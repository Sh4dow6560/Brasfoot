package bf22.intermediary;

import mod.recovered.match.MatchEvent;
import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class C0634 extends DefaultTableCellRenderer {
   private boolean SP;

   public C0634(boolean bl) {
      this.SP = bl;
   }

   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.WHITE);
      this.setFont(new Font("Arial", 0, 11));
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      MatchEvent var7 = (MatchEvent)object;
      if (this.SP) {
         this.setBackground(GameConstants.or);
      }

      if (var7 != null && var7.isDone()) {
         if (j == 1) {
            if (var7.getType() < 90) {
               this.setText(var7.getDisplayHtml());
            } else if (var7.getType() == 91) {
               this.setText("Gols");
            } else if (var7.getType() == 92) {
               this.setText("Cartões");
            } else if (var7.getType() == 95) {
               this.setText("Contusões");
            } else if (var7.getType() == 96) {
               this.setText("Substituições");
            }
         }

         if (var7.getType() > 90) {
            if (j == 1) {
               this.setFont(new Font("Arial", 1, 12));
               this.setHorizontalAlignment(0);
               this.setBackground(GameConstants.os);
            }
         } else if (var7.getTeamSide() == 0) {
            if (j == 0) {
               this.setIcon(var7.getIcon());
            } else if (j == 1) {
               this.setHorizontalAlignment(2);
            }
         } else if (var7.getTeamSide() == 1) {
            if (j == 2) {
               this.setIcon(var7.getIcon());
            } else if (j == 1) {
               this.setHorizontalAlignment(4);
            }
         }
      }

      return this;
   }
}
