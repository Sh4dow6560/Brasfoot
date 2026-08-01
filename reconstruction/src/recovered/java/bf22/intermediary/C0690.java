package bf22.intermediary;

import mod.recovered.model.Player;

public class C0690 {
   private Player U = null;
   private double ab = 0.0;
   private int W = 0;

   public C0690() {
   }

   public C0690(Player player, double d, int i) {
      this.U = player;
      this.ab = d;
      this.W = i;
   }

   public Player x() {
      return this.U;
   }

   public double F() {
      return this.ab;
   }

   public void c(double d) {
      this.ab = d;
   }

   public String cE() {
      if (this.ab > 0.0) {
         return this.ab == 10.0 ? "10" : String.format("%.2f", this.ab);
      } else {
         return "--";
      }
   }

   public int A() {
      return this.W;
   }
}
