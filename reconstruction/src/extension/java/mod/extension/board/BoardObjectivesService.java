package mod.extension.board;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mod.extension.state.ModState;

public final class BoardObjectivesService {
  public static final String MODULE_ID = "boardObjectives";
  private static final int MAX_HISTORY = 24;

  public BoardEvaluation evaluate(ModState state, BoardSnapshot snapshot) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    if (snapshot == null) {
      throw new NullPointerException("snapshot");
    }

    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    Map<String, Object> profiles = copyObject(module.get("profiles"));
    Map<String, Object> profile = copyObject(profiles.get(snapshot.getProfileKey()));
    int storedSeason = integer(profile.get("seasonNumber"), -1);
    int lastPeriod = integer(profile.get("lastPeriod"), -1);
    boolean countersReset = longValue(profile.get("baselineMatches"), 0L)
        > snapshot.getMatchCount();
    if (storedSeason != snapshot.getSeasonNumber() || profile.isEmpty() || countersReset) {
      return initialize(state, snapshot, module, profiles, profile);
    }

    int targetWinRate = integer(
        profile.get("targetWinRate"), targetWinRate(snapshot));
    int targetFanApproval = integer(
        profile.get("targetFanApproval"), targetFanApproval(snapshot));
    if (lastPeriod >= snapshot.getPeriod()) {
      int score = integer(profile.get("securityScore"),
          BoardEvaluation.weightedSecurityScore(
              snapshot.getBoardApproval(), snapshot.getFanApproval()));
      return new BoardEvaluation(
          state,
          snapshot,
          BoardOutcome.UNCHANGED,
          JobSecurity.fromScore(score),
          score,
          0,
          0,
          0,
          0,
          0,
          targetWinRate,
          targetFanApproval,
          0L,
          false);
    }

    int monthlyMatches = nonNegativeDifference(
        snapshot.getMatchCount(), integer(profile.get("baselineMatches"), 0));
    int monthlyWins = nonNegativeDifference(
        snapshot.getWinCount(), integer(profile.get("baselineWins"), 0));
    int monthlyLosses = nonNegativeDifference(
        snapshot.getLossCount(), integer(profile.get("baselineLosses"), 0));
    monthlyWins = Math.min(monthlyWins, monthlyMatches);
    monthlyLosses = Math.min(monthlyLosses, monthlyMatches - monthlyWins);
    int winRate = monthlyMatches == 0 ? 0
        : (int)Math.round(monthlyWins * 100.0D / monthlyMatches);
    long baselineNet = longValue(profile.get("baselineFinancialNet"),
        snapshot.getCumulativeFinancialNet());
    long monthlyFinancialNet = safeDifference(
        snapshot.getCumulativeFinancialNet(), baselineNet);

    int sportingScore = monthlyMatches == 0 ? 0
        : winRate >= targetWinRate ? 1
        : winRate >= targetWinRate - 10 ? 0 : -1;
    long tolerance = Math.max(100_000L, safeAbsolute(snapshot.getCashBalance()) / 20L);
    int financialScore = snapshot.getCashBalance() < 0L ? -1
        : monthlyFinancialNet >= 0L ? 1
        : monthlyFinancialNet >= -tolerance ? 0 : -1;
    int supportScore = snapshot.getFanApproval() >= targetFanApproval ? 1
        : snapshot.getFanApproval() >= targetFanApproval - 10 ? 0 : -1;
    int objectiveScore = sportingScore + financialScore + supportScore;
    int approvalDelta = approvalDelta(objectiveScore, snapshot.getCashBalance());
    int projectedApproval = BoardEvaluation.clamp(
        snapshot.getBoardApproval() + approvalDelta, 0, 100);
    int securityScore = BoardEvaluation.weightedSecurityScore(
        projectedApproval, snapshot.getFanApproval());
    JobSecurity security = JobSecurity.fromScore(securityScore);
    BoardOutcome outcome = outcome(objectiveScore);

