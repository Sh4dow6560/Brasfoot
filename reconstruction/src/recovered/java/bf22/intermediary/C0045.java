package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0045 implements ActionListener {
   final bf22.intermediary.C0043 zl;
   C0045(C0043 c0043) {
      this.zl = c0043;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0043.b(this.zl);
   }
}
