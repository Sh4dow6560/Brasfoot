package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0606 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0829 var7 = (C0829)object;
      if (var7 != null && var7.tR() != null && var7.tR().hc() != null && var7.tR().hd() != null) {
         if (j == 0) {
            if (var7.tR() != null) {
               this.setText(((C0693)GamePersistence.careerState.R().get(var7.tR().hM())).f());
            }
         } else if (j == 1) {
            super.setHorizontalTextPosition(4);
            this.setHorizontalAlignment(2);
            this.setText(var7.tR().hc().getNome());
            this.setIcon(var7.tR().hc().kU());
         } else if (j == 3) {
            super.setHorizontalTextPosition(2);
            this.setHorizontalAlignment(4);
            this.setText(var7.tR().hd().getNome());
            this.setIcon(var7.tR().hd().kU());
         } else if (j == 2) {
            String var8 = "";
            var8 = Integer.toString(var7.tR().hu());
            String var9 = "";
            var9 = Integer.toString(var7.tR().hw());
            this.setText(var8 + "x" + var9);
         } else if (j == 4) {
            this.setHorizontalAlignment(0);
            this.setFont(new Font("Helvetica", 1, 12));
            if (var7.C() < 5.0) {
               super.setForeground(new Color(120, 7, 31));
            } else if (var7.C() > 7.0) {
               super.setForeground(new Color(56, 121, 12));
            }

            if (var7.C() < 2.0) {
               this.setText("sn");
            } else if (var7.C() < 10.0) {
               this.setText(String.format("%.1f", var7.C()));
            } else if (var7.C() == 10.0) {
               this.setText("10");
            }
         }
      }

      return this;
   }
}
