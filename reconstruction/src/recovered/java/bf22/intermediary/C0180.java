package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mod.recovered.config.StateLeagueConfig;

public class C0180 extends JPanel {
   private int CF = 0;
   private C0182 CG = null;
   private StateLeagueConfig CH = null;
   private JCheckBox CI;
   private JComboBox CJ;
   private JComboBox CK;
   private JComboBox CL;
   private JComboBox CM;
   private JLabel CN;

   public C0180(int i, C0182 c0182) {
      this.CF = i;
      this.CG = c0182;
      this.mJ();
      this.CM.setMaximumRowCount(12);

      for (int var3 = 0; var3 < GameConstants.sN.length; var3++) {
         this.CM.addItem(GameConstants.sN[var3]);
      }

      this.CM.addActionListener(new C0181(this));
   }

   public void nH() {
      this.CH.setFormula(this.CM.getSelectedIndex());
      if (this.CI.isSelected()) {
         this.CH.setDesempate(0);
      } else {
         this.CH.setDesempate(1);
      }

      if (this.CJ.isVisible()) {
         this.CH.setFinaisIdaVoltaComIndex(0, this.CJ.getSelectedIndex() + 1);
      }

      if (this.CK.isVisible()) {
         this.CH.setFinaisIdaVoltaComIndex(1, this.CK.getSelectedIndex() + 1);
      }

      if (this.CL.isVisible()) {
         this.CH.setFinaisIdaVoltaComIndex(2, this.CL.getSelectedIndex() + 1);
      }
   }

   public void a(StateLeagueConfig stateLeagueConfig) {
      this.CH = stateLeagueConfig;
      this.CM.setSelectedIndex(this.CH.getFormula());
      if (this.CH.getDesempate() == 0) {
         this.CI.setSelected(true);
      } else {
         this.CI.setSelected(false);
      }

      this.a(this.CH.getFormula(), GameConstants.sL[this.CH.getFormula()][2], this.CH);
   }

   private void da(int i) {
      this.a(i, GameConstants.sL[i][2], null);
   }

   private void a(int i, int j, StateLeagueConfig stateLeagueConfig) {
      if (7 == i || 10 == i) {
         j = 8;
      }

      if (j == 2) {
         this.a(this.CJ, "f");
         this.CK.setVisible(false);
         this.CL.setVisible(false);
      } else if (j == 4) {
         this.a(this.CJ, "s");
         this.a(this.CK, "f");
         this.CK.setVisible(true);
         this.CL.setVisible(false);
      } else if (j == 8) {
         this.a(this.CJ, "q");
         this.a(this.CK, "s");
         this.a(this.CL, "f");
         this.CK.setVisible(true);
         this.CL.setVisible(true);
      }

      if (stateLeagueConfig != null) {
         if (stateLeagueConfig.getFinaisIdaVoltaFormatado()[0]) {
            this.CJ.setSelectedIndex(1);
         }

         if (j >= 4 && stateLeagueConfig.getFinaisIdaVoltaFormatado()[1]) {
            this.CK.setSelectedIndex(1);
         }

         if (j == 8 && stateLeagueConfig.getFinaisIdaVoltaFormatado()[2]) {
            this.CL.setSelectedIndex(1);
         }
      } else {
         this.CJ.setSelectedIndex(1);
         if (j >= 4) {
            this.CK.setSelectedIndex(1);
         }

         if (j == 8) {
            this.CL.setSelectedIndex(1);
         }
      }
   }

   private void a(JComboBox jComboBox, String string) {
      jComboBox.removeAllItems();
      if (string.equals("q")) {
         jComboBox.addItem("Quartas: 1 jogo");
         jComboBox.addItem("Quartas: 2 jogos");
      } else if (string.equals("s")) {
         jComboBox.addItem("Semifinal: 1 jogo");
         jComboBox.addItem("Semifinal: 2 jogos");
      } else if (string.equals("f")) {
         jComboBox.addItem("Final: 1 jogo");
         jComboBox.addItem("Final: 2 jogos");
      }
   }

   public void db(int i) {
      if (i == 1) {
         this.setBackground(new Color(36, 104, 43));
      } else if (i == 2) {
         this.setBackground(new Color(116, 20, 19));
      } else if (i == 3) {
         this.setBackground(new Color(102, 102, 102));
      }
   }

   private void mJ() {
      this.CN = new JLabel();
      this.CL = new JComboBox();
      this.CI = new JCheckBox();
      this.CM = new JComboBox();
      this.CJ = new JComboBox();
      this.CK = new JComboBox();
      this.setBackground(new Color(36, 91, 45));
      this.setLayout(new C0807());
      this.CN.setForeground(new Color(255, 255, 255));
      this.CN.setHorizontalAlignment(4);
      this.CN.setText("Sistema:");
      this.add(this.CN, new C0775(10, 14, 81, -1));
      this.add(this.CL, new C0775(400, 50, 130, -1));
      this.CI.setForeground(new Color(255, 255, 255));
      this.CI.setText("Desempate por penalties");
      this.CI.setOpaque(false);
      this.add(this.CI, new C0775(355, 10, -1, -1));
      this.add(this.CM, new C0775(101, 11, 223, -1));
      this.add(this.CJ, new C0775(100, 50, 130, -1));
      this.add(this.CK, new C0775(250, 50, 130, -1));
   }
}
