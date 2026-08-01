package bf22.intermediary;

import java.util.Comparator;

class C0695 implements Comparator<C0692> {
   public int compare(C0692 c0692, C0692 c06922) {
      int var3 = C0692.b(c0692);
      int var4 = C0692.b(c06922);
      int var5 = C0692.c(c0692);
      int var6 = C0692.c(c06922);
      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var6 - var5 : 0;
      }
   }
}
