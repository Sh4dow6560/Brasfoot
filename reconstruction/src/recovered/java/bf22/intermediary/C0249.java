package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0249 extends MouseAdapter {
   final bf22.intermediary.C0272 Iz;
   C0249(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0272.b(this.Iz);
   }
}
