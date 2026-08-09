package mod.extension.negotiation;

public final class PurchaseTerms {
  private final int totalFee;
  private final int upfrontPayment;
  private final int installmentCount;

  public PurchaseTerms(int totalFee, int upfrontPayment, int installmentCount) {
    if (totalFee <= 0 || upfrontPayment <= 0 || upfrontPayment > totalFee
        || installmentCount < 0 || installmentCount > 24
        || (installmentCount == 0) != (upfrontPayment == totalFee)) {
      throw new IllegalArgumentException("Purchase terms are invalid");
    }
    this.totalFee = totalFee;
    this.upfrontPayment = upfrontPayment;
    this.installmentCount = installmentCount;
  }

  public int getTotalFee() {
    return this.totalFee;
  }

  public int getUpfrontPayment() {
    return this.upfrontPayment;
  }

  public int getInstallmentCount() {
    return this.installmentCount;
  }

  public int getDeferredBalance() {
    return this.totalFee - this.upfrontPayment;
  }

  public boolean isCashPurchase() {
    return this.installmentCount == 0;
  }
}
