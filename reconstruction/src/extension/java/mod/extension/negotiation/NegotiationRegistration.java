package mod.extension.negotiation;

import mod.extension.state.ModState;

public final class NegotiationRegistration {
  private final ModState state;
  private final PurchaseAgreement purchaseAgreement;
  private final LoanAgreement loanAgreement;
  private final boolean stateChanged;

  NegotiationRegistration(
      ModState state,
      PurchaseAgreement purchaseAgreement,
      LoanAgreement loanAgreement,
      boolean stateChanged) {
    this.state = state;
    this.purchaseAgreement = purchaseAgreement;
    this.loanAgreement = loanAgreement;
    this.stateChanged = stateChanged;
  }

  public static NegotiationRegistration disabled(ModState state) {
    return new NegotiationRegistration(state, null, null, false);
  }

  public ModState getState() {
    return this.state;
  }

  public PurchaseAgreement getPurchaseAgreement() {
    return this.purchaseAgreement;
  }

  public LoanAgreement getLoanAgreement() {
    return this.loanAgreement;
  }

  public boolean isStateChanged() {
    return this.stateChanged;
  }
}
