package bf22.intermediary;

import java.util.Comparator;

class C0879 implements Comparator<C0914> {
   public int compare(C0914 c0914, C0914 c09142) {
      int var3 = 0;
      int var4 = 0;
      if (C0878.vG() == 0) {
         var3 = c0914.getPosicao();
         var4 = c09142.getPosicao();
      } else {
         var3 = c09142.getPosicao();
         var4 = c0914.getPosicao();
      }

      return var3 != var4 ? var4 - var3 : 0;
   }
}
