package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0306 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0306(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0294.c(this.JH);
   }
}
