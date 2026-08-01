package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0906 extends MouseAdapter {
   final bf22.intermediary.C0901 Vh;
   C0906(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0901.g(this.Vh).columnAtPoint(mouseEvent.getPoint());
      String var3 = C0901.g(this.Vh).getColumnName(var2);
      if (var2 == 0) {
         ((C0878)C0901.g(this.Vh).getModel()).i(0, false);
         C0901.g(this.Vh).addNotify();
      } else if (var2 == 2) {
         ((C0878)C0901.g(this.Vh).getModel()).i(2, false);
         C0901.g(this.Vh).addNotify();
      } else if (var2 == 3) {
         ((C0878)C0901.g(this.Vh).getModel()).i(3, false);
         C0901.g(this.Vh).addNotify();
      } else if (var2 == 5) {
         ((C0878)C0901.g(this.Vh).getModel()).i(5, false);
         C0901.g(this.Vh).addNotify();
      }
   }
}
