package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0594 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0785 var7 = (C0785)object;
      if (var7 != null) {
         if (j == 0) {
            this.setText(Integer.toString(i + 1));
         } else if (j == 1) {
            this.setText(var7.fg().getNome());
            this.setIcon(var7.fg().kU());
         } else if (j == 2) {
            if (var7.b() == 0) {
               this.setText(GameConstants.pZ[var7.uy()]);
            } else if (var7.b() == 1) {
               this.setHorizontalAlignment(0);
               this.setText("(" + Integer.toString(var7.uy()) + "/" + Integer.toString(var7.uz()) + "/" + Integer.toString(var7.uA()) + ")");
            } else {
               this.setText(Integer.toString(var7.uy()));
            }
         }
      }

      return this;
   }
}
