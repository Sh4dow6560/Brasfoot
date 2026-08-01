package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0367 implements ActionListener {
   final bf22.intermediary.C0197 GK;
   C0367(C0197 c0197) {
      this.GK = c0197;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0197.e(this.GK);
   }
}
