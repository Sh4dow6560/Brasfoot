package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ArchiveService.MemberInfo;
import com.brasfoot.reconstruction.ProjectContext.FieldSemanticName;
import com.brasfoot.reconstruction.ProjectContext.MethodSemanticName;
import com.brasfoot.reconstruction.ProjectContext.SemanticNames;
import com.brasfoot.reconstruction.ReferenceVariantAnalysisService.AddedClass;
import com.brasfoot.reconstruction.ReferenceVariantAnalysisService.AnalysisReport;
import com.brasfoot.reconstruction.ReferenceVariantAnalysisService.ClassDelta;
import com.brasfoot.reconstruction.ReferenceVariantAnalysisService.VariantReport;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

final class RecoveryQueueService {
  private static final Map<String, Integer> MODULE_PRIORITY = Map.ofEntries(
      Map.entry("game", 35),
      Map.entry("competition", 32),
      Map.entry("model", 30),
      Map.entry("transfer", 30),
      Map.entry("stadium", 28),
      Map.entry("finance", 26),
      Map.entry("manager", 25),
      Map.entry("match", 24),
      Map.entry("save", 22),
      Map.entry("config", 18),
      Map.entry("ui", 15));

  private final ProjectContext context;
  private final ArchiveService archives = new ArchiveService();

  RecoveryQueueService(ProjectContext context) {
    this.context = context;
  }

  void build() throws IOException {
    QueueReport report = analyze();
    context.writeJson(context.reportsDir().resolve("recovery-queue.json"), report);
    writeMarkdown(report, context.modkitRoot().resolve("docs/RECOVERY_QUEUE.md"));
    System.out.println("Recovery queue ranked " + report.classCandidates().size()
        + " unnamed classes, " + report.memberCandidates().size()
        + " semantic classes with member gaps and "
        + report.runtimeCandidates().size() + " runtime-verification candidates.");
  }

