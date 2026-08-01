package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0540 implements ActionListener {
   final bf22.intermediary.C0539 Nz;
   C0540(C0539 c0539) {
      this.Nz = c0539;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0539.a(this.Nz).dispose();
   }
}
