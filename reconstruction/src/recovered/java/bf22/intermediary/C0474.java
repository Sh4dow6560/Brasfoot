package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0474 implements ActionListener {
   final bf22.intermediary.C0272 Iz;
   C0474(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Iz.dp(0);
   }
}
