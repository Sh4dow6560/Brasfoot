package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0399 extends AbstractAction {
   final bf22.intermediary.C0450 LA;
   C0399(C0450 c0450) {
      this.LA = c0450;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0450.a(this.LA).dispose();
   }
}
