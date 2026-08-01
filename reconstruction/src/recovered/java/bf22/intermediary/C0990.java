package bf22.intermediary;

import java.util.ArrayList;
import mod.recovered.model.Coach;
import mod.recovered.model.Player;

public abstract class C0990 {
   public static void Af() {
      ArrayList var0 = new ArrayList();

      for (int var1 = 0; var1 < C0745.SR.R().size(); var1++) {
         for (int var2 = 0; var2 < ((C0693)C0745.SR.R().get(var1)).t().size(); var2++) {
            if (!var0.contains(((C0693)C0745.SR.R().get(var1)).t().get(var2))) {
               var0.add((C0713)((C0693)C0745.SR.R().get(var1)).t().get(var2));
            }
         }
      }

      for (int var4 = 0; var4 < var0.size(); var4++) {
         ((C0713)var0.get(var4)).az(var4);
      }

      for (int var5 = 0; var5 < C0745.SR.O().size(); var5++) {
         for (int var6 = 0; var6 < ((Player)C0745.SR.O().get(var5)).gH().size(); var6++) {
            if (((C0674)((Player)C0745.SR.O().get(var5)).gH().get(var6)).gX() >= 0) {
               for (int var3 = 0; var3 < var0.size(); var3++) {
                  if (((C0674)((Player)C0745.SR.O().get(var5)).gH().get(var6)).gX() == ((C0713)var0.get(var3)).gD()) {
                     ((C0674)((Player)C0745.SR.O().get(var5)).gH().get(var6)).m((C0713)var0.get(var3));
                     break;
                  }
               }
            }
         }
      }
   }

   public static void Ag() {
      ArrayList var0 = new ArrayList();

      for (int var1 = 0; var1 < C0745.SR.R().size(); var1++) {
         for (int var2 = 0; var2 < ((C0693)C0745.SR.R().get(var1)).t().size(); var2++) {
            if (!var0.contains(((C0693)C0745.SR.R().get(var1)).t().get(var2))) {
               var0.add((C0713)((C0693)C0745.SR.R().get(var1)).t().get(var2));
            }
         }
      }

      for (int var3 = 0; var3 < var0.size(); var3++) {
         ((C0713)var0.get(var3)).az(var3);
      }

      for (int var4 = 0; var4 < C0745.SR.O().size(); var4++) {
         for (int var5 = 0; var5 < ((Player)C0745.SR.O().get(var4)).gH().size(); var5++) {
            ((C0674)((Player)C0745.SR.O().get(var4)).gH().get(var5)).gY();
         }
      }
   }

   public static void Ah() {
      for (int var0 = 0; var0 < C0745.SR.O().size(); var0++) {
         ((Player)C0745.SR.O().get(var0)).fg();
      }

      for (int var1 = 0; var1 < C0745.SR.Q().size(); var1++) {
         ((Player)C0745.SR.Q().get(var1)).fg();
      }

      for (int var2 = 0; var2 < C0745.SR.L().size(); var2++) {
         ((Coach)C0745.SR.L().get(var2)).fg();
      }
   }

   public static void Ai() {
      int var0 = 0;

      for (int var1 = 0; var1 < C0745.SR.O().size(); var1++) {
         ((Player)C0745.SR.O().get(var1)).az(var0);
         ((Player)C0745.SR.O().get(var1)).aC(1);
         var0++;
      }

      for (int var2 = 0; var2 < C0745.SR.Q().size(); var2++) {
         ((Player)C0745.SR.Q().get(var2)).az(var0);
         ((Player)C0745.SR.Q().get(var2)).aC(2);
         var0++;
      }

      for (int var3 = 0; var3 < C0745.SR.bo().size(); var3++) {
         ((C0709)C0745.SR.bo().get(var3)).mb();
      }
   }

   public static void Aj() {
      for (int var0 = 0; var0 < C0745.SR.bo().size(); var0++) {
         ((C0709)C0745.SR.bo().get(var0)).me();
      }
   }
}
