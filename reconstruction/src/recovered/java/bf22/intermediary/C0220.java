package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0220 implements ActionListener {
   final bf22.intermediary.C0219 EP;
   C0220(C0219 c0219) {
      this.EP = c0219;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0219.a(this.EP).dispose();
   }
}
