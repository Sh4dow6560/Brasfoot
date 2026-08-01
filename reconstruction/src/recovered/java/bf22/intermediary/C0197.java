package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mod.recovered.config.NationalLeagueConfig;

public class C0197 extends JPanel {
   private static final long serialVersionUID = 1L;
   private static String[] Gv = new String[]{"Sem mata-mata", "Oit./Quar./semi/final", "Quartas/semi/final", "Semi/Final", "Final", "2 grupos de 4 e Final"};
   private static String[] Gw = new String[]{"sem grupos", "2 grupos de 10", "2 grupos de 12", "8 grupos de 5", "2 grupos de 20"};
   private int divisao = 0;
   private C0193 Gx = null;
   private NationalLeagueConfig aeQ = null;
   private NationalLeagueConfig aeR = null;
   private int[] aeS = new int[]{1, 2, 3, 4};
   private int[] aeT = new int[]{1, 2, 3, 4};
   private int aeU = 0;
   private JCheckBox Gz;
   private JCheckBox CI;
   private JCheckBox aeV;
   private JCheckBox aeW;
   private JCheckBox aeX;
   private JComboBox GA;
   private JComboBox GB;
   private JComboBox aeY;
   private JComboBox aeZ;
   private JComboBox afa;
   private JComboBox GD;
   private JTextField GE;
   private JTextField GF;
   private JLabel afb;
   private JLabel GG;
   private JLabel GH;
   private JLabel uF;
   private JLabel afc;
   private JLabel Mp;
   private JLabel afd;
   private JLabel afe;
   private JLabel aff;
   private JLabel afg;
   private JLabel afh;
   private JLabel GJ;

   public C0197(int i, C0193 c0193) {
      this.divisao = i;
      this.Gx = c0193;
      this.mJ();
      int[] var3 = new int[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 26, 28, 30, 36, 40, 48, 64};
      int[] var4 = new int[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 26, 28, 30, 36, 40, 48, 64, 68};
      if (this.divisao == 4) {
         var3 = var4;
      }

      this.GD.setMaximumRowCount(var3.length);

      for (int var5 = 0; var5 < var3.length; var5++) {
         this.GD.addItem(var3[var5]);
      }

      for (int var6 = 0; var6 < this.aeS.length; var6++) {
         this.aeY.addItem(this.aeS[var6]);
      }

      this.GD.addActionListener(new C0198(this));
      this.GA.addActionListener(new C0199(this));
      this.aeY.addActionListener(new C0359(this));
      this.aeZ.addActionListener(new C0367(this));
      this.afa.addActionListener(new C0368(this));
      if (this.divisao == 1) {
         this.afh.setText("Times que sobem: 0");
         this.aeU = 0;
         this.afa.setEnabled(false);
         this.fw(0);
         this.c(false, false);
         this.aff.setVisible(false);
         this.afa.setVisible(false);
      }
   }

   private void AE() {
      this.AH();
   }

   private void AF() {
      this.Gx.af(this.divisao, this.aeS[this.aeY.getSelectedIndex()]);
      this.aeZ.removeAllItems();

      for (int var1 = 0; var1 < this.aeS[this.aeY.getSelectedIndex()]; var1++) {
         this.aeZ.addItem(this.aeT[var1]);
      }

      this.aeZ.setSelectedIndex(this.aeZ.getItemCount() - 1);
   }

   public void fv(int i) {
      this.afh.setText("Times que sobem: " + i);
      this.aeU = i;
   }

   public void aP(boolean bl) {
      this.afa.removeAllItems();
      if (this.aeU == 1) {
         this.afa.addItem(0);
         this.AG();
      } else if (this.aeU == 2) {
         this.afa.addItem(0);
         this.afa.addItem(1);
         this.AG();
      } else if (this.aeU == 3 || this.aeU == 4) {
         this.afa.addItem(0);
         this.afa.addItem(1);
         this.afa.addItem(2);
         this.AG();
      }

      if (bl) {
         this.afa.setSelectedItem(this.aeQ.getVagasSobemPeloMataMata());
      } else {
         this.afa.setSelectedItem(0);
         this.AG();
      }
   }

