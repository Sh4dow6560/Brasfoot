package mod.extension.state;

public enum Feature {
  BOARD_OBJECTIVES("boardObjectives", false),
  SPONSORSHIPS("sponsorships", false),
  SUPPORTER_MEMBERSHIP("supporterMembership", false),
  STAFF_AND_TRAINING("staffAndTraining", false),
  SCOUTING_NETWORK("scoutingNetwork", false),
  ADVANCED_NEGOTIATIONS("advancedNegotiations", false),
  TACTICAL_ANALYTICS("tacticalAnalytics", false);

  private final String id;
  private final boolean enabledByDefault;

  Feature(String id, boolean enabledByDefault) {
    this.id = id;
    this.enabledByDefault = enabledByDefault;
  }

  public String getId() {
    return this.id;
  }

  public boolean isEnabledByDefault() {
    return this.enabledByDefault;
  }
}
