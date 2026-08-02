package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import mod.recovered.model.Player;

public class C0630 extends DefaultTableCellRenderer {
   @Override
   public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int i, int j) {
      super.getTableCellRendererComponent(jTable, object, bl, bl2, i, j);
      this.setBorder(noFocusBorder);
      super.setForeground(Color.BLACK);
      this.setHorizontalAlignment(0);
      this.setIcon(null);
      this.setText("");
      Player var7 = (Player)object;
      if (!GamePersistence.careerState.isHabilidadeIndividual()) {
         if (j == 0) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rI[var7.getPosicao()]);
         } else if (j == 1) {
            this.setHorizontalAlignment(2);
            this.setText(var7.getNome());
            if (var7.isWorldClassPlayer()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrelared.png")));
            } else if (var7.isStarPlayer()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrela.png")));
            }
         } else if (j == 2) {
            this.setHorizontalAlignment(2);
            if (var7.getClub() != null) {
               this.setText(var7.getClub().getNome());
            }
         } else if (j == 3) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rK[var7.getLado()]);
         } else if (j == 4) {
            this.setText(Integer.toString(var7.getOverallStrength()));
         } else if (j == 5) {
            this.setText(GameConstants.qN[var7.getCr1()] + "/" + GameConstants.qN[var7.getCr2()]);
         } else if (j == 6) {
            this.setText(Integer.toString(var7.getIdade()));
         }
      } else {
         if (j == 0) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rI[var7.getPosicao()]);
         } else if (j == 1) {
            this.setHorizontalAlignment(2);
            this.setText(var7.getNome());
            if (var7.isWorldClassPlayer()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrelared.png")));
            } else if (var7.isStarPlayer()) {
               this.setIcon(new ImageIcon(this.getClass().getResource("/aicons/estrela.png")));
            }
         } else if (j == 2) {
            this.setHorizontalAlignment(2);
            if (var7.getClub() != null) {
               this.setText(var7.getClub().getNome());
            }
         } else if (j == 3) {
            this.setHorizontalAlignment(0);
            this.setText(GameConstants.rK[var7.getLado()]);
         }

         if (j == 4) {
            this.setText(Integer.toString(var7.getGoalkeeping()));
         } else if (j == 5) {
            this.setText(Integer.toString(var7.getTackling()));
         } else if (j == 6) {
            this.setText(Integer.toString(var7.getPlaymaking()));
         } else if (j == 7) {
            this.setText(Integer.toString(var7.getFinishing()));
         } else if (j == 8) {
            this.setText(Integer.toString(var7.getSpeed()));
         } else if (j == 9) {
            this.setText(Integer.toString(var7.getTechnique()));
         } else if (j == 10) {
            this.setText(Integer.toString(var7.getPassing()));
         } else if (j == 11) {
            this.setText(GameConstants.qN[var7.getCr1()] + "/" + GameConstants.qN[var7.getCr2()]);
         } else if (j == 12) {
            this.setText(Integer.toString(var7.getIdade()));
         }
      }

      return this;
   }
}
