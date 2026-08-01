package com.brasfoot.reconstruction;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

final class SaveFixtureService {
  private static final List<String> EXTENSIONS = List.of(".s22", ".sbck", ".info");

  private final ProjectContext context;

  SaveFixtureService(ProjectContext context) {
    this.context = context;
  }

  void capture() throws IOException {
    Path sourceDirectory = context.hybridRoot().resolve("sav");
    Path sourceSave = latestSave(sourceDirectory);
    String fileName = sourceSave.getFileName().toString();
    String stem = fileName.substring(0, fileName.length() - 4);
    Path fixtureDirectory = context.referenceSaveDir();
    Files.createDirectories(fixtureDirectory);

    List<FixtureFile> files = new ArrayList<>();
    for (String extension : EXTENSIONS) {
      Path source = sourceDirectory.resolve(stem + extension);
      if (!Files.isRegularFile(source)) {
        if (".s22".equals(extension) || ".info".equals(extension)) {
          throw new IOException("Reference save is missing companion file: " + source);
        }
        continue;
      }
      Path target = fixtureDirectory.resolve("reference" + extension);
      Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING,
          StandardCopyOption.COPY_ATTRIBUTES);
      files.add(describe(target));
    }

    validateInfoHeader(fixtureDirectory.resolve("reference.info"));
    SaveFixtureManifest manifest = new SaveFixtureManifest(
        1,
        "fixtures/local/career-reference",
        Hashing.sha256(context.input("22-23")),
        List.copyOf(files));
    context.writeJson(context.referenceSaveManifest(), manifest);
    verify();
    System.out.println("Captured validated reference save with " + files.size()
        + " files; binary data remains outside Git.");
  }

  void verify() throws IOException {
    SaveFixtureManifest manifest = readManifest();
    if (manifest.schemaVersion() != 1 || manifest.files() == null || manifest.files().isEmpty()) {
      throw new IllegalStateException("Invalid reference save manifest");
    }
    if (!Hashing.sha256(context.input("22-23")).equals(manifest.sourceExecutableSha256())) {
      throw new IllegalStateException("Reference save belongs to a different game executable");
    }

    for (FixtureFile expected : manifest.files()) {
      Path path = context.referenceSaveDir().resolve(expected.name());
      FixtureFile actual = describe(path);
      if (expected.size() != actual.size() || !expected.sha256().equals(actual.sha256())) {
        throw new IllegalStateException("Reference save fixture changed: " + expected.name());
      }
    }
    validateInfoHeader(context.referenceSaveDir().resolve("reference.info"));
    System.out.println("Verified reference save fixture: " + manifest.files().size()
        + " files match their hashes.");
  }

  private Path latestSave(Path directory) throws IOException {
    if (!Files.isDirectory(directory)) {
      throw new IOException("Hybrid save directory not found: " + directory);
    }
    try (Stream<Path> paths = Files.list(directory)) {
      return paths
          .filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".s22"))
          .max(Comparator.comparing(this::lastModified)
              .thenComparing(path -> path.getFileName().toString()))
          .orElseThrow(() -> new IOException("No .s22 save found in " + directory));
    }
  }

  private FileTime lastModified(Path path) {
    try {
      return Files.getLastModifiedTime(path);
    } catch (IOException exception) {
      throw new IllegalStateException("Could not read save timestamp: " + path, exception);
    }
  }

  private FixtureFile describe(Path path) throws IOException {
    if (!Files.isRegularFile(path)) {
      throw new IOException("Reference save file not found: " + path);
    }
    return new FixtureFile(path.getFileName().toString(), Files.size(path), Hashing.sha256(path));
  }

  private void validateInfoHeader(Path info) throws IOException {
    byte[] bytes = Files.readAllBytes(info);
    if (bytes.length < 4
        || (bytes[0] & 0xFF) != 0xAC
        || (bytes[1] & 0xFF) != 0xED
        || bytes[2] != 0
        || bytes[3] != 5) {
      throw new IllegalStateException("Reference .info is not a Java serialization stream");
    }
  }

  private SaveFixtureManifest readManifest() throws IOException {
    Path path = context.referenceSaveManifest();
    if (!Files.isRegularFile(path)) {
      throw new IOException("Reference save manifest not found: " + path);
    }
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      SaveFixtureManifest manifest = ProjectContext.JSON.fromJson(reader, SaveFixtureManifest.class);
      if (manifest == null) {
        throw new IOException("Could not read reference save manifest: " + path);
      }
      return manifest;
    }
  }

  record SaveFixtureManifest(
      int schemaVersion,
      String localDirectory,
      String sourceExecutableSha256,
      List<FixtureFile> files) {
  }

  record FixtureFile(String name, long size, String sha256) {
  }
}
