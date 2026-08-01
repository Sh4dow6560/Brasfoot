package mod.recovered.competition;

import bf22.intermediary.*;
import java.io.Serializable;
import mod.recovered.model.Player;

public class CompetitionPlayerStats implements Serializable {
   private static final long serialVersionUID = 1L;
   private Player U = null;
   private int V = 0;
   private int W = 0;

   public CompetitionPlayerStats() {
   }

   public CompetitionPlayerStats(Competition c0713, Player player) {
      this.U = player;
   }

   public CompetitionPlayerStats(Player player, int i, int j) {
      this.U = player;
      this.V = i;
      this.W = j;
   }

   public Player x() {
      return this.U;
   }

   public int y() {
      return this.V;
   }

   public void z() {
      this.V++;
   }

   public int A() {
      return this.W;
   }

   public void i(int i) {
      this.W = i;
   }
}
