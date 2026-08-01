package bf22.intermediary;

public class C0984 {
   private double XH = Double.NaN;
   private double XI = 1.0E-9;
   private int XJ = 3000;
   private int XK = 0;
   private double XL = 0.0;
   private double XM = 0.0;
   private double XN = 0.0;
   private int XO = 100;
   private boolean XP = false;
   private boolean XQ = false;
   private boolean XR = false;
   private boolean XS = false;
   private boolean XT = false;
   private boolean XU = false;
   private static int XV = 3000;
   private static int XW = 100;
   private static boolean XX = false;
   private static boolean XY = false;
   private static boolean XZ = false;
   private static boolean Ya = false;
   private static double Yb = 1.0E-14;

   public void u(double d) {
      this.XM = d;
   }

   public void v(double d) {
      this.XL = d;
   }

   public void xL() {
      this.XT = true;
   }

   public void xM() {
      this.XQ = true;
      if (this.XR) {
         this.XP = true;
      }
   }

   public void xN() {
      this.XR = true;
      if (this.XQ) {
         this.XP = true;
      }
   }

   public void xO() {
      this.XS = true;
   }

   public void xP() {
      this.XS = true;
   }

   public void xQ() {
      this.XT = false;
   }

   public void xR() {
      this.XU = true;
   }

   public void xS() {
      this.XU = true;
   }

   public void xT() {
      this.XU = false;
   }

   public void w(double d) {
      this.XI = d;
   }

   public double xU() {
      return this.XI;
   }

   public double a(C0985 c0985) {
      return this.a(c0985, this.XM, this.XL);
   }

   public double a(C0985 c0985, double d, double e) {
      this.XM = d;
      this.XL = e;
      if (e == d) {
         throw new IllegalArgumentException("upper cannot equal lower");
      }

      if (e < d) {
         double var6 = e;
         e = d;
         d = var6;
      }

      boolean var23 = true;
      this.XK = 0;
      double var7 = 1.0E300;
      double var9 = c0985.m(e);
      double var11 = c0985.m(d);
      if (Double.isNaN(var11)) {
         if (this.XT) {
            if (!this.XU) {
               System.out.println("RealRoot: bisect: lower bound returned NaN as the function value - NaN returned as root");
            }

            return Double.NaN;
         } else {
            throw new ArithmeticException("lower bound returned NaN as the function value");
         }
      } else if (Double.isNaN(var9)) {
         if (this.XT) {
            if (!this.XU) {
               System.out.println("RealRoot: bisect: upper bound returned NaN as the function value - NaN returned as root");
            }

            return Double.NaN;
         } else {
            throw new ArithmeticException("upper bound returned NaN as the function value");
         }
      } else {
         boolean var13 = true;
         int var14 = 0;
         double var15 = (e - d) / 2.0;

         while (var13) {
            if (var9 * var11 <= 0.0) {
               var13 = false;
            } else {
               if (this.XP) {
                  String var25 = "RealRoot.bisect: root not bounded and no extension to bounds allowed\n";
                  var25 = var25 + "NaN returned";
                  if (!this.XU) {
                     System.out.println(var25);
                  }

                  return Double.NaN;
               }

               if (++var14 > this.XO) {
                  String var17 = "RealRoot.bisect: root not bounded and maximum number of extension to bounds allowed, " + this.XO + ", exceeded\n";
                  var17 = var17 + "NaN returned";
                  if (!this.XU) {
                     System.out.println(var17);
                  }

                  return Double.NaN;
               }

               if (!this.XQ) {
                  d -= var15;
                  var11 = c0985.m(d);
               }

               if (!this.XR) {
                  e += var15;
                  var9 = c0985.m(e);
               }
            }
         }

         if (var11 == 0.0) {
            this.XH = d;
            var23 = false;
         }

         if (var9 == 0.0) {
            this.XH = e;
            var23 = false;
         }

         double var27 = (d + e) / 2.0;
         double var19 = 1.0E300;
         double var21 = c0985.m(var27);

         while (var23) {
            if (var21 == 0.0 || var7 < this.XI) {
               var23 = false;
               this.XH = var27;
            }

            if (var21 * var11 > 0.0) {
               d = var27;
               var11 = var21;
            } else {
               e = var27;
            }

            var19 = var27;
            var27 = (d + e) / 2.0;
            var21 = c0985.m(var27);
            var7 = Math.abs(var27 - var19);
            this.XK++;
            if (this.XK > this.XJ) {
               if (!this.XS) {
               }

               this.XH = var27;
               var23 = false;
            }
         }

         return this.XH;
      }
   }

   public void xV() {
      this.XP = true;
      this.XQ = true;
      this.XR = true;
   }
}
