package bf22.intermediary;

import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;

public class C0676 implements Serializable {
   private static final long serialVersionUID = 1L;
   private double Z = 0.0;
   private int fy = -1;
   private int gx = -1;

   public C0676() {
   }

   public C0676(Match c0675, double d) {
      this.Z = d;
      this.fy = GamePersistence.SR.J();

      for (int var4 = 0; var4 < GamePersistence.SR.S().size(); var4++) {
         if (GamePersistence.SR.S().get(var4) == c0675) {
            this.gx = var4;
            break;
         }
      }
   }

   public double C() {
      return this.Z;
   }

   public void j(double d) {
      this.Z = d;
   }

   public int hM() {
      return this.fy;
   }

   public int im() {
      return this.gx;
   }
}
