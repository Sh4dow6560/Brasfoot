package bf22.intermediary;

import java.util.Comparator;
import mod.recovered.model.Player;

class C0658 implements Comparator<Player> {
   public int compare(Player player, Player player2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if (C0657.vG() == 0) {
         var3 = player.getPosicao();
         var4 = player2.getPosicao();
         var5 = player.getOverallStrength();
         var6 = player2.getOverallStrength();
      } else {
         var3 = player2.getPosicao();
         var4 = player.getPosicao();
         var5 = player2.getOverallStrength();
         var6 = player.getOverallStrength();
      }

      if (var3 != var4) {
         return var4 - var3;
      } else {
         return var5 != var6 ? var5 - var6 : 0;
      }
   }
}
