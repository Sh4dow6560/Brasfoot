package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0954 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0962 YP = null;
   private C0962 YQ = null;
   private C0962 YR = null;
   private C0955 YD = null;
   private ArrayList YF = new ArrayList();
   private ArrayList YS = new ArrayList();
   private Club YT = null;
   private Club YU = null;
   private ArrayList YV = new ArrayList();
   private ArrayList YW = new ArrayList();
   private boolean YX = false;

   public C0954() {
      this.F(4, 1);
      this.yo();
      this.yp();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("bra", 29, 5, true));
      this.YV.add(new C0793("arg", 11, 5, true));
      this.YV.add(new C0793("uru", 195, 2));
      this.YV.add(new C0793("par", 150, 2));
      this.YV.add(new C0793("chil", 42, 2));
      this.YV.add(new C0793("col", 46, 2));
      this.YV.add(new C0793("equ", 60, 2));
      this.YV.add(new C0793("per", 151, 2));
      this.YV.add(new C0793("bol", 26, 2));
      this.YV.add(new C0793("ven", 198, 2));
   }

   private void yp() {
      this.YW.clear();
      this.YW.add(new C0793("bol", 26, 1));
      this.YW.add(new C0793("equ", 60, 1));
      this.YW.add(new C0793("par", 150, 1));
      this.YW.add(new C0793("per", 151, 1));
      this.YW.add(new C0793("uru", 195, 1));
      this.YW.add(new C0793("vez", 198, 1));
      this.YW.add(new C0793("arg", 11, 1));
      this.YW.add(new C0793("bol", 26, 1));
      this.YW.add(new C0793("bra", 29, 1));
      this.YW.add(new C0793("bra", 29, 1));
      this.YW.add(new C0793("chil", 42, 1));
      this.YW.add(new C0793("chil", 42, 1));
      this.YW.add(new C0793("col", 46, 1));
      this.YW.add(new C0793("col", 46, 1));
      this.YW.add(new C0793("equ", 60, 1));
      this.YW.add(new C0793("par", 150, 1));
      this.YW.add(new C0793("per", 151, 1));
      this.YW.add(new C0793("uru", 195, 1));
      this.YW.add(new C0793("vez", 198, 1));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(1, 1, this.YV, this.YW, i, c0792);
   }

   public void yq() {
      if (C0745.SR.H() == 1 && C0745.SR.isGruposIntPadrao() && this.yv() && this.yu()) {
         this.YX = true;
         this.yr();
      } else {
         this.YX = false;
         this.ys();
      }
   }

   private void yr() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < C0710.sP.length; var3++) {
         for (int var4 = 0; var4 < C0745.SR.P().size(); var4++) {
            if (((Club)C0745.SR.P().get(var4)).jY().equals(C0710.sP[var3])) {
               var1.add((Club)C0745.SR.P().get(var4));
               break;
            }
         }
      }

      this.YS.addAll(var1);

      for (int var6 = 0; var6 < C0710.sQ.length; var6++) {
         for (int var8 = 0; var8 < C0745.SR.P().size(); var8++) {
            if (((Club)C0745.SR.P().get(var8)).jY().equals(C0710.sQ[var6])) {
               var2.add((Club)C0745.SR.P().get(var8));
               break;
            }
         }
      }

      this.YF.addAll(var2);
      ArrayList var7 = new ArrayList();

      for (int var9 = 0; var9 <= 5; var9++) {
         var7.add((Club)this.YS.get(var9));
      }

      boolean[] var10 = new boolean[]{true, true, true, false, false, false, false};
      this.YP = new C0962(null, var7.size(), this.b(), 1, var10, this, 4101);
      C0929 var5 = new C0929();
      var5.a(this.YP, var7, 0, true, 0, 0, this.b(), false);
   }

   public void ys() {
      ArrayList var1 = new ArrayList();
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YF.clear();
      this.YS.clear();
      this.YD = null;
      this.YP = null;
      this.YQ = null;
      this.YR = null;
      if (this.YT == null) {
         var1.add(new C0793("bra", 29, 1));
      } else {
         this.YF.add(this.YT);
      }

      if (this.YU == null) {
         var1.add(new C0793("arg", 11, 1));
      } else if (this.YU != this.YT) {
         this.YF.add(this.YU);
      }

      if (this.YT != null && this.YT == this.YU) {
         var1.add(new C0793("mesmo pais", this.YT.getPais(), 1));
      }

      ArrayList var2 = new ArrayList();
      var2.addAll(this.YF);
      var2.addAll(this.YS);
      C0938.a(var1, this.YF, var2, false);
      C0938.a(this.YV, this.YF, var2, false);
      C0938.a(this.YW, this.YS, var2, false);
      if (this.YF.size() < 28) {
         C0938.a(this.YF, this.YV, 28, var2);
      }

      if (this.YS.size() < 19) {
         C0938.a(this.YS, this.YW, 19, var2);
      }

      Collections.sort(this.YF, C1007.abm);
      if (this.YS.size() == 19 && this.YF.size() == 28) {
         ArrayList var3 = new ArrayList();

         for (int var4 = 0; var4 <= 5; var4++) {
            var3.add((Club)this.YS.get(var4));
         }

         this.ah(var3);
      } else {
         System.out.println("erro Libertadores() " + this.YF.size() + " " + this.YS.size());
      }
   }

   public void ae(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      var2.add((Club)arrayList.get(0));
      var2.add((Club)this.YS.get(6));
      var2.add((Club)this.YS.get(7));
      var2.add((Club)this.YS.get(8));
      var2.add((Club)this.YS.get(9));
      var2.add((Club)this.YS.get(10));
      var2.add((Club)this.YS.get(11));
      var2.add((Club)this.YS.get(12));
      var2.add((Club)this.YS.get(13));
      var2.add((Club)this.YS.get(14));
      var2.add((Club)arrayList.get(1));
      var2.add((Club)this.YS.get(15));
      var2.add((Club)this.YS.get(16));
      var2.add((Club)this.YS.get(17));
      var2.add((Club)this.YS.get(18));
      var2.add((Club)arrayList.get(2));
      boolean[] var3 = new boolean[]{true, false, false, false, false, false, false};
      this.YQ = new C0962(null, var2.size(), this.b(), 1, var3, this, 4102);
      C0929 var4 = new C0929();
      var4.a(this.YQ, var2, 0, true, 0, 0, this.b(), false);
   }

   public void af(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      var2.add((Club)arrayList.get(0));
      var2.add((Club)arrayList.get(7));
      var2.add((Club)arrayList.get(1));
      var2.add((Club)arrayList.get(6));
      var2.add((Club)arrayList.get(2));
      var2.add((Club)arrayList.get(5));
      var2.add((Club)arrayList.get(3));
      var2.add((Club)arrayList.get(4));
      boolean[] var3 = new boolean[]{true, false, false, false, false, false, false};
      this.YR = new C0962(null, var2.size(), this.b(), 1, var3, this, 4103);
      C0929 var4 = new C0929();
      var4.a(this.YR, var2, 0, true, 0, 0, this.b(), false);
   }

   public void g(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 4101);
      }

      if (C0745.SR.H() == 1 && this.YX) {
         this.ae(arrayList);
      } else {
         ArrayList var10 = new ArrayList();
         ArrayList var4 = new ArrayList();
         ArrayList var5 = new ArrayList();
         ArrayList var6 = new ArrayList();

         for (int var7 = 6; var7 <= 18; var7++) {
            var10.add((Club)this.YS.get(var7));
         }

         var10.addAll(arrayList);
         Collections.sort(var10, C1007.abm);

         for (int var11 = 0; var11 <= 7; var11++) {
            var5.add((Club)var10.get(var11));
         }

         for (int var12 = 8; var12 <= 15; var12++) {
            var6.add((Club)var10.get(var12));
         }

         Collections.shuffle(var5);
         Collections.shuffle(var6);
         C0797[] var13 = new C0797[8];

         for (int var8 = 0; var8 <= 7; var8++) {
            var13[var8] = new C0797();
         }

         for (int var14 = 0; var14 <= 7; var14++) {
            var13[var14].e(var5, var6);
         }

         var13[0].a(var13);

         for (int var15 = 0; var15 <= 7; var15++) {
            var4.addAll(var13[var15].cZ());
         }

         boolean[] var16 = new boolean[]{true, false, false, false, false, false, false};
         this.YQ = new C0962(null, var4.size(), this.b(), 1, var16, this, 4102);
         C0929 var9 = new C0929();
         var9.a(this.YQ, var4, 0, true, 0, 0, this.b(), false);
      }
   }

   public void h(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 4102);
      }

      if (C0745.SR.H() == 1 && this.YX) {
         this.af(arrayList);
      } else {
         ArrayList var6 = new ArrayList();
         var6.addAll(arrayList);
         boolean[] var4 = new boolean[]{true, false, false, false, false, false, false};
         this.YR = new C0962(null, var6.size(), this.b(), 1, var4, this, 4103);
         C0929 var5 = new C0929();
         var5.a(this.YR, var6, 0, true, 0, 0, this.b(), false);
      }
   }

   private void a(ArrayList arrayList, ArrayList arrayList2, int i, int j, int k) {
      for (int var6 = i; var6 <= j; var6++) {
         arrayList.add((Club)this.YF.get(var6));
      }

      if (k >= 0) {
         arrayList.add((Club)arrayList2.get(k));
      }
   }

   private void ag(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      this.a(var2, arrayList, 0, 2, 1);
      this.a(var2, arrayList, 3, 6, -1);
      this.a(var2, arrayList, 7, 9, 3);
      this.a(var2, arrayList, 10, 12, 2);
      this.a(var2, arrayList, 13, 16, -1);
      this.a(var2, arrayList, 17, 19, 0);
      this.a(var2, arrayList, 20, 23, -1);
      this.a(var2, arrayList, 24, 27, -1);
      boolean[] var3 = new boolean[]{true, true, true, false, false, false, false};
      LeagueLoadOptions var4 = new LeagueLoadOptions();
      var4.nTimes = 32;
      var4.nGrupos = 8;
      var4.numeroTimesMataMata = 2;
      var4.doisTurnos = true;
      var4.pulaDuasDatas = false;
      var4.duasVoltasMataMata = var3;
      C0955 var5 = new C0955(var4, var2, 0, null, null, null, 4, null, false, null, true, this);
      var5.fb(4104);
      this.YD = var5;
      var5.setNome(this.getNome());
   }

   public void i(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 4103);
      }

      C0745.SR.aH().Aa().addAll(arrayList2);
      C0745.SR.aH().c(arrayList2, 0);
      if (C0745.SR.H() == 1 && this.YX) {
         this.ag(arrayList);
      } else {
         ArrayList var13 = new ArrayList();
         ArrayList var4 = new ArrayList();
         ArrayList var5 = new ArrayList();
         ArrayList var6 = new ArrayList();
         ArrayList var7 = new ArrayList();
         C0797[] var8 = new C0797[8];

         for (int var9 = 0; var9 <= 7; var9++) {
            var8[var9] = new C0797();
         }

         for (int var14 = 0; var14 <= 7; var14++) {
            var4.add((Club)this.YF.get(var14));
         }

         for (int var15 = 8; var15 <= 15; var15++) {
            var5.add((Club)this.YF.get(var15));
         }

         for (int var16 = 16; var16 <= 23; var16++) {
            var6.add((Club)this.YF.get(var16));
         }

         for (int var17 = 24; var17 <= 27; var17++) {
            var7.add((Club)this.YF.get(var17));
         }

         var7.addAll(arrayList);
         Collections.shuffle(var4);
         Collections.shuffle(var5);
         Collections.shuffle(var6);
         Collections.shuffle(var7);

         for (int var18 = 0; var18 <= 7; var18++) {
            var8[var18].a(var4, var5, var6, var7);
         }

         var8[0].a(var8);
         ArrayList var19 = new ArrayList();

         for (int var10 = 0; var10 < var8.length; var10++) {
            var19.add(var8[var10]);
         }

         Collections.shuffle(var19);

         for (int var20 = 0; var20 <= 7; var20++) {
            var13.addAll(((C0797)var19.get(var20)).cZ());
         }

         if (var13.size() >= 32) {
            boolean[] var21 = new boolean[]{true, true, true, false, false, false, false};
            LeagueLoadOptions var11 = new LeagueLoadOptions();
            var11.nTimes = 32;
            var11.nGrupos = 8;
            var11.numeroTimesMataMata = 2;
            var11.doisTurnos = true;
            var11.pulaDuasDatas = false;
            var11.duasVoltasMataMata = var21;
            C0955 var12 = new C0955(var11, var13, 0, null, null, null, 4, null, false, null, true, this);
            var12.fb(4104);
            this.YD = var12;
            var12.setNome(this.getNome());
         }
      }
   }

   public void yt() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < this.YD.yQ().size(); var5++) {
         var1.add((Club)((C0673)this.YD.yQ().get(var5)).gR().get(1));
         var2.add((Club)((C0673)this.YD.yQ().get(var5)).gR().get(0));
         var4.add((Club)((C0673)this.YD.yQ().get(var5)).gR().get(2));
      }

      C0745.SR.aH().c(var4, 1);
      Collections.shuffle(var1);
      Collections.shuffle(var2);
      C0797[] var8 = new C0797[8];

      for (int var6 = 0; var6 <= 7; var6++) {
         var8[var6] = new C0797();
      }

      for (int var9 = 0; var9 <= 7; var9++) {
         var8[var9].f(var1, var2);
      }

      for (int var10 = 0; var10 <= 7; var10++) {
         var3.addAll(var8[var10].cZ());
      }

      boolean[] var11 = new boolean[]{true, true, true, false, false, false, false};
      this.YD.c(new C0962(this.YD, var3.size(), this.b(), 0, var11, this, -1));
      C0929 var7 = new C0929();
      var7.a(this.YD.yY(), var3, 0, var11[0], 0, 0, this.b(), false);
   }

   public boolean ah(ArrayList arrayList) {
      Collections.shuffle(arrayList);
      boolean[] var2 = new boolean[]{true, true, true, false, false, false, false};
      this.YP = new C0962(null, arrayList.size(), this.b(), 1, var2, this, 4101);
      C0929 var3 = new C0929();
      var3.a(this.YP, arrayList, 0, true, 0, 0, this.b(), false);
      return true;
   }

   public boolean yu() {
      int var1 = 0;

      for (int var2 = 0; var2 < C0710.sQ.length; var2++) {
         for (int var3 = 0; var3 < C0745.SR.P().size(); var3++) {
            if (((Club)C0745.SR.P().get(var3)).jY().equals(C0710.sQ[var2])) {
               var1++;
               break;
            }
         }
      }

      return var1 == 28;
   }

   public boolean yv() {
      int var1 = 0;

      for (int var2 = 0; var2 < C0710.sP.length; var2++) {
         for (int var3 = 0; var3 < C0745.SR.P().size(); var3++) {
            if (((Club)C0745.SR.P().get(var3)).jY().equals(C0710.sP[var2])) {
               var1++;
               break;
            }
         }
      }

      return var1 == 19;
   }

   public ArrayList yw() {
      ArrayList var1 = new ArrayList();
      int var2 = 0;

      for (int var3 = 0; var3 < C0710.sQ.length; var3++) {
         for (int var4 = 0; var4 < C0745.SR.P().size(); var4++) {
            if (C0710.sQ[var3].length() > 1 && ((Club)C0745.SR.P().get(var4)).jY().equals(C0710.sQ[var3]) && ((Club)C0745.SR.P().get(var4)).gg() == 1) {
               var2++;
               var1.add((Club)C0745.SR.P().get(var4));
               break;
            }
         }
      }

      return var1;
   }

   public Club yx() {
      if (this.YD.yY() != null) {
         for (int var1 = this.YD.yY().zp().size() - 1; var1 >= 0; var1--) {
            for (int var2 = 0; var2 < ((C0929)this.YD.yY().zp().get(var1)).zY().size(); var2++) {
               if (((Club)((C0929)this.YD.yY().zp().get(var1)).zY().get(var2)).getPais() != 131) {
                  return (Club)((C0929)this.YD.yY().zp().get(var1)).zY().get(var2);
               }
            }
         }
      }

      return null;
   }

   public ArrayList yy() {
      return this.YF;
   }

   public Club yz() {
      return this.YT;
   }

   public void N(Club club) {
      this.YT = club;
   }

   public Club yA() {
      return this.YU;
   }

   public void O(Club club) {
      this.YU = club;
   }

   public ArrayList yB() {
      return this.YS;
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{
         "8ª melhor 2º",
         "melhor 1º",
         "melhor 2º",
         "8ª melhor 1º",
         "5ª melhor 2º",
         "4º melhor 1º",
         "4º melhor 2º",
         "5º melhor 1º",
         "7ª melhor 2º",
         "2º melhor 1º",
         "2º melhor 2º",
         "7º melhor 1º",
         "6ª melhor 2º",
         "3º melhor 1º",
         "3º melhor 2º",
         "6º melhor 1º"
      };

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   @Override
   public void mr() {
      this.YD.za();
   }

   public C0955 yd() {
      return this.YD;
   }

   public C0962 yC() {
      return this.YP;
   }

   @Override
   public C0692 mF() {
      int var1 = C0745.SR.H() - 1;
      var1 %= 10;
      int[] var2 = new int[]{42, 11, 29, 46, 150, 195, 26, 198, 60, 151};
      return var1 < var2.length ? C0745.SR.s(var2[var1]) : null;
   }

   public static String yD() {
      int var0 = C0745.SR.H() - 1;
      var0 %= 10;
      String var1 = "";
      String[] var2 = new String[]{"Santiago", "Buenos Aires", "Rio de Janeiro", "Bogotá", "Assunción", "Montevidéu", "La Paz", "Caracas", "Quito", "Lima"};
      return var2[var0];
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YD};
      if (this.YD == null) {
         C0678[] var2 = new C0678[]{this.YP, this.YQ, this.YR};
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
      C0678[] var2 = new C0678[]{this.YP, this.YQ, this.YR};
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
      if (c0678 == this.YP) {
         return C0710.pR;
      } else if (c0678 == this.YQ) {
         return C0710.pS;
      } else {
         return c0678 == this.YR ? C0710.pT : C0710.pA;
      }
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_libertadores";
      var1[1] = this.getNome();
      return var1;
   }

   public ArrayList yE() {
      return this.YS;
   }

   @Override
   public boolean cz(int i) {
      return this.YD != null && this.YD.yY() != null && this.YD.yY().zq() == i;
   }
}
