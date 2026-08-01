package mod.recovered.competition;

import bf22.intermediary.*;
import java.util.Comparator;
import mod.recovered.model.Player;

class CountryPlayerComparator implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.fi();
      int var4 = player2.fi();
      byte var5 = 0;
      byte var6 = 0;
      if (player.ff()) {
         var5 = 1;
      }

      if (player2.ff()) {
         var6 = 1;
      }

      if (var3 > var4) {
         return -1;
      } else if (var3 < var4) {
         return 1;
      } else if (var5 > var6) {
         return -1;
      } else {
         return var5 < var6 ? 1 : 0;
      }
   }
}
