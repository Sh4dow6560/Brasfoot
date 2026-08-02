package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Player;

public class C0601 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      Player var7 = (Player)object;
      if (var7 != null) {
         if (j == 0) {
            this.setIcon(var7.fS());
         } else if (j == 1) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rI[var7.getPosicao()]);
         } else if (j == 2) {
            this.setHorizontalAlignment(2);
            String var8 = C0696.values()[var7.getPais()].jA();
            this.setText(var8);
            ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aflags/" + var7.getPais() + ".png"));
            this.setIcon(var9);
         } else if (j == 3) {
            this.setHorizontalAlignment(2);
            this.setText(var7.getNome());
         } else if (j == 4) {
            this.setText(Integer.toString(var7.getIdade()));
         }

         if (j == 5) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rK[var7.getLado()]);
         } else if (j == 6) {
            return var7.go();
         }

         if (j == 7) {
            this.setHorizontalAlignment(0);
            if (var7.fD() <= 1) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e1.png")));
            } else if (var7.fD() == 2) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e1.png")));
            } else if (var7.fD() == 3) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e15.png")));
            } else if (var7.fD() == 4) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e2.png")));
            } else if (var7.fD() == 5) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e25.png")));
            } else if (var7.fD() == 6) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e3.png")));
            } else if (var7.fD() == 7) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e35.png")));
            } else if (var7.fD() == 8) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e4.png")));
            } else if (var7.fD() == 9) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e45.png")));
            } else if (var7.fD() == 10) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aiconsj/e5.png")));
            }
         } else if (j == 8) {
            this.setText(GameConstants.qN[var7.getCr1()] + "/" + GameConstants.qN[var7.getCr2()]);
         } else if (j == 9) {
            this.setText(ClubFinances.a(var7.fk(), 0));
         } else if (j == 10) {
            this.setText(ClubFinances.a(var7.fj(), 0));
         }
      }

      return this;
   }
}
