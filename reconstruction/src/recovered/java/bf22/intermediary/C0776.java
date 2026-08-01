package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0776 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0777 var7 = (C0777)object;
      if (var7 != null) {
         if (j == 0) {
            if (var7.getEstado() >= 100) {
               this.setText(var7.sT());
            } else if (var7.getEstado() >= 0) {
               ImageIcon var8 = new ImageIcon(this.getClass().getResource("/aesticons/" + Integer.toString(var7.getEstado()) + ".png"));
               this.setIcon(var8);
               this.setText(GameConstants.rX[var7.getEstado()]);
            } else if (!var7.method_kw_to()) {
               if (var7.et() == 1) {
                  ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aeicons/ic_champion.png"));
                  this.setIcon(var9);
               } else if (var7.et() == 2) {
                  ImageIcon var10 = new ImageIcon(this.getClass().getResource("/aeicons/ic_vice.png"));
                  this.setIcon(var10);
               } else if (var7.et() == 3) {
                  ImageIcon var11 = new ImageIcon(this.getClass().getResource("/aeicons/ic_art.png"));
                  this.setIcon(var11);
               } else {
                  this.setText(var7.sT());
               }
            }
         } else if (j == 1) {
            if (var7.getEstado() >= 100) {
               this.setText(var7.sT());
            } else if (var7.getEstado() >= 0) {
               this.setText(GameConstants.rY[var7.getEstado()]);
            } else if (var7.method_kw_to()) {
               this.setText(var7.sT());
               this.setFont(new Font("Tahoma", 1, 11));
            } else if (var7.cu() != null) {
               if (var7.vA() == null) {
                  this.setText(var7.cu().getNome());
               } else {
                  this.setText(var7.vA());
               }

               this.setIcon(var7.cu().kU());
            }
         } else if (j == 2) {
            if (var7.vA() != null) {
               this.setText(var7.vz() + " gols");
            } else {
               this.setText(var7.vz());
            }
         }
      }

      return this;
   }
}
