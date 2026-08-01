package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0839 extends MouseAdapter {
   final bf22.intermediary.C0901 Vh;
   C0839(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      this.Vh.wA();
   }
}
