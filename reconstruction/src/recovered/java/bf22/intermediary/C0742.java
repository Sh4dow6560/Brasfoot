package bf22.intermediary;

import java.util.Comparator;

class C0742 implements Comparator<C0779> {
   public int compare(C0779 c0779, C0779 c07792) {
      int var3 = c0779.getId();
      int var4 = c07792.getId();
      int var5 = c0779.co();
      int var6 = c07792.co();
      int var7 = c0779.vE();
      int var8 = c07792.vE();
      if (var3 != var4) {
         return var3 - var4;
      } else if (var5 != var6) {
         return var5 - var6;
      } else {
         return var7 != var8 ? var7 - var8 : 0;
      }
   }
}
