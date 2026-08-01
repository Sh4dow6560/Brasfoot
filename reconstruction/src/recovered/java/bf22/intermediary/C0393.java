package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0393 extends MouseAdapter {
   final bf22.intermediary.C0388 Ke;
   C0393(C0388 c0388) {
      this.Ke = c0388;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      System.exit(0);
   }
}