  QueueReport analyze() throws IOException {
    ArchiveData target = archives.analyze(context.input("22-23"));
    ArchiveData version2021 = archives.analyze(context.input("2021"));
    Map<String, byte[]> entries = ZipSupport.readEntries(context.input("22-23"));
    SemanticNames semantic = context.semanticNames();
    Map<String, RecoveryEntry> recovery = readRecoveryIndex();
    Set<String> serializable = readSerializableClasses();
    AnalysisReport variants = new ReferenceVariantAnalysisService(context).analyze();
    VariantEvidence variantEvidence = variantEvidence(variants);

    Map<String, String> directModules = new HashMap<>();
    for (Map.Entry<String, String> item : semantic.classes().entrySet()) {
      directModules.put(item.getKey(), moduleFromNamed(item.getValue()));
    }
    Set<String> semanticMembers = semanticMemberKeys(semantic);
    Map<String, Signals> signals = new TreeMap<>();
    for (String className : target.classes().keySet()) {
      signals.put(className, signals(
          entries.get(className + ".class"), target.classes().keySet()));
    }
    Map<String, Set<String>> incoming = incomingReferences(signals);

    List<ClassCandidate> classCandidates = new ArrayList<>();
    List<MemberCandidate> memberCandidates = new ArrayList<>();
    List<RuntimeCandidate> runtimeCandidates = new ArrayList<>();
    for (ClassInfo classInfo : target.classes().values()) {
      Signals classSignals = signals.get(classInfo.name());
      Set<String> incomingClasses = incoming.getOrDefault(classInfo.name(), Set.of());
      String module = directModules.get(classInfo.name());
      boolean inferred = false;
      if (module == null) {
        module = inferModule(classSignals.references(), incomingClasses, directModules);
        inferred = !module.startsWith("unclassified");
      }
      int semanticMemberCount = countSemanticMembers(classInfo, semanticMembers);
      int mappableMembers = countMappableMembers(classInfo);
      int unmappedMembers = mappableMembers - semanticMemberCount;
      int incomingSemantic = countPresent(incomingClasses, semantic.classes().keySet());
      int outgoingSemantic = countPresent(
          classSignals.references(), semantic.classes().keySet());
      RecoveryEntry recoveryEntry = recovery.get(classInfo.name());
      String status = recoveryEntry == null ? "binary" : recoveryEntry.status();
      boolean stable2021 = version2021.classes().containsKey(classInfo.name())
          && version2021.classes().get(classInfo.name()).sha256().equals(classInfo.sha256());
      List<String> evidence = variantEvidence.byClass().getOrDefault(
          classInfo.name(), List.of());

      if (!semantic.classes().containsKey(classInfo.name())) {
        List<String> reasons = new ArrayList<>();
        int score = scoreClass(
            module, status, incomingClasses.size(), classSignals.references().size(),
            incomingSemantic, outgoingSemantic, classSignals.strings().size(), stable2021,
            serializable.contains(classInfo.name()), evidence, reasons);
        int effort = Math.max(10, mappableMembers + classSignals.references().size() / 2);
        double valuePerEffort = Math.round(score * 1000.0 / effort) / 10.0;
        classCandidates.add(new ClassCandidate(
            classInfo.name(),
            recoveryEntry == null ? null : recoveryEntry.intermediaryName(),
            module,
            inferred,
            score,
            effort,
            valuePerEffort,
            status,
            stable2021,
            serializable.contains(classInfo.name()),
            mappableMembers,
            incomingClasses.size(),
            classSignals.references().size(),
            incomingSemantic,
            outgoingSemantic,
            evidence,
            classSignals.strings(),
            List.copyOf(reasons)));
      } else if (unmappedMembers > 0) {
        int centrality = incomingClasses.size() + classSignals.references().size()
            + incomingSemantic * 5 + outgoingSemantic * 3;
        memberCandidates.add(new MemberCandidate(
            classInfo.name(), semantic.classes().get(classInfo.name()), module,
            mappableMembers, semanticMemberCount, unmappedMembers, centrality,
            classSignals.strings()));
      }

      if ("compile-clean".equals(status)) {
        int runtimeScore = incomingClasses.size() * 3 + incomingSemantic * 12
            + outgoingSemantic * 6 + MODULE_PRIORITY.getOrDefault(module, 0)
            + (serializable.contains(classInfo.name()) ? 20 : 0);
        runtimeCandidates.add(new RuntimeCandidate(
            classInfo.name(), semantic.classes().get(classInfo.name()), module,
            runtimeScore, serializable.contains(classInfo.name()),
            incomingClasses.size(), incomingSemantic));
      }
    }

    Comparator<ClassCandidate> classOrder = Comparator
        .comparingInt(ClassCandidate::score).reversed()
        .thenComparing(Comparator.comparingDouble(ClassCandidate::valuePerEffort).reversed())
        .thenComparing(ClassCandidate::officialName);
    classCandidates.sort(classOrder);
    memberCandidates.sort(Comparator.comparingInt(MemberCandidate::unmappedMembers).reversed()
        .thenComparing(Comparator.comparingInt(MemberCandidate::centrality).reversed())
        .thenComparing(MemberCandidate::officialName));
    runtimeCandidates.sort(Comparator.comparingInt(RuntimeCandidate::score).reversed()
        .thenComparing(RuntimeCandidate::officialName));

    List<RecoveryBatch> batches = batches(classCandidates, memberCandidates, runtimeCandidates);
    return new QueueReport(
        1,
        target.classes().size(),
        semantic.classes().size(),
        classCandidates.size(),
        List.copyOf(classCandidates),
        List.copyOf(memberCandidates),
        List.copyOf(runtimeCandidates),
        batches);
  }

  private int scoreClass(
      String module,
      String status,
      int incoming,
      int outgoing,
      int incomingSemantic,
      int outgoingSemantic,
      int stringSignals,
      boolean stable2021,
      boolean serializable,
      List<String> variantEvidence,
      List<String> reasons) {
    int score = MODULE_PRIORITY.getOrDefault(module, 5);
    if (!module.startsWith("unclassified/")) {
      reasons.add("module-frontier:" + module);
    }
    score += Math.min(incoming, 80) * 2;
    score += Math.min(outgoing, 60);
    score += Math.min(incomingSemantic, 12) * 18;
    score += Math.min(outgoingSemantic, 12) * 12;
    if (incomingSemantic > 0 || outgoingSemantic > 0) {
      reasons.add("adjacent-to-semantic-code");
    }
    score += Math.min(stringSignals, 8) * 4;
    if (stringSignals > 0) {
      reasons.add("human-readable-signals");
    }
    if ("runtime-verified".equals(status)) {
      score += 25;
      reasons.add("runtime-verified");
    } else if ("compile-clean".equals(status)) {
      score += 12;
    }
    if (stable2021) {
      score += 10;
      reasons.add("stable-since-2021");
    }
    if (serializable) {
      score += 8;
      reasons.add("save-contract");
    }
    for (String evidence : variantEvidence) {
      if (evidence.startsWith("references-added:")) {
        score += 120;
        reasons.add("new-feature-integration");
      } else if (evidence.startsWith("api-changed")) {
        score += 80;
        reasons.add("variant-api-delta");
      } else if (evidence.startsWith("behavior-changed")) {
        score += 55;
        reasons.add("variant-behavior-delta");
      }
    }
    return score;
  }

