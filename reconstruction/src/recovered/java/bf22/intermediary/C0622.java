package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0622 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      C0809 var7 = (C0809)object;
      if (object != null) {
         if (var7.sS()) {
            if (j == 2) {
               this.setHorizontalAlignment(2);
               this.setFont(new Font("Arial", 1, 12));
               this.setText(var7.sT());
            }
         } else if (var7.sP() != null) {
            if (j == 0) {
               this.setHorizontalAlignment(4);
               this.setIcon(var7.sP().getHomeClub().kU());
               this.setHorizontalTextPosition(2);
               this.setText(var7.sP().getHomeClub().getNome());
            } else if (j == 1) {
               this.setText("x");
            } else if (j == 2) {
               this.setHorizontalAlignment(2);
               this.setHorizontalTextPosition(4);
               this.setIcon(var7.sP().getAwayClub().kU());
               this.setText(var7.sP().getAwayClub().getNome());
            } else if (j == 4) {
               if (var7.sP().e()) {
                  this.setText(var7.sP().t(false));
               } else {
                  this.setText("-x-");
               }
            } else if (j == 5) {
               if (var7.sQ() != null) {
                  if (var7.sQ().e()) {
                     this.setText(var7.sQ().t(true));
                  } else {
                     this.setText("-x-");
                  }
               }
            } else if (j == 6 && var7.sQ() != null && var7.sQ().e()) {
               int[] var8 = var7.sP().hQ();
               if (var8[0] >= 0 && var8[1] >= 0) {
                  this.setForeground(Color.BLUE);
                  this.setText(var7.sP().u(false));
               } else {
                  var8 = var7.sQ().hQ();
                  if (var8[0] >= 0 && var8[1] >= 0) {
                     this.setForeground(Color.BLUE);
                     this.setText(var7.sQ().u(true));
                  }
               }
            }
         }
      }

      return this;
   }
}
