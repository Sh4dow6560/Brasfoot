package mod.recovered.model;

import mod.recovered.match.Match;
import bf22.intermediary.C0689;
import mod.recovered.competition.CountryCompetitions;
import bf22.intermediary.C0693;
import bf22.intermediary.C0696;
import bf22.intermediary.C0703;
import bf22.intermediary.C0704;
import bf22.intermediary.C0708;
import mod.recovered.core.GameConstants;
import mod.recovered.competition.Competition;
import bf22.intermediary.C0730;
import bf22.intermediary.C0741;
import mod.recovered.save.GamePersistence;
import bf22.intermediary.C0788;
import bf22.intermediary.C0799;
import bf22.intermediary.C0825;
import bf22.intermediary.C0914;
import bf22.intermediary.C0915;
import bf22.intermediary.C0924;
import bf22.intermediary.C0951;
import mod.recovered.competition.LeagueStage;
import mod.recovered.competition.KnockoutStage;
import bf22.intermediary.C1007;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import mod.recovered.finance.ClubFinances;
import mod.recovered.team.LineupPreset;

public class Club implements Serializable {
   private static final long serialVersionUID = 1L;
   private int mU = -1;
   private int ei = -1;
   private String mV = null;
   private Boolean mW = false;
   private Boolean mX = false;
   private int mY;
   private int pais;
   private int dr;
   private int hA;
   private int divisao = 0;
   private transient Coach mZ;
   private int na = -1;
   private long nb = 0L;
   private int nc = 0;
   private ArrayList nd = new ArrayList();
   private ArrayList ne = new ArrayList();
   private ArrayList nf = new ArrayList();
   private ArrayList ng = new ArrayList();
   private Player nh = null;
   private Player ni = null;
   private Player nj = null;
   private Player nk = null;
   private int nl;
   private transient Color nm = null;
   private transient Color nn = null;
   private String cor1 = "#000000";
   private String cor2 = "#ffffff";
   private ArrayList no = new ArrayList();
   private ArrayList np = new ArrayList();
   private Stadium dH;
   private int[] nq = new int[4];
   private int[] nr = new int[]{0, 1, 1, 1, 1};
   private int ns = 0;
   private boolean nt = true;
   private int nu = 0;
   private boolean nv = false;
   private int hr = new Random().nextInt(1000) + 1;
   private ArrayList nw = new ArrayList();
   private ClubFinances nx = new ClubFinances();
   private ArrayList ny = new ArrayList();
   private LineupPreset nz = null;
   private int nA = 0;
   private int[] nB = new int[15];
   private int[][] nC = new int[15][3];
   private int nD = 0;
   private transient ImageIcon nE = null;
   private transient ImageIcon nF = null;
   private transient ImageIcon nG = null;
   private transient ImageIcon nH = null;
   private transient ImageIcon nI = null;
   private ArrayList cA = new ArrayList();
   private String dm = "";
   private transient int Kb = -1;
   public static Comparator nJ = new ClubPlayerComparator();

   public Club() {
   }

   public Club(
      String string,
      String string2,
      int i,
      int j,
      int k,
      int l,
      String string3,
      int m,
      Color color,
      Color color2,
      String string4,
      int n,
      ArrayList arrayList,
      boolean bl
   ) {
      this.dm = string;
      this.mV = string2;
      this.mY = i;
      this.pais = j;
      this.dr = k;
      this.setReputacao(m);
      this.nm = color;
      this.nn = color2;
      this.setNivel(l);
      if (!bl) {
         this.a(string4, n);
         Coach var15 = new Coach(string3);
         this.mZ = var15;
         this.mZ.n(this);
         this.na = var15.lT();
         this.mZ.setReputacao(m);
         GamePersistence.SR.a(var15);
         GamePersistence.SR.c(this);

         for (int var16 = 0; var16 < arrayList.size(); var16++) {
            Player var17 = new Player((C0689)arrayList.get(var16), this);
            if (var17.fC()) {
               GamePersistence.SR.c(var17);
               this.ne.add(var17);
            } else {
               GamePersistence.SR.b(var17);
               this.nd.add(var17);
            }
         }
      } else {
         this.nc = this.getReputacao();
      }
   }

   public int getPais() {
      return this.pais;
   }

   public int jV() {
      int var1 = -1;
      Integer[][] var2 = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};

      for (int var3 = 0; var3 < var2.length; var3++) {
         for (int var4 = 0; var4 < var2[var3].length; var4++) {
            if (this.dr == var2[var3][var4]) {
               var1 = var3;
            }
         }
      }

