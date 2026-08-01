package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.util.Comparator;

class C0436 implements Comparator<C0814> {
   public int compare(C0814 c0814, C0814 c08142) {
      int var3 = 0;
      int var4 = 0;
      boolean var5 = false;
      boolean var6 = false;
      var3 = GameConstants.sE[c0814.fb().fT()][0];
      var4 = GameConstants.sE[c08142.fb().fT()][0];
      return var3 != var4 ? var3 - var4 : 0;
   }
}
