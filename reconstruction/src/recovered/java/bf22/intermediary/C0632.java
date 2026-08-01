package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0632 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      C0772 var7 = (C0772)object;
      if (var7 != null) {
         if (var7.et() == 1) {
            if (var7.ut() >= 0 && j == 0) {
               if (var7.ut() == 0) {
                  ImageIcon var8 = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_vermelha.png"));
                  this.setIcon(var8);
               }

               if (var7.ut() == 1) {
                  ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_verde.png"));
                  this.setIcon(var9);
               }
            }

            if (j == 1) {
               this.setHorizontalAlignment(2);
               this.setText(var7.x().getNome());
            }
         } else if (var7.et() == 2) {
            if (var7.ut() >= 0 && j == 3) {
               if (var7.ut() == 0) {
                  ImageIcon var10 = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_vermelha.png"));
                  this.setIcon(var10);
               }

               if (var7.ut() == 1) {
                  ImageIcon var11 = new ImageIcon(this.getClass().getResource("/aicons/ic_bola_verde.png"));
                  this.setIcon(var11);
               }
            }

            if (j == 2) {
               this.setHorizontalAlignment(4);
               this.setText(var7.x().getNome());
            }
         }
      }

      return this;
   }
}
