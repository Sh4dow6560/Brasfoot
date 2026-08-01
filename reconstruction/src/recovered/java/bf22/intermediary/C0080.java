package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0080 implements ActionListener {
   final bf22.intermediary.C0027 uj;
   C0080(C0027 c0027) {
      this.uj = c0027;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0027.a(this.uj).dispose();
   }
}
