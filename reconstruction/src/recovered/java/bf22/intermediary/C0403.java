package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0403 implements ActionListener {
   final bf22.intermediary.C0401 LD;
   C0403(C0401 c0401) {
      this.LD = c0401;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0401.c(this.LD).dispose();
   }
}
