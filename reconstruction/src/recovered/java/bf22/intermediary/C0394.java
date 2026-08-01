package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0394 extends MouseAdapter {
   final bf22.intermediary.C0196 aeK;
   C0394(C0196 c0196) {
      this.aeK = c0196;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0196.a(this.aeK).dispose();
   }
}
