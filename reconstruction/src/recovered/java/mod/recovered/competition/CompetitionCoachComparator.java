package mod.recovered.competition;

import bf22.intermediary.*;
import java.util.Comparator;

class CompetitionCoachComparator implements Comparator<C0707> {
   public int compare(C0707 c0707, C0707 c07072) {
      int var3 = c0707.lX();
      int var4 = c07072.lX();
      return var3 != var4 ? var4 - var3 : 0;
   }
}
