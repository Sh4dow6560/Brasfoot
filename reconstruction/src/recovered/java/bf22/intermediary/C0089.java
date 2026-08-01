package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0089 implements ActionListener {
   final bf22.intermediary.C0132 Bq;
   C0089(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0132.e(this.Bq).bV(2);
      C0132.a(this.Bq, C0132.e(this.Bq).kS());
      C0132.b(this.Bq, -1);
      C0132.c(this.Bq, -1);
   }
}
