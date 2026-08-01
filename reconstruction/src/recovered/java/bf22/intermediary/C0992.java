package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C0992 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.fi();
      int var4 = player2.fi();
      int var5 = player.fp();
      int var6 = player2.fp();
      if (var3 > var4) {
         return -1;
      } else if (var3 < var4) {
         return 1;
      } else if (var5 > var6) {
         return -1;
      } else {
         return var5 < var6 ? 1 : 0;
      }
   }
}
