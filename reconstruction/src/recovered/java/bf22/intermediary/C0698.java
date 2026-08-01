package bf22.intermediary;

import mod.recovered.core.GameConstants;
public abstract class C0698 {
   private static String nome = null;
   private static String mc = "";

   public static String getNome() {
      return nome;
   }

   public static boolean t(String string) {
      if (string == null) {
         return false;
      }

      nome = string;
      return false;
   }

   public static String jG() {
      return mc;
   }

   public static boolean u(String string) {
      string.trim();
      if (string != null && string.length() >= 7) {
         mc = string;
         String var1 = "";

         for (int var2 = 0; var2 < string.length(); var2++) {
            String var3 = Character.toString(string.charAt(var2));
            if (GameConstants.tG[var2]) {
               var1 = var1 + Character.toString(string.charAt(var2));
            }
         }

         if (v(string)) {
            mc = var1;
         }

         return false;
      } else {
         return false;
      }
   }

   private static boolean v(String string) {
      int var1 = 0;

      for (int var2 = 0; var2 < string.length(); var2++) {
         String var3 = Character.toString(string.charAt(var2));
         if (GameConstants.tF[var2]) {
            var1 += Character.getNumericValue(string.charAt(var2));
         }
      }

      String var4 = "";
      if (string.length() == 8) {
         var4 = Character.toString(string.charAt(6)) + Character.toString(string.charAt(7));
      } else if (string.length() == 7) {
         var4 = Character.toString(string.charAt(6));
      }

      int var5 = Integer.parseInt(var4);
      return var5 == var1;
   }
}
