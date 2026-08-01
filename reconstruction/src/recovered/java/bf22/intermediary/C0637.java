package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0637 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0778 var7 = (C0778)object;
      if (var7 != null) {
         if (j == 0) {
            this.setIcon(var7.vC());
            this.setText(var7.vB());
         } else if (j == 1) {
            this.setIcon(var7.cu().kU());
            this.setText(var7.cu().getNome());
         } else if (j == 2) {
            this.setText(Integer.toString(var7.H() + GamePersistence.careerState.getSeasonYearOffset()));
         }
      }

      return this;
   }
}
