package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0349 extends AbstractAction {
   final bf22.intermediary.C0395 Kg;
   C0349(C0395 c0395) {
      this.Kg = c0395;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0395.d(this.Kg).dispose();
   }
}
