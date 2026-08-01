package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0481 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0481(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0419.b(this.MA);
   }
}
