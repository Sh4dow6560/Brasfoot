package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ArchiveService.MemberInfo;
import com.brasfoot.reconstruction.ProjectContext.AutomaticSemanticNames;
import com.brasfoot.reconstruction.ProjectContext.FieldSemanticName;
import com.brasfoot.reconstruction.ProjectContext.MethodSemanticName;
import com.brasfoot.reconstruction.ProjectContext.SemanticNames;
import com.brasfoot.reconstruction.ProjectContext.VersionSpec;
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
import org.objectweb.asm.tree.VarInsnNode;

final class SemanticCandidateService {
  private final ProjectContext context;
  private final ArchiveService archives = new ArchiveService();

  SemanticCandidateService(ProjectContext context) {
    this.context = context;
  }

  void build() throws IOException {
    CandidateReport report = analyze();
    context.writeJson(context.reportsDir().resolve("semantic-candidates.json"), report);
    System.out.println("Generated " + report.candidateCount()
        + " semantic accessor candidates; " + report.autoApplicableCount()
        + " are safe for automatic source migration.");
  }

  void acceptHighConfidence() throws IOException {
    CandidateReport report = analyze();
    List<Candidate> accepted = report.candidates().stream()
        .filter(Candidate::autoApplicable)
        .sorted(Comparator.comparing(Candidate::key))
        .toList();
    context.writeJson(context.reportsDir().resolve("semantic-candidates.json"), report);
    if (accepted.isEmpty()) {
      context.writeJson(context.reportsDir().resolve("semantic-candidate-application.json"),
          new ApplicationReport(0, List.of()));
      System.out.println("No new high-confidence semantic candidates to accept.");
      return;
    }

    Path output = context.projectDir().resolve("config/semantic-auto-names.json");
    AutomaticSemanticNames existing = readAutomaticNames(output);
    Map<String, MethodSemanticName> methods = new TreeMap<>();
    if (existing.methods() != null) {
      for (MethodSemanticName method : existing.methods()) {
        methods.put(methodKey(method.owner(), method.name(), method.descriptor()), method);
      }
    }
    List<MethodSemanticName> added = new ArrayList<>();
    for (Candidate candidate : accepted) {
      MethodSemanticName method = new MethodSemanticName(
          candidate.owner(), candidate.methodName(), candidate.descriptor(),
          candidate.proposedName());
      String key = methodKey(method.owner(), method.name(), method.descriptor());
      MethodSemanticName previous = methods.putIfAbsent(key, method);
      if (previous != null && !previous.named().equals(method.named())) {
        throw new IllegalStateException("Conflicting automatic semantic candidate for " + key);
      }
      if (previous == null) {
        added.add(method);
      }
    }
    List<FieldSemanticName> fields = existing.fields() == null
        ? List.of() : existing.fields().stream()
            .sorted(Comparator.comparing(this::fieldKey)).toList();
    context.writeJson(output, new AutomaticSemanticNames(
        1, fields, List.copyOf(methods.values())));
    context.writeJson(context.reportsDir().resolve("semantic-candidate-application.json"),
        new ApplicationReport(added.size(), added));
    System.out.println("Accepted " + added.size()
        + " high-confidence semantic candidates into " + output + ".");
  }

