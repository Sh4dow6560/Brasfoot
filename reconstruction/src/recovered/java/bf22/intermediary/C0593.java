package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.model.Coach;

public class C0593 extends DefaultTableCellRenderer {
   private int w = 0;

   public C0593(int i) {
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
      Coach var7 = (Coach)object;
      if (var7 != null) {
         if (j == 0) {
            this.setText(Integer.toString(i + 1));
         } else if (j == 1) {
            this.setText(var7.getName());
         } else if (j == 2) {
            if (var7.getClub() != null) {
               this.setText(var7.getClub().getNome());
            }
         } else if (j == 3) {
            if (this.w == 0) {
               this.setText(Integer.toString(var7.getCareerScore()));
            } else if (var7.getReputacao() < GameConstants.pZ.length) {
               this.setText(GameConstants.pZ[var7.getReputacao()]);
            }
         } else if (j == 4 && this.w == 0) {
            this.setText(Integer.toString(var7.getTitleCount()));
         }
      }

      return this;
   }
}
