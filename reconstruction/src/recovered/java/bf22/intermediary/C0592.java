package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class C0592 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      MatteBorder var7 = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
      super.setBorder(var7);
      C0810 var8 = (C0810)object;
      if (var8.fg() == null && !var8.te()) {
         if (var8.tb()) {
            if (j == 2) {
               this.setHorizontalAlignment(2);
               super.setFont(new Font("Tahoma", 1, 12));
               this.setText(var8.getInfo());
            }
         } else if (var8.tg()) {
            if (j == 2) {
               this.setHorizontalAlignment(2);
               this.setText(var8.tc());
            }
         } else if (var8.tf() != null) {
            if (j == 2) {
               this.setHorizontalAlignment(2);
               this.setText(var8.tf().getNome());
               this.setIcon(var8.tf().kU());
            }
         } else {
            String[] var10 = new String[]{"", "", "", "PG", "J", "V", "E", "D", "GP", "GC", "SG"};
            if (j < var10.length) {
               this.setText(var10[j]);
            }
         }
      } else if (j == 0) {
         this.setHorizontalAlignment(2);
         this.setText(var8.tc());
      } else if (j == 1) {
         if (var8.fg() != null) {
            ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aiconsc/" + C0710.pr[var8.td()] + ".png"));
            this.setIcon(var9);
         }
      } else if (j == 2) {
         if (var8.fg() != null) {
            this.setIcon(var8.fg().kU());
            this.setHorizontalAlignment(2);
            this.setText(var8.fg().getNome());
         } else {
            this.setText(var8.getInfo());
         }
      } else if (j >= 3) {
         this.setText(Integer.toString(var8.ta()[j - 3]));
      }

      return this;
   }
}
