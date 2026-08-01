package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.finance.ClubFinances;

public class C0635 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0815 var7 = (C0815)object;
      if (var7 != null) {
         if (var7.isBold()) {
            this.setFont(new Font("Tahoma", 1, 11));
         }

         if (j == 0) {
            this.setHorizontalAlignment(4);
            this.setText(var7.sT());
         } else if (j == 1 && !var7.tt()) {
            this.setText(ClubFinances.c(var7.ts()));
         }
      }

      return this;
   }
}
