package bf22.intermediary;

import java.util.BitSet;
import java.util.Random;

public class C0963 extends Random {
   private double XE;
   private boolean XF = false;

   public C0963(int i) {
      super(i);
   }

   public C0963() {
   }

   public synchronized int q(double d) {
      int var5 = -1;
      double var6 = Math.exp(-d);

      for (double var8 = 1.0; var8 >= var6; var5++) {
         var8 *= this.xH();
      }

      return var5;
   }

   public synchronized int xG() {
      return this.q(1.0);
   }

   @Override
   public synchronized boolean nextBoolean() {
      return (this.next(32) & 32768) != 0;
   }

   public synchronized boolean r(double d) {
      double var3 = this.xH();
      return var3 < d;
   }

   public synchronized BitSet a(int i, double d) {
      BitSet var4 = new BitSet(i);

      for (int var5 = 0; var5 < i; var5++) {
         if (this.r(d)) {
            var4.set(var5);
         }
      }

      return var4;
   }

   public synchronized double xH() {
      long var1 = ((long)this.next(26) << 27) + this.next(27);
      return var1 / 9.007199E15F;
   }

   public synchronized double e(double d, double e) {
      return d + (e - d) * this.xH();
   }

   public synchronized int a(double[] ds) {
      double var2 = 0.0;
      double var4 = this.xH();

      for (int var6 = 0; var6 < ds.length; var6++) {
         var2 += ds[var6];
         if (var2 > var4) {
            return var6;
         }
      }

      return ds.length - 1;
   }

   public synchronized int a(double[] ds, double d) {
      double var4 = 0.0;
      double var6 = this.xH() * d;

      for (int var8 = 0; var8 < ds.length; var8++) {
         var4 += ds[var8];
         if (var4 > var6) {
            return var8;
         }
      }

      return ds.length - 1;
   }

   @Override
   public synchronized double nextGaussian() {
      if (!this.XF) {
         double var1 = this.xH();
         double var3 = this.xH();
         double var5 = Math.sqrt(-2.0 * Math.log(var1)) * Math.cos((Math.PI * 2) * var3);
         double var7 = Math.sqrt(-2.0 * Math.log(var1)) * Math.sin((Math.PI * 2) * var3);
         this.XE = var7;
         this.XF = true;
         return var5;
      } else {
         this.XF = false;
         return this.XE;
      }
   }

   public synchronized double f(double d, double e) {
      return this.nextGaussian() * Math.sqrt(e) + d;
   }

   public synchronized double xI() {
      return this.a(1.0, 1.0, 0.0);
   }

   public synchronized double s(double d) {
      return this.a(d, 1.0, 0.0);
   }

   public synchronized double eU(int i) {
      assert i >= 1;
      double var17;
      if (i < 6) {
         var17 = 1.0;

         for (int var2 = 1; var2 <= i; var2++) {
            var17 *= this.xH();
         }

         var17 = -Math.log(var17);
      } else {
         while (true) {
            double var9 = 2.0 * this.xH() - 1.0;
            double var11 = 2.0 * this.xH() - 1.0;
            if (!(var9 * var9 + var11 * var11 > 1.0)) {
               double var15 = var11 / var9;
               double var3 = i - 1;
               double var7 = Math.sqrt(2.0 * var3 + 1.0);
               var17 = var7 * var15 + var3;
               if (!(var17 <= 0.0)) {
                  double var5 = (1.0 + var15 * var15) * Math.exp(var3 * Math.log(var17 / var3) - var7 * var15);
                  if (!(this.xH() > var5)) {
                     break;
                  }
               }
            }
         }
      }

      return var17;
   }

   public synchronized double g(double d, double e) {
      return this.a(d, e, 0.0);
   }

