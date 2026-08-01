package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Coach;

class C0370 implements Comparator<Coach> {
   public int compare(Coach coach, Coach coach2) {
      int var3 = coach.getReputacao();
      int var4 = coach2.getReputacao();
      return var3 != var4 ? var4 - var3 : 0;
   }
}
