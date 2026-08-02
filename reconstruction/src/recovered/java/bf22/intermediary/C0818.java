package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.competition.Competition;
import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JToolBar.Separator;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Player;

public class C0818 extends JPanel {
   C0272 Oy;
   private JLabel Oz;
   private JLabel OA;
   private JButton vb;
   private JButton vc;
   private JButton GP;
   private JButton OB;
   private JButton OC;
   private Separator OD;
   private Separator OE;
   private Separator OF;
   private Separator OG;
   private JToolBar Iv;
   private JLabel OH;
   private JLabel OI;
   private JLabel OJ;
   private JLabel OK;
   private JLabel OL;
   private JLabel OM;
   private JLabel ON;
   private JLabel OO;
   private JLabel OP;
   private JLabel yA;
   private JLabel yB;
   private JLabel yE;
   private JLabel OQ;
   private JLabel OR;
   private JLabel OS;
   private JLabel OT;
   private JLabel OU;
   private JLabel OV;
   private JLabel OW;
   private JLabel OX;
   private JLabel uF;
   private JLabel Ec;
   private JLabel OY;
   private JLabel OZ;
   private JLabel Pa;
   private JLabel Pb;

   public C0818(C0272 c0272) {
      this.Oy = c0272;
      this.mJ();
      this.mH();
      this.GP.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/sell1d.png")));
      this.vc.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/contractd.png")));
      this.OB.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/retiredisabled.png")));
      this.vb.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aicons/sell2d.png")));
      this.GP.setForeground(new Color(123, 134, 222));
      this.setBackground(c0272.qp().kB());
      this.Iv.setBackground(c0272.qp().kB());
      this.Iv.setBorder(BorderFactory.createLineBorder(c0272.qp().kB()));
      Component[] var5;
      int var4 = (var5 = this.getComponents()).length;

      for (int var3 = 0; var3 < var4; var3++) {
         Component var2 = var5[var3];
         if (var2 instanceof JLabel) {
            var2.setForeground(c0272.qp().kC());
         }
      }

      this.uF.setOpaque(true);
      this.uF.setBackground(c0272.qp().kC());
      this.uF.setForeground(c0272.qp().kB());
      this.OM.setOpaque(true);
      this.OM.setBackground(c0272.qp().kC());
      this.OM.setForeground(c0272.qp().kB());
      this.OZ.setFont(new Font("Tahoma", 0, 11));
      this.OK.setFont(new Font("Tahoma", 0, 11));
      this.OL.setFont(new Font("Tahoma", 0, 11));
      this.OT.setFont(new Font("Tahoma", 0, 11));
      this.yB.setFont(new Font("Tahoma", 0, 11));
      this.yA.setFont(new Font("Tahoma", 0, 11));
      this.Pb.setFont(new Font("Tahoma", 0, 11));
      this.OY.setFont(new Font("Tahoma", 0, 11));
      this.OS.setFont(new Font("Tahoma", 0, 11));
      this.OP.setFont(new Font("Tahoma", 0, 11));
      this.OJ.setFont(new Font("Tahoma", 0, 11));
      this.OX.setFont(new Font("Tahoma", 0, 11));
      this.OQ.setFont(new Font("Tahoma", 0, 11));
      this.ON.setFont(new Font("Tahoma", 0, 11));
      this.OH.setFont(new Font("Tahoma", 0, 11));
      this.OV.setFont(new Font("Tahoma", 0, 11));
      this.OR.setFont(new Font("Tahoma", 0, 11));
      this.OO.setFont(new Font("Tahoma", 0, 11));
      this.OI.setFont(new Font("Tahoma", 0, 11));
      this.OW.setFont(new Font("Tahoma", 0, 11));
   }

   public void oJ() {
      this.setBackground(this.Oy.qp().kB());
      this.Iv.setBorder(BorderFactory.createLineBorder(this.Oy.qp().kB()));
      Component[] var4;
      int var3 = (var4 = this.getComponents()).length;

      for (int var2 = 0; var2 < var3; var2++) {
         Component var1 = var4[var2];
         if (var1 instanceof JLabel) {
            var1.setForeground(this.Oy.qp().kC());
         }
      }

      this.uF.setOpaque(true);
      this.uF.setBackground(this.Oy.qp().kC());
      this.uF.setForeground(this.Oy.qp().kB());
      this.OM.setOpaque(true);
      this.OM.setBackground(this.Oy.qp().kC());
      this.OM.setForeground(this.Oy.qp().kB());
   }

