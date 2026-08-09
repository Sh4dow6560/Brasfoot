package com.brasfoot.reconstruction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SemanticSourceMigrationService {
  private static final Pattern PACKAGE = Pattern.compile(
      "(?m)^package\\s+([A-Za-z_$][A-Za-z0-9_$.]*);$");
  private static final Pattern FIRST_IMPORT = Pattern.compile("(?m)^import\\s+");
  private static final int GAME_CLASS_COUNT = 1032;
  private final ProjectContext context;

  SemanticSourceMigrationService(ProjectContext context) {
    this.context = context;
  }

  void migrate() throws IOException {
    Map<String, String> currentMappings = readNamedMappings();
    Map<String, String> desiredMappings = context.semanticNames().classes();
    List<ClassMigration> migrations = desiredMappings.entrySet().stream()
        .filter(entry -> currentMappings.containsKey(entry.getKey()))
        .map(entry -> new ClassMigration(
            entry.getKey(), currentMappings.get(entry.getKey()), entry.getValue()))
        .filter(migration -> !migration.currentName().equals(migration.desiredName()))
        .sorted((left, right) -> left.officialName().compareTo(right.officialName()))
        .toList();
    if (migrations.isEmpty()) {
      throw new IllegalStateException("No pending semantic class mappings to apply");
    }
    validateMigrations(migrations);

    Path trackedRoot = context.projectDir().resolve("src/recovered/java");
    Path stagedRoot = context.buildDir().resolve("generated/semantic-source-migration");
    if (Files.exists(stagedRoot)) {
      ZipSupport.deleteTreeWithin(stagedRoot, context.buildDir().resolve("generated"));
    }
    Files.createDirectories(stagedRoot);

    Map<String, ClassMigration> byCurrentName = new HashMap<>();
    for (ClassMigration migration : migrations) {
      byCurrentName.put(migration.currentName(), migration);
    }
    int sourceCount = 0;
    int changedFiles = 0;
    Set<String> outputNames = new LinkedHashSet<>();
    try (var paths = Files.walk(trackedRoot)) {
      for (Path source : paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".java")).toList()) {
        sourceCount++;
        String relative = trackedRoot.relativize(source).toString().replace('\\', '/');
        String currentName = relative.substring(0, relative.length() - ".java".length());
        ClassMigration ownMigration = byCurrentName.get(currentName);
        String outputName = ownMigration == null ? currentName : ownMigration.desiredName();
        if (!outputNames.add(outputName)) {
          throw new IllegalStateException("Semantic source path collision: " + outputName);
        }

        String original = Files.readString(source, StandardCharsets.UTF_8);
        String migrated = migrateSource(original, currentName, outputName, migrations);
        if (!original.equals(migrated) || !currentName.equals(outputName)) {
          changedFiles++;
        }
        Path target = stagedRoot.resolve(outputName + ".java");
        Files.createDirectories(target.getParent());
        Files.writeString(target, migrated, StandardCharsets.UTF_8);
      }
    }
    if (sourceCount != GAME_CLASS_COUNT) {
      throw new IllegalStateException("Expected " + GAME_CLASS_COUNT
          + " tracked game sources, got " + sourceCount);
    }
    verifyNoOldClassIdentifiers(stagedRoot, migrations);

    Path backupRoot = context.buildDir().resolve("generated/semantic-source-backup");
    if (Files.exists(backupRoot)) {
      ZipSupport.deleteTreeWithin(backupRoot, context.buildDir().resolve("generated"));
    }
    copyDirectory(trackedRoot, backupRoot);
    try {
      ZipSupport.deleteTreeWithin(trackedRoot, context.projectDir().resolve("src/recovered"));
      copyDirectory(stagedRoot, trackedRoot);
    } catch (IOException | RuntimeException exception) {
      if (Files.exists(trackedRoot)) {
        ZipSupport.deleteTreeWithin(trackedRoot, context.projectDir().resolve("src/recovered"));
      }
      copyDirectory(backupRoot, trackedRoot);
      throw exception;
    }
    context.writeJson(context.reportsDir().resolve("semantic-source-migration.json"),
        new MigrationReport(sourceCount, changedFiles, migrations));
    System.out.println("Applied " + migrations.size() + " semantic class mappings across "
        + changedFiles + " of " + sourceCount + " recovered sources.");
  }

  private String migrateSource(
      String source, String currentName, String outputName, List<ClassMigration> migrations) {
    String migrated = source;
    for (ClassMigration migration : migrations) {
      migrated = replaceIdentifier(migrated, migration.currentName().replace('/', '.'),
          migration.desiredName().replace('/', '.'));
      migrated = replaceIdentifier(migrated, simpleName(migration.currentName()),
          simpleName(migration.desiredName()));
    }

    if (!currentName.equals(outputName)) {
      Matcher packageMatcher = PACKAGE.matcher(migrated);
      if (!packageMatcher.find()) {
        throw new IllegalStateException("Cannot locate package declaration for " + currentName);
      }
      migrated = packageMatcher.replaceFirst(
          Matcher.quoteReplacement("package " + packageName(outputName) + ";"));
    }

    String sourcePackage = packageName(outputName);
    Set<String> imports = new LinkedHashSet<>();
    if (!currentName.equals(outputName)
        && currentName.startsWith("bf22/intermediary/")) {
      imports.add("import bf22.intermediary.*;");
    }
    for (ClassMigration migration : migrations) {
      if (outputName.equals(migration.desiredName())
          || sourcePackage.equals(packageName(migration.desiredName()))) {
        continue;
      }
      String desiredSimpleName = simpleName(migration.desiredName());
      if (containsUnqualifiedIdentifier(migrated, desiredSimpleName)) {
        String importLine = "import " + migration.desiredName().replace('/', '.') + ";";
        if (!migrated.contains(importLine)) {
          imports.add(importLine);
        }
      }
    }
    return addImports(migrated, imports);
  }

  private String addImports(String source, Set<String> imports) {
    if (imports.isEmpty()) {
      return source;
    }
    String block = String.join("\n", imports.stream().sorted().toList()) + "\n";
    Matcher firstImport = FIRST_IMPORT.matcher(source);
    if (firstImport.find()) {
      return source.substring(0, firstImport.start()) + block + source.substring(firstImport.start());
    }
    Matcher packageMatcher = PACKAGE.matcher(source);
    if (!packageMatcher.find()) {
      throw new IllegalStateException("Cannot insert imports without a package declaration");
    }
    return source.substring(0, packageMatcher.end()) + "\n\n" + block
        + source.substring(packageMatcher.end()).stripLeading();
  }

  private void validateMigrations(List<ClassMigration> migrations) {
    Set<String> desiredNames = new LinkedHashSet<>();
    for (ClassMigration migration : migrations) {
      if (!desiredNames.add(migration.desiredName())) {
        throw new IllegalStateException("Duplicate desired semantic name: "
            + migration.desiredName());
      }
      if (!migration.desiredName().matches(
          "[A-Za-z_$][A-Za-z0-9_$]*(/[A-Za-z_$][A-Za-z0-9_$]*)+")) {
        throw new IllegalStateException("Illegal semantic class name: "
            + migration.desiredName());
      }
    }
  }

  private void verifyNoOldClassIdentifiers(
      Path sourceRoot, List<ClassMigration> migrations) throws IOException {
    List<String> stale = new ArrayList<>();
    try (var paths = Files.walk(sourceRoot)) {
      for (Path source : paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".java")).toList()) {
        String text = Files.readString(source, StandardCharsets.UTF_8);
        for (ClassMigration migration : migrations) {
          String currentSimpleName = simpleName(migration.currentName());
          String desiredSimpleName = simpleName(migration.desiredName());
          if (!currentSimpleName.equals(desiredSimpleName)
              && containsIdentifier(text, currentSimpleName)) {
            stale.add(sourceRoot.relativize(source).toString().replace('\\', '/')
                + ":" + currentSimpleName);
          }
        }
      }
    }
    if (!stale.isEmpty()) {
      throw new IllegalStateException("Stale class identifiers after semantic migration: "
          + stale.stream().limit(20).toList());
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

  private String replaceIdentifier(String text, String oldName, String newName) {
    return Pattern.compile("(?<![A-Za-z0-9_$])" + Pattern.quote(oldName)
        + "(?![A-Za-z0-9_$])").matcher(text).replaceAll(Matcher.quoteReplacement(newName));
  }

  private boolean containsIdentifier(String text, String identifier) {
    return Pattern.compile("(?<![A-Za-z0-9_$])" + Pattern.quote(identifier)
        + "(?![A-Za-z0-9_$])").matcher(text).find();
  }

  private boolean containsUnqualifiedIdentifier(String text, String identifier) {
    return Pattern.compile("(?<![A-Za-z0-9_$.])" + Pattern.quote(identifier)
        + "(?![A-Za-z0-9_$])").matcher(text).find();
  }

  private String packageName(String internalName) {
    int separator = internalName.lastIndexOf('/');
    return internalName.substring(0, separator).replace('/', '.');
  }

  private String simpleName(String internalName) {
    return internalName.substring(internalName.lastIndexOf('/') + 1);
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

  record ClassMigration(String officialName, String currentName, String desiredName) {
  }

  record MigrationReport(int sourceCount, int changedFiles, List<ClassMigration> classes) {
  }
}
