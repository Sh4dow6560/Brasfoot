package mod.extension.reach;

import mod.extension.state.ModState;

public final class ClubReachResult {
  private final ModState state;
  private final ClubReachStatus status;
  private final ClubReachSnapshot snapshot;
  private final ClubReachMetrics metrics;
  private final long localSupporterDelta;
  private final long internationalSupporterDelta;
  private final long socialFollowerDelta;
  private final long supporterMemberDelta;
  private final int globalReputationDelta;
  private final int monthlyMatches;
  private final int monthlyWins;
  private final int monthlyLosses;
  private final int monthlyTitles;
  private final boolean stateChanged;

  ClubReachResult(
      ModState state,
      ClubReachStatus status,
      ClubReachSnapshot snapshot,
      ClubReachMetrics metrics,
      long localSupporterDelta,
      long internationalSupporterDelta,
      long socialFollowerDelta,
      long supporterMemberDelta,
      int globalReputationDelta,
      int monthlyMatches,
      int monthlyWins,
      int monthlyLosses,
      int monthlyTitles,
      boolean stateChanged) {
    this.state = state;
    this.status = status;
    this.snapshot = snapshot;
    this.metrics = metrics;
    this.localSupporterDelta = localSupporterDelta;
    this.internationalSupporterDelta = internationalSupporterDelta;
    this.socialFollowerDelta = socialFollowerDelta;
    this.supporterMemberDelta = supporterMemberDelta;
    this.globalReputationDelta = globalReputationDelta;
    this.monthlyMatches = monthlyMatches;
    this.monthlyWins = monthlyWins;
    this.monthlyLosses = monthlyLosses;
    this.monthlyTitles = monthlyTitles;
    this.stateChanged = stateChanged;
  }

  public static ClubReachResult disabled(ModState state, ClubReachSnapshot snapshot) {
    return new ClubReachResult(
        state, ClubReachStatus.DISABLED, snapshot, null,
        0L, 0L, 0L, 0L, 0, 0, 0, 0, 0, false);
  }

  public ModState getState() {
    return this.state;
  }

  public ClubReachStatus getStatus() {
    return this.status;
  }

  public ClubReachSnapshot getSnapshot() {
    return this.snapshot;
  }

  public ClubReachMetrics getMetrics() {
    return this.metrics;
  }

  public long getLocalSupporterDelta() {
    return this.localSupporterDelta;
  }

  public long getInternationalSupporterDelta() {
    return this.internationalSupporterDelta;
  }

  public long getSocialFollowerDelta() {
    return this.socialFollowerDelta;
  }

  public long getSupporterMemberDelta() {
    return this.supporterMemberDelta;
  }

  public int getGlobalReputationDelta() {
    return this.globalReputationDelta;
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

  public int getMonthlyTitles() {
    return this.monthlyTitles;
  }

  public boolean isStateChanged() {
    return this.stateChanged;
  }
}
