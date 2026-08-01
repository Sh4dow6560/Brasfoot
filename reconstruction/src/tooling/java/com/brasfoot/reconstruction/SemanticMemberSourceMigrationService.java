package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ArchiveService.MemberInfo;
import com.brasfoot.reconstruction.ProjectContext.FieldSemanticName;
import com.brasfoot.reconstruction.ProjectContext.MethodSemanticName;
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
import org.objectweb.asm.Opcodes;

final class SemanticMemberSourceMigrationService {
  private static final int GAME_CLASS_COUNT = 1032;
  private final ProjectContext context;

  SemanticMemberSourceMigrationService(ProjectContext context) {
    this.context = context;
  }

  void migrate() throws IOException {
    TinyState current = readTinyState();
    ArchiveData game = new ArchiveService().analyze(context.input("22-23"));
    List<MemberMigration> migrations = pendingMigrations(current, game);
    if (migrations.isEmpty()) {
      throw new IllegalStateException("No pending semantic static member mappings to apply");
    }

    Path trackedRoot = context.projectDir().resolve("src/recovered/java");
    Path stagedRoot = context.buildDir().resolve("generated/semantic-member-source-migration");
    if (Files.exists(stagedRoot)) {
      ZipSupport.deleteTreeWithin(stagedRoot, context.buildDir().resolve("generated"));
    }
    Files.createDirectories(stagedRoot);

    int sourceCount = 0;
    int changedFiles = 0;
    Map<String, List<MemberMigration>> byOwner = new HashMap<>();
    for (MemberMigration migration : migrations) {
      byOwner.computeIfAbsent(migration.ownerNamed(), ignored -> new ArrayList<>()).add(migration);
    }
    try (var paths = Files.walk(trackedRoot)) {
      for (Path source : paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".java")).toList()) {
        sourceCount++;
        String relative = trackedRoot.relativize(source).toString().replace('\\', '/');
        String className = relative.substring(0, relative.length() - ".java".length());
        String original = Files.readString(source, StandardCharsets.UTF_8);
        String migrated = migrateExternalReferences(original, migrations);
        for (MemberMigration migration : byOwner.getOrDefault(className, List.of())) {
          migrated = migrateOwnerReference(migrated, migration);
        }
        if (!original.equals(migrated)) {
          changedFiles++;
        }
        Path target = stagedRoot.resolve(relative);
        Files.createDirectories(target.getParent());
        Files.writeString(target, migrated, StandardCharsets.UTF_8);
      }
    }
    if (sourceCount != GAME_CLASS_COUNT) {
      throw new IllegalStateException("Expected " + GAME_CLASS_COUNT
          + " tracked game sources, got " + sourceCount);
    }
    verifyMigration(stagedRoot, migrations);

    Path backupRoot = context.buildDir().resolve("generated/semantic-member-source-backup");
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
    context.writeJson(context.reportsDir().resolve("semantic-member-source-migration.json"),
        new MigrationReport(sourceCount, changedFiles, migrations));
    System.out.println("Applied " + migrations.size() + " semantic static member mappings across "
        + changedFiles + " of " + sourceCount + " recovered sources.");
  }

  private List<MemberMigration> pendingMigrations(TinyState current, ArchiveData game)
      throws IOException {
    List<MemberMigration> migrations = new ArrayList<>();
    for (FieldSemanticName field : context.semanticNames().fields()) {
      addPending(migrations, current, game, "field", field.owner(), field.name(),
          field.descriptor(), field.named());
    }
    for (MethodSemanticName method : context.semanticNames().methods()) {
      addPending(migrations, current, game, "method", method.owner(), method.name(),
          method.descriptor(), method.named());
    }
    migrations.sort((left, right) -> left.key().compareTo(right.key()));
    return migrations;
  }

  private void addPending(
      List<MemberMigration> migrations,
      TinyState current,
      ArchiveData game,
      String kind,
      String owner,
      String officialName,
      String descriptor,
      String desiredName) {
    String ownerNamed = current.classes().get(owner);
    if (ownerNamed == null) {
      throw new IllegalStateException("Semantic member owner is absent from mappings: " + owner);
    }
    String key = memberKey(owner, kind, officialName, descriptor);
    String currentName = current.members().getOrDefault(key, officialName);
    if (currentName.equals(desiredName)) {
      return;
    }
    ClassInfo ownerInfo = game.classes().get(owner);
    MemberInfo member = ownerInfo == null ? null : ownerInfo.members().stream()
        .filter(candidate -> candidate.kind().equals(kind))
        .filter(candidate -> candidate.name().equals(officialName))
        .filter(candidate -> candidate.descriptor().equals(descriptor))
        .findFirst().orElse(null);
    if (member == null) {
      throw new IllegalStateException("Semantic member is absent from game: " + key);
    }
    if ((member.access() & Opcodes.ACC_STATIC) == 0) {
      throw new IllegalStateException("Automatic source migration currently requires a static "
          + "member: " + key);
    }
    long sameNameMembers = ownerInfo.members().stream()
        .filter(candidate -> candidate.kind().equals(kind))
        .filter(candidate -> candidate.name().equals(officialName))
        .count();
    if (sameNameMembers != 1) {
      throw new IllegalStateException("Automatic source migration requires a unique member name: "
          + key);
    }
    migrations.add(new MemberMigration(
        owner, ownerNamed, kind, officialName, descriptor, currentName, desiredName));
  }

  private String migrateExternalReferences(String source, List<MemberMigration> migrations) {
    String migrated = source;
    for (MemberMigration migration : migrations) {
      String oldReference = simpleName(migration.ownerNamed()) + "." + migration.currentName();
      String newReference = simpleName(migration.ownerNamed()) + "." + migration.desiredName();
      migrated = replaceIdentifier(migrated, oldReference, newReference);
    }
    return migrated;
  }

  private String migrateOwnerReference(String source, MemberMigration migration) {
    String oldName = Pattern.quote(migration.currentName());
    Pattern identifier = "method".equals(migration.kind())
        ? Pattern.compile("(?<![A-Za-z0-9_$])" + oldName + "(?=\\s*\\()")
        : Pattern.compile("(?<![A-Za-z0-9_$])" + oldName + "(?![A-Za-z0-9_$])");
    return identifier.matcher(source).replaceAll(Matcher.quoteReplacement(migration.desiredName()));
  }

  private void verifyMigration(Path sourceRoot, List<MemberMigration> migrations)
      throws IOException {
    List<String> stale = new ArrayList<>();
    Map<String, String> sources = new LinkedHashMap<>();
    try (var paths = Files.walk(sourceRoot)) {
      for (Path source : paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".java")).toList()) {
        String relative = sourceRoot.relativize(source).toString().replace('\\', '/');
        sources.put(relative.substring(0, relative.length() - ".java".length()),
            Files.readString(source, StandardCharsets.UTF_8));
      }
    }
    for (MemberMigration migration : migrations) {
      String oldReference = simpleName(migration.ownerNamed()) + "." + migration.currentName();
      for (Map.Entry<String, String> source : sources.entrySet()) {
        if (containsIdentifier(source.getValue(), oldReference)) {
          stale.add(source.getKey() + ":" + oldReference);
        }
      }
      String ownerSource = sources.get(migration.ownerNamed());
      if (ownerSource == null || !containsIdentifier(ownerSource, migration.desiredName())) {
        stale.add(migration.ownerNamed() + ":missing-" + migration.desiredName());
      }
    }
    if (!stale.isEmpty()) {
      throw new IllegalStateException("Incomplete semantic member source migration: "
          + stale.stream().limit(20).toList());
    }
  }

  private TinyState readTinyState() throws IOException {
    Map<String, String> classes = new LinkedHashMap<>();
    Map<String, String> members = new LinkedHashMap<>();
    String owner = null;
    for (String line : Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8)) {
      if (line.startsWith("c\t")) {
        String[] values = line.split("\t", -1);
        owner = values[1];
        classes.put(owner, values[3]);
      } else if (owner != null && (line.startsWith("\tf\t") || line.startsWith("\tm\t"))) {
        String[] values = line.split("\t", -1);
        String kind = "f".equals(values[1]) ? "field" : "method";
        members.put(memberKey(owner, kind, values[3], values[2]), values[5]);
      }
    }
    return new TinyState(classes, members);
  }

  private String replaceIdentifier(String text, String oldName, String newName) {
    return Pattern.compile("(?<![A-Za-z0-9_$])" + Pattern.quote(oldName)
        + "(?![A-Za-z0-9_$])").matcher(text).replaceAll(Matcher.quoteReplacement(newName));
  }

  private boolean containsIdentifier(String text, String identifier) {
    return Pattern.compile("(?<![A-Za-z0-9_$])" + Pattern.quote(identifier)
        + "(?![A-Za-z0-9_$])").matcher(text).find();
  }

  private String memberKey(String owner, String kind, String name, String descriptor) {
    return owner + ":" + kind + ":" + name + ":" + descriptor;
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

  record TinyState(Map<String, String> classes, Map<String, String> members) {
  }

  record MemberMigration(
      String ownerOfficial,
      String ownerNamed,
      String kind,
      String officialName,
      String descriptor,
      String currentName,
      String desiredName) {
    String key() {
      return ownerOfficial + ":" + kind + ":" + officialName + ":" + descriptor;
    }
  }

  record MigrationReport(
      int sourceCount,
      int changedFiles,
      List<MemberMigration> migrations) {
  }
}
