package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0081 extends AbstractAction {
   final bf22.intermediary.C0132 Bq;
   C0081(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Bq.oh();
   }
}
