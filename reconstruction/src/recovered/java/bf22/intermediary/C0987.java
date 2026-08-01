package bf22.intermediary;

import java.util.ArrayList;

public class C0987 {
   private boolean Yd = false;
   private boolean Ye = false;
   private boolean Yf = false;
   private boolean Yg = true;
   private boolean Yh = false;
   private boolean Yi = true;
   private boolean Yj = false;
   private boolean Yk = false;
   private ArrayList Yl = new ArrayList();
   private boolean Ym = false;
   private ArrayList Yn = new ArrayList();
   private boolean Yo = false;
   private static boolean Yp = false;
   private static boolean Yq = false;
   private static boolean Yr = true;
   private static boolean Ys = true;
   private static int Yt = 500;
   private static double Yu = 1.0E-8;
   public static final double Yv = 1.0E-300;
   private static boolean Yw = false;
   private static int Yx = 6;
   private static double[] Yy = new double[]{
      1.000000000190015, 76.18009172947146, -86.50532032941678, 24.01409824083091, -1.231739572450155, 0.001208650973866179, -5.395239384953E-6
   };
   private static double Yz = 5.0;
   private static int YA = 1000;
   private static double YB = 1.0E-8;
   private static double YC = 1.0001;

   public static double[] a(double d, double e, int i) {
      if (e < 1.0) {
         throw new IllegalArgumentException("The rate parameter, " + e + "must be equal to or greater than one");
      } else if (e - Math.round(e) != 0.0) {
         throw new IllegalArgumentException(
            "kay must, mathematically, be an integer even though it may be entered as a double\nTry the Gamma distribution instead of the Erlang distribution"
         );
      } else {
         return b(0.0, 1.0 / d, e, i);
      }
   }

   public static double[] a(double d, int i, int j, long l) {
      if (i < 1) {
         throw new IllegalArgumentException("The rate parameter, " + i + "must be equal to or greater than one");
      } else {
         return a(0.0, 1.0 / d, i, j, l);
      }
   }

   public static double[] a(double d, long l, int i, long m) {
      if (l < 1L) {
         throw new IllegalArgumentException("The rate parameter, " + l + "must be equal to or greater than one");
      } else {
         return a(0.0, 1.0 / d, l, i, m);
      }
   }

   public static double[] a(double d, double e, int i, long l) {
      if (e < 1.0) {
         throw new IllegalArgumentException("The rate parameter, " + e + "must be equal to or greater than one");
      } else if (e - Math.round(e) != 0.0) {
         throw new IllegalArgumentException(
            "kay must, mathematically, be an integer even though it may be entered as a double\nTry the Gamma distribution instead of the Erlang distribution"
         );
      } else {
         return a(0.0, 1.0 / d, e, i, l);
      }
   }

   public static double[] b(double d, double e, double f, int i) {
      if (e <= 0.0) {
         throw new IllegalArgumentException("The scale parameter, " + e + "must be greater than zero");
      }

      if (f <= 0.0) {
         throw new IllegalArgumentException("The shape parameter, " + f + "must be greater than zero");
      }

      C0983 var7 = new C0983();
      return var7.a(d, e, f, i);
   }

   public static double[] a(double d, double e, double f, int i, long l) {
      if (e <= 0.0) {
         throw new IllegalArgumentException("The scale parameter, " + e + "must be greater than zero");
      }

      if (f <= 0.0) {
         throw new IllegalArgumentException("The shape parameter, " + f + "must be greater than zero");
      }

      C0983 var9 = new C0983(l);
      return var9.a(d, e, f, i);
   }

   public static double x(double d) {
      double var2 = d;
      double var4 = d + Yz + 0.5;
      double var6 = Yy[0];
      double var8 = 0.0;
      if (d >= 0.0) {
         var4 = Math.pow(var4, d + 0.5) * Math.exp(-var4);

         for (int var10 = 1; var10 <= Yx; var10++) {
            var6 += Yy[var10] / ++var2;
         }

         var8 = var4 * Math.sqrt(Math.PI * 2) * var6 / d;
      } else {
         var8 = -Math.PI / (d * y(-d) * Math.sin(Math.PI * d));
      }

      return var8;
   }

   public static double y(double d) {
      double var2 = d;
      double var4 = d + Yz + 0.5;
      double var6 = Yy[0];
      double var8 = 0.0;
      if (d >= 0.0) {
         var4 = Math.pow(var4, d + 0.5) * Math.exp(-var4);

         for (int var10 = 1; var10 <= Yx; var10++) {
            var6 += Yy[var10] / ++var2;
         }

         var8 = var4 * Math.sqrt(Math.PI * 2) * var6 / d;
      } else {
         var8 = -Math.PI / (d * y(-d) * Math.sin(Math.PI * d));
      }

      return var8;
   }

