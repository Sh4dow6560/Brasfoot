package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Club;

class C1016 implements Comparator<Club> {
   public int compare(Club club, Club club2) {
      int var3 = club.jW();
      int var4 = club2.jW();
      return var3 != var4 ? var3 - var4 : 0;
   }
}
