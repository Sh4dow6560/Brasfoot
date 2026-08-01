package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class C0597 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      C0786 var7 = (C0786)object;
      if (var7 != null) {
         if (var7.tt()) {
            this.setFont(new Font("Helvetica", 1, 11));
            MatteBorder var8 = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204));
            super.setBorder(var8);
         }

         if (j == 0 && !var7.tt()) {
            this.setHorizontalAlignment(2);
            this.setText(Integer.toString(var7.H() + C0745.SR.iU()));
         } else if (j == 1 && !var7.tt()) {
            this.setHorizontalAlignment(2);
            this.setText(var7.tZ());
         } else if (j == 2 && !var7.tt()) {
            this.setHorizontalAlignment(2);
            this.setText(var7.uG());
         } else if (j == 2 && var7.tt()) {
            this.setHorizontalAlignment(4);
            this.setText("Total em " + Integer.toString(var7.H() + C0745.SR.iU()) + ":");
         } else if (j == 3) {
            this.setText(Integer.toString(var7.w()));
         } else if (j == 4) {
            this.setText(Integer.toString(var7.cm()));
         } else if (j == 5) {
            this.setText(Integer.toString(var7.co()));
         } else if (j == 6) {
            this.setText(Integer.toString(var7.uF()));
         } else if (j == 7) {
            this.setText(Integer.toString(var7.ls()));
         } else if (j == 8) {
            this.setText(Integer.toString(var7.lt()));
         } else if (j == 9) {
            this.setHorizontalAlignment(2);
            this.setText(var7.uE());
         }
      }

      return this;
   }
}
