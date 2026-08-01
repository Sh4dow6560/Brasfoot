package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0729 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int ae = 0;
   private int bW = -1;
   private int ca = 0;
   private int cb = 0;
   private int T = 0;
   private int cc = 0;
   private int V = 0;
   private int cd = 0;
   private int ce = 0;
   private double ab = 0.0;
   transient int cf = -1;
   transient Club cg = null;
   transient String ch = "";

   public C0729() {
   }

   public String ck() {
      String var1 = null;
      if (var1 == null) {
         for (int var2 = 0; var2 < C0745.SR.P().size(); var2++) {
            if (((Club)C0745.SR.P().get(var2)).lk() == this.bW) {
               var1 = ((Club)C0745.SR.P().get(var2)).getNome();
               this.cg = (Club)C0745.SR.P().get(var2);
               return var1;
            }
         }
      }

      if (var1 == null) {
         for (int var5 = 0; var5 < C0745.SR.aG().size(); var5++) {
            if (((C0692)C0745.SR.aG().get(var5)).jn() != null && ((C0692)C0745.SR.aG().get(var5)).jn().lk() == this.bW) {
               var1 = ((C0692)C0745.SR.aG().get(var5)).jn().getNome();
               this.cg = ((C0692)C0745.SR.aG().get(var5)).jn();
               return var1;
            }
         }
      }

      return var1;
   }

   public Club cu() {
      if (this.cg == null) {
         for (int var1 = 0; var1 < C0745.SR.P().size(); var1++) {
            if (((Club)C0745.SR.P().get(var1)).lk() == this.bW) {
               this.cg = (Club)C0745.SR.P().get(var1);
               return (Club)C0745.SR.P().get(var1);
            }
         }
      }

      if (this.cg == null) {
         for (int var2 = 0; var2 < C0745.SR.aG().size(); var2++) {
            if (((C0692)C0745.SR.aG().get(var2)).jn() != null && ((C0692)C0745.SR.aG().get(var2)).jn().lk() == this.bW) {
               this.cg = ((C0692)C0745.SR.aG().get(var2)).jn();
               return this.cg;
            }
         }
      }

      return this.cg;
   }

   public C0729(Player player, Club club) {
      this.ae = C0745.SR.H();
      this.bW = club.lk();
   }

   public C0729(boolean bl, int[] is) {
      this.ae = -1;
      this.T = is[0];
      this.V = is[1];
      this.ca = is[2];
      this.cb = is[3];
      this.cd = is[4];
      this.cc = is[5];
   }

   public int H() {
      return this.ae;
   }

   public int cv() {
      return this.ca;
   }

   public int cw() {
      return this.cb;
   }

   public int w() {
      return this.T;
   }

   public int y() {
      return this.V;
   }

   public int cx() {
      return this.cd;
   }

   public void cy() {
      this.cd++;
   }

   public void z() {
      this.V++;
   }

   public void cl() {
      this.T++;
   }

   public void cz() {
      this.ca++;
   }

   public void cA() {
      this.cb++;
   }

   public void cB() {
      this.ca++;
      this.cb++;
   }

   public void a(Player player, C0713 c0713) {
      if (c0713 != null && player != null && !player.fC()) {
         this.cc++;
         C0674 var3 = player.h(c0713);
         var3.gV();
      }
   }

   public void k(int i) {
      this.ae = i;
   }

   public int ct() {
      return this.bW;
   }

   public int cC() {
      return this.cf;
   }

   public void D(int i) {
      this.cf = i;
   }

   public int cD() {
      return this.cc;
   }

   public void E(int i) {
      this.cc = i;
   }

   public double F() {
      return this.ab;
   }

   public String cE() {
      String var1 = "--";
      double var2 = 0.0;
      if (this.ce > 0) {
         var2 = this.ab / this.ce;
         var1 = String.format("%.2f", var2);
      } else if (this.ce == 0) {
         var1 = "--";
      }

      return var1;
   }

   public void b(double d) {
      if (d >= 2.0) {
         this.ab += d;
         this.ce++;
      }
   }

   public void c(double d) {
      this.ab = d;
   }

   public int cF() {
      return this.ce;
   }

   public String cG() {
      return this.ch;
   }

   public void e(String string) {
      this.ch = string;
   }
}
