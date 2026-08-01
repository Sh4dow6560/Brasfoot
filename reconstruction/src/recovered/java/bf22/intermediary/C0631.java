package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0631 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0813 var7 = (C0813)object;
      if (var7 != null) {
         if (j == 0) {
            this.setIcon(var7.fg().kU());
            if (var7.fg() != null) {
               this.setText(var7.fg().getNome());
            }
         } else if (j == 1) {
            if (var7.tj() != null) {
               this.setText(var7.tj().dS());
            }
         } else if (j == 2) {
            if (var7.tk() != null) {
               this.setText(var7.tk().dS());
            }
         } else if (j == 3) {
            this.setText(C0710.sh[var7.tl()]);
         }
      }

      return this;
   }
}
