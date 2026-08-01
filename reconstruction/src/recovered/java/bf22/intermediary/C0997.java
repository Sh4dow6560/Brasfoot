package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C0997 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      String var3 = player.getNome();
      String var4 = player2.getNome();
      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
