package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0518 implements ActionListener {
   final bf22.intermediary.C0512 afI;
   C0518(C0512 c0512) {
      this.afI = c0512;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0512.d(this.afI);
   }
}
