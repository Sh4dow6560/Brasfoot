package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0362 implements ActionListener {
   final bf22.intermediary.C0360 Kz;
   C0362(C0360 c0360) {
      this.Kz = c0360;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0360.b(this.Kz).dispose();
   }
}
