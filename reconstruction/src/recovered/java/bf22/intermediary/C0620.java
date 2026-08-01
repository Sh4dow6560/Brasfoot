package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.model.Club;

public class C0620 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      C0729 var7 = (C0729)object;
      if (var7 != null) {
         if (var7.cC() > 0) {
            if (j == 0) {
               this.setText(Integer.toString(var7.cC() + GamePersistence.careerState.iU()));
            }

            if (j == 1) {
               this.setText("promovido");
            }
         } else {
            if (var7.H() == -1) {
               this.setFont(new Font("Helvetica", 1, 12));
            }

            if (var7.H() == -1) {
               if (j == 1) {
                  this.setText("Total carreira:");
               }
            } else if (j == 0) {
               this.setText(Integer.toString(var7.H() + GamePersistence.careerState.iU()));
            } else if (j == 1) {
               this.setText(var7.ck());
               Club var8 = var7.cu();
               if (var8 != null) {
                  this.setIcon(var8.kU());
               }
            }

            if (j == 2) {
               this.setText(Integer.toString(var7.w()));
            } else if (j == 3) {
               this.setText(Integer.toString(var7.y()));
            } else if (j == 4) {
               this.setText(Integer.toString(var7.cv()));
            } else if (j == 5) {
               this.setText(Integer.toString(var7.cw()));
            } else if (j == 6) {
               this.setText(Integer.toString(var7.cx()));
            } else if (j == 7) {
               this.setText(Integer.toString(var7.cD()));
            } else if (j == 8) {
               if (var7.H() == -1) {
                  this.setText(var7.cG());
               } else {
                  this.setText(var7.cE());
               }
            }
         }
      }

      return this;
   }
}
