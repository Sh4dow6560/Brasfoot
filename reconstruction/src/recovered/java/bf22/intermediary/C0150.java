package bf22.intermediary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class C0150 extends MouseMotionAdapter {
   final bf22.intermediary.C0137 DI;
   C0150(C0137 c0137) {
      this.DI = c0137;
   }

   @Override
   public void mouseDragged(MouseEvent mouseEvent) {
      C0137.b(this.DI, mouseEvent, 0);
   }
}
