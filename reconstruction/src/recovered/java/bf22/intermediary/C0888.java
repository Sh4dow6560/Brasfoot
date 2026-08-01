package bf22.intermediary;

import java.util.Comparator;

class C0888 implements Comparator<C0915> {
   public int compare(C0915 c0915, C0915 c09152) {
      int var3 = 0;
      int var4 = 0;
      if (C0887.vG() == 0) {
         var3 = c0915.getNivel();
         var4 = c09152.getNivel();
      } else {
         var3 = c09152.getNivel();
         var4 = c0915.getNivel();
      }

      return var3 != var4 ? var4 - var3 : 0;
   }
}
