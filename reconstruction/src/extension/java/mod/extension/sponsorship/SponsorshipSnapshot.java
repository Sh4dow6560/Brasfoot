package mod.extension.sponsorship;

public final class SponsorshipSnapshot {
  private final int year;
  private final int month;
  private final int seasonNumber;
  private final int clubId;
  private final int division;
  private final int clubReputation;
  private final int baseAnnualRevenue;
  private final int matchCount;
  private final int winCount;
  private final int titleCount;

  public SponsorshipSnapshot(
      int year,
      int month,
      int seasonNumber,
      int clubId,
      int division,
      int clubReputation,
      int baseAnnualRevenue,
      int matchCount,
      int winCount,
      int titleCount) {
    if (year < 2000 || year > 2200 || month < 1 || month > 12) {
      throw new IllegalArgumentException("Sponsorship period is outside the supported range");
    }
    if (seasonNumber < 1 || clubId < 0 || division < 0 || division > 20
        || clubReputation < 0 || clubReputation > 20) {
      throw new IllegalArgumentException("Sponsorship club profile is inconsistent");
    }
    if (baseAnnualRevenue < 0 || matchCount < 0 || winCount < 0
        || winCount > matchCount || titleCount < 0) {
      throw new IllegalArgumentException("Sponsorship performance values are inconsistent");
    }
    this.year = year;
    this.month = month;
    this.seasonNumber = seasonNumber;
    this.clubId = clubId;
    this.division = division;
    this.clubReputation = clubReputation;
    this.baseAnnualRevenue = baseAnnualRevenue;
    this.matchCount = matchCount;
    this.winCount = winCount;
    this.titleCount = titleCount;
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

  public int getBaseAnnualRevenue() {
    return this.baseAnnualRevenue;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getWinCount() {
    return this.winCount;
  }

  public int getTitleCount() {
    return this.titleCount;
  }

  public int getWinRate() {
    return this.matchCount == 0 ? 0
        : (int)Math.round(this.winCount * 100.0D / this.matchCount);
  }

  public String getProfileKey() {
    return "club-" + this.clubId;
  }
}
