package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0121 implements ActionListener {
   final bf22.intermediary.C0120 Ae;
   C0121(C0120 c0120) {
      this.Ae = c0120;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0120.a(this.Ae).dispose();
   }
}
