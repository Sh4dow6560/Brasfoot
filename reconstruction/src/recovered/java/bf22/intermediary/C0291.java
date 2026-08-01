package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0291 implements ActionListener {
   final bf22.intermediary.C0272 Iz;
   C0291(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Iz.Hz.show(C0272.m(this.Iz), 0, C0272.m(this.Iz).getHeight());
   }
}
