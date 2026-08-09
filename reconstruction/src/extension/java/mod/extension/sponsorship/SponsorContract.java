package mod.extension.sponsorship;

public final class SponsorContract {
  private final SponsorOffer offer;
  private final int startPeriod;
  private final int endPeriod;
  private final int lastPaymentPeriod;
  private final int bonusPaidSeason;
  private final long totalPaid;
  private final int goalBaselineSeason;
  private final int baselineMatchCount;
  private final int baselineWinCount;
  private final int baselineTitleCount;

  SponsorContract(
      SponsorOffer offer,
      int startPeriod,
      int endPeriod,
      int lastPaymentPeriod,
      int bonusPaidSeason,
      long totalPaid,
      int goalBaselineSeason,
      int baselineMatchCount,
      int baselineWinCount,
      int baselineTitleCount) {
    if (offer == null) {
      throw new NullPointerException("offer");
    }
    if (startPeriod <= 0 || endPeriod < startPeriod || totalPaid < 0L
        || goalBaselineSeason < 1 || baselineMatchCount < 0
        || baselineWinCount < 0 || baselineWinCount > baselineMatchCount
        || baselineTitleCount < 0) {
      throw new IllegalArgumentException("Sponsor contract state is inconsistent");
    }
    this.offer = offer;
    this.startPeriod = startPeriod;
    this.endPeriod = endPeriod;
    this.lastPaymentPeriod = lastPaymentPeriod;
    this.bonusPaidSeason = bonusPaidSeason;
    this.totalPaid = totalPaid;
    this.goalBaselineSeason = goalBaselineSeason;
    this.baselineMatchCount = baselineMatchCount;
    this.baselineWinCount = baselineWinCount;
    this.baselineTitleCount = baselineTitleCount;
  }

  SponsorContract paid(int period, int season, int amount, boolean paidGoalBonus) {
    long updatedTotal;
    try {
      updatedTotal = Math.addExact(this.totalPaid, amount);
    } catch (ArithmeticException exception) {
      updatedTotal = Long.MAX_VALUE;
    }
    return new SponsorContract(
        this.offer,
        this.startPeriod,
        this.endPeriod,
        period,
        paidGoalBonus ? season : this.bonusPaidSeason,
        updatedTotal,
        this.goalBaselineSeason,
        this.baselineMatchCount,
        this.baselineWinCount,
        this.baselineTitleCount);
  }

  SponsorContract rebased(SponsorshipSnapshot snapshot) {
    return new SponsorContract(
        this.offer,
        this.startPeriod,
        this.endPeriod,
        this.lastPaymentPeriod,
        this.bonusPaidSeason,
        this.totalPaid,
        snapshot.getSeasonNumber(),
        snapshot.getMatchCount(),
        snapshot.getWinCount(),
        snapshot.getTitleCount());
  }

  public SponsorOffer getOffer() {
    return this.offer;
  }

  public int getStartPeriod() {
    return this.startPeriod;
  }

  public int getEndPeriod() {
    return this.endPeriod;
  }

  public int getLastPaymentPeriod() {
    return this.lastPaymentPeriod;
  }

  public int getBonusPaidSeason() {
    return this.bonusPaidSeason;
  }

  public long getTotalPaid() {
    return this.totalPaid;
  }

  public int getGoalBaselineSeason() {
    return this.goalBaselineSeason;
  }

  public int getBaselineMatchCount() {
    return this.baselineMatchCount;
  }

  public int getBaselineWinCount() {
    return this.baselineWinCount;
  }

  public int getBaselineTitleCount() {
    return this.baselineTitleCount;
  }
}
