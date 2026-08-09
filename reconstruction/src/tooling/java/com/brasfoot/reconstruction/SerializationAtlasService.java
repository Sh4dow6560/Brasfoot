package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ArchiveService.MemberInfo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

final class SerializationAtlasService {
  private static final int FIELD_ACCESS_MASK = Opcodes.ACC_PUBLIC
      | Opcodes.ACC_PRIVATE
      | Opcodes.ACC_PROTECTED
      | Opcodes.ACC_STATIC
      | Opcodes.ACC_FINAL
      | Opcodes.ACC_VOLATILE
      | Opcodes.ACC_TRANSIENT;
  private static final int METHOD_ACCESS_MASK = Opcodes.ACC_PUBLIC
      | Opcodes.ACC_PRIVATE
      | Opcodes.ACC_PROTECTED
      | Opcodes.ACC_STATIC
      | Opcodes.ACC_FINAL
      | Opcodes.ACC_SYNCHRONIZED
      | Opcodes.ACC_BRIDGE
      | Opcodes.ACC_VARARGS
      | Opcodes.ACC_NATIVE
      | Opcodes.ACC_ABSTRACT
      | Opcodes.ACC_STRICT;

  private final ProjectContext context;
  private final ArchiveService archives = new ArchiveService();

  SerializationAtlasService(ProjectContext context) {
    this.context = context;
  }

  void build() throws IOException {
    ArchiveData current = archives.analyze(context.normalizedGameJar());
    ArchiveData previous = archives.analyze(context.input("2021"));
    Map<String, String> named = readNamedMappings();
    Map<String, Boolean> serializable = new HashMap<>();
    List<SerializableClass> models = new ArrayList<>();

    for (ClassInfo info : current.classes().values()) {
      if (!isModelSerializable(info.name(), current.classes(), serializable, new HashSet<>())) {
        continue;
      }
      List<FieldContract> fields = persistentFields(info);
      Set<String> dependencies = new TreeSet<>();
      for (FieldContract field : fields) {
        collectDescriptorTypes(field.descriptor(), dependencies);
      }
      dependencies.retainAll(current.classes().keySet());
      dependencies.remove(info.name());
      String uid = explicitSerialVersionUid(info);
      String role = detectRole(info);
      ClassInfo old = previous.classes().get(info.name());
      boolean unchangedFrom2021 = old != null && old.sha256().equals(info.sha256());
      int risk = fields.size() + dependencies.size() * 3 + (uid == null ? 10 : 0);
      models.add(new SerializableClass(
          info.name(),
          named.getOrDefault(info.name(), info.name()),
          role,
          directSerializable(info),
          info.superName(),
          List.copyOf(info.interfaces()),
          uid,
          unchangedFrom2021,
          risk,
          fields,
          List.copyOf(dependencies)));
    }

    models.sort(Comparator.comparing(SerializableClass::officialName));
    SerializationContracts contracts = new SerializationContracts(1, models);
    context.writeJson(context.serializationContractsFile(), contracts);
    context.writeJson(context.reportsDir().resolve("serialization-atlas.json"), contracts);
    writeTargets(models);
    writeGraph(models);
    writeMarkdown(models);

    long direct = models.stream().filter(SerializableClass::direct).count();
    long stable = models.stream().filter(SerializableClass::unchangedFrom2021).count();
    System.out.println("Serialization atlas generated: " + models.size()
        + " model classes (" + direct + " direct), " + stable + " unchanged from 2021.");
  }