   public synchronized double a(double d, double e, double f) {
      double var7 = 0.0;
      if (!(d <= 0.0) && !(e <= 0.0)) {
         if (d < 1.0) {
            boolean var13 = false;
            double var9 = 1.0 + d * Math.exp(-1.0);

            while (!var13) {
               double var11 = var9 * this.xH();
               if (var11 > 1.0) {
                  var7 = -Math.log((var9 - var11) / d);
                  if (this.xH() <= Math.pow(var7, d - 1.0)) {
                     var13 = true;
                  }
               } else {
                  var7 = Math.pow(var11, 1.0 / d);
                  if (this.xH() <= Math.exp(-var7)) {
                     var13 = true;
                  }
               }
            }
         } else if (d == 1.0) {
            var7 = -Math.log(this.xH());
         } else {
            double var14 = -Math.log(this.xH());

            while (this.xH() > Math.pow(var14 * Math.exp(1.0 - var14), d - 1.0)) {
               var14 = -Math.log(this.xH());
            }

            var7 = d * var14;
         }

         return e * var7 + f;
      } else {
         throw new IllegalArgumentException("alpha and beta must be strictly positive.");
      }
   }

   public synchronized double xJ() {
      return this.a(1.0, 1.0, 0.0);
   }

   public synchronized double t(double d) {
      return this.a(1.0, d, 0.0);
   }

   public synchronized double h(double d, double e) {
      return this.a(1.0, d, e);
   }

   public synchronized double xK() {
      return this.a(0.5, 2.0, 0.0);
   }

   public synchronized double eV(int i) {
      return this.a(0.5 * i, 2.0, 0.0);
   }

   public synchronized double b(int i, double d) {
      return this.a(0.5 * i, 2.0, d);
   }

   public synchronized double i(double d, double e) {
      if (d <= 0.0 || e <= 0.0) {
         throw new IllegalArgumentException("alpha and beta must be strictly positive.");
      }

      if (d == 1.0 && e == 1.0) {
         return this.xH();
      }

      if (d >= 1.0 && e >= 1.0) {
         double var23 = d - 1.0;
         double var24 = e - 1.0;
         double var9 = var23 + var24;
         double var11 = var9 * Math.log(var9);
         double var13 = var23 / var9;
         double var15 = 0.5 / Math.sqrt(var9);
         double var17 = this.nextGaussian();

         double var19;
         for (var19 = var15 * var17 + var13; var19 < 0.0 || var19 > 1.0; var19 = var15 * var17 + var13) {
            var17 = this.nextGaussian();
         }

         for (double var21 = this.xH();
            Math.log(var21) >= var23 * Math.log(var19 / var23) + var24 * Math.log((1.0 - var19) / var24) + var11 + 0.5 * var17 * var17;
            var21 = this.xH()
         ) {
            var17 = this.nextGaussian();

            for (var19 = var15 * var17 + var13; var19 < 0.0 || var19 > 1.0; var19 = var15 * var17 + var13) {
               var17 = this.nextGaussian();
            }
         }

         return var19;
      } else {
         double var5 = Math.pow(this.xH(), 1.0 / d);

         double var7;
         for (var7 = Math.pow(this.xH(), 1.0 / e); var5 + var7 > 1.0; var7 = Math.pow(this.xH(), 1.0 / e)) {
            var5 = Math.pow(this.xH(), 1.0 / d);
         }

         return var5 / (var5 + var7);
      }
   }

   public static void main(String[] strings) {
      C0963 var1 = new C0963();
      byte var2 = 60;
      int[] var3 = new int[60];
      int[] var4 = new int[60];
      byte var5 = 10;

      for (int var6 = 0; var6 < 10000; var6++) {
         double var7 = 4.0;
         int var9 = (int)(var1.s(var7) / var5 * 60.0) % 60;
         int var10 = (int)(var1.eU((int)var7) / var5 * 60.0) % 60;
         var3[var9]++;
         var4[var10]++;
      }

      int var11 = 0;

      while (var11 < 60) {
         var11++;
      }
   }
}
