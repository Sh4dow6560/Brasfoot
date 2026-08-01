package bf22.intermediary;

import java.util.Comparator;

class C0565 implements Comparator<C0721> {
   public int compare(C0721 c0721, C0721 c07212) {
      int var3 = c0721.v();
      int var4 = c07212.v();
      int var5 = c0721.w();
      int var6 = c07212.w();
      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var5 - var6 : 0;
      }
   }
}
