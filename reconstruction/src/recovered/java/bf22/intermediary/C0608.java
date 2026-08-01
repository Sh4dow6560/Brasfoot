package bf22.intermediary;

import mod.recovered.transfer.PlayerTransferRecord;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.finance.ClubFinances;

public class C0608 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      PlayerTransferRecord var7 = (PlayerTransferRecord)object;
      if (var7 != null && var7.x() != null) {
         if (j == 0) {
            this.setText(var7.f());
         } else if (j == 1) {
            this.setText(var7.x().getNome());
         } else if (j == 2) {
            if (var7.ma() >= 0) {
               this.setText(var7.mc());
            }
         } else if (j == 3) {
            if (var7.lZ() >= 0) {
               this.setText(var7.md());
            }
         } else if (j == 4) {
            this.setText(ClubFinances.a(var7.lY(), 0));
         }
      }

      return this;
   }
}
