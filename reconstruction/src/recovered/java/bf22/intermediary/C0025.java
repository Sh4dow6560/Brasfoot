package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0025 implements ActionListener {
   final bf22.intermediary.C0018 vR;
   C0025(C0018 c0018) {
      this.vR = c0018;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0018.b(this.vR).getSelectedIndex() >= 0) {
         C0018.b(this.vR, C0018.b(this.vR).getSelectedIndex());
      }
   }
}
