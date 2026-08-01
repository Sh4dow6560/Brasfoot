package bf22.intermediary;

import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.StateChampionship;
import mod.recovered.competition.Competition;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import mod.recovered.model.Club;

public class C0054 extends JPanel {
   private static final long serialVersionUID = 1L;
   private JDialog ub;
   private ArrayList cS = new ArrayList();
   private ArrayList vS = new ArrayList();
   private ArrayList vT = new ArrayList();
   private ArrayList vU = new ArrayList();
   private ArrayList vV = new ArrayList();
   private LeagueStage vW = null;
   private Competition vX = null;
   private KnockoutStage vY = null;
   private ImageIcon uL = new ImageIcon(this.getClass().getResource("/aiconsb/b0.png"));
   private ImageIcon uM = new ImageIcon(this.getClass().getResource("/aiconsb/b1.png"));
   private ImageIcon uN = new ImageIcon(this.getClass().getResource("/aiconsb/b2.png"));
   private ImageIcon uO = new ImageIcon(this.getClass().getResource("/aiconsb/b3.png"));
   private ImageIcon uQ = new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png"));
   private ImageIcon uR = new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png"));
   private ImageIcon uS = new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png"));
   private ImageIcon uT = new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png"));
   private int vZ = -1;
   private int wa = -1;
   private Competition wb = null;
   private String wc = "";
   private int wd = 0;
   private JButton uW;
   private JButton vm;
   private JButton uX;
   private JButton uY;
   private JButton uZ;
   private JComboBox va;
   private JPanel vd;
   private JPanel we;
   private JPanel wf;
   private JPanel wg;
   private JPanel wh;
   private JScrollPane ut;
   private JScrollPane wi;
   private JToolBar ve;
   private JLabel wj;
   private JLabel wk;
   private JLabel wl;
   private JLabel wm;
   private JLabel wn;
   private JLabel wo;
   private JLabel vf;
   private JTable wp;
   private JTable vN;

   public void t(Competition c0713) {
      this.vS.clear();
      this.vV.clear();
      this.vX = c0713;
   }

   public void a(String string, Long long_) {
      Preferences var3 = Preferences.userRoot();
      Preferences var4 = var3.node("systemacxyz22");
      String var5 = C0670.eW();
      var4.put("n", var5);
      var4.putInt("nr", this.b(C0670.eX(), var5));
   }

   public static int G(int i, int j) {
      String var2 = String.valueOf(i);
      if (var2.charAt(0) == '-') {
         j++;
      }

      return Character.getNumericValue(var2.charAt(j - 1));
   }

   private void cF(int i) {
      this.wi.setVisible(false);
      this.wg.setVisible(false);
      this.wj.setVisible(false);
      this.wl.setVisible(false);
      this.wo.setVisible(false);
      if (this.vY == null && this.vW != null && this.vW.yX() > 0) {
         this.vY = this.vW.yY();
         if (this.vY == null) {
            int var2 = 0;
            if (this.vW.yQ().size() > 0) {
               var2 = this.vW.yX() * this.vW.yQ().size();
            } else {
               var2 = this.vW.yX();
            }

            this.vY = new KnockoutStage(this.vW, var2, this.vW.b(), 0, this.vW.getDuasVoltasMataMata(), this.vX, -1);
         }
      }

      if ((i > -1 || this.vW == null) && i >= 0 && this.vY != null && i <= this.vY.zq()) {
         this.vT.clear();
         int var17 = this.vY.zq();
         int var3 = this.vY.zb();
         boolean var4 = false;
         if (var17 == 0) {
            var4 = true;
         }

         if (i == -1) {
            this.wa = var3;
         } else {
            this.wa = i;
         }

         int var5 = GameConstants.ps.length - 1 - var17;
         int var6 = var5 + this.wa;
         int var7 = 1;
         String var8 = GameConstants.pu[var6];
         if (var4) {
            var8 = GameConstants.pu[0];
         }

         if (this.wa < this.vY.zp().size()) {
            this.y(var8);
         } else {
            int[] var9 = new int[]{64, 32, 16, 8, 4, 2, 1};
            String var10;
            if (var6 >= 1) {
               var10 = "vencedor " + GameConstants.pu[var6 - 1];
            } else {
               var10 = "vencedor ";
            }

            for (int var11 = 0; var11 < var9[var6]; var11++) {
               C0809 var12 = new C0809();
               var12.ai(true);
               var12.aj(true);
               this.vT.add(var12);
               C0809 var13 = new C0809();
               var13.ah(true);
               var13.E(var8 + Integer.toString(var11 + 1));
               var13.aj(true);
               var13.E(var8 + Integer.toString(var11 + 1));
               this.vT.add(var13);
               C0809 var14 = new C0809();
               var14.F(var10 + var7);
               var14.G(var10 + (var7 + 1));
               var14.aj(true);
               this.vT.add(var14);
               boolean[] var15 = this.vY.zz();
               if (var15[var6]) {
                  var13.H(var10 + (var7 + 1));
                  var13.I(var10 + var7);
                  var14.H(var10 + (var7 + 1));
                  var14.I(var10 + var7);
               }

               var7 += 2;
            }
         }

         if (var4) {
            this.wm.setText(GameConstants.ps[0]);
         } else {
            this.wm.setText(GameConstants.ps[var5 + this.wa]);
         }

         this.nd();
      }
   }

