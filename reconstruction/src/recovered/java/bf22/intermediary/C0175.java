package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0175 implements ActionListener {
   final bf22.intermediary.C0171 Cm;
   C0175(C0171 c0171) {
      this.Cm = c0171;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0171.d(this.Cm);
   }
}
