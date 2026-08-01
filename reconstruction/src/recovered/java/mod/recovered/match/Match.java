package mod.recovered.match;

import mod.recovered.game.ScheduleDay;
import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.model.Club;
import mod.recovered.model.Player;
import mod.recovered.model.Stadium;

public class Match implements Serializable {
   private static final long serialVersionUID = 1L;
   private boolean v = false;
   private CompetitionStage fw;
   private Competition fx;
   private int fy;
   private Club fz;
   private Club fA;
   private int fB = 0;
   private int fC = 0;
   private Stadium dH;
   private int[] fD = new int[4];
   private int fE = 0;
   private ArrayList fF = new ArrayList();
   private ArrayList fG = new ArrayList();
   private ArrayList fH = new ArrayList();
   private ArrayList fI = new ArrayList();
   private ArrayList fJ = new ArrayList();
   private ArrayList fK = new ArrayList();
   private ArrayList fL = new ArrayList();
   private ArrayList fM = new ArrayList();
   private ArrayList fN = new ArrayList();
   private int fO = 0;
   private int fP = 0;
   private int[] fQ = new int[]{0, 0, -1};
   private int[] fR = new int[]{5, 5};
   private int fS = 0;
   private int fT = 0;
   private int fU = 0;
   private ArrayList fV = new ArrayList();
   private int[] fW = new int[]{50, 50};
   private int[] fX = new int[2];
   private int[] fY = new int[2];
   private int[] fZ = new int[2];
   private int[] ga = new int[2];
   private int[] gb = new int[2];
   private int[] gc = new int[2];
   private int[] gd = new int[2];
   private boolean ge = false;
   private boolean gf = false;
   private int gg = -1;
   private int gh = -1;
   private int[] gi = new int[]{-1, -1};
   private boolean gj = false;
   private Club gk = null;
   private int[][] gl = new int[2][11];
   private int[][] gm = new int[][]{{-1, -1, -1, -1}, {-1, -1, -1, -1}};
   private int[][] gn = new int[][]{{-1, -1, -1}, {-1, -1, -1}};
   private int dq = 0;
   private transient MatchEngine go = null;
   private transient String gp = "";
   private transient String gq = null;
   private transient Stadium gr = null;
   private static ArrayList gs = null;
   private static ArrayList gt = null;
   private static ArrayList gu = null;
   private static ArrayList gv = null;
   private static ArrayList gw = null;

   public Match() {
   }

   public void clear() {
      this.fN.clear();
      this.fF.clear();
      this.fG.clear();
      this.fH.clear();
      this.fI.clear();
      this.fJ.clear();
      this.fK.clear();
      this.fL.clear();
      this.fM.clear();
   }

