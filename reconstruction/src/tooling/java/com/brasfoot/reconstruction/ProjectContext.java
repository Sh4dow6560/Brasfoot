package com.brasfoot.reconstruction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

final class ProjectContext {
  static final Gson JSON = new GsonBuilder()
      .setPrettyPrinting()
      .disableHtmlEscaping()
      .create();

  private final Path projectDir;
  private final Properties local;
  private final InputLock inputLock;

  private ProjectContext(Path projectDir, Properties local, InputLock inputLock) {
    this.projectDir = projectDir;
    this.local = local;
    this.inputLock = inputLock;
  }

  static ProjectContext load(Path projectDir) throws IOException {
    Path normalized = projectDir.toAbsolutePath().normalize();
    Path localFile = normalized.resolve("local.properties");
    if (!Files.isRegularFile(localFile)) {
      throw new IOException("Missing local configuration: " + localFile);
    }

    Properties local = new Properties();
    try (Reader reader = Files.newBufferedReader(localFile, StandardCharsets.UTF_8)) {
      local.load(reader);
    }

    Path lockFile = normalized.resolve("config/inputs-lock.json");
    try (Reader reader = Files.newBufferedReader(lockFile, StandardCharsets.UTF_8)) {
      InputLock lock = JSON.fromJson(reader, InputLock.class);
      if (lock == null || lock.versions() == null || lock.versions().isEmpty()) {
        throw new IOException("Invalid input lock: " + lockFile);
      }
      return new ProjectContext(normalized, local, lock);
    }
  }

  Path projectDir() {
    return projectDir;
  }

  Path modkitRoot() {
    return projectDir.getParent();
  }

  Path buildDir() {
    return projectDir.resolve("build");
  }

  Path gameRoot() {
    return requiredPath("game.root");
  }

  Path java8Executable() {
    return requiredPath("java8.executable");
  }

  Path input(String version) {
    return requiredPath("brasfoot." + version);
  }

  InputLock inputLock() {
    return inputLock;
  }

  Path normalizedGameJar() {
    return buildDir().resolve("work/normalized/bf22-23.jar");
  }

  Path namedGameJar() {
    return buildDir().resolve("work/named/bf22-23-named.jar");
  }

  Path mappingsFile() {
    return projectDir.resolve("mappings/brasfoot-22-23.tiny");
  }

  Path recoveredClassesDir() {
    return buildDir().resolve("classes/java/recovered");
  }

  Path extensionClassesDir() {
    return buildDir().resolve("classes/java/extension");
  }

  Path hybridRoot() {
    return modkitRoot().resolve("build/Brasfoot22-23_hybrid");
  }

  Path hybridJar() {
    return hybridRoot().resolve("brasfoot-hybrid.jar");
  }

  Path reportsDir() {
    return buildDir().resolve("reports");
  }

  Path referenceSaveDir() {
    return projectDir.resolve("fixtures/local/career-reference");
  }

  Path referenceSaveManifest() {
    return projectDir.resolve("fixtures/save-reference.json");
  }

  Path serializationContractsFile() {
    return projectDir.resolve("config/serialization-contracts.json");
  }

  Map<String, String> promotions() throws IOException {
    return readStringMap(projectDir.resolve("config/promotions.json"));
  }

  SemanticNames semanticNames() throws IOException {
    Path path = projectDir.resolve("config/semantic-names.json");
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      SemanticNames value = JSON.fromJson(reader, SemanticNames.class);
      if (value == null) {
        return new SemanticNames(Map.of(), List.of(), List.of());
      }
      SemanticNames base = new SemanticNames(
          value.classes() == null ? Map.of() : value.classes(),
          value.fields() == null ? List.of() : value.fields(),
          value.methods() == null ? List.of() : value.methods());
      return mergeAutomaticSemanticNames(base);
    }
  }

  private SemanticNames mergeAutomaticSemanticNames(SemanticNames base) throws IOException {
    Path automaticPath = projectDir.resolve("config/semantic-auto-names.json");
    if (!Files.isRegularFile(automaticPath)) {
      return base;
    }
    AutomaticSemanticNames automatic;
    try (Reader reader = Files.newBufferedReader(automaticPath, StandardCharsets.UTF_8)) {
      automatic = JSON.fromJson(reader, AutomaticSemanticNames.class);
    }
    if (automatic == null) {
      return base;
    }

    List<FieldSemanticName> fields = new ArrayList<>(base.fields());
    List<MethodSemanticName> methods = new ArrayList<>(base.methods());
    Map<String, String> fieldNames = new HashMap<>();
    Map<String, String> methodNames = new HashMap<>();
    for (FieldSemanticName field : fields) {
      fieldNames.put(fieldKey(field), field.named());
    }
    for (MethodSemanticName method : methods) {
      methodNames.put(methodKey(method), method.named());
    }
    for (FieldSemanticName field : automatic.fields() == null
        ? List.<FieldSemanticName>of() : automatic.fields()) {
      mergeSemanticName(fields, fieldNames, fieldKey(field), field.named(), field);
    }
    for (MethodSemanticName method : automatic.methods() == null
        ? List.<MethodSemanticName>of() : automatic.methods()) {
      mergeSemanticName(methods, methodNames, methodKey(method), method.named(), method);
    }
    return new SemanticNames(base.classes(), List.copyOf(fields), List.copyOf(methods));
  }

  private <T> void mergeSemanticName(
      List<T> target, Map<String, String> names, String key, String named, T value) {
    String previous = names.putIfAbsent(key, named);
    if (previous == null) {
      target.add(value);
    } else if (!previous.equals(named)) {
      throw new IllegalStateException(
          "Conflicting base and automatic semantic names for " + key
              + ": " + previous + " != " + named);
    }
  }

  private String fieldKey(FieldSemanticName field) {
    return field.owner() + ":" + field.name() + ":" + field.descriptor();
  }

  private String methodKey(MethodSemanticName method) {
    return method.owner() + ":" + method.name() + ":" + method.descriptor();
  }

  void writeJson(Path path, Object value) throws IOException {
    Files.createDirectories(path.getParent());
    Files.writeString(path, JSON.toJson(value) + System.lineSeparator(), StandardCharsets.UTF_8);
  }

  private Path requiredPath(String key) {
    String value = local.getProperty(key);
    if (value == null || value.isBlank()) {
      throw new IllegalStateException("Missing local property: " + key);
    }
    return Path.of(value).toAbsolutePath().normalize();
  }

  @SuppressWarnings("unchecked")
  private Map<String, String> readStringMap(Path path) throws IOException {
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      Map<String, String> value = JSON.fromJson(reader, LinkedHashMap.class);
      return value == null ? Map.of() : value;
    }
  }

  record InputLock(int schemaVersion, List<VersionSpec> versions) {
  }

  record VersionSpec(
      String id,
      String fileName,
      long size,
      String sha256,
      int entries,
      int classes,
      int javaMajor,
      String mainClass) {
  }

  record SemanticNames(
      Map<String, String> classes,
      List<FieldSemanticName> fields,
      List<MethodSemanticName> methods) {
  }

  record FieldSemanticName(String owner, String name, String descriptor, String named) {
  }

  record MethodSemanticName(String owner, String name, String descriptor, String named) {
  }

  record AutomaticSemanticNames(
      int schemaVersion,
      List<FieldSemanticName> fields,
      List<MethodSemanticName> methods) {
  }
}