   public static double xW() {
      return Yz;
   }

   public static int xX() {
      return Yx;
   }

   public static double a(double d, double e, double f, double g) {
      if (g < d) {
         throw new IllegalArgumentException("The upper limit, " + g + "must be equal to or greater than the location parameter, " + d);
      }

      if (e <= 0.0) {
         throw new IllegalArgumentException("The scale parameter, " + e + "must be greater than zero");
      }

      if (f <= 0.0) {
         throw new IllegalArgumentException("The shape parameter, " + f + "must be greater than zero");
      }

      double var8 = (g - d) / e;
      return m(f, var8);
   }

   public static double k(double d, double e) {
      if (e < 0.0) {
         throw new IllegalArgumentException("The upper limit, " + e + "must be equal to or greater than zero");
      } else if (d <= 0.0) {
         throw new IllegalArgumentException("The shape parameter, " + d + "must be greater than zero");
      } else {
         return m(d, e);
      }
   }

   public static double l(double d, double e) {
      return m(d, e);
   }

   public static double m(double d, double e) {
      if (!(d < 0.0) && !(e < 0.0)) {
         boolean var4 = Yw;
         Yw = true;
         double var5 = 0.0;
         if (e != 0.0) {
            if (e < d + 1.0) {
               var5 = o(d, e);
            } else {
               var5 = p(d, e);
            }

            if (var5 != var5) {
               var5 = 1.0 - n(d, e);
            }
         }

         if (var5 < 0.0) {
            var5 = 0.0;
         }

         Yw = var4;
         return var5;
      } else {
         throw new IllegalArgumentException("\nFunction defined only for a >= 0 and x>=0");
      }
   }

   private static double n(double d, double e) {
      double var4 = 0.0;
      double var6 = 100.0 * d;
      double var8 = var6 - e;
      double var10 = 0.0;
      if (var6 > e && var8 > 100.0) {
         var10 = var8 / 1000.0;
      } else {
         var6 = e + 100.0;
         var8 = 100.0;
         var10 = 0.1;
      }

      int var12 = (int)Math.round(var8 / var10);
      var10 = var8 / var12;
      C0965 var13 = new C0965();
      var13.n(d);
      var13.o(z(d));
      C0969 var14 = new C0969(var13);
      double var15 = e;
      double var17 = e + var10;
      var14.d(var15, var17);
      var4 = var14.eS(64);
      boolean var19 = true;

      for (int var20 = 1; var20 < var12; var20++) {
         var15 = var17;
         var17 = var15 + var10;
         var14.d(var15, var17);
         var4 += var14.eS(64);
      }

      return var4;
   }

   public static double z(double d) {
      double var2 = d;
      double var4 = 0.0;
      double var6 = d + Yz + 0.5;
      double var8 = Yy[0];
      if (d >= 0.0) {
         var6 -= (d + 0.5) * Math.log(var6);

         for (int var10 = 1; var10 <= Yx; var10++) {
            var8 += Yy[var10] / ++var2;
         }

         var4 = Math.log(Math.sqrt(Math.PI * 2) * var8 / d) - var6;
      } else {
         var4 = Math.PI / (y(1.0 - d) * Math.sin(Math.PI * d));
         if (var4 != Double.POSITIVE_INFINITY && var4 != Double.NEGATIVE_INFINITY) {
            if (var4 < 0.0) {
               throw new IllegalArgumentException("\nThe gamma function is negative");
            }

            var4 = Math.log(var4);
         }
      }

      return var4;
   }

   public static double o(double d, double e) {
      if (d < 0.0 || e < 0.0) {
         throw new IllegalArgumentException("\nFunction defined only for a >= 0 and x>=0");
      }

      if (e >= d + 1.0) {
         throw new IllegalArgumentException("\nx >= a+1   use Continued Fraction Representation");
      }

      double var4 = 0.0;
      if (e != 0.0) {
         int var6 = 0;
         boolean var7 = true;
         double var8 = d;
         double var10 = 1.0 / d;
         double var12 = var10;
         double var14 = A(d);

         while (var7) {
            var6++;
            d++;
            var12 *= e / d;
            var10 += var12;
            if (Math.abs(var12) < Math.abs(var10) * YB) {
               var4 = var10 * Math.exp(-e + var8 * Math.log(e) - var14);
               var7 = false;
            }

            if (var6 >= YA) {
               var7 = false;
               var4 = Double.NaN;
               if (!Yw) {
                  System.out.println("\nMaximum number of iterations were exceeded in Stat.incompleteGammaSer().");
                  System.out.println("NaN returned.\nIncrement = " + String.valueOf(var12) + ".");
                  System.out.println("Sum = " + String.valueOf(var10) + ".\nTolerance =  " + YB);
               }
            }
         }
      }

      return var4;
   }

