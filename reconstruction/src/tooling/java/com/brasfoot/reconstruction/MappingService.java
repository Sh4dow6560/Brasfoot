package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ArchiveService.MemberInfo;
import com.brasfoot.reconstruction.ProjectContext.MethodSemanticName;
import com.brasfoot.reconstruction.ProjectContext.FieldSemanticName;
import com.brasfoot.reconstruction.ProjectContext.SemanticNames;
import com.brasfoot.reconstruction.ProjectContext.VersionSpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

final class MappingService {
  private final ProjectContext context;
  private final ArchiveService archives = new ArchiveService();

  MappingService(ProjectContext context) {
    this.context = context;
  }

  void generate() throws IOException {
    ArchiveData target = archives.analyze(context.input("22-23"));
    SemanticNames semantic = context.semanticNames();
    validateSemanticSourcesMigrated(semantic);
    Map<String, String> promotions = context.promotions();
    Map<String, String> introduced = introducedVersions();
    Map<String, MethodSemanticName> semanticMethods = new HashMap<>();
    for (MethodSemanticName item : semantic.methods()) {
      semanticMethods.put(methodKey(item.owner(), item.name(), item.descriptor()), item);
    }
    addComparatorMethodMappings(target, semanticMethods);
    Map<String, FieldSemanticName> semanticFields = new HashMap<>();
    for (FieldSemanticName item : semantic.fields()) {
      semanticFields.put(fieldKey(item.owner(), item.name(), item.descriptor()), item);
    }

    List<String> officialNames = new ArrayList<>(target.classes().keySet());
    officialNames.sort(String::compareTo);
    Map<String, String> intermediary = new LinkedHashMap<>();
    Map<String, String> named = new LinkedHashMap<>();
    for (int index = 0; index < officialNames.size(); index++) {
      String official = officialNames.get(index);
      String stable = String.format(Locale.ROOT, "bf22/intermediary/C%04d", index + 1);
      intermediary.put(official, stable);
      named.put(official, semantic.classes().getOrDefault(official, stable));
    }

    validateClassMappings(intermediary, "intermediary");
    validateClassMappings(named, "named");

    StringBuilder tiny = new StringBuilder("tiny\t2\t0\tofficial\tintermediary\tnamed\n");
    int mappedMembers = 0;
    Set<String> consumedSemanticMethods = new HashSet<>();
    Set<String> consumedSemanticFields = new HashSet<>();
    for (String official : officialNames) {
      ClassInfo classInfo = target.classes().get(official);
      tiny.append("c\t").append(official).append('\t')
          .append(intermediary.get(official)).append('\t').append(named.get(official)).append('\n');

      Set<String> ownerOutputSignatures = new HashSet<>();
      for (MemberInfo member : classInfo.members()) {
        if (member.name().startsWith("<")) {
          continue;
        }
        MethodSemanticName semanticMethod = "method".equals(member.kind())
            ? semanticMethods.get(methodKey(official, member.name(), member.descriptor())) : null;
        FieldSemanticName semanticField = "field".equals(member.kind())
            ? semanticFields.get(fieldKey(official, member.name(), member.descriptor())) : null;
        boolean illegal = !JavaIdentifiers.isLegal(member.name());
        String intermediaryName = illegal
            ? JavaIdentifiers.legalMemberName(member.kind(), member.name()) : member.name();
        String namedName = semanticMethod != null
            ? semanticMethod.named()
            : semanticField != null ? semanticField.named() : intermediaryName;
        if (!JavaIdentifiers.isLegal(intermediaryName) || !JavaIdentifiers.isLegal(namedName)) {
          throw new IllegalStateException("Illegal mapped member name for " + official + "."
              + member.name() + member.descriptor());
        }
        String outputSignature = member.kind() + ":" + namedName + ":" + member.descriptor();
        if (!ownerOutputSignatures.add(outputSignature)) {
          throw new IllegalStateException("Mapped member collision: " + official + " "
              + outputSignature);
        }
        if (semanticMethod == null && semanticField == null && !illegal) {
          continue;
        }
        tiny.append('\t').append("field".equals(member.kind()) ? 'f' : 'm').append('\t')
            .append(member.descriptor()).append('\t').append(member.name()).append('\t')
            .append(intermediaryName).append('\t').append(namedName).append('\n');
        mappedMembers++;
        if (semanticMethod != null) {
          consumedSemanticMethods.add(methodKey(
              semanticMethod.owner(), semanticMethod.name(), semanticMethod.descriptor()));
        }
        if (semanticField != null) {
          consumedSemanticFields.add(fieldKey(
              semanticField.owner(), semanticField.name(), semanticField.descriptor()));
        }
      }
    }

    if (consumedSemanticMethods.size() != semanticMethods.size()) {
      Set<String> missing = new HashSet<>(semanticMethods.keySet());
      missing.removeAll(consumedSemanticMethods);
      throw new IllegalStateException("Semantic method mappings not found in target: " + missing);
    }
    if (consumedSemanticFields.size() != semanticFields.size()) {
      Set<String> missing = new HashSet<>(semanticFields.keySet());
      missing.removeAll(consumedSemanticFields);
      throw new IllegalStateException("Semantic field mappings not found in target: " + missing);
    }
    if (!target.classes().keySet().containsAll(semantic.classes().keySet())) {
      Set<String> missing = new HashSet<>(semantic.classes().keySet());
      missing.removeAll(target.classes().keySet());
      throw new IllegalStateException("Semantic class mappings not found in target: " + missing);
    }

    Path mappings = context.mappingsFile();
    Files.createDirectories(mappings.getParent());
    Files.writeString(mappings, tiny.toString(), StandardCharsets.UTF_8);

    List<RecoveryEntry> recovery = new ArrayList<>();
    for (String official : officialNames) {
      String namedClass = named.get(official);
      Path source = context.projectDir().resolve("src/recovered/java/" + namedClass + ".java");
      String sourceSha = Files.isRegularFile(source) ? Hashing.sha256(source) : null;
      recovery.add(new RecoveryEntry(
          official,
          intermediary.get(official),
          namedClass,
          introduced.getOrDefault(official, "unknown"),
          promotions.getOrDefault(official, "binary"),
          sourceSha));
    }
    context.writeJson(context.projectDir().resolve("recovery-index.json"),
        new RecoveryIndex(1, recovery));
    context.writeJson(context.reportsDir().resolve("mapping-report.json"),
        new MappingReport(
            officialNames.size(), mappedMembers, intermediary.size(), named.size(),
            0, 0, context.mappingsFile().toString()));

    System.out.println("Generated reversible mappings for " + officialNames.size()
        + " classes and " + mappedMembers + " members.");
  }

