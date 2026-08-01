package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0591 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0721 var7 = (C0721)object;
      if (j == 1) {
         this.setText(var7.getNome());
      } else if (j == 2) {
         if (var7.B() != null) {
            this.setText(var7.B().getNome());
         }
      } else if (j == 3) {
         this.setText(Integer.toString(var7.v()));
      } else if (j == 4) {
         this.setText(Integer.toString(var7.w()));
      }

      return this;
   }
}
