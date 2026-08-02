package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.competition.AfcChampionsLeague;
import mod.recovered.competition.AfricaCupOfNations;
import mod.recovered.competition.AfricaWorldCupQualifiers;
import mod.recovered.competition.AsiaWorldCupQualifiers;
import mod.recovered.competition.AsianCup;
import mod.recovered.competition.CafChampionsLeague;
import mod.recovered.competition.ClubWorldCup;
import mod.recovered.competition.ConcacafChampionsLeague;
import mod.recovered.competition.ConcacafGoldCup;
import mod.recovered.competition.ConcacafWorldCupQualifiers;
import mod.recovered.competition.CopaAmerica;
import mod.recovered.competition.CopaLibertadores;
import mod.recovered.competition.CopaSudamericana;
import mod.recovered.competition.EuropeWorldCupQualifiers;
import mod.recovered.competition.EuropeanChampionship;
import mod.recovered.competition.EuropeanSuperCup;
import mod.recovered.competition.NationalCup;
import mod.recovered.competition.NationalLeague;
import mod.recovered.competition.OceaniaWorldCupQualifiers;
import mod.recovered.competition.OfcChampionsLeague;
import mod.recovered.competition.OfcNationsCup;
import mod.recovered.competition.RegionalCup;
import mod.recovered.competition.SouthAmericaWorldCupQualifiers;
import mod.recovered.competition.SouthAmericanRecopa;
import mod.recovered.competition.StateChampionship;
import mod.recovered.competition.UefaChampionsLeague;
import mod.recovered.competition.UefaEuropaLeague;
import mod.recovered.competition.WorldCup;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CountryCompetitions;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;

public class C0065 extends JPanel {
   private JDialog ub;
   private ArrayList cS = new ArrayList();
   private ArrayList vS = new ArrayList();
   private ArrayList vT = new ArrayList();
   private ArrayList vU = new ArrayList();
   private ArrayList vV = new ArrayList();
   private ArrayList wr = new ArrayList();
   private ArrayList ws = new ArrayList();
   private ArrayList wt = new ArrayList();
   private LeagueStage vW = null;
   private Competition vX = null;
   private KnockoutStage vY = null;
   private KnockoutStage wu = null;
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
   private int wv = -1;
   private int wa = -1;
   private int ww = -1;
   private Competition wb = null;
   boolean wx = false;
   boolean wy = false;
   boolean wz = false;
   boolean wA = false;
   boolean wB = false;
   int wC = -1;
   boolean wD = false;
   boolean wE = false;
   int wF = 0;
   boolean wG = false;
   int wH = 0;
   int wI = 0;
   boolean wJ = false;
   private ArrayList wK = new ArrayList();
   private JButton wL;
   private JButton wM;
   private JButton uW;
   private JButton vi;
   private JButton wN;
   private JButton wO;
   private JButton vm;
   private JButton uX;
   private JButton uY;
   private JButton uZ;
   private JComboBox va;
   private JPanel vd;
   private JPanel wP;
   private JPanel wQ;
   private JScrollPane ut;
   private JScrollPane wi;
   private JToolBar ve;
   private JLabel wm;
   private JLabel wR;
   private JLabel vf;
   private JTable wp;
   private JTable vN;
   private JComboBox wS;

   public C0065(JDialog jDialog, int i, Competition c0713) {
      this.ub = jDialog;
      this.wb = c0713;
      this.mJ();
      this.mQ();
      this.mH();
      this.nj();
      this.wG = false;
      this.wE = false;
      this.mO();
      this.mP();
      byte var4 = 0;
      if (i == 3) {
         var4 = 2;
      }

      if (i == 4 || i == 5 || i == 6 || i == 8) {
         var4 = 1;
      }

      if (i == 7 || i == 9) {
         var4 = 3;
      }

      this.cB(var4);
      this.ut.setBorder(BorderFactory.createEmptyBorder());
      this.wi.setBorder(BorderFactory.createEmptyBorder());
      this.wM.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aiconsb/leftd.png")));
      this.wO.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aiconsb/leftd.png")));
      this.wL.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aiconsb/leftda.png")));
      this.wN.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aiconsb/leftda.png")));
      this.wm.setForeground(new Color(255, 255, 255));
      this.wN.setForeground(new Color(255, 255, 255));
      this.wO.setForeground(new Color(255, 255, 255));
      this.wR.setForeground(new Color(255, 255, 255));
      this.vd.setBackground(new Color(35, 28, 14));
      this.vd.setOpaque(true);
      this.vf.setText("Classificação e jogos - " + Integer.toString(GamePersistence.careerState.getSeasonNumber() + GamePersistence.careerState.getSeasonYearOffset()));
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void mQ() {
      C0625 var1 = new C0625();
      this.va.setPreferredSize(new Dimension(10, 25));
      this.va.setRenderer(var1);
      this.va.setMaximumRowCount(24);
      this.va.addActionListener(new C0066(this));
   }

   private void mO() {
      if (!GamePersistence.careerState.isJogaEstadual()) {
         this.uW.setVisible(false);
      }

      if (!GamePersistence.careerState.isJogaRegionais()) {
         this.vi.setVisible(false);
      }

      if (!GamePersistence.careerState.isJogaSelecoesAll()) {
         this.uZ.setVisible(false);
      }

      if (!GamePersistence.careerState.isJogaIntClubes()) {
         this.uX.setVisible(false);
      }
   }

   private void mP() {
      this.uY.addActionListener(new C0070(this));
      this.uX.addActionListener(new C0071(this));
      this.uW.addActionListener(new C0072(this));
      this.uZ.addActionListener(new C0073(this));
      this.vi.addActionListener(new C0074(this));
   }

   private void cA(int i) {
      JButton[] var2 = new JButton[]{this.uY, this.uX, this.uW, this.uZ, this.vi};
      ImageIcon[] var3 = new ImageIcon[]{this.uL, this.uM, this.uN, this.uO, this.uP};
      ImageIcon[] var4 = new ImageIcon[]{this.uQ, this.uR, this.uS, this.uT, this.uU};

      for (int var5 = 0; var5 < var2.length; var5++) {
         var2[var5].setIcon(var3[var5]);
      }

      var2[i].setIcon(var4[i]);
   }

   private void cB(int i) {
      this.wG = false;
      this.wE = false;
      this.wD = false;
      this.cA(i);
      this.cS = Competition.a(i, false, 0);
      this.va.removeAllItems();
      if (i == 2) {
         Collections.sort(this.cS, C1007.abj);
      }

      for (int var2 = 0; var2 < this.cS.size(); var2++) {
         this.va.addItem(this.cS.get(var2));
      }

      this.va.setSelectedItem(this.wb);
   }

   public void mH() {
      this.vm.addActionListener(new C0075(this));
      this.wN.addActionListener(new C0076(this));
      this.wO.addActionListener(new C0077(this));
      this.wL.addActionListener(new C0067(this));
      this.wM.addActionListener(new C0068(this));
   }

   private void b(int i, boolean bl) {
      if (i == 0) {
         this.wN.setEnabled(bl);
      }

      if (i == 1) {
         this.wO.setEnabled(bl);
      }
   }

   private void c(int i, boolean bl) {
      if (i == 0) {
         this.wL.setEnabled(bl);
      }

      if (i == 1) {
         this.wM.setEnabled(bl);
      }
   }

   private void Q(boolean bl) {
      this.wQ.setVisible(bl);
      this.wi.setVisible(bl);
   }

   private void cH(int i) {
      if (this.wJ) {
         this.cL(this.wI + i);
      } else if (this.wG) {
         this.cK(this.wa + i);
      } else if (this.wa == 2 && i == -1) {
         if (this.ww > 0) {
            this.ww--;
            this.cI(this.wa);
         } else {
            this.cI(this.wa + i);
         }
      } else if (this.wa == 2 && i == 1) {
         this.b(1, true);
         if (this.wx && this.vW == null) {
            if (this.ww < 3) {
               this.ww++;
               this.cI(this.wa);
               if (this.ww == 3) {
                  this.b(1, false);
               }
            }
         } else if (this.wy && this.vY == null) {
            if (this.wz && this.ww < this.vW.yR()) {
               this.ww++;
               this.cI(this.wa);
               if (this.ww >= this.vW.yR()) {
                  this.b(1, false);
               }
            } else if (this.vX instanceof NationalCup && this.ww < ((NationalCup)this.vX).iW()) {
               this.ww++;
               this.cI(this.wa);
               if (this.ww >= ((NationalCup)this.vX).iW()) {
                  this.b(1, false);
               }
            }
         } else if (this.ww < this.vY.zq()) {
            this.ww++;
            this.cI(this.wa);
            if (this.ww >= this.vY.zq()) {
               this.b(1, false);
            }
         } else {
            this.cI(this.wa + i);
         }
      } else if (this.wa == 0 && this.vX instanceof ClubWorldCup) {
         this.cI(2);
      } else {
         this.cI(this.wa + i);
      }
   }

   private boolean a(int i, LeagueStage c0955, Competition c0713) {
      if (c0955 == null) {
         c0955 = this.vW;
      }

      if (c0713 == null) {
         c0713 = this.vX;
      }

      if (i == -1 && c0955 != null) {
         i = 0;
      } else if (c0955 == null) {
         return false;
      }

      this.wv = i;
      this.vV.clear();

      for (int var4 = 0; var4 < GamePersistence.careerState.getScheduleDays().size(); var4++) {
         for (int var5 = 0; var5 < ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var4)).t().size(); var5++) {
            if (((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var4)).t().get(var5) == c0713) {
               this.vV.add((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var4));
               break;
            }
         }
      }

