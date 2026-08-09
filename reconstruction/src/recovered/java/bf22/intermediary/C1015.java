package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Stadium;

class C1015 implements Comparator<Stadium> {
   public int compare(Stadium stadium, Stadium stadium2) {
      int var3 = stadium.getCapacity();
      int var4 = stadium2.getCapacity();
      return var3 != var4 ? var4 - var3 : 0;
   }
}
