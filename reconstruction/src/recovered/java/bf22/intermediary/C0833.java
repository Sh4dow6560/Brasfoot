package bf22.intermediary;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

class C0833 extends MouseAdapter {
   final bf22.intermediary.C0901 Vh;
   C0833(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      int var2 = C0901.g(this.Vh).rowAtPoint(mouseEvent.getPoint());
      int var3 = C0901.g(this.Vh).columnAtPoint(mouseEvent.getPoint());
      int var4 = mouseEvent.getClickCount();
      if (var4 == 1 && var3 == 0) {
         int var5;
         if (C0901.e(this.Vh)) {
            var5 = C0901.f(this.Vh).getNumeroTitulares();
         } else {
            var5 = C0901.f(this.Vh).getNumeroTitularesJuniores();
         }

         int var6 = C0901.g(this.Vh).convertRowIndexToModel(var2);
         ((C0878)C0901.g(this.Vh).getModel()).Z(var6, var5);
         this.Vh.wo();
         C0901.g(this.Vh).addNotify();
         if (C0901.e(this.Vh)) {
            C0901.m(this.Vh).setText(Integer.toString(C0901.f(this.Vh).getNumeroTitulares()));
         } else {
            C0901.m(this.Vh).setText(Integer.toString(C0901.f(this.Vh).getNumeroTitularesJuniores()));
         }
      } else if (var4 >= 2) {
         this.Vh.wC();
      }
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      if (SwingUtilities.isRightMouseButton(mouseEvent)) {
         Point var2 = mouseEvent.getPoint();
         int var3 = C0901.g(this.Vh).rowAtPoint(var2);
         ListSelectionModel var4 = C0901.g(this.Vh).getSelectionModel();
         var4.setSelectionInterval(var3, var3);
      }
   }
}
