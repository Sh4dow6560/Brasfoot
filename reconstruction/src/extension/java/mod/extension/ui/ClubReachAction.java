package mod.extension.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mod.extension.reach.ClubReachBridge;

public final class ClubReachAction implements ActionListener {
  private final Component parent;

  public ClubReachAction(Component parent) {
    this.parent = parent;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    ClubReachBridge.openDashboard(this.parent);
  }
}
