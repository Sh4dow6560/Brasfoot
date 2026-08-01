package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0126 implements ActionListener {
   final bf22.intermediary.C0125 Ar;
   C0126(C0125 c0125) {
      this.Ar = c0125;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0125.a(this.Ar).dispose();
   }
}
