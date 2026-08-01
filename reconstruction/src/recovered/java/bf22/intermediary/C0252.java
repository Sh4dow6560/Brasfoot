package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0252 extends MouseAdapter {
   final bf22.intermediary.C0272 Iz;
   C0252(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      this.Iz.G(C0272.p(this.Iz));
   }
}