  private List<RecoveryBatch> batches(
      List<ClassCandidate> classes,
      List<MemberCandidate> members,
      List<RuntimeCandidate> runtime) {
    Set<String> selected = new LinkedHashSet<>();
    List<String> variant = classes.stream()
        .filter(value -> value.variantEvidence().stream()
            .anyMatch(item -> item.startsWith("references-added:")))
        .limit(8)
        .map(ClassCandidate::officialName)
        .toList();
    selected.addAll(variant);
    List<String> frontier = classes.stream()
        .filter(value -> !selected.contains(value.officialName()))
        .limit(12)
        .map(ClassCandidate::officialName)
        .toList();
    List<String> memberBatch = members.stream().limit(8)
        .map(MemberCandidate::officialName).toList();
    List<String> runtimeBatch = runtime.stream().limit(12)
        .map(RuntimeCandidate::officialName).toList();
    return List.of(
        new RecoveryBatch(
            "variant-integration", "Name classes that integrate externally observed features",
            variant),
        new RecoveryBatch(
            "semantic-frontier", "Expand the named dependency frontier with the highest impact",
            frontier),
        new RecoveryBatch(
            "member-frontier", "Recover members in already named core classes",
            memberBatch),
        new RecoveryBatch(
            "runtime-frontier", "Promote central compile-clean classes to runtime verification",
            runtimeBatch));
  }

  private VariantEvidence variantEvidence(AnalysisReport report) {
    Map<String, Set<String>> values = new TreeMap<>();
    for (VariantReport variant : report.variants()) {
      if (!variant.available()) {
        continue;
      }
      for (ClassDelta delta : variant.deltas()) {
        if (!"structurally-equivalent".equals(delta.classification())) {
          values.computeIfAbsent(delta.officialName(), ignored -> new TreeSet<>())
              .add(delta.classification() + ":" + variant.id());
        }
      }
      for (AddedClass addition : variant.additions()) {
        for (String referencer : addition.referencedBy()) {
          values.computeIfAbsent(referencer, ignored -> new TreeSet<>())
              .add("references-added:" + addition.name() + ":" + variant.id());
        }
      }
    }
    Map<String, List<String>> immutable = new TreeMap<>();
    values.forEach((key, value) -> immutable.put(key, List.copyOf(value)));
    return new VariantEvidence(Map.copyOf(immutable));
  }

  private Signals signals(byte[] bytes, Set<String> gameClasses) {
    if (bytes == null) {
      return new Signals(Set.of(), List.of());
    }
    ClassNode node = new ClassNode(Opcodes.ASM9);
    new ClassReader(bytes).accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
    Set<String> references = new TreeSet<>();
    Set<String> strings = new LinkedHashSet<>();
    addReference(references, node.superName, gameClasses);
    node.interfaces.forEach(value -> addReference(references, value, gameClasses));
    node.fields.forEach(field -> addDescriptorReferences(references, field.desc, gameClasses));
    for (MethodNode method : node.methods) {
      addMethodDescriptorReferences(references, method.desc, gameClasses);
      for (AbstractInsnNode instruction = method.instructions.getFirst();
          instruction != null; instruction = instruction.getNext()) {
        if (instruction instanceof FieldInsnNode field) {
          addReference(references, field.owner, gameClasses);
          addDescriptorReferences(references, field.desc, gameClasses);
        } else if (instruction instanceof MethodInsnNode call) {
          addReference(references, call.owner, gameClasses);
          addMethodDescriptorReferences(references, call.desc, gameClasses);
        } else if (instruction instanceof TypeInsnNode type) {
          addReference(references, type.desc, gameClasses);
        } else if (instruction instanceof LdcInsnNode constant
            && constant.cst instanceof String text && strings.size() < 12) {
          String compact = compact(text);
          if (!compact.isEmpty()) {
            strings.add(compact);
          }
        }
      }
    }
    references.remove(node.name);
    return new Signals(Set.copyOf(references), List.copyOf(strings));
  }

  private Map<String, Set<String>> incomingReferences(Map<String, Signals> signals) {
    Map<String, Set<String>> incoming = new TreeMap<>();
    for (Map.Entry<String, Signals> source : signals.entrySet()) {
      for (String target : source.getValue().references()) {
        incoming.computeIfAbsent(target, ignored -> new TreeSet<>()).add(source.getKey());
      }
    }
    return incoming;
  }

