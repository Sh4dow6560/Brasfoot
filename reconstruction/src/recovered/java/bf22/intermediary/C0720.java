package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Player;

public class C0720 implements Serializable {
   private static final long serialVersionUID = 1L;
   private Player U = null;
   private int V = 0;
   private int W = 0;

   public C0720() {
   }

   public C0720(C0713 c0713, Player player) {
      this.U = player;
   }

   public C0720(Player player, int i, int j) {
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
