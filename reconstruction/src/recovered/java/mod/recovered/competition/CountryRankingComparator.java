package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.CountryCompetitions;
import java.util.Comparator;

class CountryRankingComparator implements Comparator<CountryCompetitions> {
   public int compare(CountryCompetitions c0692, CountryCompetitions c06922) {
      int var3 = CountryCompetitions.b(c0692);
      int var4 = CountryCompetitions.b(c06922);
      int var5 = CountryCompetitions.c(c0692);
      int var6 = CountryCompetitions.c(c06922);
      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var6 - var5 : 0;
      }
   }
}
