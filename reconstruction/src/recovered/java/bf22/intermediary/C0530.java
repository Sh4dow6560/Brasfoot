package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0530 implements ActionListener {
   final bf22.intermediary.C0526 No;
   C0530(C0526 c0526) {
      this.No = c0526;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0526.b(this.No).dispose();
   }
}
