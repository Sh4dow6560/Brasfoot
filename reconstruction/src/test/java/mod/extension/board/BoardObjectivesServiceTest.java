package mod.extension.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class BoardObjectivesServiceTest {
  private final BoardObjectivesService service = new BoardObjectivesService();

  @Test
  void initializesOnceAndIgnoresDuplicateMonthlyEvaluation() {
    BoardSnapshot january = snapshot(2026, 1, 1, 0, 0, 0, 75, 80, 1_000_000L, 0L);

    BoardEvaluation initialized = this.service.evaluate(ModState.empty(), january);
    BoardEvaluation duplicate = this.service.evaluate(initialized.getState(), january);

    assertEquals(BoardOutcome.INITIALIZED, initialized.getOutcome());
    assertEquals(0, initialized.getApprovalDelta());
    assertTrue(initialized.isStateChanged());
    assertEquals(BoardOutcome.UNCHANGED, duplicate.getOutcome());
    assertFalse(duplicate.isStateChanged());
    assertSame(initialized.getState(), duplicate.getState());
  }

  @Test
  void rewardsAStrongSportingFinancialAndSupportMonth() {
    BoardEvaluation initialized = this.service.evaluate(
        ModState.empty(), snapshot(2026, 1, 1, 0, 0, 0, 75, 80, 1_000_000L, 0L));
    BoardEvaluation february = this.service.evaluate(
        initialized.getState(),
        snapshot(2026, 2, 1, 4, 3, 1, 75, 80, 1_200_000L, 200_000L));

    assertEquals(BoardOutcome.EXCEEDED, february.getOutcome());
    assertEquals(3, february.getApprovalDelta());
    assertEquals(4, february.getMonthlyMatches());
    assertEquals(75, february.getMonthlyWinRate());
    assertEquals(200_000L, february.getMonthlyFinancialNet());
    assertEquals(JobSecurity.SECURE, february.getJobSecurity());
  }

  @Test
  void marksASevereMonthAsCriticalAndAppliesBoundedPenalty() {
    BoardEvaluation initialized = this.service.evaluate(
        ModState.empty(), snapshot(2026, 1, 1, 0, 0, 0, 50, 60, 500_000L, 0L));
    BoardEvaluation february = this.service.evaluate(
        initialized.getState(),
        snapshot(2026, 2, 1, 5, 0, 5, 20, 30, -200_000L, -600_000L));

    assertEquals(BoardOutcome.FAILED, february.getOutcome());
    assertEquals(-6, february.getApprovalDelta());
    assertEquals(JobSecurity.CRITICAL, february.getJobSecurity());
    assertTrue(february.getSecurityScore() < 25);
  }

  @Test
  void startsANewBaselineWhenSeasonChanges() {
    BoardEvaluation first = this.service.evaluate(
        ModState.empty(), snapshot(2026, 12, 1, 20, 10, 5, 70, 70, 2_000_000L, 1_000_000L));
    BoardEvaluation nextSeason = this.service.evaluate(
        first.getState(), snapshot(2027, 1, 2, 0, 0, 0, 70, 70, 2_100_000L, 0L));

    assertEquals(BoardOutcome.INITIALIZED, nextSeason.getOutcome());
    assertEquals(0, nextSeason.getApprovalDelta());
  }

  @Test
  void retainsOnlyTheLatestTwentyFourMonthlyReports() {
    BoardEvaluation evaluation = this.service.evaluate(
        ModState.empty(), snapshot(2024, 1, 1, 0, 0, 0, 75, 80, 1_000_000L, 0L));
    int matches = 0;
    int wins = 0;
    for (int index = 1; index <= 30; index++) {
      int absoluteMonth = index;
      int year = 2024 + absoluteMonth / 12;
      int month = absoluteMonth % 12 + 1;
      matches += 2;
      wins += 1;
      evaluation = this.service.evaluate(
          evaluation.getState(),
          snapshot(year, month, 1, matches, wins, matches - wins,
              75, 80, 1_000_000L + index * 10_000L, index * 10_000L));
    }

    Map<String, Object> module = evaluation.getState().getModule(
        BoardObjectivesService.MODULE_ID);
    @SuppressWarnings("unchecked")
    Map<String, Object> profiles = (Map<String, Object>)module.get("profiles");
    @SuppressWarnings("unchecked")
    Map<String, Object> profile = (Map<String, Object>)profiles.get("7@101");
    @SuppressWarnings("unchecked")
    List<Object> history = (List<Object>)profile.get("history");
    assertEquals(24, history.size());
  }

  @Test
  void saturatesOverflowingFinancialDifferencesAtFormattableValues() {
    BoardEvaluation initialized = this.service.evaluate(
        ModState.empty(), new BoardSnapshot(
            2026, 1, 1, 7, 101, 1, 3, 0, 0, 0,
            75, 80, Long.MAX_VALUE, Long.MAX_VALUE));
    BoardEvaluation evaluation = this.service.evaluate(
        initialized.getState(), new BoardSnapshot(
            2026, 2, 1, 7, 101, 1, 3, 0, 0, 0,
            75, 80, Long.MIN_VALUE, Long.MIN_VALUE));

    assertEquals(-Long.MAX_VALUE, evaluation.getMonthlyFinancialNet());
  }

  private BoardSnapshot snapshot(
      int year,
      int month,
      int season,
      int matches,
      int wins,
      int losses,
      int boardApproval,
      int fanApproval,
      long cash,
      long net) {
    return new BoardSnapshot(
        year,
        month,
        season,
        7,
        101,
        1,
        3,
        matches,
        wins,
        losses,
        boardApproval,
        fanApproval,
        cash,
        net);
  }
}
