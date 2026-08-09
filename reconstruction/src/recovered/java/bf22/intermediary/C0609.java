package bf22.intermediary;

import mod.recovered.manager.CoachChangeRecord;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0609 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      CoachChangeRecord var7 = (CoachChangeRecord)object;
      if (var7 != null) {
         if (j == 0) {
            this.setText(var7.getDateText());
         } else if (j == 1) {
            if (var7.getClubId() >= 0) {
               this.setText(var7.getClubName());
            }
         } else if (j == 2) {
            if (var7.getIncomingCoach() != null) {
               this.setText(var7.getIncomingCoach().getName());
            }
         } else if (j == 3 && var7.getOutgoingCoach() != null) {
            this.setText(var7.getOutgoingCoach().getName());
         }
      }

      return this;
   }
}
