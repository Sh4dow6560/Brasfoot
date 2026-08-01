package bf22.intermediary;

import java.io.Serializable;

public class C0676 implements Serializable {
   private static final long serialVersionUID = 1L;
   private double Z = 0.0;
   private int fy = -1;
   private int gx = -1;

   public C0676() {
   }

   public C0676(C0675 c0675, double d) {
      this.Z = d;
      this.fy = C0745.SR.J();

      for (int var4 = 0; var4 < C0745.SR.S().size(); var4++) {
         if (C0745.SR.S().get(var4) == c0675) {
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
