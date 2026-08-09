package mod.extension.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mod.extension.infrastructure.StadiumInfrastructureBridge;

public final class StadiumInfrastructureAction implements ActionListener {
  private final Component parent;

  public StadiumInfrastructureAction(Component parent) {
    this.parent = parent;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    StadiumInfrastructureBridge.openDashboard(this.parent);
  }
}