    profile.put("seasonNumber", Long.valueOf(snapshot.getSeasonNumber()));
    profile.put("lastPeriod", Long.valueOf(snapshot.getPeriod()));
    profile.put("baselineMatches", Long.valueOf(snapshot.getMatchCount()));
    profile.put("baselineWins", Long.valueOf(snapshot.getWinCount()));
    profile.put("baselineLosses", Long.valueOf(snapshot.getLossCount()));
    profile.put("baselineFinancialNet", Long.valueOf(snapshot.getCumulativeFinancialNet()));
    profile.put("baselineCash", Long.valueOf(snapshot.getCashBalance()));
    profile.put("targetWinRate", Long.valueOf(targetWinRate));
    profile.put("targetFanApproval", Long.valueOf(targetFanApproval));
    profile.put("lastOutcome", outcome.name());
    profile.put("lastApprovalDelta", Long.valueOf(approvalDelta));
    profile.put("securityScore", Long.valueOf(securityScore));
    profile.put("jobSecurity", security.name());
    appendHistory(
        profile,
        snapshot,
        outcome,
        security,
        approvalDelta,
        monthlyMatches,
        monthlyWins,
        monthlyLosses,
        winRate,
        targetWinRate,
        targetFanApproval,
        monthlyFinancialNet);
    profiles.put(snapshot.getProfileKey(), profile);
    module.put("profiles", profiles);
    module.put("latestProfile", snapshot.getProfileKey());
    module.put("lastEvaluationPeriod", Long.valueOf(snapshot.getPeriod()));
    ModState updated = state.withModule(MODULE_ID, module);
    return new BoardEvaluation(
        updated,
        snapshot,
        outcome,
        security,
        securityScore,
        approvalDelta,
        monthlyMatches,
        monthlyWins,
        monthlyLosses,
        winRate,
        targetWinRate,
        targetFanApproval,
        monthlyFinancialNet,
        true);
  }

  private BoardEvaluation initialize(
      ModState state,
      BoardSnapshot snapshot,
      Map<String, Object> module,
      Map<String, Object> profiles,
      Map<String, Object> profile) {
    int targetWinRate = targetWinRate(snapshot);
    int targetFanApproval = targetFanApproval(snapshot);
    int securityScore = BoardEvaluation.weightedSecurityScore(
        snapshot.getBoardApproval(), snapshot.getFanApproval());
    JobSecurity security = JobSecurity.fromScore(securityScore);
    profile.clear();
    profile.put("seasonNumber", Long.valueOf(snapshot.getSeasonNumber()));
    profile.put("lastPeriod", Long.valueOf(snapshot.getPeriod()));
    profile.put("baselineMatches", Long.valueOf(snapshot.getMatchCount()));
    profile.put("baselineWins", Long.valueOf(snapshot.getWinCount()));
    profile.put("baselineLosses", Long.valueOf(snapshot.getLossCount()));
    profile.put("baselineFinancialNet", Long.valueOf(snapshot.getCumulativeFinancialNet()));
    profile.put("baselineCash", Long.valueOf(snapshot.getCashBalance()));
    profile.put("targetWinRate", Long.valueOf(targetWinRate));
    profile.put("targetFanApproval", Long.valueOf(targetFanApproval));
    profile.put("lastOutcome", BoardOutcome.INITIALIZED.name());
    profile.put("lastApprovalDelta", Long.valueOf(0L));
    profile.put("securityScore", Long.valueOf(securityScore));
    profile.put("jobSecurity", security.name());
    profile.put("history", new ArrayList<Object>());
    profiles.put(snapshot.getProfileKey(), profile);
    module.put("profiles", profiles);
    module.put("latestProfile", snapshot.getProfileKey());
    module.put("lastEvaluationPeriod", Long.valueOf(snapshot.getPeriod()));
    ModState updated = state.withModule(MODULE_ID, module);
    return new BoardEvaluation(
        updated,
        snapshot,
        BoardOutcome.INITIALIZED,
        security,
        securityScore,
        0,
        0,
        0,
        0,
        0,
        targetWinRate,
        targetFanApproval,
        0L,
        true);
  }

  private void appendHistory(
      Map<String, Object> profile,
      BoardSnapshot snapshot,
      BoardOutcome outcome,
      JobSecurity security,
      int approvalDelta,
      int monthlyMatches,
      int monthlyWins,
      int monthlyLosses,
      int winRate,
      int targetWinRate,
      int targetFanApproval,
      long monthlyFinancialNet) {
    List<Object> history = copyList(profile.get("history"));
    Map<String, Object> entry = new LinkedHashMap<String, Object>();
    entry.put("period", Long.valueOf(snapshot.getPeriod()));
    entry.put("outcome", outcome.name());
    entry.put("approvalDelta", Long.valueOf(approvalDelta));
    entry.put("matches", Long.valueOf(monthlyMatches));
    entry.put("wins", Long.valueOf(monthlyWins));
    entry.put("losses", Long.valueOf(monthlyLosses));
    entry.put("winRate", Long.valueOf(winRate));
    entry.put("targetWinRate", Long.valueOf(targetWinRate));
    entry.put("fanApproval", Long.valueOf(snapshot.getFanApproval()));
    entry.put("targetFanApproval", Long.valueOf(targetFanApproval));
    entry.put("financialNet", Long.valueOf(monthlyFinancialNet));
    entry.put("cashBalance", Long.valueOf(snapshot.getCashBalance()));
    entry.put("securityScore", Long.valueOf(
        BoardEvaluation.weightedSecurityScore(
            BoardEvaluation.clamp(
                snapshot.getBoardApproval() + approvalDelta, 0, 100),
            snapshot.getFanApproval())));
    entry.put("jobSecurity", security.name());
    history.add(entry);
    while (history.size() > MAX_HISTORY) {
      history.remove(0);
    }
    profile.put("history", history);
  }

  private int targetWinRate(BoardSnapshot snapshot) {
    int target = 36 + snapshot.getClubReputation() * 4;
    if (snapshot.getDivision() <= 1) {
      target += 4;
    } else if (snapshot.getDivision() >= 3) {
      target -= 4;
    }
    return BoardEvaluation.clamp(target, 32, 62);
  }

  private int targetFanApproval(BoardSnapshot snapshot) {
    int target = 50 + snapshot.getClubReputation() * 5;
    if (snapshot.getDivision() >= 3) {
      target -= 5;
    }
    return BoardEvaluation.clamp(target, 50, 80);
  }

  private int approvalDelta(int objectiveScore, long cashBalance) {
    int delta;
    if (objectiveScore >= 3) {
      delta = 3;
    } else if (objectiveScore >= 1) {
      delta = 1;
    } else if (objectiveScore == 0) {
      delta = 0;
    } else if (objectiveScore == -1) {
      delta = -2;
    } else {
      delta = -4;
    }
    if (cashBalance < 0L) {
      delta -= 2;
    }
    return BoardEvaluation.clamp(delta, -8, 4);
  }

  private BoardOutcome outcome(int objectiveScore) {
    if (objectiveScore >= 2) {
      return BoardOutcome.EXCEEDED;
    }
    if (objectiveScore >= 0) {
      return BoardOutcome.ON_TRACK;
    }
    if (objectiveScore == -1) {
      return BoardOutcome.AT_RISK;
    }
    return BoardOutcome.FAILED;
  }

  private int nonNegativeDifference(int current, int baseline) {
    return Math.max(0, current - baseline);
  }

  private long safeDifference(long current, long baseline) {
    try {
      return Math.subtractExact(current, baseline);
    } catch (ArithmeticException exception) {
      return current >= baseline ? Long.MAX_VALUE : -Long.MAX_VALUE;
    }
  }

  private long safeAbsolute(long value) {
    return value == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(value);
  }

  private int integer(Object value, int fallback) {
    long number = longValue(value, fallback);
    if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
      return fallback;
    }
    return (int)number;
  }

  private long longValue(Object value, long fallback) {
    return value instanceof Number ? ((Number)value).longValue() : fallback;
  }

  private Map<String, Object> copyObject(Object value) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    if (!(value instanceof Map)) {
      return result;
    }
    for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
      if (entry.getKey() instanceof String) {
        result.put((String)entry.getKey(), entry.getValue());
      }
    }
    return result;
  }

  private List<Object> copyList(Object value) {
    return value instanceof List
        ? new ArrayList<Object>((List<?>)value) : new ArrayList<Object>();
  }
}
