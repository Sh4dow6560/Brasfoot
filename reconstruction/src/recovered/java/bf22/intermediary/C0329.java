package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0329 extends AbstractAction {
   final bf22.intermediary.C0272 Iz;
   C0329(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Iz.ad(false);
   }
}
