package bf22.intermediary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class C0387 extends MouseMotionAdapter {
   final bf22.intermediary.C0383 JZ;
   C0387(C0383 c0383) {
      this.JZ = c0383;
   }

   @Override
   public void mouseDragged(MouseEvent mouseEvent) {
      C0383.c(this.JZ, mouseEvent);
   }
}
