package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0143 extends AbstractAction {
   final bf22.intermediary.C0137 DI;
   C0143(C0137 c0137) {
      this.DI = c0137;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0137.b(this.DI);
   }
}
