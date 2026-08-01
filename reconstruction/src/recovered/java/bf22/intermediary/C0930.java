package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0930 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0962 YJ = null;
   private C0955 YD = null;
   private ArrayList YF = new ArrayList();
   private ArrayList YS = new ArrayList();
   private ArrayList aao = new ArrayList();
   private Club ZA = null;
   private ArrayList YV = new ArrayList();
   private ArrayList YW = new ArrayList();

   public C0930() {
      this.setNome(C0679.getString("csa"));
      this.F(6, 1);
      this.yo();
      this.yp();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("bra", 29, 3));
      this.YV.add(new C0793("bra", 29, 3));
      this.YV.add(new C0793("arg", 11, 6));
   }

   private void yp() {
      this.YW.clear();
      this.YW.add(new C0793("bol", 26, 4));
      this.YW.add(new C0793("chil", 42, 4));
      this.YW.add(new C0793("col", 46, 4));
      this.YW.add(new C0793("equ", 60, 4));
      this.YW.add(new C0793("par", 150, 4));
      this.YW.add(new C0793("per", 151, 4));
      this.YW.add(new C0793("uru", 195, 4));
      this.YW.add(new C0793("vez", 198, 4));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(1, 2, this.YV, this.YW, i, c0792);
   }

   public void yq() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.YJ = null;
      this.YF.clear();
      this.YS.clear();
      this.aao.clear();
      ArrayList var1 = new ArrayList();
      var1.addAll(C0745.SR.aF().yy());
      var1.addAll(C0745.SR.aF().yE());
      C0938.a(this.YV, this.YF, var1, false);
      C0938.a(this.YW, this.YS, var1, false);
      if (this.YF.size() < 12) {
         C0938.a(this.YF, this.YV, 12, var1);
      }

      if (this.YF.size() < 12) {
         C0938.a(this.YF, this.YV, 12, var1);
      }

      if (this.YS.size() < 32) {
         C0938.a(this.YS, this.YW, 32, var1);
      }

      if (this.YS.size() < 32) {
         C0938.a(this.YS, this.YV, 32, var1);
      }

      Collections.sort(this.YF, C1007.abm);
      ArrayList var2 = new ArrayList();
      if (this.YS.size() == 32) {
         for (int var3 = 0; var3 <= 7; var3++) {
            var2.addAll(this.b(this.YS, var3, 4));
         }
      }

      if (var2.size() == 32 && this.YF.size() == 12) {
         boolean[] var5 = new boolean[]{true, false, false, false, false, false, false};
         this.YJ = new C0962(null, var2.size(), 6, 1, var5, this, 6100);
         C0929 var4 = new C0929();
         var4.a(this.YJ, var2, 0, true, 0, 0, 6, false);
      } else {
         System.out.println("erro sul americana size:" + this.YS.size() + " " + this.YF.size() + " " + var2.size());
      }
   }

   public void o(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 6100);
      }

      ArrayList var13 = new ArrayList();
      var13.addAll(this.aao);
      var13.addAll(arrayList);
      var13.addAll(this.YF);
      Collections.sort(var13, C1007.abm);
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      var4.addAll(this.b(var13, 0, 8));
      var5.addAll(this.b(var13, 1, 8));
      var6.addAll(this.b(var13, 2, 8));
      var7.addAll(this.b(var13, 3, 8));
      C0797[] var8 = new C0797[8];

      for (int var9 = 0; var9 <= 7; var9++) {
         var8[var9] = new C0797();
      }

      for (int var14 = 0; var14 <= 7; var14++) {
         var8[var14].a(var4, var5, var6, var7);
      }

      var8[0].a(var8);
      ArrayList var15 = new ArrayList();

      for (int var10 = 0; var10 <= 7; var10++) {
         var15.addAll(var8[var10].cZ());
      }

      if (var15.size() == 32) {
         boolean[] var16 = new boolean[]{true, true, true, false, false, false, false};
         LeagueLoadOptions var11 = new LeagueLoadOptions();
         var11.nTimes = 32;
         var11.nGrupos = 8;
         var11.numeroTimesMataMata = 1;
         var11.doisTurnos = true;
         var11.pulaDuasDatas = false;
         var11.duasVoltasMataMata = var16;
         C0955 var12 = new C0955(var11, var15, 0, null, null, null, 6, null, false, null, true, this);
         var12.fb(6105);
         this.YD = var12;
         var12.setNome(this.getNome());
      }
   }

   public void yt() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      new ArrayList();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < this.YD.yQ().size(); var5++) {
         var1.add((Club)((C0673)this.YD.yQ().get(var5)).gR().get(0));
      }

      for (int var8 = 0; var8 < C0745.SR.aF().yd().yQ().size(); var8++) {
         var2.add((Club)((C0673)C0745.SR.aF().yd().yQ().get(var8)).gR().get(2));
      }

      Collections.shuffle(var1);
      Collections.shuffle(var2);
      C0797[] var9 = new C0797[8];

      for (int var6 = 0; var6 <= 7; var6++) {
         var9[var6] = new C0797();
      }

      for (int var10 = 0; var10 <= 7; var10++) {
         var9[var10].f(var1, var2);
      }

      for (int var11 = 0; var11 <= 7; var11++) {
         var4.addAll(var9[var11].cZ());
      }

      boolean[] var12 = new boolean[]{true, true, true, false, false, false, false};
      this.YD.c(new C0962(this.YD, var4.size(), this.b(), 0, var12, this, -1));
      C0929 var7 = new C0929();
      var7.a(this.YD.yY(), var4, 0, var12[0], 0, 0, this.b(), false);
   }

   private ArrayList b(ArrayList arrayList, int i, int j) {
      ArrayList var4 = new ArrayList();
      int var5 = i * j;
      int var6 = var5 + (j - 1);

      for (int var7 = var5; var7 <= var6; var7++) {
         var4.add((Club)arrayList.get(var7));
      }

      Collections.shuffle(var4);
      return var4;
   }

   public Club yz() {
      return this.ZA;
   }

   public void N(Club club) {
      this.ZA = club;
   }

   @Override
   public void mr() {
      this.YD.za();
   }

   @Override
   public C0692 mF() {
      int var1 = C0745.SR.H() - 1;
      var1 %= 10;
      int[] var2 = new int[]{11, 29, 150, 42, 46, 151, 195, 26, 198, 60};
      return var1 < var2.length ? C0745.SR.s(var2[var1]) : null;
   }

   public static String yD() {
      int var0 = C0745.SR.H() - 1;
      var0 %= 10;
      String var1 = "";
      String[] var2 = new String[]{"Assunção", "Lima", "São Paulo", "Caracas", "Quito", "Medellín", "La Paz", "Montevidéu", "Santiago", "Córdoba"};
      return var2[var0];
   }

   public void c(ArrayList arrayList, int i) {
      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         if (((Club)arrayList.get(var3)).jZ()) {
            if (i == 0) {
               new C0799(((Club)arrayList.get(var3)).ka(), 32, 87, "", "");
            } else {
               new C0799(((Club)arrayList.get(var3)).ka(), 33, 88, "", "");
            }
         }
      }
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YD};
      if (this.YD == null) {
         C0678[] var2 = new C0678[]{this.YJ};
         var1 = var2;
      } else if (this.YD.yZ()) {
         C0678[] var3 = new C0678[]{this.YD.yY()};
         var1 = var3;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      C0678[] var2 = new C0678[]{this.YJ};
      var1.add(new C0830(var2, "Fase Preliminar"));
      C0678[] var3 = new C0678[]{this.YD};
      var1.add(new C0830(var3, "Fase de Grupos"));
      if (this.YD != null) {
         C0678[] var4 = new C0678[]{this.YD.yY()};
         var1.add(new C0830(var4, "Fase Final"));
      } else {
         var1.add(new C0830(null, "Fase Final"));
      }

      return var1;
   }

   @Override
   public String[] b(C0678 c0678) {
      return c0678 == this.YJ ? C0710.pM : C0710.pA;
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_sulamericana";
      var1[1] = this.getNome();
      return var1;
   }

   public ArrayList Aa() {
      return this.aao;
   }

   @Override
   public boolean cz(int i) {
      return this.YD != null && this.YD.yY() != null && this.YD.yY().zq() == i;
   }
}