      return var1;
   }

   public int jW() {
      int var1 = -1;
      Integer[][] var2 = new Integer[][]{{25, 18, 10, 22}, {17, 23, 4, 15, 5}, {8, 1, 13, 11, 9, 19, 14}, {24, 0, 16, 12, 2, 6}, {7, 26, 20, 3, 21}};

      for (int var3 = 0; var3 < var2.length; var3++) {
         for (int var4 = 0; var4 < var2[var3].length; var4++) {
            if (this.dr == var2[var3][var4]) {
               var1 = var3;
            }
         }
      }

      return var1;
   }

   public int jX() {
      int var1 = -1;
      Integer[][] var2 = new Integer[][]{{18, 25, 17, 22, 23}, {10}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {6, 7, 8, 11, 12, 26}, {0, 2, 3, 13, 20, 21}};

      for (int var3 = 0; var3 < var2.length; var3++) {
         for (int var4 = 0; var4 < var2[var3].length; var4++) {
            if (this.dr == var2[var3][var4]) {
               var1 = var3;
            }
         }
      }

      return var1;
   }

   public void setPais(int i) {
      this.pais = i;
   }

   public String getNome() {
      return this.dm;
   }

   public String jY() {
      return this.mV;
   }

   public Boolean jZ() {
      return this.mW;
   }

   public void k(Boolean boolean_) {
      this.mW = boolean_;
   }

   public Coach ka() {
      if (this.mZ == null) {
         this.mZ = GamePersistence.SR.y(this.na);
      }

      return this.mZ;
   }

   public void h(Coach coach) {
      this.mZ = coach;
      if (this.mZ != null) {
         this.na = this.mZ.lT();
      } else {
         this.na = -1;
      }
   }

   public long kb() {
      return this.nb;
   }

   public void e(long l) {
      this.nb = l;
   }

   public int getReputacao() {
      return this.nc;
   }

   public void setReputacao(int i) {
      this.nc = i;
   }

   public ArrayList kc() {
      return this.nd;
   }

   public void N(ArrayList arrayList) {
      this.nd = arrayList;
   }

   public Player kd() {
      if (this.nh != null && this.nh.fg() != this) {
         if (!this.lp()) {
            this.nh = null;
         } else if (!this.kc().contains(this.nh)) {
            this.nh = null;
         }
      }

      return this.nh;
   }

   public void j(Player player) {
      this.nh = player;
   }

   public Player ke() {
      if (this.ni != null && this.ni.fg() != this) {
         if (!this.lp()) {
            this.ni = null;
         } else if (!this.kc().contains(this.ni)) {
            this.ni = null;
         }
      }

      return this.ni;
   }

   public void k(Player player) {
      this.ni = player;
   }

   public Stadium ev() {
      return this.dH;
   }

   public void a(Stadium stadium) {
      this.dH = stadium;
   }

   public void l(Player player) {
      this.nd.add(player);
   }

   public void m(Player player) {
      this.ne.add(player);
   }

   public int getNivel() {
      return this.hA;
   }

   public void setNivel(int i) {
      if (i >= 1 && i <= 25) {
         this.hA = i;
      } else {
         this.hA = 10;
      }
   }

   public void a(String string, int i) {
      this.dH = new Stadium(string, i, this);
   }

   public boolean kf() {
      return this.nv;
   }

   public void I(boolean bl) {
      this.nv = bl;
   }

   public int getDivisao() {
      return this.divisao;
   }

   public boolean kg() {
      C0741 var1 = GamePersistence.SR.p(this.dr);
      return var1 != null && var1.j(this);
   }

   public void setDivisao(int i) {
      this.divisao = i;
   }

   public static void kh() {
      new ArrayList();
      ArrayList var0 = ((C0693)GamePersistence.SR.R().get(GamePersistence.SR.J())).h();

      for (int var1 = 0; var1 < var0.size(); var1++) {
         if (!((Match)var0.get(var1)).hc().jZ() && !((Match)var0.get(var1)).hc().kf()) {
            a(((Match)var0.get(var1)).hc(), (Match)var0.get(var1), 1, -1, true);
         }

         if (!((Match)var0.get(var1)).hd().jZ() && !((Match)var0.get(var1)).hd().kf()) {
            a(((Match)var0.get(var1)).hd(), (Match)var0.get(var1), 2, -1, true);
         }
      }
   }

   public static void a(Club club, Match c0675, int i, int j, boolean bl) {
      ArrayList var5 = new ArrayList();
      int[] var6 = new int[6];

      for (int var7 = 0; var7 < club.nd.size(); var7++) {
         ((Player)club.nd.get(var7)).as(-1);
         if (((Player)club.nd.get(var7)).a(c0675, false)) {
            var5.add((Player)club.nd.get(var7));
            int var8 = ((Player)club.nd.get(var7)).getPosicao();
            if (var8 >= 0 && var8 <= 4) {
               var6[var8]++;
            }

            if (var8 == 3 && ((Player)club.nd.get(var7)).fF() == 0) {
               var6[5]++;
            }

            ((Player)club.nd.get(var7)).fF();
         }
      }

      Collections.sort(var5, C1007.abh);
      club.nf.clear();
      club.ng.clear();
      int var13 = 1;
      int var15 = new Random().nextInt(100) + 1;
      if (var15 >= 0 && var15 <= 2) {
         var13 = 1;
      } else if (var15 >= 3 && var15 <= 4) {
         var13 = 2;
      } else if (var15 >= 5 && var15 <= 7) {
         var13 = 3;
      } else if (var15 >= 8 && var15 <= 38) {
         var13 = 4;
      } else if (var15 >= 39 && var15 <= 49) {
         var13 = 5;
      } else if (var15 >= 50 && var15 <= 60) {
         var13 = 6;
      } else if (var15 >= 61 && var15 <= 65) {
         var13 = 7;
      } else if (var15 >= 66 && var15 <= 72) {
         var13 = 8;
      } else if (var15 >= 73 && var15 <= 90) {
         var13 = 9;
      } else if (var15 >= 91 && var15 <= 92) {
         var13 = 10;
      } else if (var15 >= 93 && var15 <= 101) {
         var13 = 11;
      } else {
         var13 = 4;
      }

      if (j > 0) {
         var13 = j;
      }

      for (int var9 = 0; var9 < 11; var9++) {
         int var10 = GameConstants.sJ[var13][var9];
         Player var11 = a(var5, var10, false, false);
         if (var11 != null) {
            var11.as(var10);
            var11.b(true);
            club.nf.add(var11);
            if (i == 1) {
               c0675.hl().add(var11);
               c0675.hp().add(var11);
            } else if (i == 2) {
               c0675.hm().add(var11);
               c0675.hq().add(var11);
            }

            var5.remove(var11);
         }
      }

      for (int var19 = 0; var19 < GameConstants.sI.length; var19++) {
         Player var21 = a(var5, GameConstants.sI[var19], true, false);
         if (var21 != null) {
            club.ng.add(var21);
            if (i == 1) {
               c0675.hn().add(var21);
            } else if (i == 2) {
               c0675.ho().add(var21);
            }

            var5.remove(var21);
         }
      }

      club.I(true);
      if (bl) {
         byte var20 = 0;
         byte var22 = 0;
         byte var23 = 0;
         var15 = new Random().nextInt(100) + 1;
         if (var15 >= 0 && var15 <= 70) {
            var20 = 0;
         } else if (var15 >= 71 && var15 <= 80) {
            var20 = 1;
         } else if (var15 >= 81 && var15 <= 100) {
            var20 = 2;
         }

         var15 = new Random().nextInt(100) + 1;
         if (var15 >= 1 && var15 <= 5) {
            var22 = 2;
         } else if (var15 >= 6 && var15 <= 70) {
            var22 = 0;
         } else if (var15 >= 71 && var15 <= 100) {
            var22 = 1;
         }

         var15 = new Random().nextInt(100) + 1;
         if (var15 >= 1 && var15 <= 70) {
            var23 = 0;
         } else if (var15 >= 71 && var15 <= 100) {
            var23 = 1;
         }

         int[] var12 = new int[]{var13, var20, var22, var23};
         club.k(var12);
      }
   }

   public static void a(Match c0675, Club club, int i) {
      int[] var3 = new int[26];
      int[] var4 = new int[13];
      int var5 = 0;
      int var6 = 0;
      boolean var7 = false;
      ArrayList var8;
      if (i == 1) {
         var8 = c0675.hl();
      } else {
         var8 = c0675.hm();
      }

      for (int var9 = 0; var9 < var8.size(); var9++) {
         for (int var10 = 0; var10 <= 1; var10++) {
            if (GameConstants.sF[((Player)var8.get(var9)).fT()][var10] > 0) {
               if (((Player)var8.get(var9)).getPosicao() != GameConstants.sE[((Player)var8.get(var9)).fT()][0]) {
                  var6 = (int)Math.round(0.7 * ((Player)var8.get(var9)).fU());
                  if (((Player)var8.get(var9)).fT() == 1) {
                     var5 = (int)Math.round(0.3 * ((Player)var8.get(var9)).fU());
                     var7 = true;
                  }
               } else {
                  var6 = ((Player)var8.get(var9)).fU();
                  if (((Player)var8.get(var9)).fT() == 1) {
                     var5 = ((Player)var8.get(var9)).fU();
                  }
               }

               var4[GameConstants.sF[((Player)var8.get(var9)).fT()][var10]] = var4[GameConstants.sF[((Player)var8.get(var9)).fT()][var10]] + var6;
               var3[((Player)var8.get(var9)).fT()]++;
            }
         }
      }

      int var19 = 0;
      int var20 = 0;
      int var11 = 0;
      int var12 = 0;
      int var13 = 0;

      for (int var14 = 3; var14 <= 8; var14++) {
         if (var3[var14] > 0) {
            var19++;
         }
      }

      for (int var21 = 2; var21 <= 9; var21++) {
         if (var3[var21] > 0) {
            var20++;
         }
      }

      for (int var22 = 11; var22 <= 16; var22++) {
         if (var3[var22] > 0) {
            var11++;
         }
      }

      for (int var23 = 10; var23 <= 17; var23++) {
         if (var3[var23] > 0) {
            var12++;
         }
      }

      for (int var24 = 18; var24 <= 25; var24++) {
         if (var3[var24] > 0) {
            var13++;
         }
      }

      if (var19 != 1 && var20 >= 2) {
         if (var19 == 0 || var7) {
            for (int var27 = 1; var27 <= 12; var27++) {
               var4[var27] = (int)Math.round(var4[var27] * 0.2);
            }
         } else if (var19 > 3) {
            for (int var26 = 1; var26 <= 12; var26++) {
               var4[var26] = (int)Math.round(var4[var26] * 0.7);
            }
         }
      } else {
         for (int var25 = 1; var25 <= 12; var25++) {
            var4[var25] = (int)Math.round(var4[var25] * 0.7);
         }
      }

      if (var11 > 4) {
         for (int var28 = 1; var28 <= 12; var28++) {
            var4[var28] = (int)Math.round(var4[var28] * 0.7);
         }
      }

      if (var13 > 3) {
         for (int var29 = 1; var29 <= 12; var29++) {
            var4[var29] = (int)Math.round(var4[var29] * 0.7);
         }
      }

      if (var12 > 5) {
         for (int var30 = 1; var30 <= 12; var30++) {
            var4[var30] = (int)Math.round(var4[var30] * 0.5);
         }
      }

      var6 = 0;

      for (int var31 = 1; var31 <= 12; var31++) {
         var6 += var4[var31];
      }

      if (i == 1) {
         c0675.aP(var6);
      } else {
         c0675.aQ(var6);
      }
   }

   public static Player a(ArrayList arrayList, int i, boolean bl, boolean bl2) {
      int var4 = GameConstants.sE[i][0];
      int var6 = GameConstants.sE[i][1];
      int var7 = GameConstants.sE[i][2];
      boolean var8 = false;
      boolean var9 = false;
      if (var6 == -1) {
         var9 = true;
      }

      if (var7 == -1) {
         var8 = true;
      }

      if (i >= 18) {
         var7 = -1;
      }

      byte var10 = 4;
      if (bl) {
         var10 = 4;
      }

      for (int var11 = 0; var11 <= var10; var11++) {
         int var5 = GameConstants.sH[var4][var11];

         for (int var12 = 1; var12 <= 3; var12++) {
            for (int var13 = 0; var13 < arrayList.size(); var13++) {
               if (var9) {
                  var6 = ((Player)arrayList.get(var13)).getLado();
               }

               if (var8) {
                  var7 = ((Player)arrayList.get(var13)).fF();
               }

               if (var12 == 2) {
                  var6 = ((Player)arrayList.get(var13)).getLado();
               }

               if (var12 == 3) {
                  var6 = ((Player)arrayList.get(var13)).getLado();
                  var7 = ((Player)arrayList.get(var13)).fF();
               }

               if (var12 == 4) {
                  if (!bl2) {
                     var5 = ((Player)arrayList.get(var13)).getPosicao();
                  } else if (((Player)arrayList.get(var13)).getPosicao() != 0) {
                     var5 = ((Player)arrayList.get(var13)).getPosicao();
                  }
               }

               if (var5 == ((Player)arrayList.get(var13)).getPosicao()
                  && var6 == ((Player)arrayList.get(var13)).getLado()
                  && var7 == ((Player)arrayList.get(var13)).fF()) {
                  return (Player)arrayList.get(var13);
               }
            }
         }
      }

      return null;
   }

   public boolean ki() {
      for (int var1 = 0; var1 < GameConstants.rW.length; var1++) {
         if (GameConstants.rW[var1] == this.pais) {
            return true;
         }
      }

      return false;
   }

   public int gg() {
      return C0696.valueOf("P" + Integer.toString(this.pais)).gg();
   }

   public void u(int i, int j) {
      this.nr[i] = j;
   }

   public int bQ(int i) {
      return this.nr[i];
   }

   public int[] kj() {
      return this.nq;
   }

   public void k(int[] is) {
      this.nq = is;
   }

   public C0704 c(LeagueStage c0955) {
      for (int var2 = 0; var2 < this.no.size(); var2++) {
         if (((C0704)this.no.get(var2)).lC() == c0955) {
            return (C0704)this.no.get(var2);
         }
      }

      return null;
   }

   public int[] d(LeagueStage c0955) {
      int[] var2 = new int[8];

      for (int var3 = 0; var3 < this.no.size(); var3++) {
         if (((C0704)this.no.get(var3)).lC() == c0955) {
            return ((C0704)this.no.get(var3)).lB();
         }
      }

      return var2;
   }

   public void e(LeagueStage c0955) {
      for (int var2 = 0; var2 < this.no.size(); var2++) {
         if (((C0704)this.no.get(var2)).lC() == c0955) {
            ((C0704)this.no.get(var2)).lA();
         }
      }
   }

   public C0703 n(Competition c0713) {
      for (int var2 = 0; var2 < this.np.size(); var2++) {
         if (((C0703)this.np.get(var2)).H() == GamePersistence.SR.H() - 1 && ((C0703)this.np.get(var2)).b() == c0713.b() && ((C0703)this.np.get(var2)).el() == c0713.el()
            )
          {
            return (C0703)this.np.get(var2);
         }
      }

      return null;
   }

   public C0703 a(Competition c0713, int i) {
      for (int var3 = 0; var3 < this.np.size(); var3++) {
         if (((C0703)this.np.get(var3)).H() == GamePersistence.SR.H() && ((C0703)this.np.get(var3)).b() == c0713.b() && ((C0703)this.np.get(var3)).el() == i) {
            return (C0703)this.np.get(var3);
         }
      }

      C0703 var4 = new C0703(c0713, this, i);
      this.np.add(var4);
      return var4;
   }

   public void b(Competition c0713, int i) {
      C0703 var3 = this.n(c0713);
      if (var3 != null) {
         var3.ce(i);
      }
   }

   public void c(Competition c0713, int i, int j) {
      C0703 var4 = this.a(c0713, j);
      if (var4 != null) {
         var4.cd(i);
      }
   }

   public void e(Competition c0713, int i) {
      C0703 var3 = this.a(c0713, c0713.el());
      if (var3 != null) {
         var3.setDivisao(i);
      }
   }

   public void a(Competition c0713, int i, int j) {
      C0703 var4 = this.a(c0713, c0713.el());
      var4.cc(i);
      var4.cd(j);
      if (i <= 10) {
         this.b(c0713, i, j);
         if (this.ka() != null) {
            this.ka().b(c0713, i, j);
         }

         if (this.jZ() && (c0713.b() == 1 || c0713.b() == 3)) {
            this.c(c0713, i);
         }

         if (i == 1) {
            this.q(c0713);
         }
      }
   }

   private void c(Competition c0713, int i) {
      int var3 = 0;
      int var4 = this.getDivisao();
      i--;
      if (c0713.b() != 1 || var4 >= GameConstants.sr.length) {
         if (c0713.b() == 3 && c0713.ip() == 1 && i < GameConstants.su.length) {
            var3 = GameConstants.su[i];
         }
      } else if (i < GameConstants.sr[var4].length) {
         var3 = GameConstants.sr[var4][i];
      }

      if (var3 > 0) {
         this.v(var3, 3);
         if (this.ka() != null && this.ka().jZ() && c0713 != null) {
            new C0799(this.ka(), 26, 80, c0713.getNome(), ClubFinances.c(var3));
         }
      }
   }

   private void d(int i, int j, int k) {
      int[][] var4 = new int[][]{{0, 500, 300, 10, 5000, 40000, 2000, 0, 500, 0, 50, 0, 0, 1000, 0}, {0, 90, 50, 5, 1000, 1000, 500, 0, 0, 0, 0, 0, 0, 500, 0}};
      int var5 = 0;
      if (i < var4.length && j < var4[0].length) {
         var5 = var4[i][j];
      }

      if (var5 > 1000 & !this.mX && this.gg() > 1) {
         var5 = (int)Math.round(var5 * 0.6);
      }

      if (j == 1 && k > 1) {
         var5 = 50;
      }

      this.nu += var5;
      if (this.mZ != null) {
         this.mZ.a(i, j, k, this.mX, this.gg());
      }
   }

   public void kk() {
      byte var1 = 0;
      if (this.nc == 5) {
         this.nu -= 6000;
         if (this.nu < -90000) {
            this.nc = 4;
            this.nu = 0;
         }
      } else if (this.nc == 4) {
         this.nu -= 600;
         if (this.nu < -9000) {
            this.nc = 3;
            this.nu = 0;
         }
      } else if (this.nc == 3 && this.kn()) {
         this.nu -= 50;
         if (this.nu < -1000) {
            this.nc = 2;
            this.nu = 0;
         }
      } else if (this.nc == 2 && this.kn()) {
         this.nu -= 5;
         if (this.nu < -1000) {
            this.nc = 2;
            this.nu = 0;
         }
      }

      if (this.nu > 100000) {
         var1 = 5;
         this.nu = 100001;
      } else if (this.nu > 10000) {
         var1 = 4;
      } else if (this.nu > 1000) {
         var1 = 3;
      } else if (this.nu > 100) {
         var1 = 2;
      } else if (this.nu > 10) {
         var1 = 1;
      }

      if (var1 > this.nc) {
         this.nc = var1;
      }
   }

   private void b(Competition c0713, int i, int j) {
      int var4 = c0713.b();
      int var5 = -1;
      if (var4 == 1) {
         var5 = c0713.ip();
      }

      if (var4 == 7) {
         var5 = c0713.el();
      }

      if (i == 1 || i == 2) {
         this.d(i - 1, var4, var5);
      }

      int[][] var6 = new int[][]{
         new int[11],
         {0, 15, 10, 8, 7, 6, 5, 4, 3, 2, 1},
         {0, 12, 7, 3, 3, 0, 0, 0, 0, 0, 0},
         {0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 20, 15, 7, 7, 3, 3, 0, 0, 0, 0},
         {0, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 12, 10, 5, 5, 0, 0, 0, 0, 0, 0},
         {0, 50, 35, 10, 5, 0, 0, 0, 0, 0, 0},
         {0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         new int[11],
         {0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 10, 8, 4, 4, 0, 0, 0, 0, 0, 0},
         new int[11],
         {0, 15, 10, 5, 0, 0, 0, 0, 0, 0, 0},
         new int[11]
      };
      int[] var7 = var6[var4];
      if (var4 == 7) {
         if (var5 != 7) {
            int[] var8 = new int[]{0, 20, 15, 10, 5, 0, 0, 0, 0, 0, 0};
            var7 = var8;
         }
      } else if (var4 == 1 && c0713.ip() > 1) {
         if (c0713.ip() == 2) {
            int[] var11 = new int[]{0, 5, 3, 2, 1, 0, 0, 0, 0, 0, 0};
            var7 = var11;
         } else {
            int[] var12 = new int[]{0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
            var7 = var12;
         }
      } else if (var4 == 3 && c0713.ip() > 1) {
         int[] var10 = new int[11];
         var7 = var10;
      } else if (var4 == 4 && this.gg() > 1) {
         int[] var9 = new int[]{0, 18, 12, 3, 3, 1, 1, 0, 0, 0, 0};
         var7 = var9;
      }

      if (var4 <= 14 && i >= 0 && i < var7.length) {
         this.nB[var4] = this.nB[var4] + var7[i];
      }
   }

   public void e(Match c0675) {
      if (c0675.hy() != null) {
         int var2 = 0;
         int var3 = 0;
         if (c0675.hc() == this) {
            var2 = c0675.hu();
            var3 = c0675.hw();
         } else if (c0675.hd() == this) {
            var2 = c0675.hw();
            var3 = c0675.hu();
         }

         int var4 = c0675.hy().el();
         if (c0675.ht() != null && c0675.ht() instanceof KnockoutStage && ((KnockoutStage)c0675.ht()).zf() == 1098) {
            var4 = 1098;
         }

         C0703 var5 = this.a(c0675.hy(), var4);
         var5.cl();
         var5.ca(var2);
         this.e(c0675.hy().b(), 1, var2);
         var5.cb(var3);
         this.e(c0675.hy().b(), 2, var3);
         if (var2 > var3) {
            var5.cn();
            this.e(c0675.hy().b(), 0, 3);
         } else if (var2 < var3) {
            var5.cp();
         } else if (var2 == var3) {
            this.e(c0675.hy().b(), 0, 1);
         }
      }
   }

   public void a(Match c0675, LeagueStage c0955) {
      int var3 = 0;
      int var4 = 0;
      int var5 = c0675.ht().b();
      if (var5 < 0 || var5 > 14) {
         boolean var7 = false;
      }

      if (c0675.hc() == this) {
         var3 = c0675.hu();
         var4 = c0675.hw();
      } else if (c0675.hd() == this) {
         var3 = c0675.hw();
         var4 = c0675.hu();
      }

      C0704 var6 = this.c(c0955);
      if (var6 == null) {
         var6 = new C0704(this, c0955);
         this.no.add(var6);
      }

      var6.cl();
      var6.ca(var3);
      var6.cb(var4);
      if (var3 > var4) {
         var6.cn();
         var6.cf(3);
      } else if (var3 < var4) {
         var6.cp();
      } else if (var3 == var4) {
         var6.cf(1);
      }
   }

   public int getEstado() {
      return this.dr;
   }

   public int kl() {
      return this.mY;
   }

   public int iS() {
      return this.hr;
   }

   public void bR(int i) {
      this.hr = i;
   }

   public ArrayList km() {
      return this.no;
   }

   public Boolean kn() {
      return this.mX;
   }

   public boolean ko() {
      CountryCompetitions var1 = GamePersistence.SR.o(this.getPais());
      if (var1 != null) {
         for (int var2 = 0; var2 < var1.eb().size(); var2++) {
            for (int var3 = 0; var3 < ((C0924)var1.eb().get(var2)).yi().yK().size(); var3++) {
               if (((Club)((C0924)var1.eb().get(var2)).yi().yK().get(var3)).equals(this)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void l(Boolean boolean_) {
      this.mX = boolean_;
   }

   public void kp() {
      int[] var1 = this.J(false);
      int[] var2 = new int[]{2, 3, 3, 5, 4};
      this.ks();
      Collections.shuffle(this.nd);

      for (int var3 = 0; var3 <= 4; var3++) {
         if (var1[var3] > var2[var3] && new Random().nextInt(100) > 50) {
            for (int var4 = 0; var4 < this.nd.size(); var4++) {
               if (((Player)this.nd.get(var4)).getPosicao() == var3
                  && ((Player)this.nd.get(var4)).getStatus() == 0
                  && !((Player)this.nd.get(var4)).ff()
                  && !((Player)this.nd.get(var4)).gm()
                  && !((Player)this.nd.get(var4)).gl()) {
                  ((Player)this.nd.get(var4)).fm();
                  ((Player)this.nd.get(var4)).c(true);
                  if (new Random().nextInt(100) > 70 && ((Player)this.nd.get(var4)).fi() < 42) {
                     ((Player)this.nd.get(var4)).g(true);
                  }
                  break;
               }
            }
         }
      }
   }

   public int kq() {
      int var1 = 0;

      for (int var2 = 0; var2 < GamePersistence.SR.bt().size(); var2++) {
         if (((C0825)GamePersistence.SR.bt().get(var2)).x().fg() != null && ((C0825)GamePersistence.SR.bt().get(var2)).tP() == this) {
            var1++;
         }
      }

      return var1;
   }

   public int kr() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.nd.size(); var2++) {
         if (!((Player)this.nd.get(var2)).gl() && ((Player)this.nd.get(var2)).fz()) {
            var1++;
         }
      }

      return var1;
   }

   public void ks() {
      for (int var1 = 0; var1 < this.nd.size(); var1++) {
         ((Player)this.nd.get(var1)).c(false);
         ((Player)this.nd.get(var1)).g(false);
      }
   }

   public int[] kt() {
      int[] var1 = new int[5];

      for (int var2 = 0; var2 < this.nd.size(); var2++) {
         var1[((Player)this.nd.get(var2)).getPosicao()]++;
      }

      return var1;
   }

   public int[] J(boolean bl) {
      int[] var2 = new int[6];

      for (int var3 = 0; var3 < this.nd.size(); var3++) {
         if (bl) {
            var2[((Player)this.nd.get(var3)).getPosicao()]++;
            if (((Player)this.nd.get(var3)).getPosicao() == 3 && ((Player)this.nd.get(var3)).fF() == 1) {
               var2[5]++;
            }
         } else if (!((Player)this.nd.get(var3)).gl()) {
            var2[((Player)this.nd.get(var3)).getPosicao()]++;
            if (((Player)this.nd.get(var3)).getPosicao() == 3 && ((Player)this.nd.get(var3)).fF() == 0) {
               var2[5]++;
            }
         }
      }

      return var2;
   }

   public void ku() {
      int[] var1 = this.J(false);
      int[] var2 = new int[]{2, 3, 3, 5, 3, 2};

      for (int var3 = 0; var3 <= 4; var3++) {
         if (var1[var3] < var2[var3]) {
            int var4 = 5;
            if (this.kn()) {
               var4 = GameConstants.qg[this.getDivisao()];
            } else {
               var4 = GameConstants.qh[this.getReputacao()];
            }

            int[] var5 = new int[]{var3, var4};
            C0730.a(this, var5);
         }
      }
   }

   public Player kv() {
      int[] var1 = this.J(false);
      int[] var2 = new int[]{2, 3, 3, 5, 3, 2};
      ArrayList var3 = null;

      for (int var4 = 0; var4 <= 4; var4++) {
         if (var1[var4] > var2[var4]) {
            if (var3 == null) {
               var3 = new ArrayList();
            }

            var3.add(var4);
         }
      }

      if (var3 != null && var3.size() > 0) {
         Collections.shuffle(var3);
         ArrayList var6 = new ArrayList();

         for (int var5 = 0; var5 < this.nd.size(); var5++) {
            if (!((Player)this.nd.get(var5)).gl() && !((Player)this.nd.get(var5)).ff() && ((Player)this.nd.get(var5)).getPosicao() == (Integer)var3.get(0)) {
               var6.add((Player)this.nd.get(var5));
            }
         }

         if (var6.size() > 0) {
            Collections.shuffle(var6);
            return (Player)var6.get(0);
         }
      }

      return null;
   }

   public int bS(int i) {
      int[] var2 = new int[5];

      for (int var3 = 0; var3 < this.nd.size(); var3++) {
         var2[((Player)this.nd.get(var3)).getPosicao()]++;
      }

      return var2[i];
   }

   public int kw() {
      return this.nd.size();
   }

   public int kx() {
      return this.ne.size();
   }

   public ArrayList ky() {
      return this.ne;
   }

   public Club(C0915 c0915) {
      this.dm = c0915.getNome();
      this.mV = c0915.getFileRef();
      this.mY = c0915.getId();
      this.pais = c0915.getPais();
      this.dr = c0915.getEstado();
      this.setReputacao(c0915.getReputacao());
      this.nm = c0915.getCorF();
      this.nn = c0915.getCorT();
      this.cor1 = c0915.getCor1();
      this.cor2 = c0915.getCor2();
      this.setNivel(c0915.getNivel());
      this.a(c0915.getEstadio(), c0915.getCapacidade());
      Coach var2 = new Coach(c0915.getTecnico());
      var2.cg(c0915.getTecNac());
      this.mZ = var2;
      this.na = var2.lT();
      this.mZ.n(this);
      this.mZ.setReputacao(c0915.getReputacao());
      GamePersistence.SR.a(var2);
      this.nl = c0915.getCorBase();

      for (int var3 = 0; var3 < c0915.getJogadores().size(); var3++) {
         Player var4 = new Player((C0914)c0915.getJogadores().get(var3), false, this);
         GamePersistence.SR.b(var4);
         this.nd.add(var4);
      }

      for (int var5 = 0; var5 < c0915.getJuniores().size(); var5++) {
         Player var6 = new Player((C0914)c0915.getJuniores().get(var5), true, this);
         GamePersistence.SR.c(var6);
         this.ne.add(var6);
      }

      this.kA();
      this.kz();
      GamePersistence.SR.c(this);
   }

   public void kz() {
      if (this.nd.size() > 0) {
         Collections.sort(this.nd, nJ);
         this.nh = (Player)this.nd.get(0);
      }
   }

   public void O(ArrayList arrayList) {
      if (this.kd() == null || !arrayList.contains(this.kd())) {
         this.P(arrayList);
      }
   }

   public void P(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      var2.addAll(arrayList);
      if (var2.size() > 0) {
         Collections.sort(var2, nJ);
         if (((Player)var2.get(0)).fg() == this) {
            this.nh = (Player)var2.get(0);
         }
      }
   }

   public void Q(ArrayList arrayList) {
      if (this.ke() == null || !arrayList.contains(this.ke())) {
         this.R(arrayList);
      }
   }

   public void R(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      var2.addAll(arrayList);
      Player var3 = null;
      if (var2.size() > 0) {
         Collections.sort(var2, C1007.abh);

         for (int var4 = 0; var4 < var2.size(); var4++) {
            if (((Player)var2.get(var4)).getCr1() == 9) {
               var3 = (Player)var2.get(var4);
               break;
            }
         }

         if (var3 == null) {
            for (int var5 = 0; var5 < var2.size(); var5++) {
               if (((Player)var2.get(var5)).getPosicao() != 0) {
                  var3 = (Player)var2.get(var5);
                  break;
               }
            }
         }

         if (var3 == null) {
            for (int var6 = 0; var6 < var2.size(); var6++) {
               if (((Player)var2.get(var6)).getPosicao() != 0) {
                  var3 = (Player)this.nd.get(var6);
                  break;
               }
            }
         }

         if (var3 != null) {
            this.ni = var3;
         }
      }
   }

   public void kA() {
      Player var1 = null;
      if (this.nd.size() > 0) {
         Collections.sort(this.nd, C1007.abh);

         for (int var2 = 0; var2 < this.nd.size(); var2++) {
            if (((Player)this.nd.get(var2)).getStatus() == 1 && ((Player)this.nd.get(var2)).getCr1() == 9) {
               var1 = (Player)this.nd.get(var2);
               break;
            }
         }

         if (var1 == null) {
            for (int var3 = 0; var3 < this.nd.size(); var3++) {
               if (((Player)this.nd.get(var3)).getStatus() == 1 && ((Player)this.nd.get(var3)).getPosicao() != 0) {
                  var1 = (Player)this.nd.get(var3);
                  break;
               }
            }
         }

         if (var1 == null) {
            for (int var4 = 0; var4 < this.nd.size(); var4++) {
               if (((Player)this.nd.get(var4)).getPosicao() != 0) {
                  var1 = (Player)this.nd.get(var4);
                  break;
               }
            }
         }

         if (var1 != null) {
            this.ni = var1;
         }
      }
   }

   public Color kB() {
      if (this.nm == null) {
         this.nm = new Color(
            Integer.valueOf(this.cor1.substring(1, 3), 16), Integer.valueOf(this.cor1.substring(3, 5), 16), Integer.valueOf(this.cor1.substring(5, 7), 16)
         );
      }

      return this.nm;
   }

   public int bT(int i) {
      int[] var2 = new int[10];
      Color var3 = this.kB();
      if (i == 2 || i == 3) {
         var3 = this.kC();
      }

      int var4 = var3.getRGB();
      float[] var5 = new float[3];
      int var6 = var4 >> 16 & 0xFF;
      int var7 = var4 >> 8 & 0xFF;
      int var8 = var4 & 0xFF;
      double var9 = 0.2126 * var6 + 0.7152 * var7 + 0.0722 * var8;
      Color.RGBtoHSB(var6, var7, var8, var5);
      if (var9 < 128.0) {
         var2[0]++;
      } else {
         var2[1]++;
      }

      if (var5[1] < 0.1 && var5[2] > 0.9) {
         var2[8]++;
      } else if (var5[2] < 0.1) {
         var2[9]++;
      } else {
         float var11 = var5[0] * 360.0F;
         if (var11 >= 0.0F && var11 < 30.0F) {
            var2[2]++;
         } else if (var11 >= 30.0F && var11 < 90.0F) {
            var2[3]++;
         } else if (var11 >= 90.0F && var11 < 153.0F) {
            var2[4]++;
         } else if (var11 >= 150.0F && var11 < 210.0F) {
            var2[5]++;
         } else if (var11 >= 210.0F && var11 < 270.0F) {
            var2[6]++;
         } else if (var11 >= 270.0F && var11 < 330.0F) {
            var2[7]++;
         } else {
            var2[2]++;
         }
      }

      byte var12 = -1;
      if (var2[8] > 0) {
         var12 = 1;
      } else if (var2[9] > 0) {
         var12 = 0;
      } else if (var2[2] > 0 || var2[7] > 0) {
         var12 = 2;
      } else if (var2[3] > 0) {
         var12 = 5;
      } else if (var2[4] > 0) {
         var12 = 3;
      } else if (var2[5] > 0 || var2[6] > 0) {
         var12 = 4;
      }

      return var12;
   }

   private String b(Color color) {
      return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
   }

   public void c(Color color) {
      this.nm = color;
      this.cor1 = this.b(color);
   }

   public Color kC() {
      if (this.nn == null) {
         this.nn = new Color(
            Integer.valueOf(this.cor2.substring(1, 3), 16), Integer.valueOf(this.cor2.substring(3, 5), 16), Integer.valueOf(this.cor2.substring(5, 7), 16)
         );
      }

      return this.nn;
   }

   public void d(Color color) {
      this.nn = color;
      this.cor2 = this.b(color);
   }

   public ArrayList kD() {
      return this.nw;
   }

   public boolean A(Club club) {
      return this.nw.contains(club);
   }

   public int[] p(Competition c0713) {
      int[] var2 = new int[3];
      int var3 = -1;
      int var4 = 0;
      int var5 = 0;
      byte var6 = 0;
      int var7 = 0;
      if (c0713 != null && (c0713.b() == 1 || c0713.b() == 3)) {
         LeagueStage var8 = null;
         if (c0713 instanceof C0924) {
            var8 = ((C0924)c0713).yi();
         } else if (c0713 instanceof C0951) {
            var8 = ((C0951)c0713).yi();
         }

         var3 = var8.P(this);
         var4 = var8.yK().size();
         var5 = var8.getnRebaixados();
         var6 = 4;
         if (c0713.b() == 3) {
            var6 = 2;
         }
      }

      if (var3 == -1) {
         var2[2] = -1;
      } else {
         byte var10 = 0;
         if (var4 < 20) {
            var10 = 2;
         } else {
            var10 = 4;
         }

         if (var3 == 1) {
            var7 = var3;
         } else if (var3 > var4 - var5) {
            var7 = 5;
         } else if (var3 <= var6) {
            var7 = 2;
         } else if (var3 > var4 - (var5 + var10)) {
            var7 = 4;
         } else {
            var7 = 3;
         }

         var2[0] = var3;
         var2[1] = var7;
      }

      return var2;
   }

   public Coach kE() {
      Coach var1 = null;
      this.ka().lN();
      var1 = GamePersistence.SR.a(this, 0);
      if (var1 == null) {
         var1 = GamePersistence.SR.a(this, 1);
      }

      if (var1 == null && this.nc <= 3) {
         var1 = GamePersistence.SR.a(this, 2);
      }

      if (var1 == null && this.ka().jZ()) {
         var1 = GamePersistence.SR.a(this, -1);
      }

      if (var1 == null && this.ka().jZ()) {
         var1 = GamePersistence.SR.bh();
      }

      if (var1 == null && !this.ka().jZ()) {
         ArrayList var2 = GamePersistence.afQ.b(this.ka(), false);
         Coach var3 = null;
         if (var2.size() > 0) {
            var1 = ((Club)var2.get(0)).ka();
            var3 = this.ka();
         }

         if (var1 != null && var3 != null && var1 != var3) {
            GamePersistence.SR.a(var1, var3);
         }
      } else if (var1 != null && var1 != this.ka()) {
         GamePersistence.SR.a(this, this.ka(), var1);
      }

      return var1;
   }

   public C0924 kF() {
      CountryCompetitions var1 = GamePersistence.SR.o(this.pais);
      if (var1 != null) {
         for (int var2 = 0; var2 < var1.eb().size(); var2++) {
            for (int var3 = 0; var3 < ((C0924)var1.eb().get(var2)).yi().yK().size(); var3++) {
               if (((C0924)var1.eb().get(var2)).yi().yK().get(var3) == this) {
                  return (C0924)var1.eb().get(var2);
               }
            }
         }

         if (var1.eb().size() > 0) {
            return (C0924)var1.eb().get(0);
         }
      }

      return null;
   }

   public void v(int i, int j) {
      this.nb += i;
      if (this.nx != null && this.jZ()) {
         this.nx.h(i, j);
      }
   }

   public void w(int i, int j) {
      this.nb -= i;
      if (this.nx != null && this.jZ()) {
         this.nx.i(i, j);
      }
   }

   public void f(long l) {
      this.nb -= l;
      if (this.nx != null && this.jZ()) {
         this.nx.b(l);
      }
   }

   public void kG() {
      if (this.pais != 29 && GamePersistence.SR.isJogaEstadual()) {
         this.nb = (long)(this.nb + 3.2 * this.kK());
      }

      if (this.divisao >= 0 & this.divisao <= 4) {
         this.v(GameConstants.sD[this.divisao][0], 6);
      }
   }

   public void kH() {
      int var1 = this.divisao;
      this.nb = GameConstants.sC[var1][0];
      if (this.pais != 29 && GamePersistence.SR.isJogaEstadual()) {
         this.nb = (long)(this.nb + 3.2 * this.kK());
      }

      this.nx.h(GameConstants.sD[this.divisao][0], 6);
   }

   public void kI() {
      if (this.nx != null) {
         this.nx.eA();
      }
   }

   public void kJ() {
      this.f(this.kK());
   }

   public long kK() {
      long var1 = 0L;

      for (int var3 = 0; var3 < this.nd.size(); var3++) {
         var1 += ((Player)this.nd.get(var3)).fj();
      }

      for (int var4 = 0; var4 < this.ne.size(); var4++) {
         var1 += ((Player)this.ne.get(var4)).fj();
      }

      return var1;
   }

   public ClubFinances kL() {
      return this.nx;
   }

   public void kM() {
      this.nG = this.bU(1);
      this.nH = this.bU(2);
      this.nI = this.bU(3);
   }

   public ImageIcon[] kN() {
      return new ImageIcon[]{this.nG, this.nH, this.nI};
   }

   public ImageIcon bU(int i) {
      if (i >= 1 && i <= 3) {
         ImageIcon var2 = null;
         if (i == 1) {
            var2 = this.nG;
         } else if (i == 2) {
            var2 = this.nH;
         } else if (i == 3) {
            var2 = this.nI;
         }

         if (var2 != null) {
            return var2;
         }

         if (this.mV != null) {
            BufferedImage var3 = null;
            File var4 = new File(System.getProperty("user.dir") + GameConstants.tw[i - 1] + this.mV + ".png");
            if (var4.exists() && !var4.isDirectory()) {
               try {
                  var3 = ImageIO.read(new File(System.getProperty("user.dir") + GameConstants.tw[i - 1] + this.mV + ".png"));
               } catch (IOException var8) {
                  var8.printStackTrace();
               }

               if (var3 != null) {
                  var2 = new ImageIcon(var3);
               }
            }
         } else {
            String var9 = C0696.valueOf("P" + this.getPais()).jA();
            BufferedImage var11 = null;
            File var5 = new File(System.getProperty("user.dir") + GameConstants.ty[i - 1] + var9 + ".png");
            if (var5.exists() && !var5.isDirectory()) {
               try {
                  var11 = ImageIO.read(new File(System.getProperty("user.dir") + GameConstants.ty[i - 1] + var9 + ".png"));
               } catch (IOException var7) {
                  var7.printStackTrace();
               }

               if (var11 != null) {
                  var2 = new ImageIcon(var11);
               }
            }
         }

         if (var2 == null && i < 3) {
            int var10 = this.bT(i);
            if (var10 == 2) {
               var2 = new ImageIcon(this.getClass().getResource("/acamisas/vermelho.png"));
            } else if (var10 == 3) {
               var2 = new ImageIcon(this.getClass().getResource("/acamisas/verde.png"));
            } else if (var10 == 4) {
               var2 = new ImageIcon(this.getClass().getResource("/acamisas/azul.png"));
            } else if (var10 == 5) {
               var2 = new ImageIcon(this.getClass().getResource("/acamisas/amarelo.png"));
            } else if (var10 == 0) {
               var2 = new ImageIcon(this.getClass().getResource("/acamisas/preto.png"));
            } else if (var10 == 1) {
               var2 = new ImageIcon(this.getClass().getResource("/acamisas/branco.png"));
            }
         }

         return var2;
      } else {
         return null;
      }
   }

   public int a(BufferedImage bufferedImage) {
      int[] var2 = new int[9];
      int[][] var3 = new int[bufferedImage.getWidth()][bufferedImage.getHeight()];

      for (int var4 = 0; var4 < bufferedImage.getWidth(); var4++) {
         for (int var5 = 0; var5 < bufferedImage.getHeight(); var5++) {
            int var6 = bufferedImage.getRGB(var4, var5);
            float[] var7 = new float[3];
            int var8 = var6 >> 16 & 0xFF;
            int var9 = var6 >> 8 & 0xFF;
            int var10 = var6 & 0xFF;
            Color.RGBtoHSB(var8, var9, var10, var7);
            if (var7[1] < 0.1 && var7[2] > 0.9) {
               var2[0]++;
            } else if (var7[2] < 0.1) {
               var2[1]++;
            } else {
               float var11 = var7[0] * 360.0F;
               if (var11 >= 0.0F && var11 < 30.0F) {
                  var2[2]++;
               } else if (var11 >= 30.0F && var11 < 90.0F) {
                  var2[3]++;
               } else if (var11 >= 90.0F && var11 < 150.0F) {
                  var2[4]++;
               } else if (var11 >= 150.0F && var11 < 210.0F) {
                  var2[5]++;
               } else if (var11 >= 210.0F && var11 < 270.0F) {
                  var2[6]++;
               } else if (var11 >= 270.0F && var11 < 330.0F) {
                  var2[7]++;
               } else {
                  var2[8]++;
               }
            }
         }
      }

      return -1;
   }

   public String kO() {
      File var1 = new File(System.getProperty("user.dir") + "/teams/escudos/" + this.mV + ".png");
      return var1.exists() && !var1.isDirectory() ? var1.toString() : "";
   }

   public ImageIcon kP() {
      return this.L(false);
   }

   public ImageIcon K(boolean bl) {
      return this.L(true);
   }

   public ImageIcon L(boolean bl) {
      if (this.nF != null) {
         return this.nF;
      }

      if (this.mV != null) {
         BufferedImage var2 = null;
         File var3 = new File(System.getProperty("user.dir") + "/teams/escudos/" + this.mV + ".png");
         if (var3.exists() && !var3.isDirectory()) {
            try {
               var2 = ImageIO.read(new File(System.getProperty("user.dir") + "/teams/escudos/" + this.mV + ".png"));
            } catch (IOException var8) {
               var8.printStackTrace();
            }

            if (var2 != null) {
               this.nF = new ImageIcon(var2);
            }
         }
      } else {
         String var9 = C0696.valueOf("P" + this.getPais()).jA();
         BufferedImage var10 = null;
         File var4 = new File(System.getProperty("user.dir") + "/selecoes/escudos/" + var9 + ".png");
         if (var4.exists() && !var4.isDirectory()) {
            try {
               var10 = ImageIO.read(new File(System.getProperty("user.dir") + "/selecoes/escudos/" + var9 + ".png"));
            } catch (IOException var7) {
               var7.printStackTrace();
            }

            if (var10 != null) {
               this.nF = new ImageIcon(var10);
            }
         } else {
            String var5 = C0696.valueOf("P" + this.getPais()).jA();
            ImageIcon var6 = new ImageIcon(this.getClass().getResource("/aflags/" + this.getPais() + ".png"));
            if (bl) {
               var6 = new ImageIcon(this.getClass().getResource("/aflagslarge/flag_" + this.getPais() + ".png"));
            }

            this.nF = var6;
         }
      }

      return this.nF;
   }

   private void kQ() {
      if (this.mV != null) {
         BufferedImage var1 = null;
         File var2 = new File(System.getProperty("user.dir") + "/teams/escudosMini/" + this.mV + ".png");
         if (var2.exists() && !var2.isDirectory()) {
            try {
               var1 = ImageIO.read(new File(System.getProperty("user.dir") + "/teams/escudosMini/" + this.mV + ".png"));
            } catch (IOException var4) {
               var4.printStackTrace();
            }

            if (var1 != null) {
               this.nE = new ImageIcon(var1);
            }
         } else {
            this.kR();
         }
      } else {
         String var5 = C0696.valueOf("P" + this.getPais()).jA();
         ImageIcon var6 = new ImageIcon(this.getClass().getResource("/aflags/" + this.getPais() + ".png"));
         this.nE = var6;
      }
   }

   private void kR() {
      ImageIcon var1 = this.kP();
      if (var1 != null) {
         BufferedImage var2 = new BufferedImage(var1.getIconWidth(), var1.getIconHeight(), 2);
         Graphics2D var3 = var2.createGraphics();
         var1.paintIcon(null, var3, 0, 0);
         var3.dispose();
         BufferedImage var4 = new BufferedImage(18, 18, 2);
         Graphics2D var5 = var4.createGraphics();
         var5.drawImage(var2, 0, 0, 18, 18, null);
         var5.setComposite(AlphaComposite.Src);
         ImageIcon var6 = new ImageIcon(var4);
         this.nE = var6;
      }
   }

   public ImageIcon kS() {
      ImageIcon var1 = new ImageIcon(this.getClass().getResource("/aicons/camisat.png"));
      ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aicons/camisar.png"));
      ImageIcon var3 = var1;
      if (this.nA == 0) {
         var3 = this.bU(1);
         if (var3 == null) {
            var3 = var1;
         }
      } else if (this.nA == 1) {
         var3 = this.bU(2);
         if (var3 == null) {
            var3 = var2;
         }
      } else if (this.nA == 2) {
         var3 = this.bU(3);
         if (var3 == null) {
            var3 = var2;
         }
      }

      return var3;
   }

   public ImageIcon kT() {
      Image var1 = this.kS().getImage();
      BufferedImage var2 = new BufferedImage(40, 40, 2);
      Graphics2D var3 = var2.createGraphics();
      var3.drawImage(var1, 0, 0, 40, 40, null);
      var3.setComposite(AlphaComposite.Src);
      return new ImageIcon(var2);
   }

   public ImageIcon x(int i, int j) {
      return this.b(i, j, false);
   }

   public ImageIcon a(int i, int j, boolean bl) {
      return this.b(i, j, bl);
   }

   public ImageIcon b(int i, int j, boolean bl) {
      ImageIcon var4 = this.K(bl);
      if (var4 != null) {
         BufferedImage var5 = new BufferedImage(var4.getIconWidth(), var4.getIconHeight(), 2);
         Graphics2D var6 = var5.createGraphics();
         var4.paintIcon(null, var6, 0, 0);
         var6.dispose();
         BufferedImage var7 = new BufferedImage(i, j, 2);
         Graphics2D var8 = var7.createGraphics();
         var8.drawImage(var5, 0, 0, i, j, null);
         var8.setComposite(AlphaComposite.Src);
         return new ImageIcon(var7);
      } else {
         return null;
      }
   }

   public ImageIcon kU() {
      if (this.nE != null) {
         return this.nE;
      }

      this.kQ();
      return this.nE;
   }

   public void b(String string, int i) {
      if (this.mZ != null) {
         this.mZ.lN();
         this.mZ.n(null);
      }

      Coach var3 = new Coach(string);
      var3.cg(i);
      var3.k(true);
      this.mZ = var3;
      this.na = this.mZ.lT();
      this.mZ.n(this);
      this.mZ.setReputacao(this.nc);
      this.k(true);
      this.ks();
      new C0799(this.mZ, 0, 73, this.getNome(), "");
      GamePersistence.SR.a(var3);
      GamePersistence.SR.M().add(var3);
      GamePersistence.SR.aN().add(this);
   }

   public ArrayList kV() {
      return this.ny;
   }

   public int kW() {
      return this.nA;
   }

   public void bV(int i) {
      this.nA = i;
   }

   public void a(LineupPreset lineupPreset) {
      this.nz = lineupPreset;
   }

   public LineupPreset kX() {
      return this.nz;
   }

   public ArrayList kY() {
      return this.nf;
   }

   public ArrayList kZ() {
      return this.ng;
   }

   @Override
   public String toString() {
      return this.getNome();
   }

   public int[] la() {
      return this.nB;
   }

   public int lb() {
      int var1 = 0;

      for (int var2 = 1; var2 <= 14; var2++) {
         var1 += this.nB[var2];
      }

      return var1;
   }

   public int[][] lc() {
      return this.nC;
   }

   public int[] ld() {
      int[] var1 = new int[3];

      for (int var2 = 1; var2 <= 14; var2++) {
         var1[0] += this.nC[var2][0];
         var1[1] += this.nC[var2][1];
         var1[2] += this.nC[var2][2];
      }

      return var1;
   }

   public void e(int i, int j, int k) {
      if (i <= 14) {
         this.nC[i][j] = this.nC[i][j] + k;
      }
   }

   public ArrayList le() {
      return this.np;
   }

   public void q(Competition c0713) {
      C0708 var2 = new C0708();
      var2.k(GamePersistence.SR.H());
      var2.C(this.lk());
      var2.a(c0713.b());
      var2.m(c0713);
      if (c0713.b() == 1 || c0713.b() == 3) {
         var2.R(c0713.ip());
      } else if (c0713.b() == 11) {
         var2.R(this.pais);
      } else {
         var2.R(c0713.gg());
      }

      this.cA.add(var2);
   }

   public int lf() {
      return this.nD;
   }

   public void bW(int i) {
      this.nD = i;
   }

   public ArrayList cT() {
      return this.cA;
   }

   public void lg() {
      this.nx = new ClubFinances();
      this.kH();
   }

   public boolean a(Player player, boolean bl) {
      if (this.nd.size() >= 35) {
         return false;
      }

      if (this.kn()) {
         if (player.fi() < GameConstants.qg[this.getDivisao()]) {
            return false;
         }
      } else if (player.fi() < GameConstants.qh[this.getReputacao()]) {
         return false;
      }

      if (player.fi() > GameConstants.qi[this.getReputacao()]) {
         return false;
      }

      if (bl) {
         int[] var3 = this.J(false);
         if (player.getPosicao() == 0 && var3[0] > 3) {
            return false;
         }

         if (player.getPosicao() == 1 && var3[1] > 5) {
            return false;
         }

         if (player.getPosicao() == 2 && var3[2] > 5) {
            return false;
         }

         if (player.getPosicao() == 3 && var3[3] > 10) {
            return false;
         }

         if (player.getPosicao() == 4 && var3[4] > 5) {
            return false;
         }
      }

      return true;
   }

   public boolean lh() {
      return this.nd.size() >= 35;
   }

   public boolean b(Player player, boolean bl) {
      if (this.nd.size() >= 35) {
         return false;
      }

      if (this.kn()) {
         if (player.fi() < GameConstants.qg[this.getDivisao()]) {
            return false;
         }
      } else if (player.fi() < GameConstants.qh[this.getReputacao()]) {
         return false;
      }

      return true;
   }

   public int li() {
      return this.nl;
   }

   public void S(ArrayList arrayList) {
      this.ne = arrayList;
   }

   public int gD() {
      return this.ei;
   }

   public void az(int i) {
      this.ei = i;
   }

   public void a(C0788 c0788, Competition c0713) {
      for (int var3 = 0; var3 < this.no.size(); var3++) {
         if (((C0704)this.no.get(var3)).lC().equals(c0713)) {
            ((C0704)this.no.get(var3)).a(c0788);
         }
      }
   }

   public void lj() {
      for (int var1 = 0; var1 < 5; var1++) {
         this.u(var1, 1 + new Random().nextInt(3));
      }
   }

   public int lk() {
      return this.mU;
   }

   public void bX(int i) {
      this.mU = i;
   }

   public boolean bY(int i) {
      for (int var2 = 0; var2 < GamePersistence.SR.R().size(); var2++) {
         if (((C0693)GamePersistence.SR.R().get(var2)).a().get(2) == i && ((C0693)GamePersistence.SR.R().get(var2)).a(this)) {
            return true;
         }
      }

      return false;
   }

   public boolean ll() {
      return this.nt;
   }

   public void M(boolean bl) {
      this.nt = bl;
   }

   public int lm() {
      return this.ns;
   }

   public void bZ(int i) {
      this.ns = i;
   }

   public void ln() {
      if (this.nm != null) {
         String var1 = String.format("#%02x%02x%02x", this.nm.getRed(), this.nm.getGreen(), this.nm.getBlue());
         this.cor1 = var1;
      }
   }

   public void lo() {
      if (this.nn != null) {
         String var1 = String.format("#%02x%02x%02x", this.nn.getRed(), this.nn.getGreen(), this.nn.getBlue());
         this.cor2 = var1;
      }
   }

   public boolean lp() {
      for (int var1 = 0; var1 < GamePersistence.SR.aG().size(); var1++) {
         if (((CountryCompetitions)GamePersistence.SR.aG().get(var1)).jn() == this) {
            return true;
         }
      }

      return false;
   }

   public Player lq() {
      if (this.nj != null && this.nj.fg() != this) {
         if (!this.lp()) {
            this.nj = null;
         } else if (!this.kc().contains(this.nj)) {
            this.nj = null;
         }
      }

      return this.nj;
   }

   public void n(Player player) {
      this.nj = player;
   }

   public Player lr() {
      if (this.nk != null && this.nk.fg() != this) {
         if (!this.lp()) {
            this.nk = null;
         } else if (!this.kc().contains(this.nk)) {
            this.nk = null;
         }
      }

      return this.nk;
   }

   public void o(Player player) {
      this.nk = player;
   }

   public int Au() {
      return this.Kb;
   }

   public void fr(int i) {
      this.Kb = i;
   }
}
