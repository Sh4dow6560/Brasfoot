package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0107 extends MouseAdapter {
   final bf22.intermediary.C0051 zt;
   C0107(C0051 c0051) {
      this.zt = c0051;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0051.a(this.zt, mouseEvent.getComponent());
   }
}
