package com.brasfoot.reconstruction;

import com.brasfoot.reconstruction.ArchiveService.ArchiveData;
import java.nio.file.Path;
import java.util.Map;

public final class ReconstructionTool {
  private ReconstructionTool() {
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      throw new IllegalArgumentException("Usage: ReconstructionTool <command> <project-directory>");
    }
    String command = args[0];
    ProjectContext context = ProjectContext.load(Path.of(args[1]));

    switch (command) {
      case "verify-inputs" -> new AtlasService(context).verifyInputs();
      case "normalize-game" -> normalizeGame(context);
      case "build-version-atlas" -> new AtlasService(context).buildVersionAtlas();
      case "capture-reference-save" -> new SaveFixtureService(context).capture();
      case "verify-reference-save" -> new SaveFixtureService(context).verify();
      case "build-serialization-atlas" -> new SerializationAtlasService(context).build();
      case "repair-decompiled-sources" -> new DecompiledSourceRepairService(context).repair();
      case "prepare-recovered-sources" -> new RecoveredSourcePreparationService(context).prepare();
      case "build-synthetic-compile-classpath" ->
          new SyntheticCompileClasspathService(context).build();
      case "analyze-candidate-compilation" -> new CandidateCompileService(context).analyze();
      case "promote-candidate-batch" -> new CandidatePromotionService(context).promote();
      case "generate-mappings" -> new MappingService(context).generate();
      case "remap-game" -> {
        new MappingService(context).validateExisting();
        new RemapService(context).remapGameToNamed();
      }
      case "assemble-hybrid" -> new HybridService(context).assemble();
      case "static-smoke" -> new SmokeService(context).staticSmoke();
      case "runtime-smoke" -> new SmokeService(context).runtimeSmoke();
      case "save-compatibility" -> new SaveCompatibilityService(context).verify();
      case "full-save-compatibility" -> new FullSaveCompatibilityService(context).verify();
      case "run-hybrid" -> new SmokeService(context).runHybrid();
      default -> throw new IllegalArgumentException("Unknown command: " + command);
    }
  }

  private static void normalizeGame(ProjectContext context) throws Exception {
    ZipSupport.normalize(context.input("22-23"), context.normalizedGameJar());
    Map<String, byte[]> source = ZipSupport.readEntries(context.input("22-23"));
    Map<String, byte[]> normalized = ZipSupport.readEntries(context.normalizedGameJar());
    if (!source.keySet().equals(normalized.keySet())) {
      throw new IllegalStateException("Normalized JAR entry set differs from executable");
    }
    for (Map.Entry<String, byte[]> entry : source.entrySet()) {
      byte[] copy = normalized.get(entry.getKey());
      if (!Hashing.sha256(entry.getValue()).equals(Hashing.sha256(copy))) {
        throw new IllegalStateException("Normalized entry differs: " + entry.getKey());
      }
    }
    ArchiveData data = new ArchiveService().analyze(context.normalizedGameJar());
    if (data.classes().size() != 1038 || !"best.h2".equals(data.mainClass())) {
      throw new IllegalStateException("Normalized JAR has unexpected structure");
    }
    context.writeJson(context.reportsDir().resolve("normalization.json"),
        new NormalizationReport(
            context.input("22-23").toString(),
            context.normalizedGameJar().toString(),
            source.size(),
            data.classes().size(),
            data.sha256()));
    System.out.println("Normalized Launch4j executable to a pure JAR with " + source.size()
        + " byte-identical entries.");
  }

  record NormalizationReport(
      String source, String output, int entries, int classes, String normalizedSha256) {
  }
}
