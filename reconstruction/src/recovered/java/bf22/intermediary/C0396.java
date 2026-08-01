package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0396 implements ActionListener {
   final bf22.intermediary.C0395 Kg;
   C0396(C0395 c0395) {
      this.Kg = c0395;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0395.a(this.Kg);
   }
}
