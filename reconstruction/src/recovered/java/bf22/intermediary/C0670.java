package bf22.intermediary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.Preferences;

public class C0670 {
   private static String dZ = null;
   private static String ea = null;
   private static int eb = 0;
   private static final String cH = "AAAAAAACEEEEIIIIDNOOOOO×ØUUUUYIßaaaaaaaceeeeiiiionooooo÷ouuuuyþyAaAaAaCcCcCcCcDdDdEeEeEeEeEeGgGgGgGgHhHhIiIiIiIiIiJjJjKkkLlLlLlLlLlNnNnNnnNnOoOoOoOoRrRrRrSsSsSsSsTtTtTtUuUuUuUuUuUuWwYyYZzZzZzF";
   private static final String cI = "abcdefghijklmnopqrstuvxzyw0123456789";
   private static final String cJ = "fitbzvengwpkycmuqhldxjrasofitbzvengw";
   private static int ec = 0;

   public static String f(String string) {
      char[] var1 = new char[string.length()];

      for (int var3 = 0; var3 < string.length(); var3++) {
         char var2 = string.charAt(var3);
         if (var2 >= 192 && var2 <= 383) {
            var2 = "AAAAAAACEEEEIIIIDNOOOOO×ØUUUUYIßaaaaaaaceeeeiiiionooooo÷ouuuuyþyAaAaAaCcCcCcCcDdDdEeEeEeEeEeGgGgGgGgHhHhIiIiIiIiIiJjJjKkkLlLlLlLlLlNnNnNnnNnOoOoOoOoRrRrRrSsSsSsSsTtTtTtUuUuUuUuUuUuWwYyYZzZzZzF"
               .charAt(var2 - 192);
         }

         var1[var3] = var2;
      }

      return new String(var1);
   }

   public static void eS() {
      ea = dZ.toLowerCase();
      ea = ea.trim();
      ea = ea.replaceAll("\\s", "");
      ea = ea.replaceAll("`", "");
      ea = ea.replaceAll("'", "");
      ea = ea.replaceAll("´", "");
      ea = ea.replaceAll("\\.", "");
      ea = f(ea);
      if (ea.equals("lucasgabrielvalentimgoncalves")) {
         ea = "";
      }

      ea = l(ea);
   }

   public static boolean k(String string) {
      ArrayList var1 = new ArrayList();
      var1.add("zyyfcxzkbmllfcdml");
      var1.add("zyyfcxzklfcdml");
      var1.add("zyfcxzklfcdml");
      var1.add("zyfcxzkbmllfcdml");
      var1.add("ihflvmmdfyfagce");
      var1.add("ygtnzkbzkgyf");
      var1.add("vmeftfdj");
      var1.add("bfcgzkbzlmxlf");
      var1.add("vzkguzxtngbf");
      var1.add("wmfmuzbhmtfhbmam");
      var1.add("vzkguzozccgmymxhfbfcdfl");
      Preferences var2 = Preferences.userRoot();
      var2 = var2.node("systemacxyz22");
      String var3 = var2.get("newfk2", "");
      if (var3 != null && var3 != "") {
         List var4 = Arrays.asList(var3.split(","));

         for (int var5 = 0; var5 < var4.size(); var5++) {
            var1.add((String)var4.get(var5));
         }
      }

      return var1.contains(string);
   }

   public static String l(String string) {
      char[] var1 = string.toCharArray();

      for (int var2 = 0; var2 < string.length(); var2++) {
         if ("abcdefghijklmnopqrstuvxzyw0123456789".indexOf(string.charAt(var2)) >= 0) {
            var1[var2] = "fitbzvengwpkycmuqhldxjrasofitbzvengw".charAt("abcdefghijklmnopqrstuvxzyw0123456789".indexOf(string.charAt(var2)));
         }
      }

      String var3 = new String(var1);
      if (k(var3)) {
         var3 = "Brasfoot2016";
      }

      return var3;
   }

   public static int eT() {
      int var0 = 0;
      boolean var1 = false;
      boolean var2 = false;
      int var3 = 0;

      for (int var4 = 0; var4 < ea.length(); var4++) {
         char var5 = ea.charAt(var4);
         char var6 = var5;
         var0 += var6 * ++var3 + var3 + 3;
      }

      char var10 = ea.charAt(1);
      char var11 = var10;
      char var12 = ea.charAt(2);
      char var7 = var12;
      var0 *= var7 + var11 + 5;
      var0 = var0 * 12 + 331216;
      Y(var0);
      return var0;
   }

   public static int eU() {
      int var0 = 0;
      boolean var1 = false;
      boolean var2 = false;
      int var3 = 0;

      for (int var4 = 0; var4 < ea.length(); var4++) {
         char var5 = ea.charAt(var4);
         char var6 = var5;
         if (var5 != 'a') {
            var0 += var6 * ++var3 + var3 + 3;
         }
      }

      char var10 = ea.charAt(1);
      char var11 = var10;
      char var12 = ea.charAt(2);
      char var7 = var12;
      var0 *= var7 + var11 + 5;
      var0 = var0 * 11 + 263874;
      Y(var0);
      return var0;
   }

   public static String eV() {
      return dZ;
   }

   public static void m(String string) {
      dZ = string;
   }

   public static String eW() {
      return ea;
   }

   public static void n(String string) {
      ea = string;
   }

   public static int eX() {
      return ec;
   }

   public static void Y(int i) {
      ec = i;
   }

   public static int eY() {
      return eb;
   }

   public static void Z(int i) {
      eb = i;
   }
}
