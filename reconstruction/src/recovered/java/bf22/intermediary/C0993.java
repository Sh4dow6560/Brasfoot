package bf22.intermediary;

import mod.recovered.competition.LeagueStage;
import java.util.Comparator;

class C0993 implements Comparator<LeagueStage> {
   public int compare(LeagueStage c0955, LeagueStage c09552) {
      int var3 = c0955.getDivisao();
      int var4 = c09552.getDivisao();
      int var5 = c0955.ze();
      int var6 = c09552.ze();
      if (var3 != var4) {
         return var3 - var4;
      } else {
         return var5 != var6 ? var5 - var6 : 0;
      }
   }
}
