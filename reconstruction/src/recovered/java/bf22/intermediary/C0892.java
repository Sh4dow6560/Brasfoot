package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0892 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setBackground(Color.YELLOW);
      super.setForeground(Color.BLACK);
      if (j == 1) {
         String var7 = C0696.values()[(Integer)object].getNome();
         this.setText(var7);
         ImageIcon var8 = new ImageIcon(this.getClass().getResource("/aflags/" + object + ".png"));
         this.setIcon(var8);
      }

      if (j == 0) {
         this.setText((String)object);
         this.setIcon(null);
      }

      return this;
   }
}
