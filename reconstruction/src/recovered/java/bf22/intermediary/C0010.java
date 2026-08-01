package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0010 implements ActionListener {
   final bf22.intermediary.C0008 vJ;
   C0010(C0008 c0008) {
      this.vJ = c0008;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0008.c(this.vJ);
   }
}
