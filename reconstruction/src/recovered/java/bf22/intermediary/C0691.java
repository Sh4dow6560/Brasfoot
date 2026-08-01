package bf22.intermediary;

import java.util.Random;
import mod.recovered.model.Player;

public class C0691 {
   private Player U;
   private double Z;
   private int hq;
   private int hr = new Random().nextInt(100);
   private static boolean hs = false;

   public Player x() {
      return this.U;
   }

   public void a(Player player) {
      this.U = player;
   }

   public double C() {
      return this.Z;
   }

   public void j(double d) {
      this.Z = d;
   }

   public int iR() {
      return this.hq;
   }

   public void bi(int i) {
      this.hq = i;
   }

   public int iS() {
      return this.hr;
   }

   public static void x(boolean bl) {
      hs = bl;
   }
}
