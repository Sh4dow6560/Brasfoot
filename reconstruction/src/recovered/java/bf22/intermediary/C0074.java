package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0074 implements ActionListener {
   final bf22.intermediary.C0065 wT;
   C0074(C0065 c0065) {
      this.wT = c0065;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0065.b(this.wT, 4);
   }
}
