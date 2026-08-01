package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;

public class C0934 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YD = null;
   private String agn = "";

   public C0934() {
      this.F(15, 0);
      this.setNome("Torneio Amistoso");
   }

   public void xZ() {
      this.YD = null;
   }

   public void a(ArrayList arrayList, int i, String string, String string2, boolean bl) {
      this.setNome(string);
      this.agn = string2;
      byte var6 = 1;
      if (i == 0) {
         var6 = 2;
      }

      LeagueLoadOptions var7 = new LeagueLoadOptions();
      var7.nTimes = arrayList.size();
      var7.nGrupos = var6;
      var7.numeroTimesMataMata = 2;
      if (i == 2) {
         var7.numeroTimesMataMata = 0;
      }

      var7.doisTurnos = false;
      boolean[] var8 = new boolean[7];
      var7.duasVoltasMataMata = var8;
      if (bl) {
         Collections.shuffle(arrayList);
      }

      C0955 var9 = new C0955(var7, arrayList, 0, null, null, null, 15, null, false, null, true, this);
      this.YD = var9;
      var9.setNome(string);
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YD};
      if (this.YD.yZ()) {
         C0678[] var2 = new C0678[]{this.YD.yY()};
         var1 = var2;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      if (this.YD.yX() > 0) {
         String var2 = "Primeira Fase";
         if (this.YD.yQ().size() > 0) {
            var2 = "Fase de Grupos";
         }

         C0678[] var3 = new C0678[]{this.YD};
         var1.add(new C0830(var3, var2));
         C0678[] var4 = new C0678[]{this.YD.yY()};
         var1.add(new C0830(var4, "Fase Final"));
         return var1;
      } else {
         return null;
      }
   }

   public String Bt() {
      return this.agn;
   }

   @Override
   public void mr() {
      this.YD.za();
   }
}
