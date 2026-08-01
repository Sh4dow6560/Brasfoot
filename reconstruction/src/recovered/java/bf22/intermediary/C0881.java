package bf22.intermediary;

import java.util.Comparator;

class C0881 implements Comparator<C0914> {
   public int compare(C0914 c0914, C0914 c09142) {
      String var3 = "";
      String var4 = "";
      if (C0878.xi() == -1) {
         var3 = c09142.getNome();
         var4 = c0914.getNome();
      } else {
         var3 = c0914.getNome();
         var4 = c09142.getNome();
      }

      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