   public String ha() {
      String var1 = "<html>"
         + this.fW[0]
         + "% "
         + " <b>posse de bola</b> "
         + this.fW[1]
         + " %"
         + "<br>"
         + this.fY[0]
         + " <b>finalizações</b> "
         + this.fY[1]
         + "<br>"
         + "<center>"
         + this.fZ[0]
         + " <b>no gol</b> "
         + this.fZ[1]
         + "</center>"
         + "<br>"
         + this.ga[0]
         + " <b>para fora</b> "
         + this.ga[1]
         + "<br>"
         + this.gb[0]
         + " <b>desarnes</b> "
         + this.gb[1]
         + "<br>"
         + this.gc[0]
         + " passes errados "
         + this.gc[1]
         + "<br>"
         + this.gd[0]
         + " faltas "
         + this.gd[1]
         + "</html>";
      return "<html><body><table width=\"190\" border=\"0\"><tr><td colspan=\"2\">"
         + this.fW[0]
         + "% </td>"
         + "<td colspan=\"2\" align=\"center\"><strong>posse de bola</strong></td>"
         + "<td colspan=\"2\">"
         + this.fW[1]
         + "% </td>"
         + "</tr>"
         + "<tr>"
         + "<td colspan=\"2\">"
         + this.fY[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>finalizações</strong></td>"
         + "<td colspan=\"2\">"
         + this.fY[1]
         + "</td>"
         + "</tr>"
         + "<tr>"
         + "<td colspan=\"2\">"
         + this.fZ[0]
         + "/"
         + this.ga[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>no gol/fora</strong></td>"
         + "<td colspan=\"2\">"
         + this.fZ[1]
         + "/"
         + this.ga[1]
         + "</td>"
         + "</tr>"
         + "<td colspan=\"2\">"
         + this.gb[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>desarmes</strong></td>"
         + "<td colspan=\"2\">"
         + this.gb[1]
         + "</td>"
         + "</tr>"
         + "</tr>"
         + "<td colspan=\"2\">"
         + this.gc[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>erros passes</strong></td>"
         + "<td  colspan=\"2\">"
         + this.gc[1]
         + "</td>"
         + "</tr>"
         + "</table>"
         + "</body>"
         + "</html>";
   }

   public Match(CompetitionStage c0678, int i, Club club, Club club2, int j, Competition c0713, Stadium stadium) {
      this.fw = c0678;
      this.fz = club;
      this.fA = club2;
      this.fy = j;
      this.fx = c0713;
      if (stadium == null) {
         this.dH = this.fz.ev();
      } else {
         this.dH = stadium;
      }

      if (this.dH != null) {
         this.dq = this.dH.dX();
      }

      if (c0678 != null) {
         if (c0678.b() == 9) {
            CountryCompetitions var8 = GamePersistence.careerState.s(this.fz.getPais());
            if (var8 != null) {
               this.dH = var8.C(false);
            }
         } else if ((c0678.b() == 4 || c0678.b() == 6 || c0678.b() == 12) && (c0713.gg() == 0 || c0713.gg() == 1) && c0713.cz(i)) {
            this.dH = null;
            CountryCompetitions var10 = c0713.mF();
            if (var10 != null) {
               boolean var9 = true;
               if (c0678.b() == 6) {
                  var9 = false;
               }

               this.dH = var10.C(var9);
            }
         }
      }

      ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(j)).a(this);
      ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(j)).a(c0678);
      ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(j)).a(c0713);
      if (this.fx.b() == 5 || this.fx.b() == 15) {
         this.dH = null;
      }

      this.hb();
   }

   private void hb() {
      if (gs == null) {
         gs = new ArrayList();

         for (int var1 = 19; var1 <= 38; var1++) {
            gs.add(var1);
         }
      }

      Collections.shuffle(gs);
      if (gt == null) {
         gt = new ArrayList();

         for (int var3 = 5; var3 <= 15; var3++) {
            gt.add(var3);
         }
      }

      if (gu == null) {
         gu = new ArrayList();

         for (int var4 = 16; var4 <= 35; var4++) {
            gu.add(var4);
         }
      }

      if (gv == null) {
         gv = new ArrayList();

         for (int var5 = 36; var5 <= 42; var5++) {
            gv.add(var5);
         }
      }

      if (gw == null) {
         gw = new ArrayList();

         for (int var6 = 43; var6 <= 47; var6++) {
            gw.add(var6);
         }
      }

      Random var7 = new Random();
      int var2 = var7.nextInt(100);
      this.gn[0][0] = (Integer)gs.get(0);
      this.gn[0][1] = (Integer)gs.get(1);
      this.gn[1][0] = (Integer)gs.get(2);
      this.gn[1][1] = (Integer)gs.get(3);
      if (var7.nextInt(100) > 30) {
         this.gn[0][2] = (Integer)gs.get(4);
      }

      if (var7.nextInt(100) > 30) {
         this.gn[1][2] = (Integer)gs.get(5);
      }

      if (var2 > 90) {
         this.F(gt);
      } else if (var2 > 50) {
         this.F(gu);
      } else {
         this.F(gv);
      }

      Collections.shuffle(gw);
      if (var7.nextInt(100) > 20) {
         this.gm[0][2] = (Integer)gw.get(0);
      }

      if (var7.nextInt(100) > 50) {
         this.gm[0][3] = (Integer)gw.get(1);
      }

      if (var7.nextInt(100) > 20) {
         this.gm[1][2] = (Integer)gw.get(2);
      }

      if (var7.nextInt(100) > 50) {
         this.gm[1][3] = (Integer)gw.get(3);
      }
   }

   private void F(ArrayList arrayList) {
      Collections.shuffle(arrayList);
      this.gm[0][0] = (Integer)arrayList.get(0);
      this.gm[0][1] = (Integer)arrayList.get(1);
      this.gm[1][0] = (Integer)arrayList.get(2);
      this.gm[1][1] = (Integer)arrayList.get(3);
   }

   public Match(Club club, Club club2, boolean bl) {
      this.fz = club;
      this.fA = club2;
   }

   public Club hc() {
      return this.fz;
   }

   public void s(Club club) {
      this.fz = club;
   }

   public Club hd() {
      return this.fA;
   }

   public void t(Club club) {
      this.fA = club;
   }

   public static void he() {
      new ArrayList();
      ArrayList var0 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).h();
      Competition var1 = null;
      int var2 = 0;

      for (int var3 = 0; var3 < var0.size(); var3++) {
         ((Match)var0.get(var3)).o(((Match)var0.get(var3)).hG());
         if (((Match)var0.get(var3)).hy() != null) {
            if (((Match)var0.get(var3)).hy().b() == 15) {
               ((Match)var0.get(var3)).a(((Match)var0.get(var3)).hy(), var2, true, GamePersistence.careerState.yn().Bt());
            }

            boolean var4 = false;
            if (((Match)var0.get(var3)).hy().b() == 14 && ((Match)var0.get(var3)).ht() == GamePersistence.careerState.sq().BF()) {
               var4 = true;
            }

            if (((Match)var0.get(var3)).hy().b() == 7 || ((Match)var0.get(var3)).hy().b() == 13 || var4) {
               if (var1 != ((Match)var0.get(var3)).hy()) {
                  var2 = 0;
               }

               var1 = ((Match)var0.get(var3)).hy();
               ((Match)var0.get(var3)).a(((Match)var0.get(var3)).hy(), var2, false, "");
               var2++;
            }

            if (((Match)var0.get(var3)).hy().b() == 9
               && ((Match)var0.get(var3)).ht() != null
               && ((Match)var0.get(var3)).ht() instanceof LeagueStage
               && ((LeagueStage)((Match)var0.get(var3)).ht()).ze() == 7701) {
               CountryCompetitions var5 = GamePersistence.careerState.aY().eY(2);
               String var6 = "";
               if (var5 != null) {
                  var6 = var5.jf();
               }

               ((Match)var0.get(var3)).a(((Match)var0.get(var3)).hy(), var2, true, var6);
            }
         }

         ((Match)var0.get(var3)).V();
      }
   }

   public void hf() {
      int var1 = this.fx.b();
      if (var1 != 7 && var1 != 5 && this.hc().jZ()) {
         this.hc().v(this.fE, 5);
      }
   }

