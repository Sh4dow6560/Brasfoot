package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0494 implements ActionListener {
   final bf22.intermediary.C0493 ME;
   C0494(C0493 c0493) {
      this.ME = c0493;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0493.a(this.ME).dispose();
   }
}
