package bf22.intermediary;

import java.util.ArrayList;

public class C0969 {
   private C0968 Ww = null;
   private boolean Wx = false;
   private double Wy = 0.0;
   private double Wz = 0.0;
   private boolean WA = false;
   private int WB = 0;
   private boolean WC = false;
   private int WD = 0;
   private boolean WE = false;
   private double WF = 0.0;
   private double WG = 0.0;
   private double WH = 0.0;
   private boolean WI = false;
   private boolean WJ = false;
   private ArrayList WK = new ArrayList();
   private ArrayList WL = new ArrayList();
   private double[] WM = null;
   private ArrayList WN = new ArrayList();
   private double[] WO = null;
   private double WP = 3.0E-11;
   private double WQ = 0.0;
   private double WR = 0.0;
   private static double WS = 0.0;
   private int WT = 0;
   private int WU = 1;
   private static int WV = 1;

   public C0969() {
   }

   public C0969(C0968 c0968) {
      this.Ww = c0968;
      this.Wx = true;
   }

   public C0969(C0968 c0968, double d, double e) {
      this.Ww = c0968;
      this.Wx = true;
      this.Wy = d;
      this.Wz = e;
      this.WA = true;
   }

   public void d(double d, double e) {
      this.Wy = d;
      this.Wz = e;
      this.WA = true;
   }

   public double xn() {
      if (!this.WC) {
         throw new IllegalArgumentException("Number of points not set");
      }

      if (!this.WA) {
         throw new IllegalArgumentException("One limit or both limits not set");
      }

      if (!this.Wx) {
         throw new IllegalArgumentException("No integral function has been set");
      }

      this.WM = new double[this.WB];
      this.WO = new double[this.WB];
      boolean var1 = true;
      int var2 = -1;
      if (!this.WK.isEmpty()) {
         for (int var3 = 0; var3 < this.WK.size(); var3++) {
            Integer var4 = (Integer)this.WK.get(var3);
            if (var4 == this.WB) {
               var1 = false;
               var2 = var3;
            }
         }
      }

      if (var1) {
         this.eR(this.WB);
         this.WK.add(new Integer(this.WB));
         this.WL.add(this.WM);
         this.WN.add(this.WO);
      } else {
         this.WM = (double[])this.WL.get(var2);
         this.WO = (double[])this.WN.get(var2);
      }

      double var12 = 0.0;
      double var5 = 0.5 * (this.Wz + this.Wy);
      double var7 = 0.5 * (this.Wz - this.Wy);
      double var9 = 0.0;

      for (int var11 = 0; var11 < this.WB; var11++) {
         var9 = var7 * this.WM[var11];
         var12 += this.WO[var11] * this.Ww.m(var5 + var9);
      }

      this.WF = var12 * var7;
      this.WI = true;
      return this.WF;
   }

   public void eR(int i) {
      double var2 = 0.0;
      double var4 = 0.0;
      double var6 = 0.0;
      double var8 = 0.0;
      double var10 = 0.0;
      double var12 = 0.0;
      double var14 = -1.0;
      double var16 = 1.0;
      int var18 = (i + 1) / 2;
      double var19 = 0.5 * (var16 + var14);
      double var21 = 0.5 * (var16 - var14);

      for (int var23 = 1; var23 <= var18; var23++) {
         var2 = Math.cos(Math.PI * (var23 - 0.25) / (i + 0.5));

         do {
            var6 = 1.0;
            var8 = 0.0;

            for (int var24 = 1; var24 <= i; var24++) {
               var10 = var8;
               var8 = var6;
               var6 = ((2.0 * var24 - 1.0) * var2 * var8 - (var24 - 1.0) * var10) / var24;
            }

            var12 = i * (var2 * var6 - var8) / (var2 * var2 - 1.0);
            var4 = var2;
            var2 = var4 - var6 / var12;
         } while (Math.abs(var2 - var4) > this.WP);

         this.WM[var23 - 1] = var19 - var21 * var2;
         this.WM[i - var23] = var19 + var21 * var2;
         this.WO[var23 - 1] = 2.0 * var21 / ((1.0 - var2 * var2) * var12 * var12);
         this.WO[i - var23] = this.WO[var23 - 1];
      }
   }

   public static void a(double[] ds, double[] es, int i) {
      C0969 var3 = new C0969();
      var3.eR(i);
      ds = var3.xo();
      es = var3.xp();
   }

   public double[] xo() {
      return this.WM;
   }

   public double[] xp() {
      return this.WO;
   }

   public double eS(int i) {
      this.WB = i;
      this.WC = true;
      return this.xn();
   }

   public static double a(C0968 c0968, double d, double e, int i) {
      C0969 var6 = new C0969(c0968, d, e);
      return var6.eS(i);
   }

   public ArrayList xq() {
      if (!this.WC) {
         throw new IllegalArgumentException("Number of points not set");
      }

      if (!this.WA) {
         throw new IllegalArgumentException("One limit or both limits not set");
      }

      if (!this.Wx) {
         throw new IllegalArgumentException("No integral function has been set");
      }

      this.WM = new double[this.WB];
      this.WO = new double[this.WB];
      double var1 = 0.5 * (this.Wz + this.Wy);
      double var3 = 0.5 * (this.Wz - this.Wy);
      boolean var5 = true;
      int var6 = -1;
      if (!this.WK.isEmpty()) {
         for (int var7 = 0; var7 < this.WK.size(); var7++) {
            Integer var8 = (Integer)this.WK.get(var7);
            if (var8 == this.WB) {
               var5 = false;
               var6 = var7;
            }
         }
      }

      if (var5) {
         this.eR(this.WB);
         this.WK.add(new Integer(this.WB));
         this.WL.add(this.WM);
         this.WN.add(this.WO);
      } else {
         this.WM = (double[])this.WL.get(var6);
         this.WO = (double[])this.WN.get(var6);
      }

      double var20 = 0.0;
      double var9 = 0.0;
      double var11 = 0.0;
      double var13 = 0.0;
      double var15 = 0.0;

      for (int var17 = 0; var17 < this.WB; var17++) {
         var15 = var3 * this.WM[var17];
         var11 = var1 + var15;
         var9 = this.WO[var17] * this.Ww.m(var11);
         var20 += var9;
         var13 += var9 * var11;
      }

      this.WF = var20 * var3;
      this.WG = var13 / var20;
      double var27 = 0.0;

      for (int var19 = 0; var19 < this.WB; var19++) {
         var15 = var3 * this.WM[var19];
         var11 = var1 + var15;
         var9 = this.WO[var19] * this.Ww.m(var11);
         var27 += C0966.p(var11 - this.WG) * var9;
      }

      this.WH = Math.sqrt(var27 / var20);
      ArrayList var28 = new ArrayList();
      var28.add(new Double(this.WF));
      var28.add(new Double(this.WG));
      var28.add(new Double(this.WH));
      this.WJ = true;
      this.WI = true;
      return var28;
   }
}