   public void AG() {
      if (this.afa.getSelectedItem() != null) {
         if ((Integer)this.afa.getSelectedItem() == 0) {
            this.c(false, false);
         } else if ((Integer)this.afa.getSelectedItem() == 1) {
            this.c(true, true);
         } else if ((Integer)this.afa.getSelectedItem() == 2) {
            this.c(false, true);
         }
      }
   }

   public void fw(int i) {
   }

   public void AH() {
      int var1 = 0;
      if (this.aeY.getSelectedIndex() >= 0 && this.aeZ.getSelectedIndex() >= 0) {
         var1 = this.aeS[this.aeY.getSelectedIndex()] - this.aeT[this.aeZ.getSelectedIndex()];
      }

      this.afd.setText("Disputam playoff com liga abaixo: " + var1);
   }

   public void c(boolean bl, boolean bl2) {
      this.afg.setVisible(bl2);
      this.aeW.setVisible(bl2);
      this.afb.setVisible(bl);
      this.aeX.setVisible(bl);
      if (bl) {
         this.afg.setText("Semifinal");
      } else {
         this.afg.setText("Final");
      }
   }

   public void a(NationalLeagueConfig nationalLeagueConfig, NationalLeagueConfig nationalLeagueConfig2) {
      this.b(nationalLeagueConfig);
      this.GE.setText(nationalLeagueConfig.getNome2());
      if (this.GE.getText().isEmpty()) {
         nationalLeagueConfig.setNome2("Campeonato");
      }

      this.GF.setText(nationalLeagueConfig.getNomeDivisao());
      if (this.GF.getText().isEmpty() || this.GF.getText() == "") {
         nationalLeagueConfig.setNomeDivisao(nationalLeagueConfig.getDivisao() + "ª divisão");
      }

      this.dh(nationalLeagueConfig.getnTimes());
      this.di(nationalLeagueConfig.getnTimes());
      if (nationalLeagueConfig.getnTimes() != 8
         && nationalLeagueConfig.getnTimes() != 10
         && nationalLeagueConfig.getnTimes() != 12
         && nationalLeagueConfig.getnTimes() != 14) {
         this.O(nationalLeagueConfig.getnGrupos(), nationalLeagueConfig.getNumeroTimesMataMata());
      } else {
         if (nationalLeagueConfig.getFormula() == 0) {
            if (nationalLeagueConfig.getnTimes() == 8) {
               this.GA.setSelectedItem("4");
            } else if (nationalLeagueConfig.getnTimes() == 10) {
               this.GA.setSelectedItem("4");
            } else if (nationalLeagueConfig.getnTimes() == 12) {
               this.GA.setSelectedItem("3");
            } else if (nationalLeagueConfig.getnTimes() == 14) {
               this.GA.setSelectedItem("3");
            }
         } else {
            this.GA.setSelectedItem(Integer.toString(nationalLeagueConfig.getFormula()));
         }

         int var3 = nationalLeagueConfig.getNumeroTimesMataMata();
         if (var3 == 8) {
            this.GB.setSelectedItem(Gv[2]);
         } else if (var3 == 4) {
            this.GB.setSelectedItem(Gv[3]);
         } else if (var3 == 2) {
            this.GB.setSelectedItem(Gv[4]);
         } else {
            this.GB.setSelectedIndex(0);
         }
      }

      if (nationalLeagueConfig.getnRebaixados() < 1 && nationalLeagueConfig.getnRebaixados() > 4) {
         nationalLeagueConfig.setnRebaixados(2);
      }

      this.aeY.setSelectedItem(nationalLeagueConfig.getnRebaixados());
      this.aeZ.removeAllItems();

      for (int var4 = 0; var4 < nationalLeagueConfig.getnRebaixados(); var4++) {
         this.aeZ.addItem(this.aeT[var4]);
      }

      if (nationalLeagueConfig.getRebaixadosDireto() == 0) {
         this.aeZ.setSelectedItem(nationalLeagueConfig.getnRebaixados());
      } else {
         this.aeZ.setSelectedItem(nationalLeagueConfig.getRebaixadosDireto());
      }

      this.aP(true);
      if (nationalLeagueConfig.getDuasVoltasMataMataSobe() != null) {
         boolean[] var5 = nationalLeagueConfig.getDuasVoltasMataMataSobe();
         this.aeW.setSelected(var5[0]);
         this.aeX.setSelected(var5[1]);
      }

      if (nationalLeagueConfig.getDuasVoltasplayoffReb() != null) {
         this.aeV.setSelected(nationalLeagueConfig.getDuasVoltasplayoffReb()[0]);
      }

      boolean[] var6 = nationalLeagueConfig.getDuasVoltasMataMata();
      this.Gz.setSelected(var6[0]);
      if (nationalLeagueConfig.getDesempate() == 0) {
         this.CI.setSelected(true);
      } else {
         this.CI.setSelected(false);
      }

      this.AH();
   }

