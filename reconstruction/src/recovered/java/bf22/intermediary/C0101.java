package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0101 implements ActionListener {
   final bf22.intermediary.C0132 Bq;
   C0101(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0132.g(this.Bq).getSelectedIndex() >= 0) {
         C0132.e(this.Bq).getTacticalSettings()[3] = C0132.g(this.Bq).getSelectedIndex();
      }
   }
}
