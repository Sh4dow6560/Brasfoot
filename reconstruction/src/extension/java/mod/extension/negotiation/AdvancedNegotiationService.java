package mod.extension.negotiation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mod.extension.state.ModState;

public final class AdvancedNegotiationService {
  public static final String MODULE_ID = "advancedNegotiations";
  private static final int MAX_HISTORY = 100;

  public NegotiationRegistration registerPurchase(
      ModState state,
      int period,
      int playerId,
      String playerName,
      int sellerClubId,
      int buyerClubId,
      PurchaseTerms terms) {
    requireStateAndPeriod(state, period);
    if (terms == null) {
      throw new NullPointerException("terms");
    }
    if (terms.isCashPurchase()) {
      return new NegotiationRegistration(state, null, null, false);
    }
    requireIdentity(playerId, playerName, sellerClubId, buyerClubId);

    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    List<Object> purchases = copyList(module.get("purchases"));
    int sequence = nextSequence(module);
    PurchaseAgreement agreement = new PurchaseAgreement(
        "purchase-" + sequence,
        playerId,
        playerName,
        sellerClubId,
        buyerClubId,
        terms.getTotalFee(),
        terms.getUpfrontPayment(),
        terms.getDeferredBalance(),
        terms.getInstallmentCount(),
        addMonths(period, 1));
    purchases.add(writePurchase(agreement));
    module.put("purchases", purchases);
    appendHistory(
        module,
        period,
        "purchase-registered",
        agreement.getId(),
        agreement.getRemainingBalance());
    return new NegotiationRegistration(
        state.withModule(MODULE_ID, module), agreement, null, true);
  }

  public NegotiationRegistration registerLoan(
      ModState state,
      int period,
      int playerId,
      String playerName,
      int originalClubId,
      int borrowerClubId,
      int playerSalary,
      LoanTerms terms) {
    requireStateAndPeriod(state, period);
    if (terms == null) {
      throw new NullPointerException("terms");
    }
    requireIdentity(playerId, playerName, originalClubId, borrowerClubId);
    if (playerSalary < 0 || playerSalary > 100_000_000) {
      throw new IllegalArgumentException("Player salary is invalid");
    }

    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    List<Object> loans = copyList(module.get("loans"));
    for (Object value : loans) {
      LoanAgreement existing = readLoan(value);
      if (existing != null && existing.getPlayerId() == playerId) {
        throw new IllegalStateException("Player already has an advanced loan agreement");
      }
    }

    int sequence = nextSequence(module);
    int contribution = roundedPercent(
        playerSalary, terms.getOriginalClubWagePercent());
    LoanAgreement agreement = new LoanAgreement(
        "loan-" + sequence,
        playerId,
        playerName,
        originalClubId,
        borrowerClubId,
        period,
        addMonths(period, terms.getDurationMonths()),
        terms.getLoanFee(),
        terms.getBorrowerWagePercent(),
        contribution,
        terms.getPurchaseOptionPrice(),
        addMonths(period, 1));
    loans.add(writeLoan(agreement));
    module.put("loans", loans);
    appendHistory(
        module,
        period,
        "loan-registered",
        agreement.getId(),
        terms.getLoanFee());
    return new NegotiationRegistration(
        state.withModule(MODULE_ID, module), null, agreement, true);
  }

