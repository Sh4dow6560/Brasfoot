package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0023 implements ActionListener {
   final bf22.intermediary.C0018 vR;
   C0023(C0018 c0018) {
      this.vR = c0018;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0018.a(this.vR, 3);
   }
}