      if (i >= c0955.yG()) {
         i = c0955.yG() - 1;
         this.wv = i;
      }

      if (this.wE) {
         i += 7;
      }

      this.vU.clear();
      if (this.wJ) {
         i += 4;
      } else if (this.wx) {
         i += 2;
      }

      try {
         for (int var9 = 0; var9 < ((ScheduleDay)this.vV.get(i)).h().size(); var9++) {
            if (((Match)((ScheduleDay)this.vV.get(i)).h().get(var9)).getCompetitionStage() == c0955) {
               C0828 var11 = new C0828();
               var11.ao(true);
               this.vU.add(var11);
               C0828 var6 = new C0828();
               var6.n((Match)((ScheduleDay)this.vV.get(i)).h().get(var9));
               var6.ah(true);
               this.vU.add(var6);
               C0828 var7 = new C0828();
               var7.n((Match)((ScheduleDay)this.vV.get(i)).h().get(var9));
               this.vU.add(var7);
            }
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      if (this.wJ) {
         i -= 4;
      } else if (this.wx) {
         i -= 2;
      }

      byte var10 = 0;
      String var12 = "";
      if (this.wE) {
         var10 = 7;
         var12 = " - 2º T";
      }

      this.wR.setText(i - var10 + 1 + "ª rodada" + var12);
      this.c(0, true);
      this.c(1, true);
      int var13 = c0955.yG() - 1;
      byte var14 = 0;
      if (this.wE) {
         var13 += 2;
         var14 = 7;
      }

      if (i == var14) {
         this.c(0, false);
      } else if (i == var13) {
         this.c(1, false);
      }

      this.vN.addNotify();
      return true;
   }

   private void cC(int i) {
      this.wv = -1;
      this.wa = 0;
      this.vY = null;
      this.wi.setVisible(true);
      this.Q(true);
      this.nc();
      this.nl();
      if (this.cS.size() > 0) {
         this.u((Competition)this.va.getSelectedItem());
      }
   }

   private void a(LeagueStage c0955, KnockoutStage c0962, KnockoutStage c09622, boolean bl, boolean bl2) {
      this.vY = c0962;
      this.vW = c0955;
      this.wu = c09622;
      this.wy = bl;
      this.wx = bl2;
      this.wz = true;
      if (this.vX instanceof NationalCup || this.vX instanceof EuropeanSuperCup || this.vX instanceof SouthAmericanRecopa || this.vX instanceof CopaSudamericana || this.vX instanceof ClubWorldCup) {
         this.wz = false;
      }

      if (this.vW != null) {
         this.vY = this.vW.yY();
      }

      if (this.vX instanceof ConcacafWorldCupQualifiers && GamePersistence.careerState.bQ() != null && GamePersistence.careerState.bQ().yd().yY() != null) {
         this.vY = GamePersistence.careerState.bQ().yd().yY();
      }

      if (this.vX instanceof OceaniaWorldCupQualifiers && GamePersistence.careerState.bK() != null && GamePersistence.careerState.bK().yd().yY() != null) {
         this.vY = GamePersistence.careerState.bK().yd().yY();
      }

      this.wa = 1;
      this.ww = 0;
      this.wv = 0;
      if (c0955 != null) {
         this.wv = c0955.zb() - 1;
      }

      if (bl2) {
         if (this.vW == null) {
            this.wa = 0;
         }
      } else if (c0955 == null) {
         this.wa = 2;
      }

      if (this.vX instanceof ClubWorldCup) {
         this.wG = true;
         if (this.vY == null) {
            this.wa = 0;
         } else {
            this.wa = this.vY.zp().size();
         }
      }

      if (bl) {
         if (this.vW != null && c0955.yZ()) {
            this.wa = 2;
            this.ww = this.vY.zp().size() - 1;
         } else if (this.vY != null) {
            this.ww = this.vY.zp().size() - 1;
         }

         this.nf();
      }

      if (this.wG) {
         this.cK(this.wa);
      } else if (this.wJ) {
         if (this.vW == null) {
            this.cL(0 + c09622.zb());
         } else if (this.vY == null) {
            this.cL(2);
         } else if (this.vY != null) {
            this.cL(3 + this.vY.zb());
         }
      } else {
         this.cI(this.wa);
      }
   }

   private void nf() {
      try {
         this.wr.clear();
         this.ws.clear();
         this.wt.clear();
         int[] var1 = new int[]{64, 32, 16, 8, 4, 2, 1};
         int[] var2 = new int[]{40, 20, 10, 5, 8, 4, 2, 1};
         int var3 = 0;
         String[] var4 = GameConstants.ps;
         String[] var5 = GameConstants.pu;
         if (this.vY != null && this.vY.zf() == 29) {
            var4 = GameConstants.pt;
            var5 = GameConstants.pv;
            var1 = var2;
         }

         if (this.wx) {
            var3 = 3;
         } else if (this.vY != null) {
            var3 = var4.length - 1 - this.vY.zq();
         } else if (this.wz && this.vW != null) {
            var3 = var4.length - 1 - this.vW.yR();
         } else if (this.vX instanceof NationalCup) {
            var3 = var4.length - 1 - ((NationalCup)this.vX).iW();
         }

         for (int var6 = var3; var6 < var4.length; var6++) {
            this.wr.add(var4[var6]);
            this.ws.add(var1[var6]);
            this.wt.add(var5[var6]);
         }
      } catch (Exception var7) {
      }
   }

   private void ng() {
      this.wm.setText("tabela ainda não sorteada");
      this.b(0, false);
      this.b(1, false);
      this.c(0, false);
      this.c(1, false);
      this.vT.clear();
      this.vS.clear();
      this.vU.clear();
      this.wp.addNotify();
      this.vN.addNotify();
   }

   private void cI(int i) {
      try {
         this.b(0, true);
         this.b(1, true);
         if (i == 0) {
            if (this.wu != null) {
               this.wa = 0;
               this.ww = 0;
               this.a(this.wu, null);
            } else {
               this.nh();
            }

            this.b(0, false);
         } else if (i == 1) {
            if (this.vW != null && this.vW.yK().size() > 0) {
               this.wa = 1;
               this.a(this.wv, null, null);
               this.i(this.vW);
               this.nc();
            } else if (!this.wx && this.vW.yK().size() == 0) {
               this.wm.setText("tabela ainda não sorteada");
               this.b(0, false);
               this.b(1, false);
               this.c(0, false);
               this.c(1, false);
               this.vT.clear();
               this.vS.clear();
               this.vU.clear();
               this.wp.addNotify();
               this.vN.addNotify();
            } else if (this.wz) {
               this.wa = 1;
               this.cJ(-1);
            }

            if (!this.wx) {
               this.b(0, false);
            }

            if (!this.wy) {
               this.b(1, false);
            }
         } else if (i == 2) {
            if (this.vY != null) {
               this.wa = 2;
               this.a(this.vY, null);
            } else if (this.wy) {
               this.wa = 2;
               this.nh();
            }

            if (this.ww == 0 && !this.wz) {
               this.b(0, false);
            }
         }
      } catch (Exception var3) {
      }
   }

   private void cJ(int i) {
      this.wi.setVisible(true);
      this.Q(true);
      this.wm.setText("1ª fase");
      this.wR.setText("");
      if (!this.wx && !this.wy) {
         this.wm.setText("Fase única");
      }

      if (this.wB && this.wH == 1) {
         this.wm.setText("2ª fase");
         this.c(0, false);
         this.c(1, false);
      }

      ArrayList var2 = null;
      ArrayList var3 = null;
      byte var4 = 8;
      byte var5 = 4;
      if (i == 318) {
         var4 = 2;
         var5 = 8;
         String[] var6 = new String[]{
            "1º do grupo A",
            "2º do grupo A",
            "3º do grupo A",
            "4º do grupo A",
            "1º do grupo B",
            "2º do grupo B",
            "3º do grupo B",
            "4º do grupo B",
            "5º do grupo A",
            "6º do grupo A",
            "7º do grupo A",
            "8º do grupo A",
            "5º do grupo B",
            "6º do grupo B",
            "7º do grupo B",
            "8º do grupo B"
         };
         String[] var7 = new String[]{"C", "D"};
         var2 = new ArrayList();

         for (int var8 = 0; var8 < var6.length; var8++) {
            var2.add(var6[var8]);
         }

         var3 = new ArrayList();

         for (int var9 = 0; var9 < var7.length; var9++) {
            var3.add(var7[var9]);
         }
      }

      this.vS.clear();
      this.vS = C0810.a(var4, var5, var2, var3);
      this.vU.clear();
      this.vN.addNotify();
      this.nc();
   }

   private void nh() {
      this.ni();
      int var1 = 0;
      if (this.ww < this.ws.size()) {
         var1 = (Integer)this.ws.get(this.ww);
      }

      if (this.wB) {
         int[] var2 = new int[]{0, 0, 2, 1};
         var1 = var2[this.wH];
      }

      if (this.wJ && this.vX instanceof UefaChampionsLeague && this.wa == 0 && this.ww == 1) {
         var1 = 10;
      }

      boolean var12 = true;
      Object var3 = null;
      boolean[] var4 = new boolean[]{true, true, true, false, false, false, false};
      String var5 = "";
      String var6 = "";
      if (this.wB) {
         if (this.wH == 2) {
            var12 = false;
         } else {
            var12 = true;
         }
      } else if (this.vX instanceof UefaChampionsLeague || this.vX instanceof CopaLibertadores) {
         var12 = var4[this.ww];
      } else if (this.vY != null) {
         var3 = this.vY.zz();
         var12 = (boolean)((Object[])var3)[this.ww];
      } else if (this.vW != null) {
         var3 = this.vW.getDuasVoltasMataMata();
         var12 = (boolean)((Object[])var3)[this.ww];
      }

      if (this.wB) {
         if (this.wH == 2) {
            var5 = "Semi-Final";
         } else {
            var6 = "Semi-Final";
            var5 = "Decisão";
         }
      } else if (this.wJ && this.wI < 2) {
         var5 = "J";
      } else {
         if (this.ww < this.wt.size()) {
            var5 = (String)this.wt.get(this.ww);
         }

         if (this.ww > 0 && this.ww - 1 < this.wt.size()) {
            var6 = (String)this.wt.get(this.ww - 1);
         }
      }

      ArrayList var7 = null;
      if (this.ww == 0) {
         if (this.vX instanceof UefaChampionsLeague || this.vX instanceof UefaEuropaLeague) {
            var6 = "sorteio";
         } else if (this.vX instanceof CopaLibertadores || this.vX instanceof AfcChampionsLeague || this.vX instanceof CafChampionsLeague) {
            var7 = CopaLibertadores.yc();
         } else if (this.vX instanceof ConcacafChampionsLeague) {
            var7 = ConcacafChampionsLeague.yc();
         } else if (this.vX instanceof OfcChampionsLeague) {
            var7 = OfcChampionsLeague.yc();
         } else if (this.vX instanceof CopaAmerica) {
            var7 = CopaAmerica.yc();
         } else if (this.vX instanceof AfricaCupOfNations) {
            var7 = AfricaCupOfNations.yc();
         } else if (this.vX instanceof AsianCup) {
            var7 = AsianCup.yc();
         } else if (this.vX instanceof ConcacafGoldCup) {
            var7 = ConcacafGoldCup.yc();
         } else if (this.vX instanceof OfcNationsCup) {
            var7 = OfcNationsCup.yc();
         } else if (this.vX instanceof RegionalCup) {
            var7 = RegionalCup.yc();
         } else if (this.vX instanceof EuropeWorldCupQualifiers) {
            var7 = EuropeWorldCupQualifiers.yc();
         } else if (this.vX instanceof SouthAmericaWorldCupQualifiers) {
            var7 = SouthAmericaWorldCupQualifiers.yc();
         } else if (this.vX instanceof AfricaWorldCupQualifiers) {
            var7 = AfricaWorldCupQualifiers.yc();
         } else if (this.vX instanceof AsiaWorldCupQualifiers) {
            var7 = AsiaWorldCupQualifiers.yc();
         } else if (this.vX instanceof OceaniaWorldCupQualifiers) {
            var7 = OceaniaWorldCupQualifiers.yc();
         } else if (this.vX.b() != 1) {
            this.vX.b();
         }
      }

      boolean var8 = false;
      if (this.vX instanceof EuropeWorldCupQualifiers) {
         var1 = 4;
      } else if (this.vX instanceof SouthAmericaWorldCupQualifiers) {
         var1 = 1;
      } else if (this.vX instanceof AsiaWorldCupQualifiers) {
         var1 = 1;
      } else if (this.vX instanceof OceaniaWorldCupQualifiers) {
         var1 = 1;
      } else if (this.vX instanceof ConcacafWorldCupQualifiers) {
         var1 = 1;
      }

      if (this.wG) {
         int[] var9 = new int[]{2, 2, 2};
         var1 = var9[this.wa];
         if (this.wa == 1) {
            var5 = "Semi-Final";
         } else if (this.wa == 2) {
            var6 = "Semi-Final";
            var5 = "Decisão";
         }

         if (this.wa == 1) {
            var7 = ClubWorldCup.eX(1);
         } else if (this.wa == 2) {
            var7 = ClubWorldCup.eX(2);
            var8 = true;
         }

         var12 = false;
      }

      this.vT.clear();
      this.vT = C0809.a(var1, var12, var5, var6, var7, var8);
      if (this.wB) {
         if (this.wH == 2) {
            var5 = "Semi-Final TR";
         } else if (this.wC == 18) {
            var6 = "Semi-Final TR";
            var5 = "Decisão Taça Rio";
         } else {
            var6 = "Semi-Final TC";
            var5 = "Decisão Taça Cidade";
         }

         String var17 = "Taca Cidade";
         if (this.wC == 18) {
            var17 = "Taça Rio";
         }

         var7 = StateChampionship.eX(319);
         C0809 var10 = new C0809();
         var10.ai(true);
         var10.aj(true);
         this.vT.add(var10);
         C0809 var11 = new C0809();
         var11.ai(true);
         var11.aj(true);
         var11.D("<html><b>" + var17 + "</b></html>");
         this.vT.add(var11);
         this.vT.addAll(C0809.a(var1, var12, var5, var6, var7, var8));
      }

      if (this.vX != null && this.vX.b() == 2 && this.vX instanceof NationalCup) {
         CountryCompetitions var18 = ((NationalCup)this.vX).yg();
         if (var18.jc() == 29 && GamePersistence.getOptions().isNovoFormatoCopa() && (var18.jq() == null || var18.jq().yf() == null)) {
            this.vT.clear();
            C0809 var19 = new C0809();
            var19.ai(true);
            var19.aj(true);
            var19.D("<html><b>Ainda não sorteada</b></html>");
            this.vT.add(var19);
         }
      }

      this.wi.setVisible(false);
      this.Q(false);
      this.nk();
   }

   private void ni() {
      if (this.vX instanceof EuropeWorldCupQualifiers || this.vX instanceof SouthAmericaWorldCupQualifiers || this.vX instanceof AsiaWorldCupQualifiers || this.vX instanceof OceaniaWorldCupQualifiers || this.vX instanceof ConcacafWorldCupQualifiers) {
         this.wm.setText("Repescagem");
      } else if (this.wB) {
         if (this.wH == 2) {
            this.wm.setText("Semi-Final");
         } else if (this.wH == 3) {
            this.wm.setText("Final");
         }
      } else if (this.wG) {
         if (this.wa == 0) {
            this.wm.setText("Quartas");
         } else if (this.wa == 1) {
            this.wm.setText("Semi-final");
         } else if (this.wa == 2) {
            this.wm.setText("Final");
         }
      } else if (this.wa == 0) {
         this.wm.setText("Fase Preliminar");
         if (this.wI == 0) {
            this.wm.setText("Fase Preliminar R1");
         } else if (this.wI == 1) {
            this.wm.setText("Fase Preliminar R2");
         }
      } else if (this.ww < this.wr.size()) {
         this.wm.setText((String)this.wr.get(this.ww));
      }

      if (this.wE) {
         this.wm.setText(this.wm.getText() + " - 2º turno");
         if (this.vY != null) {
            int var1 = this.vY.zq();
            if (var1 == 0) {
               this.wm.setText("Final do campeonato");
            }
         }
      }
   }

   private void a(KnockoutStage c0962, KnockoutStage c09622) {
      this.wi.setVisible(false);
      this.Q(false);
      if (this.wB) {
         if (this.wH == 2) {
            this.ww = 0;
         } else if (this.wH >= 3) {
            if (this.wH > 3) {
               this.wH = 3;
            }

            this.ww = 1;
         }
      }

      this.vT.clear();
      this.ni();
      String var3 = "";
      if (this.ww < this.wt.size()) {
         var3 = (String)this.wt.get(this.ww);
      }

      if (this.ww >= c0962.zp().size() && this.ww <= c0962.zq()) {
         this.nh();
      }

      if (this.wa == 0) {
         var3 = "";
      }

      if (this.wB) {
         if (this.ww == 0) {
            var3 = "Semi-Final";
         } else if (this.ww == 1) {
            var3 = "Decisão";
         }
      }

      boolean var4 = false;
      if (this.wG) {
         if (this.wa == 0) {
            this.ww = 0;
            var3 = "Quartas";
         } else if (this.wa == 1) {
            this.ww = 0;
            var3 = "Semi-Final";
         } else if (this.wa == 2) {
            this.ww = 1;
            var3 = "Decisão";
            var4 = true;
         }
      }

      if (this.vX.b() == 7 && this.ww >= c0962.zq()) {
         var4 = true;
      }

      for (int var5 = 0; var5 < 2; var5++) {
         KnockoutStage var6 = c0962;
         if (var5 == 1) {
            var6 = c09622;
         }

         if (var6 != null && this.ww < var6.zp().size()) {
            for (int var7 = 0; var7 < ((KnockoutRound)var6.zp().get(this.ww)).zW().size(); var7++) {
               C0809 var8 = new C0809();
               var8.ai(true);
               this.vT.add(var8);
               C0809 var9 = new C0809();
               var9.l((Match)((KnockoutRound)var6.zp().get(this.ww)).zW().get(var7));
               var9.ah(true);
               var9.E(var3 + Integer.toString(var7 + 1));
               if (var4 && var7 == 0) {
                  var9.E("Decisão");
               } else if (var4 && var7 == 1) {
                  var9.E("Decisão 3º lugar");
               }

               if (((KnockoutRound)var6.zp().get(this.ww)).zW().size() == 1) {
                  var9.E(var3);
               }

               if (this.wB && this.wH == 3) {
                  String var10 = "Taca Cidade";
                  if (this.wC == 18) {
                     var10 = "Taça Rio";
                  }

                  if (var7 == 0 && var5 == 1) {
                     var9.E("Decisão " + var10);
                  }
               }

               if (this.wB && this.wH == 2 && var5 == 1) {
                  var9.E("Semi-Final TR" + Integer.toString(var7 + 1));
               }

               this.vT.add(var9);
               C0809 var11 = new C0809();
               var11.l((Match)((KnockoutRound)var6.zp().get(this.ww)).zW().get(var7));
               this.vT.add(var11);
               if (((KnockoutRound)var6.zp().get(this.ww)).hO()) {
                  var9.m((Match)((KnockoutRound)var6.zp().get(this.ww)).zX().get(var7));
                  var11.m((Match)((KnockoutRound)var6.zp().get(this.ww)).zX().get(var7));
               }
            }
         }
      }

      this.nk();
   }

   private void i(LeagueStage c0955) {
      this.wi.setVisible(true);
      this.Q(true);
      this.wm.setText("1ª fase");
      if (this.wE) {
         this.wm.setText("1ª fase - 2º turno");
         if (this.vW.yQ().size() == 0) {
            this.wm.setText("Soma dos dois turnos");
         }
      }

      if (!this.wx && !this.wy) {
         this.wm.setText("Fase única");
      }

      if (this.wB && this.wH == 1) {
         this.wm.setText("2ª fase");
      }

      this.vS.clear();
      if (c0955.yQ().size() == 0) {
         this.a(c0955, "", true, 0);
      } else {
         String[] var2 = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"};
         byte var3 = 0;
         if (this.wB && this.wH == 1) {
            var3 = 2;
         }

         for (int var4 = 0; var4 < c0955.yQ().size(); var4++) {
            String var5 = Integer.toString(var4 + 1);
            if (this.wA) {
               var5 = var2[var4];
            }

            this.a(c0955, var5, false, var4);
         }
      }

      this.j(c0955);
      if (this.wB && this.wH == 1) {
         this.k(c0955);
      } else if (!this.wB) {
         this.k(c0955);
      }

      if (this.wE && this.vW != null) {
         this.vS.add(new C0810(true, "Campeão do 1º turno:"));
         this.vS.add(new C0810(this.vW.tf()));
      }

      this.wp.addNotify();
   }

   private void j(LeagueStage c0955) {
      this.wK.clear();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      int var5 = c0955.yX();
      if (this.vX instanceof EuropeWorldCupQualifiers || this.vX instanceof AfricaWorldCupQualifiers) {
         var5 = 1;
      } else if (this.vX instanceof SouthAmericaWorldCupQualifiers || this.vX instanceof AsiaWorldCupQualifiers) {
         var5 = 4;
      } else if (this.vX instanceof ConcacafWorldCupQualifiers) {
         var5 = 3;
      }

      if (this.wD) {
         var5 = 2;
      }

      boolean var6 = false;
      if (this.wE && this.vW.yQ().size() == 0) {
         var6 = true;
      }

      if (c0955.ze() == 14 && !var6 && c0955.tf() != null) {
         var4.add(c0955.tf());
      }

      if (c0955.ze() == 8) {
         if (c0955.tf() != null) {
            this.wK.add(c0955.tf());
         }

         if (!this.wK.contains(c0955.yK().get(0))) {
            this.wK.add((Club)c0955.yK().get(0));
         }

         if (c0955.zb() < 10) {
            this.wm.setText("1ª fase - 1º turno");
         } else {
            this.wm.setText("1ª fase - 2º turno");
         }
      }

      if (var5 == 0) {
         if (c0955.getDivisao() > 1) {
            byte var7 = 0;

            for (int var8 = 0; var8 < var7; var8++) {
               this.wK.add((Club)c0955.yK().get(var8));
            }
         }
      } else {
         int var10 = var5;
         if (c0955.yQ().size() != 0 && !c0955.zl()) {
            if (!this.wB) {
               for (int var26 = 0; var26 < c0955.yQ().size(); var26++) {
                  for (int var9 = 0; var9 < var10; var9++) {
                     this.wK.add((Club)((C0673)c0955.yQ().get(var26)).gR().get(var9));
                  }
               }

               if (c0955.yQ().size() == 12 && c0955.melhoresTerceiros) {
                  ArrayList var28 = new ArrayList();

                  for (int var42 = 0; var42 < c0955.yQ().size(); var42++) {
                     var28.add((Club)((C0673)c0955.yQ().get(var42)).gR().get(2));
                  }

                  LeagueStage.r(this.vW);
                  Collections.sort(var28, C1007.abn);

                  for (int var43 = 0; var43 < 8; var43++) {
                     this.wK.add((Club)var28.get(var43));
                  }
               } else if (c0955.yQ().size() == 17 && c0955.melhoresTerceiros) {
                  ArrayList var27 = new ArrayList();

                  for (int var40 = 0; var40 < c0955.yQ().size(); var40++) {
                     var27.add((Club)((C0673)c0955.yQ().get(var40)).gR().get(1));
                  }

                  LeagueStage.r(this.vW);
                  Collections.sort(var27, C1007.abn);

                  for (int var41 = 0; var41 < 15; var41++) {
                     this.wK.add((Club)var27.get(var41));
                  }
               }
            }

            if (this.wB && this.wH == 0) {
               for (int var30 = 0; var30 < c0955.yQ().size(); var30++) {
                  for (int var44 = 0; var44 < var10; var44++) {
                     this.wK.add((Club)((C0673)c0955.yQ().get(var30)).gR().get(var44));
                  }
               }

               for (int var31 = 0; var31 < c0955.yQ().size(); var31++) {
                  for (int var45 = 4; var45 < 8; var45++) {
                     var2.add((Club)((C0673)c0955.yQ().get(var31)).gR().get(var45));
                  }
               }
            } else if (this.wB && this.wH == 1) {
               for (int var29 = 0; var29 < var10; var29++) {
                  this.wK.add((Club)((C0673)c0955.yQ().get(0)).gR().get(var29));
               }

               var2.add((Club)((C0673)c0955.yQ().get(0)).gR().get(4));
               var2.add((Club)((C0673)c0955.yQ().get(0)).gR().get(5));
               var2.add((Club)((C0673)c0955.yQ().get(1)).gR().get(0));
               var2.add((Club)((C0673)c0955.yQ().get(1)).gR().get(1));
            }
         } else {
            for (int var25 = 0; var25 < var10; var25++) {
               this.wK.add((Club)c0955.yK().get(var25));
            }
         }
      }

      if (c0955.ze() == 14 && var6) {
         this.wK.clear();
         Club var11 = c0955.cS();
         if (this.vW != null) {
            this.vS.add(new C0810(true, "Campeão das finais:"));
            this.vS.add(new C0810(var11));
         }
      }

      if (c0955.b() == 1 && GamePersistence.careerState.isJogaIntClubes()) {
         if (c0955.vl().gg() == 1) {
            Club var12 = GamePersistence.careerState.aF().cS();
            if (var12 != null) {
               var4.add(var12);
            }

            Club var32 = GamePersistence.careerState.aH().cS();
            if (var32 != null) {
               var4.add(var32);
            }
         } else if (c0955.vl().gg() == 0) {
            Club var13 = GamePersistence.careerState.aI().cS();
            if (var13 != null) {
               var4.add(var13);
            }

            Club var33 = GamePersistence.careerState.aK().cS();
            if (var33 != null) {
               var4.add(var33);
            }
         } else if (c0955.vl().gg() == 2) {
            Club var14 = GamePersistence.careerState.aO().cS();
            if (var14 != null) {
               var4.add(var14);
            }

            Club var34 = c0955.vl().jq().cS();
            if (var34 != null) {
               var4.add(var34);
            }
         } else if (c0955.vl().gg() == 3) {
            Club var15 = GamePersistence.careerState.aL().cS();
            if (var15 != null) {
               var4.add(var15);
            }
         } else if (c0955.vl().gg() == 5) {
            Club var16 = GamePersistence.careerState.aQ().cS();
            if (var16 != null) {
               var4.add(var16);
            }
         } else if (c0955.vl().gg() == 4) {
            Club var17 = GamePersistence.careerState.aP().cS();
            if (var17 != null) {
               var4.add(var17);
            }
         }

         if (c0955.vl().gg() != 0) {
            Club var18 = c0955.vl().jq().cS();
            if (var18 != null) {
               var4.add(var18);
            }
         }
      }

      if (c0955.getDivisao() == 1 && c0955.b() == 1 && GamePersistence.careerState.isJogaIntClubes()) {
         int[] var19 = new int[3];

         for (int var35 = 0; var35 < c0955.yK().size(); var35++) {
            if (var19[0] > 0 && !var4.contains(c0955.yK().get(var35))) {
               var4.add((Club)c0955.yK().get(var35));
               var19[0]--;
            }
         }

         if (c0955.vl().gg() == 1 || c0955.vl().gg() == 0) {
            for (int var36 = 0; var36 < c0955.yK().size(); var36++) {
               if (var19[2] > 0 && !var4.contains(c0955.yK().get(var36))) {
                  var3.add((Club)c0955.yK().get(var36));
                  var19[2]--;
               }
            }
         }

         if (var19[1] > 0) {
            for (int var37 = 0; var37 < c0955.yK().size(); var37++) {
               if (var19[1] > 0 && !var2.contains(c0955.yK().get(var37)) && !var4.contains(c0955.yK().get(var37)) && !var3.contains(c0955.yK().get(var37))) {
                  var2.add((Club)c0955.yK().get(var37));
                  var19[1]--;
               }
            }
         }
      }

      if (this.vX instanceof EuropeWorldCupQualifiers) {
         ArrayList var20 = new ArrayList();

         for (int var38 = 0; var38 < c0955.yQ().size(); var38++) {
            var20.add((Club)((C0673)c0955.yQ().get(var38)).gR().get(1));
         }

         LeagueStage.r(this.vW);
         Collections.sort(var20, C1007.abn);

         for (int var39 = 0; var39 < 8; var39++) {
            var2.add((Club)var20.get(var39));
         }
      } else if (this.vX instanceof SouthAmericaWorldCupQualifiers) {
         var2.add((Club)c0955.yK().get(4));
      } else if (this.vX instanceof AsiaWorldCupQualifiers) {
         var2.add((Club)c0955.yK().get(4));
      } else if (this.vX instanceof ConcacafWorldCupQualifiers) {
         var2.add((Club)c0955.yK().get(3));
      } else if (this.vX instanceof OceaniaWorldCupQualifiers) {
         var2.add((Club)c0955.yK().get(0));
      }

      for (int var21 = 0; var21 < this.vS.size(); var21++) {
         if (this.wK.contains(((C0810)this.vS.get(var21)).getClub())) {
            ((C0810)this.vS.get(var21)).dF(1);
         }
      }

      if (var2.size() > 0) {
         for (int var22 = 0; var22 < this.vS.size(); var22++) {
            if (var2.contains(((C0810)this.vS.get(var22)).getClub())) {
               ((C0810)this.vS.get(var22)).dF(2);
            }
         }
      }

      if (var4.size() > 0) {
         for (int var23 = 0; var23 < this.vS.size(); var23++) {
            if (var4.contains(((C0810)this.vS.get(var23)).getClub())) {
               ((C0810)this.vS.get(var23)).dF(4);
            }
         }
      }

      if (var3.size() > 0) {
         for (int var24 = 0; var24 < this.vS.size(); var24++) {
            if (var3.contains(((C0810)this.vS.get(var24)).getClub())) {
               ((C0810)this.vS.get(var24)).dF(5);
            }
         }
      }
   }

   private boolean k(LeagueStage c0955) {
      if (c0955.b() == 1 || c0955.b() == 3) {
         if (c0955.b() == 1 && c0955.iq().jc() == 29 && GamePersistence.careerState.bk() && c0955.getDivisao() == 4) {
            return false;
         }

         int var2 = c0955.getnRebaixados();
         boolean var3 = c0955.zc();
         if (c0955.zc() && c0955.yQ().size() > 0) {
            var2 = Math.round(var2 / c0955.yQ().size());
         }

         boolean var4 = false;
         if (this.wE) {
            var3 = false;
            if (this.vW.yQ().size() == 0) {
               var3 = false;
               var4 = true;
            }
         }

         if (this.wB) {
            var2 = 2;
            var3 = true;
         }

         if (c0955.zg() && c0955.zh() < var2) {
            var2 = c0955.zh();
         }

         if (var2 > 0) {
            ArrayList var5 = new ArrayList();
            if (!var3) {
               int var9 = var2;

               for (int var11 = c0955.yK().size() - 1; var11 >= 0; var11--) {
                  if (var9 > 0 && !this.wK.contains(c0955.yK().get(var11))) {
                     var5.add((Club)c0955.yK().get(var11));
                     var9--;
                  }
               }
            } else {
               byte var6 = 0;
               if (this.wB) {
                  var6 = 1;
               }

               for (int var7 = var6; var7 < c0955.yQ().size(); var7++) {
                  for (int var8 = ((C0673)c0955.yQ().get(var7)).gR().size() - 1; var8 >= ((C0673)c0955.yQ().get(var7)).gR().size() - var2; var8--) {
                     var5.add((Club)((C0673)c0955.yQ().get(var7)).gR().get(var8));
                  }
               }
            }

            if (this.wD && this.wF != 4) {
               var5.clear();
            }

            if (c0955.ze() == 14 && !var4) {
               var5.clear();
            }

            for (int var10 = 0; var10 < this.vS.size(); var10++) {
               if (var5.contains(((C0810)this.vS.get(var10)).getClub())) {
                  ((C0810)this.vS.get(var10)).dF(3);
               }
            }
         }
      }

      return true;
   }

   private void a(LeagueStage c0955, String string, boolean bl, int i) {
      int[] var5 = new int[8];
      int[] var6 = new int[8];
      String var7 = "";
      if (!bl) {
         C0810 var8 = new C0810();
         var8.setInfo("Grupo " + string);
         var8.ak(true);
         this.vS.add(var8);
      }

      C0810 var14 = new C0810();
      var14.setInfo("topo");
      this.vS.add(var14);
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
            var7 = "1º";
         } else if (var10 > 0) {
            var6 = ((Club)var9.get(var10 - 1)).d(c0955);
            if (var5[0] == var6[0] && var5[2] == var6[2] && var5[5] == var6[5] && var5[7] == var6[7]) {
               var7 = "";
            } else {
               var7 = Integer.toString(var10 + 1) + "º";
            }
         }

         var11.J(var7);
         this.vS.add(var11);
      }

