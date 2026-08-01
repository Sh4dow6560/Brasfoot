package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0617 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0722 var7 = (C0722)object;
      if (j == 0) {
         this.setText(Integer.toString(i + 1));
      } else if (j == 1) {
         this.setText(var7.x().getNome());
      } else if (j == 2) {
         if (var7.x().fg() != null) {
            this.setText(var7.x().fg().getNome());
         }
      } else if (j == 3) {
         this.setText(String.format("%.2f", var7.F()));
      } else if (j == 4) {
         Double var8 = var7.D();
         int var9 = var8.intValue();
         this.setText(Integer.toString(var9));
      }

      return this;
   }
}
