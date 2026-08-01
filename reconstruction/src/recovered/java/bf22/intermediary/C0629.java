package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0629 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      super.setHorizontalTextPosition(11);
      C0675 var7 = (C0675)object;
      if (object != null) {
         if (j == 0) {
            this.setText(((C0693)C0745.SR.R().get(var7.hM())).f());
         } else if (j == 1) {
            this.setHorizontalAlignment(2);
            this.setText(var7.hc().getNome());
            this.setIcon(var7.hc().kU());
         } else if (j == 3) {
            super.setHorizontalTextPosition(2);
            this.setHorizontalAlignment(4);
            this.setText(var7.hd().getNome());
            this.setIcon(var7.hd().kU());
         } else if (j == 4) {
            this.setHorizontalAlignment(4);
            this.setText(var7.hy().getNome());
         }

         if (var7.e()) {
            if (j == 2) {
               String var8 = "";
               var8 = Integer.toString(var7.hu());
               String var9 = "";
               var9 = Integer.toString(var7.hw());
               int[] var10 = var7.hQ();
               if (var10[0] >= 0 && var10[1] >= 0) {
                  var8 = var8 + "(" + Integer.toString(var10[0]) + ") ";
                  var9 = var9 + "(" + Integer.toString(var10[1]) + ") ";
               }

               this.setText(var8 + "x" + var9);
            }
         } else if (j == 2) {
            this.setText("x");
         }
      }

      return this;
   }
}
