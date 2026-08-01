package bf22.intermediary;

import java.util.Comparator;

class C1030 implements Comparator<C0915> {
   public int compare(C0915 c0915, C0915 c09152) {
      String var3 = C0732.f(c0915.getNome());
      String var4 = C0732.f(c09152.getNome());
      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