   public void db(int i) {
      if (i == 1) {
         this.setBackground(new Color(0, 75, 106));
      } else if (i == 2) {
         this.setBackground(new Color(116, 20, 19));
      } else if (i == 3) {
         this.setBackground(new Color(102, 102, 102));
      }
   }

   public void O(int i, int j) {
      if (i == 0) {
         this.GA.setSelectedIndex(0);
      } else if (i == 2) {
         this.GA.setSelectedIndex(1);
      } else if (i == 8) {
         this.GA.setSelectedIndex(0);
      } else if (i == 12) {
         this.GA.setSelectedIndex(0);
      }

      if (i == 8) {
         this.GB.setSelectedIndex(0);
      } else if (i == 12) {
         this.GB.setSelectedIndex(0);
      } else if (i > 0) {
         if (j == 4) {
            this.GB.setSelectedItem(Gv[2]);
         } else if (j == 2) {
            this.GB.setSelectedItem(Gv[3]);
         } else if (j == 1) {
            this.GB.setSelectedItem(Gv[4]);
         } else if (j == 1020) {
            this.GB.setSelectedItem(Gv[5]);
         } else {
            this.GB.setSelectedIndex(0);
         }
      } else if (j == 8) {
         this.GB.setSelectedItem(Gv[2]);
      } else if (j == 4) {
         this.GB.setSelectedItem(Gv[3]);
      } else if (j == 2) {
         this.GB.setSelectedItem(Gv[4]);
      } else if (j == 1020) {
         this.GB.setSelectedItem(Gv[5]);
      } else {
         this.GB.setSelectedIndex(0);
      }
   }

   public void dh(int i) {
      this.GD.setSelectedItem(i);
   }

   public void b(NationalLeagueConfig nationalLeagueConfig) {
      this.aeQ = nationalLeagueConfig;
   }

