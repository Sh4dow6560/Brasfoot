package bf22.intermediary;

import java.util.Comparator;

class C0996 implements Comparator<C0713> {
   public int compare(C0713 c0713, C0713 c07132) {
      String var3 = c0713.getNome();
      String var4 = c07132.getNome();
      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
