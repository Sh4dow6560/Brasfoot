package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0314 extends MouseAdapter {
   final bf22.intermediary.C0294 JH;
   C0314(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0294.e(this.JH).rowAtPoint(mouseEvent.getPoint());
      int var3 = C0294.e(this.JH).columnAtPoint(mouseEvent.getPoint());
      int var4 = mouseEvent.getClickCount();
      if (var4 == 1 && var3 == 0) {
         int var5 = C0294.e(this.JH).convertRowIndexToModel(var2);
         ((C0566)C0294.e(this.JH).getModel()).ex(var5);
         C0294.e(this.JH).addNotify();
      }
   }
}