  private String inferModule(
      Set<String> outgoing,
      Set<String> incoming,
      Map<String, String> directModules) {
    Map<String, Integer> scores = new TreeMap<>();
    for (String reference : outgoing) {
      String module = directModules.get(reference);
      if (module != null) {
        scores.merge(module, 3, Integer::sum);
      }
    }
    for (String reference : incoming) {
      String module = directModules.get(reference);
      if (module != null) {
        scores.merge(module, 2, Integer::sum);
      }
    }
    Map.Entry<String, Integer> best = null;
    boolean tied = false;
    for (Map.Entry<String, Integer> score : scores.entrySet()) {
      if (best == null || score.getValue() > best.getValue()) {
        best = score;
        tied = false;
      } else if (score.getValue().equals(best.getValue())) {
        tied = true;
      }
    }
    return best != null && best.getValue() >= 3 && !tied
        ? best.getKey() : "unclassified";
  }

  private String moduleFromNamed(String named) {
    String prefix = "mod/recovered/";
    if (!named.startsWith(prefix)) {
      return "named-other";
    }
    String remainder = named.substring(prefix.length());
    int separator = remainder.indexOf('/');
    return separator < 0 ? "infrastructure" : remainder.substring(0, separator);
  }

  private int countMappableMembers(ClassInfo classInfo) {
    return (int) classInfo.members().stream().filter(this::isMappable).count();
  }

  private int countSemanticMembers(ClassInfo classInfo, Set<String> semanticMembers) {
    int count = 0;
    for (MemberInfo member : classInfo.members()) {
      if (isMappable(member) && semanticMembers.contains(memberKey(
          classInfo.name(), member.kind(), member.name(), member.descriptor()))) {
        count++;
      }
    }
    return count;
  }

  private boolean isMappable(MemberInfo member) {
    return !member.name().startsWith("<")
        && (member.access() & (Opcodes.ACC_SYNTHETIC | Opcodes.ACC_BRIDGE)) == 0;
  }

  private Set<String> semanticMemberKeys(SemanticNames semantic) {
    Set<String> keys = new LinkedHashSet<>();
    for (FieldSemanticName field : semantic.fields()) {
      keys.add(memberKey(field.owner(), "field", field.name(), field.descriptor()));
    }
    for (MethodSemanticName method : semantic.methods()) {
      keys.add(memberKey(method.owner(), "method", method.name(), method.descriptor()));
    }
    return Set.copyOf(keys);
  }