   public static double p(double d, double e) {
      if (d < 0.0 || e < 0.0) {
         throw new IllegalArgumentException("\nFunction defined only for a >= 0 and x>=0");
      }

      if (e < d + 1.0) {
         throw new IllegalArgumentException("\nx < a+1   Use Series Representation");
      }

      double var4 = 0.0;
      if (e != 0.0) {
         int var6 = 0;
         double var7 = 0.0;
         boolean var9 = true;
         double var10 = A(d);
         double var12 = 0.0;
         double var14 = 0.0;
         double var16 = e - d + 1.0;
         double var18 = 1.0 / var16;
         double var20 = 9.999999999999999E299;
         double var22 = var18;

         while (var9) {
            var7 = ++var6;
            var12 = -var7 * (var7 - d);
            var16 += 2.0;
            var18 = var12 * var18 + var16;
            if (Math.abs(var18) < 1.0E-300) {
               var18 = 1.0E-300;
            }

            var20 = var16 + var12 / var20;
            if (Math.abs(var20) < 1.0E-300) {
               var20 = 1.0E-300;
            }

            var18 = 1.0 / var18;
            var14 = var18 * var20;
            var22 *= var14;
            if (Math.abs(var14 - 1.0) < YB) {
               var9 = false;
            }

            if (var6 >= YA) {
               var9 = false;
               var4 = 0.0;
               if (!Yw) {
                  System.out.println("\nMaximum number of iterations were exceeded in Stat.incompleteGammaFract().");
                  System.out.println("NaN returned.\nIncrement - 1 = " + String.valueOf(var14 - 1.0) + ".");
                  System.out.println("Tolerance =  " + String.valueOf(YB));
               }
            }
         }

         var4 = 1.0 - Math.exp(-e + d * Math.log(e) - var10) * var22;
      }

      return var4;
   }

   public static double A(double d) {
      double var2 = d;
      double var4 = 0.0;
      double var6 = d + Yz + 0.5;
      double var8 = Yy[0];
      if (d >= 0.0) {
         var6 -= (d + 0.5) * Math.log(var6);

         for (int var10 = 1; var10 <= Yx; var10++) {
            var8 += Yy[var10] / ++var2;
         }

         var4 = Math.log(Math.sqrt(Math.PI * 2) * var8 / d) - var6;
      } else {
         var4 = Math.PI / (y(1.0 - d) * Math.sin(Math.PI * d));
         if (var4 != Double.POSITIVE_INFINITY && var4 != Double.NEGATIVE_INFINITY) {
            if (var4 < 0.0) {
               throw new IllegalArgumentException("\nThe gamma function is negative");
            }

            var4 = Math.log(var4);
         }
      }

      return var4;
   }

   public static double[] B(double d) {
      double var2 = 0.8856031944108839;
      double var4 = 1.4616321399961483;
      if (d < var2) {
         throw new IllegalArgumentException(
            "Entered argument (gamma) value, " + d + ", must be equal to or greater than 0.8856031944108839 - this method does not handle the negative domain"
         );
      }

      double[] var6 = new double[2];
      double var7 = 1.0E-12;
      if (d == 1.0) {
         var6[0] = 1.0;
      } else if (d == var2) {
         var6[0] = var4;
      } else {
         C0970 var9 = new C0970();
         var9.Wu = d;
         double var10 = 0.0;
         double var12 = var4;
         C0984 var14 = new C0984();
         var14.xV();
         var14.w(var7);
         var14.xL();
         var14.xP();
         var14.xR();
         var6[0] = var14.a(var9, var10, var12);
      }

      if (d == 1.0) {
         var6[1] = 2.0;
      } else if (d == var2) {
         var6[1] = var4;
      } else {
         C0970 var19 = new C0970();
         var19.Wu = d;
         double var20 = var4;
         double var21 = 2.0;
         double var22 = 2.0;
         double var16 = y(var22);
         if (d > var16) {
            boolean var18 = true;

            while (var18) {
               var16 = y(++var22);
               if (d <= var16) {
                  var21 = var22;
                  var20 = var22 - 1.0;
                  var18 = false;
               }
            }
         }

         C0984 var24 = new C0984();
         var24.xV();
         var24.w(var7);
         var24.xL();
         var24.xP();
         var24.xR();
         var6[1] = var24.a(var19, var20, var21);
      }

      return var6;
   }
}
