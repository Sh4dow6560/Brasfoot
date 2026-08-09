package com.brasfoot.reconstruction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

final class DifferentialTestService {
  private static final List<String> REQUIRED_SCENARIOS = List.of(
      "ROOT",
      "CALENDAR",
      "MATCH_EVENTS",
      "MATCH_EVENT_API",
      "MATCH_STATE",
      "MATCH_STATE_API",
      "SUBSTITUTION_API",
      "MATCH_ENGINE_API",
      "LINEUP_API",
      "CONTRACT_LOAN_API",
      "TRANSFER_NEGOTIATION_API",
      "AI_SQUAD_API",
      "COACH_CAREER_API",
      "PLAYER_SEARCH_API",
      "TRANSFER_HISTORY_API",
      "CLUB_FINANCES_API",
      "PLAYER_CLUB_API",
      "STADIUM_EXPANSION",
      "ROUNDTRIP");

  private final ProjectContext context;

  DifferentialTestService(ProjectContext context) {
    this.context = context;
  }

  void verify() throws Exception {
    new SaveFixtureService(context).verify();
    Path probeJar = context.buildDir().resolve("libs/brasfoot-runtime-probe.jar");
    List<Path> libraries = embeddedLibraries();
    if (!Files.isRegularFile(probeJar)) {
      throw new IOException("Differential runtime probe not found: " + probeJar);
    }

    TreeSet<String> targets = recoveredSerializableClasses();
    ProbeResult original = runProbe(
        "original", context.normalizedGameJar(), probeJar, libraries, targets);
    ProbeResult hybrid = runProbe(
        "hybrid", context.hybridJar(), probeJar, libraries, targets);
    List<ScenarioComparison> comparisons = compare(original.markers(), hybrid.markers());
    long mismatches = comparisons.stream().filter(result -> !result.identical()).count();

    DifferentialReport report = new DifferentialReport(
        1,
        Hashing.sha256(context.normalizedGameJar()),
        Hashing.sha256(context.hybridJar()),
        Hashing.sha256(context.referenceSaveDir().resolve("reference.s22")),
        targets.size(),
        comparisons.size(),
        (int)mismatches,
        comparisons);
    Path reportPath = context.reportsDir().resolve("differential-test.json");
    context.writeJson(reportPath, report);

    validateRequiredScenarios(original.markers(), "original");
    validateRequiredScenarios(hybrid.markers(), "hybrid");
    if (mismatches > 0) {
      StringBuilder message = new StringBuilder(
          "Differential test found " + mismatches + " behavioral difference(s):");
      comparisons.stream()
          .filter(result -> !result.identical())
          .limit(10)
          .forEach(result -> message.append(System.lineSeparator())
              .append(result.id()).append(": original=")
              .append(result.original()).append(" hybrid=").append(result.hybrid()));
      throw new IllegalStateException(message.toString());
    }

    System.out.println("Differential test passed on Java 8: " + comparisons.size()
        + " deterministic save and gameplay markers match the original runtime.");
  }

  private List<Path> embeddedLibraries() throws IOException {
    Path directory = context.buildDir().resolve("work/embedded-libs");
    if (!Files.isDirectory(directory)) {
      throw new IOException("Embedded runtime libraries not found: " + directory);
    }
    List<Path> libraries;
    try (var paths = Files.list(directory)) {
      libraries = paths.filter(Files::isRegularFile)
          .filter(path -> path.getFileName().toString().endsWith(".jar"))
          .sorted(Comparator.comparing(path -> path.getFileName().toString()))
          .toList();
    }
    if (libraries.size() != 4) {
      throw new IllegalStateException(
          "Expected four embedded Kryo libraries, got " + libraries.size());
    }
    return libraries;
  }

