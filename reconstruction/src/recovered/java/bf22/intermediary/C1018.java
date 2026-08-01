package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1018 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.fk();
      int var4 = player2.fk();
      return var3 != var4 ? var4 - var3 : 0;
   }
}
