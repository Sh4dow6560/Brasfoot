package mod.extension.negotiation;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import mod.recovered.finance.ClubFinances;

final class NegotiationTermsDialog {
  private NegotiationTermsDialog() {
  }

  static PurchaseTerms choosePurchaseTerms(
      Component parent, String playerName, int totalFee) {
    PurchasePlan[] plans = new PurchasePlan[]{
        new PurchasePlan(totalFee, 100, 0),
        new PurchasePlan(totalFee, 50, 3),
        new PurchasePlan(totalFee, 40, 6),
        new PurchasePlan(totalFee, 25, 12)
    };
    if (GraphicsEnvironment.isHeadless()) {
      return plans[0].terms;
    }
    PurchasePlan selected = (PurchasePlan)JOptionPane.showInputDialog(
        parent,
        "Defina a forma de pagamento por " + playerName + ":",
        "Termos da transfer\u00eancia",
        JOptionPane.PLAIN_MESSAGE,
        null,
        plans,
        plans[0]);
    return selected == null ? null : selected.terms;
  }

  static LoanTerms chooseLoanTerms(
      Component parent, String playerName, int marketValue) {
    int maximum = (int)Math.max(
        1_000L, Math.min(1_000_000_000L, (long)marketValue * 2L));
    int step = Math.max(1_000, rounded(Math.max(1, marketValue / 100), 1_000));
    int defaultFee = Math.min(maximum, rounded(Math.max(0, marketValue / 20), 1_000));
    int defaultOption = Math.min(
        maximum, rounded(Math.max(1_000, marketValue * 11L / 10L), 1_000));
    JComboBox<Integer> duration = new JComboBox<Integer>(new Integer[]{6, 12});
    duration.setSelectedItem(Integer.valueOf(12));
    JSpinner loanFee = new JSpinner(new SpinnerNumberModel(
        defaultFee, 0, maximum, step));
    JComboBox<Integer> wageShare =
        new JComboBox<Integer>(new Integer[]{25, 50, 75, 100});
    wageShare.setSelectedItem(Integer.valueOf(100));
    JCheckBox optionEnabled = new JCheckBox("Incluir op\u00e7\u00e3o de compra", true);
    JSpinner optionPrice = new JSpinner(new SpinnerNumberModel(
        defaultOption, 1_000, maximum, step));
    optionEnabled.addActionListener(event ->
        optionPrice.setEnabled(optionEnabled.isSelected()));

    JPanel panel = new JPanel(new GridLayout(0, 2, 8, 6));
    panel.add(new JLabel("Jogador:"));
    panel.add(new JLabel(playerName));
    panel.add(new JLabel("Dura\u00e7\u00e3o (meses):"));
    panel.add(duration);
    panel.add(new JLabel("Taxa de empr\u00e9stimo:"));
    panel.add(loanFee);
    panel.add(new JLabel("Sal\u00e1rio pago pelo seu clube:"));
    panel.add(wageShare);
    panel.add(optionEnabled);
    panel.add(optionPrice);
    if (GraphicsEnvironment.isHeadless()) {
      return new LoanTerms(12, defaultFee, 100, defaultOption);
    }
    int choice = JOptionPane.showConfirmDialog(
        parent,
        panel,
        "Termos do empr\u00e9stimo",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    if (choice != JOptionPane.OK_OPTION) {
      return null;
    }
    return new LoanTerms(
        ((Integer)duration.getSelectedItem()).intValue(),
        ((Number)loanFee.getValue()).intValue(),
        ((Integer)wageShare.getSelectedItem()).intValue(),
        optionEnabled.isSelected()
            ? ((Number)optionPrice.getValue()).intValue() : 0);
  }

  private static int rounded(long value, int step) {
    long result = ((Math.max(0L, value) + step / 2L) / step) * step;
    return (int)Math.min(1_000_000_000L, result);
  }

  private static final class PurchasePlan {
    private final PurchaseTerms terms;

    private PurchasePlan(int totalFee, int upfrontPercent, int installments) {
      if (installments > 0 && totalFee <= 1) {
        installments = 0;
      }
      int upfront = installments == 0
          ? totalFee
          : Math.max(1, (int)((long)totalFee * upfrontPercent / 100L));
      if (installments > 0 && upfront >= totalFee) {
        upfront = totalFee - 1;
      }
      this.terms = new PurchaseTerms(totalFee, upfront, installments);
    }

    @Override
    public String toString() {
      if (this.terms.isCashPurchase()) {
        return "\u00c0 vista: " + ClubFinances.formatAmount(this.terms.getTotalFee());
      }
      int installment = (this.terms.getDeferredBalance()
          + this.terms.getInstallmentCount() - 1)
          / this.terms.getInstallmentCount();
      return ClubFinances.formatAmount(this.terms.getUpfrontPayment())
          + " + " + this.terms.getInstallmentCount() + " parcelas de aproximadamente "
          + ClubFinances.formatAmount(installment);
    }
  }
}
