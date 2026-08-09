package mod.extension.ui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mod.extension.reach.ClubReachBridge;
import mod.extension.sponsorship.SponsorshipBridge;
import mod.extension.state.Feature;
import mod.extension.state.ModRuntime;

public final class ModSettingsAction implements ActionListener {
  private final Component parent;

  public ModSettingsAction(Component parent) {
    this.parent = parent;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    JCheckBox boardObjectives = new JCheckBox(
        "Objetivos mensais da diretoria",
        ModRuntime.isFeatureEnabled(Feature.BOARD_OBJECTIVES));
    JCheckBox sponsorships = new JCheckBox(
        "Contratos de patroc\u00ednio",
        ModRuntime.isFeatureEnabled(Feature.SPONSORSHIPS));
    JCheckBox clubReach = new JCheckBox(
        "Torcida, redes sociais e alcance mundial",
        ModRuntime.isFeatureEnabled(Feature.CLUB_REACH));
    JPanel panel = new JPanel(new GridLayout(0, 1, 0, 6));
    panel.add(boardObjectives);
    panel.add(sponsorships);
    panel.add(clubReach);
    int choice = JOptionPane.showConfirmDialog(
        this.parent,
        panel,
        "Recursos adicionais",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    if (choice != JOptionPane.OK_OPTION) {
      return;
    }

    ModRuntime.setFeatureEnabled(
        Feature.BOARD_OBJECTIVES, boardObjectives.isSelected());
    boolean sponsorshipWasEnabled =
        ModRuntime.isFeatureEnabled(Feature.SPONSORSHIPS);
    ModRuntime.setFeatureEnabled(
        Feature.SPONSORSHIPS, sponsorships.isSelected());
    if (!sponsorshipWasEnabled && sponsorships.isSelected()) {
      SponsorshipBridge.openOffersForUserClubs(this.parent);
    }
    boolean clubReachWasEnabled = ModRuntime.isFeatureEnabled(Feature.CLUB_REACH);
    ModRuntime.setFeatureEnabled(Feature.CLUB_REACH, clubReach.isSelected());
    if (!clubReachWasEnabled && clubReach.isSelected()) {
      ClubReachBridge.openDashboard(this.parent);
    }
  }
}
