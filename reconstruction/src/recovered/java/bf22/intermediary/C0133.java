package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0133 implements ActionListener {
   final bf22.intermediary.C0027 uj;
   C0133(C0027 c0027) {
      this.uj = c0027;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0027.b(this.uj);
   }
}
