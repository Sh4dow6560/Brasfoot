package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0492 implements ActionListener {
   final bf22.intermediary.C0489 MB;
   C0492(C0489 c0489) {
      this.MB = c0489;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0489.c(this.MB);
   }
}
