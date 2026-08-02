package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1006 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.getTackling();
      int var4 = player2.getTackling();
      return var3 != var4 ? var4 - var3 : 0;
   }
}
