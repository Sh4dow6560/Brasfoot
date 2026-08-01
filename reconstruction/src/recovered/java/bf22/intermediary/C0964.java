package bf22.intermediary;

import java.util.Random;

public class C0964 {
   public static void xl() {
      int var0 = 0;
      int var1 = 0;

      for (int var2 = 0; var2 < 1000; var2++) {
         int var3 = eN(50);
         if (var3 < 25) {
            var0++;
         } else {
            var1++;
         }
      }

      var0 = 0;
      var1 = 0;

      for (int var8 = 0; var8 < 1000; var8++) {
         int var10 = eM(50);
         if (var10 < 25) {
            var0++;
         } else {
            var1++;
         }
      }

      var0 = 0;
      var1 = 0;

      for (int var9 = 0; var9 < 1000; var9++) {
         int var11 = eP(50);
         if (var11 < 25) {
            var0++;
         } else {
            var1++;
         }
      }

      System.out.println("");
      System.out.println("contnrmenosNormal: " + var0);
      System.out.println("contnr: " + var1);
   }

   public static int eM(int i) {
      byte var1 = 0;
      double var2 = 0.0;
      C0963 var4 = new C0963();

      while (var2 <= 0.0 || var2 >= 1.0) {
         var2 = var4.xI();
      }

      return (int)Math.round(var1 + i * var2);
   }

   public static int eN(int i) {
      byte var1 = 0;
      double var2 = 0.0;
      new C0983();
      var2 = C0987.a(1.0, 1, 1, new Random().nextLong())[0];

      while (var2 <= 0.0 || var2 >= 1.0) {
         var2 = C0987.a(1.0, 1, 1, new Random().nextLong())[0];
      }

      return (int)Math.round(var1 + i * var2);
   }

   public static int eO(int i) {
      byte var1 = 0;
      double var2 = 0.0;
      Random var4 = new Random();
      var2 = var4.nextDouble();

      while (var2 <= 0.0 || var2 >= 1.0) {
         var2 = var4.nextDouble();
      }

      return (int)Math.round(var1 + i * var2);
   }

   public static int eP(int i) {
      byte var1 = 0;
      double var2 = 0.0;
      C0963 var4 = new C0963();
      var2 = var4.nextGaussian();

      while (var2 <= 0.0 || var2 >= 1.0) {
         var2 = var4.nextGaussian();
      }

      return (int)Math.round(var1 + i * var2);
   }

   public static void xm() {
      Double[] var0 = new Double[]{58.0, 18.0};
      Double[] var1 = new Double[]{82.0, 22.0};
      Double[] var2 = new Double[]{70.0, 10.0};
      Double[] var3 = new Double[]{40.0, 20.0};
      byte var4 = 0;
      byte var5 = 1;
      int var6 = 0;
      int[] var7 = new int[2];
      int[] var8 = new int[2];

      for (int var9 = 0; var9 < 100; var9++) {
         var6 = a(var4, var5, var0, var1, var2, var3);
         if (var6 == 3) {
            var7[var4]++;
            var8[var4]++;
         }

         if (var6 == 2) {
            var8[var4]++;
         }

         if (var4 == 0) {
            var4 = 1;
         } else {
            var4 = 0;
         }
      }
   }

   public static int a(int i, int j, Double[] doubles, Double[] doubles2, Double[] doubles3, Double[] doubles4) {
      byte var6 = 0;
      if (a(doubles2[i], doubles2[j])) {
         var6 = 1;
         if (a(doubles3[i], doubles[j])) {
            if (a(doubles3[i], doubles[j])) {
               var6 = 3;
            }
         } else {
            var6 = 2;
         }
      }

      return var6;
   }

   public static boolean a(Double double_, Double double2) {
      int var2 = (int)Math.round(double_);
      int var3 = (int)Math.round(double2);
      return eM(var2) > eM(var3);
   }
}
