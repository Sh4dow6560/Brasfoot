package mod.extension.board;

public final class BoardSnapshot {
  private final int year;
  private final int month;
  private final int seasonNumber;
  private final int coachId;
  private final int clubId;
  private final int division;
  private final int clubReputation;
  private final int matchCount;
  private final int winCount;
  private final int lossCount;
  private final int boardApproval;
  private final int fanApproval;
  private final long cashBalance;
  private final long cumulativeFinancialNet;

  public BoardSnapshot(
      int year,
      int month,
      int seasonNumber,
      int coachId,
      int clubId,
      int division,
      int clubReputation,
      int matchCount,
      int winCount,
      int lossCount,
      int boardApproval,
      int fanApproval,
      long cashBalance,
      long cumulativeFinancialNet) {
    if (year < 2000 || year > 2200) {
      throw new IllegalArgumentException("year is outside the supported range");
    }
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("month must be between 1 and 12");
    }
    if (seasonNumber < 1) {
      throw new IllegalArgumentException("seasonNumber must be positive");
    }
    if (coachId < -1 || clubId < -1) {
      throw new IllegalArgumentException("coachId and clubId must be at least -1");
    }
    if (division < 0 || division > 20 || clubReputation < 0 || clubReputation > 20) {
      throw new IllegalArgumentException("club classification is outside the supported range");
    }
    if (matchCount < 0 || winCount < 0 || lossCount < 0
        || winCount + lossCount > matchCount) {
      throw new IllegalArgumentException("match counters are inconsistent");
    }
    if (boardApproval < 0 || boardApproval > 100 || fanApproval < 0
        || fanApproval > 100) {
      throw new IllegalArgumentException("approval must be between 0 and 100");
    }
    this.year = year;
    this.month = month;
    this.seasonNumber = seasonNumber;
    this.coachId = coachId;
    this.clubId = clubId;
    this.division = division;
    this.clubReputation = clubReputation;
    this.matchCount = matchCount;
    this.winCount = winCount;
    this.lossCount = lossCount;
    this.boardApproval = boardApproval;
    this.fanApproval = fanApproval;
    this.cashBalance = cashBalance;
    this.cumulativeFinancialNet = cumulativeFinancialNet;
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

  public int getCoachId() {
    return this.coachId;
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

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getWinCount() {
    return this.winCount;
  }

  public int getLossCount() {
    return this.lossCount;
  }

  public int getBoardApproval() {
    return this.boardApproval;
  }

  public int getFanApproval() {
    return this.fanApproval;
  }

  public long getCashBalance() {
    return this.cashBalance;
  }

  public long getCumulativeFinancialNet() {
    return this.cumulativeFinancialNet;
  }

  public String getProfileKey() {
    return this.coachId + "@" + this.clubId;
  }
}
