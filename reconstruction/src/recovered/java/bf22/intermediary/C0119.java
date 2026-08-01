package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0119 implements ActionListener {
   final bf22.intermediary.C0118 zW;
   C0119(C0118 c0118) {
      this.zW = c0118;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0118.a(this.zW).dispose();
   }
}
