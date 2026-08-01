package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1022 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.getPais();
      int var4 = player2.getPais();
      return var3 != var4 ? var3 - var4 : 0;
   }
}
