package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0130 extends MouseAdapter {
   final bf22.intermediary.C0127 Ax;
   C0130(C0127 c0127) {
      this.Ax = c0127;
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      C0127.a(this.Ax, mouseEvent);
   }

   @Override
   public void mouseReleased(MouseEvent mouseEvent) {
      C0127.b(this.Ax, mouseEvent);
   }
}
