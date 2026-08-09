package bf22.intermediary;

import mod.recovered.manager.CoachSeasonRecord;
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
      CoachSeasonRecord var7 = (CoachSeasonRecord)object;
      if (var7 != null) {
         if (j == 0) {
            this.setText(Integer.toString(var7.getSeasonNumber() + GamePersistence.careerState.getSeasonYearOffset()));
         } else if (j == 1) {
            this.setText(var7.getClubName());
         } else if (j == 2) {
            this.setText(Integer.toString(var7.getMatchCount()));
         } else if (j == 3) {
            this.setText(Integer.toString(var7.getWinCount()));
         } else if (j == 4) {
            this.setText(Integer.toString(var7.getLossCount()));
         } else if (j == 5) {
            int var8 = (int)(var7.getWinCount() * 100.0F / var7.getMatchCount());
            this.setText(Integer.toString(var8) + "%");
         } else if (j == 6) {
            this.setText(Integer.toString(var7.getCareerScore()));
         } else if (j == 7) {
            this.setText(Integer.toString(var7.getTitleCount()));
         }
      }

      return this;
   }
}
