package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0292 implements ActionListener {
   final bf22.intermediary.C0186 ux;
   C0292(C0186 c0186) {
      this.ux = c0186;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0186.b(this.ux);
   }
}
