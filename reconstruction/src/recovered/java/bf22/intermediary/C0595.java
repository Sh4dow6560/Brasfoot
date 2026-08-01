package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0595 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0784 var7 = (C0784)object;
      if (var7 != null) {
         if (j == 0) {
            if (var7.fg() != null) {
               this.setText(GameConstants.y(var7.b(), var7.fg().getPais()));
            }
         } else if (j == 1) {
            if (var7.uC() == 1) {
               this.setText("(" + Integer.toString(var7.uy()) + "/" + Integer.toString(var7.uz()) + "/" + Integer.toString(var7.uA()) + ")");
            } else if (var7.uC() == 2) {
               this.setText(Integer.toString(var7.uy()));
            }
         }
      }

      return this;
   }
}
