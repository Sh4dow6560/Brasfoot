package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0300 extends MouseAdapter {
   final bf22.intermediary.C0294 JH;
   C0300(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0294.b(this.JH, 3);
   }
}
