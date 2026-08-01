package bf22.intermediary;

import mod.recovered.competition.Competition;
import java.util.Comparator;

class C0996 implements Comparator<Competition> {
   public int compare(Competition c0713, Competition c07132) {
      String var3 = c0713.getNome();
      String var4 = c07132.getNome();
      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
