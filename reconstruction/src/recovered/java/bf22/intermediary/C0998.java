package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C0998 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      String var3 = "";
      String var4 = "";
      if (player.fg() != null) {
         var3 = player.fg().getNome();
      }

      if (player2.fg() != null) {
         var4 = player2.fg().getNome();
      }

      return !var3.equals(var4) ? var3.compareTo(var4) : 0;
   }
}
