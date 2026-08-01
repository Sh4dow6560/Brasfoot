package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0111 extends MouseAdapter {
   final bf22.intermediary.C0108 zy;
   C0111(C0108 c0108) {
      this.zy = c0108;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0108.a(this.zy, mouseEvent.getComponent());
   }
}
