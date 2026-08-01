package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1021 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      boolean var3 = player.fz();
      boolean var4 = player2.fz();
      if (var3 != var4) {
         return var3 ? -1 : 1;
      } else {
         return 0;
      }
   }
}