   public void nH() {
      int var1 = 0;
      int[] var2 = new int[]{8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 26, 28, 30, 36, 40, 48, 64, 68};
      var1 = var2[this.GD.getSelectedIndex()];
      this.aeQ.setVersaoArquivo(22);
      this.aeQ.setnTimes(var1);
      this.aeQ.setnRebaixados(this.aeS[this.aeY.getSelectedIndex()]);
      this.aeQ.setRebaixadosDireto(this.aeT[this.aeZ.getSelectedIndex()]);
      this.aeQ.setMelhoresTerceiros(false);
      boolean[] var3 = new boolean[2];
      if (this.aeW.isVisible()) {
         var3[0] = this.aeW.isSelected();
      }

      if (this.aeX.isVisible()) {
         var3[1] = this.aeX.isSelected();
      }

      this.aeQ.setIdaVoltaMMSobe(var3[0], var3[1]);
      if (this.aeV.isVisible()) {
         this.aeQ.setDuasVoltasplayoffReb(this.aeV.isSelected());
      }

      if (this.divisao > 1) {
         this.aeQ.setVagasSobemPeloMataMata((Integer)this.afa.getSelectedItem());
      }

      this.aeQ.setnGrupos(0);
      if (this.aeQ.getnTimes() != 20 && this.aeQ.getnTimes() != 24) {
         if (this.aeQ.getnTimes() == 40) {
            this.aeQ.setnGrupos(8);
            if (this.GA.getSelectedIndex() == 1) {
               this.aeQ.setnGrupos(2);
            }
         } else if (this.aeQ.getnTimes() == 48) {
            this.aeQ.setnGrupos(12);
         } else if (this.aeQ.getnTimes() == 64) {
            this.aeQ.setnGrupos(8);
         } else if (this.aeQ.getnTimes() == 68) {
            this.aeQ.setnGrupos(8);
         }
      } else if (this.GA.getSelectedIndex() == 1) {
         this.aeQ.setnGrupos(2);
      }

      this.aeQ.setFormula(0);
      if (this.aeQ.getnTimes() == 8 || this.aeQ.getnTimes() == 10 || this.aeQ.getnTimes() == 12 || this.aeQ.getnTimes() == 14) {
         if (this.GA.getSelectedItem().equals("4")) {
            this.aeQ.setFormula(4);
         } else if (this.GA.getSelectedItem().equals("3")) {
            this.aeQ.setFormula(3);
         } else if (this.GA.getSelectedItem().equals("2")) {
            this.aeQ.setFormula(2);
         }
      }

      if (this.aeQ.getnTimes() == 30) {
         this.aeQ.setDoisTurnos(false);
      }

      this.aeQ.setNumeroTimesMataMata(0);
      int[] var4 = new int[]{0, 16, 8, 4, 2, 1020};

      for (int var5 = 0; var5 < Gv.length; var5++) {
         if (this.GB.getSelectedItem().equals(Gv[var5])) {
            this.aeQ.setNumeroTimesMataMata(var4[var5]);
         }
      }

      if (this.aeQ.getnGrupos() > 0) {
         if (this.aeQ.getNumeroTimesMataMata() == 0) {
            this.aeQ.setNumeroTimesMataMata(2);
         }

         if (this.aeQ.getNumeroTimesMataMata() < 1000) {
            this.aeQ.setNumeroTimesMataMata(this.aeQ.getNumeroTimesMataMata() / this.aeQ.getnGrupos());
         }

         if (this.aeQ.getnTimes() == 20 && this.aeQ.getnGrupos() == 2) {
            this.aeQ.setRebaixadoPeloGrupo(true);
            if (this.aeQ.getnRebaixados() == 1 || this.aeQ.getnRebaixados() == 3) {
               this.aeQ.setnRebaixados(4);
            }
         }

         if (this.aeQ.getnTimes() == 40 && this.aeQ.getnGrupos() == 8) {
            this.aeQ.setRebaixadoPeloGrupo(false);
         }

         if (this.aeQ.getnTimes() == 48 && this.aeQ.getnGrupos() == 12) {
            this.aeQ.setRebaixadoPeloGrupo(false);
            this.aeQ.setNumeroTimesMataMata(2);
            this.aeQ.setMelhoresTerceiros(true);
         } else if (this.aeQ.getnTimes() == 64 && this.aeQ.getnGrupos() == 8) {
            this.aeQ.setRebaixadoPeloGrupo(false);
            this.aeQ.setNumeroTimesMataMata(4);
            this.aeQ.setDoisTurnos(true);
         } else if (this.aeQ.getnTimes() == 68 && this.aeQ.getnGrupos() == 8) {
            this.aeQ.setRebaixadoPeloGrupo(false);
            this.aeQ.setNumeroTimesMataMata(4);
            this.aeQ.setMelhoresTerceiros(false);
         }
      }

      boolean[] var8 = new boolean[]{true, true, true, true, true, true, true};
      boolean[] var6 = new boolean[7];
      if (this.Gz.isSelected()) {
         this.aeQ.setDuasVoltasMataMata(var8);
      } else {
         this.aeQ.setDuasVoltasMataMata(var6);
      }

      if (this.aeQ.getnTimes() > 22 && this.aeQ.getnTimes() < 25) {
         this.aeQ.setDuasVoltasMataMata(var6);
      }

      if (this.aeQ.getnTimes() == 24 && this.GA.getSelectedIndex() == 1 && this.Gz.isSelected()) {
         this.aeQ.setDuasVoltasMataMata(var8);
      }

      if (this.aeQ.getnTimes() == 40 || this.aeQ.getnTimes() == 48 || this.aeQ.getnTimes() == 68) {
         this.aeQ.setDuasVoltasMataMata(var8);
      }

      if (!this.Gz.isSelected()) {
         this.aeQ.setDuasVoltasMataMata(var6);
      }

      if (!this.CI.isSelected()) {
         this.aeQ.setDesempate(1);
      } else if (this.CI.isSelected()) {
         this.aeQ.setDesempate(0);
      }

      if (!this.GE.getText().toString().equals("")) {
         this.aeQ.setNome2(this.GE.getText().toString());
      }

      this.aeQ.setNomeDivisao(this.GF.getText().toString());
   }

