package com.brasfoot.reconstruction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import net.fabricmc.tinyremapper.NonClassCopyMode;
import net.fabricmc.tinyremapper.OutputConsumerPath;
import net.fabricmc.tinyremapper.TinyRemapper;
import net.fabricmc.tinyremapper.TinyUtils;

final class RemapService {
  private final ProjectContext context;

  RemapService(ProjectContext context) {
    this.context = context;
  }

  void remapGameToNamed() throws IOException {
    remap(
        context.normalizedGameJar(),
        context.namedGameJar(),
        "official",
        "named",
        null,
        true);
    System.out.println("Remapped original game to named development namespace.");
  }

  void remapRecoveredToOfficial(Path output) throws IOException {
    Path namedInput = context.buildDir().resolve("work/recovered/recovered-named.jar");
    ZipSupport.jarDirectory(context.recoveredClassesDir(), namedInput);
    new SyntheticMemberService(context).markConfiguredMethods(namedInput);
    remap(namedInput, output, "named", "official", context.namedGameJar(), false);
  }

  void remapNamedGameToOfficial(Path output) throws IOException {
    remap(context.namedGameJar(), output, "named", "official", null, true);
  }

  private void remap(
      Path input,
      Path output,
      String fromNamespace,
      String toNamespace,
      Path classpath,
      boolean copyResources) throws IOException {
    if (!Files.isRegularFile(input)) {
      throw new IOException("Remap input not found: " + input);
    }
    if (!Files.isRegularFile(context.mappingsFile())) {
      throw new IOException("Mappings not found: " + context.mappingsFile());
    }
    Files.createDirectories(output.toAbsolutePath().getParent());
    Files.deleteIfExists(output);

    TinyRemapper remapper = TinyRemapper.newRemapper()
        .withMappings(TinyUtils.createTinyMappingProvider(
            context.mappingsFile(), fromNamespace, toNamespace))
        .renameInvalidLocals(true)
        .rebuildSourceFilenames(true)
        .build();
    try (OutputConsumerPath consumer = new OutputConsumerPath.Builder(output).build()) {
      if (copyResources) {
        consumer.addNonClassFiles(input, NonClassCopyMode.FIX_META_INF, remapper);
      }
      if (classpath != null) {
        remapper.readClassPath(classpath);
      }
      remapper.readInputs(input);
      remapper.apply(consumer);
    } finally {
      remapper.finish();
    }
  }
}
