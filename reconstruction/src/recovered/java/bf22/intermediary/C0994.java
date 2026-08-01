package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Club;

class C0994 implements Comparator<Club> {
   public int compare(Club club, Club club2) {
      int var3 = club.getNivel();
      int var4 = club2.getNivel();
      int var5 = club.iS();
      int var6 = club2.iS();
      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var6 - var5 : 0;
      }
   }
}
