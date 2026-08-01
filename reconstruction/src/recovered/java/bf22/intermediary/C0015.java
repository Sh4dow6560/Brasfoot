package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0015 implements ActionListener {
   final bf22.intermediary.C0012 vO;
   C0015(C0012 c0012) {
      this.vO = c0012;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0012.a(this.vO).dispose();
   }
}
