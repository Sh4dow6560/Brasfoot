package mod.recovered.game;

import bf22.intermediary.*;
import java.util.Comparator;
import mod.recovered.model.Coach;

class CoachPerformanceComparator implements Comparator<Coach> {
   public int compare(Coach coach, Coach coach2) {
      int var3 = coach.getCareerScore();
      int var4 = coach2.getCareerScore();
      int var5 = coach.getWinCount();
      int var6 = coach2.getWinCount();
      int var7 = coach.getMatchCount();
      int var8 = coach2.getMatchCount();
      if (var3 != var4) {
         return var4 - var3;
      } else if (var5 != var6) {
         return var6 - var5;
      } else {
         return var7 != var8 ? var7 - var8 : 0;
      }
   }
}
