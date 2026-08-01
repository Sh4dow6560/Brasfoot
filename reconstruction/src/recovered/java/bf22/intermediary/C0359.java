package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0359 implements ActionListener {
   final bf22.intermediary.C0197 GK;
   C0359(C0197 c0197) {
      this.GK = c0197;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0197.d(this.GK);
   }
}