  private CandidateReport analyze() throws IOException {
    ArchiveData target = archives.analyze(context.input("22-23"));
    SemanticNames semantic = context.semanticNames();
    Map<String, byte[]> entries = ZipSupport.readEntries(context.input("22-23"));
    Map<String, String> namedClasses = readNamedClasses();
    Map<String, FieldSemanticName> semanticFields = new HashMap<>();
    Map<String, MethodSemanticName> semanticMethods = new HashMap<>();
    for (FieldSemanticName field : semantic.fields()) {
      semanticFields.put(fieldKey(field.owner(), field.name(), field.descriptor()), field);
    }
    for (MethodSemanticName method : semantic.methods()) {
      semanticMethods.put(methodKey(method.owner(), method.name(), method.descriptor()), method);
    }

    Map<String, Integer> methodNameCounts = new HashMap<>();
    Map<String, Integer> zeroArgumentNameCounts = new HashMap<>();
    for (ClassInfo classInfo : target.classes().values()) {
      for (MemberInfo member : classInfo.members()) {
        if (!"method".equals(member.kind()) || member.name().startsWith("<")) {
          continue;
        }
        methodNameCounts.merge(member.name(), 1, Integer::sum);
        if (Type.getArgumentTypes(member.descriptor()).length == 0) {
          zeroArgumentNameCounts.merge(member.name(), 1, Integer::sum);
        }
      }
    }

    Map<String, ArchiveData> versions = new LinkedHashMap<>();
    for (VersionSpec version : context.inputLock().versions()) {
      versions.put(version.id(), archives.analyze(context.input(version.id())));
    }

    int methodsScanned = 0;
    List<Candidate> candidates = new ArrayList<>();
    for (Map.Entry<String, byte[]> entry : entries.entrySet()) {
      if (!entry.getKey().endsWith(".class")) {
        continue;
      }
      ClassNode owner = new ClassNode(Opcodes.ASM9);
      new ClassReader(entry.getValue()).accept(owner, 0);
      ClassInfo ownerInfo = target.classes().get(owner.name);
      if (ownerInfo == null) {
        continue;
      }
      for (MethodNode method : owner.methods) {
        if (method.name.startsWith("<")) {
          continue;
        }
        methodsScanned++;
        if ((method.access & (Opcodes.ACC_ABSTRACT | Opcodes.ACC_NATIVE
            | Opcodes.ACC_SYNTHETIC | Opcodes.ACC_BRIDGE)) != 0
            || semanticMethods.containsKey(methodKey(owner.name, method.name, method.desc))) {
          continue;
        }
        Accessor accessor = detectAccessor(owner.name, method);
        if (accessor == null) {
          continue;
        }
        FieldSemanticName field = semanticFields.get(fieldKey(
            accessor.fieldOwner(), accessor.fieldName(), accessor.fieldDescriptor()));
        if (field == null) {
          continue;
        }
        String proposed = accessorName(accessor.kind(), field.named(), field.descriptor());
        if (proposed.equals(method.name) || !JavaIdentifiers.isLegal(proposed)) {
          continue;
        }

        List<String> blockers = new ArrayList<>();
        if (hasOutputCollision(owner, method, proposed, semanticMethods)) {
          blockers.add("owner-method-collision");
        }
        long ownerMethodsWithName = ownerInfo.members().stream()
            .filter(member -> "method".equals(member.kind()))
            .filter(member -> member.name().equals(method.name))
            .count();
        boolean migrationAddressable = (method.access & Opcodes.ACC_STATIC) != 0
            || (method.access & Opcodes.ACC_PRIVATE) != 0
            || methodNameCounts.getOrDefault(method.name, 0) == 1
            || (Type.getArgumentTypes(method.desc).length == 0
                && zeroArgumentNameCounts.getOrDefault(method.name, 0) == 1);
        String migrationStrategy = migrationAddressable && ownerMethodsWithName == 1
            ? "textual" : "symbol-resolved";
        String namedClass = namedClasses.get(owner.name);
        if (namedClass == null || !Files.isRegularFile(context.projectDir().resolve(
            "src/recovered/java/" + namedClass + ".java"))) {
          blockers.add("source-not-promoted");
        }

        Evidence evidence = evidence(method);
        candidates.add(new Candidate(
            owner.name,
            namedClass,
            method.name,
            method.desc,
            accessor.kind(),
            proposed,
            migrationStrategy,
            accessor.fieldOwner(),
            accessor.fieldName(),
            field.named(),
            blockers.isEmpty(),
            List.copyOf(blockers),
            evidence.fieldAccesses(),
            evidence.methodCalls(),
            evidence.typeReferences(),
            evidence.strings(),
            presentInVersions(versions, owner.name, method.name, method.desc)));
      }
    }
    candidates.sort(Comparator.comparing(Candidate::key));
    int autoApplicable = (int) candidates.stream().filter(Candidate::autoApplicable).count();
    return new CandidateReport(
        1, target.classes().size(), methodsScanned, semanticFields.size(),
        semanticMethods.size(), candidates.size(), autoApplicable, List.copyOf(candidates));
  }

