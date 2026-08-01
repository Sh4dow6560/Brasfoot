package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.StateChampionship;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionPlayerStats;
import mod.recovered.competition.CompetitionStage;
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
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
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
import javax.swing.JViewport;
import javax.swing.GroupLayout.Alignment;
import mod.recovered.model.Club;

public class C0078 extends JPanel {
   private ImageIcon uL = new ImageIcon(this.getClass().getResource("/aiconsb/b0.png"));
   private ImageIcon uM = new ImageIcon(this.getClass().getResource("/aiconsb/b1.png"));
   private ImageIcon uN = new ImageIcon(this.getClass().getResource("/aiconsb/b2.png"));
   private ImageIcon uO = new ImageIcon(this.getClass().getResource("/aiconsb/b3.png"));
   private ImageIcon uP = new ImageIcon(this.getClass().getResource("/aiconsb/b4.png"));
   private ImageIcon uQ = new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png"));
   private ImageIcon uR = new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png"));
   private ImageIcon uS = new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png"));
   private ImageIcon uT = new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png"));
   private ImageIcon uU = new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png"));
   private JDialog ub;
   private Competition wU = null;
   private CompetitionStage wV = null;
   private CompetitionStage[] wW = null;
   private CompetitionStage wX = null;
   private Competition wY = null;
   private ArrayList cS = new ArrayList();
   private ArrayList vU = new ArrayList();
   boolean wA = false;
   boolean wZ = true;
   boolean xa = true;
   private JPanel xb = null;
   private ArrayList wK = new ArrayList();
   private ArrayList xc = new ArrayList();
   private ArrayList xd = new ArrayList();
   private ArrayList xe = new ArrayList();
   private ArrayList xf = new ArrayList();
   private ArrayList xg = new ArrayList();
   private ArrayList aeP = new ArrayList();
   private int xh = 0;
   private int xi = 0;
   private JLabel xj;
   private JLabel xk;
   private JLabel xl;
   private JLabel xm;
   private JLabel xn;
   private JLabel xo;
   private JLabel xp;
   private JLabel xq;
   private JLabel xr;
   private JLabel xs;
   private JLabel xt;
   private JLabel xu;
   private JLabel xv;
   private JLabel xw;
   private JLabel xx;
   private JButton uW;
   private JButton vm;
   private JButton uX;
   private JButton uY;
   private JButton xy;
   private JButton uZ;
   private JComboBox xz;
   private JComboBox va;
   private JLabel xA;
   private JLabel xB;
   private JLabel xC;
   private JLabel xD;
   private JLabel xE;
   private JLabel xF;
   private JLabel xG;
   private JLabel uh;
   private JLabel ur;
   private JLabel us;
   private JLabel vx;
   private JLabel vy;
   private JLabel vz;
   private JLabel vA;
   private JPanel vd;
   private JPanel wQ;
   private JScrollPane ut;
   private JScrollPane wi;
   private JToolBar ve;
   private JLabel xH;
   private JLabel xI;
   private JLabel xJ;
   private JLabel xK;
   private JLabel xL;
   private JLabel xM;
   private JLabel xN;
   private JLabel xO;
   private JLabel xP;
   private JLabel xQ;
   private JLabel xR;
   private JLabel xS;
   private JLabel xT;
   private JLabel xU;
   private JLabel xV;
   private JLabel xW;
   private JLabel xX;
   private JLabel xY;
   private JLabel xZ;
   private JLabel ya;
   private JLabel yb;
   private JLabel yc;
   private JPanel yd;
   private JPanel ye;
   private JPanel yf;
   private JPanel yg;
   private JPanel yh;
   private JTable wp;
   private JTable vN;

   public C0078(JDialog jDialog, Competition c0713) {
      this.ub = jDialog;
      this.wU = c0713;
      this.mJ();
      this.yg.setVisible(false);
      this.mO();
      this.nv();
      this.nw();
      this.mG();
      byte var3 = 0;
      if (this.wU != null) {
         if (this.wU.b() == 3) {
            var3 = 2;
         } else if (this.wU.b() == 4 || this.wU.b() == 5 || this.wU.b() == 6 || this.wU.b() == 8 || this.wU.b() == 12) {
            var3 = 1;
         } else if (this.wU.b() == 7 || this.wU.b() == 9) {
            var3 = 3;
         } else if (this.wU.b() == 10) {
            var3 = 4;
         } else if (this.wU.b() == 15) {
            if (GamePersistence.careerState.isJogaIntClubes()) {
               var3 = 1;
            } else {
               var3 = 0;
            }
         }
      }

      this.mH();
      this.cM(var3);
      this.xN.setText(Integer.toString(GamePersistence.careerState.getSeasonNumber() + GamePersistence.careerState.getSeasonYearOffset()));
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.xI.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
      this.xI.setForeground(Color.WHITE);
      this.ut.setBorder(BorderFactory.createEmptyBorder());
      if (GamePersistence.getOptions().getCorTema() == 2) {
         this.us.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.uh.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.ur.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.vy.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.vx.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.vz.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.vA.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
      }

      this.xH.setBackground(Color.LIGHT_GRAY);
   }

   private void cM(int i) {
      this.cS = Competition.a(i, false, 0);
      if (this.cS.size() > 0) {
         this.cA(i);
         this.va.removeAllItems();
         if (i == 2) {
            Collections.sort(this.cS, C1007.abj);
         }

         for (int var2 = 0; var2 < this.cS.size(); var2++) {
            this.va.addItem(this.cS.get(var2));
         }

         this.xa = false;
         if (this.cS.contains(this.wU)) {
            this.va.setSelectedItem(this.wU);
         } else if (this.va.getItemCount() > 0) {
            this.va.setSelectedIndex(0);
         }
      }
   }

   private void cC(int i) {
      if (this.cS.size() > 0) {
         this.wU = (Competition)this.va.getSelectedItem();
      }

      if (this.wU != null && this.wU != this.wY) {
         this.wW = this.wU.mB();
         if (this.wW != null) {
            this.no();
            this.wV = this.wW[0];
            this.wZ = true;
            this.ns();
            if (this.xz.isVisible() && this.xz.getItemCount() > 0 && this.wV != null) {
               for (int var2 = 0; var2 < this.xz.getItemCount(); var2++) {
                  if (((C0830)this.xz.getItemAt(var2)).tY()[0] == this.wV) {
                     this.xz.setSelectedIndex(var2);
                     break;
                  }
               }
            }

            this.wZ = false;
            this.nm();
            this.xz.setSelectedItem(this.wV);
            this.wY = this.wU;
         }
      }
   }

   private void cN(int i) {
      if (this.wU != null) {
         if (((C0830)this.xz.getSelectedItem()).tY() != null) {
            this.wW = ((C0830)this.xz.getSelectedItem()).tY();
            this.wV = ((C0830)this.xz.getSelectedItem()).tY()[0];
            this.nm();
         } else {
            this.nn();
         }
      }
   }

