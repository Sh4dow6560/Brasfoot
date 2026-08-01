package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0099 implements ActionListener {
   final bf22.intermediary.C0132 Bq;
   C0099(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0132.d(this.Bq).getSelectedIndex() >= 0) {
         C0132.e(this.Bq).kj()[1] = C0132.d(this.Bq).getSelectedIndex();
      }
   }
}