  static Accessor detectAccessor(String owner, MethodNode method) {
    List<AbstractInsnNode> instructions = new ArrayList<>();
    for (AbstractInsnNode instruction = method.instructions.getFirst();
        instruction != null; instruction = instruction.getNext()) {
      if (instruction.getOpcode() >= 0) {
        instructions.add(instruction);
      }
    }
    Type methodType = Type.getMethodType(method.desc);
    boolean isStatic = (method.access & Opcodes.ACC_STATIC) != 0;

    if (methodType.getArgumentTypes().length == 0) {
      FieldInsnNode field = null;
      if (!isStatic && instructions.size() == 3
          && isVariable(instructions.get(0), Opcodes.ALOAD, 0)
          && instructions.get(1) instanceof FieldInsnNode candidate
          && candidate.getOpcode() == Opcodes.GETFIELD
          && candidate.owner.equals(owner)) {
        field = candidate;
      } else if (isStatic && instructions.size() == 2
          && instructions.get(0) instanceof FieldInsnNode candidate
          && candidate.getOpcode() == Opcodes.GETSTATIC) {
        field = candidate;
      }
      if (field != null
          && methodType.getReturnType().equals(Type.getType(field.desc))
          && instructions.get(instructions.size() - 1).getOpcode()
              == Type.getType(field.desc).getOpcode(Opcodes.IRETURN)) {
        return new Accessor("getter", field.owner, field.name, field.desc);
      }
    }

    Type[] arguments = methodType.getArgumentTypes();
    if (arguments.length == 1 && methodType.getReturnType().equals(Type.VOID_TYPE)) {
      FieldInsnNode field = null;
      int valueIndex = isStatic ? 0 : 1;
      if (!isStatic && instructions.size() == 4
          && isVariable(instructions.get(0), Opcodes.ALOAD, 0)
          && instructions.get(1) instanceof VarInsnNode value
          && value.var == valueIndex
          && value.getOpcode() == arguments[0].getOpcode(Opcodes.ILOAD)
          && instructions.get(2) instanceof FieldInsnNode candidate
          && candidate.getOpcode() == Opcodes.PUTFIELD
          && candidate.owner.equals(owner)) {
        field = candidate;
      } else if (isStatic && instructions.size() == 3
          && instructions.get(0) instanceof VarInsnNode value
          && value.var == valueIndex
          && value.getOpcode() == arguments[0].getOpcode(Opcodes.ILOAD)
          && instructions.get(1) instanceof FieldInsnNode candidate
          && candidate.getOpcode() == Opcodes.PUTSTATIC) {
        field = candidate;
      }
      if (field != null && arguments[0].equals(Type.getType(field.desc))
          && instructions.get(instructions.size() - 1).getOpcode() == Opcodes.RETURN) {
        return new Accessor("setter", field.owner, field.name, field.desc);
      }
    }
    return null;
  }

  static String accessorName(String kind, String fieldName, String fieldDescriptor) {
    String prefix = "setter".equals(kind)
        ? "set" : "Z".equals(fieldDescriptor) ? "is" : "get";
    return prefix + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
  }

  private static boolean isVariable(AbstractInsnNode instruction, int opcode, int variable) {
    return instruction instanceof VarInsnNode candidate
        && candidate.getOpcode() == opcode && candidate.var == variable;
  }

  private boolean hasOutputCollision(
      ClassNode owner, MethodNode target, String proposed,
      Map<String, MethodSemanticName> semanticMethods) {
    String parameters = parameterDescriptor(target.desc);
    for (MethodNode method : owner.methods) {
      if (method == target || method.name.startsWith("<")
          || !parameterDescriptor(method.desc).equals(parameters)) {
        continue;
      }
      MethodSemanticName mapped = semanticMethods.get(
          methodKey(owner.name, method.name, method.desc));
      String output = mapped == null
          ? JavaIdentifiers.isLegal(method.name) ? method.name
              : JavaIdentifiers.legalMemberName("method", method.name)
          : mapped.named();
      if (proposed.equals(output)) {
        return true;
      }
    }
    return false;
  }

