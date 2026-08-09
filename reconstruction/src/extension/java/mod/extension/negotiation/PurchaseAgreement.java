package mod.extension.negotiation;

public final class PurchaseAgreement {
  private final String id;
  private final int playerId;
  private final String playerName;
  private final int sellerClubId;
  private final int buyerClubId;
  private final int totalFee;
  private final int upfrontPayment;
  private final int remainingBalance;
  private final int remainingInstallments;
  private final int nextPaymentPeriod;

  PurchaseAgreement(
      String id,
      int playerId,
      String playerName,
      int sellerClubId,
      int buyerClubId,
      int totalFee,
      int upfrontPayment,
      int remainingBalance,
      int remainingInstallments,
      int nextPaymentPeriod) {
    if (id == null || id.length() == 0 || playerId < 0
        || playerName == null || playerName.length() == 0
        || sellerClubId < 0 || buyerClubId < 0 || sellerClubId == buyerClubId
        || totalFee <= 0 || upfrontPayment <= 0 || upfrontPayment > totalFee
        || remainingBalance < 0 || remainingBalance > totalFee
        || remainingInstallments < 0 || remainingInstallments > 24
        || (remainingInstallments == 0) != (remainingBalance == 0)) {
      throw new IllegalArgumentException("Purchase agreement is invalid");
    }
    this.id = id;
    this.playerId = playerId;
    this.playerName = playerName;
    this.sellerClubId = sellerClubId;
    this.buyerClubId = buyerClubId;
    this.totalFee = totalFee;
    this.upfrontPayment = upfrontPayment;
    this.remainingBalance = remainingBalance;
    this.remainingInstallments = remainingInstallments;
    this.nextPaymentPeriod = nextPaymentPeriod;
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

  public int getSellerClubId() {
    return this.sellerClubId;
  }

  public int getBuyerClubId() {
    return this.buyerClubId;
  }

  public int getTotalFee() {
    return this.totalFee;
  }

  public int getUpfrontPayment() {
    return this.upfrontPayment;
  }

  public int getRemainingBalance() {
    return this.remainingBalance;
  }

  public int getRemainingInstallments() {
    return this.remainingInstallments;
  }

  public int getNextPaymentPeriod() {
    return this.nextPaymentPeriod;
  }
}
