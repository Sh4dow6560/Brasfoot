package mod.extension.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ModStateStoreTest {
  @TempDir
  Path directory;

  @Test
  void missingSidecarKeepsEveryFeatureDisabled() throws Exception {
    Path save = createSave("missing.s22");
    ModStateStore store = new ModStateStore();

    ModStateStore.LoadResult result = store.load(save);
    FeatureRegistry registry = FeatureRegistry.from(result.getState());

    assertEquals(ModStateStore.LoadStatus.MISSING, result.getStatus());
    assertFalse(Files.exists(result.getSidecar()));
    for (Feature feature : Feature.values()) {
      assertFalse(registry.isEnabled(feature));
    }
  }

  @Test
  void writesUtf8StateAtomicallyAndLoadsCurrentSchema() throws Exception {
    Path save = createSave("current.s22");
    ModStateStore store = new ModStateStore();
    ModStateStore.LoadResult baseline = store.load(save);
    FeatureRegistry registry = FeatureRegistry.from(baseline.getState());
    registry.setEnabled(Feature.BOARD_OBJECTIVES, true);
    registry.setEnabled("experimentalFixture", true);

    Map<String, Object> board = new LinkedHashMap<String, Object>();
    board.put("club", "S\u00e3o Paulo");
    board.put("targetPoints", Integer.valueOf(72));
    board.put("milestones", Arrays.asList("continental", "title"));
    ModState state = registry.applyTo(baseline.getState())
        .withModule("boardObjectives", board);

    ModStateStore.LoadResult saved = store.save(save, baseline, state);
    ModStateStore.LoadResult loaded = store.load(save);

    assertEquals(1L, saved.getState().getRevision());
    assertEquals(ModStateStore.LoadStatus.LOADED, loaded.getStatus());
    assertTrue(FeatureRegistry.from(loaded.getState()).isEnabled(Feature.BOARD_OBJECTIVES));
    assertTrue(FeatureRegistry.from(loaded.getState()).isEnabled("experimentalFixture"));
    assertEquals("S\u00e3o Paulo", loaded.getState().getModule("boardObjectives").get("club"));
    assertEquals(Long.valueOf(72L),
        loaded.getState().getModule("boardObjectives").get("targetPoints"));
    String json = new String(Files.readAllBytes(loaded.getSidecar()), StandardCharsets.UTF_8);
    assertTrue(json.contains("S\u00e3o Paulo"));
    assertTrue(json.contains("\"schemaVersion\":1"));

    assertThrows(IllegalStateException.class,
        () -> store.save(save, loaded, ModState.empty()));
    FeatureRegistry updatedRegistry = FeatureRegistry.from(loaded.getState());
    updatedRegistry.setEnabled(Feature.SPONSORSHIPS, true);
    ModStateStore.LoadResult updated = store.save(
        save, loaded, updatedRegistry.applyTo(loaded.getState()));
    assertEquals(2L, updated.getState().getRevision());
    assertTrue(FeatureRegistry.from(store.load(save).getState())
        .isEnabled(Feature.SPONSORSHIPS));

    try (java.util.stream.Stream<Path> files = Files.list(this.directory)) {
      assertFalse(files.anyMatch(path -> path.getFileName().toString().endsWith(".tmp")));
    }
  }

  @Test
  void corruptSidecarFallsBackAndCannotBeOverwritten() throws Exception {
    Path save = createSave("corrupt.s22");
    ModStateStore store = new ModStateStore();
    Path sidecar = store.sidecarFor(save);
    byte[] corrupt = "{not-json".getBytes(StandardCharsets.UTF_8);
    Files.write(sidecar, corrupt);

    ModStateStore.LoadResult result = store.load(save);

    assertEquals(ModStateStore.LoadStatus.CORRUPT, result.getStatus());
    assertNotNull(result.getWarning());
    assertFalse(FeatureRegistry.from(result.getState()).isEnabled(Feature.SPONSORSHIPS));
    assertThrows(IllegalStateException.class,
        () -> store.save(save, result, result.getState()));
    assertTrue(Arrays.equals(corrupt, Files.readAllBytes(sidecar)));
  }

  @Test
  void migratesSchemaZeroInMemoryThenPersistsCurrentSchema() throws Exception {
    Path save = createSave("legacy.s22");
    ModStateStore store = new ModStateStore();
    Path sidecar = store.sidecarFor(save);
    String legacy = "{\"schemaVersion\":0,\"revision\":7,"
        + "\"enabledFeatures\":[\"sponsorships\"],"
        + "\"data\":{\"sponsorships\":{\"monthlyPayment\":125000}}}";
    Files.write(sidecar, legacy.getBytes(StandardCharsets.UTF_8));

    ModStateStore.LoadResult migrated = store.load(save);

    assertEquals(ModStateStore.LoadStatus.MIGRATED, migrated.getStatus());
    assertEquals(ModState.CURRENT_SCHEMA_VERSION, migrated.getState().getSchemaVersion());
    assertEquals(7L, migrated.getState().getRevision());
    assertTrue(FeatureRegistry.from(migrated.getState()).isEnabled(Feature.SPONSORSHIPS));
    assertEquals(Long.valueOf(125000L),
        migrated.getState().getModule("sponsorships").get("monthlyPayment"));
    assertTrue(new String(Files.readAllBytes(sidecar), StandardCharsets.UTF_8)
        .contains("\"schemaVersion\":0"));

    ModStateStore.LoadResult saved = store.save(save, migrated, migrated.getState());
    assertEquals(8L, saved.getState().getRevision());
    assertEquals(ModStateStore.LoadStatus.LOADED, store.load(save).getStatus());
    assertTrue(new String(Files.readAllBytes(sidecar), StandardCharsets.UTF_8)
        .contains("\"schemaVersion\":1"));
  }

  @Test
  void futureSchemaAndConcurrentEditsAreNeverOverwritten() throws Exception {
    Path futureSave = createSave("future.s22");
    ModStateStore store = new ModStateStore();
    Path futureSidecar = store.sidecarFor(futureSave);
    String future = "{\"schemaVersion\":2,\"features\":{\"sponsorships\":true}}";
    Files.write(futureSidecar, future.getBytes(StandardCharsets.UTF_8));
    ModStateStore.LoadResult unsupported = store.load(futureSave);
    assertEquals(ModStateStore.LoadStatus.UNSUPPORTED, unsupported.getStatus());
    assertFalse(FeatureRegistry.from(unsupported.getState()).isEnabled(Feature.SPONSORSHIPS));
    assertThrows(IllegalStateException.class,
        () -> store.save(futureSave, unsupported, unsupported.getState()));

    Path concurrentSave = createSave("concurrent.s22");
    ModStateStore.LoadResult baseline = store.load(concurrentSave);
    Files.write(store.sidecarFor(concurrentSave), "{}".getBytes(StandardCharsets.UTF_8));
    assertThrows(IOException.class,
        () -> store.save(concurrentSave, baseline, baseline.getState()));
  }

  private Path createSave(String name) throws IOException {
    Path save = this.directory.resolve(name);
    Files.write(save, new byte[]{1, 2, 3});
    return save;
  }
}
