package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0619 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0796 var7 = (C0796)object;
      if (var7 != null) {
         if (var7.tt()) {
            if (j == 0) {
               this.setHorizontalAlignment(4);
               ImageIcon var8 = new ImageIcon(this.getClass().getResource("/aflags/" + var7.vl().jc() + ".png"));
               this.setIcon(var8);
            } else if (j == 1) {
               this.setFont(new Font("Helvetica", 1, 12));
               if (var7.vl() != null) {
                  this.setText(var7.vl().jf());
               }
            }
         } else if (j == 0) {
            this.setHorizontalAlignment(0);
            this.setText(Integer.toString(var7.H() + GamePersistence.careerState.getSeasonYearOffset()));
         } else if (j == 1) {
            this.setIcon(var7.ce().kU());
            this.setText(var7.ce().getNome());
         } else if (j == 2) {
            this.setIcon(var7.cf().kU());
            this.setText(var7.cf().getNome());
         } else if (j == 3) {
            String var9 = "";
            if (var7.ch() != null) {
               this.setIcon(var7.ch().kU());
               var9 = "(" + var7.ch().getNome() + ")";
            }

            if (var7.cg() != null) {
               this.setText(var7.cg() + var9 + " - " + Integer.toString(var7.y()) + " g");
            }
         } else if (j == 4 && var7.ci() != null) {
            this.setText(var7.ci().dS());
         }
      }

      return this;
   }
}
