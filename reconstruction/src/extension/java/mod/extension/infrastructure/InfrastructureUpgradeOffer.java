package mod.extension.infrastructure;

public final class InfrastructureUpgradeOffer {
  private final FacilityType facilityType;
  private final int currentLevel;
  private final int targetLevel;
  private final int cost;
  private final int durationMonths;
  private final int completionPeriod;

  InfrastructureUpgradeOffer(
      FacilityType facilityType,
      int currentLevel,
      int targetLevel,
      int cost,
      int durationMonths,
      int completionPeriod) {
    this.facilityType = facilityType;
    this.currentLevel = currentLevel;
    this.targetLevel = targetLevel;
    this.cost = cost;
    this.durationMonths = durationMonths;
    this.completionPeriod = completionPeriod;
  }

  public FacilityType getFacilityType() {
    return this.facilityType;
  }

  public int getCurrentLevel() {
    return this.currentLevel;
  }

  public int getTargetLevel() {
    return this.targetLevel;
  }

  public int getCost() {
    return this.cost;
  }

  public int getDurationMonths() {
    return this.durationMonths;
  }

  public int getCompletionPeriod() {
    return this.completionPeriod;
  }
}
