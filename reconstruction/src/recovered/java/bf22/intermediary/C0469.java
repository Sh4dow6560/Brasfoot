package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0469 implements ActionListener {
   final bf22.intermediary.C0468 MZ;
   C0469(C0468 c0468) {
      this.MZ = c0468;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0468.a(this.MZ).dispose();
   }
}
