package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0240 implements ActionListener {
   final bf22.intermediary.C0272 Iz;
   C0240(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Iz.HA.show(C0272.n(this.Iz), 0, C0272.n(this.Iz).getHeight());
   }
}
