package mod.extension.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import mod.extension.board.BoardEvaluation;
import mod.extension.board.BoardObjectivesService;
import mod.extension.board.BoardOutcome;
import mod.extension.board.BoardSnapshot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ModRuntimeTest {
  @TempDir
  Path directory;

  @AfterEach
  void resetRuntime() {
    ModRuntime.startNewCareer();
  }

  @Test
  void disabledFeatureKeepsOriginalFallbackUntouched() {
    ModRuntime.startNewCareer();
    BoardEvaluation evaluation = ModRuntime.evaluateBoardObjectives(snapshot(2026, 1, 0, 0));

    assertEquals(BoardOutcome.DISABLED, evaluation.getOutcome());
    assertFalse(evaluation.isStateChanged());
    assertTrue(ModRuntime.getState().getModule(BoardObjectivesService.MODULE_ID).isEmpty());
  }

  @Test
  void persistsEnabledBoardObjectivesAcrossRuntimeAttach() throws Exception {
    Path save = this.directory.resolve("career.s22");
    Files.write(save, new byte[]{1, 2, 3});
    ModRuntime.startNewCareer();
    ModRuntime.setFeatureEnabled(Feature.BOARD_OBJECTIVES, true);
    ModRuntime.evaluateBoardObjectives(snapshot(2026, 1, 0, 0));
    BoardEvaluation february = ModRuntime.evaluateBoardObjectives(snapshot(2026, 2, 4, 3));

    assertEquals(3, february.getApprovalDelta());
    assertTrue(ModRuntime.persist(save));
    ModRuntime.startNewCareer();
    assertFalse(ModRuntime.isFeatureEnabled(Feature.BOARD_OBJECTIVES));

    assertEquals(ModStateStore.LoadStatus.LOADED, ModRuntime.attach(save));
    assertTrue(ModRuntime.isFeatureEnabled(Feature.BOARD_OBJECTIVES));
    assertFalse(ModRuntime.getState().getModule(BoardObjectivesService.MODULE_ID).isEmpty());
  }

  private BoardSnapshot snapshot(int year, int month, int matches, int wins) {
    return new BoardSnapshot(
        year,
        month,
        1,
        7,
        101,
        1,
        3,
        matches,
        wins,
        matches - wins,
        75,
        80,
        1_000_000L + month * 100_000L,
        month * 100_000L);
  }
}
