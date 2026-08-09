package mod.extension.board;

import bf22.intermediary.C0799;
import java.util.ArrayList;
import mod.extension.state.Feature;
import mod.extension.state.ModRuntime;
import mod.recovered.finance.ClubFinances;
import mod.recovered.game.CareerState;
import mod.recovered.manager.CoachSeasonRecord;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;
import mod.recovered.save.GamePersistence;

public final class BoardObjectivesBridge {
  private BoardObjectivesBridge() {
  }

  public static int evaluateMonthly(int year, int month) {
    if (!ModRuntime.isFeatureEnabled(Feature.BOARD_OBJECTIVES)) {
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null || career.M() == null) {
      return 0;
    }

    int evaluations = 0;
    ArrayList coaches = career.M();
    for (int index = 0; index < coaches.size(); index++) {
      Object value = coaches.get(index);
      if (!(value instanceof Coach)) {
        continue;
      }
      Coach coach = (Coach)value;
      Club club = coach.getClub();
      if (!Boolean.TRUE.equals(coach.isUserControlled()) || club == null) {
        continue;
      }
      try {
        CoachSeasonRecord season = coach.getOrCreateSeasonRecord(club);
        ClubFinances finances = club.getFinances();
        BoardSnapshot snapshot = new BoardSnapshot(
            year,
            month,
            career.getSeasonNumber(),
            coach.getCoachId(),
            club.getClubId(),
            club.getDivisao(),
            club.getReputation(),
            season.getMatchCount(),
            season.getWinCount(),
            season.getLossCount(),
            coach.getBoardApproval(),
            coach.getFanApproval(),
            club.getCashBalance(),
            finances == null ? 0L : finances.getNetResult());
        BoardEvaluation evaluation = ModRuntime.evaluateBoardObjectives(snapshot);
        if (evaluation.getApprovalDelta() != 0) {
          coach.adjustBoardApproval(evaluation.getApprovalDelta());
        }
        if (evaluation.isStateChanged()) {
          new C0799(
              coach,
              BoardReportFormatter.MESSAGE_TITLE_INDEX,
              BoardReportFormatter.MESSAGE_BODY_INDEX,
              "",
              BoardReportFormatter.format(
                  evaluation,
                  ClubFinances.formatAmount(evaluation.getMonthlyFinancialNet())));
          evaluations++;
        }
      } catch (RuntimeException exception) {
        System.err.println("Board objectives evaluation failed: " + exception.getMessage());
      }
    }
    return evaluations;
  }
}
