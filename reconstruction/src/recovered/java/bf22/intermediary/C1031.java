package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C1031 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = player.getPosicao();
      int var4 = player2.getPosicao();
      int var5 = player.fF();
      int var6 = player2.fF();
      int var7 = player.getOverallStrength();
      int var8 = player2.getOverallStrength();
      byte var9 = 0;
      byte var10 = 0;
      if (player.ff()) {
         var9 = 1;
      }

      if (player2.ff()) {
         var10 = 1;
      }

      if (var3 > var4) {
         return 1;
      } else if (var3 < var4) {
         return -1;
      } else if (var5 > var6) {
         return 1;
      } else if (var5 < var6) {
         return -1;
      } else if (var7 > var8) {
         return -1;
      } else if (var7 < var8) {
         return 1;
      } else if (var9 > var10) {
         return -1;
      } else {
         return var9 < var10 ? 1 : 0;
      }
   }
}