   public void a(Player player, Match c0675, Competition c0713, boolean bl) {
      String var5 = player.getContractEndDateLabel();
      String var6 = "Contrato até:";
      if (player.isOnLoan()) {
         var6 = "Emprestado até:";
      }

      String var7 = "";
      if (player.isInjured() && player.getInjuryEndTimeMillis() > ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a().getTime().getTime()) {
         var7 = "Fim contusão: " + ScheduleDay.a(player.getInjuryEndTimeMillis());
      }

      String var8 = "";
      if (c0675 != null && c0713 != null) {
         int[] var9 = player.e(c0675.getCompetition());
         if (var9 == null) {
            var9 = new int[2];
         }

         if (player.c(c0713)) {
            String var10 = "";
            if (var9[0] >= 3) {
               var10 = "3 cartões amarelos";
            }

            if (var9[1] == 1) {
               var10 = "1 jogo";
            } else if (var9[1] > 1) {
               var10 = Integer.toString(var9[1]) + " jogos";
            }

            var8 = "Suspenso " + var10;
         }
      }

      if (bl) {
         var6 = "";
         var5 = "";
      }

      ImageIcon var11 = new ImageIcon(this.getClass().getResource("/aflags/" + player.getPais() + ".png"));
      this.uF.setIcon(var11);
      this.uF.setText(player.getNome());
      this.OT.setText(GameConstants.rH[player.getPosicao()] + " - Lado " + GameConstants.rL[player.getLado()] + " - " + Integer.toString(player.getIdade()) + " anos");
      this.OM.setText("F:" + Integer.toString(player.getOverallStrength()));
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         this.OM.setVisible(false);
      }

