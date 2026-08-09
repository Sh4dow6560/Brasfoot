package mod.extension.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mod.extension.negotiation.AdvancedNegotiationBridge;

public final class AdvancedNegotiationAction implements ActionListener {
  private final Component parent;

  public AdvancedNegotiationAction(Component parent) {
    this.parent = parent;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    AdvancedNegotiationBridge.openDashboard(this.parent);
  }
}
