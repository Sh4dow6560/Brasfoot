package mod.extension.negotiation;

public final class LoanAgreement {
  private final String id;
  private final int playerId;
  private final String playerName;
  private final int originalClubId;
  private final int borrowerClubId;
  private final int startPeriod;
  private final int endPeriod;
  private final int loanFee;
  private final int borrowerWagePercent;
  private final int monthlyWageContribution;
  private final int purchaseOptionPrice;
  private final int nextWagePeriod;

  LoanAgreement(
      String id,
      int playerId,
      String playerName,
      int originalClubId,
      int borrowerClubId,
      int startPeriod,
      int endPeriod,
      int loanFee,
      int borrowerWagePercent,
      int monthlyWageContribution,
      int purchaseOptionPrice,
      int nextWagePeriod) {
    if (id == null || id.length() == 0 || playerId < 0
        || playerName == null || playerName.length() == 0
        || originalClubId < 0 || borrowerClubId < 0
        || originalClubId == borrowerClubId || endPeriod <= startPeriod
        || loanFee < 0 || loanFee > 1_000_000_000
        || borrowerWagePercent < 0 || borrowerWagePercent > 100
        || borrowerWagePercent % 25 != 0
        || monthlyWageContribution < 0
        || monthlyWageContribution > 100_000_000
        || purchaseOptionPrice < 0 || purchaseOptionPrice > 1_000_000_000) {
      throw new IllegalArgumentException("Loan agreement is invalid");
    }
    this.id = id;
    this.playerId = playerId;
    this.playerName = playerName;
    this.originalClubId = originalClubId;
    this.borrowerClubId = borrowerClubId;
    this.startPeriod = startPeriod;
    this.endPeriod = endPeriod;
    this.loanFee = loanFee;
    this.borrowerWagePercent = borrowerWagePercent;
    this.monthlyWageContribution = monthlyWageContribution;
    this.purchaseOptionPrice = purchaseOptionPrice;
    this.nextWagePeriod = nextWagePeriod;
  }

  public String getId() {
    return this.id;
  }

  public int getPlayerId() {
    return this.playerId;
  }

  public String getPlayerName() {
    return this.playerName;
  }

  public int getOriginalClubId() {
    return this.originalClubId;
  }

  public int getBorrowerClubId() {
    return this.borrowerClubId;
  }

  public int getStartPeriod() {
    return this.startPeriod;
  }

  public int getEndPeriod() {
    return this.endPeriod;
  }

  public int getLoanFee() {
    return this.loanFee;
  }

  public int getBorrowerWagePercent() {
    return this.borrowerWagePercent;
  }

  public int getOriginalClubWagePercent() {
    return 100 - this.borrowerWagePercent;
  }

  public int getMonthlyWageContribution() {
    return this.monthlyWageContribution;
  }

  public int getPurchaseOptionPrice() {
    return this.purchaseOptionPrice;
  }

  public boolean hasPurchaseOption() {
    return this.purchaseOptionPrice > 0;
  }

  public int getNextWagePeriod() {
    return this.nextWagePeriod;
  }
}
