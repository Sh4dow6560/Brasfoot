package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Club;

class C1017 implements Comparator<Club> {
   public int compare(Club club, Club club2) {
      int var3 = club.jX();
      int var4 = club2.jX();
      return var3 != var4 ? var3 - var4 : 0;
   }
}
