package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0621 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      super.setVerticalAlignment(1);
      this.setIcon(null);
      this.setText("");
      C0828 var7 = (C0828)object;
      if (object != null) {
         if (!var7.method_kw_to()) {
            if (j == 0) {
               this.setHorizontalAlignment(4);
               this.setHorizontalTextPosition(2);
               this.setText(var7.tR().hc().getNome());
               this.setIcon(var7.tR().hc().kU());
            } else if (j == 2) {
               this.setHorizontalAlignment(2);
               this.setHorizontalTextPosition(4);
               this.setText(var7.tR().hd().getNome());
               this.setIcon(var7.tR().hd().kU());
            }

            if (j == 1) {
               if (var7.tR().e()) {
                  String var8 = "";
                  var8 = Integer.toString(var7.tR().hu());
                  String var9 = "";
                  var9 = Integer.toString(var7.tR().hw());
                  this.setText(var8 + "x" + var9);
               } else {
                  this.setText("x");
               }
            }
         } else if (j == 0) {
            this.setFont(new Font("Arial", 1, 12));
            this.setText(var7.sT());
         }
      }

      return this;
   }
}
