package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0380 implements ActionListener {
   final bf22.intermediary.C0379 JW;
   C0380(C0379 c0379) {
      this.JW = c0379;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0379.a(this.JW).dispose();
   }
}
