package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0230 implements ActionListener {
   final bf22.intermediary.C0229 FK;
   C0230(C0229 c0229) {
      this.FK = c0229;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0229.a(this.FK).dispose();
   }
}
