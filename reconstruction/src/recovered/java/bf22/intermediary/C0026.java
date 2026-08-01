package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0026 implements ActionListener {
   final bf22.intermediary.C0018 vR;
   C0026(C0018 c0018) {
      this.vR = c0018;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0018.c(this.vR).getSelectedIndex() >= 0) {
         C0018.d(this.vR);
      }
   }
}
