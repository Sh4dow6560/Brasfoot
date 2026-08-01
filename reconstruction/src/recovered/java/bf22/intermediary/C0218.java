package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0218 implements ActionListener {
   final bf22.intermediary.C0217 Er;
   C0218(C0217 c0217) {
      this.Er = c0217;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0217.a(this.Er).dispose();
   }
}
