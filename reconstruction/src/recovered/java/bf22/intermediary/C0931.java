package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class C0931 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0962 aac = null;
   private ArrayList cE = new ArrayList();
   private int pais;

   public C0931() {
   }

   public C0931(int i) {
      this.pais = i;
      C0692 var2 = C0745.SR.o(this.pais);
      this.setNome("Supercopa - " + var2.jf());
      this.F(11, i);
   }

   public void Ab() {
      Club var1 = null;
      Club var2 = null;
      C0692 var3 = C0745.SR.o(this.pais);
      if (var3 != null && var3.eb() != null && var3.eb().size() > 0) {
         var1 = ((C0924)var3.eb().get(0)).cv(C0745.SR.H() - 1);
         Club[] var4 = var3.bk(C0745.SR.H() - 1);
         if (var4 != null) {
            if (var1 != var4[0]) {
               var2 = var4[0];
            } else {
               var2 = var4[1];
            }
         }

         this.b(var1, var2);
      }
   }

   public void b(Club club, Club club2) {
      this.cE.clear();
      this.aac = null;
      boolean[] var3 = new boolean[7];
      if (club != null && club2 != null) {
         this.cE.add(club);
         this.cE.add(club2);
         this.aac = new C0962(null, this.cE.size(), 11, 0, var3, this, -1);
         C0929 var4 = new C0929();
         var4.a(this.aac, this.cE, 0, var3[0], 0, 0, 11, false);
      }
   }

   @Override
   public void mr() {
      this.aac.z(this);
   }

   public C0962 zS() {
      return this.aac;
   }

   public int getPais() {
      return this.pais;
   }

   @Override
   public C0678[] mB() {
      return new C0678[]{this.aac};
   }

   @Override
   public ArrayList mC() {
      return null;
   }

   @Override
   public String[] b(C0678 c0678) {
      return this.aac.zB();
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      String var2 = "tr_supercopa_" + C0696.valueOf("P" + Integer.toString(this.pais)).jA();
      String var3 = "tr_supercopa_generico";
      if (C0710.w(var2)) {
         var1[0] = var2;
      } else {
         var1[0] = var3;
      }

      var1[1] = this.getNome();
      return var1;
   }
}
