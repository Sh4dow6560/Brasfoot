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
      if (var7 != null && var7.getPlayer() != null) {
         if (j == 0) {
            this.setText(var7.getDateText());
         } else if (j == 1) {
            this.setText(var7.getPlayer().getNome());
         } else if (j == 2) {
            if (var7.getSourceClubId() >= 0) {
               this.setText(var7.getSourceClubName());
            }
         } else if (j == 3) {
            if (var7.getDestinationClubId() >= 0) {
               this.setText(var7.getDestinationClubName());
            }
         } else if (j == 4) {
            this.setText(ClubFinances.a(var7.getFee(), 0));
         }
      }

      return this;
   }
}
