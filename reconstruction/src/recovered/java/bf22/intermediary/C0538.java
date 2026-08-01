package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0538 implements ActionListener {
   final bf22.intermediary.C0536 Ny;
   C0538(C0536 c0536) {
      this.Ny = c0536;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0536.b(this.Ny).dispose();
   }
}
