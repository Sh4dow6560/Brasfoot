package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0093 extends MouseAdapter {
   final bf22.intermediary.C0132 Bq;
   C0093(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      C0132.b(this.Bq, mouseEvent);
   }

   @Override
   public void mouseReleased(MouseEvent mouseEvent) {
      C0132.c(this.Bq, mouseEvent);
   }
}
