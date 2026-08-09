package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Club;

class C1000 implements Comparator<Club> {
   public int compare(Club club, Club club2) {
      int var3 = club.getReputation();
      int var4 = club2.getReputation();
      int var5 = club.getNivel();
      int var6 = club2.getNivel();
      int var7 = club.iS();
      int var8 = club2.iS();
      if (var5 != var6) {
         return var6 - var5;
      } else if (var3 != var4) {
         return var4 - var3;
      } else {
         return var7 != var8 ? var8 - var7 : 0;
      }
   }
}
