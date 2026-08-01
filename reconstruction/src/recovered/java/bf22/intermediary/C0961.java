package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0961 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 YD = null;
   private ArrayList YF = new ArrayList();
   private Club ZA = null;
   private ArrayList YV = new ArrayList();

   public C0961() {
      this.setNome(C0679.getString("ligaOfc"));
      this.F(4, 5);
      this.yo();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("nze", 143, 2));
      this.YV.add(new C0793("pap", 148, 1));
      this.YV.add(new C0793("ilha s", 93, 1));
      this.YV.add(new C0793("taiti", 184, 1));
      this.YV.add(new C0793("fiji", 69, 1));
      this.YV.add(new C0793("van", 197, 1));
      this.YV.add(new C0793("novaCal", 215, 1));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(5, 1, this.YV, null, i, c0792);
   }

   public void yq() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YF.clear();
      this.YD = null;
      new ArrayList();
      ArrayList var2 = new ArrayList();
      C0938.a(this.YV, this.YF, var2, false);
      if (this.YF.size() < 8) {
         C0938.a(this.YF, this.YV, 8, var2);
      }

      Collections.sort(this.YF, C1007.abm);
      ArrayList var3 = new ArrayList();
      if (this.YF.size() >= 8) {
         int[] var4 = new int[]{0, 2, 4, 6, 1, 3, 5, 7};

         for (int var5 = 0; var5 < var4.length; var5++) {
            var3.add((Club)this.YF.get(var4[var5]));
         }

         LeagueLoadOptions var7 = new LeagueLoadOptions();
         var7.nTimes = 8;
         var7.nGrupos = 2;
         var7.numeroTimesMataMata = 2;
         var7.doisTurnos = true;
         var7.pulaDuasDatas = true;
         C0955 var6 = new C0955(var7, var3, 0, null, null, null, 4, null, false, null, true, this);
         this.YD = var6;
         var6.setNome(this.getNome());
      } else {
         System.out.println("erro Liga Ofc() " + this.YF.size());
      }
   }

   public ArrayList yy() {
      return this.YF;
   }

   public Club yz() {
      return this.ZA;
   }

   public void N(Club club) {
      this.ZA = club;
   }

   public C0955 yd() {
      return this.YD;
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"1º G1", "2º G2", "1º G2", "2º G1"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   @Override
   public void mr() {
      this.YD.za();
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
      C0678[] var2 = new C0678[]{this.YD};
      var1.add(new C0830(var2, "Fase de Grupos"));
      C0678[] var3 = new C0678[]{this.YD.yY()};
      var1.add(new C0830(var3, "Fase Final"));
      return var1;
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_ligaofc";
      var1[1] = this.getNome();
      return var1;
   }
}
