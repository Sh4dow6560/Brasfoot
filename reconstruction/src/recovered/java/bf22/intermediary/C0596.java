package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0596 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.WHITE);
      super.setBackground(GameConstants.or);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      this.setFont(new Font("Arial", 0, 12));
      this.setHorizontalTextPosition(4);
      C0814 var7 = (C0814)object;
      String var8 = "";
      if (var7 != null && var7.fb() != null) {
         if (j == 0) {
            String var9 = "";
            if (var7.tq()) {
               var9 = " (" + var7.tp() + ")";
            }

            if (var7.fb().getTacticalPosition() >= 0) {
               var8 = GameConstants.rI[GameConstants.sE[var7.fb().getTacticalPosition()][0]];
            }

            this.setText(var8 + " - " + var7.fb().getNome() + var9);
            if (var7.tm() > 0) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/esubs.png")));
            }

            if (var7.tq()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/arrowright.png")));
               this.setBackground(GameConstants.os);
            } else if (var7.tr()) {
               this.setHorizontalAlignment(4);
               this.setHorizontalTextPosition(2);
               this.setIcon(new ImageIcon(this.getClass().getResource("/aeicons/arrowlfet.png")));
            }
         } else if (j == 1) {
            String var12 = "";
            if (var7.fb().gB() != null) {
               int var10 = var7.fb().gB().cD();
               if (var10 > 0) {
                  String var11 = Integer.toString(var10);
                  if (var10 < 8) {
                     this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_chuteira" + var11 + ".png")));
                  } else {
                     this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ic_chuteira1.png")));
                  }
               }
            }
         } else if (j == 2 && !var7.tr()) {
            if (var7.fb().gk() < 2.0) {
               this.setText("sn");
            } else if (var7.fb().gk() < 10.0) {
               this.setText(String.format("%.1f", var7.fb().gk()));
            } else if (var7.fb().gk() == 10.0) {
               this.setText("10");
            }
         }
      } else if (var7.method_kw_to() && j == 0) {
         this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.yellow));
         this.setText("Substituições");
      }

      return this;
   }
}