  void verifyRecoveredContracts(Path recoveredOfficialJar) throws IOException {
    ArchiveData original = archives.analyze(context.normalizedGameJar());
    ArchiveData recovered = archives.analyze(recoveredOfficialJar);
    for (ClassInfo replacement : recovered.classes().values()) {
      ClassInfo expected = original.classes().get(replacement.name());
      if (expected == null) {
        if (!replacement.name().startsWith("mod/extension/")) {
          throw new IllegalStateException("Recovered class does not exist in original: "
              + replacement.name());
        }
        continue;
      }
      if (!Objects.equals(expected.superName(), replacement.superName())) {
        throw new IllegalStateException("Recovered superclass changed: " + replacement.name());
      }
      if (!expected.interfaces().equals(replacement.interfaces())) {
        throw new IllegalStateException("Recovered interfaces changed: " + replacement.name());
      }
      if (!binaryMembers(expected, "field").equals(binaryMembers(replacement, "field"))) {
        throw new IllegalStateException("Recovered fields changed: " + replacement.name());
      }
      if (!binaryMembers(expected, "method").equals(binaryMembers(replacement, "method"))) {
        throw new IllegalStateException("Recovered methods changed: " + replacement.name());
      }
      if (!directSerializable(expected) && !directSerializable(replacement)) {
        continue;
      }
      if (!Objects.equals(explicitSerialVersionUid(expected), explicitSerialVersionUid(replacement))) {
        throw new IllegalStateException("serialVersionUID changed: " + replacement.name());
      }
      if (!persistentFields(expected).equals(persistentFields(replacement))) {
        throw new IllegalStateException("Persistent fields changed: " + replacement.name());
      }
    }
  }

  private List<BinaryMember> binaryMembers(ClassInfo info, String kind) {
    int accessMask = "field".equals(kind) ? FIELD_ACCESS_MASK : METHOD_ACCESS_MASK;
    List<BinaryMember> members = new ArrayList<>();
    for (MemberInfo member : info.members()) {
      if (!kind.equals(member.kind()) || "<clinit>".equals(member.name())) {
        continue;
      }
      if ((member.access() & Opcodes.ACC_SYNTHETIC) != 0) {
        continue;
      }
      members.add(new BinaryMember(
          member.name(), member.descriptor(), member.access() & accessMask));
    }
    members.sort(Comparator.comparing(BinaryMember::name).thenComparing(BinaryMember::descriptor));
    return List.copyOf(members);
  }

  private boolean isModelSerializable(
      String name,
      Map<String, ClassInfo> classes,
      Map<String, Boolean> memo,
      Set<String> visiting) {
    Boolean known = memo.get(name);
    if (known != null) {
      return known;
    }
    if (!visiting.add(name)) {
      return false;
    }
    ClassInfo info = classes.get(name);
    boolean result = info != null && directSerializable(info);
    if (!result && info != null && info.superName() != null && classes.containsKey(info.superName())) {
      result = isModelSerializable(info.superName(), classes, memo, visiting);
    }
    if (!result && info != null) {
      for (String interfaceName : info.interfaces()) {
        if (classes.containsKey(interfaceName)
            && isModelSerializable(interfaceName, classes, memo, visiting)) {
          result = true;
          break;
        }
      }
    }
    visiting.remove(name);
    memo.put(name, result);
    return result;
  }

  private boolean directSerializable(ClassInfo info) {
    return info.interfaces().contains("java/io/Serializable")
        || info.interfaces().contains("java/io/Externalizable");
  }

  private List<FieldContract> persistentFields(ClassInfo info) {
    List<FieldContract> fields = new ArrayList<>();
    for (MemberInfo member : info.members()) {
      if (!"field".equals(member.kind())
          || "serialVersionUID".equals(member.name())
          || (member.access() & (Opcodes.ACC_STATIC | Opcodes.ACC_TRANSIENT)) != 0) {
        continue;
      }
      fields.add(new FieldContract(
          member.name(),
          member.descriptor(),
          member.genericSignature(),
          member.access() & FIELD_ACCESS_MASK));
    }
    fields.sort(Comparator.comparing(FieldContract::name).thenComparing(FieldContract::descriptor));
    return List.copyOf(fields);
  }

  private String explicitSerialVersionUid(ClassInfo info) {
    return info.members().stream()
        .filter(member -> "field".equals(member.kind()))
        .filter(member -> "serialVersionUID".equals(member.name()))
        .filter(member -> "J".equals(member.descriptor()))
        .map(MemberInfo::constantValue)
        .findFirst()
        .orElse(null);
  }

  private void collectDescriptorTypes(String descriptor, Set<String> output) {
    collectType(Type.getType(descriptor), output);
  }

  private void collectType(Type type, Set<String> output) {
    if (type.getSort() == Type.OBJECT) {
      output.add(type.getInternalName());
    } else if (type.getSort() == Type.ARRAY) {
      collectType(type.getElementType(), output);
    }
  }