      if (!bl) {
         C0810 var15 = new C0810();
         var15.setInfo("");
         var15.ak(true);
         this.vS.add(var15);
      }
   }

   private void nj() {
      this.wS.addActionListener(new C0069(this));
   }

   private void u(Competition c0713) {
      this.vX = c0713;
      this.wA = false;
      this.wB = false;
      this.wD = false;
      this.wG = false;
      this.wJ = false;
      this.wS.setVisible(false);
      this.wS.removeAllItems();
      if (this.vX instanceof CafChampionsLeague) {
         this.wA = true;
         this.a(GamePersistence.careerState.aO().yd(), null, null, true, false);
      } else if (this.vX instanceof AfcChampionsLeague) {
         this.wA = true;
         this.a(GamePersistence.careerState.aL().yd(), null, null, true, false);
      } else if (this.vX instanceof UefaChampionsLeague) {
         this.wA = true;
         this.wJ = true;
         this.a(GamePersistence.careerState.aI().yd(), null, GamePersistence.careerState.aI().yC(), true, true);
      } else if (this.vX instanceof CopaLibertadores) {
         this.wA = true;
         this.wJ = true;
         this.a(GamePersistence.careerState.aF().yd(), null, GamePersistence.careerState.aF().yC(), true, true);
      } else if (this.vX instanceof ConcacafChampionsLeague) {
         this.wA = true;
         this.a(GamePersistence.careerState.aP().yd(), null, null, true, false);
      } else if (this.vX instanceof OfcChampionsLeague) {
         this.wA = true;
         this.a(GamePersistence.careerState.aQ().yd(), null, null, true, false);
      } else if (this.vX instanceof UefaEuropaLeague) {
         this.wA = true;
         this.a(GamePersistence.careerState.aK().yd(), null, null, true, false);
      } else if (this.vX instanceof ClubWorldCup) {
         this.a(null, GamePersistence.careerState.aR().zE(), GamePersistence.careerState.aR().zD(), true, true);
      } else if (this.vX instanceof WorldCup) {
         this.wA = true;
         this.a(GamePersistence.careerState.aY().yd(), null, null, true, false);
      } else if (this.vX instanceof EuropeanChampionship) {
         this.wA = true;
         this.a(GamePersistence.careerState.ba().yd(), null, null, true, false);
      } else if (this.vX instanceof CopaAmerica) {
         this.wA = true;
         this.a(GamePersistence.careerState.aZ().yd(), null, null, true, false);
      } else if (this.vX instanceof AfricaCupOfNations) {
         this.wA = true;
         this.a(GamePersistence.careerState.be().yd(), null, null, true, false);
      } else if (this.vX instanceof AsianCup) {
         this.wA = true;
         this.a(GamePersistence.careerState.bf().yd(), null, null, true, false);
      } else if (this.vX instanceof ConcacafGoldCup) {
         this.wA = true;
         this.a(GamePersistence.careerState.bg().yd(), null, null, true, false);
      } else if (this.vX instanceof OfcNationsCup) {
         this.wA = true;
         this.a(GamePersistence.careerState.bX().yd(), null, null, true, false);
      } else if (this.vX instanceof RegionalCup) {
         this.a(((RegionalCup)this.vX).yd(), null, null, true, false);
      } else if (this.vX instanceof OceaniaWorldCupQualifiers) {
         this.wA = true;
         this.a(GamePersistence.careerState.bS().yd(), null, null, true, false);
      } else if (this.vX instanceof SouthAmericaWorldCupQualifiers) {
         this.wA = true;
         this.a(GamePersistence.careerState.bK().yd(), null, null, true, false);
      } else if (this.vX instanceof AfricaWorldCupQualifiers) {
         this.wA = true;
         this.a(GamePersistence.careerState.bM().yd(), null, null, false, false);
      } else if (this.vX instanceof AsiaWorldCupQualifiers) {
         this.wA = true;
         this.a(GamePersistence.careerState.bQ().yd(), null, null, true, false);
      } else if (this.vX instanceof NationalCup) {
         this.a(null, ((NationalCup)this.vX).yf(), null, true, false);
      } else if (this.vX instanceof EuropeanSuperCup) {
         this.a(null, GamePersistence.careerState.aW().zS(), null, true, false);
      } else if (this.vX instanceof SouthAmericanRecopa) {
         this.a(null, GamePersistence.careerState.aV().zS(), null, true, false);
      } else if (this.vX instanceof NationalLeague || this.vX instanceof StateChampionship) {
         LeagueStage var2 = null;
         if (this.vX instanceof NationalLeague) {
            var2 = ((NationalLeague)this.vX).yi();
         } else if (this.vX instanceof StateChampionship) {
            var2 = ((StateChampionship)this.vX).yi();
         }

         boolean var3 = false;
         if (var2.yX() > 0) {
            var3 = true;
         }

         this.a(var2, null, null, var3, false);
      }
   }

   private void cK(int i) {
      this.wa = i;
      if (i == 0) {
         if (this.wu != null) {
            this.a(this.wu, null);
         } else {
            this.nh();
         }

         this.b(0, false);
         this.b(1, true);
      } else if (i == 1) {
         if (this.vY != null) {
            this.wa = 1;
            this.a(this.vY, null);
         } else {
            this.nh();
         }

         this.b(0, true);
         this.b(1, true);
      } else if (i == 2) {
         if (this.vY != null && this.vY.zp().size() == 2) {
            this.a(this.vY, null);
         } else {
            this.nh();
         }

         this.b(0, true);
         this.b(1, false);
      }
   }

   private void cL(int i) {
      this.b(0, true);
      this.b(1, true);
      if (i >= 0) {
         this.wI = i;
         if (i == 0) {
            this.wa = 0;
            this.ww = 0;
            this.a(this.wu, null);
         } else if (i == 1) {
            this.wa = 0;
            this.ww = 1;
            this.a(this.wu, null);
         } else if (i == 2) {
            this.cI(1);
         } else if (i == 3) {
            this.ww = 0;
            this.cI(2);
         } else if (i > 3) {
            this.ww = i - 3;
            this.cI(2);
         }

         if (i == 6) {
            this.b(1, false);
         }
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

   private void nk() {
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

   private void nl() {
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

   private void mJ() {
      this.vf = new JLabel();
      this.vd = new JPanel();
      this.va = new JComboBox();
      this.ve = new JToolBar();
      this.uY = new JButton();
      this.uX = new JButton();
      this.uW = new JButton();
      this.uZ = new JButton();
      this.vi = new JButton();
      this.wP = new JPanel();
      this.wN = new JButton();
      this.wm = new JLabel();
      this.wO = new JButton();
      this.wQ = new JPanel();
      this.wL = new JButton();
      this.wR = new JLabel();
      this.wM = new JButton();
      this.vm = new JButton();
      this.ut = new JScrollPane();
      this.wp = new JTable();
      this.wi = new JScrollPane();
      this.vN = new JTable();
      this.wS = new JComboBox();
      this.wS.setVisible(false);
      this.setBackground(new Color(176, 161, 142));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setFont(new Font("Tahoma", 1, 12));
      this.vf.setText("");
      this.setBackground(new Color(104, 120, 100));
      this.vd.setPreferredSize(new Dimension(483, 40));
      this.vd.setLayout(new C0807());
      this.vd.add(this.va, new C0775(420, 10, 290, 25));
      this.ve.setBackground(new Color(38, 34, 22));
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
      this.vi.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4.png")));
      this.vi.setBorderPainted(false);
      this.vi.setContentAreaFilled(false);
      this.vi.setFocusable(false);
      this.vi.setHorizontalTextPosition(0);
      this.vi.setMargin(new Insets(0, 0, 0, 0));
      this.vi.setMaximumSize(new Dimension(79, 45));
      this.vi.setMinimumSize(new Dimension(79, 45));
      this.vi.setPreferredSize(new Dimension(79, 45));
      this.vi.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png")));
      this.vi.setVerticalTextPosition(3);
      this.ve.add(this.vi);
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
      this.vd.add(this.ve, new C0775(0, 0, 410, 40));
      this.wP.setOpaque(false);
      this.wP.setLayout(new C0807());
      this.wN.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/lefta.png")));
      this.wN.setText("Fase anterior");
      this.wN.setBorderPainted(false);
      this.wN.setContentAreaFilled(false);
      this.wP.add(this.wN, new C0775(0, 0, 139, -1));
      this.wm.setFont(new Font("Tahoma", 1, 12));
      this.wm.setHorizontalAlignment(0);
      this.wm.setText("Oitavas de final");
      this.wP.add(this.wm, new C0775(167, 7, 200, -1));
      this.wO.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/leftar.png")));
      this.wO.setText("Próxima fase");
      this.wO.setBorderPainted(false);
      this.wO.setContentAreaFilled(false);
      this.wO.setHorizontalTextPosition(2);
      this.wP.add(this.wO, new C0775(385, 0, 132, -1));
      this.wQ.setOpaque(false);
      this.wL.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/lefta.png")));
      this.wL.setBorderPainted(false);
      this.wL.setContentAreaFilled(false);
      this.wR.setFont(new Font("Tahoma", 1, 12));
      this.wR.setHorizontalAlignment(0);
      this.wR.setText("ª rodada");
      this.wM.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/leftar.png")));
      this.wM.setBorderPainted(false);
      this.wM.setContentAreaFilled(false);
      this.wM.setDisabledIcon(new ImageIcon(this.getClass().getResource("/aiconsb/leftd.png")));
      GroupLayout var1 = new GroupLayout(this.wQ);
      this.wQ.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(69, 69, 69)
                  .addComponent(this.wL)
                  .addGap(17, 17, 17)
                  .addComponent(this.wR, -2, 105, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.wM, -2, 37, -2)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addComponent(this.wL)
            .addGroup(var1.createSequentialGroup().addGap(11, 11, 11).addComponent(this.wR))
            .addComponent(this.wM)
      );
      this.vm.setText("X");
      this.ut.setViewportView(this.wp);
      this.wi.setViewportView(this.vN);
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.wP, -2, 517, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, 31, 32767)
                              .addComponent(this.wQ, -2, -1, -2)
                        )
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup()
                              .addComponent(this.vf, -2, 293, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 60, -2)
                              .addGap(22, 22, 22)
                        )
                        .addGroup(var2.createSequentialGroup().addComponent(this.vd, -1, -1, 32767).addGap(1, 1, 1))
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.ut)
                                    .addGroup(var2.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.wS, -2, 249, -2))
                              )
                              .addGap(14, 14, 14)
                              .addComponent(this.wi, -2, 310, -2)
                        )
                  )
                  .addContainerGap()
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var2.createParallelGroup(Alignment.LEADING).addComponent(this.vf).addComponent(this.vm))
                  .addGap(8, 8, 8)
                  .addComponent(this.vd, -2, -1, -2)
                  .addGap(12, 12, 12)
                  .addGroup(var2.createParallelGroup(Alignment.LEADING).addComponent(this.wP, -2, -1, -2).addComponent(this.wQ, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.wi, -1, 647, 32767)
                        .addGroup(var2.createSequentialGroup().addComponent(this.wS, -2, 25, -2).addGap(8, 8, 8).addComponent(this.ut))
                  )
                  .addContainerGap()
            )
      );
   }
}
