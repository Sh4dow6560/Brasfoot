package bf22.intermediary;

import java.util.Comparator;

class C1019 implements Comparator<C0915> {
   public int compare(C0915 c0915, C0915 c09152) {
      int var3 = c0915.getNivel();
      int var4 = c09152.getNivel();
      return var3 != var4 ? var4 - var3 : 0;
   }
}
