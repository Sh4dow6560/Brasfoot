package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0097 implements ActionListener {
   final bf22.intermediary.C0132 Bq;
   C0097(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0132.d(this.Bq, ((C0795)C0132.a(this.Bq).get(C0132.b(this.Bq))).x());
   }
}
