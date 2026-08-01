package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1027 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      double var3 = player.F();
      double var5 = player2.F();
      if (var3 != var5) {
         return var5 > var3 ? 1 : -1;
      } else {
         return 0;
      }
   }
}
