package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0756 implements ActionListener {
   final bf22.intermediary.C0754 Qo;
   C0756(C0754 c0754) {
      this.Qo = c0754;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0754.b(this.Qo);
   }
}
