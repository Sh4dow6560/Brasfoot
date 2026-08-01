package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0141 extends MouseAdapter {
   final bf22.intermediary.C0137 DI;
   C0141(C0137 c0137) {
      this.DI = c0137;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0137.a(this.DI, 1);
   }
}
