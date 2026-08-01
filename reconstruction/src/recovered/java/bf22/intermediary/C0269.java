package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0269 extends AbstractAction {
   final bf22.intermediary.C0208 Hu;
   C0269(C0208 c0208) {
      this.Hu = c0208;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0208.a(this.Hu, 5);
   }
}