   public void di(int i) {
      this.GA.setVisible(true);
      this.GG.setVisible(true);
      this.GG.setText("Grupos");
      this.GA.removeAllItems();
      if (i == 20) {
         this.GA.addItem(Gw[0]);
         this.GA.addItem(Gw[1]);
      } else if (i == 24) {
         this.GA.addItem(Gw[0]);
         this.GA.addItem(Gw[2]);
      } else if (i == 40) {
         this.GA.addItem(Gw[3]);
         this.GA.addItem(Gw[4]);
      } else if (i == 48) {
         this.GA.addItem("12 grupos de 4");
      } else if (i == 64) {
         this.GA.addItem("8 grupos de 8");
      } else if (i == 68) {
         this.GA.addItem("Seletiva/8 grupos de 8");
      } else {
         this.GA.addItem(Gw[0]);
         this.GA.setVisible(false);
         this.GG.setVisible(false);
      }

      if (i != 8 && i != 10 && i != 12 && i != 14) {
         this.d(i, false);
      } else {
         this.d(i, true);
      }

      if (i < 20) {
         this.aeY.setSelectedIndex(0);
      } else {
         this.aeY.setSelectedIndex(1);
      }

      if (i == 8 || i == 10 || i == 12 || i == 14) {
         this.GA.setVisible(true);
         this.GG.setVisible(true);
         this.GA.removeAllItems();
         this.GG.setText("Turnos");
         if (i == 10) {
            this.GA.addItem("2");
            this.GA.addItem("3");
            this.GA.addItem("4");
            this.GA.setSelectedItem("4");
         } else if (i == 12 || i == 14) {
            this.GA.addItem("2");
            this.GA.addItem("3");
            this.GA.setSelectedItem("3");
         } else if (i == 8) {
            this.GA.addItem("4");
         }

         this.d(i, true);
      }
   }

   private void d(int i, boolean bl) {
      this.GB.removeAllItems();
      if (i <= 10 || i == 12 || i == 14) {
         this.GB.addItem(Gv[0]);
         this.GB.addItem(Gv[2]);
         this.GB.addItem(Gv[3]);
         this.GB.addItem(Gv[4]);
      } else if (i <= 20 || i == 30 || i == 25 || i == 26 || i == 28 || i == 36) {
         boolean var3 = false;
         if (this.GA.getSelectedItem() != null && this.GA.getSelectedItem().equals(Gw[0])) {
            this.GB.addItem(Gv[0]);
            var3 = true;
         }

         if (bl) {
            this.GB.addItem(Gv[0]);
         }

         this.GB.addItem(Gv[2]);
         this.GB.addItem(Gv[3]);
         this.GB.addItem(Gv[4]);
         if (i == 20) {
            this.GB.addItem(Gv[5]);
         }
      } else if (i == 22) {
         this.GB.addItem(Gv[0]);
         this.GB.addItem(Gv[2]);
         this.GB.addItem(Gv[3]);
         this.GB.addItem(Gv[4]);
      } else if (i == 24) {
         if (this.GA.getSelectedItem() != null && this.GA.getSelectedItem().equals(Gw[0])) {
            this.GB.addItem(Gv[0]);
         } else {
            this.GB.addItem(Gv[2]);
            this.GB.addItem(Gv[3]);
            this.GB.addItem(Gv[4]);
         }
      } else if (i == 40) {
         if (this.GA.getSelectedItem() != null && this.GA.getSelectedItem().equals(Gw[4])) {
            this.GB.addItem(Gv[3]);
            this.GB.addItem(Gv[4]);
         } else {
            this.GB.addItem(Gv[1]);
         }
      } else if (i != 48 && i != 64 && i != 68) {
         this.GB.addItem(Gv[0]);
      } else {
         this.GB.addItem("32 classificados");
      }
   }

