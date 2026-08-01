package bf22.intermediary;

public class C0829 {
   private double Z = 0.0;
   private C0675 zz = null;

   public C0829(C0676 c0676) {
      this.Z = c0676.C();
      int var2 = c0676.hM();
      int var3 = c0676.im();
      if (var2 >= 0 && var3 >= 0 && C0745.SR.m(var2) != null && var3 < C0745.SR.m(var2).size()) {
         this.zz = (C0675)C0745.SR.m(var2).get(var3);
      }
   }

   public double C() {
      return this.Z;
   }

   public void j(double d) {
      this.Z = d;
   }

   public C0675 tR() {
      return this.zz;
   }

   public void n(C0675 c0675) {
      this.zz = c0675;
   }
}