   public void hg() {
      int var1 = -1;
      if (this.fx != null) {
         var1 = this.fx.b();
      }

      C0686 var2 = null;

      for (int var3 = 0; var3 < GamePersistence.careerState.bd().size(); var3++) {
         if (((C0686)GamePersistence.careerState.bd().get(var3)).a(this.fz, this.fA)) {
            var2 = (C0686)GamePersistence.careerState.bd().get(var3);
         }
      }

      if (var2 != null) {
         var2.a(this.fz, this.fA, this.fB, this.fC, var1);
      } else {
         new C0686(this.fz.lk(), this.fA.lk(), this.fB, this.fC, var1);
      }

      this.fz.e(this);
      this.fA.e(this);
      if (this.fz.ka() != null) {
         this.fz.ka().e(this);
         if (this.fx != null
            && (
               this.fx.b() == 1
                  || this.fx.b() == 3
                  || this.fx.b() == 2
                  || this.fx.b() == 4
                  || this.fx.b() == 5
                  || this.fx.b() == 6
                  || this.fx.b() == 8
                  || this.fx.b() == 10
            )) {
            this.fz.ka().a(this, false, -1);
         }
      }

      if (this.fA.ka() != null) {
         this.fA.ka().e(this);
         if (this.fx != null
            && (
               this.fx.b() == 1
                  || this.fx.b() == 3
                  || this.fx.b() == 2
                  || this.fx.b() == 4
                  || this.fx.b() == 5
                  || this.fx.b() == 6
                  || this.fx.b() == 8
                  || this.fx.b() == 10
            )) {
            this.fA.ka().a(this, false, -1);
         }
      }
   }

   public void hh() {
      for (int var1 = 0; var1 < this.fF.size(); var1++) {
         ((Player)this.fF.get(var1)).b(this.fx, this.hc());
         ((Player)this.fF.get(var1)).a(this.fx, this, 0, 1, this.hc());
         if (var1 < this.gl[0].length) {
            this.gl[0][var1] = ((Player)this.fF.get(var1)).fT();
         }
      }

      for (int var2 = 0; var2 < this.fG.size(); var2++) {
         ((Player)this.fG.get(var2)).b(this.fx, this.hd());
         ((Player)this.fG.get(var2)).a(this.fx, this, 1, 0, this.hd());
         if (var2 < this.gl[1].length) {
            this.gl[1][var2] = ((Player)this.fG.get(var2)).fT();
         }
      }

      for (int var3 = 0; var3 < this.fL.size(); var3++) {
         ((Player)this.fL.get(var3)).b(this.fx, this.hc());
         ((Player)this.fL.get(var3)).a(this.fx, this, 0, 1, this.hc());
      }

      for (int var4 = 0; var4 < this.fM.size(); var4++) {
         ((Player)this.fM.get(var4)).b(this.fx, this.hd());
         ((Player)this.fM.get(var4)).a(this.fx, this, 1, 0, this.hd());
      }

      for (int var5 = 0; var5 < this.fN.size(); var5++) {
         if (((C0667)this.fN.get(var5)).eo() != null) {
            if (((C0667)this.fN.get(var5)).b() == 1 && ((C0667)this.fN.get(var5)).el() != 2) {
               ((C0667)this.fN.get(var5)).eo().a(this.fx, ((C0667)this.fN.get(var5)).cu());
            } else if (((C0667)this.fN.get(var5)).b() == 2 || ((C0667)this.fN.get(var5)).b() == 3 || ((C0667)this.fN.get(var5)).b() == 4) {
               ((C0667)this.fN.get(var5)).eo().a(((C0667)this.fN.get(var5)).b(), this.fx, ((C0667)this.fN.get(var5)).cu());
            }
         }
      }
   }

   public void hi() {
      Competition var1 = this.fx;

      for (int var2 = 0; var2 < this.fz.kc().size(); var2++) {
         ((Player)this.fz.kc().get(var2)).aw(0);
         if (((Player)this.fz.kc().get(var2)).c(var1)) {
            ((Player)this.fz.kc().get(var2)).f(var1);
         }
      }

      for (int var3 = 0; var3 < this.fA.kc().size(); var3++) {
         ((Player)this.fA.kc().get(var3)).aw(0);
         if (((Player)this.fA.kc().get(var3)).c(var1)) {
            ((Player)this.fA.kc().get(var3)).f(var1);
         }
      }
   }

   public static void a(int i, Match c0675, Player player, int j, int k) {
      Club var5 = c0675.hc();
      if (i == 1) {
         var5 = c0675.hd();
      }

      a(4, -1, c0675, var5, player, null, j, k);
   }

   public static void b(int i, Match c0675, Player player, int j, int k) {
      player.gj();
      Club var5 = c0675.hc();
      if (i == 1) {
         var5 = c0675.hd();
      }

      if (player.gi() == 2) {
         a(3, -1, c0675, var5, player, null, j, k);
      } else {
         a(2, -1, c0675, var5, player, null, j, k);
      }
   }

   public void k(int i, int j) {
      for (int var3 = 1; var3 <= j; var3++) {
         a(this, i, var3);
      }
   }

