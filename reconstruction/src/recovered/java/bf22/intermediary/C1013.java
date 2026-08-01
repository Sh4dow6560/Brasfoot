package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1013 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.fn();
      int var4 = player2.fn();
      int var5 = player.getPosicao();
      int var6 = player2.getPosicao();
      if (var3 == 0) {
         var3 = 100;
      }

      if (var4 == 0) {
         var4 = 100;
      }

      if (var3 != var4) {
         return var3 - var4;
      } else {
         return var5 != var6 ? var5 - var6 : 0;
      }
   }
}
