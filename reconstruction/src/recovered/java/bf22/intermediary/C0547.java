package bf22.intermediary;

import java.util.Comparator;

class C0547 implements Comparator<C0785> {
   public int compare(C0785 c0785, C0785 c07852) {
      int var3 = c0785.uy();
      int var4 = c07852.uy();
      int var5 = c0785.uA();
      int var6 = c07852.uA();
      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var6 - var5 : 0;
      }
   }
}
