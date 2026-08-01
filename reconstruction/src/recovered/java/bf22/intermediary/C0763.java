package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0763 implements ActionListener {
   final bf22.intermediary.C0762 QR;
   C0763(C0762 c0762) {
      this.QR = c0762;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0762.a(this.QR);
   }
}
