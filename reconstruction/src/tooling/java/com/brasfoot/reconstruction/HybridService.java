package com.brasfoot.reconstruction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class HybridService {
  static final String ORIGINAL_COMPONENT = "components/ar.class";

  private final ProjectContext context;
  private final RemapService remapper;

  HybridService(ProjectContext context) {
    this.context = context;
    this.remapper = new RemapService(context);
  }

  void assemble() throws IOException {
    Path officialRecovered = context.buildDir().resolve("work/recovered/recovered-official.jar");
    remapper.remapRecoveredToOfficial(officialRecovered);

    Map<String, byte[]> originalEntries = ZipSupport.readEntries(context.normalizedGameJar());
    Map<String, byte[]> recoveredEntries = ZipSupport.readEntries(officialRecovered);
    recoveredEntries.entrySet().removeIf(entry -> !entry.getKey().endsWith(".class"));
    if (!recoveredEntries.containsKey(ORIGINAL_COMPONENT)) {
      throw new IllegalStateException("Recovered overlay does not contain " + ORIGINAL_COMPONENT);
    }

    List<OverlayEntry> overlays = new ArrayList<>();
    for (Map.Entry<String, byte[]> entry : new TreeMap<>(recoveredEntries).entrySet()) {
      byte[] original = originalEntries.get(entry.getKey());
      overlays.add(new OverlayEntry(
          entry.getKey(),
          original == null ? null : Hashing.sha256(original),
          Hashing.sha256(entry.getValue()),
          original == null));
    }

    Path hybridRoot = context.hybridRoot();
    ZipSupport.copyGameTree(context.gameRoot(), hybridRoot, "bf22-23.exe");
    ZipSupport.overlay(context.normalizedGameJar(), officialRecovered, context.hybridJar());

    Map<String, byte[]> hybridEntries = ZipSupport.readEntries(context.hybridJar());
    int unchanged = 0;
    for (Map.Entry<String, byte[]> original : originalEntries.entrySet()) {
      if (recoveredEntries.containsKey(original.getKey())) {
        continue;
      }
      byte[] hybrid = hybridEntries.get(original.getKey());
      if (hybrid == null || !Hashing.sha256(original.getValue()).equals(Hashing.sha256(hybrid))) {
        throw new IllegalStateException("Non-overlay entry changed: " + original.getKey());
      }
      unchanged++;
    }

    context.writeJson(hybridRoot.resolve("overlay-manifest.json"),
        new OverlayManifest(
            1,
            Hashing.sha256(context.input("22-23")),
            Hashing.sha256(context.hybridJar()),
            originalEntries.size(),
            unchanged,
            overlays));
    writeLauncher(hybridRoot.resolve("run-hybrid.cmd"));
    System.out.println("Hybrid build assembled with " + overlays.size() + " source overlays; "
        + unchanged + " entries remained byte-identical.");
  }

  private void writeLauncher(Path output) throws IOException {
    String java = context.java8Executable().toString();
    String script = "@echo off\r\n"
        + "cd /d \"%~dp0\"\r\n"
        + "\"" + java + "\" -jar brasfoot-hybrid.jar\r\n";
    Files.writeString(output, script, StandardCharsets.US_ASCII);
  }

  record OverlayManifest(
      int schemaVersion,
      String sourceExecutableSha256,
      String hybridJarSha256,
      int originalEntries,
      int unchangedEntries,
      List<OverlayEntry> overlays) {
  }

  record OverlayEntry(
      String entry,
      String originalSha256,
      String replacementSha256,
      boolean added) {
  }
}
