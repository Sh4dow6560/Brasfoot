package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0243 extends AbstractAction {
   final bf22.intermediary.C0272 Iz;
   C0243(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0272.a(this.Iz);
   }
}
