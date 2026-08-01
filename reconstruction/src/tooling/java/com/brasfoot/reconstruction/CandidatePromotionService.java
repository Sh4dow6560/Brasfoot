package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.CandidateCompileService.CandidateCompilationReport;
import com.brasfoot.reconstruction.CandidateCompileService.CandidateResult;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class CandidatePromotionService {
  private final ProjectContext context;

  CandidatePromotionService(ProjectContext context) {
    this.context = context;
  }

  void promote() throws IOException {
    PromotionBatch batch = readBatch();
    if (!batch.allCompileClean() && (batch.classes() == null || batch.classes().isEmpty())) {
      throw new IllegalStateException("Candidate promotion batch is empty");
    }
    CandidateCompilationReport report = readCandidateReport();
    Map<String, CandidateResult> results = new HashMap<>();
    for (CandidateResult result : report.results()) {
      results.put(result.source(), result);
    }
    Map<String, String> namedMappings = readNamedMappings();
    Map<String, String> promotions = new TreeMap<>(context.promotions());
    List<String> officialNames;
    if (batch.allCompileClean()) {
      List<String> excludedPrefixes = batch.excludedPrefixes() == null
          ? List.of() : batch.excludedPrefixes();
      officialNames = namedMappings.entrySet().stream()
          .filter(entry -> !promotions.containsKey(entry.getKey()))
          .filter(entry -> excludedPrefixes.stream()
              .noneMatch(prefix -> entry.getKey().startsWith(prefix)))
          .filter(entry -> {
            CandidateResult result = results.get(entry.getValue() + ".java");
            return result != null && result.success();
          })
          .map(Map.Entry::getKey)
          .sorted()
          .toList();
    } else {
      officialNames = batch.classes().stream().distinct().sorted().toList();
    }
    if (officialNames.isEmpty()) {
      throw new IllegalStateException("No compile-clean candidates remain for promotion");
    }

    for (String officialName : officialNames) {
      String namedName = namedMappings.get(officialName);
      if (namedName == null) {
        throw new IllegalStateException("No named mapping for candidate " + officialName);
      }
      String relativeSource = namedName + ".java";
      CandidateResult result = results.get(relativeSource);
      if (result == null || !result.success()) {
        throw new IllegalStateException("Candidate is not compile-clean: " + officialName
            + " (" + relativeSource + ")");
      }

      Path source = context.buildDir().resolve("generated/decompiled").resolve(relativeSource);
      Path target = context.projectDir().resolve("src/recovered/java").resolve(relativeSource);
      if (!Files.isRegularFile(source)) {
        throw new IOException("Candidate source not found: " + source);
      }
      if (Files.isRegularFile(target)) {
        if (!Hashing.sha256(source).equals(Hashing.sha256(target))) {
          throw new IllegalStateException("Refusing to overwrite reviewed source: " + target);
        }
      } else {
        Files.createDirectories(target.getParent());
        Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES);
      }
      promotions.put(officialName, "compile-clean");
    }

    context.writeJson(context.projectDir().resolve("config/promotions.json"), promotions);
    System.out.println("Promoted " + officialNames.size()
        + " compile-clean candidates into reviewed source.");
  }

  private PromotionBatch readBatch() throws IOException {
    Path path = context.projectDir().resolve("config/candidate-promotion-batch.json");
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      PromotionBatch batch = ProjectContext.JSON.fromJson(reader, PromotionBatch.class);
      if (batch == null) {
        throw new IOException("Invalid candidate promotion batch: " + path);
      }
      return batch;
    }
  }

  private CandidateCompilationReport readCandidateReport() throws IOException {
    Path path = context.reportsDir().resolve("candidate-compilation.json");
    try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
      CandidateCompilationReport report = ProjectContext.JSON.fromJson(
          reader, CandidateCompilationReport.class);
      if (report == null || report.results() == null) {
        throw new IOException("Invalid candidate compilation report: " + path);
      }
      return report;
    }
  }

  private Map<String, String> readNamedMappings() throws IOException {
    Map<String, String> mappings = new LinkedHashMap<>();
    for (String line : Files.readAllLines(context.mappingsFile(), StandardCharsets.UTF_8)) {
      if (!line.startsWith("c\t")) {
        continue;
      }
      String[] values = line.split("\t", -1);
      mappings.put(values[1], values[3]);
    }
    return mappings;
  }

  record PromotionBatch(
      boolean allCompileClean, List<String> excludedPrefixes, List<String> classes) {
  }
}
