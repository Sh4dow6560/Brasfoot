package mod.extension.negotiation;

public final class LoanTerms {
  private final int durationMonths;
  private final int loanFee;
  private final int borrowerWagePercent;
  private final int purchaseOptionPrice;

  public LoanTerms(
      int durationMonths,
      int loanFee,
      int borrowerWagePercent,
      int purchaseOptionPrice) {
    if ((durationMonths != 6 && durationMonths != 12)
        || loanFee < 0 || loanFee > 1_000_000_000
        || borrowerWagePercent < 0 || borrowerWagePercent > 100
        || borrowerWagePercent % 25 != 0
        || purchaseOptionPrice < 0 || purchaseOptionPrice > 1_000_000_000) {
      throw new IllegalArgumentException("Loan terms are invalid");
    }
    this.durationMonths = durationMonths;
    this.loanFee = loanFee;
    this.borrowerWagePercent = borrowerWagePercent;
    this.purchaseOptionPrice = purchaseOptionPrice;
  }

  public int getDurationMonths() {
    return this.durationMonths;
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

  public int getPurchaseOptionPrice() {
    return this.purchaseOptionPrice;
  }

  public boolean hasPurchaseOption() {
    return this.purchaseOptionPrice > 0;
  }
}
