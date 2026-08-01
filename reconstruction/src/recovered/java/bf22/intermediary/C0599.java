package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0599 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      this.setForeground(Color.white);
      this.setBackground(C0710.ot);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      C0827 var7 = (C0827)object;
      if (var7.tR() != null) {
         if (j == 0) {
            this.setHorizontalAlignment(0);
            if (var7.tR().ev() != null) {
               this.setText(var7.tR().ev().dS() + " | " + Integer.toString(var7.hU()));
            } else if (var7.ik() != null) {
               this.setText(var7.ik());
            }
         } else if (j == 1) {
            this.setHorizontalAlignment(2);
            this.setBackground(var7.tR().hc().kB());
            this.setForeground(var7.tR().hc().kC());
            this.setText(var7.tR().hc().getNome());
            this.setIcon(var7.tR().hc().kU());
         } else if (j == 2) {
            this.setHorizontalAlignment(0);
            if (var7.ei() && C0745.SR.isUsaCorPlacar()) {
               int var8 = C0745.SR.getCorPlacar();
               int[] var9 = C0710.oY[var8];
               this.setBackground(new Color(var9[0], var9[1], var9[2]));
            } else {
               this.setBackground(new Color(84, 127, 59));
            }

            this.setForeground(Color.WHITE);
            this.setText(Integer.toString(var7.tT()));
         } else if (j == 3) {
            this.setHorizontalAlignment(0);
            if (var7.ei() && C0745.SR.isUsaCorPlacar()) {
               int var10 = C0745.SR.getCorPlacar();
               int[] var12 = C0710.oY[var10];
               this.setBackground(new Color(var12[0], var12[1], var12[2]));
            } else {
               this.setBackground(new Color(84, 127, 59));
            }

            this.setForeground(Color.WHITE);
            this.setText(Integer.toString(var7.tU()));
         } else if (j == 4) {
            this.setHorizontalAlignment(2);
            this.setBackground(var7.tR().hd().kB());
            this.setForeground(var7.tR().hd().kC());
            this.setText(var7.tR().hd().getNome());
            this.setIcon(var7.tR().hd().kU());
         } else if (j == 5) {
            this.setHorizontalAlignment(2);
            if (var7.tV() != null) {
               if (var7.tV().et() == 0 && C0745.SR.isNegritoCasa()) {
                  super.setFont(new Font("Tahoma", 1, 11));
               }

               boolean var11 = true;
               if (var7.tV().b() == 6 && !var7.tR().hc().jZ() && !var7.tR().hd().jZ()) {
                  var11 = false;
               }

               if (var7.tV().b() == 1 && var7.tV().el() == 3) {
                  var11 = var7.tV().eu();
               }

               if (var11) {
                  this.setText(var7.tV().er());
                  this.setIcon(var7.tV().es());
               }
            }
         }
      } else if (j == 0 && var7.tS() != "") {
         this.setBackground(C0710.ou);
         this.setHorizontalAlignment(2);
         this.setText(var7.tS());
      }

      return this;
   }
}
