package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0610 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      super.setBackground(Color.white);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0791 var7 = (C0791)object;
      if (object != null) {
         if (j == 0) {
            if (var7.tt()) {
               super.setBackground(Color.BLACK);
               super.setForeground(Color.white);
            } else if (!var7.tt()) {
               this.setText(Integer.toString(var7.H() + GamePersistence.careerState.getSeasonYearOffset()));
            }
         }

         if (j == 1) {
            if (var7.tt()) {
               super.setBackground(Color.BLACK);
               super.setForeground(Color.white);
               this.setText(var7.sT());
            } else if (var7.getClub() != null) {
               this.setIcon(var7.getClub().kU());
               this.setText(var7.getClub().getNome());
            }
         }
      }

      return this;
   }
}
