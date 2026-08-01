package com.brasfoot.reconstruction;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

final class DecompiledSourceRepairService {
  private static final Pattern TYPED_COMPARATOR_METHOD = Pattern.compile(
      "public int compare\\(([A-Za-z_$][A-Za-z0-9_$.<>?]*)\\s+"
          + "[A-Za-z_$][A-Za-z0-9_$]*,\\s*\\1\\s+[A-Za-z_$][A-Za-z0-9_$]*\\)");
  private final ProjectContext context;

  DecompiledSourceRepairService(ProjectContext context) {
    this.context = context;
  }

  void repair() throws IOException {
    Path rawRoot = context.buildDir().resolve("generated/decompiled-raw");
    Path repairedRoot = context.buildDir().resolve("generated/decompiled");
    if (!Files.isDirectory(rawRoot)) {
      throw new IOException("Raw decompiled sources not found: " + rawRoot);
    }
    if (Files.exists(repairedRoot)) {
      ZipSupport.deleteTreeWithin(repairedRoot, context.buildDir().resolve("generated"));
    }
    copyDirectory(rawRoot, repairedRoot);

    RepairConfiguration configuration = readConfiguration();
    if (configuration.schemaVersion() != 1 || configuration.repairs() == null) {
      throw new IOException("Unsupported decompiler repair configuration");
    }
    Map<String, String> mappings = readNamedMappings();
    int replacementCount = 0;
    for (ClassRepair repair : configuration.repairs()) {
      String namedClass = mappings.get(repair.officialClass());
      if (namedClass == null) {
        throw new IOException("No named mapping for repair " + repair.officialClass());
      }
      Path source = repairedRoot.resolve(namedClass + ".java");
      if (!Files.isRegularFile(source)) {
        throw new IOException("Decompiler repair source not found: " + source);
      }
      String text = Files.readString(source, StandardCharsets.UTF_8);
      for (Replacement replacement : repair.replacements()) {
        int occurrences = countOccurrences(text, replacement.search());
        if (occurrences != replacement.expectedOccurrences()) {
          throw new IllegalStateException("Repair occurrence mismatch for "
              + repair.officialClass() + ": expected " + replacement.expectedOccurrences()
              + " but found " + occurrences + " for " + replacement.search());
        }
        text = text.replace(replacement.search(), replacement.replacement());
        replacementCount += occurrences;
      }
      Files.writeString(source, text, StandardCharsets.UTF_8);
    }
    int syntheticFieldCount = restoreReferencedSyntheticFields(repairedRoot);
    int syntheticMethodCount = new SyntheticMethodSourceService(context).augment(repairedRoot);
    int comparatorCount = repairComparatorDeclarations(repairedRoot);
    System.out.println("Repaired " + configuration.repairs().size()
        + " configured classes with " + replacementCount + " deterministic replacements and "
        + comparatorCount + " typed Comparator declarations; restored "
        + syntheticFieldCount + " referenced synthetic fields and "
        + syntheticMethodCount + " synthetic method signatures.");
  }

  private int restoreReferencedSyntheticFields(Path sourceRoot) throws IOException {
    ArchiveService.ArchiveData namedArchive = new ArchiveService().analyze(context.namedGameJar());
    int restored = 0;
    for (ArchiveService.ClassInfo classInfo : namedArchive.classes().values()) {
      Path source = sourceRoot.resolve(classInfo.name() + ".java");
      if (!Files.isRegularFile(source)) {
        continue;
      }
      String text = Files.readString(source, StandardCharsets.UTF_8);
      if (text.contains("enum ")) {
        continue;
      }
      StringBuilder declarations = new StringBuilder();
      for (ArchiveService.MemberInfo member : classInfo.members()) {
        if (!"field".equals(member.kind())
            || (member.access() & Opcodes.ACC_SYNTHETIC) == 0
            || !referencesIdentifier(text, member.name())
            || declaresField(text, member)) {
          continue;
        }
        declarations.append("\n   ").append(fieldModifiers(member.access()))
            .append(Type.getType(member.descriptor()).getClassName())
            .append(' ').append(member.name()).append(';');
        restored++;
      }
      if (declarations.length() == 0) {
        continue;
      }
      String simpleName = classInfo.name().substring(classInfo.name().lastIndexOf('/') + 1);
      int declaration = text.indexOf("class " + simpleName);
      int openingBrace = declaration < 0 ? -1 : text.indexOf('{', declaration);
      if (openingBrace < 0) {
        throw new IllegalStateException("Cannot locate class declaration in " + source);
      }
      text = text.substring(0, openingBrace + 1) + declarations + text.substring(openingBrace + 1);
      Files.writeString(source, text, StandardCharsets.UTF_8);
    }
    return restored;
  }