  private Map<String, RecoveryEntry> readRecoveryIndex() throws IOException {
    Path path = context.projectDir().resolve("recovery-index.json");
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      RecoveryIndex index = ProjectContext.JSON.fromJson(reader, RecoveryIndex.class);
      Map<String, RecoveryEntry> result = new HashMap<>();
      if (index != null && index.classes() != null) {
        for (RecoveryEntry entry : index.classes()) {
          result.put(entry.officialName(), entry);
        }
      }
      return result;
    }
  }

  private Set<String> readSerializableClasses() throws IOException {
    try (Reader reader = Files.newBufferedReader(
        context.serializationContractsFile(), StandardCharsets.UTF_8)) {
      SerializationContracts contracts = ProjectContext.JSON.fromJson(
          reader, SerializationContracts.class);
      Set<String> result = new TreeSet<>();
      if (contracts != null && contracts.classes() != null) {
        contracts.classes().forEach(value -> result.add(value.officialName()));
      }
      return Set.copyOf(result);
    }
  }

  private void addMethodDescriptorReferences(
      Set<String> result, String descriptor, Set<String> gameClasses) {
    Type method = Type.getMethodType(descriptor);
    addTypeReference(result, method.getReturnType(), gameClasses);
    for (Type argument : method.getArgumentTypes()) {
      addTypeReference(result, argument, gameClasses);
    }
  }

  private void addDescriptorReferences(
      Set<String> result, String descriptor, Set<String> gameClasses) {
    addTypeReference(result, Type.getType(descriptor), gameClasses);
  }

  private void addTypeReference(Set<String> result, Type type, Set<String> gameClasses) {
    if (type.getSort() == Type.ARRAY) {
      addTypeReference(result, type.getElementType(), gameClasses);
    } else if (type.getSort() == Type.OBJECT) {
      addReference(result, type.getInternalName(), gameClasses);
    }
  }

  private void addReference(Set<String> result, String name, Set<String> gameClasses) {
    if (name != null && gameClasses.contains(name)) {
      result.add(name);
    }
  }

  private int countPresent(Set<String> values, Set<String> expected) {
    int count = 0;
    for (String value : values) {
      if (expected.contains(value)) {
        count++;
      }
    }
    return count;
  }

  private String compact(String text) {
    String result = text.replace('\r', ' ').replace('\n', ' ').trim();
    return result.length() <= 120 ? result : result.substring(0, 120);
  }

  private String memberKey(String owner, String kind, String name, String descriptor) {
    return owner + ':' + kind + ':' + name + ':' + descriptor;
  }

  private void writeMarkdown(QueueReport report, Path output) throws IOException {
    StringBuilder markdown = new StringBuilder();
    markdown.append("# Fila De Recuperacao\n\n")
        .append("Fila deterministica orientada por dependencias, estabilidade entre versoes, ")
        .append("sinais textuais, variantes de referencia e risco de save.\n\n")
        .append("- Classes sem nome: ").append(report.unnamedClasses()).append(".\n")
        .append("- Classes semanticas: ").append(report.semanticClasses()).append(".\n\n")
        .append("## Lotes Recomendados\n\n");
    for (RecoveryBatch batch : report.batches()) {
      markdown.append("### ").append(batch.id()).append("\n\n")
          .append(batch.objective()).append(".\n\n")
          .append(batch.classes().isEmpty() ? "Nenhuma classe pendente."
              : "`" + String.join("`, `", batch.classes()) + "`")
          .append("\n\n");
    }
    markdown.append("## Fronteira Semantica\n\n")
        .append("| Classe | Modulo | Score | Valor/esforco | Entrada | Saida | Evidencia |\n")
        .append("|---|---|---:|---:|---:|---:|---|\n");
    for (ClassCandidate candidate : report.classCandidates().stream().limit(40).toList()) {
      markdown.append("|`").append(candidate.officialName()).append("`|")
          .append(candidate.module()).append('|')
          .append(candidate.score()).append('|')
          .append(candidate.valuePerEffort()).append('|')
          .append(candidate.incomingReferences()).append('|')
          .append(candidate.outgoingReferences()).append('|')
          .append(String.join(", ", candidate.variantEvidence())).append("|\n");
    }
    markdown.append("\n## Fronteira De Membros\n\n")
        .append("| Classe | Nome | Modulo | Pendentes | Centralidade |\n")
        .append("|---|---|---|---:|---:|\n");
    for (MemberCandidate candidate : report.memberCandidates().stream().limit(30).toList()) {
      markdown.append("|`").append(candidate.officialName()).append("`|`")
          .append(candidate.semanticName()).append("`|")
          .append(candidate.module()).append('|')
          .append(candidate.unmappedMembers()).append('|')
          .append(candidate.centrality()).append("|\n");
    }
    Files.createDirectories(output.getParent());
    Files.writeString(output, markdown.toString(), StandardCharsets.UTF_8);
  }

  record Signals(Set<String> references, List<String> strings) {
  }

  record VariantEvidence(Map<String, List<String>> byClass) {
  }

  record RecoveryIndex(int schemaVersion, List<RecoveryEntry> classes) {
  }

  record RecoveryEntry(
      String officialName,
      String intermediaryName,
      String namedName,
      String introducedIn,
      String status,
      String sourceSha256) {
  }

  record SerializationContracts(int schemaVersion, List<SerializationContract> classes) {
  }

  record SerializationContract(String officialName) {
  }

  record ClassCandidate(
      String officialName,
      String intermediaryName,
      String module,
      boolean moduleInferred,
      int score,
      int estimatedEffort,
      double valuePerEffort,
      String status,
      boolean stableSince2021,
      boolean serializable,
      int mappableMembers,
      int incomingReferences,
      int outgoingReferences,
      int incomingSemanticReferences,
      int outgoingSemanticReferences,
      List<String> variantEvidence,
      List<String> stringSignals,
      List<String> reasons) {
  }

  record MemberCandidate(
      String officialName,
      String semanticName,
      String module,
      int mappableMembers,
      int semanticMembers,
      int unmappedMembers,
      int centrality,
      List<String> stringSignals) {
  }

  record RuntimeCandidate(
      String officialName,
      String semanticName,
      String module,
      int score,
      boolean serializable,
      int incomingReferences,
      int incomingSemanticReferences) {
  }

  record RecoveryBatch(String id, String objective, List<String> classes) {
  }

  record QueueReport(
      int schemaVersion,
      int totalClasses,
      int semanticClasses,
      int unnamedClasses,
      List<ClassCandidate> classCandidates,
      List<MemberCandidate> memberCandidates,
      List<RuntimeCandidate> runtimeCandidates,
      List<RecoveryBatch> batches) {
  }
}
