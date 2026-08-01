package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0115 implements ActionListener {
   final bf22.intermediary.C0113 zT;
   C0115(C0113 c0113) {
      this.zT = c0113;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0113.a(this.zT).dispose();
   }
}
