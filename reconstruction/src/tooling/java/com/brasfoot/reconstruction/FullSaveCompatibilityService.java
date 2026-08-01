package com.brasfoot.reconstruction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class FullSaveCompatibilityService {
  private static final List<String> REQUIRED_MODELS = List.of(
      "best.F", "best.ah", "best.al", "best.C", "best.v");

  private final ProjectContext context;

  FullSaveCompatibilityService(ProjectContext context) {
    this.context = context;
  }

  void verify() throws Exception {
    new SaveFixtureService(context).verify();
    Path probeJar = context.buildDir().resolve("libs/brasfoot-runtime-probe.jar");
    Path embeddedDirectory = context.buildDir().resolve("work/embedded-libs");
    if (!Files.isRegularFile(probeJar) || !Files.isDirectory(embeddedDirectory)) {
      throw new IOException("Kryo compatibility runtime is not assembled");
    }
    List<Path> libraries;
    try (var paths = Files.list(embeddedDirectory)) {
      libraries = paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".jar"))
          .sorted(Comparator.comparing(path -> path.getFileName().toString()))
          .toList();
    }
    if (libraries.size() != 4) {
      throw new IllegalStateException("Expected four embedded Kryo libraries, got "
          + libraries.size());
    }

    List<String> classpath = new ArrayList<>();
    classpath.add(probeJar.toString());
    libraries.forEach(path -> classpath.add(path.toString()));
    Path output = context.reportsDir().resolve("full-save-compatibility.log");
    TreeSet<String> targets = recoveredSerializableClasses();
    List<String> command = new ArrayList<>();
    command.add(context.java8Executable().toString());
    command.add("-cp");
    command.add(String.join(File.pathSeparator, classpath));
    command.add("com.brasfoot.reconstruction.agent.KryoSaveCompatibilityProbe");
    command.add(context.hybridJar().toString());
    command.add(context.referenceSaveDir().resolve("reference.s22").toString());
    command.addAll(targets);
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.redirectErrorStream(true);
    builder.redirectOutput(output.toFile());
    Process process = builder.start();
    if (!process.waitFor(90, java.util.concurrent.TimeUnit.SECONDS)) {
      process.destroyForcibly();
      throw new IllegalStateException("Full save compatibility probe timed out");
    }
    String log = Files.readString(output, StandardCharsets.UTF_8);
    if (process.exitValue() != 0) {
      throw new IllegalStateException("Full save compatibility probe failed:\n" + log);
    }
    for (String model : REQUIRED_MODELS) {
      int count = readCount(log, model);
      if (count <= 0) {
        throw new IllegalStateException("Reference save does not contain recovered model " + model);
      }
    }
    if (!log.contains("ROOT best.f AUX best.ay") || !log.contains("ROUNDTRIP ")) {
      throw new IllegalStateException("Full save did not complete a Kryo round-trip:\n" + log);
    }
    System.out.println("Full save compatibility passed on Java 8: Kryo loaded and rewrote the "
        + "complete reference career with recovered Player, Club, Coach, finances and stadium.");
  }

  private TreeSet<String> recoveredSerializableClasses() throws IOException {
    ArchiveService.ArchiveData original = new ArchiveService().analyze(context.normalizedGameJar());
    Map<String, byte[]> hybridEntries = ZipSupport.readEntries(context.hybridJar());
    Map<String, byte[]> originalEntries = ZipSupport.readEntries(context.normalizedGameJar());
    TreeSet<String> classes = new TreeSet<>();
    for (ArchiveService.ClassInfo info : original.classes().values()) {
      if (!info.interfaces().contains("java/io/Serializable")) {
        continue;
      }
      String entry = info.name() + ".class";
      byte[] originalBytes = originalEntries.get(entry);
      byte[] hybridBytes = hybridEntries.get(entry);
      if (originalBytes != null && hybridBytes != null
          && !Hashing.sha256(originalBytes).equals(Hashing.sha256(hybridBytes))) {
        classes.add(info.name().replace('/', '.'));
      }
    }
    return classes;
  }

  private int readCount(String log, String model) {
    String prefix = "COUNT " + model + " ";
    for (String line : log.split("\\R")) {
      if (line.startsWith(prefix)) {
        return Integer.parseInt(line.substring(prefix.length()).trim());
      }
    }
    return -1;
  }
}
