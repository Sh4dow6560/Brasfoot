package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0352 implements ActionListener {
   final bf22.intermediary.C0350 aeO;
   C0352(C0350 c0350) {
      this.aeO = c0350;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0350.d(this.aeO);
   }
}
