package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0059 extends MouseAdapter {
   final bf22.intermediary.C0054 wq;
   C0059(C0054 c0054) {
      this.wq = c0054;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0054.b(this.wq, C0054.c(this.wq) - 1);
   }
}
