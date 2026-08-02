package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0602 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      if (j == 0) {
         int var8 = 0;
         if (object instanceof Integer) {
            var8 = (Integer)object;
         } else if (object instanceof String) {
            var8 = Integer.parseInt((String)object);
         }

         ImageIcon var7;
         if (var8 == 1) {
            var7 = new ImageIcon(this.getClass().getResource("/aicons/ballsel.png"));
         } else {
            var7 = new ImageIcon(this.getClass().getResource("/aicons/balldesel.png"));
         }

         this.setIcon(var7);
         this.setText(null);
         this.setHorizontalAlignment(0);
      } else if (j == 1) {
         String var9 = C0696.values()[(Integer)object].getNome();
         this.setText(var9);
         ImageIcon var10 = new ImageIcon(this.getClass().getResource("/aflags/" + object + ".png"));
         this.setIcon(var10);
      } else if (j == 2) {
         this.setIcon(null);
      }

      return this;
   }
}
