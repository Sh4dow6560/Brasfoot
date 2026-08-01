package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0140 implements ActionListener {
   final bf22.intermediary.C0137 DI;
   C0140(C0137 c0137) {
      this.DI = c0137;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0137.b(this.DI);
   }
}
