package bf22.intermediary;

import mod.recovered.competition.Competition;
import java.io.Serializable;
import mod.recovered.model.Player;

public class C0722 implements Serializable {
   private static final long serialVersionUID = 1L;
   Player U = null;
   Competition Y = null;
   double Z = 0.0;
   double aa = 0.0;
   double ab = 0.0;
   int ac = 0;

   public C0722() {
   }

   public C0722(Competition c0713, Player player) {
      this.Y = c0713;
      this.U = player;
   }

   public Player x() {
      return this.U;
   }

   public void a(Player player) {
      this.U = player;
   }

   public double C() {
      return this.Z;
   }

   public void a(double d) {
      this.Z += d;
      this.aa++;
      this.ab = this.Z / this.aa;
   }

   public double D() {
      return this.aa;
   }

   public int E() {
      return this.ac;
   }

   public void j(int i) {
      this.ac = i;
   }

   public double F() {
      return this.ab;
   }
}
