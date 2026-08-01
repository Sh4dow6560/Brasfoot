package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.CompetitionPlayerStats;
import java.util.Comparator;

class CompetitionPlayerStatsComparator implements Comparator<CompetitionPlayerStats> {
   public int compare(CompetitionPlayerStats c0720, CompetitionPlayerStats c07202) {
      int var3 = c0720.y();
      int var4 = c07202.y();
      int var5 = c0720.A();
      int var6 = c07202.A();
      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var5 - var6 : 0;
      }
   }
}
