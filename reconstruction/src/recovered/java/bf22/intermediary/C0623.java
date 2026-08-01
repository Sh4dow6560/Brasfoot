package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0623 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      C0810 var7 = (C0810)object;
      if (var7.fg() != null) {
         this.setBackground(var7.getCorF());
         if (j == 1) {
            this.setIcon(var7.fg().kU());
         } else if (j == 2) {
            this.setHorizontalAlignment(2);
            this.setText(var7.fg().getNome());
         } else if (j == 3) {
            this.setText(Integer.toString(var7.ta()[0]));
         } else if (j == 4) {
            this.setText(Integer.toString(var7.ta()[1]));
         }
      } else {
         if (j < 3) {
            this.setBackground(Color.WHITE);
         } else {
            this.setBackground(var7.getCorF());
         }

         if (j == 3) {
            this.setText("PG");
         }

         if (j == 4) {
            this.setText("J");
         }
      }

      return this;
   }
}
