package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0451 implements ActionListener {
   final bf22.intermediary.C0398 uy;
   C0451(C0398 c0398) {
      this.uy = c0398;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0398.a(this.uy).dispose();
   }
}
