package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Club;

public class C0728 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int ae;
   private int bW = -1;
   private int T;
   private int bX;
   private int d;
   private int bY;
   private int bZ;

   public C0728() {
   }

   public C0728(Club club) {
      this.ae = C0745.SR.H();
      if (club != null) {
         this.bW = club.lk();
      }
   }

   public String ck() {
      Object var1 = null;
      if (var1 == null) {
         for (int var2 = 0; var2 < C0745.SR.P().size(); var2++) {
            if (((Club)C0745.SR.P().get(var2)).lk() == this.bW) {
               return ((Club)C0745.SR.P().get(var2)).getNome();
            }
         }
      }

      if (var1 == null) {
         for (int var3 = 0; var3 < C0745.SR.aG().size(); var3++) {
            if (((C0692)C0745.SR.aG().get(var3)).jn() != null && ((C0692)C0745.SR.aG().get(var3)).jn().lk() == this.bW) {
               return ((C0692)C0745.SR.aG().get(var3)).jn().getNome();
            }
         }
      }

      return (String)var1;
   }

   public int H() {
      return this.ae;
   }

   public void k(int i) {
      this.ae = i;
   }

   public int w() {
      return this.T;
   }

   public void cl() {
      this.T++;
   }

   public int cm() {
      return this.bX;
   }

   public void cn() {
      this.bX++;
   }

   public int co() {
      return this.d;
   }

   public void cp() {
      this.d++;
   }

   public int cq() {
      return this.bY;
   }

   public void B(int i) {
      this.bY += i;
   }

   public int cr() {
      return this.bZ;
   }

   public void cs() {
      this.bZ++;
   }

   public int ct() {
      return this.bW;
   }

   public void C(int i) {
      this.bW = i;
   }
}
