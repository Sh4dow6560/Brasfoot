package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0371 implements ActionListener {
   final bf22.intermediary.C0369 KE;
   C0371(C0369 c0369) {
      this.KE = c0369;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0369.a(this.KE);
   }
}
