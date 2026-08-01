package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0605 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0728 var7 = (C0728)object;
      if (var7 != null) {
         if (j == 0) {
            this.setText(Integer.toString(var7.H() + GamePersistence.SR.iU()));
         } else if (j == 1) {
            this.setText(var7.ck());
         } else if (j == 2) {
            this.setText(Integer.toString(var7.w()));
         } else if (j == 3) {
            this.setText(Integer.toString(var7.cm()));
         } else if (j == 4) {
            this.setText(Integer.toString(var7.co()));
         } else if (j == 5) {
            int var8 = (int)(var7.cm() * 100.0F / var7.w());
            this.setText(Integer.toString(var8) + "%");
         } else if (j == 6) {
            this.setText(Integer.toString(var7.cq()));
         } else if (j == 7) {
            this.setText(Integer.toString(var7.cr()));
         }
      }

      return this;
   }
}
