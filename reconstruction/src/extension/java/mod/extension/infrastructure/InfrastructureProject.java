package mod.extension.infrastructure;

public final class InfrastructureProject {
  private final FacilityType facilityType;
  private final int targetLevel;
  private final int startPeriod;
  private final int completionPeriod;
  private final int cost;

  InfrastructureProject(
      FacilityType facilityType,
      int targetLevel,
      int startPeriod,
      int completionPeriod,
      int cost) {
    if (facilityType == null) {
      throw new NullPointerException("facilityType");
    }
    if (targetLevel < 2 || targetLevel > 5 || startPeriod < 200001
        || completionPeriod < startPeriod || cost <= 0) {
      throw new IllegalArgumentException("Infrastructure project is invalid");
    }
    this.facilityType = facilityType;
    this.targetLevel = targetLevel;
    this.startPeriod = startPeriod;
    this.completionPeriod = completionPeriod;
    this.cost = cost;
  }

  public FacilityType getFacilityType() {
    return this.facilityType;
  }

  public int getTargetLevel() {
    return this.targetLevel;
  }

  public int getStartPeriod() {
    return this.startPeriod;
  }

  public int getCompletionPeriod() {
    return this.completionPeriod;
  }

  public int getCost() {
    return this.cost;
  }
}