  private void validateSemanticSourcesMigrated(SemanticNames semantic) throws IOException {
    Path mappings = context.mappingsFile();
    if (!Files.isRegularFile(mappings)) {
      return;
    }
    Map<String, String> current = new HashMap<>();
    for (String line : Files.readAllLines(mappings, StandardCharsets.UTF_8)) {
      if (line.startsWith("c\t")) {
        String[] values = line.split("\t", -1);
        current.put(values[1], values[3]);
      }
    }
    List<String> pending = new ArrayList<>();
    for (Map.Entry<String, String> entry : semantic.classes().entrySet()) {
      String currentName = current.get(entry.getKey());
      if (currentName == null || currentName.equals(entry.getValue())) {
        continue;
      }
      Path currentSource = context.projectDir().resolve(
          "src/recovered/java/" + currentName + ".java");
      Path desiredSource = context.projectDir().resolve(
          "src/recovered/java/" + entry.getValue() + ".java");
      if (Files.isRegularFile(currentSource) && !Files.isRegularFile(desiredSource)) {
        pending.add(entry.getKey() + ":" + currentName + "->" + entry.getValue());
      }
    }
    if (!pending.isEmpty()) {
      throw new IllegalStateException("Semantic source migration required before generating "
          + "mappings. Run applySemanticSourceMappings. Pending: " + pending);
    }
  }

