package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0007 implements ActionListener {
   final bf22.intermediary.C0003 vs;
   C0007(C0003 c0003) {
      this.vs = c0003;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0003.a(this.vs, -1);
   }
}