  private boolean referencesIdentifier(String text, String name) {
    return Pattern.compile("(?<![A-Za-z0-9_$])" + Pattern.quote(name)
        + "(?![A-Za-z0-9_$])").matcher(text).find();
  }

  private boolean declaresField(String text, ArchiveService.MemberInfo member) {
    String className = Type.getType(member.descriptor()).getClassName();
    String simpleType = className.substring(className.lastIndexOf('.') + 1);
    String type = "(?:" + Pattern.quote(className) + "|" + Pattern.quote(simpleType) + ")";
    return Pattern.compile("(?m)^\\s*(?:(?:public|protected|private|static|final|transient|volatile)\\s+)*"
        + type + "\\s+" + Pattern.quote(member.name()) + "\\s*(?:=|;)")
        .matcher(text).find();
  }

  private String fieldModifiers(int access) {
    StringBuilder modifiers = new StringBuilder();
    if ((access & Opcodes.ACC_PUBLIC) != 0) {
      modifiers.append("public ");
    } else if ((access & Opcodes.ACC_PROTECTED) != 0) {
      modifiers.append("protected ");
    } else if ((access & Opcodes.ACC_PRIVATE) != 0) {
      modifiers.append("private ");
    }
    if ((access & Opcodes.ACC_STATIC) != 0) {
      modifiers.append("static ");
    }
    if ((access & Opcodes.ACC_FINAL) != 0) {
      modifiers.append("final ");
    }
    if ((access & Opcodes.ACC_TRANSIENT) != 0) {
      modifiers.append("transient ");
    }
    if ((access & Opcodes.ACC_VOLATILE) != 0) {
      modifiers.append("volatile ");
    }
    return modifiers.toString();
  }

  private int repairComparatorDeclarations(Path sourceRoot) throws IOException {
    int repaired = 0;
    try (var paths = Files.walk(sourceRoot)) {
      for (Path source : paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".java")).toList()) {
        String text = Files.readString(source, StandardCharsets.UTF_8);
        if (!text.contains("implements Comparator {")) {
          continue;
        }
        Matcher method = TYPED_COMPARATOR_METHOD.matcher(text);
        if (!method.find()) {
          throw new IllegalStateException("Cannot identify typed Comparator method in " + source);
        }
        String declaration = "implements Comparator<" + method.group(1) + "> {";
        int occurrences = countOccurrences(text, "implements Comparator {");
        if (occurrences != 1) {
          throw new IllegalStateException("Expected one raw Comparator declaration in " + source
              + ", got " + occurrences);
        }
        Files.writeString(source, text.replace("implements Comparator {", declaration),
            StandardCharsets.UTF_8);
        repaired++;
      }
    }
    return repaired;
  }

  private RepairConfiguration readConfiguration() throws IOException {
    Path path = context.projectDir().resolve("config/decompiler-repairs.json");
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      RepairConfiguration configuration = ProjectContext.JSON.fromJson(
          reader, RepairConfiguration.class);
      if (configuration == null) {
        throw new IOException("Invalid decompiler repair configuration: " + path);
      }
      return configuration;
    }
  }

  private Map<String, String> readNamedMappings() throws IOException {
    Map<String, String> mappings = new LinkedHashMap<>();
    for (String line : Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8)) {
      if (line.startsWith("c\t")) {
        String[] values = line.split("\t", -1);
        mappings.put(values[1], values[3]);
      }
    }
    return mappings;
  }

  private int countOccurrences(String text, String search) {
    if (search.isEmpty()) {
      throw new IllegalArgumentException("Repair search text must not be empty");
    }
    int count = 0;
    int offset = 0;
    while ((offset = text.indexOf(search, offset)) >= 0) {
      count++;
      offset += search.length();
    }
    return count;
  }

  private void copyDirectory(Path source, Path target) throws IOException {
    Files.walkFileTree(source, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes)
          throws IOException {
        Files.createDirectories(target.resolve(source.relativize(directory).toString()));
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
          throws IOException {
        Path destination = target.resolve(source.relativize(file).toString());
        Files.createDirectories(destination.getParent());
        Files.copy(file, destination, StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES);
        return FileVisitResult.CONTINUE;
      }
    });
  }

  record RepairConfiguration(int schemaVersion, List<ClassRepair> repairs) {
  }

  record ClassRepair(String officialClass, List<Replacement> replacements) {
  }

  record Replacement(String search, String replacement, int expectedOccurrences) {
  }
}
