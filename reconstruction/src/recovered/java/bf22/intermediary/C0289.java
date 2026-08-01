package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0289 implements ActionListener {
   final bf22.intermediary.C0272 Iz;
   C0289(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0272.i(this.Iz).show(C0272.j(this.Iz), 0, C0272.j(this.Iz).getHeight());
   }
}
