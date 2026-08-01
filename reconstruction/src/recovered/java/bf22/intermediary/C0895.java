package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0895 extends AbstractAction {
   final bf22.intermediary.C0893 Ut;
   C0895(C0893 c0893) {
      this.Ut = c0893;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0893.b(this.Ut);
   }
}
