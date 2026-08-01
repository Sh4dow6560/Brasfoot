package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0202 implements ActionListener {
   final bf22.intermediary.C0200 GR;
   C0202(C0200 c0200) {
      this.GR = c0200;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0200.a(this.GR).dispose();
   }
}