  private ProbeResult runProbe(
      String id,
      Path gameJar,
      Path probeJar,
      List<Path> libraries,
      TreeSet<String> targets) throws Exception {
    List<String> classpath = new ArrayList<>();
    classpath.add(probeJar.toString());
    libraries.forEach(path -> classpath.add(path.toString()));

    List<String> command = new ArrayList<>();
    command.add(context.java8Executable().toString());
    command.add("-cp");
    command.add(String.join(File.pathSeparator, classpath));
    command.add("com.brasfoot.reconstruction.agent.KryoSaveCompatibilityProbe");
    command.add(gameJar.toString());
    command.add(context.referenceSaveDir().resolve("reference.s22").toString());
    command.addAll(targets);

    Files.createDirectories(context.reportsDir());
    Path output = context.reportsDir().resolve("differential-" + id + ".log");
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.redirectErrorStream(true);
    builder.redirectOutput(output.toFile());
    Process process = builder.start();
    if (!process.waitFor(90, TimeUnit.SECONDS)) {
      process.destroyForcibly();
      throw new IllegalStateException("Differential " + id + " probe timed out");
    }
    String log = Files.readString(output, StandardCharsets.UTF_8);
    if (process.exitValue() != 0) {
      throw new IllegalStateException(
          "Differential " + id + " probe failed:" + System.lineSeparator() + log);
    }
    return new ProbeResult(parseMarkers(log));
  }

  private TreeSet<String> recoveredSerializableClasses() throws IOException {
    ArchiveService.ArchiveData original =
        new ArchiveService().analyze(context.normalizedGameJar());
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
    if (classes.isEmpty()) {
      throw new IllegalStateException("No recovered serializable classes to compare");
    }
    return classes;
  }

  private void validateRequiredScenarios(Map<String, String> markers, String runtime) {
    for (String scenario : REQUIRED_SCENARIOS) {
      if (!markers.containsKey(scenario)) {
        throw new IllegalStateException(
            "Differential " + runtime + " probe did not emit " + scenario);
      }
    }
    String roundTrip = markers.get("ROUNDTRIP");
    if (!roundTrip.contains("byteIdentical=true")) {
      throw new IllegalStateException(
          "Differential " + runtime + " save round-trip was not byte-identical: "
              + roundTrip);
    }
  }

  static Map<String, String> parseMarkers(String log) {
    Map<String, String> markers = new TreeMap<>();
    for (String rawLine : log.split("\\R")) {
      String line = rawLine.trim();
      String key = markerKey(line);
      if (key == null) {
        continue;
      }
      String previous = markers.putIfAbsent(key, line);
      if (previous != null) {
        throw new IllegalArgumentException("Duplicate differential marker: " + key);
      }
    }
    return new LinkedHashMap<>(markers);
  }

  private static String markerKey(String line) {
    if (line.startsWith("COUNT ")) {
      String[] parts = line.split("\\s+", 3);
      return parts.length == 3 ? "COUNT " + parts[1] : null;
    }
    int separator = line.indexOf(' ');
    String prefix = separator < 0 ? line : line.substring(0, separator);
    return REQUIRED_SCENARIOS.contains(prefix) ? prefix : null;
  }

  static List<ScenarioComparison> compare(
      Map<String, String> original, Map<String, String> hybrid) {
    TreeSet<String> keys = new TreeSet<>(original.keySet());
    keys.addAll(hybrid.keySet());
    List<ScenarioComparison> comparisons = new ArrayList<>();
    for (String key : keys) {
      String originalValue = original.get(key);
      String hybridValue = hybrid.get(key);
      comparisons.add(new ScenarioComparison(
          key,
          java.util.Objects.equals(originalValue, hybridValue),
          originalValue,
          hybridValue));
    }
    return List.copyOf(comparisons);
  }

  private record ProbeResult(Map<String, String> markers) {
  }

  record ScenarioComparison(String id, boolean identical, String original, String hybrid) {
  }

  record DifferentialReport(
      int schemaVersion,
      String originalJarSha256,
      String hybridJarSha256,
      String referenceSaveSha256,
      int serializableTargets,
      int comparedMarkers,
      int mismatches,
      List<ScenarioComparison> scenarios) {
  }
}
