package bf22.intermediary;

import java.util.Comparator;

class C0860 implements Comparator<C0915> {
   public int compare(C0915 c0915, C0915 c09152) {
      String var3 = "";
      String var4 = "";
      if (C0887.xj() == -1) {
         var3 = c09152.getNome();
         var4 = c0915.getNome();
      } else {
         var3 = c0915.getNome();
         var4 = c09152.getNome();
      }

      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
