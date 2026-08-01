package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0153 implements ActionListener {
   final bf22.intermediary.C0151 DV;
   C0153(C0151 c0151) {
      this.DV = c0151;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0151.a(this.DV);
   }
}
