package mod.recovered.competition;

import bf22.intermediary.*;
import java.util.Comparator;

class NationalLeagueTableComparator implements Comparator<C0691> {
   public int compare(C0691 c0691, C0691 c06912) {
      double var3 = c0691.C();
      double var5 = c06912.C();
      int var7 = c0691.iS();
      int var8 = c06912.iS();
      if (Double.compare(var5, var3) != 0) {
         return Double.compare(var5, var3);
      } else {
         return var7 != var8 ? var8 - var7 : 0;
      }
   }
}
