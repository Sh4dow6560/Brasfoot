package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class C0927 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0962 aac = null;
   private ArrayList cE = new ArrayList();

   public C0927() {
      this.setNome(C0679.getString("recopaS"));
      this.F(8, 1);
   }

   public void zR() {
      this.cE.clear();
      this.aac = null;
      Club var1 = null;
      Club var2 = null;
      if (C0745.SR.aF() != null) {
         var1 = C0745.SR.aF().yz();
      }

      if (C0745.SR.aH() != null) {
         var2 = C0745.SR.aH().yz();
      }

      boolean[] var3 = new boolean[]{true, true, true, true, true, true, true};
      if (var1 != null && var2 != null && var1 != var2) {
         this.cE.add(var2);
         this.cE.add(var1);
         this.aac = new C0962(null, this.cE.size(), 8, 0, var3, this, -1);
         C0929 var4 = new C0929();
         var4.a(this.aac, this.cE, 0, true, 0, 0, 8, false);
      }
   }

   @Override
   public void mr() {
      this.aac.z(this);
   }

   public C0962 zS() {
      return this.aac;
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
      var1[0] = "tr_recopasulamaericana";
      var1[1] = this.getNome();
      return var1;
   }
}
