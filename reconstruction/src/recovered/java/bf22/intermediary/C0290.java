package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0290 implements ActionListener {
   final bf22.intermediary.C0272 Iz;
   C0290(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0272.k(this.Iz).show(C0272.l(this.Iz), 0, C0272.l(this.Iz).getHeight());
   }
}
