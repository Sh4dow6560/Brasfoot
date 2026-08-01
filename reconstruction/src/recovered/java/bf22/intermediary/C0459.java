package bf22.intermediary;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

class C0459 extends MouseAdapter {
   final bf22.intermediary.C0452 MV;
   C0459(C0452 c0452) {
      this.MV = c0452;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0452.k(this.MV).rowAtPoint(mouseEvent.getPoint());
      int var3 = C0452.k(this.MV).columnAtPoint(mouseEvent.getPoint());
      int var4 = mouseEvent.getClickCount();
      if (var4 >= 2) {
         C0685.a(C0452.l(this.MV), null);
      }
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      if (SwingUtilities.isRightMouseButton(mouseEvent)) {
         Point var2 = mouseEvent.getPoint();
         int var3 = C0452.k(this.MV).rowAtPoint(var2);
         ListSelectionModel var4 = C0452.k(this.MV).getSelectionModel();
         var4.setSelectionInterval(var3, var3);
      }
   }
}
