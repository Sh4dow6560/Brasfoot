package bf22.intermediary;

import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
public class C0829 {
   private double Z = 0.0;
   private Match zz = null;

   public C0829(C0676 c0676) {
      this.Z = c0676.C();
      int var2 = c0676.hM();
      int var3 = c0676.im();
      if (var2 >= 0 && var3 >= 0 && GamePersistence.careerState.m(var2) != null && var3 < GamePersistence.careerState.m(var2).size()) {
         this.zz = (Match)GamePersistence.careerState.m(var2).get(var3);
      }
   }

   public double C() {
      return this.Z;
   }

   public void j(double d) {
      this.Z = d;
   }

   public Match tR() {
      return this.zz;
   }

   public void n(Match c0675) {
      this.zz = c0675;
   }
}
