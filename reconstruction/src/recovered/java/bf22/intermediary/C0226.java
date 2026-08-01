package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0226 implements ActionListener {
   final bf22.intermediary.C0225 Ft;
   C0226(C0225 c0225) {
      this.Ft = c0225;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0225.a(this.Ft).dispose();
   }
}
