package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import mod.recovered.model.Club;

public class C0923 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0962 ZM = null;
   private C0962 ZN = null;
   private Club ZO = null;
   private Club ZP = null;
   private Club ZQ = null;
   private Club ZR = null;
   private Club ZS = null;
   private Club ZT = null;

   public C0923() {
      this.setNome(C0679.getString("mundialclubes"));
      this.F(5, 7);
      this.O(true);
   }

   public void zC() {
      this.ZM = null;
      this.ZN = null;
      this.ZO = null;
      this.ZP = null;
      this.ZQ = null;
      this.ZR = null;
      this.ZS = null;
      this.ZT = null;
      if (C0745.SR.aI() != null) {
         this.ZO = C0745.SR.aI().cS();
         C0745.SR.aI().N(this.ZO);
      }

      if (C0745.SR.aF() != null) {
         this.ZP = C0745.SR.aF().cS();
         C0745.SR.aF().N(this.ZP);
         if (this.ZP != null && this.ZP.getPais() == 131) {
            this.ZP = C0745.SR.aF().yx();
         }
      }

      if (C0745.SR.aO() != null) {
         this.ZQ = C0745.SR.aO().cS();
         C0745.SR.aO().N(this.ZQ);
      }

      if (C0745.SR.aL() != null) {
         this.ZR = C0745.SR.aL().cS();
         C0745.SR.aL().N(this.ZR);
      }

      if (C0745.SR.aQ() != null) {
         this.ZS = C0745.SR.aQ().cS();
         C0745.SR.aQ().N(this.ZS);
      }

      if (C0745.SR.aP() != null) {
         this.ZT = C0745.SR.aP().cS();
         C0745.SR.aP().N(this.ZT);
      }

      if (this.ZO != null && this.ZP != null && this.ZQ != null && this.ZR != null && this.ZS != null && this.ZT != null) {
         Club[] var1 = new Club[]{this.ZQ, this.ZR, this.ZS, this.ZT};
         int[] var2 = new int[]{2, 0, 3, 1};
         int[] var3 = new int[]{3, 2, 1, 0};
         int[] var4 = new int[]{0, 2, 3, 1};
         int var5 = new Random().nextInt(3);
         int[] var10000 = new int[]{2, 0, 3, 1};
         int[] var6;
         if (var5 == 0) {
            var6 = var2;
         } else if (var5 == 1) {
            var6 = var3;
         } else {
            var6 = var4;
         }

         ArrayList var7 = new ArrayList();

         for (int var8 = 0; var8 < 4; var8++) {
            var7.add(var1[var6[var8]]);
         }

         boolean[] var10 = new boolean[7];
         this.ZM = new C0962(null, var7.size(), this.b(), 1, var10, this, -1);
         this.ZM.fc(150);
         C0929 var9 = new C0929();
         var9.a(this.ZM, var7, 0, false, 0, 0, this.b(), false);
      }
   }

   public void al(ArrayList arrayList) {
      if (arrayList.size() == 2) {
         ArrayList var2 = new ArrayList();
         var2.add(this.ZP);
         var2.add((Club)arrayList.get(0));
         var2.add(this.ZO);
         var2.add((Club)arrayList.get(1));
         boolean[] var3 = new boolean[7];
         this.ZN = new C0962(null, var2.size(), this.b(), 0, var3, this, -1);
         C0929 var4 = new C0929();
         var4.a(this.ZN, var2, 0, false, 0, 0, this.b(), false);
      }
   }

   public C0962 zD() {
      return this.ZM;
   }

   public C0962 zE() {
      return this.ZN;
   }

   @Override
   public String[] b(C0678 c0678) {
      return c0678 == this.ZM ? C0710.pE : C0710.pF;
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.ZM};
      C0678[] var2 = new C0678[]{this.ZM, this.ZN};
      return this.ZN == null ? var1 : var2;
   }

   @Override
   public void mr() {
      this.ZN.z(this);
   }

   public static ArrayList eX(int i) {
      ArrayList var1 = new ArrayList();
      String[] var2 = null;
      if (i == 1) {
         String[] var3 = new String[]{"Campeão Libertadores", "vencedor quartas 1", "Campeão L. Campeões", "vencedor quartas 2"};
         var2 = var3;
      } else if (i == 2) {
         String[] var4 = new String[]{"Vencedor Semi-Final 1", "Vencedor Semi-Final 2", "Perdedor Semi-Final 1", "Perdedor Semi-Final 2"};
         var2 = var4;
      }

      for (int var5 = 0; var5 < var2.length; var5++) {
         var1.add(var2[var5]);
      }

      return var1;
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_mundial";
      var1[1] = this.getNome();
      return var1;
   }
}
