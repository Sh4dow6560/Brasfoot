package mod.recovered.game;

import bf22.intermediary.*;
import java.util.Comparator;
import mod.recovered.model.Coach;

class CoachPerformanceComparator implements Comparator<Coach> {
   public int compare(Coach coach, Coach coach2) {
      int var3 = coach.lI();
      int var4 = coach2.lI();
      int var5 = coach.lJ();
      int var6 = coach2.lJ();
      int var7 = coach.A();
      int var8 = coach2.A();
      if (var3 != var4) {
         return var4 - var3;
      } else if (var5 != var6) {
         return var6 - var5;
      } else {
         return var7 != var8 ? var7 - var8 : 0;
      }
   }
}
