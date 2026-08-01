package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0503 implements ActionListener {
   final bf22.intermediary.C0498 MI;
   C0503(C0498 c0498) {
      this.MI = c0498;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0498.a(this.MI, actionEvent);
   }
}
