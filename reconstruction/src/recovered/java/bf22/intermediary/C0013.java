package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0013 extends AbstractAction {
   final bf22.intermediary.C0012 vO;
   C0013(C0012 c0012) {
      this.vO = c0012;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0012.a(this.vO).dispose();
   }
}
