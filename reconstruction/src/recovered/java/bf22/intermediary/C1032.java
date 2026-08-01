package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1032 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.getPosicao();
      int var4 = player2.getPosicao();
      if (var3 > var4) {
         return 1;
      } else {
         return var3 < var4 ? -1 : 0;
      }
   }
}
