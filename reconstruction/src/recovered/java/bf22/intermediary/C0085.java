package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0085 implements ActionListener {
   final bf22.intermediary.C0132 Bq;
   C0085(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.SR.f(C0132.j(this.Bq).isSelected());
   }
}
