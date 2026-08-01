package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0877 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      if (j == 0) {
         ImageIcon var7;
         if ((Integer)object == 1) {
            var7 = new ImageIcon(this.getClass().getResource("/aicons/player_shirt_greensmall.png"));
         } else {
            var7 = new ImageIcon(this.getClass().getResource("/aicons/player_shirt_graysmall.png"));
         }

         this.setIcon(var7);
         this.setText(null);
      } else if (j == 1) {
         ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aicons/estrela.png"));
         ImageIcon var8 = new ImageIcon(this.getClass().getResource("/aicons/estrelared.png"));
         if ((Integer)object == 0) {
            this.setIcon(null);
            this.setText(null);
         } else if ((Integer)object == 1) {
            this.setIcon(var9);
            this.setText(null);
         } else if ((Integer)object == 2) {
            this.setIcon(var8);
            this.setText(null);
         }
      } else if (j == 2) {
         this.setText((String)object);
         this.setIcon(null);
      } else if (j == 4) {
         String var10 = C0696.valueOf("P" + object).jA();
         this.setText(var10);
         ImageIcon var11 = new ImageIcon(this.getClass().getResource("/aflags/" + object + ".png"));
         this.setIcon(var11);
      } else if (j == 5) {
         this.setHorizontalAlignment(0);
         this.setIcon(null);
      } else {
         this.setIcon(null);
      }

      return this;
   }
}