   private int b(int i, String string) {
      char var3 = string.charAt(0);
      int var4 = var3 * 31348;
      return i - var4;
   }

   public C0054() {
      this.a("", 0L);
   }

   private void y(String string) {
      for (int var2 = 0; var2 < ((KnockoutRound)this.vY.zp().get(this.wa)).zW().size(); var2++) {
         C0809 var3 = new C0809();
         var3.ai(true);
         this.vT.add(var3);
         C0809 var4 = new C0809();
         var4.l((Match)((KnockoutRound)this.vY.zp().get(this.wa)).zW().get(var2));
         var4.ah(true);
         var4.E(string + Integer.toString(var2 + 1));
         this.vT.add(var4);
         C0809 var5 = new C0809();
         var5.l((Match)((KnockoutRound)this.vY.zp().get(this.wa)).zW().get(var2));
         this.vT.add(var5);
         if (((KnockoutRound)this.vY.zp().get(this.wa)).hO()) {
            var4.m((Match)((KnockoutRound)this.vY.zp().get(this.wa)).zX().get(var2));
            var5.m((Match)((KnockoutRound)this.vY.zp().get(this.wa)).zX().get(var2));
         }
      }
   }

   private void h(LeagueStage c0955) {
      int[] var2 = new int[8];
      int[] var3 = new int[8];
      String var4 = "";
      int var5 = -1;
      if (c0955.b() == 1 && c0955.getDivisao() > 1) {
         var5 = ((NationalLeague)c0955.iq().eb().get(c0955.getDivisao() - 2)).yi().getnRebaixados();
      } else if (c0955.b() == 3 && c0955.getDivisao() > 1) {
         var5 = ((StateChampionship)c0955.ir().eb().get(c0955.getDivisao() - 2)).yi().getnRebaixados();
      }

      if (c0955.yQ().size() == 0) {
         C0810 var6 = new C0810();
         var6.setInfo("topo");
         this.vS.add(var6);
         new ArrayList();
         ArrayList var7 = c0955.yK();

         for (int var8 = 0; var8 < var7.size(); var8++) {
            C0810 var9 = new C0810();
            var9.n((Club)var7.get(var8));
            var2 = ((Club)var7.get(var8)).d(c0955);
            var9.l(var2);
            if (var8 == 0) {
               var4 = "1º";
            } else if (var8 > 0) {
               var3 = ((Club)var7.get(var8 - 1)).d(c0955);
               if (var2[0] == var3[0] && var2[2] == var3[2] && var2[5] == var3[5] && var2[7] == var3[7]) {
                  var4 = "";
               } else {
                  var4 = Integer.toString(var8 + 1) + "º";
               }
            }

            if (c0955.yX() > 0) {
               if (var8 < c0955.yX()) {
                  var9.dF(1);
               }
            } else if (var5 > 0 && var8 < var5) {
               var9.dF(1);
            }

            if (var8 >= var7.size() - c0955.getnRebaixados()) {
               var9.dF(3);
            }

            var9.J(var4);
            this.vS.add(var9);
         }
      } else {
         for (int var17 = 0; var17 < c0955.yQ().size(); var17++) {
            if (var17 > 0) {
               C0810 var19 = new C0810();
               var19.setInfo("");
               var19.ak(true);
               this.vS.add(var19);
            }

            C0810 var20 = new C0810();
            var20.setInfo("Grupo " + Integer.toString(var17 + 1));
            var20.ak(true);
            this.vS.add(var20);
            C0810 var22 = new C0810();
            var22.setInfo("topo");
            this.vS.add(var22);
            new ArrayList();
            ArrayList var23 = ((C0673)c0955.yQ().get(var17)).gR();

            for (int var10 = 0; var10 < var23.size(); var10++) {
               C0810 var11 = new C0810();
               var11.n((Club)var23.get(var10));
               var2 = ((Club)var23.get(var10)).d(c0955);
               var11.l(var2);
               if (var10 == 0) {
                  var4 = "1º";
               } else if (var10 > 0) {
                  var3 = ((Club)var23.get(var10 - 1)).d(c0955);
                  if (var2[0] == var3[0] && var2[2] == var3[2] && var2[5] == var3[5] && var2[7] == var3[7]) {
                     var4 = "";
                  } else {
                     var4 = Integer.toString(var10 + 1) + "º";
                  }
               }

               var11.J(var4);
               if (var10 < c0955.yX()) {
                  var11.dF(1);
               }

               int var12 = 0;
               if (c0955.zc() && c0955.yQ().size() > 0) {
                  var12 = Math.round(c0955.getnRebaixados() / c0955.yQ().size());
                  if (var10 >= var23.size() - var12) {
                     var11.dF(3);
                  }
               } else {
                  var12 = c0955.getnRebaixados();
                  if (c0955.R((Club)var23.get(var10)) >= c0955.yK().size() - var12) {
                     var11.dF(3);
                  }
               }

               this.vS.add(var11);
            }
         }
      }

      this.wk.setVisible(true);
      this.wn.setVisible(true);
      this.wm.setVisible(true);
      this.wm.setText("1ª fase");
      if (this.vW.yX() == 0) {
         this.wk.setVisible(false);
         this.wn.setVisible(false);
         this.wm.setVisible(false);
      }

      for (int var18 = 0; var18 < GamePersistence.SR.R().size(); var18++) {
         for (int var21 = 0; var21 < ((C0693)GamePersistence.SR.R().get(var18)).t().size(); var21++) {
            if (((C0693)GamePersistence.SR.R().get(var18)).t().get(var21) == this.vX) {
               this.vV.add((C0693)GamePersistence.SR.R().get(var18));
               break;
            }
         }
      }

      this.cG(this.vZ);
   }

