package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0005 implements ActionListener {
   final bf22.intermediary.C0003 vs;
   C0005(C0003 c0003) {
      this.vs = c0003;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0208.a(C0003.a(this.vs), C0003.b(this.vs));
      C0003.c(this.vs).dispose();
   }
}
