package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class C0762 extends JPanel {
   public JDialog ub;
   private int w;
   private String pU = "Qualquer";
   public JButton vm;
   public JCheckBox Qq;
   public JCheckBox Qr;
   public JCheckBox Qs;
   public JCheckBox Qt;
   public JComboBox Qu;
   public JComboBox Qv;
   public JComboBox Qw;
   public JComboBox Qx;
   public JComboBox BD;
   public JComboBox Nq;
   public JComboBox Qy;
   public JTextField uf;
   public JLabel Bj;
   public JLabel vw;
   public JLabel zb;
   public JLabel zc;
   public JLabel uh;
   public JLabel a_;
   public JLabel ur;
   public JLabel vx;
   public JLabel vy;
   public JLabel vz;
   public JLabel Qz;
   public JLabel QA;
   public C0781 QB;
   public C0781 QC;
   public JLabel Ei;
   public JLabel Jw;
   public JLabel Jx;
   public JLabel Jy;
   public JLabel Jz;
   public JLabel JA;
   public JLabel JB;
   public JLabel JC;
   public JLabel QD;
   public JLabel QE;
   public JLabel QF;
   public JLabel QG;
   public JLabel QH;
   public JLabel QI;
   public JLabel QJ;
   public C0781 QK;
   public C0781 QL;
   public C0781 QM;
   public C0781 QN;
   public C0781 QO;
   public C0781 QP;
   public C0781 QQ;

   public C0762(JDialog jDialog, int i) {
      this.ub = jDialog;
      this.w = i;
      if (i == 1) {
         this.mJ();
      } else if (i == 2) {
         this.rS();
      } else if (i == 3) {
         this.uq();
      } else if (i == 4) {
         this.ur();
      }
   }

   public void rR() {
      this.uf.setText("");
      this.Nq.setSelectedIndex(0);
      this.Qx.setSelectedIndex(0);
      this.uk();
      this.Qy.setSelectedIndex(0);
      this.Qv.setSelectedIndex(0);
      this.Qw.setSelectedIndex(0);
      this.BD.setSelectedIndex(0);
      this.Qu.setSelectedIndex(0);
      this.Qs.setSelected(false);
      this.Qt.setSelected(false);
      if (this.Qq != null) {
         this.Qq.setSelected(false);
      }

      if (this.Qr != null) {
         this.Qr.setSelected(false);
      }
   }

   public void mG() {
      if (this.w != 1 && this.w != 4) {
         this.uj();
      } else {
         this.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
         this.QC.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
         this.QB.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
      }
   }

   private void uj() {
      this.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
      this.QC.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
      C0781[] var1 = new C0781[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2].setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
      }
   }

   public void uk() {
      if (this.w != 1 && this.w != 4) {
         this.up();
      } else {
         this.QC.setMinimum(16);
         this.QC.setMaximum(45);
         this.QC.setValue(16);
         this.QC.dP(45);
         this.QB.setMinimum(1);
         this.QB.setMaximum(100);
         this.QB.setValue(1);
         this.QB.dP(100);
      }
   }

   public void mK() {
      this.uk();
      this.um();
      this.mH();
      String[] var1 = new String[]{
         "1 mil => 100 mil",
         "101 mil => 500 mil",
         "501 mil => 1 milhão",
         "1 milhão => 3 milhões",
         "3 milhões => 5 milhões",
         "5 milhões => 10 milhões",
         "mais 10 milhões"
      };
      this.Nq.addItem(this.pU);

      for (int var2 = 0; var2 < GameConstants.rH.length; var2++) {
         this.Nq.addItem(GameConstants.rH[var2]);
      }

      this.Nq.setSelectedIndex(0);
      this.Qx.addItem(this.pU);

      for (int var4 = 0; var4 < GameConstants.rK.length; var4++) {
         this.Qx.addItem(GameConstants.rK[var4]);
      }

      this.Qx.setSelectedIndex(0);
      this.Qy.addItem(this.pU);

      for (int var5 = 0; var5 < var1.length; var5++) {
         this.Qy.addItem(var1[var5]);
      }

      this.Qy.setSelectedIndex(0);
      this.Qv.addItem(this.pU);

      for (int var6 = 0; var6 < GameConstants.qM.length; var6++) {
         this.Qv.addItem(GameConstants.qM[var6]);
      }

      this.Qv.setSelectedIndex(0);
      this.Qw.addItem(this.pU);

      for (int var7 = 0; var7 < GameConstants.qM.length; var7++) {
         this.Qw.addItem(GameConstants.qM[var7]);
      }

      this.Qw.setSelectedIndex(0);
      if (this.w == 1 || this.w == 2) {
         this.BD.addItem(this.pU);

         for (int var8 = 0; var8 < C0696.jz(); var8++) {
            this.BD.addItem(((CountryInfo)C0732.cY().get(var8)).getNome());
         }
      }

      C0037 var9 = new C0037();
      var9.setPreferredSize(new Dimension(10, 25));
      this.BD.setRenderer(var9);
      this.BD.setMaximumRowCount(12);
      if (this.BD.getItemCount() > 0) {
         this.BD.setSelectedIndex(0);
      }

      this.Qu.addItem(this.pU);

      for (int var3 = 0; var3 < GamePersistence.SR.N().size(); var3++) {
         this.Qu.addItem(((CountryCompetitions)GamePersistence.SR.N().get(var3)).jp());
      }

      C0037 var10 = new C0037();
      var10.setPreferredSize(new Dimension(10, 25));
      this.Qu.setRenderer(var10);
      this.Qu.setMaximumRowCount(12);
      this.Qu.setSelectedIndex(0);
      this.mG();
   }

   private void ul() {
      if (this.ub != null) {
         this.ub.dispose();
      }
   }

   public void mH() {
      if (this.w != 1 && this.w != 4) {
         this.uo();
      } else {
         if (this.vm != null) {
            this.vm.addActionListener(new C0763(this));
         }

         this.QC.addChangeListener(new C0764(this));
         this.QB.addChangeListener(new C0765(this));
      }
   }

   public void um() {
      if (this.w != 1 && this.w != 4) {
         this.un();
      } else {
         this.Qz.setText(String.valueOf(this.QB.getValue()) + " - " + this.QB.uv());
         String var1 = String.valueOf(this.QC.uv());
         if (this.QC.uv() == this.QC.getMaximum()) {
            var1 = var1 + "+";
         }

         this.QA.setText(String.valueOf(this.QC.getValue()) + " - " + var1);
      }
   }

   private void un() {
      String var1 = String.valueOf(this.QC.uv());
      if (this.QC.uv() == this.QC.getMaximum()) {
         var1 = var1 + "+";
      }

      this.QA.setText(String.valueOf(this.QC.getValue()) + " - " + var1);
      C0781[] var2 = new C0781[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};
      JLabel[] var3 = new JLabel[]{this.QG, this.QE, this.QJ, this.QF, this.QD, this.QI, this.QH};

      for (int var4 = 0; var4 < var3.length; var4++) {
         var3[var4].setText(String.valueOf(var2[var4].getValue()) + " - " + var2[var4].uv());
      }
   }

   public void uo() {
      this.QC.addChangeListener(new C0767(this));
      C0781[] var1 = new C0781[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2].addChangeListener(new C0768(this));
      }

      if (this.vm != null) {
         this.vm.addActionListener(new C0769(this));
      }
   }

   private void up() {
      C0781[] var1 = new C0781[]{this.QN, this.QL, this.QQ, this.QM, this.QK, this.QP, this.QO};
      this.QC.setMinimum(16);
      this.QC.setMaximum(45);
      this.QC.setValue(16);
      this.QC.dP(45);

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2].setMinimum(1);
         var1[var2].setMaximum(100);
         var1[var2].setValue(1);
         var1[var2].dP(100);
      }
   }

   public void mJ() {
      this.uf = new JTextField();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.Nq = new JComboBox();
      this.ur = new JLabel();
      this.Qx = new JComboBox();
      this.vx = new JLabel();
      this.QC = new C0781();
      this.vw = new JLabel();
      this.Qu = new JComboBox();
      this.BD = new JComboBox();
      this.Bj = new JLabel();
      this.vz = new JLabel();
      this.Qv = new JComboBox();
      this.Qw = new JComboBox();
      this.Qy = new JComboBox();
      this.vy = new JLabel();
      this.Qs = new JCheckBox();
      this.Qt = new JCheckBox();
      this.Qq = new JCheckBox();
      this.Qr = new JCheckBox();
      this.zb = new JLabel();
      this.QA = new JLabel();
      this.QB = new C0781();
      this.vm = new JButton();
      this.zc = new JLabel();
      this.Qz = new JLabel();
      this.setBackground(new Color(0, 102, 51));
      this.setLayout(new C0807());
      this.add(this.uf, new C0775(40, 30, 310, -1));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(2);
      this.uh.setText("Nome:");
      this.add(this.uh, new C0775(40, 10, 80, -1));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Posição:");
      this.add(this.a_, new C0775(40, 65, 80, -1));
      this.add(this.Nq, new C0775(40, 85, 130, -1));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("Lado:");
      this.add(this.ur, new C0775(200, 65, 90, -1));
      this.add(this.Qx, new C0775(200, 85, 150, -1));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setHorizontalAlignment(2);
      this.vx.setText("Idade:");
      this.add(this.vx, new C0775(200, 130, 40, 17));
      this.add(this.QC, new C0775(200, 150, 150, -1));
      this.vw.setForeground(new Color(255, 255, 255));
      this.vw.setHorizontalAlignment(2);
      this.vw.setText("Atuando no:");
      this.add(this.vw, new C0775(570, 65, 91, -1));
      this.add(this.Qu, new C0775(570, 85, 150, -1));
      this.add(this.BD, new C0775(400, 85, 150, -1));
      this.Bj.setForeground(new Color(255, 255, 255));
      this.Bj.setHorizontalAlignment(2);
      this.Bj.setText("Nacionalidade:");
      this.add(this.Bj, new C0775(400, 65, 110, -1));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(2);
      this.vz.setText("Característica 2");
      this.add(this.vz, new C0775(570, 10, 110, -1));
      this.add(this.Qv, new C0775(400, 30, 150, -1));
      this.add(this.Qw, new C0775(570, 30, 150, -1));
      this.add(this.Qy, new C0775(400, 150, 150, -1));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setHorizontalAlignment(2);
      this.vy.setText("Valor:");
      this.add(this.vy, new C0775(400, 130, 91, -1));
      this.Qs.setForeground(new Color(255, 255, 255));
      this.Qs.setText("estrela");
      this.Qs.setOpaque(false);
      this.add(this.Qs, new C0775(580, 130, 80, -1));
      this.Qt.setForeground(new Color(255, 255, 255));
      this.Qt.setText("Top Mundial");
      this.Qt.setOpaque(false);
      this.add(this.Qt, new C0775(670, 130, 100, -1));
      this.Qq.setForeground(new Color(255, 255, 255));
      this.Qq.setText("À venda");
      this.Qq.setOpaque(false);
      this.add(this.Qq, new C0775(580, 160, 80, -1));
      this.Qr.setForeground(new Color(255, 255, 255));
      this.Qr.setText("Empréstimo");
      this.Qr.setOpaque(false);
      this.add(this.Qr, new C0775(670, 160, 100, -1));
      this.zb.setForeground(new Color(255, 255, 255));
      this.zb.setHorizontalAlignment(2);
      this.zb.setText("Força:");
      this.add(this.zb, new C0775(40, 130, 60, -1));
      this.QA.setForeground(new Color(255, 255, 255));
      this.QA.setHorizontalAlignment(4);
      this.QA.setText("10");
      this.add(this.QA, new C0775(290, 130, 60, -1));
      this.add(this.QB, new C0775(40, 150, 140, -1));
      this.vm.setText("X");
      this.add(this.vm, new C0775(737, 10, 50, -1));
      this.zc.setForeground(new Color(255, 255, 255));
      this.zc.setHorizontalAlignment(2);
      this.zc.setText("Característica 1");
      this.add(this.zc, new C0775(400, 10, 110, -1));
      this.Qz.setForeground(new Color(255, 255, 255));
      this.Qz.setHorizontalAlignment(4);
      this.Qz.setText("10");
      this.add(this.Qz, new C0775(120, 130, 60, -1));
   }

   public void rS() {
      this.uf = new JTextField();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.Nq = new JComboBox();
      this.ur = new JLabel();
      this.Qx = new JComboBox();
      this.vx = new JLabel();
      this.QC = new C0781();
      this.vw = new JLabel();
      this.Qu = new JComboBox();
      this.BD = new JComboBox();
      this.Bj = new JLabel();
      this.vz = new JLabel();
      this.Qv = new JComboBox();
      this.Qw = new JComboBox();
      this.Qy = new JComboBox();
      this.vy = new JLabel();
      this.Qs = new JCheckBox();
      this.Qt = new JCheckBox();
      this.Qq = new JCheckBox();
      this.Qr = new JCheckBox();
      this.QA = new JLabel();
      this.Jw = new JLabel();
      this.QN = new C0781();
      this.Ei = new JLabel();
      this.QG = new JLabel();
      this.vm = new JButton();
      this.QL = new C0781();
      this.Jx = new JLabel();
      this.QE = new JLabel();
      this.QQ = new C0781();
      this.Jy = new JLabel();
      this.QJ = new JLabel();
      this.QM = new C0781();
      this.Jz = new JLabel();
      this.QF = new JLabel();
      this.QK = new C0781();
      this.JA = new JLabel();
      this.QD = new JLabel();
      this.QP = new C0781();
      this.JB = new JLabel();
      this.QI = new JLabel();
      this.QO = new C0781();
      this.QH = new JLabel();
      this.JC = new JLabel();
      this.setBackground(new Color(0, 102, 51));
      this.setLayout(new C0807());
      this.add(this.uf, new C0775(30, 40, 310, -1));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(2);
      this.uh.setText("Nome:");
      this.add(this.uh, new C0775(30, 20, 80, -1));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Posição:");
      this.add(this.a_, new C0775(30, 80, 80, -1));
      this.add(this.Nq, new C0775(30, 100, 150, -1));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("Lado:");
      this.add(this.ur, new C0775(200, 80, 90, -1));
      this.add(this.Qx, new C0775(200, 100, 150, -1));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setHorizontalAlignment(2);
      this.vx.setText("Idade:");
      this.add(this.vx, new C0775(30, 130, 40, 17));
      this.add(this.QC, new C0775(30, 150, 150, -1));
      this.vw.setForeground(new Color(255, 255, 255));
      this.vw.setHorizontalAlignment(2);
      this.vw.setText("Atuando no:");
      this.add(this.vw, new C0775(200, 230, 91, -1));
      this.add(this.Qu, new C0775(200, 250, 150, -1));
      this.add(this.BD, new C0775(30, 250, 150, -1));
      this.Bj.setForeground(new Color(255, 255, 255));
      this.Bj.setHorizontalAlignment(2);
      this.Bj.setText("Nacionalidade:");
      this.add(this.Bj, new C0775(30, 230, 110, -1));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(2);
      this.vz.setText("Característica 2");
      this.add(this.vz, new C0775(200, 180, 110, -1));
      this.add(this.Qv, new C0775(30, 200, 150, -1));
      this.add(this.Qw, new C0775(200, 200, 150, -1));
      this.add(this.Qy, new C0775(200, 150, 150, -1));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setHorizontalAlignment(2);
      this.vy.setText("Valor:");
      this.add(this.vy, new C0775(200, 130, 91, -1));
      this.Qs.setForeground(new Color(255, 255, 255));
      this.Qs.setText("estrela");
      this.Qs.setOpaque(false);
      this.add(this.Qs, new C0775(400, 250, 70, -1));
      this.Qt.setForeground(new Color(255, 255, 255));
      this.Qt.setText("Top Mundial");
      this.Qt.setOpaque(false);
      this.add(this.Qt, new C0775(480, 250, 100, -1));
      this.Qq.setForeground(new Color(255, 255, 255));
      this.Qq.setText("À venda");
      this.Qq.setOpaque(false);
      this.add(this.Qq, new C0775(580, 250, 80, -1));
      this.Qr.setForeground(new Color(255, 255, 255));
      this.Qr.setText("Empréstimo");
      this.Qr.setOpaque(false);
      this.add(this.Qr, new C0775(670, 250, 110, -1));
      this.QA.setForeground(new Color(255, 255, 255));
      this.QA.setHorizontalAlignment(4);
      this.QA.setText("10");
      this.add(this.QA, new C0775(120, 130, 60, -1));
      this.Jw.setForeground(new Color(255, 255, 255));
      this.Jw.setHorizontalAlignment(2);
      this.Jw.setText("Característica 1");
      this.add(this.Jw, new C0775(30, 180, 110, -1));
      this.add(this.QN, new C0775(400, 40, 150, -1));
      this.Ei.setForeground(new Color(255, 255, 255));
      this.Ei.setHorizontalAlignment(2);
      this.Ei.setText("Goleiro");
      this.add(this.Ei, new C0775(400, 20, 40, 17));
      this.QG.setForeground(new Color(255, 255, 255));
      this.QG.setHorizontalAlignment(4);
      this.QG.setText("10");
      this.add(this.QG, new C0775(490, 20, 60, -1));
      this.vm.setText("X");
      this.add(this.vm, new C0775(740, 20, 50, -1));
      this.add(this.QL, new C0775(570, 40, 150, -1));
      this.Jx.setForeground(new Color(255, 255, 255));
      this.Jx.setHorizontalAlignment(2);
      this.Jx.setText("Desarme");
      this.add(this.Jx, new C0775(570, 20, 80, 20));
      this.QE.setForeground(new Color(255, 255, 255));
      this.QE.setHorizontalAlignment(4);
      this.QE.setText("10");
      this.add(this.QE, new C0775(660, 20, 60, 10));
      this.add(this.QQ, new C0775(400, 100, 150, -1));
      this.Jy.setForeground(new Color(255, 255, 255));
      this.Jy.setHorizontalAlignment(2);
      this.Jy.setText("Velocidade");
      this.add(this.Jy, new C0775(400, 80, 70, 17));
      this.QJ.setForeground(new Color(255, 255, 255));
      this.QJ.setHorizontalAlignment(4);
      this.QJ.setText("10");
      this.add(this.QJ, new C0775(490, 80, 60, -1));
      this.add(this.QM, new C0775(570, 100, 150, -1));
      this.Jz.setForeground(new Color(255, 255, 255));
      this.Jz.setHorizontalAlignment(2);
      this.Jz.setText("Finalização");
      this.add(this.Jz, new C0775(570, 80, 80, 20));
      this.QF.setForeground(new Color(255, 255, 255));
      this.QF.setHorizontalAlignment(4);
      this.QF.setText("10");
      this.add(this.QF, new C0775(660, 80, 60, 10));
      this.add(this.QK, new C0775(400, 160, 150, -1));
      this.JA.setForeground(new Color(255, 255, 255));
      this.JA.setHorizontalAlignment(2);
      this.JA.setText("Armação");
      this.add(this.JA, new C0775(400, 130, 70, 17));
      this.QD.setForeground(new Color(255, 255, 255));
      this.QD.setHorizontalAlignment(4);
      this.QD.setText("10");
      this.add(this.QD, new C0775(490, 130, 60, -1));
      this.add(this.QP, new C0775(570, 160, 150, -1));
      this.JB.setForeground(new Color(255, 255, 255));
      this.JB.setHorizontalAlignment(2);
      this.JB.setText("Técnica");
      this.add(this.JB, new C0775(570, 130, 60, 20));
      this.QI.setForeground(new Color(255, 255, 255));
      this.QI.setHorizontalAlignment(4);
      this.QI.setText("10");
      this.add(this.QI, new C0775(660, 130, 60, 10));
      this.add(this.QO, new C0775(400, 220, 150, -1));
      this.QH.setForeground(new Color(255, 255, 255));
      this.QH.setHorizontalAlignment(4);
      this.QH.setText("10");
      this.add(this.QH, new C0775(490, 200, 60, -1));
      this.JC.setForeground(new Color(255, 255, 255));
      this.JC.setHorizontalAlignment(2);
      this.JC.setText("Passe");
      this.add(this.JC, new C0775(400, 200, 50, 17));
   }

   private void uq() {
      this.uf = new JTextField();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.Nq = new JComboBox();
      this.ur = new JLabel();
      this.Qx = new JComboBox();
      this.vx = new JLabel();
      this.QC = new C0781();
      this.vw = new JLabel();
      this.Qu = new JComboBox();
      this.BD = new JComboBox();
      this.Bj = new JLabel();
      this.vz = new JLabel();
      this.Qv = new JComboBox();
      this.Qw = new JComboBox();
      this.Qy = new JComboBox();
      this.vy = new JLabel();
      this.Qs = new JCheckBox();
      this.Qt = new JCheckBox();
      this.QA = new JLabel();
      this.Jw = new JLabel();
      this.QN = new C0781();
      this.Ei = new JLabel();
      this.QG = new JLabel();
      this.QL = new C0781();
      this.Jx = new JLabel();
      this.QE = new JLabel();
      this.QQ = new C0781();
      this.Jy = new JLabel();
      this.QJ = new JLabel();
      this.QM = new C0781();
      this.Jz = new JLabel();
      this.QF = new JLabel();
      this.QK = new C0781();
      this.JA = new JLabel();
      this.QD = new JLabel();
      this.QP = new C0781();
      this.JB = new JLabel();
      this.QI = new JLabel();
      this.QO = new C0781();
      this.QH = new JLabel();
      this.JC = new JLabel();
      this.setBackground(new Color(0, 102, 51));
      this.setLayout(new C0807());
      this.add(this.uf, new C0775(30, 30, 320, -1));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(2);
      this.uh.setText("Nome:");
      this.add(this.uh, new C0775(30, 10, 80, -1));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Posição:");
      this.add(this.a_, new C0775(30, 60, 80, -1));
      this.add(this.Nq, new C0775(30, 80, 150, -1));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("Lado:");
      this.add(this.ur, new C0775(200, 60, 90, -1));
      this.add(this.Qx, new C0775(200, 80, 150, -1));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setHorizontalAlignment(2);
      this.vx.setText("Idade:");
      this.add(this.vx, new C0775(30, 115, 40, 17));
      this.add(this.QC, new C0775(30, 135, 150, -1));
      this.vw.setForeground(new Color(255, 255, 255));
      this.vw.setHorizontalAlignment(2);
      this.vw.setText("Atuando no:");
      this.add(this.vw, new C0775(200, 215, 91, -1));
      this.add(this.Qu, new C0775(200, 235, 150, -1));
      this.add(this.BD, new C0775(30, 235, 150, -1));
      this.Bj.setForeground(new Color(255, 255, 255));
      this.Bj.setHorizontalAlignment(2);
      this.Bj.setText("Nacionalidade:");
      this.add(this.Bj, new C0775(30, 215, 110, -1));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(2);
      this.vz.setText("Característica 2");
      this.add(this.vz, new C0775(200, 165, 110, -1));
      this.add(this.Qv, new C0775(30, 185, 150, -1));
      this.add(this.Qw, new C0775(200, 185, 150, -1));
      this.add(this.Qy, new C0775(200, 130, 150, -1));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setHorizontalAlignment(2);
      this.vy.setText("Valor:");
      this.add(this.vy, new C0775(200, 110, 91, -1));
      this.Qs.setForeground(new Color(255, 255, 255));
      this.Qs.setText("estrela");
      this.Qs.setOpaque(false);
      this.add(this.Qs, new C0775(620, 200, 80, -1));
      this.Qt.setForeground(new Color(255, 255, 255));
      this.Qt.setText("Top Mundial");
      this.Qt.setOpaque(false);
      this.add(this.Qt, new C0775(620, 230, 100, -1));
      this.QA.setForeground(new Color(255, 255, 255));
      this.QA.setHorizontalAlignment(4);
      this.QA.setText("10");
      this.add(this.QA, new C0775(120, 115, 60, -1));
      this.Jw.setForeground(new Color(255, 255, 255));
      this.Jw.setHorizontalAlignment(2);
      this.Jw.setText("Característica 1");
      this.add(this.Jw, new C0775(30, 165, 110, -1));
      this.add(this.QN, new C0775(430, 40, 150, -1));
      this.Ei.setForeground(new Color(255, 255, 255));
      this.Ei.setHorizontalAlignment(2);
      this.Ei.setText("Goleiro");
      this.add(this.Ei, new C0775(430, 20, -1, -1));
      this.QG.setForeground(new Color(255, 255, 255));
      this.QG.setHorizontalAlignment(4);
      this.QG.setText("10");
      this.add(this.QG, new C0775(530, 20, 50, -1));
      this.add(this.QL, new C0775(620, 40, 150, -1));
      this.Jx.setForeground(new Color(255, 255, 255));
      this.Jx.setHorizontalAlignment(2);
      this.Jx.setText("Desarme");
      this.add(this.Jx, new C0775(620, 20, -1, -1));
      this.QE.setForeground(new Color(255, 255, 255));
      this.QE.setHorizontalAlignment(4);
      this.QE.setText("10");
      this.add(this.QE, new C0775(720, 20, 50, -1));
      this.add(this.QQ, new C0775(430, 100, 150, -1));
      this.Jy.setForeground(new Color(255, 255, 255));
      this.Jy.setHorizontalAlignment(2);
      this.Jy.setText("Velocidade");
      this.add(this.Jy, new C0775(430, 80, -1, -1));
      this.QJ.setForeground(new Color(255, 255, 255));
      this.QJ.setHorizontalAlignment(4);
      this.QJ.setText("10");
      this.add(this.QJ, new C0775(530, 80, 50, -1));
      this.add(this.QM, new C0775(620, 100, 150, -1));
      this.Jz.setForeground(new Color(255, 255, 255));
      this.Jz.setHorizontalAlignment(2);
      this.Jz.setText("Finalização");
      this.add(this.Jz, new C0775(620, 80, -1, -1));
      this.QF.setForeground(new Color(255, 255, 255));
      this.QF.setHorizontalAlignment(4);
      this.QF.setText("10");
      this.add(this.QF, new C0775(720, 80, 50, -1));
      this.add(this.QK, new C0775(430, 160, 150, -1));
      this.JA.setForeground(new Color(255, 255, 255));
      this.JA.setHorizontalAlignment(2);
      this.JA.setText("Armação");
      this.add(this.JA, new C0775(430, 140, -1, -1));
      this.QD.setForeground(new Color(255, 255, 255));
      this.QD.setHorizontalAlignment(4);
      this.QD.setText("10");
      this.add(this.QD, new C0775(530, 140, 50, -1));
      this.add(this.QP, new C0775(620, 160, 150, -1));
      this.JB.setForeground(new Color(255, 255, 255));
      this.JB.setHorizontalAlignment(2);
      this.JB.setText("Técnica");
      this.add(this.JB, new C0775(620, 140, -1, -1));
      this.QI.setForeground(new Color(255, 255, 255));
      this.QI.setHorizontalAlignment(4);
      this.QI.setText("10");
      this.add(this.QI, new C0775(720, 140, 50, -1));
      this.add(this.QO, new C0775(430, 230, 150, -1));
      this.QH.setForeground(new Color(255, 255, 255));
      this.QH.setHorizontalAlignment(4);
      this.QH.setText("10");
      this.add(this.QH, new C0775(530, 210, 50, -1));
      this.JC.setForeground(new Color(255, 255, 255));
      this.JC.setHorizontalAlignment(2);
      this.JC.setText("Passe");
      this.add(this.JC, new C0775(430, 210, -1, -1));
   }

   private void ur() {
      this.uf = new JTextField();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.Nq = new JComboBox();
      this.ur = new JLabel();
      this.Qx = new JComboBox();
      this.vx = new JLabel();
      this.QC = new C0781();
      this.vw = new JLabel();
      this.Qu = new JComboBox();
      this.BD = new JComboBox();
      this.Bj = new JLabel();
      this.vz = new JLabel();
      this.Qv = new JComboBox();
      this.Qw = new JComboBox();
      this.Qy = new JComboBox();
      this.vy = new JLabel();
      this.Qs = new JCheckBox();
      this.Qt = new JCheckBox();
      this.zb = new JLabel();
      this.QA = new JLabel();
      this.QB = new C0781();
      this.zc = new JLabel();
      this.Qz = new JLabel();
      this.setBackground(new Color(0, 102, 51));
      this.setLayout(new C0807());
      this.add(this.uf, new C0775(40, 50, 310, -1));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(2);
      this.uh.setText("Nome:");
      this.add(this.uh, new C0775(40, 30, 80, -1));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Posição:");
      this.add(this.a_, new C0775(40, 85, 80, -1));
      this.add(this.Nq, new C0775(40, 105, 130, -1));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("Lado:");
      this.add(this.ur, new C0775(200, 85, 90, -1));
      this.add(this.Qx, new C0775(200, 105, 150, -1));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setHorizontalAlignment(2);
      this.vx.setText("Idade:");
      this.add(this.vx, new C0775(200, 145, 40, 17));
      this.add(this.QC, new C0775(200, 170, 150, -1));
      this.vw.setForeground(new Color(255, 255, 255));
      this.vw.setHorizontalAlignment(2);
      this.vw.setText("Atuando no:");
      this.add(this.vw, new C0775(610, 85, 91, -1));
      this.add(this.Qu, new C0775(610, 105, 150, -1));
      this.add(this.BD, new C0775(420, 105, 150, -1));
      this.Bj.setForeground(new Color(255, 255, 255));
      this.Bj.setHorizontalAlignment(2);
      this.Bj.setText("Nacionalidade:");
      this.add(this.Bj, new C0775(420, 85, 110, -1));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(2);
      this.vz.setText("Característica 2");
      this.add(this.vz, new C0775(610, 30, 110, -1));
      this.add(this.Qv, new C0775(420, 50, 150, -1));
      this.add(this.Qw, new C0775(610, 50, 150, -1));
      this.add(this.Qy, new C0775(420, 165, 150, -1));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setHorizontalAlignment(2);
      this.vy.setText("Valor:");
      this.add(this.vy, new C0775(420, 145, 91, -1));
      this.Qs.setForeground(new Color(255, 255, 255));
      this.Qs.setText("estrela");
      this.Qs.setOpaque(false);
      this.add(this.Qs, new C0775(610, 165, 80, -1));
      this.Qt.setForeground(new Color(255, 255, 255));
      this.Qt.setText("Top Mundial");
      this.Qt.setOpaque(false);
      this.add(this.Qt, new C0775(700, 165, 100, -1));
      this.zb.setForeground(new Color(255, 255, 255));
      this.zb.setHorizontalAlignment(2);
      this.zb.setText("Força:");
      this.add(this.zb, new C0775(40, 145, 60, -1));
      this.QA.setForeground(new Color(255, 255, 255));
      this.QA.setHorizontalAlignment(4);
      this.QA.setText("10");
      this.add(this.QA, new C0775(290, 145, 60, -1));
      this.add(this.QB, new C0775(40, 170, 140, -1));
      this.zc.setForeground(new Color(255, 255, 255));
      this.zc.setHorizontalAlignment(2);
      this.zc.setText("Característica 1");
      this.add(this.zc, new C0775(420, 30, 110, -1));
      this.Qz.setForeground(new Color(255, 255, 255));
      this.Qz.setHorizontalAlignment(4);
      this.Qz.setText("10");
      this.add(this.Qz, new C0775(120, 145, 60, -1));
   }
}
