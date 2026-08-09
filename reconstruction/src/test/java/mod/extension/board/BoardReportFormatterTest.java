package mod.extension.board;

import static org.junit.jupiter.api.Assertions.assertTrue;

import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class BoardReportFormatterTest {
  private final BoardObjectivesService service = new BoardObjectivesService();

  @Test
  void formatsInitialTargetsForTheGameInbox() {
    BoardEvaluation evaluation = this.service.evaluate(
        ModState.empty(), snapshot(2026, 1, 0, 0, 75));

    String message = BoardReportFormatter.format(evaluation, "0");

    assertTrue(message.contains("vit\u00f3rias m\u00ednimas de 52%"));
    assertTrue(message.contains("confian\u00e7a da torcida de 65%"));
    assertTrue(message.contains("Seguran\u00e7a: seguro"));
  }

  @Test
  void formatsMonthlyResultAndSignedApprovalChange() {
    BoardEvaluation initialized = this.service.evaluate(
        ModState.empty(), snapshot(2026, 1, 0, 0, 75));
    BoardEvaluation evaluation = this.service.evaluate(
        initialized.getState(), snapshot(2026, 2, 4, 3, 75));

    String message = BoardReportFormatter.format(evaluation, "200 mil");

    assertTrue(message.contains("metas superadas"));
    assertTrue(message.contains("3V, 1D em 4 jogos"));
    assertTrue(message.contains("Saldo: 200 mil"));
    assertTrue(message.contains("Confian\u00e7a da diretoria: +3"));
  }

  private BoardSnapshot snapshot(
      int year, int month, int matches, int wins, int boardApproval) {
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
        boardApproval,
        80,
        1_000_000L + month * 100_000L,
        month * 100_000L);
  }
}
