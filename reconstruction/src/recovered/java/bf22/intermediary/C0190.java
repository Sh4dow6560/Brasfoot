package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0190 extends MouseAdapter {
   final bf22.intermediary.C0238 Gn;
   C0190(C0238 c0238) {
      this.Gn = c0238;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0238.c(this.Gn);
   }
}
