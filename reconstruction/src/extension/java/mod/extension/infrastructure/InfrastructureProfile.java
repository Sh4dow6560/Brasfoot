package mod.extension.infrastructure;

public final class InfrastructureProfile {
  private final int pitchLevel;
  private final int trainingLevel;
  private final int medicalLevel;
  private final int youthLevel;
  private final int commercialLevel;
  private final int pitchQuality;
  private final int monthlyMaintenance;
  private final int lastProcessedPeriod;
  private final int baselineSeason;
  private final int baselineMatches;
  private final long totalInvested;
  private final long totalMaintenancePaid;
  private final int maintenanceFailures;

  InfrastructureProfile(
      int pitchLevel,
      int trainingLevel,
      int medicalLevel,
      int youthLevel,
      int commercialLevel,
      int pitchQuality,
      int monthlyMaintenance,
      int lastProcessedPeriod,
      int baselineSeason,
      int baselineMatches,
      long totalInvested,
      long totalMaintenancePaid,
      int maintenanceFailures) {
    requireLevel(pitchLevel);
    requireLevel(trainingLevel);
    requireLevel(medicalLevel);
    requireLevel(youthLevel);
    requireLevel(commercialLevel);
    if (pitchQuality < 0 || pitchQuality > 100 || monthlyMaintenance < 0
        || lastProcessedPeriod < -1 || baselineSeason < 1 || baselineMatches < 0
        || totalInvested < 0L || totalMaintenancePaid < 0L
        || maintenanceFailures < 0) {
      throw new IllegalArgumentException("Infrastructure profile is invalid");
    }
    this.pitchLevel = pitchLevel;
    this.trainingLevel = trainingLevel;
    this.medicalLevel = medicalLevel;
    this.youthLevel = youthLevel;
    this.commercialLevel = commercialLevel;
    this.pitchQuality = pitchQuality;
    this.monthlyMaintenance = monthlyMaintenance;
    this.lastProcessedPeriod = lastProcessedPeriod;
    this.baselineSeason = baselineSeason;
    this.baselineMatches = baselineMatches;
    this.totalInvested = totalInvested;
    this.totalMaintenancePaid = totalMaintenancePaid;
    this.maintenanceFailures = maintenanceFailures;
  }

  public int getLevel(FacilityType type) {
    if (type == FacilityType.PITCH) {
      return this.pitchLevel;
    }
    if (type == FacilityType.TRAINING) {
      return this.trainingLevel;
    }
    if (type == FacilityType.MEDICAL) {
      return this.medicalLevel;
    }
    if (type == FacilityType.YOUTH) {
      return this.youthLevel;
    }
    if (type == FacilityType.COMMERCIAL) {
      return this.commercialLevel;
    }
    throw new NullPointerException("type");
  }

  public int getPitchLevel() {
    return this.pitchLevel;
  }

  public int getTrainingLevel() {
    return this.trainingLevel;
  }

  public int getMedicalLevel() {
    return this.medicalLevel;
  }

  public int getYouthLevel() {
    return this.youthLevel;
  }

  public int getCommercialLevel() {
    return this.commercialLevel;
  }

  public int getPitchQuality() {
    return this.pitchQuality;
  }

  public int getLegacyPitchCondition() {
    if (this.pitchQuality >= 85) {
      return 0;
    }
    if (this.pitchQuality >= 65) {
      return 1;
    }
    if (this.pitchQuality >= 45) {
      return 2;
    }
    return 3;
  }

  public int getMonthlyMaintenance() {
    return this.monthlyMaintenance;
  }

  public int getLastProcessedPeriod() {
    return this.lastProcessedPeriod;
  }

  int getBaselineSeason() {
    return this.baselineSeason;
  }

  int getBaselineMatches() {
    return this.baselineMatches;
  }

  public long getTotalInvested() {
    return this.totalInvested;
  }

  public long getTotalMaintenancePaid() {
    return this.totalMaintenancePaid;
  }

  public int getMaintenanceFailures() {
    return this.maintenanceFailures;
  }

  InfrastructureProfile withFacilityLevel(
      FacilityType type, int targetLevel, int maintenance) {
    return new InfrastructureProfile(
        type == FacilityType.PITCH ? targetLevel : this.pitchLevel,
        type == FacilityType.TRAINING ? targetLevel : this.trainingLevel,
        type == FacilityType.MEDICAL ? targetLevel : this.medicalLevel,
        type == FacilityType.YOUTH ? targetLevel : this.youthLevel,
        type == FacilityType.COMMERCIAL ? targetLevel : this.commercialLevel,
        this.pitchQuality,
        maintenance,
        this.lastProcessedPeriod,
        this.baselineSeason,
        this.baselineMatches,
        this.totalInvested,
        this.totalMaintenancePaid,
        this.maintenanceFailures);
  }

  InfrastructureProfile withMaintenance(int maintenance) {
    return new InfrastructureProfile(
        this.pitchLevel,
        this.trainingLevel,
        this.medicalLevel,
        this.youthLevel,
        this.commercialLevel,
        this.pitchQuality,
        maintenance,
        this.lastProcessedPeriod,
        this.baselineSeason,
        this.baselineMatches,
        this.totalInvested,
        this.totalMaintenancePaid,
        this.maintenanceFailures);
  }

  InfrastructureProfile withInvestment(int amount) {
    return new InfrastructureProfile(
        this.pitchLevel,
        this.trainingLevel,
        this.medicalLevel,
        this.youthLevel,
        this.commercialLevel,
        this.pitchQuality,
        this.monthlyMaintenance,
        this.lastProcessedPeriod,
        this.baselineSeason,
        this.baselineMatches,
        Math.addExact(this.totalInvested, amount),
        this.totalMaintenancePaid,
        this.maintenanceFailures);
  }

  InfrastructureProfile afterMonthlyProcessing(
      int period,
      int season,
      int matches,
      int quality,
      int maintenance,
      boolean paid) {
    return new InfrastructureProfile(
        this.pitchLevel,
        this.trainingLevel,
        this.medicalLevel,
        this.youthLevel,
        this.commercialLevel,
        quality,
        maintenance,
        period,
        season,
        matches,
        this.totalInvested,
        paid ? Math.addExact(this.totalMaintenancePaid, maintenance)
            : this.totalMaintenancePaid,
        paid || this.maintenanceFailures == Integer.MAX_VALUE
            ? this.maintenanceFailures : this.maintenanceFailures + 1);
  }

  private static void requireLevel(int level) {
    if (level < 1 || level > 5) {
      throw new IllegalArgumentException("Facility level is invalid: " + level);
    }
  }
}
