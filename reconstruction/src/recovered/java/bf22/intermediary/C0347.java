package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0347 extends MouseAdapter {
   final bf22.intermediary.C0395 Kg;
   C0347(C0395 c0395) {
      this.Kg = c0395;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0395.c(this.Kg).rowAtPoint(mouseEvent.getPoint());
      int var3 = C0395.c(this.Kg).columnAtPoint(mouseEvent.getPoint());
      if (mouseEvent.getClickCount() == 2) {
         this.Kg.rQ();
      }
   }
}
