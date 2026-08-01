package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0029 extends MouseAdapter {
   final bf22.intermediary.C0078 yi;
   C0029(C0078 c0078) {
      this.yi = c0078;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0078.a(this.yi, 1);
   }
}
