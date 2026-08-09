package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import com.brasfoot.reconstruction.ArchiveService.ClassInfo;
import com.brasfoot.reconstruction.ClassStructuralComparator.Comparison;
import com.brasfoot.reconstruction.ClassStructuralComparator.Snapshot;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class ReferenceVariantAnalysisService {
  private final ProjectContext context;
  private final ArchiveService archives = new ArchiveService();

  ReferenceVariantAnalysisService(ProjectContext context) {
    this.context = context;
  }

  void build() throws IOException {
    AnalysisReport report = analyze();
    context.writeJson(context.reportsDir().resolve("reference-variants.json"), report);
    writeMarkdown(report, context.modkitRoot().resolve("docs/REFERENCE_VARIANTS.md"));
    long available = report.variants().stream().filter(VariantReport::available).count();
    int behaviorDeltas = report.variants().stream()
        .mapToInt(value -> value.behaviorChangedClasses() + value.apiChangedClasses()).sum();
    System.out.println("Analyzed " + available + "/" + report.variants().size()
        + " reference variants; " + behaviorDeltas
        + " classes contain structural or behavioral deltas.");
  }

  AnalysisReport analyze() throws IOException {
    VariantConfig config = readConfig();
    ArchiveData baseline = archives.analyze(context.input("22-23"));
    Map<String, byte[]> baselineEntries = ZipSupport.readEntries(context.input("22-23"));
    List<VariantReport> reports = new ArrayList<>();
    for (VariantSpec variant : config.variants()) {
      reports.add(analyzeVariant(baseline, baselineEntries, variant));
    }
    reports.sort(Comparator.comparing(VariantReport::id));
    return new AnalysisReport(
        1, baseline.sha256(), baseline.classes().size(), List.copyOf(reports));
  }

  private VariantReport analyzeVariant(
      ArchiveData baseline,
      Map<String, byte[]> baselineEntries,
      VariantSpec spec) throws IOException {
    Path path = context.optionalPath(spec.localProperty());
    if (path == null || !Files.isRegularFile(path)) {
      return VariantReport.unavailable(spec, path == null
          ? "local property is not configured" : "configured archive does not exist");
    }

    String actualHash = Hashing.sha256(path);
    if (!actualHash.equalsIgnoreCase(spec.sha256())) {
      throw new IOException("Reference variant hash mismatch for " + spec.id()
          + ": expected " + spec.sha256() + " but found " + actualHash);
    }
    ArchiveData candidate = archives.analyze(path);
    if (candidate.classes().size() != spec.expectedClasses()) {
      throw new IOException("Reference variant class count mismatch for " + spec.id()
          + ": expected " + spec.expectedClasses() + " but found "
          + candidate.classes().size());
    }
    Map<String, byte[]> candidateEntries = ZipSupport.readEntries(path);
    Map<String, String> relocations = spec.relocations() == null
        ? Map.of() : new TreeMap<>(spec.relocations());

    Map<String, String> canonicalToCandidate = new TreeMap<>();
    for (String candidateName : candidate.classes().keySet()) {
      String canonical = relocations.getOrDefault(candidateName, candidateName);
      String previous = canonicalToCandidate.putIfAbsent(canonical, candidateName);
      if (previous != null) {
        throw new IOException("Reference variant " + spec.id()
            + " maps multiple classes to " + canonical + ": " + previous
            + " and " + candidateName);
      }
    }

    int binaryIdentical = 0;
    int structurallyEquivalent = 0;
    int behaviorChanged = 0;
    int apiChanged = 0;
    List<ClassDelta> deltas = new ArrayList<>();
    for (Map.Entry<String, String> match : canonicalToCandidate.entrySet()) {
      ClassInfo baselineClass = baseline.classes().get(match.getKey());
      if (baselineClass == null) {
        continue;
      }
      ClassInfo candidateClass = candidate.classes().get(match.getValue());
      if (match.getKey().equals(match.getValue())
          && baselineClass.sha256().equals(candidateClass.sha256())) {
        binaryIdentical++;
        continue;
      }

      Comparison comparison = ClassStructuralComparator.compare(
          requireClass(baselineEntries, match.getKey()),
          requireClass(candidateEntries, match.getValue()),
          relocations);
      String classification;
      if (comparison.behaviorEquivalent()) {
        classification = "structurally-equivalent";
        structurallyEquivalent++;
      } else if (comparison.apiEquivalent()) {
        classification = "behavior-changed";
        behaviorChanged++;
      } else {
        classification = "api-changed";
        apiChanged++;
      }
      deltas.add(new ClassDelta(
          match.getKey(),
          match.getValue(),
          classification,
          baselineClass.javaMajor(),
          candidateClass.javaMajor(),
          comparison.addedMembers(),
          comparison.removedMembers(),
          comparison.changedFields(),
          comparison.changedMethods(),
          comparison.addedStrings(),
          comparison.removedStrings(),
          comparison.candidateReferences()));
    }
    deltas.sort(Comparator.comparing(ClassDelta::officialName));

    Set<String> addedNames = new TreeSet<>(canonicalToCandidate.keySet());
    addedNames.removeAll(baseline.classes().keySet());
    Set<String> removedNames = new TreeSet<>(baseline.classes().keySet());
    removedNames.removeAll(canonicalToCandidate.keySet());
    List<AddedClass> additions = describeAdditions(
        addedNames, canonicalToCandidate, candidateEntries, relocations);

    VariantReport report = new VariantReport(
        spec.id(),
        spec.purpose(),
        spec.localProperty(),
        true,
        null,
        path.toString(),
        actualHash,
        candidate.classes().size(),
        relocations.size(),
        binaryIdentical,
        structurallyEquivalent,
        behaviorChanged,
        apiChanged,
        List.copyOf(addedNames),
        List.copyOf(removedNames),
        List.copyOf(deltas),
        additions);
    validateExpectedAnalysis(spec, report);
    return report;
  }

  private void validateExpectedAnalysis(VariantSpec spec, VariantReport report)
      throws IOException {
    ExpectedAnalysis expected = spec.expectedAnalysis();
    if (expected == null) {
      return;
    }
    Map<String, Object> mismatches = new LinkedHashMap<>();
    compareExpected(mismatches, "binaryIdenticalClasses",
        expected.binaryIdenticalClasses(), report.binaryIdenticalClasses());
    compareExpected(mismatches, "structurallyEquivalentClasses",
        expected.structurallyEquivalentClasses(), report.structurallyEquivalentClasses());
    compareExpected(mismatches, "behaviorChangedClasses",
        expected.behaviorChangedClasses(), report.behaviorChangedClasses());
    compareExpected(mismatches, "apiChangedClasses",
        expected.apiChangedClasses(), report.apiChangedClasses());
    compareExpected(mismatches, "addedClasses",
        sorted(expected.addedClasses()), report.addedClasses());
    compareExpected(mismatches, "removedClasses",
        sorted(expected.removedClasses()), report.removedClasses());
    if (!mismatches.isEmpty()) {
      throw new IOException("Reference variant analysis changed for " + spec.id()
          + ": " + mismatches);
    }
  }

  private void compareExpected(
      Map<String, Object> mismatches, String name, Object expected, Object actual) {
    if (!expected.equals(actual)) {
      mismatches.put(name, Map.of("expected", expected, "actual", actual));
    }
  }

  private List<String> sorted(List<String> values) {
    return values == null ? List.of() : values.stream().sorted().toList();
  }

  private List<AddedClass> describeAdditions(
      Set<String> addedNames,
      Map<String, String> canonicalToCandidate,
      Map<String, byte[]> candidateEntries,
      Map<String, String> relocations) throws IOException {
    Map<String, Snapshot> snapshots = new TreeMap<>();
    for (Map.Entry<String, String> entry : canonicalToCandidate.entrySet()) {
      snapshots.put(entry.getKey(), ClassStructuralComparator.snapshot(
          requireClass(candidateEntries, entry.getValue()), relocations));
    }
    List<AddedClass> additions = new ArrayList<>();
    for (String addedName : addedNames) {
      Snapshot snapshot = snapshots.get(addedName);
      List<String> referencedBy = snapshots.entrySet().stream()
          .filter(value -> !value.getKey().equals(addedName))
          .filter(value -> value.getValue().references().contains(addedName))
          .map(Map.Entry::getKey)
          .sorted()
          .toList();
      additions.add(new AddedClass(
          addedName,
          snapshot.header().superName(),
          snapshot.header().interfaces(),
          List.copyOf(snapshot.declarations()),
          List.copyOf(snapshot.strings()),
          referencedBy));
    }
    return List.copyOf(additions);
  }

  private byte[] requireClass(Map<String, byte[]> entries, String internalName)
      throws IOException {
    byte[] bytes = entries.get(internalName + ".class");
    if (bytes == null) {
      throw new IOException("Class entry not found: " + internalName);
    }
    return bytes;
  }

  private VariantConfig readConfig() throws IOException {
    try (Reader reader = Files.newBufferedReader(
        context.referenceVariantsFile(), StandardCharsets.UTF_8)) {
      VariantConfig config = ProjectContext.JSON.fromJson(reader, VariantConfig.class);
      if (config == null || config.variants() == null) {
        throw new IOException("Invalid reference variant configuration: "
            + context.referenceVariantsFile());
      }
      return config;
    }
  }

  private void writeMarkdown(AnalysisReport report, Path output) throws IOException {
    StringBuilder markdown = new StringBuilder();
    markdown.append("# Variantes De Referencia\n\n")
        .append("Comparacao estrutural deterministica contra o Brasfoot 22/23. ")
        .append("Renomeacoes conhecidas sao normalizadas antes da comparacao de bytecode.\n\n");
    for (VariantReport variant : report.variants()) {
      markdown.append("## ").append(variant.id()).append("\n\n");
      if (!variant.available()) {
        markdown.append("- Indisponivel localmente: ").append(variant.message())
            .append(".\n\n");
        continue;
      }
      markdown.append("- Classes: ").append(variant.classes()).append(".\n")
          .append("- Binariamente identicas: ").append(variant.binaryIdenticalClasses())
          .append(".\n")
          .append("- Estruturalmente equivalentes apos normalizacao: ")
          .append(variant.structurallyEquivalentClasses()).append(".\n")
          .append("- Com mudanca de comportamento: ")
          .append(variant.behaviorChangedClasses()).append(".\n")
          .append("- Com mudanca de API: ").append(variant.apiChangedClasses()).append(".\n")
          .append("- Classes adicionadas: ")
          .append(variant.addedClasses().isEmpty() ? "nenhuma"
              : String.join(", ", variant.addedClasses())).append(".\n")
          .append("- Classes removidas: ")
          .append(variant.removedClasses().isEmpty() ? "nenhuma"
              : String.join(", ", variant.removedClasses())).append(".\n\n");
      if (!variant.additions().isEmpty()) {
        markdown.append("### Integracoes Novas\n\n")
            .append("| Classe | Superclasse | Referenciada por | Sinais |\n")
            .append("|---|---|---|---|\n");
        for (AddedClass addition : variant.additions()) {
          markdown.append("|`").append(addition.name()).append("`|`")
              .append(addition.superName()).append("`|")
              .append(String.join(", ", addition.referencedBy())).append("|")
              .append(String.join(", ", addition.strings().stream().limit(5).toList()))
              .append("|\n");
        }
        markdown.append('\n');
      }
      List<ClassDelta> meaningful = variant.deltas().stream()
          .filter(value -> !"structurally-equivalent".equals(value.classification()))
          .toList();
      if (!meaningful.isEmpty()) {
        markdown.append("### Alteracoes Reais\n\n")
            .append("| Classe | Tipo | Metodos | Campos | API + | API - |\n")
            .append("|---|---|---:|---:|---:|---:|\n");
        for (ClassDelta delta : meaningful) {
          markdown.append("|`").append(delta.officialName()).append("`|")
              .append(delta.classification()).append("|")
              .append(delta.changedMethods().size()).append("|")
              .append(delta.changedFields().size()).append("|")
              .append(delta.addedMembers().size()).append("|")
              .append(delta.removedMembers().size()).append("|\n");
        }
        markdown.append('\n');
      }
    }
    Files.createDirectories(output.getParent());
    Files.writeString(output, markdown.toString().stripTrailing() + "\n",
        StandardCharsets.UTF_8);
  }

  record VariantConfig(int schemaVersion, List<VariantSpec> variants) {
  }

  record VariantSpec(
      String id,
      String localProperty,
      String sha256,
      int expectedClasses,
      String purpose,
      ExpectedAnalysis expectedAnalysis,
      Map<String, String> relocations) {
  }

  record ExpectedAnalysis(
      int binaryIdenticalClasses,
      int structurallyEquivalentClasses,
      int behaviorChangedClasses,
      int apiChangedClasses,
      List<String> addedClasses,
      List<String> removedClasses) {
  }

  record AnalysisReport(
      int schemaVersion,
      String baselineSha256,
      int baselineClasses,
      List<VariantReport> variants) {
  }

  record VariantReport(
      String id,
      String purpose,
      String localProperty,
      boolean available,
      String message,
      String localPath,
      String sha256,
      int classes,
      int normalizedRelocations,
      int binaryIdenticalClasses,
      int structurallyEquivalentClasses,
      int behaviorChangedClasses,
      int apiChangedClasses,
      List<String> addedClasses,
      List<String> removedClasses,
      List<ClassDelta> deltas,
      List<AddedClass> additions) {
    static VariantReport unavailable(VariantSpec spec, String message) {
      return new VariantReport(
          spec.id(), spec.purpose(), spec.localProperty(), false, message,
          null, spec.sha256(), 0,
          spec.relocations() == null ? 0 : spec.relocations().size(),
          0, 0, 0, 0, List.of(), List.of(), List.of(), List.of());
    }
  }

  record ClassDelta(
      String officialName,
      String variantName,
      String classification,
      int baselineJavaMajor,
      int variantJavaMajor,
      List<String> addedMembers,
      List<String> removedMembers,
      List<String> changedFields,
      List<String> changedMethods,
      List<String> addedStrings,
      List<String> removedStrings,
      List<String> references) {
  }

  record AddedClass(
      String name,
      String superName,
      List<String> interfaces,
      List<String> declarations,
      List<String> strings,
      List<String> referencedBy) {
  }
}
