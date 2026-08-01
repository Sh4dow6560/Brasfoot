package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0167 implements ActionListener {
   final bf22.intermediary.C0164 BW;
   C0167(C0164 c0164) {
      this.BW = c0164;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0164.c(this.BW);
   }
}
