package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ArchiveService.MemberInfo;
import com.brasfoot.reconstruction.ProjectContext.FieldSemanticName;
import com.brasfoot.reconstruction.ProjectContext.MethodSemanticName;
import com.brasfoot.reconstruction.ProjectContext.SemanticNames;
import com.brasfoot.reconstruction.ProjectContext.VersionSpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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

final class SemanticCoverageService {
  private final ProjectContext context;
  private final ArchiveService archives = new ArchiveService();

  SemanticCoverageService(ProjectContext context) {
    this.context = context;
  }

  void build() throws IOException {
    ArchiveData target = archives.analyze(context.input("22-23"));
    ArchiveData version2021 = archives.analyze(context.input("2021"));
    SemanticNames semantic = context.semanticNames();
    Map<String, byte[]> entries = ZipSupport.readEntries(context.input("22-23"));
    Map<String, String> directModules = new HashMap<>();
    for (Map.Entry<String, String> named : semantic.classes().entrySet()) {
      directModules.put(named.getKey(), moduleFromNamedClass(named.getValue()));
    }
    Set<String> semanticFields = new LinkedHashSet<>();
    Set<String> semanticMethods = new LinkedHashSet<>();
    for (FieldSemanticName field : semantic.fields()) {
      semanticFields.add(memberKey(field.owner(), "field", field.name(), field.descriptor()));
    }
    for (MethodSemanticName method : semantic.methods()) {
      semanticMethods.add(memberKey(
          method.owner(), "method", method.name(), method.descriptor()));
    }

    Map<String, String> introduced = introducedVersions();
    Map<String, ModuleAccumulator> moduleTotals = new TreeMap<>();
    List<ClassGap> gaps = new ArrayList<>();
    int mappableMembers = 0;
    int semanticMemberCount = 0;
    for (ClassInfo classInfo : target.classes().values()) {
      byte[] bytes = entries.get(classInfo.name() + ".class");
      ClassSignals signals = bytes == null
          ? new ClassSignals(Map.of(), List.of()) : signals(bytes, directModules);
      String directModule = directModules.get(classInfo.name());
      String module = directModule == null
          ? inferModule(classInfo.name(), signals.moduleScores()) : directModule;
      boolean inferred = directModule == null && !module.startsWith("unclassified/");
      int classMembers = 0;
      int classSemanticMembers = 0;
      for (MemberInfo member : classInfo.members()) {
        if (!isMappable(member)) {
          continue;
        }
        classMembers++;
        String key = memberKey(
            classInfo.name(), member.kind(), member.name(), member.descriptor());
        if (semanticFields.contains(key) || semanticMethods.contains(key)) {
          classSemanticMembers++;
        }
      }
      mappableMembers += classMembers;
      semanticMemberCount += classSemanticMembers;
      boolean semanticClass = semantic.classes().containsKey(classInfo.name());
      ModuleAccumulator totals = moduleTotals.computeIfAbsent(
          module, ignored -> new ModuleAccumulator(module));
      totals.add(semanticClass, classMembers, classSemanticMembers);
      ClassInfo previous = version2021.classes().get(classInfo.name());
      gaps.add(new ClassGap(
          classInfo.name(),
          semantic.classes().get(classInfo.name()),
          module,
          inferred,
          introduced.getOrDefault(classInfo.name(), "unknown"),
          previous != null && previous.sha256().equals(classInfo.sha256()),
          classMembers,
          classSemanticMembers,
          classMembers - classSemanticMembers,
          signals.moduleScores(),
          signals.strings()));
    }
    gaps.sort(Comparator.comparingInt(ClassGap::unmappedMembers).reversed()
        .thenComparing(Comparator.comparingInt(ClassGap::mappableMembers).reversed())
        .thenComparing(ClassGap::officialName));

    List<ModuleCoverage> modules = moduleTotals.values().stream()
        .map(ModuleAccumulator::snapshot)
        .sorted(Comparator.comparing(ModuleCoverage::module))
        .toList();
    int semanticClasses = semantic.classes().size();
    int mappingEntries = countNamedMemberMappings();
    CoverageReport report = new CoverageReport(
        1,
        target.classes().size(),
        semanticClasses,
        percentage(semanticClasses, target.classes().size()),
        mappableMembers,
        semanticMemberCount,
        mappingEntries,
        percentage(semanticMemberCount, mappableMembers),
        modules,
        List.copyOf(gaps.subList(0, Math.min(100, gaps.size()))));
    context.writeJson(context.reportsDir().resolve("semantic-coverage.json"), report);
    writeMarkdown(report, context.modkitRoot().resolve("docs/SEMANTIC_COVERAGE.md"));
    System.out.println("Semantic coverage: " + semanticClasses + "/"
        + target.classes().size() + " classes and " + semanticMemberCount + "/"
        + mappableMembers + " explicit members; " + mappingEntries
        + " member mappings are emitted in Tiny v2.");
  }

