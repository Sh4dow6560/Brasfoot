package mod.extension.negotiation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mod.extension.state.ModState;

public final class NegotiationMonthResult {
  private final ModState state;
  private final List<NegotiationPayment> payments;
  private final List<LoanAgreement> maturedLoans;
  private final boolean stateChanged;

  NegotiationMonthResult(
      ModState state,
      List<NegotiationPayment> payments,
      List<LoanAgreement> maturedLoans,
      boolean stateChanged) {
    this.state = state;
    this.payments = Collections.unmodifiableList(
        new ArrayList<NegotiationPayment>(payments));
    this.maturedLoans = Collections.unmodifiableList(
        new ArrayList<LoanAgreement>(maturedLoans));
    this.stateChanged = stateChanged;
  }

  public static NegotiationMonthResult disabled(ModState state) {
    return new NegotiationMonthResult(
        state,
        Collections.<NegotiationPayment>emptyList(),
        Collections.<LoanAgreement>emptyList(),
        false);
  }

  public ModState getState() {
    return this.state;
  }

  public List<NegotiationPayment> getPayments() {
    return this.payments;
  }

  public List<LoanAgreement> getMaturedLoans() {
    return this.maturedLoans;
  }

  public boolean isStateChanged() {
    return this.stateChanged;
  }
}
