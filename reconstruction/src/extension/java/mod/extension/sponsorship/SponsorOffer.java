package mod.extension.sponsorship;

public final class SponsorOffer {
  private final String id;
  private final String sponsorName;
  private final int durationMonths;
  private final int signingBonus;
  private final int monthlyPayment;
  private final SponsorGoal goal;
  private final int goalTarget;
  private final int goalBonus;

  public SponsorOffer(
      String id,
      String sponsorName,
      int durationMonths,
      int signingBonus,
      int monthlyPayment,
      SponsorGoal goal,
      int goalTarget,
      int goalBonus) {
    if (id == null || id.length() == 0 || sponsorName == null
        || sponsorName.length() == 0 || goal == null) {
      throw new IllegalArgumentException("Sponsor offer identity is required");
    }
    if (durationMonths < 1 || durationMonths > 60) {
      throw new IllegalArgumentException("durationMonths is outside the supported range");
    }
    if (signingBonus < 0 || monthlyPayment <= 0 || goalTarget <= 0 || goalBonus < 0) {
      throw new IllegalArgumentException("Sponsor offer values must be positive");
    }
    if (signingBonus > 1_000_000_000 || monthlyPayment > 1_000_000_000
        || goalBonus > 1_000_000_000) {
      throw new IllegalArgumentException("Sponsor offer values exceed the safety limit");
    }
    this.id = id;
    this.sponsorName = sponsorName;
    this.durationMonths = durationMonths;
    this.signingBonus = signingBonus;
    this.monthlyPayment = monthlyPayment;
    this.goal = goal;
    this.goalTarget = goalTarget;
    this.goalBonus = goalBonus;
  }

  public String getId() {
    return this.id;
  }

  public String getSponsorName() {
    return this.sponsorName;
  }

  public int getDurationMonths() {
    return this.durationMonths;
  }

  public int getSigningBonus() {
    return this.signingBonus;
  }

  public int getMonthlyPayment() {
    return this.monthlyPayment;
  }

  public SponsorGoal getGoal() {
    return this.goal;
  }

  public int getGoalTarget() {
    return this.goalTarget;
  }

  public int getGoalBonus() {
    return this.goalBonus;
  }
}