  public NegotiationMonthResult processMonthly(ModState state, int period) {
    requireStateAndPeriod(state, period);
    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    int lastProcessed = integer(module.get("lastProcessedPeriod"), -1);
    if (lastProcessed >= period) {
      return new NegotiationMonthResult(
          state,
          Collections.<NegotiationPayment>emptyList(),
          Collections.<LoanAgreement>emptyList(),
          false);
    }

    List<NegotiationPayment> payments = new ArrayList<NegotiationPayment>();
    List<LoanAgreement> maturedLoans = new ArrayList<LoanAgreement>();
    List<Object> activePurchases = new ArrayList<Object>();
    for (Object value : copyList(module.get("purchases"))) {
      PurchaseAgreement agreement = readPurchase(value);
      if (agreement == null) {
        continue;
      }
      int balance = agreement.getRemainingBalance();
      int installments = agreement.getRemainingInstallments();
      int nextPeriod = agreement.getNextPaymentPeriod();
      while (installments > 0 && nextPeriod <= period) {
        int amount = divideCeiling(balance, installments);
        payments.add(new NegotiationPayment(
            agreement.getId(),
            NegotiationPaymentType.PURCHASE_INSTALLMENT,
            agreement.getBuyerClubId(),
            agreement.getSellerClubId(),
            amount,
            1));
        balance -= amount;
        installments--;
        nextPeriod = addMonths(nextPeriod, 1);
      }
      if (installments > 0) {
        activePurchases.add(writePurchase(new PurchaseAgreement(
            agreement.getId(),
            agreement.getPlayerId(),
            agreement.getPlayerName(),
            agreement.getSellerClubId(),
            agreement.getBuyerClubId(),
            agreement.getTotalFee(),
            agreement.getUpfrontPayment(),
            balance,
            installments,
            nextPeriod)));
      } else {
        appendHistory(
            module, period, "purchase-paid", agreement.getId(), agreement.getTotalFee());
      }
    }

    List<Object> activeLoans = new ArrayList<Object>();
    for (Object value : copyList(module.get("loans"))) {
      LoanAgreement agreement = readLoan(value);
      if (agreement == null) {
        continue;
      }
      int nextWagePeriod = agreement.getNextWagePeriod();
      while (nextWagePeriod <= period && nextWagePeriod <= agreement.getEndPeriod()) {
        if (agreement.getMonthlyWageContribution() > 0) {
          payments.add(new NegotiationPayment(
              agreement.getId(),
              NegotiationPaymentType.WAGE_CONTRIBUTION,
              agreement.getOriginalClubId(),
              agreement.getBorrowerClubId(),
              agreement.getMonthlyWageContribution(),
              1));
        }
        nextWagePeriod = addMonths(nextWagePeriod, 1);
      }
      LoanAgreement updated = new LoanAgreement(
          agreement.getId(),
          agreement.getPlayerId(),
          agreement.getPlayerName(),
          agreement.getOriginalClubId(),
          agreement.getBorrowerClubId(),
          agreement.getStartPeriod(),
          agreement.getEndPeriod(),
          agreement.getLoanFee(),
          agreement.getBorrowerWagePercent(),
          agreement.getMonthlyWageContribution(),
          agreement.getPurchaseOptionPrice(),
          nextWagePeriod);
      activeLoans.add(writeLoan(updated));
      if (period >= updated.getEndPeriod()) {
        maturedLoans.add(updated);
      }
    }

    module.put("purchases", activePurchases);
    module.put("loans", activeLoans);
    module.put("lastProcessedPeriod", Long.valueOf(period));
    if (!payments.isEmpty()) {
      appendHistory(
          module,
          period,
          "monthly-payments",
          "period-" + period,
          totalPayments(payments));
    }
    ModState updated = state.withModule(MODULE_ID, module);
    return new NegotiationMonthResult(updated, payments, maturedLoans, true);
  }

