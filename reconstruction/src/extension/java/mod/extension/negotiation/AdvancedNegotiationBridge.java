package mod.extension.negotiation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import mod.extension.state.Feature;
import mod.extension.state.ModRuntime;
import mod.recovered.game.CareerState;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;
import mod.recovered.save.GamePersistence;
import mod.recovered.transfer.PlayerLoan;
import mod.recovered.transfer.PlayerTransferRecord;
import mod.recovered.transfer.TransferNegotiation;

public final class AdvancedNegotiationBridge {
  public static final int NOT_HANDLED = -1;
  public static final int CANCELED = -2;
  public static final int COMPLETED = 1;
  public static final int INSUFFICIENT_FUNDS = 5;

  private AdvancedNegotiationBridge() {
  }

  public static boolean canSubmitPurchaseOffer(
      Player player, Club buyer, int totalFee) {
    if (player == null || buyer == null || totalFee <= 0) {
      return false;
    }
    if (!ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)
        || player.getPlayerId() < 0 || !buyer.isUserControlled()) {
      return buyer.getCashBalance() >= totalFee;
    }
    int minimumUpfront = Math.max(1, (int)((long)totalFee * 25L / 100L));
    return buyer.getCashBalance() >= minimumUpfront;
  }

  public static int completePurchase(
      Component parent,
      Player player,
      Club buyer,
      int totalFee,
      boolean youthTransfer) {
    if (!ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)
        || youthTransfer || player == null || buyer == null
        || player.getPlayerId() < 0 || !buyer.isUserControlled()) {
      return NOT_HANDLED;
    }
    Club seller = player.getClub();
    if (seller == null || seller == buyer || totalFee <= 0) {
      return CANCELED;
    }
    PurchaseTerms terms = NegotiationTermsDialog.choosePurchaseTerms(
        parent, player.getNome(), totalFee);
    if (terms == null) {
      return CANCELED;
    }
    if (buyer.getCashBalance() < terms.getUpfrontPayment()) {
      show(
          parent,
          "O clube n\u00e3o possui caixa para a entrada de "
              + mod.recovered.finance.ClubFinances.formatAmount(
                  terms.getUpfrontPayment())
              + ".",
          "Transfer\u00eancia");
      return INSUFFICIENT_FUNDS;
    }

    player.moveToClub(buyer, terms.getUpfrontPayment(), false, false, false);
    updateTransferRecord(player, totalFee);
    if (!terms.isCashPurchase()) {
      ModRuntime.registerPurchaseAgreement(
          currentPeriod(),
          player.getPlayerId(),
          player.getNome(),
          seller.getClubId(),
          buyer.getClubId(),
          terms);
    }
    return COMPLETED;
  }

  public static int tryListedPurchase(
      Component parent, Player player, Club buyer) {
    if (!ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)
        || player == null || player.getPlayerId() < 0) {
      return NOT_HANDLED;
    }
    if (buyer == null || !Boolean.TRUE.equals(player.isTransferListed())) {
      return 0;
    }
    if (buyer == player.getClub()) {
      return 2;
    }
    if (buyer.getSeniorPlayers().size() >= 35) {
      return 3;
    }
    if (!TransferNegotiation.canPlayerJoinClub(player, buyer)) {
      return 4;
    }
    int price = player.getAskingPrice();
    if (!canSubmitPurchaseOffer(player, buyer, price)) {
      return INSUFFICIENT_FUNDS;
    }
    int result = completePurchase(parent, player, buyer, price, false);
    return result == INSUFFICIENT_FUNDS ? CANCELED : result;
  }

  public static int tryLoanPlayer(
      Component parent, Player player, Club borrower) {
    if (!ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)
        || player == null || borrower == null || player.getPlayerId() < 0
        || !borrower.isUserControlled()) {
      return NOT_HANDLED;
    }
    Club originalClub = player.getClub();
    if (originalClub == null) {
      return 0;
    }
    int eligibility = validateLoanEligibility(player, borrower);
    if (eligibility != COMPLETED) {
      return eligibility;
    }
    LoanTerms terms = NegotiationTermsDialog.chooseLoanTerms(
        parent, player.getNome(), player.getMarketValue());
    if (terms == null) {
      return CANCELED;
    }
    if (borrower.getCashBalance() < terms.getLoanFee()) {
      show(
          parent,
          "O clube n\u00e3o possui caixa para a taxa de empr\u00e9stimo.",
          "Empr\u00e9stimo");
      return CANCELED;
    }
    int result = TransferNegotiation.tryLoanPlayer(player, borrower);
    if (result != COMPLETED) {
      return result;
    }
    if (terms.getLoanFee() > 0) {
      borrower.debit(terms.getLoanFee(), 1);
      originalClub.credit(terms.getLoanFee(), 1);
    }
    updateTransferRecord(player, terms.getLoanFee());
    ModRuntime.registerLoanAgreement(
        currentPeriod(),
        player.getPlayerId(),
        player.getNome(),
        originalClub.getClubId(),
        borrower.getClubId(),
        player.getSalary(),
        terms);
    return COMPLETED;
  }

  public static int tryPurchaseLoanOption(
      Component parent, Player player, Club borrower) {
    if (!ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return NOT_HANDLED;
    }
    if (player == null || borrower == null || player.getPlayerId() < 0) {
      return CANCELED;
    }
    if (!borrower.isUserControlled()) {
      return NOT_HANDLED;
    }
    LoanAgreement agreement = ModRuntime.findLoanAgreement(player.getPlayerId());
    if (agreement == null) {
      return NOT_HANDLED;
    }
    if (agreement.getBorrowerClubId() != borrower.getClubId()) {
      return CANCELED;
    }
    if (!agreement.hasPurchaseOption()) {
      show(
          parent,
          "Este contrato de empr\u00e9stimo n\u00e3o possui op\u00e7\u00e3o de compra.",
          "Op\u00e7\u00e3o de compra");
      return CANCELED;
    }
    int price = agreement.getPurchaseOptionPrice();
    if (borrower.getCashBalance() < price) {
      show(
          parent,
          "Sem dinheiro para exercer a op\u00e7\u00e3o de compra de "
              + mod.recovered.finance.ClubFinances.formatAmount(price) + ".",
          "Op\u00e7\u00e3o de compra");
      return INSUFFICIENT_FUNDS;
    }
    int confirmation = GraphicsEnvironment.isHeadless()
        ? JOptionPane.YES_OPTION
        : JOptionPane.showConfirmDialog(
            parent,
            "Exercer a op\u00e7\u00e3o de compra por "
                + mod.recovered.finance.ClubFinances.formatAmount(price) + "?",
            "Op\u00e7\u00e3o de compra",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE);
    if (confirmation != JOptionPane.YES_OPTION) {
      return CANCELED;
    }
    CareerState career = GamePersistence.careerState;
    PlayerLoan loan = career.findPlayerLoan(player);
    if (loan == null || loan.getOriginalClub() == null) {
      ModRuntime.closeLoanAgreement(
          currentPeriod(), player.getPlayerId(), "missing");
      return CANCELED;
    }
    Club originalClub = loan.getOriginalClub();
    career.removePlayerLoan(player);
    player.returnFromLoan(originalClub);
    player.moveToClub(borrower, price, false, false, false);
    updateTransferRecord(player, price);
    ModRuntime.closeLoanAgreement(
        currentPeriod(), player.getPlayerId(), "purchased");
    return COMPLETED;
  }

  public static void closeLoanAgreement(Player player, String reason) {
    if (ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)
        && player != null && player.getPlayerId() >= 0) {
      ModRuntime.closeLoanAgreement(
          currentPeriod(), player.getPlayerId(), reason);
    }
  }

  public static int processMonthly(int year, int month) {
    if (!ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null) {
      return 0;
    }
    NegotiationMonthResult result =
        ModRuntime.processNegotiationMonth(year * 100 + month);
    int actions = 0;
    for (NegotiationPayment payment : result.getPayments()) {
      Club from = career.findClubById(payment.getFromClubId());
      Club to = career.findClubById(payment.getToClubId());
      if (from == null || to == null) {
        continue;
      }
      if (payment.getType() == NegotiationPaymentType.PURCHASE_INSTALLMENT) {
        from.debit(payment.getAmount(), 1);
        to.credit(payment.getAmount(), 1);
      } else {
        from.debitSalaryExpense(payment.getAmount());
        to.credit(payment.getAmount(), 9);
      }
      actions++;
    }
    for (LoanAgreement agreement : result.getMaturedLoans()) {
      PlayerLoan loan = findPlayerLoan(career, agreement.getPlayerId());
      if (loan == null) {
        ModRuntime.closeLoanAgreement(
            year * 100 + month, agreement.getPlayerId(), "expired");
        continue;
      }
      if (loan.returnToOriginalClub()) {
        career.removePlayerLoan(loan.getPlayer());
        ModRuntime.closeLoanAgreement(
            year * 100 + month, agreement.getPlayerId(), "expired");
        actions++;
      }
    }
    return actions;
  }

  public static int openDashboard(Component parent) {
    if (!ModRuntime.isFeatureEnabled(Feature.ADVANCED_NEGOTIATIONS)) {
      show(parent, "Ative o recurso em Recursos adicionais.", "Negocia\u00e7\u00f5es");
      return 0;
    }
    CareerState career = GamePersistence.careerState;
    if (career == null) {
      show(parent, "Nenhuma carreira ativa.", "Negocia\u00e7\u00f5es");
      return 0;
    }
    List<PurchaseAgreement> purchases = ModRuntime.getPurchaseAgreements();
    List<LoanAgreement> loans = ModRuntime.getLoanAgreements();
    StringBuilder report = new StringBuilder();
    report.append("Compras parceladas\n");
    if (purchases.isEmpty()) {
      report.append("Nenhuma obriga\u00e7\u00e3o ativa.\n");
    }
    for (PurchaseAgreement agreement : purchases) {
      report.append("\n").append(agreement.getPlayerName())
          .append(" | saldo ")
          .append(ClubFinances.formatAmount(agreement.getRemainingBalance()))
          .append(" | ").append(agreement.getRemainingInstallments())
          .append(" parcelas | pr\u00f3xima ")
          .append(periodLabel(agreement.getNextPaymentPeriod()));
    }
    report.append("\n\nEmpr\u00e9stimos\n");
    if (loans.isEmpty()) {
      report.append("Nenhum contrato ativo.");
    }
    for (LoanAgreement agreement : loans) {
      Club original = career.findClubById(agreement.getOriginalClubId());
      Club borrower = career.findClubById(agreement.getBorrowerClubId());
      report.append("\n").append(agreement.getPlayerName())
          .append(" | ")
          .append(original == null ? "Clube de origem" : original.getNome())
          .append(" -> ")
          .append(borrower == null ? "Clube atual" : borrower.getNome())
          .append(" | fim ").append(periodLabel(agreement.getEndPeriod()))
          .append(" | sal\u00e1rio do destino ")
          .append(agreement.getBorrowerWagePercent()).append('%');
      if (agreement.hasPurchaseOption()) {
        report.append(" | op\u00e7\u00e3o ")
            .append(ClubFinances.formatAmount(agreement.getPurchaseOptionPrice()));
      }
    }
    show(parent, report.toString(), "Negocia\u00e7\u00f5es avan\u00e7adas");
    return purchases.size() + loans.size();
  }

  private static PlayerLoan findPlayerLoan(CareerState career, int playerId) {
    ArrayList loans = career.getPlayerLoans();
    for (int index = 0; index < loans.size(); index++) {
      Object value = loans.get(index);
      if (value instanceof PlayerLoan
          && ((PlayerLoan)value).getPlayer() != null
          && ((PlayerLoan)value).getPlayer().getPlayerId() == playerId) {
        return (PlayerLoan)value;
      }
    }
    return null;
  }

  private static int validateLoanEligibility(Player player, Club borrower) {
    if (!player.isAvailableForLoan()) {
      return 5;
    }
    if (borrower == player.getClub()) {
      return 2;
    }
    if (borrower.getSeniorPlayers().size() >= 35) {
      return 6;
    }
    int activeLoans = 0;
    ArrayList loans = GamePersistence.careerState.getPlayerLoans();
    for (int index = 0; index < loans.size(); index++) {
      Object value = loans.get(index);
      if (value instanceof PlayerLoan) {
        Player loanedPlayer = ((PlayerLoan)value).getPlayer();
        if (loanedPlayer != null && loanedPlayer.getClub() == borrower) {
          activeLoans++;
        }
      }
    }
    if (activeLoans >= 4) {
      return 3;
    }
    return TransferNegotiation.canPlayerJoinClub(player, borrower)
        ? COMPLETED : 4;
  }

  private static void updateTransferRecord(Player player, int totalFee) {
    ArrayList records = GamePersistence.careerState.getTransferHistory();
    if (records.isEmpty()) {
      return;
    }
    Object value = records.get(records.size() - 1);
    if (value instanceof PlayerTransferRecord
        && ((PlayerTransferRecord)value).getPlayer() == player) {
      ((PlayerTransferRecord)value).setFee(totalFee);
    }
  }

  private static int currentPeriod() {
    Calendar date = GamePersistence.careerState.getCurrentDate();
    return date.get(Calendar.YEAR) * 100 + date.get(Calendar.MONTH) + 1;
  }

  private static String periodLabel(int period) {
    int month = period % 100;
    return (month < 10 ? "0" : "") + month + "/" + period / 100;
  }

  private static void show(Component parent, String text, String title) {
    if (GraphicsEnvironment.isHeadless()) {
      return;
    }
    JTextArea content = new JTextArea(text, 8, 42);
    content.setEditable(false);
    content.setLineWrap(true);
    content.setWrapStyleWord(true);
    JScrollPane scroll = new JScrollPane(content);
    scroll.setPreferredSize(new Dimension(500, 180));
    JOptionPane.showMessageDialog(
        parent, scroll, title, JOptionPane.PLAIN_MESSAGE);
  }
}