   private void nm() {
      if (this.wV != null) {
         if (this.wV != this.wX) {
            this.nt();
            this.cO(1);
            this.wX = this.wV;
            if (!(this.wV instanceof KnockoutStage)) {
               if (this.wV instanceof LeagueStage) {
                  if (((LeagueStage)this.wV).yK().size() > 0) {
                     this.i((LeagueStage)this.wV);
                     this.xH.setVisible(true);
                  } else {
                     this.nn();
                  }
               }
            } else {
               if (this.wW.length > 1) {
                  for (int var1 = this.wW.length - 1; var1 > 0; var1--) {
                     if (this.wW[var1] != null) {
                        this.a((KnockoutStage)this.wW[var1]);
                     }
                  }
               }

               this.a((KnockoutStage)this.wV);
               this.xH.setVisible(false);
            }

            JViewport var2 = this.ut.getViewport();
            var2.setView(this.xb);
         }
      } else {
         this.nn();
      }
   }

   private void nn() {
      this.nt();
      this.wX = null;
      this.cO(1);
      this.xH.setVisible(false);
      this.z("Ainda não definido");
      JViewport var1 = this.ut.getViewport();
      var1.setView(this.xb);
   }

   private void no() {
      int var1 = 0;
      JLabel[] var2 = new JLabel[]{this.xj, this.xk, this.xl, this.xm, this.xn};
      JLabel[] var3 = new JLabel[]{this.xt, this.xu, this.xv, this.xw, this.xx};
      JLabel[] var4 = new JLabel[]{this.xo, this.xp, this.xq, this.xr, this.xs};
      JLabel[] var5 = new JLabel[]{this.xO, this.xP, this.xQ, this.xR, this.xS};
      JLabel[] var6 = new JLabel[]{this.xT, this.xU, this.xV, this.xW, this.xX};
      JLabel[] var7 = new JLabel[]{this.xY, this.xZ, this.ya, this.yb, this.yc};

      for (int var8 = 0; var8 < var2.length; var8++) {
         var2[var8].setText("(ainda não definido)");
         var3[var8].setText("");
         var4[var8].setText("");
         var2[var8].setIcon(null);
      }

      for (int var11 = 0; var11 < var5.length; var11++) {
         var5[var11].setText("(ainda não definido)");
         var5[var11].setIcon(null);
         var6[var11].setText("");
         var7[var11].setText("");
      }

      this.xE.setText("(ainda não há jogos)");
      this.xA.setText("(ainda não há goleadas)");
      this.xG.setIcon(null);
      this.xG.setText("(ainda não definido)");
      this.xB.setIcon(null);
      this.xC.setIcon(null);
      this.xD.setIcon(null);
      this.xB.setText("(ainda não definido)");
      this.xC.setText("");
      this.xD.setText("");

      for (int var12 = 0; var12 < this.wU.ms().size(); var12++) {
         this.wU.mv();
         String var9 = "";
         if (((CompetitionPlayerStats)this.wU.ms().get(var12)).x().fg() != null) {
            if (GameConstants.fs(this.wU.b())) {
               var9 = C0696.bl(((CompetitionPlayerStats)this.wU.ms().get(var12)).x().getPais());
               ImageIcon var10 = new ImageIcon(this.getClass().getResource("/aflags/" + ((CompetitionPlayerStats)this.wU.ms().get(var12)).x().getPais() + ".png"));
               var2[var12].setIcon(var10);
            } else {
               var9 = ((CompetitionPlayerStats)this.wU.ms().get(var12)).x().fg().getNome();
               var2[var12].setIcon(((CompetitionPlayerStats)this.wU.ms().get(var12)).x().fg().kU());
            }
         } else {
            var2[var12].setIcon(null);
         }

         var2[var12].setText(((CompetitionPlayerStats)this.wU.ms().get(var12)).x().getNome() + " (" + var9 + ")");
         var3[var12].setText(Integer.toString(((CompetitionPlayerStats)this.wU.ms().get(var12)).A()));
         var4[var12].setText(Integer.toString(((CompetitionPlayerStats)this.wU.ms().get(var12)).y()));
         if (++var1 == 5) {
            break;
         }
      }

      if (this.wU.mD() != null && this.wU.mD().size() >= 4) {
         this.nr();
      } else {
         this.wU.mz();
         this.nr();
      }

      if (this.wU.mE() != null) {
         this.np();
      } else {
         this.wU.my();
         this.np();
      }

      this.nq();
   }

   private void np() {
      this.xE.setText(this.wU.mE().cQ() + " (" + Integer.toString(this.wU.mE().y()) + " G/" + Integer.toString(this.wU.mE().A()) + " J)");
      if (this.wU.mE().cR() != null) {
         this.xA
            .setText(
               this.wU.mE().cR().hc().getNome()
                  + " "
                  + Integer.toString(this.wU.mE().cR().hu())
                  + " x "
                  + Integer.toString(this.wU.mE().cR().hw())
                  + " "
                  + this.wU.mE().cR().hd().getNome()
            );
      }

      if (this.wU.mE().cS() != null) {
         this.xG.setText(this.wU.mE().cS().getNome());
         this.xG.setIcon(this.wU.mE().cS().kU());
      }

      if (this.wU.mE().cT() != null && this.wU.mE().cT().size() > 0) {
         JLabel[] var1 = new JLabel[]{this.xB, this.xC, this.xD};

         for (int var2 = 0; var2 < this.wU.mE().cT().size(); var2++) {
            var1[var2].setText(((C0707)this.wU.mE().cT().get(var2)).fg().getNome() + " (" + Integer.toString(((C0707)this.wU.mE().cT().get(var2)).lX()) + ")");
            var1[var2].setIcon(((C0707)this.wU.mE().cT().get(var2)).fg().kU());
            if (var2 == var1.length - 1) {
               break;
            }
         }
      }
   }

   private void nq() {
      String[] var1 = this.wU.mA();
      ImageIcon var2 = GameConstants.a(GameConstants.x(var1[0]), 40, 55);
      this.xJ.setIcon(var2);
   }

   private void nr() {
      JLabel[] var1 = new JLabel[]{this.xO, this.xP, this.xQ, this.xR, this.xS};
      JLabel[] var2 = new JLabel[]{this.xT, this.xU, this.xV, this.xW, this.xX};
      JLabel[] var3 = new JLabel[]{this.xY, this.xZ, this.ya, this.yb, this.yc};
      if (this.wU.mD() != null && this.wU.mD().size() > 0) {
         for (int var4 = 0; var4 < this.wU.mD().size(); var4++) {
            String var5 = "";
            if (GameConstants.fs(this.wU.b())) {
               var5 = C0696.bl(((C0690)this.wU.mD().get(var4)).x().getPais());
               ImageIcon var6 = new ImageIcon(this.getClass().getResource("/aflags/" + ((C0690)this.wU.mD().get(var4)).x().getPais() + ".png"));
               var1[var4].setIcon(var6);
            } else if (((C0690)this.wU.mD().get(var4)).x().fg() != null) {
               var5 = ((C0690)this.wU.mD().get(var4)).x().fg().getNome();
               var1[var4].setIcon(((C0690)this.wU.mD().get(var4)).x().fg().kU());
            } else {
               var1[var4].setIcon(null);
            }

            var1[var4]
               .setText(GameConstants.rI[((C0690)this.wU.mD().get(var4)).x().getPosicao()] + " - " + ((C0690)this.wU.mD().get(var4)).x().getNome() + " (" + var5 + ")");
            var2[var4].setText(Integer.toString(((C0690)this.wU.mD().get(var4)).A()));
            var3[var4].setText(((C0690)this.wU.mD().get(var4)).cE());
         }
      }
   }