  private String detectRole(ClassInfo info) {
    Set<String> methods = new HashSet<>();
    info.members().stream()
        .filter(member -> "method".equals(member.kind()))
        .forEach(member -> methods.add(member.name()));
    if (methods.containsAll(Set.of("getNome", "getIdade", "setPosicao", "setPais"))) {
      return "player";
    }
    if (methods.containsAll(Set.of("getNome", "setReputacao", "setNivel"))) {
      return "club";
    }
    if ("best/al".equals(info.name())) {
      return "coach";
    }
    if (info.name().startsWith("est/")) {
      return "configuration";
    }
    return "unknown";
  }

  private Map<String, String> readNamedMappings() throws IOException {
    Map<String, String> mappings = new TreeMap<>();
    for (String line : Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8)) {
      if (!line.startsWith("c\t")) {
        continue;
      }
      String[] values = line.split("\t", -1);
      mappings.put(values[1], values[3]);
    }
    return mappings;
  }

  private void writeTargets(List<SerializableClass> models) throws IOException {
    StringBuilder text = new StringBuilder();
    models.stream().map(SerializableClass::officialName).sorted()
        .forEach(name -> text.append(name).append('\n'));
    Path output = context.reportsDir().resolve("serialization-targets.txt");
    Files.createDirectories(output.getParent());
    Files.writeString(output, text.toString(), StandardCharsets.UTF_8);
  }

  private void writeGraph(List<SerializableClass> models) throws IOException {
    Set<String> names = new LinkedHashSet<>();
    models.forEach(model -> names.add(model.officialName()));
    StringBuilder dot = new StringBuilder("digraph serialization {\n  rankdir=LR;\n");
    for (SerializableClass model : models) {
      dot.append("  \"").append(model.officialName()).append("\" [label=\"")
          .append(model.officialName()).append("\\n").append(model.role()).append("\"];\n");
      for (String dependency : model.dependencies()) {
        if (names.contains(dependency)) {
          dot.append("  \"").append(model.officialName()).append("\" -> \"")
              .append(dependency).append("\";\n");
        }
      }
    }
    dot.append("}\n");
    Path output = context.reportsDir().resolve("serialization-graph.dot");
    Files.createDirectories(output.getParent());
    Files.writeString(output, dot.toString(), StandardCharsets.UTF_8);
  }

  private void writeMarkdown(List<SerializableClass> models) throws IOException {
    long direct = models.stream().filter(SerializableClass::direct).count();
    long stable = models.stream().filter(SerializableClass::unchangedFrom2021).count();
    StringBuilder markdown = new StringBuilder("# Atlas De Serializacao\n\n")
        .append("Contrato estrutural usado para preservar `.ban` e saves durante a recuperacao.\n\n")
        .append("- Classes de modelo serializaveis: ").append(models.size()).append("\n")
        .append("- Implementacoes diretas: ").append(direct).append("\n")
        .append("- Bytecode identico ao 2021: ").append(stable).append("\n\n")
        .append("| Classe oficial | Papel | UID | Campos | Dependencias | Igual a 2021 | Risco |\n")
        .append("|---|---|---:|---:|---:|---|---:|\n");
    models.stream()
        .sorted(Comparator.comparing(SerializableClass::risk)
            .thenComparing(SerializableClass::officialName))
        .forEach(model -> markdown.append('|').append(model.officialName())
            .append('|').append(model.role())
            .append('|').append(model.serialVersionUid() == null ? "-" : model.serialVersionUid())
            .append('|').append(model.fields().size())
            .append('|').append(model.dependencies().size())
            .append('|').append(model.unchangedFrom2021() ? "sim" : "nao")
            .append('|').append(model.risk()).append("|\n"));
    Files.writeString(
        context.modkitRoot().resolve("docs/SERIALIZATION_ATLAS.md"),
        markdown.toString(),
        StandardCharsets.UTF_8);
  }

  record SerializationContracts(int schemaVersion, List<SerializableClass> classes) {
  }

  record SerializableClass(
      String officialName,
      String namedName,
      String role,
      boolean direct,
      String superName,
      List<String> interfaces,
      String serialVersionUid,
      boolean unchangedFrom2021,
      int risk,
      List<FieldContract> fields,
      List<String> dependencies) {
  }

  record FieldContract(String name, String descriptor, String genericSignature, int access) {
  }

  record BinaryMember(String name, String descriptor, int access) {
  }
}
