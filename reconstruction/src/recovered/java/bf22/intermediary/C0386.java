package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0386 extends MouseAdapter {
   final bf22.intermediary.C0383 JZ;
   C0386(C0383 c0383) {
      this.JZ = c0383;
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      C0383.a(this.JZ, mouseEvent);
   }

   @Override
   public void mouseReleased(MouseEvent mouseEvent) {
      C0383.b(this.JZ, mouseEvent);
   }
}
