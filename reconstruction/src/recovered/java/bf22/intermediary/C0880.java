package bf22.intermediary;

import java.util.Comparator;

class C0880 implements Comparator<C0914> {
   public int compare(C0914 c0914, C0914 c09142) {
      int var3 = c0914.getPosicao();
      int var4 = c09142.getPosicao();
      return var3 != var4 ? var3 - var4 : 0;
   }
}
