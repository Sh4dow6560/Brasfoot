package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0603 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0915 var7 = (C0915)object;
      if (var7 != null) {
         if (j == 0) {
            if (var7.isMark()) {
               super.setForeground(Color.RED);
            }

            this.setText(var7.getNome());
         } else if (j == 1) {
            String var8 = C0696.valueOf("P" + var7.getPais()).getNome();
            this.setText(var8);
            ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aflags/" + var7.getPais() + ".png"));
            this.setIcon(var9);
         } else if (j == 2) {
            this.setText(Integer.toString(var7.getNivel()));
         }
      }

      return this;
   }
}