  public LoanAgreement findLoanAgreement(ModState state, int playerId) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    for (Object value : copyList(state.getModule(MODULE_ID).get("loans"))) {
      LoanAgreement agreement = readLoan(value);
      if (agreement != null && agreement.getPlayerId() == playerId) {
        return agreement;
      }
    }
    return null;
  }

  public List<PurchaseAgreement> getPurchaseAgreements(ModState state) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    List<PurchaseAgreement> result = new ArrayList<PurchaseAgreement>();
    for (Object value : copyList(state.getModule(MODULE_ID).get("purchases"))) {
      PurchaseAgreement agreement = readPurchase(value);
      if (agreement != null) {
        result.add(agreement);
      }
    }
    return Collections.unmodifiableList(result);
  }

  public List<LoanAgreement> getLoanAgreements(ModState state) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    List<LoanAgreement> result = new ArrayList<LoanAgreement>();
    for (Object value : copyList(state.getModule(MODULE_ID).get("loans"))) {
      LoanAgreement agreement = readLoan(value);
      if (agreement != null) {
        result.add(agreement);
      }
    }
    return Collections.unmodifiableList(result);
  }

  public NegotiationRegistration closeLoan(
      ModState state, int period, int playerId, String reason) {
    requireStateAndPeriod(state, period);
    if (reason == null || reason.length() == 0 || reason.length() > 40) {
      throw new IllegalArgumentException("Loan close reason is invalid");
    }
    Map<String, Object> module = copyObject(state.getModule(MODULE_ID));
    List<Object> active = new ArrayList<Object>();
    LoanAgreement closed = null;
    for (Object value : copyList(module.get("loans"))) {
      LoanAgreement agreement = readLoan(value);
      if (agreement == null) {
        continue;
      }
      if (closed == null && agreement.getPlayerId() == playerId) {
        closed = agreement;
      } else {
        active.add(writeLoan(agreement));
      }
    }
    if (closed == null) {
      return new NegotiationRegistration(state, null, null, false);
    }
    module.put("loans", active);
    appendHistory(
        module,
        period,
        "loan-" + reason,
        closed.getId(),
        closed.getPurchaseOptionPrice());
    return new NegotiationRegistration(
        state.withModule(MODULE_ID, module), null, closed, true);
  }

  private PurchaseAgreement readPurchase(Object value) {
    Map<String, Object> source = copyObject(value);
    if (source.isEmpty()) {
      return null;
    }
    try {
      int nextPeriod = integer(source.get("nextPaymentPeriod"), -1);
      if (!validPeriod(nextPeriod)) {
        return null;
      }
      return new PurchaseAgreement(
          string(source.get("id")),
          integer(source.get("playerId"), -1),
          string(source.get("playerName")),
          integer(source.get("sellerClubId"), -1),
          integer(source.get("buyerClubId"), -1),
          integer(source.get("totalFee"), -1),
          integer(source.get("upfrontPayment"), -1),
          integer(source.get("remainingBalance"), -1),
          integer(source.get("remainingInstallments"), -1),
          nextPeriod);
    } catch (IllegalArgumentException exception) {
      return null;
    }
  }

  private Map<String, Object> writePurchase(PurchaseAgreement agreement) {
    Map<String, Object> target = new LinkedHashMap<String, Object>();
    target.put("id", agreement.getId());
    target.put("playerId", Long.valueOf(agreement.getPlayerId()));
    target.put("playerName", agreement.getPlayerName());
    target.put("sellerClubId", Long.valueOf(agreement.getSellerClubId()));
    target.put("buyerClubId", Long.valueOf(agreement.getBuyerClubId()));
    target.put("totalFee", Long.valueOf(agreement.getTotalFee()));
    target.put("upfrontPayment", Long.valueOf(agreement.getUpfrontPayment()));
    target.put("remainingBalance", Long.valueOf(agreement.getRemainingBalance()));
    target.put(
        "remainingInstallments", Long.valueOf(agreement.getRemainingInstallments()));
    target.put("nextPaymentPeriod", Long.valueOf(agreement.getNextPaymentPeriod()));
    return target;
  }

  private LoanAgreement readLoan(Object value) {
    Map<String, Object> source = copyObject(value);
    if (source.isEmpty()) {
      return null;
    }
    try {
      int start = integer(source.get("startPeriod"), -1);
      int end = integer(source.get("endPeriod"), -1);
      int nextWage = integer(source.get("nextWagePeriod"), -1);
      if (!validPeriod(start) || !validPeriod(end) || !validPeriod(nextWage)) {
        return null;
      }
      return new LoanAgreement(
          string(source.get("id")),
          integer(source.get("playerId"), -1),
          string(source.get("playerName")),
          integer(source.get("originalClubId"), -1),
          integer(source.get("borrowerClubId"), -1),
          start,
          end,
          integer(source.get("loanFee"), -1),
          integer(source.get("borrowerWagePercent"), -1),
          integer(source.get("monthlyWageContribution"), -1),
          integer(source.get("purchaseOptionPrice"), -1),
          nextWage);
    } catch (IllegalArgumentException exception) {
      return null;
    }
  }

  private Map<String, Object> writeLoan(LoanAgreement agreement) {
    Map<String, Object> target = new LinkedHashMap<String, Object>();
    target.put("id", agreement.getId());
    target.put("playerId", Long.valueOf(agreement.getPlayerId()));
    target.put("playerName", agreement.getPlayerName());
    target.put("originalClubId", Long.valueOf(agreement.getOriginalClubId()));
    target.put("borrowerClubId", Long.valueOf(agreement.getBorrowerClubId()));
    target.put("startPeriod", Long.valueOf(agreement.getStartPeriod()));
    target.put("endPeriod", Long.valueOf(agreement.getEndPeriod()));
    target.put("loanFee", Long.valueOf(agreement.getLoanFee()));
    target.put("borrowerWagePercent", Long.valueOf(agreement.getBorrowerWagePercent()));
    target.put(
        "monthlyWageContribution",
        Long.valueOf(agreement.getMonthlyWageContribution()));
    target.put("purchaseOptionPrice", Long.valueOf(agreement.getPurchaseOptionPrice()));
    target.put("nextWagePeriod", Long.valueOf(agreement.getNextWagePeriod()));
    return target;
  }

  private int nextSequence(Map<String, Object> module) {
    int current = Math.max(0, integer(module.get("sequence"), 0));
    if (current == Integer.MAX_VALUE) {
      throw new IllegalStateException("Negotiation sequence overflow");
    }
    int next = current + 1;
    module.put("sequence", Long.valueOf(next));
    return next;
  }

  private void appendHistory(
      Map<String, Object> module,
      int period,
      String type,
      String agreementId,
      int amount) {
    List<Object> history = copyList(module.get("history"));
    Map<String, Object> event = new LinkedHashMap<String, Object>();
    event.put("period", Long.valueOf(period));
    event.put("type", type);
    event.put("agreementId", agreementId);
    event.put("amount", Long.valueOf(amount));
    history.add(event);
    while (history.size() > MAX_HISTORY) {
      history.remove(0);
    }
    module.put("history", history);
  }

  private int totalPayments(List<NegotiationPayment> payments) {
    long total = 0L;
    for (NegotiationPayment payment : payments) {
      total += payment.getAmount();
    }
    return (int)Math.min(Integer.MAX_VALUE, total);
  }

  private int roundedPercent(int amount, int percent) {
    return (int)(((long)amount * percent + 50L) / 100L);
  }

  private int divideCeiling(int value, int divisor) {
    return (int)(((long)value + divisor - 1L) / divisor);
  }

  private int addMonths(int period, int months) {
    if (!validPeriod(period) || months < 0) {
      throw new IllegalArgumentException("Invalid negotiation period");
    }
    int year = period / 100;
    int month = period % 100;
    int absoluteMonth = year * 12 + month - 1 + months;
    return absoluteMonth / 12 * 100 + absoluteMonth % 12 + 1;
  }

  private boolean validPeriod(int period) {
    int year = period / 100;
    int month = period % 100;
    return year >= 2000 && year <= 2200 && month >= 1 && month <= 12;
  }

  private void requireStateAndPeriod(ModState state, int period) {
    if (state == null) {
      throw new NullPointerException("state");
    }
    if (!validPeriod(period)) {
      throw new IllegalArgumentException("Negotiation period is invalid");
    }
  }

  private void requireIdentity(
      int playerId, String playerName, int sourceClubId, int destinationClubId) {
    if (playerId < 0 || playerName == null || playerName.length() == 0
        || sourceClubId < 0 || destinationClubId < 0
        || sourceClubId == destinationClubId) {
      throw new IllegalArgumentException("Negotiation identity is invalid");
    }
  }

  private int integer(Object value, int fallback) {
    long number = value instanceof Number ? ((Number)value).longValue() : fallback;
    return number < Integer.MIN_VALUE || number > Integer.MAX_VALUE
        ? fallback : (int)number;
  }

  private String string(Object value) {
    if (!(value instanceof String) || ((String)value).length() == 0) {
      throw new IllegalArgumentException("Negotiation string is missing");
    }
    return (String)value;
  }

  private Map<String, Object> copyObject(Object value) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    if (!(value instanceof Map)) {
      return result;
    }
    for (Map.Entry<?, ?> entry : ((Map<?, ?>)value).entrySet()) {
      if (entry.getKey() instanceof String) {
        result.put((String)entry.getKey(), entry.getValue());
      }
    }
    return result;
  }

  private List<Object> copyList(Object value) {
    return value instanceof List
        ? new ArrayList<Object>((List<?>)value) : new ArrayList<Object>();
  }
}
