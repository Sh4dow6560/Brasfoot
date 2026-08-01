package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

class C0149 extends MouseAdapter {
   final bf22.intermediary.C0137 DI;
   C0149(C0137 c0137) {
      this.DI = c0137;
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      if (SwingUtilities.isRightMouseButton(mouseEvent)) {
         C0137.a(this.DI, mouseEvent);
      }

      if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
         C0137.b(this.DI, mouseEvent);
      }
   }

   @Override
   public void mouseReleased(MouseEvent mouseEvent) {
      if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
         C0137.a(this.DI, mouseEvent, 0);
      }
   }
}
