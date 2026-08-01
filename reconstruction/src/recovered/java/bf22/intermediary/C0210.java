package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0210 extends MouseAdapter {
   final bf22.intermediary.C0208 Hu;
   C0210(C0208 c0208) {
      this.Hu = c0208;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      if (C0208.c(this.Hu) >= 0) {
         C0208.b(this.Hu, C0208.c(this.Hu));
      }
   }
}
