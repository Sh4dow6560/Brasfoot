package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1011 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.gJ();
      int var4 = player2.gJ();
      return var3 != var4 ? var4 - var3 : 0;
   }
}
