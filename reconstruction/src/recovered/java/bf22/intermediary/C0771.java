package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0771 extends MouseAdapter {
   final bf22.intermediary.C0770 QV;
   C0771(C0770 c0770) {
      this.QV = c0770;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0770.a(this.QV);
   }
}
