package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0641 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0789 var7 = (C0789)object;
      if (object != null) {
         if (j == 0) {
            this.setFont(new Font("Tahoma", 1, 11));
            this.setHorizontalAlignment(4);
            this.setText(var7.uJ());
         }

         if (j == 1) {
            this.setText(var7.uK());
         }
      }

      return this;
   }
}
