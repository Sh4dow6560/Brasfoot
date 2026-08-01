package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0552 implements ActionListener {
   final bf22.intermediary.C0551 uJ;
   C0552(C0551 c0551) {
      this.uJ = c0551;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0551.a(this.uJ).dispose();
   }
}
