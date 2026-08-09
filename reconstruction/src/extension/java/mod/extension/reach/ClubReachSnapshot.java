package mod.extension.reach;

public final class ClubReachSnapshot {
  private final int year;
  private final int month;
  private final int seasonNumber;
  private final int clubId;
  private final int division;
  private final int clubReputation;
  private final int fanApproval;
  private final int stadiumCapacity;
  private final int matchCount;
  private final int winCount;
  private final int lossCount;
  private final int titleCount;

  public ClubReachSnapshot(
      int year,
      int month,
      int seasonNumber,
      int clubId,
      int division,
      int clubReputation,
      int fanApproval,
      int stadiumCapacity,
      int matchCount,
      int winCount,
      int lossCount,
      int titleCount) {
    if (year < 2000 || year > 2200 || month < 1 || month > 12) {
      throw new IllegalArgumentException("Club reach period is outside the supported range");
    }
    if (seasonNumber < 1 || clubId < 0 || division < 0 || division > 20
        || clubReputation < 0 || clubReputation > 20) {
      throw new IllegalArgumentException("Club reach profile is inconsistent");
    }
    if (fanApproval < 0 || fanApproval > 100 || stadiumCapacity < 0
        || stadiumCapacity > 1_000_000) {
      throw new IllegalArgumentException("Club reach support values are inconsistent");
    }
    if (matchCount < 0 || winCount < 0 || lossCount < 0 || titleCount < 0
        || winCount + lossCount > matchCount) {
      throw new IllegalArgumentException("Club reach performance values are inconsistent");
    }
    this.year = year;
    this.month = month;
    this.seasonNumber = seasonNumber;
    this.clubId = clubId;
    this.division = division;
    this.clubReputation = clubReputation;
    this.fanApproval = fanApproval;
    this.stadiumCapacity = stadiumCapacity;
    this.matchCount = matchCount;
    this.winCount = winCount;
    this.lossCount = lossCount;
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

  public int getFanApproval() {
    return this.fanApproval;
  }

  public int getStadiumCapacity() {
    return this.stadiumCapacity;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getWinCount() {
    return this.winCount;
  }

  public int getLossCount() {
    return this.lossCount;
  }

  public int getTitleCount() {
    return this.titleCount;
  }

  public String getProfileKey() {
    return "club-" + this.clubId;
  }
}
