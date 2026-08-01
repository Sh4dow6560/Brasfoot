package mod.recovered.competition;

import bf22.intermediary.*;
import java.util.Comparator;

class CompetitionPerformanceComparator implements Comparator<C0722> {
   public int compare(C0722 c0722, C0722 c07222) {
      double var3 = c0722.F();
      double var5 = c07222.F();
      double var7 = c0722.D();
      double var9 = c07222.D();
      if (var3 != var5) {
         return Double.compare(var5, var3);
      } else {
         return var7 != var9 ? Double.compare(var9, var7) : 0;
      }
   }
}