      int[] var12 = new int[6];
      var12 = player.gw();
      this.OQ.setText(Integer.toString(var12[0]));
      this.OS.setText(Integer.toString(player.gu()));
      this.OR.setText(Integer.toString(player.i(c0713)));
      this.ON.setText(Integer.toString(var12[1]));
      this.OP.setText(Integer.toString(player.gt()));
      this.OO.setText(Integer.toString(player.gA()));
      this.OH.setText(Integer.toString(var12[5]));
      this.OI.setText(Integer.toString(player.j(c0713)));
      this.OJ.setText(Integer.toString(player.gs()));
      this.OX.setText(player.gn());
      this.OV.setText(player.gx());
      this.OW.setText(player.k(c0713));
      this.Pb.setText(ClubFinances.formatAmount(player.getMarketValue()));
      this.OY.setText(ClubFinances.formatAmount(player.getSalary()));
      this.yA.setText(var7 + " " + var8);
      this.yB.setText(var6 + " " + var5);
   }

   private void mH() {
      this.vb.addActionListener(new C0819(this));
      this.OC.addActionListener(new C0820(this));
      this.OB.addActionListener(new C0821(this));
      this.vc.addActionListener(new C0822(this));
      this.GP.addActionListener(new C0823(this));
   }

   public void g(int i, boolean bl) {
      if (i == 1) {
         this.vb.setVisible(bl);
      }
   }

   public void h(int i, boolean bl) {
      if (i == 1) {
         this.vb.setEnabled(bl);
      } else if (i == 2) {
         this.vc.setEnabled(bl);
      } else if (i == 3) {
         this.GP.setEnabled(bl);
      } else if (i == 4) {
         this.OB.setEnabled(bl);
      } else if (i == 5) {
         this.OC.setEnabled(bl);
      }
   }

   private void mJ() {
      this.Iv = new JToolBar();
      this.GP = new JButton();
      this.OD = new Separator();
      this.vc = new JButton();
      this.OE = new Separator();
      this.OB = new JButton();
      this.OF = new Separator();
      this.vb = new JButton();
      this.OG = new Separator();
      this.OC = new JButton();
      this.uF = new JLabel();
      this.OM = new JLabel();
      this.OT = new JLabel();
      this.yB = new JLabel();
      this.OA = new JLabel();
      this.Oz = new JLabel();
      this.OZ = new JLabel();
      this.OU = new JLabel();
      this.Pa = new JLabel();
      this.Ec = new JLabel();
      this.yA = new JLabel();
      this.yE = new JLabel();
      this.OX = new JLabel();
      this.OJ = new JLabel();
      this.OS = new JLabel();
      this.OP = new JLabel();
      this.OV = new JLabel();
      this.OH = new JLabel();
      this.ON = new JLabel();
      this.OQ = new JLabel();
      this.Pb = new JLabel();
      this.OY = new JLabel();
      this.OK = new JLabel();
      this.OL = new JLabel();
      this.OW = new JLabel();
      this.OI = new JLabel();
      this.OO = new JLabel();
      this.OR = new JLabel();
      this.setBackground(new Color(255, 255, 255));
      this.setPreferredSize(new Dimension(240, 110));
      this.setLayout(new C0807());
      this.Iv.setBackground(new Color(0, 0, 0));
      this.Iv.setFloatable(false);
      this.Iv.setRollover(true);
      this.Iv.setFont(new Font("Tahoma", 0, 12));
      this.Iv.setOpaque(false);
      this.Iv.setPreferredSize(new Dimension(122, 20));
      this.GP.setIcon(new ImageIcon(this.getClass().getResource("/aicons/sell1.png")));
      this.GP.setToolTipText("Vender");
      this.GP.setBorderPainted(false);
      this.GP.setFocusable(false);
      this.GP.setHorizontalTextPosition(0);
      this.GP.setOpaque(false);
      this.GP.setVerticalTextPosition(3);
      this.Iv.add(this.GP);
      this.Iv.add(this.OD);
      this.vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/contract.png")));
      this.vc.setToolTipText("Contrato");
      this.vc.setBorderPainted(false);
      this.vc.setFocusable(false);
      this.vc.setHorizontalTextPosition(0);
      this.vc.setOpaque(false);
      this.vc.setVerticalTextPosition(3);
      this.Iv.add(this.vc);
      this.OE.setAutoscrolls(true);
      this.Iv.add(this.OE);
      this.OB.setIcon(new ImageIcon(this.getClass().getResource("/aicons/retire.png")));
      this.OB.setToolTipText("Aposentar");
      this.OB.setBorderPainted(false);
      this.OB.setFocusable(false);
      this.OB.setHorizontalTextPosition(0);
      this.OB.setMaximumSize(new Dimension(31, 31));
      this.OB.setOpaque(false);
      this.OB.setRequestFocusEnabled(false);
      this.OB.setVerticalTextPosition(3);
      this.Iv.add(this.OB);
      this.Iv.add(this.OF);
      this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/sell2.png")));
      this.vb.setToolTipText("Retirar da Venda");
      this.vb.setBorderPainted(false);
      this.vb.setFocusable(false);
      this.vb.setHorizontalTextPosition(0);
      this.vb.setMaximumSize(new Dimension(31, 31));
      this.vb.setMinimumSize(new Dimension(31, 31));
      this.vb.setOpaque(false);
      this.vb.setPreferredSize(new Dimension(31, 31));
      this.vb.setVerticalTextPosition(3);
      this.Iv.add(this.vb);
      this.Iv.add(this.OG);
      this.OC.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon22.png")));
      this.OC.setToolTipText("Estatísticas");
      this.OC.setBorderPainted(false);
      this.OC.setFocusable(false);
      this.OC.setHorizontalTextPosition(0);
      this.OC.setMaximumSize(new Dimension(31, 31));
      this.OC.setMinimumSize(new Dimension(31, 31));
      this.OC.setOpaque(false);
      this.OC.setPreferredSize(new Dimension(31, 31));
      this.OC.setVerticalTextPosition(3);
      this.Iv.add(this.OC);
      this.add(this.Iv, new C0775(10, 30, 270, 28));
      this.uF.setFont(new Font("Tahoma", 1, 12));
      this.uF.setText("João Silva Clemntino Abade");
      this.add(this.uF, new C0775(10, 5, 220, 20));
      this.OM.setFont(new Font("Tahoma", 1, 12));
      this.OM.setText("F:100");
      this.add(this.OM, new C0775(230, 5, 40, 20));
      this.OT.setFont(new Font("Tahoma", 0, 12));
      this.OT.setText("Meia - Lado Direito - 32 anos");
      this.add(this.OT, new C0775(10, 70, 260, -1));
      this.yB.setHorizontalAlignment(2);
      this.yB.setText("Infor temporada");
      this.add(this.yB, new C0775(10, 90, 260, -1));
      this.OA.setFont(new Font("Tahoma", 1, 11));
      this.OA.setHorizontalAlignment(4);
      this.OA.setText("Gols:");
      this.add(this.OA, new C0775(0, 185, 80, -1));
      this.Oz.setFont(new Font("Tahoma", 1, 11));
      this.Oz.setHorizontalAlignment(4);
      this.Oz.setText("Assistências:");
      this.add(this.Oz, new C0775(0, 200, 80, -1));
      this.OZ.setText("Temporada");
      this.add(this.OZ, new C0775(70, 155, -1, -1));
      this.OU.setFont(new Font("Tahoma", 1, 11));
      this.OU.setHorizontalAlignment(4);
      this.OU.setText("Nota Média:");
      this.add(this.OU, new C0775(0, 215, 80, -1));
      this.Pa.setFont(new Font("Tahoma", 1, 11));
      this.Pa.setHorizontalAlignment(4);
      this.Pa.setText("Valor:");
      this.add(this.Pa, new C0775(5, 130, 40, -1));
      this.Ec.setFont(new Font("Tahoma", 1, 11));
      this.Ec.setHorizontalAlignment(4);
      this.Ec.setText("Salário:");
      this.add(this.Ec, new C0775(145, 130, 50, -1));
      this.yA.setHorizontalAlignment(2);
      this.yA.setText("Infor temporada");
      this.add(this.yA, new C0775(10, 110, 260, -1));
      this.yE.setFont(new Font("Tahoma", 1, 11));
      this.yE.setHorizontalAlignment(4);
      this.yE.setText("Jogos:");
      this.yE.setPreferredSize(new Dimension(80, 14));
      this.add(this.yE, new C0775(0, 170, 80, 15));
      this.OX.setText("0");
      this.add(this.OX, new C0775(100, 215, 40, -1));
      this.OJ.setText("0");
      this.add(this.OJ, new C0775(100, 200, 40, -1));
      this.OS.setText("0");
      this.add(this.OS, new C0775(100, 170, 40, -1));
      this.OP.setText("0");
      this.add(this.OP, new C0775(100, 185, 40, -1));
      this.OV.setText("0");
      this.add(this.OV, new C0775(160, 215, 30, -1));
      this.OH.setText("0");
      this.add(this.OH, new C0775(160, 200, 30, -1));
      this.ON.setText("0");
      this.add(this.ON, new C0775(160, 185, 30, -1));
      this.OQ.setText("0");
      this.add(this.OQ, new C0775(160, 170, 30, -1));
      this.Pb.setText("jLabel24");
      this.add(this.Pb, new C0775(50, 130, 100, -1));
      this.OY.setText("jLabel30");
      this.add(this.OY, new C0775(200, 130, 80, -1));
      this.OK.setText("Carreira");
      this.add(this.OK, new C0775(140, 155, -1, -1));
      this.OL.setText("Competição atual");
      this.add(this.OL, new C0775(190, 155, -1, -1));
      this.OW.setText("0");
      this.add(this.OW, new C0775(220, 215, 30, -1));
      this.OI.setText("0");
      this.add(this.OI, new C0775(220, 200, 30, -1));
      this.OO.setText("0");
      this.add(this.OO, new C0775(220, 185, 30, -1));
      this.OR.setText("0");
      this.add(this.OR, new C0775(220, 170, 30, -1));
   }
}
