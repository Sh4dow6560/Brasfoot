package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0067 implements ActionListener {
   final bf22.intermediary.C0065 wT;
   C0067(C0065 c0065) {
      this.wT = c0065;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0065.c(this.wT).isEnabled()) {
         C0065.a(this.wT, C0065.d(this.wT) - 1, null, null);
      }
   }
}
