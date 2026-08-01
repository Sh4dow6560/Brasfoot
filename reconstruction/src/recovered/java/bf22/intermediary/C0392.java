package bf22.intermediary;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0392 extends MouseAdapter {
   final bf22.intermediary.C0388 Ke;
   C0392(C0388 c0388) {
      this.Ke = c0388;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0388.f(this.Ke).setCursor(new Cursor(3));
      C0388.g(this.Ke);
      C0388.f(this.Ke).setCursor(new Cursor(12));
   }
}
