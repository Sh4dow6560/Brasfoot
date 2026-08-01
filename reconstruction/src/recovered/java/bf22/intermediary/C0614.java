package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.model.Club;

public class C0614 extends DefaultTableCellRenderer {
   private int w = 0;

   public C0614(int i) {
      this.w = i;
   }

   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      Club var7 = (Club)object;
      if (var7 != null) {
         if (this.w < 2) {
            if (j == 0) {
               this.setText(Integer.toString(i + 1));
            } else if (j == 1) {
               this.setText(var7.getNome());
               this.setIcon(var7.kU());
            } else if (j == 2) {
               if (this.w == 0) {
                  this.setText(String.valueOf(var7.getDivisao()) + "ª div.");
                  super.setToolTipText(C0696.bl(var7.getPais()));
                  this.setIcon(new ImageIcon(this.getClass().getResource("/aflags/" + var7.getPais() + ".png")));
               } else {
                  this.setText(GameConstants.aeH[var7.gg()]);
               }
            }
         } else if (this.w == 2) {
            if (j == 0) {
               this.setText(Integer.toString(i + 1));
            } else if (j == 1) {
               this.setText(var7.getNome());
               this.setIcon(var7.kU());
            } else if (j == 2) {
               if (var7.Au() == 0) {
                  this.setText("Grupo A");
               } else if (var7.Au() == 1) {
                  this.setText("Grupo B");
               } else {
                  this.setText("");
               }
            }

            if (var7.Au() >= 0) {
               super.setForeground(Color.BLACK);
            } else {
               super.setForeground(new Color(165, 18, 36));
            }
         }
      }

      return this;
   }
}