  private Evidence evidence(MethodNode method) {
    Set<String> fields = new TreeSet<>();
    Set<String> calls = new TreeSet<>();
    Set<String> types = new TreeSet<>();
    Set<String> strings = new LinkedHashSet<>();
    for (AbstractInsnNode instruction = method.instructions.getFirst();
        instruction != null; instruction = instruction.getNext()) {
      if (instruction instanceof FieldInsnNode field) {
        fields.add(field.owner + "." + field.name + ":" + field.desc);
      } else if (instruction instanceof MethodInsnNode call) {
        calls.add(call.owner + "." + call.name + call.desc);
      } else if (instruction instanceof TypeInsnNode type) {
        types.add(type.desc);
      } else if (instruction instanceof LdcInsnNode constant
          && constant.cst instanceof String value && strings.size() < 10) {
        strings.add(compact(value));
      }
    }
    return new Evidence(
        List.copyOf(fields), List.copyOf(calls), List.copyOf(types), List.copyOf(strings));
  }

  private String compact(String value) {
    String compact = value.replace('\r', ' ').replace('\n', ' ').trim();
    return compact.length() <= 120 ? compact : compact.substring(0, 120);
  }

  private List<String> presentInVersions(
      Map<String, ArchiveData> versions, String owner, String name, String descriptor) {
    List<String> present = new ArrayList<>();
    for (Map.Entry<String, ArchiveData> version : versions.entrySet()) {
      ClassInfo classInfo = version.getValue().classes().get(owner);
      if (classInfo != null && classInfo.members().stream()
          .anyMatch(member -> "method".equals(member.kind())
              && member.name().equals(name) && member.descriptor().equals(descriptor))) {
        present.add(version.getKey());
      }
    }
    return List.copyOf(present);
  }

  private Map<String, String> readNamedClasses() throws IOException {
    Map<String, String> classes = new HashMap<>();
    for (String line : Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8)) {
      if (line.startsWith("c\t")) {
        String[] values = line.split("\t", -1);
        classes.put(values[1], values[3]);
      }
    }
    return classes;
  }

  private AutomaticSemanticNames readAutomaticNames(Path path) throws IOException {
    if (!Files.isRegularFile(path)) {
      return new AutomaticSemanticNames(1, List.of(), List.of());
    }
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      AutomaticSemanticNames value = ProjectContext.JSON.fromJson(
          reader, AutomaticSemanticNames.class);
      return value == null ? new AutomaticSemanticNames(1, List.of(), List.of()) : value;
    }
  }

  private String parameterDescriptor(String descriptor) {
    return descriptor.substring(0, descriptor.indexOf(')') + 1);
  }

  private String fieldKey(FieldSemanticName field) {
    return fieldKey(field.owner(), field.name(), field.descriptor());
  }

  private String fieldKey(String owner, String name, String descriptor) {
    return owner + ":" + name + ":" + descriptor;
  }

  private String methodKey(String owner, String name, String descriptor) {
    return owner + ":" + name + ":" + descriptor;
  }

  record Accessor(String kind, String fieldOwner, String fieldName, String fieldDescriptor) {
  }

  record Evidence(
      List<String> fieldAccesses,
      List<String> methodCalls,
      List<String> typeReferences,
      List<String> strings) {
  }

  record Candidate(
      String owner,
      String ownerNamed,
      String methodName,
      String descriptor,
      String kind,
      String proposedName,
      String migrationStrategy,
      String backingFieldOwner,
      String backingFieldName,
      String backingFieldSemanticName,
      boolean autoApplicable,
      List<String> blockers,
      List<String> fieldAccesses,
      List<String> methodCalls,
      List<String> typeReferences,
      List<String> strings,
      List<String> presentInVersions) {
    String key() {
      return owner + ":" + methodName + ":" + descriptor;
    }
  }

  record CandidateReport(
      int schemaVersion,
      int classesScanned,
      int methodsScanned,
      int semanticFieldsAvailable,
      int semanticMethodsAlreadyMapped,
      int candidateCount,
      int autoApplicableCount,
      List<Candidate> candidates) {
  }

  record ApplicationReport(int addedCount, List<MethodSemanticName> methods) {
  }
}
