package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0271 extends MouseAdapter {
   final bf22.intermediary.C0208 Hu;
   C0271(C0208 c0208) {
      this.Hu = c0208;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0208.b(this.Hu).rowAtPoint(mouseEvent.getPoint());
      if (var2 >= 0 && ((C0827)C0208.qo().get(var2)).tR() != null) {
         C0208.b(this.Hu, var2);
      }
   }
}
