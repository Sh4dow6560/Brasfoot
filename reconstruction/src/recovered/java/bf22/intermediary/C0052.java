package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0052 implements ActionListener {
   final bf22.intermediary.C0051 zt;
   C0052(C0051 c0051) {
      this.zt = c0051;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0051.a(this.zt);
      C0051.b(this.zt).dispose();
   }
}
