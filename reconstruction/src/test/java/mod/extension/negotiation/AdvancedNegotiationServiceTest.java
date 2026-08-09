package mod.extension.negotiation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mod.extension.state.ModState;
import org.junit.jupiter.api.Test;

class AdvancedNegotiationServiceTest {
  private final AdvancedNegotiationService service =
      new AdvancedNegotiationService();

  @Test
  void paysPurchaseInstallmentsOncePerMonthAndClosesTheAgreement() {
    NegotiationRegistration registered = this.service.registerPurchase(
        ModState.empty(),
        202601,
        7,
        "Jogador",
        10,
        20,
        new PurchaseTerms(10_000_000, 4_000_000, 3));

    PurchaseAgreement agreement = registered.getPurchaseAgreement();
    assertTrue(registered.isStateChanged());
    assertEquals(6_000_000, agreement.getRemainingBalance());
    assertEquals(202602, agreement.getNextPaymentPeriod());

    NegotiationMonthResult february = this.service.processMonthly(
        registered.getState(), 202602);
    NegotiationPayment payment = february.getPayments().get(0);
    assertEquals(NegotiationPaymentType.PURCHASE_INSTALLMENT, payment.getType());
    assertEquals(20, payment.getFromClubId());
    assertEquals(10, payment.getToClubId());
    assertEquals(2_000_000, payment.getAmount());
    assertEquals(4_000_000, this.service.getPurchaseAgreements(
        february.getState()).get(0).getRemainingBalance());

    NegotiationMonthResult repeated = this.service.processMonthly(
        february.getState(), 202602);
    assertFalse(repeated.isStateChanged());
    assertSame(february.getState(), repeated.getState());
    assertTrue(repeated.getPayments().isEmpty());

    NegotiationMonthResult april = this.service.processMonthly(
        february.getState(), 202604);
    assertEquals(2, april.getPayments().size());
    assertTrue(this.service.getPurchaseAgreements(april.getState()).isEmpty());
  }

  @Test
  void catchesUpSkippedInstallmentsAcrossTheYearBoundary() {
    ModState registered = this.service.registerPurchase(
        ModState.empty(),
        202611,
        8,
        "Atacante",
        30,
        40,
        new PurchaseTerms(10_000_000, 1_000_000, 3)).getState();

    NegotiationMonthResult february =
        this.service.processMonthly(registered, 202702);

    assertEquals(3, february.getPayments().size());
    assertEquals(9_000_000, total(february.getPayments()));
    assertTrue(this.service.getPurchaseAgreements(february.getState()).isEmpty());
  }

  @Test
  void sharesLoanWagesForTheFullTermAndReportsMaturity() {
    NegotiationRegistration registered = this.service.registerLoan(
        ModState.empty(),
        202601,
        9,
        "Meia",
        50,
        60,
        100_000,
        new LoanTerms(6, 500_000, 50, 5_000_000));

    LoanAgreement agreement = registered.getLoanAgreement();
    assertEquals(202607, agreement.getEndPeriod());
    assertEquals(50_000, agreement.getMonthlyWageContribution());
    assertTrue(agreement.hasPurchaseOption());

    NegotiationMonthResult matured = this.service.processMonthly(
        registered.getState(), 202607);

    assertEquals(6, matured.getPayments().size());
    assertEquals(300_000, total(matured.getPayments()));
    assertEquals(1, matured.getMaturedLoans().size());
    assertEquals(9, matured.getMaturedLoans().get(0).getPlayerId());

    NegotiationRegistration closed = this.service.closeLoan(
        matured.getState(), 202607, 9, "expired");
    assertTrue(closed.isStateChanged());
    assertNull(this.service.findLoanAgreement(closed.getState(), 9));
  }

  @Test
  void isolatesConcurrentContractsAndRejectsDuplicateLoans() {
    ModState first = this.service.registerLoan(
        ModState.empty(),
        202601,
        11,
        "Goleiro",
        70,
        80,
        60_000,
        new LoanTerms(12, 0, 100, 0)).getState();
    ModState second = this.service.registerLoan(
        first,
        202601,
        12,
        "Zagueiro",
        90,
        80,
        80_000,
        new LoanTerms(6, 100_000, 75, 2_000_000)).getState();

    assertEquals(2, this.service.getLoanAgreements(second).size());
    assertThrows(
        IllegalStateException.class,
        () -> this.service.registerLoan(
            second,
            202602,
            11,
            "Goleiro",
            70,
            81,
            60_000,
            new LoanTerms(6, 0, 100, 0)));

    ModState closed = this.service.closeLoan(
        second, 202602, 11, "canceled").getState();
    assertNull(this.service.findLoanAgreement(closed, 11));
    assertEquals(12, this.service.getLoanAgreements(closed).get(0).getPlayerId());
  }

  @Test
  void skipsMalformedSidecarContractsWithoutBlockingValidOnes() {
    Map<String, Object> malformed = new LinkedHashMap<String, Object>();
    malformed.put("id", "invalid");
    List<Object> purchases = new ArrayList<Object>();
    purchases.add(malformed);
    Map<String, Object> module = new LinkedHashMap<String, Object>();
    module.put("purchases", purchases);
    ModState state = ModState.empty().withModule(
        AdvancedNegotiationService.MODULE_ID, module);

    NegotiationMonthResult result = this.service.processMonthly(state, 202601);

    assertTrue(result.getPayments().isEmpty());
    assertTrue(this.service.getPurchaseAgreements(result.getState()).isEmpty());
  }

  @Test
  void validatesTermsAndContractIdentity() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new PurchaseTerms(1_000_000, 1_000_000, 3));
    assertThrows(
        IllegalArgumentException.class,
        () -> new LoanTerms(9, 0, 100, 0));
    assertThrows(
        IllegalArgumentException.class,
        () -> new LoanAgreement(
            "loan-invalid",
            1,
            "Jogador",
            10,
            20,
            202601,
            202607,
            0,
            33,
            10_000,
            0,
            202602));
    assertThrows(
        IllegalArgumentException.class,
        () -> this.service.registerPurchase(
            ModState.empty(),
            202601,
            -1,
            "Jogador",
            10,
            20,
            new PurchaseTerms(1_000_000, 500_000, 2)));
  }

  private int total(List<NegotiationPayment> payments) {
    int total = 0;
    for (NegotiationPayment payment : payments) {
      total += payment.getAmount();
    }
    return total;
  }
}
