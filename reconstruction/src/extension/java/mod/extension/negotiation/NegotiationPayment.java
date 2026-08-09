package mod.extension.negotiation;

public final class NegotiationPayment {
  private final String agreementId;
  private final NegotiationPaymentType type;
  private final int fromClubId;
  private final int toClubId;
  private final int amount;
  private final int periods;

  NegotiationPayment(
      String agreementId,
      NegotiationPaymentType type,
      int fromClubId,
      int toClubId,
      int amount,
      int periods) {
    if (agreementId == null || type == null || fromClubId < 0 || toClubId < 0
        || fromClubId == toClubId || amount <= 0 || periods <= 0) {
      throw new IllegalArgumentException("Negotiation payment is invalid");
    }
    this.agreementId = agreementId;
    this.type = type;
    this.fromClubId = fromClubId;
    this.toClubId = toClubId;
    this.amount = amount;
    this.periods = periods;
  }

  public String getAgreementId() {
    return this.agreementId;
  }

  public NegotiationPaymentType getType() {
    return this.type;
  }

  public int getFromClubId() {
    return this.fromClubId;
  }

  public int getToClubId() {
    return this.toClubId;
  }

  public int getAmount() {
    return this.amount;
  }

  public int getPeriods() {
    return this.periods;
  }
}
