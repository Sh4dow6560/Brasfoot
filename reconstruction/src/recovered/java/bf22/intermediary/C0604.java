package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.model.Coach;

public class C0604 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      Coach var7 = (Coach)object;
      if (var7 != null) {
         if (j == 0) {
            this.setText(var7.dS());
            ImageIcon var8 = new ImageIcon(this.getClass().getResource("/aflags/" + var7.lE() + ".png"));
            this.setIcon(var8);
         } else if (j == 1 && var7.fg() != null) {
            this.setText(var7.fg().getNome());
            this.setIcon(var7.fg().kU());
         }
      }

      return this;
   }
}
