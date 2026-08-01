package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0774 extends MouseAdapter {
   final bf22.intermediary.C0773 QX;
   C0774(C0773 c0773) {
      this.QX = c0773;
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      C0773.a(this.QX, mouseEvent);
   }
}
