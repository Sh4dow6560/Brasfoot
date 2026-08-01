package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0356 implements ActionListener {
   final bf22.intermediary.C0350 aeO;
   C0356(C0350 c0350) {
      this.aeO = c0350;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0350.f(this.aeO) != null) {
         C0350.i(this.aeO);
      }
   }
}
