package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Player;

public class C0607 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(2);
      this.setIcon(null);
      this.setText("");
      Player var7 = (Player)object;
      if (var7 != null) {
         if (j == 0) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rI[var7.getPosicao()]);
         }

         if (j == 1) {
            this.setHorizontalAlignment(2);
            this.setIcon(var7.fS());
         } else if (j == 2) {
            this.setHorizontalAlignment(2);
            String var8 = C0696.values()[var7.getPais()].jA();
            this.setText(var8);
            ImageIcon var9 = new ImageIcon(this.getClass().getResource("/aflags/" + var7.getPais() + ".png"));
            this.setIcon(var9);
         }

         if (j == 3) {
            this.setHorizontalAlignment(2);
            this.setText(var7.getNome());
            if (var7.isWorldClassPlayer()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrelared.png")));
            } else if (var7.isStarPlayer()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrela.png")));
            }
         }

         if (j == 4) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rK[var7.getLado()]);
         }

         if (!GamePersistence.careerState.isHabilidadeIndividual()) {
            if (j == 5) {
               this.setText(Integer.toString(var7.getOverallStrength()));
            } else if (j == 6) {
               this.setText(ClubFinances.a(var7.getSalary(), 0));
            } else if (j == 7) {
               this.setText(ClubFinances.a(var7.getMarketValue(), 0));
            } else if (j == 8) {
               this.setText(GameConstants.qN[var7.getCr1()] + "/" + GameConstants.qN[var7.getCr2()]);
            } else if (j == 9) {
               this.setText(Integer.toString(var7.gy()));
            } else if (j == 10) {
               this.setText(Integer.toString(var7.gs()));
            } else if (j == 11) {
               this.setText(Integer.toString(var7.getIdade()));
            } else if (j == 12) {
               if (var7.isTransferListed()) {
                  this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
               }
            } else if (j == 13 && var7.isAvailableForLoan()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
            }
         } else if (j == 5) {
            this.setText(Integer.toString(var7.getGoalkeeping()));
         } else if (j == 6) {
            this.setText(Integer.toString(var7.getTackling()));
         } else if (j == 7) {
            this.setText(Integer.toString(var7.getPlaymaking()));
         } else if (j == 8) {
            this.setText(Integer.toString(var7.getFinishing()));
         } else if (j == 9) {
            this.setText(Integer.toString(var7.getSpeed()));
         } else if (j == 10) {
            this.setText(Integer.toString(var7.getTechnique()));
         } else if (j == 11) {
            this.setText(Integer.toString(var7.getPassing()));
         } else if (j == 12) {
            this.setText(ClubFinances.a(var7.getSalary(), 0));
         } else if (j == 13) {
            this.setText(ClubFinances.a(var7.getMarketValue(), 0));
         } else if (j == 14) {
            this.setText(GameConstants.qN[var7.getCr1()] + "/" + GameConstants.qN[var7.getCr2()]);
         } else if (j == 15) {
            this.setText(Integer.toString(var7.gy()));
         } else if (j == 16) {
            this.setText(Integer.toString(var7.gs()));
         } else if (j == 17) {
            this.setText(Integer.toString(var7.getIdade()));
         } else if (j == 18) {
            if (var7.isTransferListed()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
            }
         } else if (j == 19 && var7.isAvailableForLoan()) {
            this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconchecked.png")));
         }
      }

      return this;
   }
}
