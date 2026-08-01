package bf22.intermediary;

import java.util.Comparator;

class C0859 implements Comparator<C0915> {
   public int compare(C0915 c0915, C0915 c09152) {
      String var3 = "";
      String var4 = "";
      if (C0887.xi() == -1) {
         var3 = c09152.getNomep();
         var4 = c0915.getNomep();
      } else {
         var3 = c0915.getNomep();
         var4 = c09152.getNomep();
      }

      int var5 = c0915.getNivel();
      int var6 = c09152.getNivel();
      if (!var3.equals(var4)) {
         return var3.compareTo(var4);
      } else {
         return var5 != var6 ? var6 - var5 : 0;
      }
   }
}