   public static void a(Match c0675, int i, int j) {
      int var3 = 30;
      int var4 = 700;
      int var5 = 1000;
      Player var6 = null;
      int[] var7 = new int[]{70, 40, 30};
      int[] var8 = new int[]{45, 40, 30};
      int[] var9 = new int[]{1200, 900, 800};
      int[] var10 = new int[]{800, 700, 550};
      int[] var11 = new int[]{1500, 1000, 800};
      int[] var12 = new int[]{800, 600, 600};
      byte var13 = 0;
      int var15 = new Random().nextInt(100);
      int var16 = 0;
      byte var17 = 0;
      ArrayList var14;
      if (var15 > 55) {
         var14 = c0675.fJ;
         var16 = c0675.hc().kj()[2];
      } else {
         var14 = c0675.fK;
         var16 = c0675.hd().kj()[2];
         var17 = 1;
      }

      int[] var18 = new int[]{30, 10, 0};
      if (var16 >= var18.length) {
         var16 = 0;
      }

      if (j < 15) {
         var13 = 0;
      } else if (j < 30) {
         var13 = 1;
      } else {
         var13 = 2;
      }

      if (j % 7 == 0) {
         c0675.l(i, j);
      }

      if (i == 1) {
         var3 = var7[var13] + var18[var16];
         var4 = var9[var13];
         var5 = var11[var13];
      } else {
         var3 = var8[var13] + var18[var16];
         var4 = var10[var13];
         var5 = var12[var13];
      }

      if (c0675.fS > 5) {
         var3 *= 2;
      } else if (c0675.fS > 10) {
         var3 = 1000;
      }

      if (c0675.fT >= 2) {
         var3 = var4 * 2;
      }

      if (c0675.fU >= 1) {
         var3 = var5 * 5;
      }

      if (new Random().nextInt(var3) == 1) {
         var6 = H(var14);
         c0675.fS++;
         if (var6 != null) {
            b(var17, c0675, var6, i, j);
         }
      } else if (new Random().nextInt(var4) == 1) {
         var6 = J(var14);
         if (var6 != null) {
            a(var17, c0675, var6, i, j);
         }

         c0675.fT++;
      } else if (new Random().nextInt(var5) == 1) {
         c0675.fU++;
         Club var19 = c0675.hc();
         if (var17 == 1) {
            var19 = c0675.hd();
         }

         var6 = I(var14);
         if (var6 != null) {
            a(5, -1, c0675, var19, var6, null, i, j);
         }
      } else if (i == 2 && j >= 5) {
         c0675.m(i, j);
      }
   }

   public int a(Player player, int i, int j) {
      byte var4 = 1;
      int var5 = new Random().nextInt(1000);
      if (i == 1) {
         if (var5 < 900) {
            var4 = 1;
         } else if (var5 < 950) {
            var4 = 3;
         } else if (var5 < 980) {
            var4 = 4;
         } else if (var5 < 990) {
            var4 = 2;
         } else if (var5 < 995) {
            var4 = 5;
         } else {
            var4 = 1;
         }
      } else if (i == 2) {
         if (var5 < 800) {
            var4 = 1;
         } else if (var5 < 850) {
            var4 = 3;
         } else if (var5 < 980) {
            var4 = 4;
         } else if (var5 < 990) {
            var4 = 2;
         } else if (var5 < 995) {
            var4 = 5;
         } else {
            var4 = 1;
         }
      }

      if (var4 == 5 && (player.getPosicao() == 0 || player.getPosicao() == 2)) {
         var4 = 1;
      }

      if (var4 == 3) {
         ArrayList var6 = null;
         byte var7 = 0;
         if (player.fg() == this.fz) {
            var6 = this.fK;
            var7 = 1;
         } else if (player.fg() == this.fA) {
            var6 = this.fJ;
            var7 = 0;
         }

         if (var6 != null) {
            var5 = new Random().nextInt(100);
            if (var5 < 50) {
               Player var8 = H(var6);
               if (var8 != null) {
                  b(var7, this, var8, i, j);
               }
            } else if (var5 < 60) {
               Player var10 = J(var6);
               if (var10 != null) {
                  a(var7, this, var10, i, j);
               }
            }
         }
      }

      return var4;
   }

   public static C0671 a(Match c0675, int i, int j, int k) {
      for (int var4 = 0; var4 < c0675.fV.size(); var4++) {
         if (((C0671)c0675.fV.get(var4)).fc() == i && ((C0671)c0675.fV.get(var4)).eZ() == k && ((C0671)c0675.fV.get(var4)).en() == j) {
            return (C0671)c0675.fV.get(var4);
         }
      }

      return null;
   }

   public static C0667 a(int i, int j, Match c0675, Club club, Player player, Player player2, int k, int l) {
      ArrayList var8 = null;
      ArrayList var9 = null;
      byte var10 = 0;
      if (club == c0675.fz) {
         var8 = c0675.hp();
         var9 = c0675.hq();
         var10 = 0;
      } else if (club == c0675.fA) {
         var8 = c0675.hq();
         var9 = c0675.hp();
         var10 = 1;
      }

      C0667 var11 = new C0667(var10);
      var11.a(i);
      var11.f(player);
      if (j == 2) {
         Player var12 = G(var9);
         if (var12 != null) {
            var11.f(var12);
            var11.R(2);
         } else {
            var11.R(1);
         }
      } else {
         var11.R(j);
      }

      if (player2 != null) {
         var11.g(player2);
      }

      var11.S(l);
      var11.T(k);
      var11.k(club);
      c0675.fN.add(var11);
      if (i == 2) {
         player.gB().tG();
      } else if (i == 4) {
         player.gB().tH();
      } else if (i == 3) {
         player.gB().tG();
         player.gB().tH();
      }

      if (i != 3 && i != 4) {
         if (i == 5) {
            if (player != null) {
               player.p(club);
            }

            if (var8 != null && !club.jZ()) {
               var8.remove(player);
            }

            if (c0675 != null && club != null && c0675.fR[var10] > 0 && !club.jZ()) {
               a(var10, false, c0675, player, k, l, true);
            }
         }
      } else if (var8 != null) {
         var8.remove(player);
         if (player.fT() <= 13 && !club.jZ() && c0675.fR[var10] > 0) {
            a(var10, true, c0675, player, k, l, false);
         }
      }

      return var11;
   }