  private ClassSignals signals(byte[] bytes, Map<String, String> directModules) {
    ClassNode node = new ClassNode(Opcodes.ASM9);
    new ClassReader(bytes).accept(node, 0);
    Map<String, Integer> scores = new TreeMap<>();
    Set<String> strings = new LinkedHashSet<>();
    addReference(scores, directModules, node.superName, 1);
    for (String interfaceName : node.interfaces) {
      addReference(scores, directModules, interfaceName, 1);
    }
    node.fields.forEach(field -> addDescriptor(scores, directModules, field.desc, 1));
    for (MethodNode method : node.methods) {
      addMethodDescriptor(scores, directModules, method.desc, 1);
      for (AbstractInsnNode instruction = method.instructions.getFirst();
          instruction != null; instruction = instruction.getNext()) {
        if (instruction instanceof FieldInsnNode field) {
          addReference(scores, directModules, field.owner, 3);
          addDescriptor(scores, directModules, field.desc, 1);
        } else if (instruction instanceof MethodInsnNode call) {
          addReference(scores, directModules, call.owner, 3);
          addMethodDescriptor(scores, directModules, call.desc, 1);
        } else if (instruction instanceof TypeInsnNode type) {
          addReference(scores, directModules, type.desc, 1);
        } else if (instruction instanceof LdcInsnNode constant
            && constant.cst instanceof String value && strings.size() < 8) {
          String compact = compact(value);
          if (!compact.isEmpty()) {
            strings.add(compact);
          }
        }
      }
    }
    return new ClassSignals(
        Collections.unmodifiableMap(new LinkedHashMap<>(scores)), List.copyOf(strings));
  }

  private void addMethodDescriptor(
      Map<String, Integer> scores, Map<String, String> modules,
      String descriptor, int weight) {
    Type method = Type.getMethodType(descriptor);
    addType(scores, modules, method.getReturnType(), weight);
    for (Type argument : method.getArgumentTypes()) {
      addType(scores, modules, argument, weight);
    }
  }

  private void addDescriptor(
      Map<String, Integer> scores, Map<String, String> modules,
      String descriptor, int weight) {
    addType(scores, modules, Type.getType(descriptor), weight);
  }

  private void addType(
      Map<String, Integer> scores, Map<String, String> modules, Type type, int weight) {
    if (type.getSort() == Type.ARRAY) {
      addType(scores, modules, type.getElementType(), weight);
    } else if (type.getSort() == Type.OBJECT) {
      addReference(scores, modules, type.getInternalName(), weight);
    }
  }

  private void addReference(
      Map<String, Integer> scores, Map<String, String> modules,
      String className, int weight) {
    String module = modules.get(className);
    if (module != null) {
      scores.merge(module, weight, Integer::sum);
    }
  }

  private String inferModule(String className, Map<String, Integer> scores) {
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
    if (best != null && best.getValue() >= 2 && !tied) {
      return best.getKey();
    }
    int separator = className.indexOf('/');
    String packageName = separator < 0 ? "root" : className.substring(0, separator);
    return "unclassified/" + packageName;
  }

  private String moduleFromNamedClass(String named) {
    String prefix = "mod/recovered/";
    if (!named.startsWith(prefix)) {
      return "named-other";
    }
    String remainder = named.substring(prefix.length());
    int separator = remainder.indexOf('/');
    return separator < 0 ? "infrastructure" : remainder.substring(0, separator);
  }

  private boolean isMappable(MemberInfo member) {
    return !member.name().startsWith("<")
        && (member.access() & (Opcodes.ACC_SYNTHETIC | Opcodes.ACC_BRIDGE)) == 0;
  }

  private Map<String, String> introducedVersions() throws IOException {
    Map<String, String> result = new HashMap<>();
    for (VersionSpec version : context.inputLock().versions()) {
      for (String className : archives.analyze(context.input(version.id())).classes().keySet()) {
        result.putIfAbsent(className, version.id());
      }
    }
    return result;
  }

