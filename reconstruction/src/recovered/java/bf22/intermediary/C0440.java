package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0440 extends AbstractAction {
   final bf22.intermediary.C0435 Lt;
   C0440(C0435 c0435) {
      this.Lt = c0435;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0435.a(this.Lt);
   }
}