   public static void a(int i, boolean bl, Match c0675, Player player, int j, int k, boolean bl2) {
      ArrayList var7 = null;
      ArrayList var8 = null;
      Player var9 = null;
      if (i == 0) {
         var7 = c0675.hn();
         var8 = c0675.fJ;
      } else if (i == 1) {
         var7 = c0675.ho();
         var8 = c0675.fK;
      }

      if (bl) {
         var9 = a(var8, 18, 25);
         if (var9 == null) {
            var9 = a(var8, 14, 17);
         }

         if (var9 == null && player.fT() == 1) {
            var9 = a(var8, 2, 25);
         }
      } else {
         var9 = player;
      }

      if (var7 != null && var9 != null) {
         Player var10 = null;
         if (player.fT() >= 0) {
            boolean var11 = true;
            if (player.getPosicao() == 0) {
               var11 = false;
            }

            var10 = Club.a(var7, player.fT(), false, var11);
         }

         if (var10 != null) {
            if (bl2) {
               if (var9.getPosicao() == 0 || var10.getPosicao() != 0) {
                  c0675.a(i, var9, var10, j, k, player.fT());
               }
            } else {
               c0675.a(i, var9, var10, j, k, player.fT());
            }
         }
      }
   }

   public C0667 a(int i, Player player, Player player2, int j, int k, int l) {
      C0667 var7 = null;
      ArrayList var8 = null;
      ArrayList var9 = null;
      ArrayList var10 = null;
      if (player != null && player2 != null) {
         Club var11 = this.hc();
         if (i == 0) {
            var8 = this.hp();
            var9 = this.hn();
            var10 = this.fL;
            this.aS(0);
         } else if (i == 1) {
            var8 = this.hq();
            var9 = this.ho();
            this.aS(1);
            var10 = this.fM;
            var11 = this.hd();
         }

         if (var8 != null && var9 != null) {
            player2.as(player.fT());
            if (l > 0) {
               player2.as(l);
            }

            var8.remove(player);
            var8.add(player2);
            var10.add(player2);
            player2.b(true);
            var9.remove(player2);
         }

         var7 = a(6, -1, this, var11, player, player2, j, k);
      }

      return var7;
   }

   public void l(int i, int j) {
      for (int var3 = 0; var3 < this.fJ.size(); var3++) {
         if (((Player)this.fJ.get(var3)).fT() != 1) {
            ((Player)this.fJ.get(var3)).fq();
         } else if (i == 2) {
            ((Player)this.fJ.get(var3)).fq();
         }
      }

      for (int var4 = 0; var4 < this.fK.size(); var4++) {
         if (((Player)this.fK.get(var4)).fT() != 1) {
            ((Player)this.fK.get(var4)).fq();
         } else if (i == 2) {
            ((Player)this.fK.get(var4)).fq();
         }
      }
   }

   public void m(int i, int j) {
      boolean var3 = false;
      if (i == 2) {
         if (!this.fz.jZ() && this.fR[0] > 0) {
            if (j == 0 && this.n(1, 1)) {
               if (new Random().nextInt(100) > 50) {
                  var3 = this.a(2, 0, i, j, this.hp());
               }
            } else if (j != this.gn[0][0] && j != this.gn[0][1] && j != this.gn[0][2]) {
               if (j == this.gm[0][0] || j == this.gm[0][1] || j == this.gm[0][2] || j == this.gm[0][3]) {
                  var3 = this.a(1, 0, i, j, this.hp());
               }
            } else if (this.n(1, 1) || this.hj()) {
               var3 = this.a(2, 0, i, j, this.hp());
            }
         }

         if (!var3 && !this.fA.jZ() && this.fR[1] > 0) {
            if (j == 0 && this.n(2, 2)) {
               if (new Random().nextInt(100) > 50) {
                  this.a(2, 1, i, j, this.hq());
               }
            } else if (j != this.gn[1][0] && j != this.gn[1][1] && j != this.gn[1][2]) {
               if (j == this.gm[1][0] || j == this.gm[1][1] || j == this.gm[1][2] || j == this.gm[1][3]) {
                  this.a(1, 1, i, j, this.hq());
               }
            } else if (this.n(2, 1)) {
               this.a(2, 1, i, j, this.hq());
            }
         }
      }
   }

   public boolean a(int i, int j, int k, int l, ArrayList arrayList) {
      if (i == 1) {
         byte var6 = 60;
         int var7 = 0;
         if (l > 40) {
            var6 = 90;
            if (arrayList.size() > 0) {
               var7 = new Random().nextInt(arrayList.size());
            }
         }

         for (int var8 = var7; var8 < arrayList.size(); var8++) {
            if (((Player)arrayList.get(var8)).fT() != 1 && ((Player)arrayList.get(var8)).fp() < var6) {
               a(j, false, this, (Player)arrayList.get(var8), k, l, false);
               return true;
            }
         }
      } else if (i == 2) {
         Random var9 = new Random();
         int var10 = 0;
         if (arrayList.size() > 0) {
            var10 = var9.nextInt(arrayList.size());
            ArrayList var12 = this.fL;
            if (j == 2) {
               var12 = this.fM;
            }

            if (var12.contains(arrayList.get(var10))) {
               var10 = var9.nextInt(arrayList.size());
            }

            if (((Player)arrayList.get(var10)).fT() != 1 && !var12.contains(arrayList.get(var10))) {
               a(j, false, this, (Player)arrayList.get(var10), k, l, false);
               return true;
            }
         }
      }

      return false;
   }

   private boolean hj() {
      return this.fB == this.fC;
   }

   private boolean n(int i, int j) {
      if (i == 1) {
         if (this.fC - this.fB >= j) {
            return true;
         }
      } else if (this.fB - this.fC >= j) {
         return true;
      }

      return false;
   }

