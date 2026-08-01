package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.model.Player;

public class C0616 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      Player var7 = (Player)object;
      if (j == 0) {
         this.setHorizontalAlignment(0);
         this.setText(GameConstants.rI[var7.getPosicao()]);
      } else if (j == 1) {
         this.setHorizontalAlignment(2);
         this.setText(var7.getNome());
      } else if (j == 2) {
         if (!GamePersistence.SR.isHabilidadeIndividual()) {
            this.setText(Integer.toString(var7.fi()));
         } else {
            this.setText(Integer.toString(var7.gP()));
         }
      } else {
         if (j == 3) {
            return var7.a(Color.black);
         }

         if (j == 4) {
            this.setText(GameConstants.qN[var7.getCr1()] + "/" + GameConstants.qN[var7.getCr2()]);
         }
      }

      return this;
   }
}
