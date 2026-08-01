package bf22.intermediary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class C0091 extends MouseMotionAdapter {
   final bf22.intermediary.C0132 Bq;
   C0091(C0132 c0132) {
      this.Bq = c0132;
   }

   @Override
   public void mouseDragged(MouseEvent mouseEvent) {
      C0132.d(this.Bq, mouseEvent);
   }
}
