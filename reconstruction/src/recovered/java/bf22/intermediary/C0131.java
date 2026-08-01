package bf22.intermediary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class C0131 extends MouseMotionAdapter {
   final bf22.intermediary.C0127 Ax;
   C0131(C0127 c0127) {
      this.Ax = c0127;
   }

   @Override
   public void mouseDragged(MouseEvent mouseEvent) {
      C0127.c(this.Ax, mouseEvent);
   }
}