   private void mJ() {
      this.GE = new JTextField();
      this.aeY = new JComboBox();
      this.uF = new JLabel();
      this.GF = new JTextField();
      this.GJ = new JLabel();
      this.GD = new JComboBox();
      this.GG = new JLabel();
      this.GA = new JComboBox();
      this.GH = new JLabel();
      this.aeX = new JCheckBox();
      this.CI = new JCheckBox();
      this.afc = new JLabel();
      this.Mp = new JLabel();
      this.afd = new JLabel();
      this.afb = new JLabel();
      this.afa = new JComboBox();
      this.afe = new JLabel();
      this.aeZ = new JComboBox();
      this.afh = new JLabel();
      this.GB = new JComboBox();
      this.Gz = new JCheckBox();
      this.aeW = new JCheckBox();
      this.aff = new JLabel();
      this.aeV = new JCheckBox();
      this.afg = new JLabel();
      this.setBackground(new Color(0, 75, 106));
      this.setMinimumSize(new Dimension(720, 160));
      this.setPreferredSize(new Dimension(720, 160));
      this.setRequestFocusEnabled(false);
      this.setVerifyInputWhenFocusTarget(false);
      this.setLayout(new C0807());
      this.add(this.GE, new C0775(100, 10, 220, -1));
      this.add(this.aeY, new C0775(450, 90, 48, -1));
      this.uF.setFont(new Font("Tahoma", 0, 12));
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setHorizontalAlignment(4);
      this.uF.setText("Nome divisão:");
      this.add(this.uF, new C0775(11, 40, 80, -1));
      this.add(this.GF, new C0775(100, 40, 220, -1));
      this.GJ.setFont(new Font("Tahoma", 0, 12));
      this.GJ.setForeground(new Color(255, 255, 255));
      this.GJ.setHorizontalAlignment(4);
      this.GJ.setText("Total times:");
      this.add(this.GJ, new C0775(20, 70, 70, -1));
      this.add(this.GD, new C0775(100, 70, 49, -1));
      this.GG.setFont(new Font("Tahoma", 0, 12));
      this.GG.setForeground(new Color(255, 255, 255));
      this.GG.setHorizontalAlignment(4);
      this.GG.setText("Grupos:");
      this.GG.setToolTipText("");
      this.add(this.GG, new C0775(158, 70, 50, -1));
      this.GA.setModel(new DefaultComboBoxModel<>(new String[]{"Sem Grupos", "4 grupos"}));
      this.add(this.GA, new C0775(210, 70, 110, -1));
      this.GH.setFont(new Font("Tahoma", 0, 12));
      this.GH.setForeground(new Color(255, 255, 255));
      this.GH.setHorizontalAlignment(4);
      this.GH.setText("Mata-mata:");
      this.add(this.GH, new C0775(20, 100, 70, -1));
      this.aeX.setFont(new Font("Tahoma", 0, 12));
      this.aeX.setForeground(new Color(255, 255, 255));
      this.aeX.setText("Ida e volta");
      this.aeX.setOpaque(false);
      this.add(this.aeX, new C0775(630, 50, 90, -1));
      this.CI.setFont(new Font("Tahoma", 0, 12));
      this.CI.setForeground(new Color(255, 255, 255));
      this.CI.setText("Desempate por penalties");
      this.CI.setOpaque(false);
      this.add(this.CI, new C0775(180, 122, -1, -1));
      this.afc.setFont(new Font("Tahoma", 0, 12));
      this.afc.setForeground(new Color(255, 255, 255));
      this.afc.setHorizontalAlignment(4);
      this.afc.setText("Nome:");
      this.add(this.afc, new C0775(40, 15, 51, -1));
      this.add(this.aeZ, new C0775(660, 90, 48, -1));
      this.afe.setBackground(new Color(7, 28, 39));
      this.afe.setFont(new Font("Tahoma", 0, 12));
      this.afe.setForeground(new Color(255, 255, 255));
      this.afe.setHorizontalAlignment(2);
      this.afe.setText("Rebaixados direto:");
      this.afe.setOpaque(true);
      this.add(this.afe, new C0775(550, 90, 170, 20));
      this.Mp.setBackground(new Color(7, 28, 39));
      this.Mp.setFont(new Font("Tahoma", 0, 12));
      this.Mp.setForeground(new Color(255, 255, 255));
      this.Mp.setText("Total Rebaixados:");
      this.Mp.setOpaque(true);
      this.add(this.Mp, new C0775(340, 90, 210, 20));
      this.afd.setFont(new Font("Tahoma", 0, 12));
      this.afd.setForeground(new Color(255, 255, 255));
      this.afd.setHorizontalAlignment(4);
      this.afd.setText("Disputam playoff com liga abaixo: 5");
      this.add(this.afd, new C0775(360, 120, 200, -1));
      this.afd.getAccessibleContext().setAccessibleName("Disputam playoff com liga abaixo: 0");
      this.afb.setFont(new Font("Tahoma", 0, 12));
      this.afb.setForeground(new Color(255, 255, 255));
      this.afb.setHorizontalAlignment(4);
      this.afb.setText("Final:");
      this.add(this.afb, new C0775(620, 38, 40, 10));
      this.add(this.afa, new C0775(480, 40, 48, -1));
      this.afh.setBackground(new Color(7, 28, 39));
      this.afh.setFont(new Font("Tahoma", 0, 12));
      this.afh.setForeground(new Color(255, 255, 255));
      this.afh.setText("Times que sobem:");
      this.afh.setOpaque(true);
      this.add(this.afh, new C0775(340, 10, 380, 20));
      this.GB.setModel(new DefaultComboBoxModel<>(new String[]{"Quartas/Semi/Final", "Sem Mata-Mata", " "}));
      this.add(this.GB, new C0775(100, 100, 220, -1));
      this.Gz.setFont(new Font("Tahoma", 0, 12));
      this.Gz.setForeground(new Color(255, 255, 255));
      this.Gz.setText("Mata-mata em dois jogos");
      this.Gz.setOpaque(false);
      this.add(this.Gz, new C0775(10, 122, 170, -1));
      this.aeW.setFont(new Font("Tahoma", 0, 12));
      this.aeW.setForeground(new Color(255, 255, 255));
      this.aeW.setText("Ida e volta");
      this.aeW.setOpaque(false);
      this.add(this.aeW, new C0775(535, 50, 90, -1));
      this.aff.setFont(new Font("Tahoma", 0, 12));
      this.aff.setForeground(new Color(255, 255, 255));
      this.aff.setHorizontalAlignment(4);
      this.aff.setText("Vagas pelo mata-mata:");
      this.add(this.aff, new C0775(340, 40, 130, -1));
      this.aeV.setFont(new Font("Tahoma", 0, 12));
      this.aeV.setForeground(new Color(255, 255, 255));
      this.aeV.setText("Ida e volta");
      this.aeV.setOpaque(false);
      this.add(this.aeV, new C0775(580, 115, 100, -1));
      this.afg.setFont(new Font("Tahoma", 0, 12));
      this.afg.setForeground(new Color(255, 255, 255));
      this.afg.setText("Final");
      this.add(this.afg, new C0775(540, 36, 70, -1));
   }
}
