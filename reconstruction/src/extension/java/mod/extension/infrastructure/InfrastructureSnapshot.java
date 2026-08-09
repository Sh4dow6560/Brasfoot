package mod.extension.infrastructure;

public final class InfrastructureSnapshot {
  private final int year;
  private final int month;
  private final int seasonNumber;
  private final int clubId;
  private final int division;
  private final int clubReputation;
  private final int stadiumCapacity;
  private final int legacyPitchCondition;
  private final int matchCount;
  private final long cashBalance;

  public InfrastructureSnapshot(
      int year,
      int month,
      int seasonNumber,
      int clubId,
      int division,
      int clubReputation,
      int stadiumCapacity,
      int legacyPitchCondition,
      int matchCount,
      long cashBalance) {
    if (year < 2000 || year > 2200 || month < 1 || month > 12) {
      throw new IllegalArgumentException("Infrastructure period is outside the supported range");
    }
    if (seasonNumber < 1 || clubId < 0 || division < 0 || division > 20
        || clubReputation < 0 || clubReputation > 20) {
      throw new IllegalArgumentException("Infrastructure profile is inconsistent");
    }
    if (stadiumCapacity < 0 || stadiumCapacity > 1_000_000
        || legacyPitchCondition < 0 || legacyPitchCondition > 3
        || matchCount < 0) {
      throw new IllegalArgumentException("Infrastructure stadium values are inconsistent");
    }
    this.year = year;
    this.month = month;
    this.seasonNumber = seasonNumber;
    this.clubId = clubId;
    this.division = division;
    this.clubReputation = clubReputation;
    this.stadiumCapacity = stadiumCapacity;
    this.legacyPitchCondition = legacyPitchCondition;
    this.matchCount = matchCount;
    this.cashBalance = cashBalance;
  }

  public int getYear() {
    return this.year;
  }

  public int getMonth() {
    return this.month;
  }

  public int getPeriod() {
    return this.year * 100 + this.month;
  }

  public int getSeasonNumber() {
    return this.seasonNumber;
  }

  public int getClubId() {
    return this.clubId;
  }

  public int getDivision() {
    return this.division;
  }

  public int getClubReputation() {
    return this.clubReputation;
  }

  public int getStadiumCapacity() {
    return this.stadiumCapacity;
  }

  public int getLegacyPitchCondition() {
    return this.legacyPitchCondition;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public long getCashBalance() {
    return this.cashBalance;
  }

  public String getProfileKey() {
    return "club-" + this.clubId;
  }
}
