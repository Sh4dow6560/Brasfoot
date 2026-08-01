package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0204 implements ActionListener {
   final bf22.intermediary.C0200 GR;
   C0204(C0200 c0200) {
      this.GR = c0200;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.c(C0200.d(this.GR), false);
      C0200.a(this.GR).dispose();
   }
}
