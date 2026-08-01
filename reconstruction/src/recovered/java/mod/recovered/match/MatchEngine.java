package mod.recovered.match;

import bf22.intermediary.*;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Random;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class MatchEngine {
   private static final double[] SW = new double[]{44.55, 23.86, 7.4};
   private static final double[] SX = new double[]{30.69, 18.35, 12.99};
   private static final double[] SY = new double[]{7.8, 45.78, 53.52};
   private static final double[] SZ = new double[]{10.8, 43.78, 53.52};
   private static final double[] Ta = new double[]{13.2, 36.78, 44.52};
   private static final double[] Tb = new double[]{7.8, 37.78, 45.52};
   private static final double[] Tc = new double[]{5.8, 37.78, 45.52};
   private static final double[] Td = new double[]{2.8, 37.78, 45.52};
   private static final double[] Te = new double[]{1.8, 45.78, 53.52};
   private static final double[] Tf = new double[]{1.0, 55.78, 63.52};
   private static final double[] Tg = new double[]{55.0, 45.0};
   private static final double[] Th = new double[]{50.0, 50.0};
   private static final double Ti = 4.15;
   private static final double Tj = 3.81;
   private static final double Tk = 1.0;
   private static final double Tl = 10.0;
   private static final double Tm = 18.0;
   private Random Tn = new Random();
   private Random To = new Random();
   private C0963 Tp = new C0963();
   private static final double Tq = 3.0;
   private static final double Tr = 5.0;
   private static final double Ts = 5.0;
   private static final double Tt = 3.0;
   private static final double Tu = 24.0;
   private static final double Tv = 20.0;
   private static final double Tw = 12.0;
   public static final double[][] Tx = new double[][]{
      {-1.0, -1.0, -1.0},
      {-1.0, -1.0, -1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {8.0, 8.0, 8.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {8.0, 8.0, 8.0},
      {8.0, 8.0, 8.0},
      {8.0, 8.0, 8.0},
      {8.0, 8.0, 8.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0}
   };
   public static final double[][] Ty = new double[][]{
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {10.0, 10.0, 10.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {20.0, 20.0, 20.0},
      {20.0, 20.0, 20.0},
      {20.0, 20.0, 20.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0}
   };
   public static final double[][] Tz = new double[][]{
      {-1.0, -1.0, -1.0},
      {1.0, 1.0, 1.0},
      {5.0, 5.0, 5.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {5.0, 5.0, 5.0},
      {1.0, 1.0, 1.0},
      {5.0, 5.0, 5.0},
      {5.0, 5.0, 5.0},
      {5.0, 5.0, 5.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0}
   };
   private Match zz = null;
   private Club[] TA = null;
   private int TB = 0;
   private int TC = 0;
   private boolean TD = false;
   Player TE = null;
   private double TF = 0.0;
   private int[] zA = new int[2];
   private int[] TG = new int[2];
   private int[] TH = new int[2];
   private int[] TI = new int[2];
   private int[] TJ = new int[2];
   private int[] TK = new int[2];
   private int[] TL = new int[2];
   private int[] TM = new int[2];
   private int[] TN = new int[2];
   private int[] TO = new int[2];
   private int[] TP = new int[2];
   private int[] fX = new int[2];
   private int[] TQ = new int[2];
   private int[] TR = new int[2];
   private int[] TS = new int[3];
   private int[] TT = new int[26];
   private static final double[] TU = new double[]{5.5, 35.55, 15.0};
   private static final double[] TV = new double[]{4.5, 40.55, 15.0};
   private static final double[] TW = new double[]{3.0, 40.55, 15.0};
   private static final double[] TX = new double[]{0.5, 40.55, 15.0};
   int[] TY = new int[]{1, 22, 24, 11, 13, 14, 16, 2, 9, 3, 5};

   public int vN() {
      boolean var1 = this.Tn.nextBoolean();
      return var1 ? 0 : 1;
   }

   public MatchEngine(Match c0675) {
      this.zz = c0675;
      Club[] var2 = new Club[]{c0675.hc(), c0675.hd()};
      this.TA = var2;
      this.TB = this.vN();
      this.TD = c0675.hX();
      if (c0675.hp().size() == 0) {
         System.out.println("erro escala: " + c0675.hc().getNome());
         GamePersistence.careerState.bN = true;
         Club.a(c0675.hc(), c0675, 1, -1, true);
      }

      if (c0675.hq().size() == 0) {
         System.out.println("erro escala: " + c0675.hd().getNome());
         GamePersistence.careerState.bN = true;
         Club.a(c0675.hd(), c0675, 1, -1, true);
      }

      for (int var3 = 0; var3 < c0675.hl().size(); var3++) {
         ((Player)c0675.hl().get(var3)).fe();
      }

      for (int var4 = 0; var4 < c0675.hm().size(); var4++) {
         ((Player)c0675.hm().get(var4)).fe();
      }

      for (int var5 = 0; var5 < c0675.hn().size(); var5++) {
         ((Player)c0675.hn().get(var5)).fe();
      }

      for (int var6 = 0; var6 < c0675.ho().size(); var6++) {
         ((Player)c0675.ho().get(var6)).fe();
      }
   }

   public MatchEngine() {
   }

   public C0667 vO() {
      C0667 var1 = null;
      this.TC++;
      int var2 = this.vR();
      if (var2 == this.TB) {
         if (this.vS() == 0) {
            this.zz.hA()[this.TB]++;
            var1 = this.vT();
         } else if (this.To.nextInt(100) < 50) {
            this.zz.hB()[this.vQ()]++;
         } else {
            this.zz.hC()[this.TB]++;
         }
      } else if (this.To.nextInt(100) < 50) {
         this.zz.hB()[this.vQ()]++;
      } else {
         this.zz.hC()[this.TB]++;
      }

      this.vP();
      return var1;
   }

   private void vP() {
      if (this.TB == 1) {
         this.TB = 0;
      } else if (this.TB == 0) {
         this.TB = 1;
      }
   }

   private int vQ() {
      return this.TB == 1 ? 0 : 1;
   }

   private double ez(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.zz.hp();
      } else {
         var2 = this.zz.hq();
      }

      int var3 = this.TA[i].kj()[2];
      double[] var4 = new double[]{0.0, 0.04, 0.08};
      if (var3 >= var4.length) {
         var3 = 2;
      }

      double var5 = 0.0 + var4[var3];
      int var7 = 0;
      double var8 = 0.1;

      for (int var10 = 0; var10 < var2.size(); var10++) {
         if (var7 < 5 && ((Player)var2.get(var10)).fT() >= 10 && ((Player)var2.get(var10)).fT() <= 17) {
            var5 += this.B((Player)var2.get(var10));
            var7++;
         }
      }

      var8 = var5 / 5.0;
      if (var7 < 3) {
         var8 = 0.01;
      }

      return var8;
   }

   private double eA(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.zz.hp();
      } else {
         var2 = this.zz.hq();
      }

      double var3 = 0.0;
      int var5 = 0;
      double var6 = 0.1;

      for (int var8 = 0; var8 < var2.size(); var8++) {
         if (var5 < 3 && ((Player)var2.get(var8)).fT() >= 19 && ((Player)var2.get(var8)).fT() <= 25) {
            var3 += this.B((Player)var2.get(var8));
            var5++;
         }
      }

      var6 = var3 / 3.0;
      if (var5 < 1) {
         var6 = 0.0;
      }

      return var6;
   }

   private double eB(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.zz.hp();
      } else {
         var2 = this.zz.hq();
      }

      Player var3 = null;
      double var4 = 0.1;

      for (int var6 = 0; var6 < var2.size(); var6++) {
         if (((Player)var2.get(var6)).fT() == 1) {
            var3 = (Player)var2.get(var6);
            var4 = this.B((Player)var2.get(var6));
            break;
         }
      }

      if (var3 != null && var3.gF()) {
         var4 = (int)Math.round(var4 * 0.2);
      }

      return var4;
   }

   private double eC(int i) {
      double var2 = 0.1;
      this.TE = this.vU();
      if (this.TE != null) {
         var2 = this.B(this.TE);
      }

      return var2;
   }

   private int eD(int i) {
      ArrayList var2 = null;
      int var3 = 0;
      if (i == 0) {
         var2 = this.zz.hp();
      } else {
         var2 = this.zz.hq();
      }

      for (int var4 = 0; var4 < var2.size(); var4++) {
         if (((Player)var2.get(var4)).fT() >= 3 && ((Player)var2.get(var4)).fT() <= 8) {
            var3++;
         }
      }

      return var3;
   }

   private double eE(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.zz.hp();
      } else {
         var2 = this.zz.hq();
      }

      double var3 = 0.0;
      int var5 = 0;
      double var6 = 0.1;

      for (int var8 = 0; var8 < var2.size(); var8++) {
         if (var5 < 5 && ((Player)var2.get(var8)).fT() >= 2 && ((Player)var2.get(var8)).fT() <= 9) {
            var3 += this.B((Player)var2.get(var8));
            var5++;
         }
      }

      var6 = var3 / 5.0;
      if (var5 < 3) {
         var6 = 0.01;
      }

      return var6;
   }

   public double B(Player player) {
      int var2 = player.fi();
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = 0;
         if (player.fT() == 1) {
            var2 += (int)Math.round(player.gK() * 0.6);
            var2 += (int)Math.round(player.gL() * 0.15);
            var2 += (int)Math.round(player.gJ() * 0.15);
            var2 += (int)Math.round(player.gM() * 0.1);
         } else if (player.fT() >= 3 && player.fT() <= 8) {
            var2 += (int)Math.round(player.gN() * 0.5);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gM() * 0.1);
            var2 += (int)Math.round(player.gO() * 0.05);
         } else if (player.fT() == 2 || player.fT() == 9) {
            var2 += (int)Math.round(player.gN() * 0.4);
            var2 += (int)Math.round(player.gJ() * 0.1);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gM() * 0.3);
            var2 += (int)Math.round(player.gO() * 0.05);
            var2 += (int)Math.round(player.gP() * 0.05);
         } else if (player.fT() >= 11 && player.fT() <= 13) {
            var2 += (int)Math.round(player.gN() * 0.4);
            var2 += (int)Math.round(player.gJ() * 0.15);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gM() * 0.2);
            var2 += (int)Math.round(player.gO() * 0.1);
            var2 += (int)Math.round(player.gP() * 0.05);
         } else if (player.fT() >= 14 && player.fT() <= 16) {
            var2 += (int)Math.round(player.gN() * 0.05);
            var2 += (int)Math.round(player.gJ() * 0.1);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gM() * 0.25);
            var2 += (int)Math.round(player.gO() * 0.4);
            var2 += (int)Math.round(player.gP() * 0.1);
         } else if (player.fT() == 10 || player.fT() == 17) {
            var2 += (int)Math.round(player.gN() * 0.05);
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gL() * 0.15);
            var2 += (int)Math.round(player.gM() * 0.25);
            var2 += (int)Math.round(player.gO() * 0.2);
            var2 += (int)Math.round(player.gP() * 0.1);
         } else if (player.fT() >= 19 && player.fT() <= 24) {
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gL() * 0.25);
            var2 += (int)Math.round(player.gM() * 0.05);
            var2 += (int)Math.round(player.gO() * 0.05);
            var2 += (int)Math.round(player.gP() * 0.4);
         } else if (player.fT() == 18 || player.fT() == 25) {
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gL() * 0.15);
            var2 += (int)Math.round(player.gM() * 0.15);
            var2 += (int)Math.round(player.gO() * 0.05);
            var2 += (int)Math.round(player.gP() * 0.4);
         }
      }

      if (player.gF()) {
         var2 = (int)Math.round(var2 * 0.5);
      }

      if (var2 <= 0) {
         var2 = 1;
      }

      if (this.zz != null && this.zz.hy().b() == 7) {
         if (this.zz.hc() != null && player.getPais() == this.zz.hc().getPais()) {
            if (this.zz.hc().getReputacao() < 3) {
               var2 = (int)Math.round(var2 * 0.65);
            } else if (this.zz.hc().getReputacao() == 3) {
               var2 = (int)Math.round(var2 * 0.85);
            } else if (this.zz.hc().getReputacao() == 4) {
               var2 = (int)Math.round(var2 * 0.95);
            }
         } else if (this.zz.hd() != null && player.getPais() == this.zz.hd().getPais()) {
            if (this.zz.hd().getReputacao() < 3) {
               var2 = (int)Math.round(var2 * 0.65);
            } else if (this.zz.hd().getReputacao() == 3) {
               var2 = (int)Math.round(var2 * 0.85);
            } else if (this.zz.hd().getReputacao() == 4) {
               var2 = (int)Math.round(var2 * 0.95);
            }
         }
      }

      if (this.zz != null && this.zz.hy().b() == 4) {
         if (player.fg() != null && player.fg().getReputacao() < 3) {
            var2 = (int)Math.round(var2 * 0.75);
         } else if (player.fg() != null && player.fg().getReputacao() == 3) {
            var2 = (int)Math.round(var2 * 0.85);
         } else if (player.fg() != null && player.fg().getPais() == 29) {
            var2 = (int)Math.round(var2 * 0.9);
         }
      }

      if (this.zz != null && this.zz.hy().b() == 5) {
         if (player.fg() != null && player.fg().getReputacao() < 3) {
            var2 = (int)Math.round(var2 * 0.55);
         } else if (player.fg() != null && player.fg().getReputacao() == 3) {
            var2 = (int)Math.round(var2 * 0.75);
         } else if (player.fg() != null && player.fg().gg() != 0) {
            var2 = (int)Math.round(var2 * 0.9);
         }
      }

      if (this.zz != null && this.zz.hy().b() == 1) {
         if (player.fg() != null && player.fg().getReputacao() < 3) {
            var2 = (int)Math.round(var2 * 0.85);
         } else if (player.fg() != null && player.fg().getReputacao() == 3) {
            var2 = (int)Math.round(var2 * 0.95);
         }
      }

      if (this.zz != null
         && (this.zz.hy().b() == 3 || this.zz.hy().b() == 2)
         && this.zz.hc().getReputacao() < 3
         && this.zz.hd().getReputacao() >= 3
         && player.fg() != null
         && player.fg().equals(this.zz.hd())) {
         var2 = (int)Math.round(var2 * 0.8);
      }

      return var2 / 10.0;
   }

   private void eF(int i) {
      this.zz.hY()[i]++;
      int var2 = GameConstants.A(this.zz.hY()[0], this.zz.hY()[0] + this.zz.hY()[1]);
      int var3 = GameConstants.A(this.zz.hY()[1], this.zz.hY()[0] + this.zz.hY()[1]);
      this.zz.hz()[0] = var2;
      this.zz.hz()[1] = var3;
   }

   public int vR() {
      double[] var1 = new double[]{0.1, 0.1};
      var1[this.TB] = this.ez(this.TB);
      var1[this.vQ()] = this.ez(this.vQ());
      double var2 = 1.0 + this.a(var1[this.TB], var1[this.vQ()]);
      double var4 = 1.0 + this.a(var1[this.vQ()], var1[this.TB]);
      if (!this.TD && this.TB == 0) {
         var2 += 0.3;
      }

      int var10000 = this.TA[this.TB].kj()[1];
      if (var2 < 0.2) {
         var2 = 0.2;
      }

      if (var4 < 0.2) {
         var4 = 0.2;
      }

      double[] var6 = new double[]{var2, var4};
      int var7 = -1;
      var7 = this.b(Tg, var6);
      int var8 = 0;
      if (var7 == 0) {
         this.TQ[this.vQ()]++;
         this.fX[this.TB]++;
         var8 = this.TB;
         this.TN[this.TB]++;
         this.eF(this.TB);
      } else if (var7 == 1) {
         this.TQ[this.TB]++;
         this.fX[this.vQ()]++;
         var8 = this.vQ();
         this.TO[this.vQ()]++;
         this.eF(this.vQ());
      }

      return var8;
   }

   public int vS() {
      double var1 = this.eE(this.vQ());
      this.TF = var1;
      double var3 = this.eA(this.TB);
      double var5 = 1.0 + this.a(var3, var1);
      double var7 = 1.0 + this.a(var1, var3);
      if (var1 == 0.0) {
         var7 = 0.1;
      }

      if (!this.TD && this.TB == 0) {
         var5 += 0.3;
      }

      if (var3 == 0.0) {
         var5 = 0.1;
      }

      if (var5 < 0.2) {
         var5 = 0.2;
      }

      if (var7 < 0.2) {
         var7 = 0.2;
      }

      int var9 = 0;
      if (this.TA[0].jZ() || this.TA[1].jZ()) {
         var9 = this.eD(this.vQ());
         if (var9 == 0) {
            var7 = 0.1;
         } else if (var9 == 1) {
            var7 = 0.05;
         }
      }

      double[] var10 = new double[]{var5, var7};
      int var11 = -1;
      var11 = this.b(Th, var10);
      if (var11 == 0) {
         this.TM[this.TB]++;
      } else if (var11 == 1) {
         this.TP[this.vQ()]++;
      }

      return var11;
   }

   public double a(double d, double e) {
      double var5 = 0.1;
      byte var7 = 8;
      if (GamePersistence.careerState.H() >= 5) {
         var7 = 11;
      } else if (GamePersistence.careerState.H() >= 9) {
         var7 = 12;
      }

      var5 = d - e;
      return var5 / var7;
   }

   public double b(double d, double e) {
      double var5 = 0.1;
      byte var7 = 8;
      if (GamePersistence.careerState.H() >= 5) {
         var7 = 10;
      }

      var5 = d - e;
      return var5 / var7;
   }

   public double c(double d, double e) {
      double var5 = 0.1;
      var5 = d - e;
      return var5 / 12.0;
   }

   public C0667 vT() {
      C0667 var1 = null;
      double var2 = this.eE(this.vQ());
      this.TF = var2;
      double var4 = this.eA(this.TB);
      double var6 = this.eC(this.TB);
      double var8 = this.eB(this.vQ());
      double var12 = 1.0 + this.b(var8, var6);
      double var10 = 1.0 + this.b(var2, var4);
      int var14 = 0;
      if (this.TA[0].jZ() || this.TA[1].jZ()) {
         var14 = this.eD(this.vQ());
         if (var14 == 0) {
            var12 = (int)Math.round(var12 * 0.2);
         } else if (var14 == 1) {
            var12 = (int)Math.round(var12 * 0.4);
         }
      }

      if (!this.TD) {
         if (this.TB == 0) {
            var12 += 0.1;
            var10 = var12 + 0.1;
         }

         if (this.TB == 1) {
            var12 -= 0.1;
            var10 = var12 - 0.1;
         }
      }

      double[] var15 = TU;
      if (this.zA[this.TB] >= 6) {
         var15 = TX;
      } else if (this.zA[this.TB] >= 5) {
         var15 = TW;
      } else if (this.zA[this.TB] >= 3) {
         var15 = TV;
      }

      if (this.zA[this.TB] >= 2 && this.TA[this.vQ()].getReputacao() - this.TA[this.TB].getReputacao() >= 2) {
         var15 = TW;
      }

      if (var12 < 0.2) {
         var12 = 0.2;
      }

      if (var10 < 0.2) {
         var10 = 0.2;
      }

      double[] var16 = new double[]{1.0, var12, var10};
      int var17 = -1;
      var17 = this.a(var15, var16);
      this.TG[this.TB]++;
      if (var17 == 0) {
         var1 = new C0667(this.TB);
         var1.k(this.TA[this.TB]);
         this.a(var1, this.TE);
         this.zz.hZ()[this.TB]++;
      } else if (var17 == 1) {
         this.zz.hZ()[this.TB]++;
         if (this.TE != null) {
            this.TE.gB().tL();
         }
      } else if (var17 == 2) {
         this.zz.ia()[this.TB]++;
      }

      return var1;
   }

   private int a(double[] ds, double[] es) {
      double var3 = 0.0;
      double[] var5 = new double[ds.length];

      for (int var6 = 0; var6 < ds.length; var6++) {
         var5[var6] = ds[var6] * es[var6];
         var3 += var5[var6];
      }

      double var11 = this.Tn.nextDouble() * var3;
      double var8 = 0.0;

      for (int var10 = 0; var10 < var5.length; var10++) {
         var8 += var5[var10];
         if (var11 < var8) {
            return var10;
         }
      }

      return ds.length;
   }

   private int b(double[] ds, double[] es) {
      double var3 = 0.0;
      double[] var5 = new double[ds.length];

      for (int var6 = 0; var6 < ds.length; var6++) {
         var5[var6] = ds[var6] * es[var6];
         var3 += var5[var6];
      }

      double var11 = this.Tn.nextDouble() * var3;
      double var8 = 0.0;

      for (int var10 = 0; var10 < var5.length; var10++) {
         var8 += var5[var10];
         if (var11 < var8) {
            return var10;
         }
      }

      return ds.length;
   }

   public Player vU() {
      Player var1 = null;
      ArrayList var2 = null;
      if (this.TB == 0) {
         var2 = this.zz.hp();
      } else {
         var2 = this.zz.hq();
      }

      double var3 = 0.0;

      for (int var5 = 0; var5 < var2.size(); var5++) {
         if (((Player)var2.get(var5)).fT() != 1
            && ((Player)var2.get(var5)).getPosicao() != 0
            && ((Player)var2.get(var5)).fT() > 0
            && ((Player)var2.get(var5)).fT() < Tx.length) {
            var3 += Tx[((Player)var2.get(var5)).fT()][0];
            if (((Player)var2.get(var5)).getCr1() == 9 || ((Player)var2.get(var5)).getCr2() == 9) {
               var3 += 4.0;
            } else if (((Player)var2.get(var5)).getCr1() == 5 || ((Player)var2.get(var5)).getCr2() == 5) {
               var3 += 2.0;
               if (((Player)var2.get(var5)).getPosicao() == 2) {
                  var3 += 2.0;
               }
            }
         }
      }

      double var12 = this.Tn.nextDouble() * var3;
      double var7 = 0.0;

      for (int var9 = 0; var9 < var2.size(); var9++) {
         if (((Player)var2.get(var9)).fT() != 1
            && ((Player)var2.get(var9)).getPosicao() != 0
            && ((Player)var2.get(var9)).fT() > 0
            && ((Player)var2.get(var9)).fT() < Tx.length) {
            var7 += Tx[((Player)var2.get(var9)).fT()][0];
            if (((Player)var2.get(var9)).getCr1() == 9 || ((Player)var2.get(var9)).getCr2() == 9) {
               var7 += 4.0;
            } else if (((Player)var2.get(var9)).getCr1() == 5 || ((Player)var2.get(var9)).getCr2() == 5) {
               var7 += 2.0;
               if (((Player)var2.get(var9)).getPosicao() == 2) {
                  var7 += 2.0;
               }
            }
         }

         if (var12 <= var7) {
            var1 = (Player)var2.get(var9);
            return (Player)var2.get(var9);
         }
      }

      if (var1 == null) {
         for (int var13 = var2.size() - 1; var13 > 0; var13--) {
            if (var13 < var2.size() && var2.get(var13) != null) {
               var1 = (Player)var2.get(var13);
               break;
            }
         }
      }

      return var1;
   }

   public Player C(Player player) {
      if (new Random().nextInt(100) > 80) {
         return null;
      }

      Player var2 = null;
      ArrayList var3 = null;
      int var4 = 0;
      if (this.TB == 0) {
         var3 = this.zz.hp();
         var4 = this.zz.hc().kj()[2];
      } else {
         var3 = this.zz.hq();
         var4 = this.zz.hd().kj()[2];
      }

      double var5 = 0.0;

      for (int var7 = 0; var7 < var3.size(); var7++) {
         if (var3.get(var7) != player && ((Player)var3.get(var7)).fT() > 0 && ((Player)var3.get(var7)).fT() < Ty.length) {
            var5 += Ty[((Player)var3.get(var7)).fT()][0];
            if (((Player)var3.get(var7)).getCr1() == 11 || ((Player)var3.get(var7)).getCr2() == 11) {
               var5 += 10.0;
               if (((Player)var3.get(var7)).getCr1() == 4 || ((Player)var3.get(var7)).getCr2() == 4) {
                  var5 += 5.0;
               }
            } else if (((Player)var3.get(var7)).getCr1() == 4 || ((Player)var3.get(var7)).getCr2() == 4) {
               var5 += 2.0;
               if (((Player)var3.get(var7)).getCr1() == 8) {
                  var5 += 2.0;
               }
            } else if (((Player)var3.get(var7)).getCr1() == 8 || ((Player)var3.get(var7)).getCr2() == 8) {
               var5 += 2.0;
               if (((Player)var3.get(var7)).getCr1() == 13) {
                  var5 += 2.0;
               }
            } else if (((Player)var3.get(var7)).getCr1() != 13 && ((Player)var3.get(var7)).getCr2() != 13) {
               if (((Player)var3.get(var7)).getCr1() == 6 || ((Player)var3.get(var7)).getCr2() == 6) {
                  var5 += 5.0;
                  if (((Player)var3.get(var7)).getPosicao() == 1) {
                     var5 += 2.0;
                  }
               }
            } else {
               var5++;
               if (((Player)var3.get(var7)).getPosicao() == 1) {
                  var5 += 2.0;
               }
            }

            if (var4 == 1 && ((Player)var3.get(var7)).getPosicao() == 1) {
               var5 += 20.0;
            }
         }
      }

      double var15 = this.Tn.nextDouble() * var5;
      double var9 = 0.0;

      for (int var11 = 0; var11 < var3.size(); var11++) {
         if (var3.get(var11) != player && ((Player)var3.get(var11)).fT() > 0 && ((Player)var3.get(var11)).fT() < Ty.length) {
            var9 += Ty[((Player)var3.get(var11)).fT()][0];
            if (((Player)var3.get(var11)).getCr1() == 11 || ((Player)var3.get(var11)).getCr2() == 11) {
               var9 += 10.0;
               if (((Player)var3.get(var11)).getCr1() == 4 || ((Player)var3.get(var11)).getCr2() == 4) {
                  var9 += 5.0;
               }
            } else if (((Player)var3.get(var11)).getCr1() == 4 || ((Player)var3.get(var11)).getCr2() == 4) {
               var9 += 2.0;
               if (((Player)var3.get(var11)).getCr1() == 8) {
                  var9 += 2.0;
               }
            } else if (((Player)var3.get(var11)).getCr1() == 8 || ((Player)var3.get(var11)).getCr2() == 8) {
               var9 += 2.0;
               if (((Player)var3.get(var11)).getCr1() == 13) {
                  var9 += 2.0;
               }
            } else if (((Player)var3.get(var11)).getCr1() != 13 && ((Player)var3.get(var11)).getCr2() != 13) {
               if (((Player)var3.get(var11)).getCr1() == 6 || ((Player)var3.get(var11)).getCr2() == 6) {
                  var9 += 5.0;
                  if (((Player)var3.get(var11)).getPosicao() == 1) {
                     var9 += 2.0;
                  }
               }
            } else {
               var9 += 2.0;
               if (((Player)var3.get(var11)).getPosicao() == 1) {
                  var9 += 2.0;
               }
            }

            if (var4 == 1 && ((Player)var3.get(var11)).getPosicao() == 1) {
               var9 += 20.0;
            }
         }

         if (var15 <= var9) {
            var2 = (Player)var3.get(var11);
            return (Player)var3.get(var11);
         }
      }

      return var2;
   }

   public Player vV() {
      Object var1 = null;
      ArrayList var2 = null;
      if (this.TB == 0) {
         var2 = this.zz.hq();
      } else {
         var2 = this.zz.hp();
      }

      double var3 = 0.0;

      for (int var5 = 0; var5 < var2.size(); var5++) {
         if (((Player)var2.get(var5)).fT() >= 0 && ((Player)var2.get(var5)).fT() < Tz.length) {
            var3 += Tz[((Player)var2.get(var5)).fT()][0];
         }
      }

      double var11 = this.Tn.nextDouble() * var3;
      double var7 = 0.0;

      for (int var9 = 0; var9 < var2.size(); var9++) {
         if (((Player)var2.get(var9)).fT() >= 0 && ((Player)var2.get(var9)).fT() < Tz.length) {
            var7 += Tz[((Player)var2.get(var9)).fT()][0];
         }

         if (var11 <= var7) {
            return (Player)var2.get(var9);
         }
      }

      return (Player)var1;
   }

   public int vW() {
      double var1 = 0.0;

      for (int var3 = 0; var3 < this.TY.length; var3++) {
         if (this.TY[var3] != 1) {
            var1 += Tx[this.TY[var3]][0];
         }
      }

      double var8 = this.Tn.nextDouble() * var1;
      double var5 = 0.0;

      for (int var7 = 0; var7 < this.TY.length; var7++) {
         if (this.TY[var7] != 1) {
            var5 += Tx[this.TY[var7]][0];
         }

         if (var8 <= var5) {
            return this.TY[var7];
         }
      }

      return -1;
   }

   public void a(C0667 c0667, Player player) {
      c0667.a(1);
      c0667.f(player);
      byte var3 = 1;
      int var4 = new Random().nextInt(1000);
      if (var4 < 900) {
         var3 = 1;
      } else if (var4 < 950) {
         var3 = 3;
      } else if (var4 < 980) {
         var3 = 4;
      } else if (var4 < 990) {
         var3 = 2;
      } else if (var4 < 995) {
         var3 = 5;
      } else {
         var3 = 1;
      }

      if (player == null) {
         ArrayList var5 = null;
         if (this.TB == 0) {
            var5 = this.zz.hp();
         } else {
            var5 = this.zz.hq();
         }

         if (var5.size() == 0) {
            Club.a(this.TA[this.TB], this.zz, this.TB + 1, -1, true);
         }

         player = this.vU();
      }

      if (player != null && var3 != 3 && var3 != 2) {
         player.gB().z();
      }

      if (var3 != 3 && var3 != 2 && var3 != 5 && var3 != 4) {
         Player var8 = this.C(player);
         if (var8 != null && var8 != player) {
            var8.gB().gV();
            if (var8.fg() != null && !var8.fC()) {
               var8.a(8, c0667.cu(), this.zz.hy());
            }

            c0667.g(var8);
         }
      }

      if (player != null && var3 == 5) {
         ArrayList var9 = null;
         if (this.TB == 0) {
            var9 = this.zz.hp();
         } else {
            var9 = this.zz.hq();
         }

         if (this.TA[this.TB].lq() != null && var9.contains(this.TA[this.TB].lq())) {
            c0667.f(this.TA[this.TB].lq());
         } else if (player.getPosicao() == 0) {
            var3 = 1;
         }
      }

      if (var3 == 2) {
         Player var11 = this.vV();
         if (var11 != null) {
            c0667.f(var11);
            var11.gB().tE();
         } else {
            var3 = 1;
            if (player != null) {
               player.gB().z();
            }
         }
      }

      if (var3 == 3 || var3 == 4) {
         ArrayList var12 = null;
         if (this.TB == 0) {
            var12 = this.zz.hp();
         } else {
            var12 = this.zz.hq();
         }

         if (this.TA[this.TB].ke() != null && var12.contains(this.TA[this.TB].ke())) {
            c0667.f(this.TA[this.TB].ke());
         }
      }

      boolean var14 = false;
      if (var3 == 3) {
         c0667.q(true);
         if (this.TA[0].jZ() || this.TA[1].jZ()) {
            var14 = true;
            var3 = 3;
            c0667.q(false);
         }
      }

      if (!var14) {
         this.zA[this.TB]++;
         if (this.TB == 0) {
            this.zz.hv();
         } else {
            this.zz.hx();
         }

         if (player != null) {
            player.gB().z();
         }
      }

      c0667.R(var3);
   }

   public void eG(int i) {
      this.zA[i]++;
   }

   public int[] vX() {
      return this.zA;
   }

   public int[] vY() {
      return this.TG;
   }

   public int[] vZ() {
      return this.TH;
   }

   public int[] wa() {
      return this.TI;
   }

   public int[] wb() {
      return this.TJ;
   }

   public int[] wc() {
      return this.TK;
   }

   public int[] wd() {
      return this.TL;
   }

   public int[] we() {
      return this.TM;
   }

   public int[] wf() {
      return this.TN;
   }

   public int[] wg() {
      return this.TO;
   }

   public int[] wh() {
      return this.TP;
   }

   public int[] hY() {
      return this.fX;
   }

   public int[] wi() {
      return this.TR;
   }
}
