package com.brasfoot.reconstruction.agent;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import mod.extension.state.Feature;
import mod.extension.state.FeatureRegistry;
import mod.extension.state.ModState;
import mod.extension.state.ModStateStore;

public final class ModStateCompatibilityProbe {
  private ModStateCompatibilityProbe() {
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      throw new IllegalArgumentException("Usage: ModStateCompatibilityProbe <work-directory>");
    }
    Path root = Paths.get(args[0]);
    Files.createDirectories(root);
    ModStateStore store = new ModStateStore();

    Path currentSave = createSave(root, "current.s22");
    ModStateStore.LoadResult missing = store.load(currentSave);
    assertStatus(missing, ModStateStore.LoadStatus.MISSING);
    FeatureRegistry registry = FeatureRegistry.from(missing.getState());
    for (Feature feature : Feature.values()) {
      if (registry.isEnabled(feature)) {
        throw new IllegalStateException("Feature enabled without an override: " + feature);
      }
    }
    registry.setEnabled(Feature.BOARD_OBJECTIVES, true);
    Map<String, Object> board = new LinkedHashMap<String, Object>();
    board.put("club", "S\u00e3o Paulo");
    board.put("targetPoints", Integer.valueOf(72));
    ModState state = registry.applyTo(missing.getState())
        .withModule("boardObjectives", board);
    ModStateStore.LoadResult saved = store.save(currentSave, missing, state);
    assertStatus(saved, ModStateStore.LoadStatus.LOADED);
    if (saved.getState().getRevision() != 1L) {
      throw new IllegalStateException("First persisted revision was not 1");
    }
    ModStateStore.LoadResult current = store.load(currentSave);
    assertStatus(current, ModStateStore.LoadStatus.LOADED);
    if (!FeatureRegistry.from(current.getState()).isEnabled(Feature.BOARD_OBJECTIVES)
        || !"S\u00e3o Paulo".equals(
            current.getState().getModule("boardObjectives").get("club"))) {
      throw new IllegalStateException("Current mod state changed during JSON round-trip");
    }

    Path corruptSave = createSave(root, "corrupt.s22");
    Path corruptSidecar = store.sidecarFor(corruptSave);
    byte[] corruptBytes = "{broken".getBytes(StandardCharsets.UTF_8);
    Files.write(corruptSidecar, corruptBytes);
    ModStateStore.LoadResult corrupt = store.load(corruptSave);
    assertStatus(corrupt, ModStateStore.LoadStatus.CORRUPT);
    assertRefusesSave(store, corruptSave, corrupt);
    if (!java.util.Arrays.equals(corruptBytes, Files.readAllBytes(corruptSidecar))) {
      throw new IllegalStateException("Corrupt sidecar was modified");
    }

    Path legacySave = createSave(root, "legacy.s22");
    String legacyJson = "{\"schemaVersion\":0,\"revision\":3,"
        + "\"enabledFeatures\":[\"sponsorships\"],"
        + "\"data\":{\"sponsorships\":{\"monthlyPayment\":125000}}}";
    Files.write(store.sidecarFor(legacySave), legacyJson.getBytes(StandardCharsets.UTF_8));
    ModStateStore.LoadResult migrated = store.load(legacySave);
    assertStatus(migrated, ModStateStore.LoadStatus.MIGRATED);
    if (!FeatureRegistry.from(migrated.getState()).isEnabled(Feature.SPONSORSHIPS)
        || migrated.getState().getRevision() != 3L) {
      throw new IllegalStateException("Legacy sidecar migration lost state");
    }
    ModStateStore.LoadResult upgraded = store.save(legacySave, migrated, migrated.getState());
    if (upgraded.getState().getRevision() != 4L
        || store.load(legacySave).getStatus() != ModStateStore.LoadStatus.LOADED) {
      throw new IllegalStateException("Migrated sidecar was not upgraded");
    }

    Path futureSave = createSave(root, "future.s22");
    String futureJson = "{\"schemaVersion\":2,"
        + "\"features\":{\"sponsorships\":true}}";
    Files.write(store.sidecarFor(futureSave), futureJson.getBytes(StandardCharsets.UTF_8));
    ModStateStore.LoadResult future = store.load(futureSave);
    assertStatus(future, ModStateStore.LoadStatus.UNSUPPORTED);
    assertRefusesSave(store, futureSave, future);

    try (java.util.stream.Stream<Path> files = Files.list(root)) {
      if (files.anyMatch(path -> path.getFileName().toString().endsWith(".tmp"))) {
        throw new IllegalStateException("Atomic save left a temporary file behind");
      }
    }
    System.out.println("MOD_STATE_API missing=true current=true corrupt=true migrated=true "
        + "unsupported=true atomic=true revision=true utf8=true defaultsDisabled=true");
  }

  private static Path createSave(Path root, String name) throws Exception {
    Path save = root.resolve(name);
    Files.write(save, new byte[]{1, 2, 3});
    return save;
  }

  private static void assertStatus(
      ModStateStore.LoadResult result, ModStateStore.LoadStatus expected) {
    if (result.getStatus() != expected) {
      throw new IllegalStateException(
          "Expected " + expected + " mod state, got " + result.getStatus());
    }
  }

  private static void assertRefusesSave(
      ModStateStore store, Path save, ModStateStore.LoadResult result) throws Exception {
    try {
      store.save(save, result, result.getState());
      throw new IllegalStateException("Unsafe mod state overwrite was accepted");
    } catch (IllegalStateException expected) {
      if (expected.getMessage().contains("Unsafe mod state overwrite")) {
        throw expected;
      }
    }
  }
}