   public void o(int i, int j) {
      int var3 = new Random().nextInt(100) + 1;
      byte var4 = 50;
      if (j < 10) {
         var4 = 95;
      } else if (j < 30) {
         var4 = 80;
      } else if (j < 40) {
         var4 = 60;
      } else {
         var4 = 40;
      }

      boolean var5 = false;
      if (var3 > var4) {
         if (!this.fz.jZ() && this.fR[0] > 0) {
            for (int var6 = 0; var6 < this.fJ.size(); var6++) {
               if (((Player)this.fJ.get(var6)).fT() != 1) {
                  if (((Player)this.fJ.get(var6)).fp() < 75) {
                     a(0, false, this, (Player)this.fJ.get(var6), i, j, false);
                     var5 = true;
                     break;
                  }
               } else if (i == 2 && ((Player)this.fJ.get(var6)).fp() < 40) {
                  a(0, false, this, (Player)this.fJ.get(var6), i, j, false);
                  var5 = true;
                  break;
               }
            }
         }

         if (!var5 && !this.fA.jZ() && this.fR[1] > 0) {
            for (int var8 = 0; var8 < this.fK.size(); var8++) {
               if (((Player)this.fK.get(var8)).fT() != 1) {
                  if (((Player)this.fK.get(var8)).fp() < 75) {
                     a(1, false, this, (Player)this.fK.get(var8), i, j, false);
                     break;
                  }
               } else if (i == 2 && ((Player)this.fK.get(var8)).fp() < 40) {
                  a(1, false, this, (Player)this.fK.get(var8), i, j, false);
                  break;
               }
            }
         }
      }
   }

