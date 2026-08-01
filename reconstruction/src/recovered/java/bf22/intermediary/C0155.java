package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0155 implements ActionListener {
   final bf22.intermediary.C0151 DV;
   C0155(C0151 c0151) {
      this.DV = c0151;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.DV.pm();
   }
}
