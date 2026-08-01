package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0187 extends AbstractAction {
   final bf22.intermediary.C0238 Gn;
   C0187(C0238 c0238) {
      this.Gn = c0238;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0238.a(this.Gn);
   }
}