   public static Player G(ArrayList arrayList) {
      int var1 = new Random().nextInt(1000);
      Object var2 = null;
      byte var3 = 0;
      if (var1 == 0) {
         var3 = 6;
      } else if (var1 < 150) {
         var3 = 0;
      } else if (var1 < 350) {
         var3 = 1;
      } else if (var1 < 400) {
         var3 = 2;
      } else if (var1 < 450) {
         var3 = 3;
      } else if (var1 < 500) {
         var3 = 4;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static Player H(ArrayList arrayList) {
      int var1 = new Random().nextInt(100);
      Object var2 = null;
      byte var3 = 0;
      if (var1 < 25) {
         var3 = 0;
      } else if (var1 < 40) {
         var3 = 1;
      } else if (var1 < 65) {
         var3 = 2;
      } else if (var1 < 73) {
         var3 = 3;
      } else if (var1 < 82) {
         var3 = 4;
      } else if (var1 < 85) {
         var3 = 6;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static Player I(ArrayList arrayList) {
      int var1 = new Random().nextInt(500);
      Object var2 = null;
      byte var3 = 0;
      if (var1 == 0) {
         var3 = 6;
      } else if (var1 < 150) {
         var3 = 0;
      } else if (var1 < 250) {
         var3 = 1;
      } else if (var1 < 320) {
         var3 = 2;
      } else if (var1 < 360) {
         var3 = 3;
      } else if (var1 < 420) {
         var3 = 4;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static Player a(ArrayList arrayList, int i, int j) {
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < arrayList.size(); var4++) {
         if (((Player)arrayList.get(var4)).fT() >= i && ((Player)arrayList.get(var4)).fT() <= j) {
            var3.add((Player)arrayList.get(var4));
         }
      }

      Collections.shuffle(var3);
      return var3.size() > 0 ? (Player)var3.get(0) : null;
   }

   public static Player J(ArrayList arrayList) {
      int var1 = new Random().nextInt(200);
      Object var2 = null;
      byte var3 = 0;
      if (var1 == 0) {
         var3 = 6;
      } else if (var1 < 80) {
         var3 = 0;
      } else if (var1 < 110) {
         var3 = 1;
      } else if (var1 < 160) {
         var3 = 2;
      } else if (var1 < 170) {
         var3 = 3;
      } else if (var1 < 190) {
         var3 = 4;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static ArrayList p(int i, int j) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 1; var4 <= i; var4++) {
         var3.add(var4);
      }

      Collections.shuffle(var3);

      for (int var5 = 0; var5 <= j - 1; var5++) {
         var2.add((Integer)var3.get(var5));
      }

      return var2;
   }

   public void q(int i, int j) {
      MatchEngine var3 = null;
      if (this.go == null) {
         var3 = new MatchEngine(this);
         this.a(var3);
      } else {
         var3 = this.go;
      }

      a(this, j, i);
      C0667 var4 = null;
      var4 = var3.vO();
      if (var4 != null) {
         var4.S(i);
         var4.T(j);
         this.hE().add(var4);
         if (var4.b() == 1 && var4.ep() != null) {
            C0667 var5 = new C0667(var4.et());
            var5.S(i);
            var5.f(var4.ep());
            var5.a(8);
            var5.T(j);
            this.hE().add(var5);
         }
      }
   }

   public void a(Competition c0713, int i, boolean bl, String string) {
      if (!bl) {
         this.p(c0713.cx(i));
         int var5 = c0713.cy(i);
         this.b(new Stadium(true, this.ik(), var5));
      } else {
         this.dH = null;
         this.gr = null;
         this.p(string);
      }
   }

   public void V() {
      MatchEngine var1 = new MatchEngine(this);
      this.a(var1);
      int[] var10000 = new int[]{-1, -1};
      if (this.ht() instanceof KnockoutStage) {
         if (((KnockoutStage)this.ht()).zu()) {
            if (((KnockoutStage)this.ht()).zr() == 2) {
               int[] var2 = ((KnockoutStage)this.ht()).o(this);
               this.aU(var2[1]);
               this.aV(var2[0]);
               this.gj = true;
               this.ge = true;
            }
         } else {
            this.ge = true;
         }

         if (this.ge) {
            if (((KnockoutStage)this.ht()).zA()) {
               this.gf = false;
            } else {
               this.gf = true;
            }
         }
      }

      if (this.ev() != null) {
         this.ev().b(this);
      } else if (this.il() != null) {
         this.il().b(this);
      }

      if (!this.hc().jZ() && !this.hd().jZ()) {
         this.fQ[0] = new Random().nextInt(3);
         this.fQ[1] = new Random().nextInt(5) + 1;

         for (int var3 = 0; var3 < 45 + this.fQ[0]; var3++) {
            a(this, 1, var3);
            C0667 var4 = null;
            var4 = var1.vO();
            if (var4 != null) {
               var4.S(var3);
               var4.T(1);
               this.hE().add(var4);
               if (var4.b() == 1 && var4.ep() != null) {
                  C0667 var5 = new C0667(var4.et());
                  var5.S(var3);
                  var5.f(var4.ep());
                  var5.a(8);
                  var5.T(1);
                  this.hE().add(var5);
               }
            }
         }

         this.m(2, 0);

         for (int var6 = 0; var6 < 45 + this.fQ[1]; var6++) {
            a(this, 2, var6);
            C0667 var9 = null;
            var9 = var1.vO();
            if (var9 != null) {
               var9.S(var6);
               var9.T(2);
               this.hE().add(var9);
               if (var9.b() == 1 && var9.ep() != null) {
                  C0667 var12 = new C0667(var9.et());
                  var12.S(var6);
                  var12.f(var9.ep());
                  var12.T(2);
                  var12.a(8);
                  this.hE().add(var12);
               }
            }
         }

         if (this.ge && this.gf && this.hk()) {
            int var7 = new Random().nextInt(7) + 2;
            int var11 = new Random().nextInt(7) + 2;
            if (var7 >= var11) {
               this.gk = this.hc();
               this.gi[0] = var7;
               this.gi[1] = var7 - 1;
            } else {
               this.gk = this.hd();
               this.gi[0] = var7;
               this.gi[1] = var7 + 1;
            }
         }
      }

      this.hc().I(false);
      this.hd().I(false);
   }

   public boolean hk() {
      boolean var1 = ((KnockoutStage)this.ht()).zv();
      int var2 = ((KnockoutStage)this.ht()).BI();
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      byte var9 = 0;
      int var10 = 0;
      int var11 = 0;
      var3 = this.hu();
      var4 = this.hw();
      var10 = var3;
      var11 = var4;
      if (var3 > var4) {
         var7++;
      } else if (var4 > var3) {
         var8++;
      }

      if (this.gj) {
         var6 = this.hK();
         var5 = this.hL();
         if (var5 > var6) {
            var7++;
         } else if (var6 > var5) {
            var8++;
         }

         var10 += var5;
         var11 += var6;
      }

      if (var7 > var8) {
         var9 = 1;
      } else if (var8 > var7) {
         var9 = 2;
      }

      if (var9 == 0) {
         if (var10 > var11) {
            var9 = 1;
         } else if (var11 > var10) {
            var9 = 2;
         }
      }

      if (var9 == 0 && this.gj && var1) {
         if (var5 > var4) {
            var9 = 1;
         } else if (var4 > var5) {
            var9 = 2;
         }
      }

      return var9 == 0 && var2 == 2129 ? false : var9 == 0;
   }

   public ArrayList hl() {
      return this.fF;
   }

   public ArrayList hm() {
      return this.fG;
   }

   public ArrayList hn() {
      return this.fH;
   }

   public ArrayList ho() {
      return this.fI;
   }

   public ArrayList hp() {
      return this.fJ;
   }

   public ArrayList hq() {
      return this.fK;
   }

   public int hr() {
      return this.fO;
   }

   public void aP(int i) {
      this.fO = i;
   }

   public int hs() {
      return this.fP;
   }

   public void aQ(int i) {
      this.fP = i;
   }

   public CompetitionStage ht() {
      return this.fw;
   }

   public int hu() {
      return this.fB;
   }

   public void hv() {
      this.fB++;
   }

   public int hw() {
      return this.fC;
   }

   public void hx() {
      this.fC++;
   }

   public int aR(int i) {
      return this.fR[i];
   }

   public void aS(int i) {
      this.fR[i]--;
   }

   public Competition hy() {
      return this.fx;
   }

   public int[] hz() {
      return this.fW;
   }

   public void d(int[] is) {
      this.fW = is;
   }

   public int[] hA() {
      return this.fY;
   }

   public void e(int[] is) {
      this.fY = is;
   }

   public int[] hB() {
      return this.gb;
   }

   public void f(int[] is) {
      this.gb = is;
   }

   public int[] hC() {
      return this.gc;
   }

   public void g(int[] is) {
      this.gc = is;
   }

   public int[] hD() {
      return this.gd;
   }

   public void h(int[] is) {
      this.gd = is;
   }

   public ArrayList hE() {
      return this.fN;
   }

   public Stadium ev() {
      return this.dH;
   }

   public Player aT(int i) {
      if (i == 1) {
         for (int var2 = 0; var2 < this.fJ.size(); var2++) {
            if (((Player)this.fJ.get(var2)).fT() == 1) {
               return (Player)this.fJ.get(var2);
            }
         }
      } else if (i == 2) {
         for (int var3 = 0; var3 < this.fK.size(); var3++) {
            if (((Player)this.fK.get(var3)).fT() == 1) {
               return (Player)this.fK.get(var3);
            }
         }
      }

      return null;
   }

   public void hF() {
      this.fB = 0;
      this.fC = 0;

      for (int var1 = 0; var1 < this.fN.size(); var1++) {
         if (((C0667)this.fN.get(var1)).b() == 1) {
            if (((C0667)this.fN.get(var1)).cu() == this.fz) {
               this.fB++;
            } else if (((C0667)this.fN.get(var1)).cu() == this.fA) {
               this.fC++;
            }
         }
      }
   }

   public String hG() {
      String var1 = "";
      if (this.fx != null) {
         var1 = this.fx.is();
      }

      if (this.fw != null) {
         var1 = var1 + " - " + this.fw.io();
      }

      if (this.fx != null && this.fx.b() == 9 && this.fw != null && this.fw instanceof LeagueStage && ((LeagueStage)this.fw).ze() == 7701) {
         var1 = "Torneio Repescagem";
      }

      if (this.fx != null && this.fx.b() == 1 && this.fw != null && this.fw instanceof KnockoutStage) {
         if (((KnockoutStage)this.fw).zf() == 1099) {
            var1 = "Mata-Mata Ascenso - " + var1;
         } else if (((KnockoutStage)this.fw).zf() == 1098) {
            var1 = "Playoff Rebaixamento - " + var1;
         }
      }

      return var1;
   }

   public String hH() {
      String var1 = "";
      if (this.fx != null) {
         var1 = this.fx.getNome();
      }

      String var2 = "";
      if (this.fw != null) {
         var2 = " - " + this.fw.io();
      }

      return var1 + var2;
   }

   public String hI() {
      String var1 = "";
      String var2 = "";
      if (this.fx != null) {
         var1 = this.fx.getNome();
      }

      if (this.fw != null) {
         var2 = " - " + this.fw.io();
      }

      return var1 + var2;
   }

   public String[] hJ() {
      String[] var1 = new String[]{"", ""};
      if (this.fw != null) {
         var1[1] = this.fw.io();
      }

      if (this.fx != null) {
         var1[0] = this.fx.is();
      }

      return var1;
   }

   public int hK() {
      return this.gg;
   }

   public void aU(int i) {
      this.gg = i;
   }

   public int hL() {
      return this.gh;
   }

   public void aV(int i) {
      this.gh = i;
   }

   public int hM() {
      return this.fy;
   }

   public int hN() {
      return this.fE;
   }

   public boolean hO() {
      return this.gj;
   }

   public void s(boolean bl) {
      this.gj = bl;
   }

   public boolean hP() {
      return this.gf;
   }

   public int[] hQ() {
      return this.gi;
   }

   public Club hR() {
      return this.gk;
   }

   public boolean hS() {
      return this.ge;
   }

   public void u(Club club) {
      this.gk = club;
   }

   public void i(int[] is) {
      this.gi = is;
   }

   public void aW(int i) {
      this.fE = i;
   }

   public void j(int[] is) {
      this.fD = is;
   }

   public int[] hT() {
      return this.fD;
   }

   public int hU() {
      return this.fD[0] + this.fD[1] + this.fD[2] + this.fD[3];
   }

   public String hV() {
      return Integer.toString(this.hU())
         + " (G:"
         + Integer.toString(this.fD[0])
         + ","
         + "A:"
         + Integer.toString(this.fD[1])
         + ","
         + "Cd:"
         + Integer.toString(this.fD[2])
         + ","
         + "Cm:"
         + Integer.toString(this.fD[3])
         + ")";
   }

   public MatchEngine hW() {
      return this.go;
   }

   public void a(MatchEngine c0746) {
      this.go = c0746;
   }

   public boolean hX() {
      return this.fx != null && this.fx.b() == 5 || this.fx.b() == 7;
   }

   public int[] hY() {
      return this.fX;
   }

   public int[] hZ() {
      return this.fZ;
   }

   public int[] ia() {
      return this.ga;
   }

   public boolean e() {
      return this.v;
   }

   public void a(boolean bl) {
      this.v = bl;
   }

   public int[] ib() {
      return this.fQ;
   }

   public boolean ic() {
      boolean var1 = false;
      if (this.fz.jY() != null && this.fA.jY() != null) {
         for (int var2 = 0; var2 < GameConstants.pe.length; var2++) {
            if (this.fz.jY().equals(GameConstants.pe[var2][0]) && this.fA.jY().equals(GameConstants.pe[var2][1])) {
               return true;
            }

            if (this.fA.jY().equals(GameConstants.pe[var2][0]) && this.fz.jY().equals(GameConstants.pe[var2][1])) {
               return true;
            }
         }
      }

      return var1;
   }

   public int[][] id() {
      return this.gl;
   }

   public ArrayList ie() {
      return this.fL;
   }

   public ArrayList method_kw_if() {
      return this.fM;
   }

   public String ig() {
      return this.fB + " x " + this.fC;
   }

   public String ih() {
      return " " + this.fB + "x" + this.fC + " ";
   }

   public String ii() {
      return " " + this.fB + "x" + this.fC + " " + "(" + this.gi[0] + "x" + this.gi[1] + ")";
   }

   public String t(boolean bl) {
      return !bl ? " " + this.fB + "x" + this.fC + " " : " " + this.fC + "x" + this.fB + " ";
   }

   public String u(boolean bl) {
      return !bl ? this.gi[0] + "x" + this.gi[1] : this.gi[1] + "x" + this.gi[0];
   }

   public String ij() {
      return this.gp;
   }

   public void o(String string) {
      this.gp = string;
   }

   public int dX() {
      return this.dq;
   }

   public void O(int i) {
      this.dq = i;
   }

   public String ik() {
      return this.gq;
   }

   public void p(String string) {
      this.gq = string;
   }

   public Stadium il() {
      return this.gr;
   }

   public void b(Stadium stadium) {
      this.gr = stadium;
   }
}
