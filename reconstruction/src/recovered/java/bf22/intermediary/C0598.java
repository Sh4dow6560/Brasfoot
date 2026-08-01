package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0598 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      if (j == 0) {
         String var7 = C0710.rY[(Integer)object];
         this.setText(var7);
      } else if (j == 1) {
         this.setIcon(null);
      }

      return this;
   }
}
