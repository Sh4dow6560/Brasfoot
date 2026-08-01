package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0053 implements ActionListener {
   final bf22.intermediary.C0051 zt;
   C0053(C0051 c0051) {
      this.zt = c0051;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0051.c(this.zt);
   }
}