   private void ns() {
      this.xz.removeAllItems();
      if (this.wU.mC() != null) {
         this.xz.setVisible(true);

         for (int var1 = 0; var1 < this.wU.mC().size(); var1++) {
            this.xz.addItem(this.wU.mC().get(var1));
         }
      } else {
         this.xz.setVisible(false);
      }
   }

   private void a(KnockoutStage c0962) {
      String[] var2 = this.wU.b(c0962);
      if (var2 == null) {
         var2 = c0962.zB();
         if (var2 != null && this.wU.mq() && var2.length > 0) {
            var2[var2.length - 1] = "Final e decisão do 3º lugar";
         }
      }

      for (int var3 = c0962.zp().size() - 1; var3 >= 0; var3--) {
         if (var3 < var2.length) {
            this.z(var2[var3]);
         }

         for (int var4 = 0; var4 < ((KnockoutRound)c0962.zp().get(var3)).zW().size(); var4++) {
            C0809 var5 = new C0809();
            var5.l((Match)((KnockoutRound)c0962.zp().get(var3)).zW().get(var4));
            if (((KnockoutRound)c0962.zp().get(var3)).hO()) {
               var5.m((Match)((KnockoutRound)c0962.zp().get(var3)).zX().get(var4));
            }

            this.a(var5, ((KnockoutRound)c0962.zp().get(var3)).zY());
         }
      }
   }

   private void i(LeagueStage c0955) {
      this.vU.clear();
      if (c0955.yK().size() > 0) {
         this.j(c0955);
         if (c0955 != null && c0955.ze() != 1022) {
            this.o(c0955);
         }
      }

      if (c0955.yQ().size() == 0) {
         this.a(c0955, "", true, 0);
      } else {
         if (this.wU.b() == 4 || this.wU.b() == 6 | this.wU.b() == 7 || this.wU.b() == 9) {
            this.wA = true;
         }

         String[] var2 = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};

         for (int var3 = 0; var3 < c0955.yQ().size(); var3++) {
            String var4 = Integer.toString(var3 + 1);
            if (this.wA) {
               var4 = var2[var3];
            }

            this.a(c0955, var4, false, var3);
         }
      }

