package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Club;

class C0995 implements Comparator<Club> {
   public int compare(Club club, Club club2) {
      String var3 = C0732.f(club.getNome());
      String var4 = C0732.f(club2.getNome());
      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
