package bf22.intermediary;

import mod.recovered.competition.LeagueStage;
import java.util.Comparator;
import mod.recovered.model.Club;

class C1001 implements Comparator<Club> {
   public int compare(Club club, Club club2) {
      int[] var3 = club.d(LeagueStage.Zl);
      int[] var4 = club2.d(LeagueStage.Zl);
      int var5 = var3[0];
      int var6 = var4[0];
      int var7 = var3[2];
      int var8 = var4[2];
      int var9 = var3[7];
      int var10 = var4[7];
      int var11 = var3[5];
      int var12 = var4[5];
      if (var5 != var6) {
         return var6 - var5;
      } else if (var7 != var8) {
         return var8 - var7;
      } else if (var9 != var10) {
         return var10 - var9;
      } else {
         return var11 != var12 ? var12 - var11 : 0;
      }
   }
}
