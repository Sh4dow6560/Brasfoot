package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0633 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.WHITE);
      super.setBackground(new Color(44, 53, 49));
      Font var7 = new Font("Arial", 0, 11);
      this.setFont(var7);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      if (bl) {
         super.setBackground(Color.WHITE);
         super.setForeground(Color.BLACK);
      }

      C0799 var8 = (C0799)object;
      if (var8 != null) {
         if (!var8.vo()) {
            Font var9 = new Font("Arial", 1, 11);
            this.setFont(var9);
         }

         if (j == 0) {
            this.setText(var8.getData());
         } else if (j == 1) {
            if (var8.vm() < C0711.tP.length) {
               this.setText(C0711.tP[var8.vm()] + " " + var8.vp());
            } else {
               this.setText("");
            }
         }
      }

      return this;
   }
}