  private int countNamedMemberMappings() throws IOException {
    int count = 0;
    for (String line : Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8)) {
      if (line.startsWith("\tf\t") || line.startsWith("\tm\t")) {
        String[] values = line.split("\t", -1);
        if (values.length >= 6 && !values[3].equals(values[5])) {
          count++;
        }
      }
    }
    return count;
  }

  private String compact(String value) {
    String compact = value.replace('\r', ' ').replace('\n', ' ').trim();
    return compact.length() <= 100 ? compact : compact.substring(0, 100);
  }

  private double percentage(int value, int total) {
    return total == 0 ? 0.0 : Math.round(value * 1000.0 / total) / 10.0;
  }

  private String memberKey(String owner, String kind, String name, String descriptor) {
    return owner + ":" + kind + ":" + name + ":" + descriptor;
  }

  private void writeMarkdown(CoverageReport report, Path output) throws IOException {
    StringBuilder markdown = new StringBuilder();
    markdown.append("# Cobertura Semantica\n\n");
    markdown.append("Relatorio deterministico gerado a partir do bytecode 22/23. ")
        .append("Classes sem nome direto sao agrupadas pelo modulo semantico mais ")
        .append("referenciado; empates permanecem nao classificados.\n\n");
    markdown.append("- Classes: ").append(report.semanticClasses()).append("/")
        .append(report.totalClasses()).append(" (")
        .append(report.classCoveragePercent()).append("%).\n");
    markdown.append("- Membros semanticos explicitos: ")
        .append(report.explicitSemanticMembers()).append("/")
        .append(report.mappableMembers()).append(" (")
        .append(report.memberCoveragePercent()).append("%).\n");
    markdown.append("- Entradas de membros emitidas no Tiny v2: ")
        .append(report.tinyMemberMappings()).append(".\n\n");
    markdown.append("| Modulo | Classes | Nomeadas | Cobertura | Membros | Semanticos | Cobertura |\n");
    markdown.append("|---|---:|---:|---:|---:|---:|---:|\n");
    for (ModuleCoverage module : report.modules()) {
      markdown.append("|").append(module.module()).append("|")
          .append(module.classes()).append("|")
          .append(module.semanticClasses()).append("|")
          .append(module.classCoveragePercent()).append("%|")
          .append(module.mappableMembers()).append("|")
          .append(module.semanticMembers()).append("|")
          .append(module.memberCoveragePercent()).append("%|\n");
    }
    markdown.append("\n## Maiores Lacunas\n\n");
    markdown.append("| Classe oficial | Modulo | Introduzida | Membros pendentes | Total |\n");
    markdown.append("|---|---|---|---:|---:|\n");
    for (ClassGap gap : report.largestGaps().stream().limit(30).toList()) {
      markdown.append("|`").append(gap.officialName()).append("`|")
          .append(gap.module()).append("|")
          .append(gap.introducedIn()).append("|")
          .append(gap.unmappedMembers()).append("|")
          .append(gap.mappableMembers()).append("|\n");
    }
    Files.createDirectories(output.getParent());
    Files.writeString(output, markdown.toString(), StandardCharsets.UTF_8);
  }

  record ClassSignals(Map<String, Integer> moduleScores, List<String> strings) {
  }

  record ClassGap(
      String officialName,
      String semanticName,
      String module,
      boolean moduleInferred,
      String introducedIn,
      boolean byteIdenticalTo2021,
      int mappableMembers,
      int semanticMembers,
      int unmappedMembers,
      Map<String, Integer> referencedSemanticModules,
      List<String> stringSignals) {
  }

  record ModuleCoverage(
      String module,
      int classes,
      int semanticClasses,
      double classCoveragePercent,
      int mappableMembers,
      int semanticMembers,
      double memberCoveragePercent) {
  }

  record CoverageReport(
      int schemaVersion,
      int totalClasses,
      int semanticClasses,
      double classCoveragePercent,
      int mappableMembers,
      int explicitSemanticMembers,
      int tinyMemberMappings,
      double memberCoveragePercent,
      List<ModuleCoverage> modules,
      List<ClassGap> largestGaps) {
  }

  private final class ModuleAccumulator {
    private final String module;
    private int classes;
    private int semanticClasses;
    private int members;
    private int semanticMembers;

    private ModuleAccumulator(String module) {
      this.module = module;
    }

    private void add(boolean semanticClass, int classMembers, int classSemanticMembers) {
      classes++;
      if (semanticClass) {
        semanticClasses++;
      }
      members += classMembers;
      semanticMembers += classSemanticMembers;
    }

    private ModuleCoverage snapshot() {
      return new ModuleCoverage(
          module,
          classes,
          semanticClasses,
          percentage(semanticClasses, classes),
          members,
          semanticMembers,
          percentage(semanticMembers, members));
    }
  }
}
