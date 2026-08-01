package bf22.intermediary;

import java.io.Serializable;
import java.util.Random;

public class C0983 implements Serializable {
   private static final long serialVersionUID = 1L;
   private long Xd;
   private long Xe;
   private int Xf = 1;
   private int Xg = 1;
   private Random Xh = null;
   private int Xi = 1;
   private long Xj = 16807L;
   private long Xk = 2147483647L;
   private double Xl = 1.0 / this.Xk;
   private long Xm = 127773L;
   private long Xn = 2836L;
   private int Xo = 32;
   private long Xp = 1L + (this.Xk - 1L) / this.Xo;
   private double Xq = 1.2E-7;
   private double Xr = 1.0 - this.Xq;
   private long Xs = 0L;
   private long[] Xt = new long[this.Xo];
   private static int[] Xu = new int[231];
   private static int[] Xv = new int[7];
   private int Xw = 0;
   private double Xx = 0.0;
   private long Xy = 1L;
   private long Xz = 2L;
   private long XA = 16L;
   private long XB = 131072L;
   private static C0611 XC = new C0611();
   private long XD = this.Xy + this.Xz + this.XA;

   public C0983() {
      this.Xd = System.currentTimeMillis();
      this.Xe = this.Xd;
      this.Xh = new Random(this.Xd);
   }

   public C0983(long l) {
      this.Xd = l;
      this.Xe = l;
      this.Xh = new Random(this.Xd);
   }

   public void setSeed(long l) {
      this.Xd = l;
      if (this.Xf == 1) {
         this.Xh = new Random(this.Xd);
      }
   }

   public double[] a(double d, double e, double f, int i) {
      double[] var8 = new double[i];
      C0967 var9 = new C0967();
      var9.Ws = d;
      var9.Wt = e;
      var9.Wu = f;
      double var10 = Math.sqrt(f) * e;
      double var12 = 1.0E-10;
      double var14 = d;
      double var16 = d + 5.0 * var10;
      if (var16 <= var14) {
         var16 += var10;
      }

      for (int var18 = 0; var18 < i; var18++) {
         C0984 var19 = new C0984();
         var19.xM();
         var19.w(var12);
         var19.xL();
         var19.xO();
         var19.xS();
         boolean var20 = true;
         int var21 = 0;
         byte var22 = 10;

         while (var20) {
            var9.Wv = this.nextDouble();
            double var23 = var19.a(var9, var14, var16);
            if (!Double.isNaN(var23)) {
               var20 = false;
               var8[var18] = var23;
            } else if (var21 > var22) {
               var8[var18] = Double.NaN;
               var20 = false;
            } else {
               var21++;
            }
         }
      }

      return var8;
   }

   public double nextDouble() {
      return this.Xf == 1 ? this.Xh.nextDouble() : this.xF();
   }

   public double nextDouble(double d) {
      return d * this.nextDouble();
   }

   public double nextDouble(double d, double e) {
      return (e - d) * this.nextDouble() + d;
   }

   public double xF() {
      int var1 = 0;
      long var2 = 0L;
      double var4 = 0.0;
      this.Xs = 0L;
      if (this.Xd <= 0L || this.Xs != 0L) {
         if (-this.Xd < 1L) {
            this.Xd = 1L;
         } else {
            this.Xd = -this.Xd;
         }

         for (int var6 = this.Xo + 7; var6 >= 0; var6--) {
            var2 = this.Xd / this.Xm;
            this.Xd = this.Xj * (this.Xd - var2 * this.Xm) - this.Xn * var2;
            if (this.Xd < 0L) {
               this.Xd = this.Xd + this.Xk;
            }

            if (var6 < this.Xo) {
               this.Xt[var6] = this.Xd;
            }
         }

         this.Xs = this.Xt[0];
      }

      var2 = this.Xd / this.Xm;
      this.Xd = this.Xj * (this.Xd - var2 * this.Xm) - this.Xn * var2;
      if (this.Xd < 0L) {
         this.Xd = this.Xd + this.Xk;
      }

      var1 = (int)(this.Xs / this.Xp);
      this.Xs = this.Xt[var1];
      this.Xt[var1] = this.Xd;
      return (var4 = this.Xl * this.Xs) > this.Xr ? this.Xr : var4;
   }

   public double d(double d, int i) {
      return this.a(0.0, 1.0 / d, i);
   }

   public double a(double d, double e, double f) {
      double var7 = 0.0;
      C0967 var9 = new C0967();
      var9.Ws = d;
      var9.Wt = e;
      var9.Wu = f;
      double var10 = Math.sqrt(f) * e;
      double var12 = 1.0E-10;
      double var14 = d;
      double var16 = d + 5.0 * var10;
      if (var16 <= var14) {
         var16 += var10;
      }

      C0984 var18 = new C0984();
      var18.xM();
      var18.w(var12);
      var18.xL();
      var18.xO();
      var18.xS();
      boolean var19 = true;
      int var20 = 0;
      byte var21 = 10;

      while (var19) {
         var9.Wv = this.nextDouble();
         var7 = var18.a(var9, var14, var16);
         if (!Double.isNaN(var7)) {
            var19 = false;
         } else if (var20 > var21) {
            var7 = Double.NaN;
            var19 = false;
         } else {
            var20++;
         }
      }

      return var7;
   }

   public static void aa(int i, int j) {
      Xu[i] = j;
   }

   public static void i(int i, int j, int k) {
      Xv[i] = Xu[j] + k;
   }

   public static int eT(int i) {
      return Xv[i];
   }
}
