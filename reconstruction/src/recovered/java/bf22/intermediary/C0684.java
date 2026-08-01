package bf22.intermediary;

import mod.recovered.core.GameConstants;
public class C0684 {
   public static int eT() {
      String var0 = C0670.eW();
      int var1 = 0;
      boolean var2 = false;
      boolean var3 = false;
      int var4 = 0;

      try {
         for (int var5 = 0; var5 < var0.length(); var5++) {
            char var6 = var0.charAt(var5);
            char var7 = var6;
            var1 += var7 * ++var4 + var4 + 3;
         }

         char var11 = var0.charAt(1);
         int var12 = var11;
         char var13 = var0.charAt(2);
         char var8 = var13;
         var1 *= var8 + var12 + 5;
         var1 = var1 * 12 + 331216;

         for (int var9 = 0; var9 < 45; var9++) {
            var12 = var8 * '\b' + 342874 + GameConstants.B(var1, var9);
         }

         C0670.Y(var12);
      } catch (Exception var10) {
         System.exit(0);
      }

      return var1;
   }
}
