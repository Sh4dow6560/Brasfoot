package bf22.intermediary;

import java.util.Calendar;
import java.util.Random;

public class C0986 {
   private static Random Yc = new Random(Calendar.getInstance().getTimeInMillis() + Thread.currentThread().getId());

   public static double j(double d, double e) {
      boolean var4 = false;
      if (d < 1.0) {
         double var25 = 1.0 / d;
         double var26 = (1.0 - d) * Math.pow(d, d / (1.0 - d));

         double var31;
         do {
            double var27 = Yc.nextDouble();
            double var28 = Yc.nextDouble();
            double var29 = -Math.log(var27);
            double var30 = -Math.log(var28);
            var31 = Math.pow(var29, var25);
            if (var29 + var30 >= var26 + var31) {
               var4 = true;
            }
         } while (!var4);

         return var31 * e;
      } else {
         double var5 = d - Math.log(4.0);
         double var7 = d + Math.sqrt(2.0 * d - 1.0);
         double var9 = Math.sqrt(2.0 * d - 1.0);
         double var11 = 1.0 + Math.log(4.5);

         double var17;
         do {
            double var13 = Yc.nextDouble();
            double var15 = Yc.nextDouble();
            double var19 = 1.0 / var9 * Math.log(var15 / (1.0 - var15));
            var17 = d * Math.exp(var19);
            double var21 = var13 * var15 * var15;
            double var23 = var5 + var7 * var19 - var17;
            if (var23 >= 4.5 * var21 - var11 || var23 >= Math.log(var21)) {
               var4 = true;
            }
         } while (!var4);

         return var17 * e;
      }
   }
}