   private void cG(int i) {
      if (i == -1) {
         i = this.vW.zb() - 1;
      }

      boolean var2 = false;
      if (this.vW.yZ()) {
         var2 = true;
      }

      this.vZ = i;
      if (!var2) {
         this.wa = -1;
         this.vU.clear();
         this.vV.size();
         this.wo.setText(i + 1 + "ª rodada");
         this.wj.setVisible(true);
         this.wl.setVisible(true);
         if (i == 0) {
            this.wj.setVisible(false);
         } else if (i == this.vW.yG() - 1) {
            this.wl.setVisible(false);
         }

         this.vN.addNotify();
      } else {
         this.cF(this.wa);
      }
   }

   private void nc() {
      C0653 var1 = new C0653(this.vS);
      this.wp.setModel(var1);
      this.wp.setTableHeader(null);
      int[] var2 = new int[]{20, 5, 140, 20, 20, 20, 20, 20, 20, 20, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.wp.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.wp.getColumnModel().getColumn(0).setMaxWidth(20);
      this.wp.getColumnModel().getColumn(1).setMaxWidth(5);
      this.wp.setAutoResizeMode(3);
      this.wp.setRowHeight(24);
      this.wp.setShowGrid(false);
      this.wp.setDefaultRenderer(C0810.class, new C0592());
      this.wp.setAutoCreateRowSorter(false);
      this.wp.setIntercellSpacing(new Dimension(0, 0));
      this.wp.setCellSelectionEnabled(false);
      this.wp.setRowSelectionAllowed(false);
      this.wp.setFillsViewportHeight(true);
   }

   private void nd() {
      C0654 var1 = new C0654(this.vT);
      this.wp.setModel(var1);
      this.wp.setTableHeader(null);
      int[] var2 = new int[]{90, 40, 90, 100, 90, 40, 90};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.wp.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.wp.setRowHeight(24);
      this.wp.setShowGrid(false);
      this.wp.setDefaultRenderer(C0809.class, new C0642());
      this.wp.setAutoCreateRowSorter(false);
      this.wp.setIntercellSpacing(new Dimension(0, 0));
      this.wp.setCellSelectionEnabled(false);
      this.wp.setRowSelectionAllowed(false);
      this.wp.setFillsViewportHeight(true);
   }

   private void ne() {
      C0652 var1 = new C0652(this.vU);
      this.vN.setModel(var1);
      this.vN.setTableHeader(null);
      int[] var2 = new int[]{90, 40, 90};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vN.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vN.setRowHeight(20);
      this.vN.setShowGrid(false);
      this.vN.setDefaultRenderer(C0828.class, new C0621());
      this.vN.setAutoCreateRowSorter(false);
      this.vN.setIntercellSpacing(new Dimension(0, 0));
      this.vN.setCellSelectionEnabled(false);
      this.vN.setRowSelectionAllowed(false);
      this.vN.setFillsViewportHeight(true);
   }

   public void mH() {
      this.vm.addActionListener(new C0055(this));
      this.wn.addMouseListener(new C0057(this));
      this.wk.addMouseListener(new C0058(this));
      this.wj.addMouseListener(new C0059(this));
      this.wl.addMouseListener(new C0060(this));
   }

   private void cC(int i) {
      this.vZ = -1;
      this.wa = 0;
      this.vY = null;
      this.wi.setVisible(true);
      this.wj.setVisible(true);
      this.wl.setVisible(true);
      this.wo.setVisible(true);
      this.nc();
      this.ne();
      if (this.cS.size() > 0) {
         this.t((Competition)this.va.getSelectedItem());
      }
   }

   private void mQ() {
      C0625 var1 = new C0625();
      this.va.setPreferredSize(new Dimension(10, 25));
      this.va.setRenderer(var1);
      this.va.setMaximumRowCount(24);
      this.va.addActionListener(new C0061(this));
   }

   private void mO() {
      if (!GamePersistence.SR.isJogaEstadual()) {
         this.uW.setVisible(false);
      }

      if (!GamePersistence.SR.isJogaSelecoesAll()) {
         this.uZ.setVisible(false);
      }

      if (!GamePersistence.SR.isJogaIntClubes()) {
         this.uX.setVisible(false);
      }
   }

   private void mP() {
      this.uY.addActionListener(new C0062(this));
      this.uX.addActionListener(new C0063(this));
      this.uW.addActionListener(new C0064(this));
      this.uZ.addActionListener(new C0056(this));
   }

   private void cA(int i) {
      JButton[] var2 = new JButton[]{this.uY, this.uX, this.uW, this.uZ};
      ImageIcon[] var3 = new ImageIcon[]{this.uL, this.uM, this.uN, this.uO};
      ImageIcon[] var4 = new ImageIcon[]{this.uQ, this.uR, this.uS, this.uT};

      for (int var5 = 0; var5 < var2.length; var5++) {
         var2[var5].setIcon(var3[var5]);
      }

      var2[i].setIcon(var4[i]);
   }

   private void cB(int i) {
      this.cA(i);
      this.cS = Competition.a(i, false, 0);
      this.va.removeAllItems();

      for (int var2 = 0; var2 < this.cS.size(); var2++) {
         this.va.addItem(this.cS.get(var2));
      }

      this.va.setSelectedItem(this.wb);
   }

   private void mJ() {
      this.vf = new JLabel();
      this.vd = new JPanel();
      this.va = new JComboBox();
      this.ve = new JToolBar();
      this.uY = new JButton();
      this.uX = new JButton();
      this.uW = new JButton();
      this.uZ = new JButton();
      this.ut = new JScrollPane();
      this.wp = new JTable();
      this.wi = new JScrollPane();
      this.vN = new JTable();
      this.we = new JPanel();
      this.vm = new JButton();
      this.wf = new JPanel();
      this.wg = new JPanel();
      this.wj = new JLabel();
      this.wo = new JLabel();
      this.wl = new JLabel();
      this.wh = new JPanel();
      this.wm = new JLabel();
      this.wn = new JLabel();
      this.wk = new JLabel();
      this.setBackground(new Color(204, 204, 204));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.vf.setFont(new Font("Tahoma", 1, 12));
      this.vf.setText("Classificação e jogos");
      this.vd.setBackground(new Color(255, 204, 51));
      this.vd.setPreferredSize(new Dimension(483, 40));
      this.vd.setLayout(new C0807());
      this.vd.add(this.va, new C0775(420, 10, 290, 25));
      this.ve.setBackground(new Color(255, 205, 26));
      this.ve.setFloatable(false);
      this.ve.setRollover(true);
      this.ve.setBorderPainted(false);
      this.uY.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0.png")));
      this.uY.setBorderPainted(false);
      this.uY.setContentAreaFilled(false);
      this.uY.setFocusable(false);
      this.uY.setHorizontalTextPosition(0);
      this.uY.setMargin(new Insets(0, 0, 0, 0));
      this.uY.setMaximumSize(new Dimension(79, 45));
      this.uY.setMinimumSize(new Dimension(79, 45));
      this.uY.setPreferredSize(new Dimension(79, 45));
      this.uY.setPressedIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
      this.uY.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
      this.uY.setVerticalTextPosition(3);
      this.ve.add(this.uY);
      this.uX.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1.png")));
      this.uX.setBorderPainted(false);
      this.uX.setContentAreaFilled(false);
      this.uX.setFocusable(false);
      this.uX.setHorizontalTextPosition(0);
      this.uX.setMargin(new Insets(0, 0, 0, 0));
      this.uX.setMaximumSize(new Dimension(79, 45));
      this.uX.setMinimumSize(new Dimension(79, 45));
      this.uX.setPreferredSize(new Dimension(79, 45));
      this.uX.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png")));
      this.uX.setVerticalTextPosition(3);
      this.ve.add(this.uX);
      this.uW.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2.png")));
      this.uW.setBorderPainted(false);
      this.uW.setContentAreaFilled(false);
      this.uW.setFocusable(false);
      this.uW.setHorizontalTextPosition(0);
      this.uW.setMargin(new Insets(0, 0, 0, 0));
      this.uW.setMaximumSize(new Dimension(79, 45));
      this.uW.setMinimumSize(new Dimension(79, 45));
      this.uW.setPreferredSize(new Dimension(79, 45));
      this.uW.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png")));
      this.uW.setVerticalTextPosition(3);
      this.ve.add(this.uW);
      this.uZ.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3.png")));
      this.uZ.setBorderPainted(false);
      this.uZ.setContentAreaFilled(false);
      this.uZ.setFocusable(false);
      this.uZ.setHorizontalTextPosition(0);
      this.uZ.setMargin(new Insets(0, 0, 0, 0));
      this.uZ.setMaximumSize(new Dimension(79, 45));
      this.uZ.setMinimumSize(new Dimension(79, 45));
      this.uZ.setPreferredSize(new Dimension(79, 45));
      this.uZ.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png")));
      this.uZ.setVerticalTextPosition(3);
      this.ve.add(this.uZ);
      this.vd.add(this.ve, new C0775(0, 0, 340, 40));
      this.wp.setModel(new DefaultTableModel(new Object[][]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
      this.ut.setViewportView(this.wp);
      this.vN.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.wi.setViewportView(this.vN);
      this.we.setOpaque(false);
      GroupLayout var1 = new GroupLayout(this.we);
      this.we.setLayout(var1);
      var1.setHorizontalGroup(var1.createParallelGroup(Alignment.LEADING).addGap(0, 509, 32767));
      var1.setVerticalGroup(var1.createParallelGroup(Alignment.LEADING).addGap(0, 0, 32767));
      this.vm.setText("X");
      this.wf.setOpaque(false);
      GroupLayout var2 = new GroupLayout(this.wf);
      this.wf.setLayout(var2);
      var2.setHorizontalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 9, 32767));
      var2.setVerticalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 0, 32767));
      this.wg.setOpaque(false);
      this.wj.setText("<<");
      this.wo.setFont(new Font("Tahoma", 0, 12));
      this.wo.setHorizontalAlignment(0);
      this.wo.setText("1ª rodada");
      this.wo.setHorizontalTextPosition(0);
      this.wl.setText(">>");
      GroupLayout var3 = new GroupLayout(this.wg);
      this.wg.setLayout(var3);
      var3.setHorizontalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var3.createSequentialGroup()
                  .addGap(74, 74, 74)
                  .addComponent(this.wj)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.wo, -2, 111, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.wl)
                  .addContainerGap(-1, 32767)
            )
      );
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var3.createSequentialGroup()
                  .addGroup(var3.createParallelGroup(Alignment.BASELINE).addComponent(this.wj).addComponent(this.wo).addComponent(this.wl))
                  .addGap(0, 0, 32767)
            )
      );
      this.wh.setOpaque(false);
      this.wm.setFont(new Font("Tahoma", 0, 12));
      this.wm.setHorizontalAlignment(0);
      this.wm.setText("Oitavas de final");
      this.wn.setFont(new Font("Tahoma", 0, 12));
      this.wn.setHorizontalAlignment(4);
      this.wn.setText("Próxima Fase>>");
      this.wk.setFont(new Font("Tahoma", 0, 12));
      this.wk.setHorizontalAlignment(2);
      this.wk.setText("<< Fase Anterior");
      GroupLayout var4 = new GroupLayout(this.wh);
      this.wh.setLayout(var4);
      var4.setHorizontalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var4.createSequentialGroup()
                  .addComponent(this.wk, -2, 101, -2)
                  .addGap(53, 53, 53)
                  .addComponent(this.wm, -2, 129, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, 86, 32767)
                  .addComponent(this.wn, -2, 105, -2)
            )
      );
      var4.setVerticalGroup(
         var4.createParallelGroup(Alignment.LEADING)
            .addGroup(var4.createParallelGroup(Alignment.BASELINE).addComponent(this.wm).addComponent(this.wn).addComponent(this.wk))
      );
      GroupLayout var5 = new GroupLayout(this);
      this.setLayout(var5);
      var5.setHorizontalGroup(
         var5.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var5.createSequentialGroup()
                  .addGap(10, 10, 10)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           Alignment.TRAILING,
                           var5.createSequentialGroup()
                              .addComponent(this.vf, -2, 293, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, 394, 32767)
                              .addComponent(this.vm, -2, 52, -2)
                        )
                        .addGroup(var5.createSequentialGroup().addComponent(this.vd, -1, -1, 32767).addGap(2, 2, 2))
                        .addGroup(
                           var5.createSequentialGroup()
                              .addGroup(
                                 var5.createParallelGroup(Alignment.LEADING)
                                    .addGroup(var5.createSequentialGroup().addComponent(this.ut).addGap(6, 6, 6))
                                    .addGroup(
                                       Alignment.TRAILING,
                                       var5.createSequentialGroup().addComponent(this.wh, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED)
                                    )
                              )
                              .addGroup(
                                 var5.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.wi, -2, 0, 32767)
                                    .addGroup(var5.createSequentialGroup().addComponent(this.wg, -1, -1, 32767).addGap(2, 2, 2))
                              )
                        )
                  )
                  .addGap(8, 8, 8)
                  .addComponent(this.wf, -2, -1, -2)
            )
      );
      var5.setVerticalGroup(
         var5.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var5.createSequentialGroup()
                  .addGap(11, 11, 11)
                  .addGroup(
                     var5.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var5.createSequentialGroup()
                              .addGroup(
                                 var5.createParallelGroup(Alignment.LEADING)
                                    .addGroup(var5.createSequentialGroup().addGap(3, 3, 3).addComponent(this.vf))
                                    .addComponent(this.vm)
                              )
                              .addGap(11, 11, 11)
                              .addComponent(this.vd, -2, -1, -2)
                              .addGap(18, 18, 18)
                              .addGroup(
                                 var5.createParallelGroup(Alignment.LEADING, false).addComponent(this.wg, -1, -1, 32767).addComponent(this.wh, -1, -1, 32767)
                              )
                              .addGap(6, 6, 6)
                              .addGroup(var5.createParallelGroup(Alignment.LEADING).addComponent(this.wi, -1, 602, 32767).addComponent(this.ut))
                              .addGap(16, 16, 16)
                        )
                        .addComponent(this.wf, -1, -1, 32767)
                  )
            )
      );
   }
}