      if (c0955.yK().size() <= 0) {
         this.nn();
      }
   }

   private void a(C0810 c0810) {
      if (this.wK.contains(c0810.fg())) {
         c0810.dF(1);
         if (this.xd.contains(c0810.fg())) {
            c0810.dF(101);
         } else if (this.xe.contains(c0810.fg())) {
            c0810.dF(102);
         } else if (this.xf.contains(c0810.fg())) {
            c0810.dF(106);
         } else if (this.xg.contains(c0810.fg())) {
            c0810.dF(106);
         }
      } else if (this.xc.contains(c0810.fg())) {
         c0810.dF(3);
         if (this.xd.contains(c0810.fg())) {
            c0810.dF(301);
         } else if (this.xe.contains(c0810.fg())) {
            c0810.dF(302);
         } else if (this.xf.contains(c0810.fg())) {
            c0810.dF(306);
         } else if (this.xg.contains(c0810.fg())) {
            c0810.dF(106);
         }
      } else if (this.xd.contains(c0810.fg())) {
         c0810.dF(4);
      } else if (this.xe.contains(c0810.fg())) {
         c0810.dF(5);
      } else if (this.xf.contains(c0810.fg())) {
         c0810.dF(2);
      } else if (this.xg.contains(c0810.fg())) {
         c0810.dF(6);
      } else if (this.aeP.contains(c0810.fg())) {
         c0810.dF(12000);
      }
   }

   private void j(LeagueStage c0955) {
      this.xd.clear();
      this.xe.clear();
      this.xf.clear();
      this.xg.clear();
      this.wK.clear();
      this.aeP.clear();
      if (this.wU.b() == 9) {
         this.l(c0955);
      } else if (this.wU.b() == 14) {
         this.s(c0955);
      } else {
         this.n(c0955);
         if (GamePersistence.careerState.isJogaIntClubes() && this.wU.b() == 1) {
            this.m(c0955);
         }
      }
   }

   private void s(LeagueStage c0955) {
      for (int var2 = 0; var2 < c0955.yQ().size(); var2++) {
         this.wK.add((Club)((C0673)c0955.yQ().get(var2)).gR().get(0));
         if (c0955.ze() == 14003) {
            this.xf.add((Club)((C0673)c0955.yQ().get(var2)).gR().get(3));
         }
      }
   }

   private void l(LeagueStage c0955) {
      byte var2 = 0;
      byte var3 = 0;
      byte var4 = 0;
      byte var5 = 0;
      if (c0955.ze() == 7701) {
         var2 = 2;
      } else if (c0955.ze() == 9001) {
         var2 = 1;
         var3 = 1;
         var4 = 2;
         var5 = 2;
         if (GamePersistence.careerState.bL().el() == 70) {
            var2 = 2;
            var3 = 0;
            var4 = 8;
            var5 = 2;
         }
      } else if (c0955.ze() == 9100) {
         var2 = 6;
         var3 = 1;
      } else if (c0955.ze() == 9201) {
         var2 = 1;
         var4 = 4;
         var5 = 1;
      } else if (c0955.ze() == 9301) {
         var3 = 1;
         var4 = 4;
         var5 = 1;
      } else if (c0955.ze() == 9302) {
         var2 = 4;
         var3 = 1;
      } else if (c0955.ze() == 9400) {
         var3 = 1;
      } else if (c0955.ze() == 9402) {
         var2 = 6;
         var3 = 1;
      } else if (c0955.ze() == 9500) {
         var3 = 1;
      } else if (c0955.ze() == 9501) {
         var3 = 2;
      }

      if (var2 > 0) {
         if (c0955.yQ().size() == 0) {
            for (int var6 = 0; var6 < var2; var6++) {
               this.xd.add((Club)c0955.yK().get(var6));
            }
         } else {
            for (int var9 = 0; var9 < c0955.yQ().size(); var9++) {
               for (int var7 = 0; var7 < var2; var7++) {
                  this.xd.add((Club)((C0673)c0955.yQ().get(var9)).gR().get(var7));
               }
            }
         }
      }

      if (var3 > 0) {
         if (c0955.yQ().size() == 0) {
            int var10 = 0;

            for (int var13 = var2; var13 < c0955.yK().size(); var13++) {
               this.xf.add((Club)c0955.yK().get(var13));
               if (++var10 == var3) {
                  break;
               }
            }
         } else {
            for (int var11 = 0; var11 < c0955.yQ().size(); var11++) {
               int var14 = 0;

               for (int var8 = var2; var8 < ((C0673)c0955.yQ().get(var11)).gR().size(); var8++) {
                  this.xf.add((Club)((C0673)c0955.yQ().get(var11)).gR().get(var8));
                  if (++var14 == var3) {
                     break;
                  }
               }
            }
         }
      }

      if (var4 > 0) {
         ArrayList var12 = new ArrayList();

         for (int var15 = 0; var15 < c0955.yQ().size(); var15++) {
            var12.add((Club)((C0673)c0955.yQ().get(var15)).gR().get(var5));
         }

         LeagueStage.r(c0955);
         Collections.sort(var12, C1007.abn);

         for (int var16 = 0; var16 < var4; var16++) {
            this.xf.add((Club)var12.get(var16));
         }
      }
   }

   private void m(LeagueStage c0955) {
      int var2 = c0955.yX();
      if (c0955.ze() == 1022) {
         var2 = 2;
      }

      Club var3 = c0955.fd(1);
      if (var3 != null) {
         this.xd.add(var3);
      }

      if (c0955.vl().gg() == 1 || c0955.vl().gg() == 0) {
         Club var4 = c0955.fd(2);
         if (var4 != null) {
            this.xd.add(var4);
         }
      }

      if (c0955.getDivisao() == 1 && c0955.b() == 1 && var2 == 0) {
         C0792 var11 = null;
         if (c0955.vl() != null) {
            var11 = c0955.vl().As();
         }

         if (var11 != null) {
            if (var11.uS() > 0) {
               Club var5 = null;
               if (c0955.vl().jq() != null) {
                  var5 = c0955.vl().jq().cS();
               }

               if (var5 != null) {
                  this.xd.add(var5);
               }
            }

            int var12 = var11.uO();
            if (var12 > 0) {
               for (int var6 = 0; var6 < c0955.yK().size(); var6++) {
                  if (var12 > 0 && !this.xd.contains(c0955.yK().get(var6))) {
                     this.xd.add((Club)c0955.yK().get(var6));
                     var12--;
                  }
               }
            }

            int var13 = var11.uP();
            if (var13 > 0) {
               for (int var7 = 0; var7 < c0955.yK().size(); var7++) {
                  if (var13 > 0 && !this.xd.contains(c0955.yK().get(var7))) {
                     this.xe.add((Club)c0955.yK().get(var7));
                     var13--;
                  }
               }
            }

            if (var11.uU() > 0) {
               Club var14 = null;
               if (c0955.vl().jq() != null) {
                  var14 = c0955.vl().jq().cS();
               }

               if (var14 != null && !this.xf.contains(var14) && !this.xd.contains(var14) && !this.xe.contains(var14)) {
                  this.xf.add(var14);
               }
            }

            int var15 = var11.uQ();
            if (var15 > 0) {
               for (int var8 = 0; var8 < c0955.yK().size(); var8++) {
                  if (var15 > 0
                     && !this.xf.contains(c0955.yK().get(var8))
                     && !this.xd.contains(c0955.yK().get(var8))
                     && !this.xe.contains(c0955.yK().get(var8))) {
                     this.xf.add((Club)c0955.yK().get(var8));
                     var15--;
                  }
               }
            }

            if (var11.uV() > 0) {
               Club var16 = null;
               if (c0955.vl().jq() != null) {
                  var16 = c0955.vl().jq().cS();
               }

               if (var16 != null && !this.xf.contains(var16) && !this.xd.contains(var16) && !this.xe.contains(var16) && !this.xg.contains(var16)) {
                  this.xf.add(var16);
               }
            }

            int var17 = var11.uR();
            if (var17 > 0) {
               for (int var9 = 0; var9 < c0955.yK().size(); var9++) {
                  if (var17 > 0
                     && !this.xf.contains(c0955.yK().get(var9))
                     && !this.xd.contains(c0955.yK().get(var9))
                     && !this.xe.contains(c0955.yK().get(var9))
                     && !this.xg.contains(c0955.yK().get(var9))) {
                     this.xg.add((Club)c0955.yK().get(var9));
                     var17--;
                  }
               }
            }

            if (c0955.vl().gg() == 0) {
               if (var11.Ba() > 0) {
                  Club var18 = null;
                  if (c0955.vl().jq() != null) {
                     var18 = c0955.vl().jq().cS();
                  }

                  if (var18 != null
                     && !this.aeP.contains(var18)
                     && !this.xf.contains(var18)
                     && !this.xd.contains(var18)
                     && !this.xe.contains(var18)
                     && !this.xg.contains(var18)) {
                     this.aeP.add(var18);
                  }
               }

               int var19 = var11.AY();
               if (var19 > 0) {
                  for (int var10 = 0; var10 < c0955.yK().size(); var10++) {
                     if (var19 > 0
                        && !this.aeP.contains(c0955.yK().get(var10))
                        && !this.xf.contains(c0955.yK().get(var10))
                        && !this.xd.contains(c0955.yK().get(var10))
                        && !this.xe.contains(c0955.yK().get(var10))
                        && !this.xg.contains(c0955.yK().get(var10))) {
                        this.aeP.add((Club)c0955.yK().get(var10));
                        var19--;
                     }
                  }
               }
            }
         }
      }
   }

   private void n(LeagueStage c0955) {
      int var2 = c0955.yX();
      if (c0955.ze() == 1022) {
         var2 = 1;
      }

      if (var2 == 0) {
         if (c0955.getDivisao() > 1) {
            int[] var3 = new int[3];
            if (c0955.yT() instanceof NationalLeague) {
               var3 = ((NationalLeague)c0955.yT()).t(c0955);
            } else if (c0955.yT() instanceof StateChampionship) {
               var3 = ((StateChampionship)c0955.yT()).t(c0955);
            }

            if (var3[0] > 0) {
               for (int var4 = 0; var4 < var3[0]; var4++) {
                  this.wK.add((Club)c0955.yK().get(var4));
               }

               if (var3[1] > 0) {
                  byte var8 = 4;

                  for (int var5 = var3[0]; var5 < var3[0] + var8; var5++) {
                     if (var3[2] > 0) {
                        this.xe.add((Club)c0955.yK().get(var5));
                     } else {
                        this.xf.add((Club)c0955.yK().get(var5));
                     }
                  }
               } else if (var3[2] > 0) {
                  for (int var9 = var3[0] - var3[2]; var9 < var3[0]; var9++) {
                     this.xe.add((Club)c0955.yK().get(var9));
                  }
               }
            }
         }
      } else {
         int var6 = var2;
         if (c0955.yQ().size() != 0 && !c0955.zl()) {
            for (int var11 = 0; var11 < c0955.yQ().size(); var11++) {
               for (int var14 = 0; var14 < var6; var14++) {
                  this.wK.add((Club)((C0673)c0955.yQ().get(var11)).gR().get(var14));
               }

               if (c0955.ze() == 4005) {
                  this.xf.add((Club)((C0673)c0955.yQ().get(var11)).gR().get(2));
               } else if (c0955.ze() == 4104) {
                  this.xf.add((Club)((C0673)c0955.yQ().get(var11)).gR().get(2));
               } else if (c0955.ze() == 6005) {
                  this.aeP.add((Club)((C0673)c0955.yQ().get(var11)).gR().get(2));
               }
            }

            if ((c0955.yQ().size() != 12 || !c0955.melhoresTerceiros) && c0955.yQ().size() == 17) {
               ;
            }
         } else {
            for (int var10 = 0; var10 < var6; var10++) {
               this.wK.add((Club)c0955.yK().get(var10));
            }
         }
      }

      if (c0955.ze() == 1403) {
         ArrayList var7 = new ArrayList();

         for (int var12 = 0; var12 < c0955.yQ().size(); var12++) {
            if (((C0673)c0955.yQ().get(var12)).gR().size() >= 2) {
               var7.add((Club)((C0673)c0955.yQ().get(var12)).gR().get(1));
            }
         }

         LeagueStage.r(c0955);
         Collections.sort(var7, C1007.abn);

         for (int var13 = 0; var13 < 6; var13++) {
            this.xe.add((Club)var7.get(var13));
         }
      }
   }

   private void o(LeagueStage c0955) {
      this.xc.clear();
      if (c0955.b() == 14) {
         if (c0955.ze() == 14001 || c0955.ze() == 14002) {
            for (int var2 = 0; var2 < 4; var2++) {
               this.xc.add((Club)((C0673)c0955.yQ().get(var2)).gR().get(3));
            }
         }
      } else if (c0955.b() == 1 || c0955.b() == 3) {
         int var8 = c0955.getnRebaixados();
         boolean var3 = c0955.zc();
         if (c0955.zc() && c0955.yQ().size() > 0) {
            var8 = Math.round(var8 / c0955.yQ().size());
         }

         if (c0955.zg() && c0955.zh() < var8) {
            var8 = c0955.zh();
         }

         if (var8 > 0) {
            ArrayList var4 = new ArrayList();
            if (!var3) {
               int var9 = var8;

               for (int var11 = c0955.yK().size() - 1; var11 >= 0; var11--) {
                  if (var9 > 0 && !this.wK.contains(c0955.yK().get(var11))) {
                     var4.add((Club)c0955.yK().get(var11));
                     var9--;
                  }
               }
            } else {
               byte var5 = 0;

               for (int var6 = var5; var6 < c0955.yQ().size(); var6++) {
                  for (int var7 = ((C0673)c0955.yQ().get(var6)).gR().size() - 1; var7 >= ((C0673)c0955.yQ().get(var6)).gR().size() - var8; var7--) {
                     var4.add((Club)((C0673)c0955.yQ().get(var6)).gR().get(var7));
                  }
               }
            }

            this.xc.addAll(var4);
            if (c0955.b() == 1 && !c0955.zc()) {
               int var10 = c0955.Bw();
               if (var10 > 0) {
                  for (int var12 = var4.size() - 1; var12 >= 0; var12--) {
                     if (var10 > 0) {
                        this.xe.add((Club)var4.get(var12));
                        var10--;
                     }
                  }
               }
            }
         }
      }
   }

   private void nt() {
      this.xb = new JPanel(new C0807());
      this.xh = 0;
      this.xi = 0;
   }

   private void b(C0810 c0810) {
      if (c0810.fg() != null) {
         this.a(c0810);
         if (this.wU != null) {
            c0810.a(this.wU.b());
         }
      }

      C0801 var2 = new C0801(c0810);
      this.xb.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.xb.add(var2, new C0775(0, this.xh, 470, 25));
      this.xh += 26;
   }

   private void a(C0809 c0809, ArrayList arrayList) {
      c0809.a(this.wU.b());
      C0802 var3 = new C0802(c0809, arrayList);
      boolean var4 = false;
      if (c0809.sQ() != null) {
         var4 = true;
      }

      byte var5 = 55;
      if (!var4) {
         var5 = 30;
      }

      this.xb.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.xb.add(var3, new C0775(0, this.xh, 470, var5));
      this.xh = this.xh + var5 + 1;
   }

   private void z(String string) {
      C0804 var2 = new C0804(string);
      byte var3 = 8;
      if (this.xh == 0) {
         var3 = 0;
      }

      this.xb.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.xb.add(var2, new C0775(0, this.xh + var3, 470, 25));
      this.xh = this.xh + 26 + var3;
   }

   private void A(String string) {
      this.xi++;
      C0803 var2 = new C0803(string);
      if (this.xi > 1) {
         this.xh += 20;
      }

      this.xb.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.xb.add(var2, new C0775(0, this.xh, 470, 25));
      this.xh += 26;
   }

   private void a(LeagueStage c0955, String string, boolean bl, int i) {
      int[] var5 = new int[8];
      int[] var6 = new int[8];
      String var7 = "";
      if (!bl) {
         C0810 var8 = new C0810();
         var8.setInfo("Grupo " + string);
         var8.ak(true);
         this.A("Grupo " + string);
      } else {
         this.A("");
      }

      C0810 var14 = new C0810();
      var14.setInfo("topo");
      new ArrayList();
      ArrayList var9;
      if (bl) {
         var9 = c0955.yK();
      } else {
         var9 = ((C0673)c0955.yQ().get(i)).gR();
      }

      for (int var10 = 0; var10 < var9.size(); var10++) {
         C0810 var11 = new C0810();
         var11.n((Club)var9.get(var10));
         var5 = ((Club)var9.get(var10)).d(c0955);
         var11.l(var5);
         if (var10 == 0) {
            var7 = "1";
         } else if (var10 > 0) {
            var6 = ((Club)var9.get(var10 - 1)).d(c0955);
            if (var5[0] == var6[0] && var5[2] == var6[2] && var5[5] == var6[5] && var5[7] == var6[7]) {
               var7 = "";
            } else {
               var7 = Integer.toString(var10 + 1);
            }
         }

         var11.J(var7);
         this.b(var11);
      }
   }

   private void nu() {
      if (this.vU.size() == 0 && this.wV instanceof LeagueStage) {
         String var1 = Integer.toString(((LeagueStage)this.wV).zb() - 1) + " ª Rodada";
         ArrayList var2 = new ArrayList();
         int var3 = 0;

         for (int var4 = 0; var4 < GamePersistence.careerState.getScheduleDays().size(); var4++) {
            for (int var5 = 0; var5 < ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var4)).j().size(); var5++) {
               if (((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var4)).j().get(var5) == this.wV) {
                  var2.add((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var4));
                  break;
               }
            }
         }

         for (int var8 = 0; var8 < var2.size(); var8++) {
            C0828 var10 = new C0828();
            var10.ao(true);
            var10.D(Integer.toString(var8 + 1) + "ª Rodada");
            this.vU.add(var10);
            var3 = 0;

            for (int var6 = 0; var6 < ((ScheduleDay)var2.get(var8)).h().size(); var6++) {
               if (((Match)((ScheduleDay)var2.get(var8)).h().get(var6)).ht() == this.wV) {
                  C0828 var7 = new C0828();
                  var7.n((Match)((ScheduleDay)var2.get(var8)).h().get(var6));
                  this.vU.add(var7);
                  var3++;
               }
            }

            C0828 var13 = new C0828();
            var13.ao(true);
            var13.D("");
            this.vU.add(var13);
         }

         this.ne();
         this.vN.addNotify();
         int var9 = 0;

         for (int var11 = 0; var11 < this.vU.size(); var11++) {
            if (((C0828)this.vU.get(var11)).sT() != null && ((C0828)this.vU.get(var11)).sT().equals(var1)) {
               var9 = var11;
               break;
            }
         }

         int var12 = var9 + var3 * 2;
         if (var12 > this.vU.size() - 1) {
            var12 = var9 + var3;
         }

         if (var12 > this.vU.size() - 1) {
            var12 = var9;
         }

         this.vN.scrollRectToVisible(new Rectangle(this.vN.getCellRect(var12, 0, true)));
      }
   }

   private void ne() {
      C0652 var1 = new C0652(this.vU);
      this.vN.setModel(var1);
      this.vN.setTableHeader(null);
      int[] var2 = new int[]{120, 30, 120};

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

   private void cA(int i) {
      JButton[] var2 = new JButton[]{this.uY, this.uX, this.uW, this.uZ, this.xy};
      ImageIcon[] var3 = new ImageIcon[]{this.uL, this.uM, this.uN, this.uO, this.uP};
      ImageIcon[] var4 = new ImageIcon[]{this.uQ, this.uR, this.uS, this.uT, this.uU};

      for (int var5 = 0; var5 < var2.length; var5++) {
         var2[var5].setIcon(var3[var5]);
      }

      var2[i].setIcon(var4[i]);
   }

   private void nv() {
      C0625 var1 = new C0625();
      this.va.setPreferredSize(new Dimension(10, 25));
      this.va.setRenderer(var1);
      this.va.setMaximumRowCount(24);
   }

   private void nw() {
      C0627 var1 = new C0627();
      this.xz.setPreferredSize(new Dimension(10, 25));
      this.xz.setRenderer(var1);
      this.xz.setMaximumRowCount(24);
   }

   private void cO(int i) {
      if (i == 1) {
         this.yg.setVisible(false);
         this.ye.setVisible(true);
         this.xI.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.xI.setForeground(Color.WHITE);
         this.xH.setBackground(Color.LIGHT_GRAY);
         this.xH.setForeground(Color.BLACK);
      } else {
         this.yg.setVisible(true);
         this.ye.setVisible(false);
         this.xH.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
         this.xH.setForeground(Color.WHITE);
         this.xI.setBackground(Color.LIGHT_GRAY);
         this.xI.setForeground(Color.BLACK);
         this.nu();
      }
   }

   private void mH() {
      this.vm.addActionListener(new C0079(this));
      this.xI.addMouseListener(new C0029(this));
      this.xH.addMouseListener(new C0030(this));
      this.uY.addActionListener(new C0031(this));
      this.uX.addActionListener(new C0032(this));
      this.uW.addActionListener(new C0033(this));
      this.uZ.addActionListener(new C0034(this));
      this.xy.addActionListener(new C0035(this));
      this.va.addActionListener(new C0036(this));
      this.xz.addItemListener(new C0028(this));
   }

   private void mO() {
      if (!GamePersistence.careerState.isJogaEstadual()) {
         this.uW.setVisible(false);
      }

      if (!GamePersistence.careerState.isJogaRegionais()) {
         this.xy.setVisible(false);
      }

      if (!GamePersistence.careerState.isJogaSelecoesAll()) {
         this.uZ.setVisible(false);
      }

      if (!GamePersistence.careerState.isJogaIntClubes()) {
         this.uX.setVisible(false);
      }
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ve = new JToolBar();
      this.uY = new JButton();
      this.uX = new JButton();
      this.uZ = new JButton();
      this.uW = new JButton();
      this.xy = new JButton();
      this.vm = new JButton();
      this.xN = new JLabel();
      this.wQ = new JPanel();
      this.ut = new JScrollPane();
      this.wp = new JTable();
      this.xz = new JComboBox();
      this.va = new JComboBox();
      this.ye = new JPanel();
      this.yd = new JPanel();
      this.xt = new JLabel();
      this.xj = new JLabel();
      this.xn = new JLabel();
      this.xl = new JLabel();
      this.xk = new JLabel();
      this.xm = new JLabel();
      this.us = new JLabel();
      this.vx = new JLabel();
      this.vy = new JLabel();
      this.xo = new JLabel();
      this.xp = new JLabel();
      this.xu = new JLabel();
      this.xq = new JLabel();
      this.xv = new JLabel();
      this.xr = new JLabel();
      this.xw = new JLabel();
      this.xs = new JLabel();
      this.xx = new JLabel();
      this.yf = new JPanel();
      this.uh = new JLabel();
      this.xO = new JLabel();
      this.xS = new JLabel();
      this.xQ = new JLabel();
      this.xP = new JLabel();
      this.xR = new JLabel();
      this.vz = new JLabel();
      this.vA = new JLabel();
      this.xY = new JLabel();
      this.xT = new JLabel();
      this.xZ = new JLabel();
      this.xU = new JLabel();
      this.ya = new JLabel();
      this.xV = new JLabel();
      this.yb = new JLabel();
      this.xW = new JLabel();
      this.yc = new JLabel();
      this.xX = new JLabel();
      this.yh = new JPanel();
      this.ur = new JLabel();
      this.xK = new JLabel();
      this.xL = new JLabel();
      this.xD = new JLabel();
      this.xM = new JLabel();
      this.xF = new JLabel();
      this.xA = new JLabel();
      this.xB = new JLabel();
      this.xC = new JLabel();
      this.xJ = new JLabel();
      this.xG = new JLabel();
      this.xE = new JLabel();
      this.yg = new JPanel();
      this.wi = new JScrollPane();
      this.vN = new JTable();
      this.xH = new JLabel();
      this.xI = new JLabel();
      this.setBackground(new Color(0, 68, 105));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setLayout(new C0807());
      this.vd.setBackground(new Color(35, 28, 14));
      this.vd.setPreferredSize(new Dimension(483, 40));
      this.vd.setLayout(new C0807());
      this.ve.setBackground(new Color(35, 28, 14));
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
      this.xy.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4.png")));
      this.xy.setBorderPainted(false);
      this.xy.setContentAreaFilled(false);
      this.xy.setFocusable(false);
      this.xy.setHorizontalTextPosition(0);
      this.xy.setMargin(new Insets(0, 0, 0, 0));
      this.xy.setMaximumSize(new Dimension(79, 45));
      this.xy.setMinimumSize(new Dimension(79, 45));
      this.xy.setPreferredSize(new Dimension(79, 45));
      this.xy.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png")));
      this.xy.setVerticalTextPosition(3);
      this.ve.add(this.xy);
      this.vd.add(this.ve, new C0775(0, 0, 600, 50));
      this.vm.setFont(new Font("Tahoma", 1, 12));
      this.vm.setText("X");
      this.vd.add(this.vm, new C0775(740, 10, 55, -1));
      this.xN.setFont(new Font("Arial", 1, 14));
      this.xN.setForeground(new Color(255, 255, 255));
      this.xN.setHorizontalAlignment(0);
      this.xN.setText("2022");
      this.vd.add(this.xN, new C0775(585, 15, 90, -1));
      this.add(this.vd, new C0775(10, 20, 810, 48));
      this.wQ.setOpaque(false);
      this.wQ.setLayout(new C0807());
      this.ut.setHorizontalScrollBarPolicy(31);
      this.ut.setHorizontalScrollBar(null);
      this.ut.setViewportView(this.wp);
      this.wQ.add(this.ut, new C0775(0, 40, 490, 570));
      this.wQ.add(this.xz, new C0775(310, 0, 180, 25));
      this.wQ.add(this.va, new C0775(0, 0, 290, 25));
      this.add(this.wQ, new C0775(14, 90, 490, -1));
      this.ye.setOpaque(false);
      this.ye.setLayout(new C0807());
      this.yd.setBackground(new Color(204, 204, 204));
      this.yd.setLayout(new C0807());
      this.xt.setFont(new Font("Arial", 1, 12));
      this.xt.setHorizontalAlignment(0);
      this.xt.setText("25");
      this.xt.setName("");
      this.yd.add(this.xt, new C0775(265, 30, 30, 20));
      this.xj.setFont(new Font("Arial", 1, 12));
      this.xj.setText("a1");
      this.yd.add(this.xj, new C0775(5, 35, 210, 20));
      this.xn.setFont(new Font("Arial", 1, 12));
      this.xn.setText("a1");
      this.yd.add(this.xn, new C0775(5, 155, 210, 20));
      this.xl.setFont(new Font("Arial", 1, 12));
      this.xl.setText("a1");
      this.yd.add(this.xl, new C0775(5, 95, 210, 20));
      this.xk.setFont(new Font("Arial", 1, 12));
      this.xk.setText("a1");
      this.yd.add(this.xk, new C0775(5, 65, 210, 20));
      this.xm.setFont(new Font("Arial", 1, 12));
      this.xm.setText("a1");
      this.yd.add(this.xm, new C0775(5, 125, 210, 20));
      this.us.setBackground(new Color(0, 0, 0));
      this.us.setFont(new Font("Arial", 1, 12));
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setText("  Artilheiros");
      this.us.setName("");
      this.us.setOpaque(true);
      this.yd.add(this.us, new C0775(0, 0, 225, 30));
      this.vx.setBackground(new Color(0, 0, 0));
      this.vx.setFont(new Font("Arial", 1, 12));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setHorizontalAlignment(0);
      this.vx.setText("J");
      this.vx.setName("");
      this.vx.setOpaque(true);
      this.yd.add(this.vx, new C0775(260, 0, 35, 30));
      this.vy.setBackground(new Color(0, 0, 0));
      this.vy.setFont(new Font("Arial", 1, 12));
      this.vy.setForeground(new Color(255, 255, 255));
      this.vy.setHorizontalAlignment(0);
      this.vy.setText("G");
      this.vy.setName("");
      this.vy.setOpaque(true);
      this.yd.add(this.vy, new C0775(225, 0, 35, 30));
      this.xo.setFont(new Font("Arial", 1, 12));
      this.xo.setHorizontalAlignment(0);
      this.xo.setText("25");
      this.xo.setName("");
      this.yd.add(this.xo, new C0775(225, 30, 30, 20));
      this.xp.setFont(new Font("Arial", 1, 12));
      this.xp.setHorizontalAlignment(0);
      this.xp.setText("25");
      this.xp.setName("");
      this.yd.add(this.xp, new C0775(225, 65, 30, 20));
      this.xu.setFont(new Font("Arial", 1, 12));
      this.xu.setHorizontalAlignment(0);
      this.xu.setText("25");
      this.xu.setName("");
      this.yd.add(this.xu, new C0775(265, 65, 30, 20));
      this.xq.setFont(new Font("Arial", 1, 12));
      this.xq.setHorizontalAlignment(0);
      this.xq.setText("25");
      this.xq.setName("");
      this.yd.add(this.xq, new C0775(225, 95, 30, 20));
      this.xv.setFont(new Font("Arial", 1, 12));
      this.xv.setHorizontalAlignment(0);
      this.xv.setText("25");
      this.xv.setName("");
      this.yd.add(this.xv, new C0775(265, 95, 30, 20));
      this.xr.setFont(new Font("Arial", 1, 12));
      this.xr.setHorizontalAlignment(0);
      this.xr.setText("25");
      this.xr.setName("");
      this.yd.add(this.xr, new C0775(225, 125, 30, 20));
      this.xw.setFont(new Font("Arial", 1, 12));
      this.xw.setHorizontalAlignment(0);
      this.xw.setText("25");
      this.xw.setName("");
      this.yd.add(this.xw, new C0775(265, 125, 30, 20));
      this.xs.setFont(new Font("Arial", 1, 12));
      this.xs.setHorizontalAlignment(0);
      this.xs.setText("25");
      this.xs.setName("");
      this.yd.add(this.xs, new C0775(225, 155, 30, 20));
      this.xx.setFont(new Font("Arial", 1, 12));
      this.xx.setHorizontalAlignment(0);
      this.xx.setText("25");
      this.xx.setName("");
      this.yd.add(this.xx, new C0775(265, 155, 30, 20));
      this.ye.add(this.yd, new C0775(0, 0, 295, 175));
      this.yf.setBackground(new Color(204, 204, 204));
      this.yf.setLayout(new C0807());
      this.uh.setBackground(new Color(0, 0, 0));
      this.uh.setFont(new Font("Arial", 1, 12));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText("  Melhores Notas Médias");
      this.uh.setName("");
      this.uh.setOpaque(true);
      this.yf.add(this.uh, new C0775(0, 0, 225, 30));
      this.xO.setFont(new Font("Arial", 1, 12));
      this.xO.setText("a1");
      this.yf.add(this.xO, new C0775(5, 35, 210, 20));
      this.xS.setFont(new Font("Arial", 1, 12));
      this.xS.setText("a1");
      this.yf.add(this.xS, new C0775(5, 155, 220, 20));
      this.xQ.setFont(new Font("Arial", 1, 12));
      this.xQ.setText("a1");
      this.yf.add(this.xQ, new C0775(5, 95, 210, 20));
      this.xP.setFont(new Font("Arial", 1, 12));
      this.xP.setText("a1");
      this.yf.add(this.xP, new C0775(5, 65, 200, 20));
      this.xR.setFont(new Font("Arial", 1, 12));
      this.xR.setText("a1");
      this.yf.add(this.xR, new C0775(5, 125, 220, 20));
      this.vz.setBackground(new Color(0, 0, 0));
      this.vz.setFont(new Font("Arial", 1, 12));
      this.vz.setForeground(new Color(255, 255, 255));
      this.vz.setHorizontalAlignment(0);
      this.vz.setText("N");
      this.vz.setName("");
      this.vz.setOpaque(true);
      this.yf.add(this.vz, new C0775(225, 0, 35, 30));
      this.vA.setBackground(new Color(0, 0, 0));
      this.vA.setFont(new Font("Arial", 1, 12));
      this.vA.setForeground(new Color(255, 255, 255));
      this.vA.setHorizontalAlignment(0);
      this.vA.setText("J");
      this.vA.setName("");
      this.vA.setOpaque(true);
      this.yf.add(this.vA, new C0775(260, 0, 35, 30));
      this.xY.setFont(new Font("Arial", 1, 12));
      this.xY.setHorizontalAlignment(0);
      this.xY.setText("9,2");
      this.xY.setName("");
      this.yf.add(this.xY, new C0775(225, 30, 30, 20));
      this.xT.setFont(new Font("Arial", 1, 12));
      this.xT.setHorizontalAlignment(0);
      this.xT.setText("25");
      this.xT.setName("");
      this.yf.add(this.xT, new C0775(265, 30, 30, 20));
      this.xZ.setFont(new Font("Arial", 1, 12));
      this.xZ.setHorizontalAlignment(0);
      this.xZ.setText("9,2");
      this.xZ.setName("");
      this.yf.add(this.xZ, new C0775(225, 65, 30, 20));
      this.xU.setFont(new Font("Arial", 1, 12));
      this.xU.setHorizontalAlignment(0);
      this.xU.setText("25");
      this.xU.setName("");
      this.yf.add(this.xU, new C0775(265, 65, 30, 20));
      this.ya.setFont(new Font("Arial", 1, 12));
      this.ya.setHorizontalAlignment(0);
      this.ya.setText("9,2");
      this.ya.setName("");
      this.yf.add(this.ya, new C0775(225, 95, 30, 20));
      this.xV.setFont(new Font("Arial", 1, 12));
      this.xV.setHorizontalAlignment(0);
      this.xV.setText("25");
      this.xV.setName("");
      this.yf.add(this.xV, new C0775(265, 95, 30, 20));
      this.yb.setFont(new Font("Arial", 1, 12));
      this.yb.setHorizontalAlignment(0);
      this.yb.setText("9,2");
      this.yb.setName("");
      this.yf.add(this.yb, new C0775(225, 125, 30, 20));
      this.xW.setFont(new Font("Arial", 1, 12));
      this.xW.setHorizontalAlignment(0);
      this.xW.setText("25");
      this.xW.setName("");
      this.yf.add(this.xW, new C0775(265, 125, 30, 20));
      this.yc.setFont(new Font("Arial", 1, 12));
      this.yc.setHorizontalAlignment(0);
      this.yc.setText("9,2");
      this.yc.setName("");
      this.yf.add(this.yc, new C0775(225, 155, 30, 20));
      this.xX.setFont(new Font("Arial", 1, 12));
      this.xX.setHorizontalAlignment(0);
      this.xX.setText("25");
      this.xX.setName("");
      this.yf.add(this.xX, new C0775(265, 155, 30, 20));
      this.ye.add(this.yf, new C0775(0, 185, 295, 175));
      this.yh.setBackground(new Color(204, 204, 204));
      this.yh.setLayout(new C0807());
      this.ur.setBackground(new Color(0, 0, 0));
      this.ur.setFont(new Font("Arial", 1, 12));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setText("  Estatísticas e história");
      this.ur.setToolTipText("");
      this.ur.setName("");
      this.ur.setOpaque(true);
      this.yh.add(this.ur, new C0775(0, 0, 295, 30));
      this.xK.setFont(new Font("Arial", 1, 12));
      this.xK.setText("Média de gols:");
      this.yh.add(this.xK, new C0775(5, 35, 100, 20));
      this.xL.setFont(new Font("Arial", 1, 12));
      this.xL.setText("Maior vencedor:");
      this.xL.setVerticalAlignment(1);
      this.yh.add(this.xL, new C0775(5, 125, 110, 20));
      this.xD.setFont(new Font("Arial", 1, 12));
      this.xD.setText("Atual campeão:");
      this.yh.add(this.xD, new C0775(110, 175, 180, 20));
      this.xM.setFont(new Font("Arial", 1, 12));
      this.xM.setText("Maior goleada:");
      this.yh.add(this.xM, new C0775(5, 65, 100, 20));
      this.xF.setFont(new Font("Arial", 1, 12));
      this.xF.setText("Último campeão:");
      this.yh.add(this.xF, new C0775(5, 95, 100, 20));
      this.xA.setFont(new Font("Arial", 1, 12));
      this.xA.setText("Último campeão:");
      this.yh.add(this.xA, new C0775(110, 65, 180, 20));
      this.xB.setFont(new Font("Arial", 1, 12));
      this.xB.setText("Último campeão:");
      this.yh.add(this.xB, new C0775(110, 125, 180, 20));
      this.xC.setFont(new Font("Arial", 1, 12));
      this.xC.setText("Último campeão:");
      this.yh.add(this.xC, new C0775(110, 150, 180, 20));
      this.xJ.setForeground(new Color(255, 255, 255));
      this.xJ.setHorizontalAlignment(0);
      this.xJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trsmall.png")));
      this.xJ.setToolTipText("");
      this.yh.add(this.xJ, new C0775(10, 145, 80, 55));
      this.xG.setFont(new Font("Arial", 1, 12));
      this.xG.setText("Último campeão:");
      this.yh.add(this.xG, new C0775(110, 95, 180, 20));
      this.xE.setFont(new Font("Arial", 1, 12));
      this.xE.setText("Último campeão:");
      this.yh.add(this.xE, new C0775(110, 35, 180, 20));
      this.ye.add(this.yh, new C0775(0, 370, 295, 205));
      this.add(this.ye, new C0775(520, 90, 300, 580));
      this.wi.setViewportView(this.vN);
      GroupLayout var1 = new GroupLayout(this.yg);
      this.yg.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGap(0, 303, 32767)
            .addGroup(
               var1.createParallelGroup(Alignment.LEADING)
                  .addGroup(var1.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.wi, -2, 303, -2).addGap(0, 0, 32767))
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGap(0, 536, 32767)
            .addGroup(
               var1.createParallelGroup(Alignment.LEADING)
                  .addGroup(var1.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.wi, -2, 536, -2).addGap(0, 0, 32767))
            )
      );
      this.add(this.yg, new C0775(520, 130, -1, 530));
      this.xH.setHorizontalAlignment(0);
      this.xH.setText("Rodadas");
      this.xH.setOpaque(true);
      this.add(this.xH, new C0775(620, 675, 90, 25));
      this.xI.setHorizontalAlignment(0);
      this.xI.setText("Estatísticas");
      this.xI.setOpaque(true);
      this.add(this.xI, new C0775(520, 675, 90, 25));
   }
}
