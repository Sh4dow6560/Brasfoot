package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0609 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0739 var7 = (C0739)object;
      if (var7 != null) {
         if (j == 0) {
            this.setText(var7.f());
         } else if (j == 1) {
            if (var7.ct() >= 0) {
               this.setText(var7.dR());
            }
         } else if (j == 2) {
            if (var7.dP() != null) {
               this.setText(var7.dP().dS());
            }
         } else if (j == 3 && var7.dO() != null) {
            this.setText(var7.dO().dS());
         }
      }

      return this;
   }
}
