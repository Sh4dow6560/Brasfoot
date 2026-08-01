package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0016 extends MouseAdapter {
   final bf22.intermediary.C0012 vO;
   C0016(C0012 c0012) {
      this.vO = c0012;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      if (mouseEvent.getClickCount() == 2) {
         this.vO.mZ();
      }
   }
}
