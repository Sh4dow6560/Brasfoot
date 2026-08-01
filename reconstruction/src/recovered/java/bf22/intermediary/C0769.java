package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0769 implements ActionListener {
   final bf22.intermediary.C0762 QR;
   C0769(C0762 c0762) {
      this.QR = c0762;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0762.a(this.QR);
   }
}
