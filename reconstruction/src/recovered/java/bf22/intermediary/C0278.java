package bf22.intermediary;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

class C0278 extends MouseAdapter {
   final bf22.intermediary.C0272 Iz;
   C0278(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0272.c(this.Iz).rowAtPoint(mouseEvent.getPoint());
      int var3 = C0272.c(this.Iz).columnAtPoint(mouseEvent.getPoint());
      int var4 = mouseEvent.getClickCount();
      if (var4 >= 2) {
         this.Iz.qC();
      }
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      if (SwingUtilities.isRightMouseButton(mouseEvent)) {
         Point var2 = mouseEvent.getPoint();
         int var3 = C0272.c(this.Iz).rowAtPoint(var2);
         ListSelectionModel var4 = C0272.c(this.Iz).getSelectionModel();
         var4.setSelectionInterval(var3, var3);
      }
   }
}
