package mod.recovered.competition;

import bf22.intermediary.*;
import java.util.Comparator;

class CompetitionRatingComparator implements Comparator<C0690> {
   public int compare(C0690 c0690, C0690 c06902) {
      double var3 = c0690.F();
      double var5 = c06902.F();
      int var7 = c0690.A();
      int var8 = c06902.A();
      if (var3 != var5) {
         return Double.compare(var5, var3);
      } else {
         return var7 != var8 ? var7 - var8 : 0;
      }
   }
}
