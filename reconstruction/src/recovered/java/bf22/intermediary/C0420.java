package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0420 extends MouseAdapter {
   final bf22.intermediary.C0419 MA;
   C0420(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0419.a(this.MA).rowAtPoint(mouseEvent.getPoint());
      int var3 = C0419.a(this.MA).columnAtPoint(mouseEvent.getPoint());
      int var4 = mouseEvent.getClickCount();
      if (var4 == 1 && var3 == 0) {
         int var5 = C0419.a(this.MA).convertRowIndexToModel(var2);
         ((C0581)C0419.a(this.MA).getModel()).ex(var5);
         C0419.a(this.MA).addNotify();
      }
   }
}
