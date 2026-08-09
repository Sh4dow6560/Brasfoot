package mod.extension.board;

import mod.extension.state.ModState;

public final class BoardEvaluation {
  private final ModState state;
  private final BoardSnapshot snapshot;
  private final BoardOutcome outcome;
  private final JobSecurity jobSecurity;
  private final int securityScore;
  private final int approvalDelta;
  private final int monthlyMatches;
  private final int monthlyWins;
  private final int monthlyLosses;
  private final int monthlyWinRate;
  private final int targetWinRate;
  private final int targetFanApproval;
  private final long monthlyFinancialNet;
  private final boolean stateChanged;

  BoardEvaluation(
      ModState state,
      BoardSnapshot snapshot,
      BoardOutcome outcome,
      JobSecurity jobSecurity,
      int securityScore,
      int approvalDelta,
      int monthlyMatches,
      int monthlyWins,
      int monthlyLosses,
      int monthlyWinRate,
      int targetWinRate,
      int targetFanApproval,
      long monthlyFinancialNet,
      boolean stateChanged) {
    this.state = state;
    this.snapshot = snapshot;
    this.outcome = outcome;
    this.jobSecurity = jobSecurity;
    this.securityScore = securityScore;
    this.approvalDelta = approvalDelta;
    this.monthlyMatches = monthlyMatches;
    this.monthlyWins = monthlyWins;
    this.monthlyLosses = monthlyLosses;
    this.monthlyWinRate = monthlyWinRate;
    this.targetWinRate = targetWinRate;
    this.targetFanApproval = targetFanApproval;
    this.monthlyFinancialNet = monthlyFinancialNet;
    this.stateChanged = stateChanged;
  }

  public static BoardEvaluation disabled(ModState state, BoardSnapshot snapshot) {
    int score = weightedSecurityScore(
        snapshot.getBoardApproval(), snapshot.getFanApproval());
    return new BoardEvaluation(
        state,
        snapshot,
        BoardOutcome.DISABLED,
        JobSecurity.fromScore(score),
        score,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0L,
        false);
  }

  static int weightedSecurityScore(int boardApproval, int fanApproval) {
    return clamp((boardApproval * 3 + fanApproval) / 4, 0, 100);
  }

  static int clamp(int value, int minimum, int maximum) {
    return Math.max(minimum, Math.min(maximum, value));
  }

  public ModState getState() {
    return this.state;
  }

  public BoardSnapshot getSnapshot() {
    return this.snapshot;
  }

  public BoardOutcome getOutcome() {
    return this.outcome;
  }

  public JobSecurity getJobSecurity() {
    return this.jobSecurity;
  }

  public int getSecurityScore() {
    return this.securityScore;
  }

  public int getApprovalDelta() {
    return this.approvalDelta;
  }

  public int getMonthlyMatches() {
    return this.monthlyMatches;
  }

  public int getMonthlyWins() {
    return this.monthlyWins;
  }

  public int getMonthlyLosses() {
    return this.monthlyLosses;
  }

  public int getMonthlyWinRate() {
    return this.monthlyWinRate;
  }

  public int getTargetWinRate() {
    return this.targetWinRate;
  }

  public int getTargetFanApproval() {
    return this.targetFanApproval;
  }

  public long getMonthlyFinancialNet() {
    return this.monthlyFinancialNet;
  }

  public boolean isStateChanged() {
    return this.stateChanged;
  }
}
