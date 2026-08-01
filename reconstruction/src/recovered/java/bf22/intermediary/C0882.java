package bf22.intermediary;

import java.util.Comparator;

class C0882 implements Comparator<C0914> {
   public int compare(C0914 c0914, C0914 c09142) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if (C0878.xj() == 0) {
         var3 = c0914.getStatus();
         var4 = c09142.getStatus();
      } else {
         var3 = c09142.getStatus();
         var4 = c0914.getStatus();
      }

      var5 = c0914.getPosicao();
      var6 = c0914.getPosicao();
      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var6 - var5 : 0;
      }
   }
}