  void validateExisting() throws IOException {
    if (!Files.isRegularFile(context.mappingsFile())) {
      throw new IOException("Mappings not found: " + context.mappingsFile());
    }
    List<String> lines = Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8);
    if (lines.isEmpty() || !"tiny\t2\t0\tofficial\tintermediary\tnamed".equals(lines.get(0))) {
      throw new IllegalStateException("Unexpected Tiny mapping header");
    }
    Set<String> intermediary = new HashSet<>();
    Set<String> named = new HashSet<>();
    Set<String> intermediaryFolded = new HashSet<>();
    Set<String> namedFolded = new HashSet<>();
    int classes = 0;
    for (String line : lines) {
      if (!line.startsWith("c\t")) {
        continue;
      }
      String[] values = line.split("\t", -1);
      if (values.length != 4) {
        throw new IllegalStateException("Invalid class mapping: " + line);
      }
      addUnique(intermediary, values[2], "intermediary");
      addUnique(named, values[3], "named");
      addUnique(intermediaryFolded, values[2].toLowerCase(Locale.ROOT),
          "case-insensitive intermediary");
      addUnique(namedFolded, values[3].toLowerCase(Locale.ROOT), "case-insensitive named");
      classes++;
    }
    if (classes != 1038) {
      throw new IllegalStateException("Expected 1038 mapped classes, got " + classes);
    }
  }

  private Map<String, String> introducedVersions() throws IOException {
    Map<String, String> introduced = new TreeMap<>();
    for (VersionSpec version : context.inputLock().versions()) {
      ArchiveData archive = archives.analyze(context.input(version.id()));
      for (String className : archive.classes().keySet()) {
        introduced.putIfAbsent(className, version.id());
      }
    }
    return introduced;
  }

  private void validateClassMappings(Map<String, String> mappings, String namespace) {
    Set<String> exact = new HashSet<>();
    Set<String> folded = new HashSet<>();
    for (String value : mappings.values()) {
      if (!JavaIdentifiers.isLegalInternalClassName(value)) {
        throw new IllegalStateException("Illegal " + namespace + " class name: " + value);
      }
      addUnique(exact, value, namespace);
      addUnique(folded, value.toLowerCase(Locale.ROOT), "case-insensitive " + namespace);
    }
  }

  private void addComparatorMethodMappings(
      ArchiveData target, Map<String, MethodSemanticName> semanticMethods) {
    for (ClassInfo classInfo : target.classes().values()) {
      if (!classInfo.interfaces().contains("java/util/Comparator")) {
        continue;
      }
      List<MemberInfo> candidates = classInfo.members().stream()
          .filter(member -> "method".equals(member.kind()))
          .filter(member -> (member.access() & (Opcodes.ACC_STATIC | Opcodes.ACC_SYNTHETIC)) == 0)
          .filter(member -> {
            Type method = Type.getMethodType(member.descriptor());
            Type[] arguments = method.getArgumentTypes();
            if (!method.getReturnType().equals(Type.INT_TYPE)
                || arguments.length != 2
                || !arguments[0].equals(arguments[1])) {
              return false;
            }
            int sort = arguments[0].getSort();
            return (sort == Type.OBJECT || sort == Type.ARRAY)
                && !arguments[0].equals(Type.getType(Object.class));
          })
          .toList();
      if (candidates.size() != 1) {
        throw new IllegalStateException("Expected one typed Comparator method in "
            + classInfo.name() + ", got " + candidates.size());
      }
      MemberInfo method = candidates.get(0);
      MethodSemanticName mapping = new MethodSemanticName(
          classInfo.name(), method.name(), method.descriptor(), "compare");
      String key = methodKey(classInfo.name(), method.name(), method.descriptor());
      MethodSemanticName previous = semanticMethods.putIfAbsent(key, mapping);
      if (previous != null && !"compare".equals(previous.named())) {
        throw new IllegalStateException("Comparator method has conflicting semantic mapping: "
            + key);
      }
    }
  }

  private void addUnique(Set<String> values, String value, String label) {
    if (!values.add(value)) {
      throw new IllegalStateException("Duplicate " + label + " name: " + value);
    }
  }

  private String methodKey(String owner, String name, String descriptor) {
    return owner + "." + name + descriptor;
  }

  private String fieldKey(String owner, String name, String descriptor) {
    return owner + "." + name + ":" + descriptor;
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

  record MappingReport(
      int officialClasses,
      int mappedMembers,
      int intermediaryClasses,
      int namedClasses,
      int illegalIdentifiers,
      int caseInsensitiveCollisions,
      String mappingFile) {
  }
}
