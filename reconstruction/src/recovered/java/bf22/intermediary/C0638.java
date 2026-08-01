package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0638 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0692 var7 = (C0692)object;
      if (j == 0) {
         try {
            ImageIcon var8;
            if (var7.jr()) {
               var8 = new ImageIcon(this.getClass().getResource("/aicons/ballsel.png"));
            } else {
               var8 = new ImageIcon(this.getClass().getResource("/aicons/balldesel.png"));
            }

            this.setIcon(var8);
         } catch (Exception var10) {
         }

         this.setText(null);
         this.setHorizontalAlignment(0);
      } else if (j == 1) {
         String var11 = C0696.valueOf("P" + var7.jc()).getNome();
         this.setText(var11);
         ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aflags/" + var7.jc() + ".png"));
         this.setIcon(var9);
      }

      return this;
   }
}
