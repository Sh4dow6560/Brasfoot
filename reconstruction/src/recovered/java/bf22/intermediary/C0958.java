package bf22.intermediary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0958 extends C0713 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0962 YJ = null;
   private C0962 YP = null;
   private C0962 YQ = null;
   private C0962 YR = null;
   private C0962 ZB = null;
   private C0955 YD = null;
   private ArrayList YF = new ArrayList();
   private ArrayList YS = new ArrayList();
   private Club YT = null;
   private Club ZC = null;
   private int ZD = 1;
   private ArrayList YV = new ArrayList();
   private ArrayList YW = new ArrayList();

   public C0958() {
      this.F(4, 0);
      this.yo();
      this.yp();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("ing", 97, 1));
      this.YV.add(new C0793("esp", 65, 1));
      this.YV.add(new C0793("ita", 104, 1));
      this.YV.add(new C0793("ale", 3, 1));
      this.YV.add(new C0793("fra", 72, 1));
      this.YV.add(new C0793("por", 154, 1));
      this.YV.add(new C0793("hol", 85, 1));
      this.YV.add(new C0793("bel", 21, 1));
      this.YV.add(new C0793("aut", 15, 1));
      this.YV.add(new C0793("esc", 62, 1));
      this.YV.add(new C0793("ucr", 193, 1));
      this.YV.add(new C0793("ing", 97, 1));
      this.YV.add(new C0793("esp", 65, 1));
      this.YV.add(new C0793("ita", 104, 1));
      this.YV.add(new C0793("ale", 3, 1));
      this.YV.add(new C0793("fra", 72, 1));
      this.YV.add(new C0793("por", 154, 1));
      this.YV.add(new C0793("ing", 97, 1));
      this.YV.add(new C0793("esp", 65, 1));
      this.YV.add(new C0793("ita", 104, 1));
      this.YV.add(new C0793("ale", 3, 1));
      this.YV.add(new C0793("ing", 97, 1));
      this.YV.add(new C0793("esp", 65, 1));
      this.YV.add(new C0793("ita", 104, 1));
   }

   private void yp() {
      this.YW.clear();
      this.YW.add(new C0793("tur", 192, 1));
      this.YW.add(new C0793("din", 54, 1));
      this.YW.add(new C0793("chipre", 44, 1));
      this.YW.add(new C0793("serv", 171, 1));
      this.YW.add(new C0793("hol", 85, 1));
      this.YW.add(new C0793("bel", 21, 1));
      this.YW.add(new C0793("aut", 15, 1));
      this.YW.add(new C0793("esc", 62, 1));
      this.YW.add(new C0793("fra", 72, 1));
      this.YW.add(new C0793("por", 154, 1));
      this.YW.add(new C0793("cze", 159, 1));
      this.YW.add(new C0793("cro", 52, 1));
      this.YW.add(new C0793("sui", 180, 1));
      this.YW.add(new C0793("gre", 78, 1));
      this.YW.add(new C0793("isr", 103, 1));
      this.YW.add(new C0793("ucr", 193, 1));
      this.YW.add(new C0793("tu", 192, 1));
      this.YW.add(new C0793("din", 54, 1));
      this.YW.add(new C0793("chipre", 44, 1));
      this.YW.add(new C0793("nor", 142, 1));
      this.YW.add(new C0793("sue", 179, 1));
      this.YW.add(new C0793("bul", 31, 1));
      this.YW.add(new C0793("rom", 160, 1));
      this.YW.add(new C0793("aze", 16, 1));
      this.YW.add(new C0793("caz", 40, 1));
      this.YW.add(new C0793("hun", 88, 1));
      this.YW.add(new C0793("belarus", 25, 1));
      this.YW.add(new C0793("pol", 152, 1));
      this.YW.add(new C0793("esl", 64, 1));
      this.YW.add(new C0793("esk", 63, 1));
      this.YW.add(new C0793("lit", 119, 1));
      this.YW.add(new C0793("lux", 120, 1));
      this.YW.add(new C0793("bos", 27, 1));
      this.YW.add(new C0793("irl", 100, 1));
      this.YW.add(new C0793("mac", 122, 1));
      this.YW.add(new C0793("arm", 12, 1));
      this.YW.add(new C0793("let", 114, 1));
      this.YW.add(new C0793("alb", 2, 1));
      this.YW.add(new C0793("irlN", 101, 1));
      this.YW.add(new C0793("geo", 76, 1));
      this.YW.add(new C0793("fin", 70, 1));
      this.YW.add(new C0793("mol", 134, 1));
      this.YW.add(new C0793("mlt", 128, 1));
      this.YW.add(new C0793("ifaroe", 92, 1));
      this.YW.add(new C0793("kos", 110, 1));
      this.YW.add(new C0793("gib", 216, 1));
      this.YW.add(new C0793("mnt", 105, 1));
      this.YW.add(new C0793("wal", 145, 1));
      this.YW.add(new C0793("isl", 102, 1));
      this.YW.add(new C0793("est", 66, 1));
      this.YW.add(new C0793("andorra", 4, 1));
      this.YW.add(new C0793("san m", 164, 1));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(0, 1, this.YV, this.YW, i, c0792);
   }

   private void Bd() {
      ((C0793)this.YV.get(8)).fE(192);
      ((C0793)this.YW.get(0)).fE(15);
      ((C0793)this.YW.get(43)).fE(102);
      ((C0793)this.YW.get(48)).fE(92);
      ((C0793)this.YW.get(2)).fE(162);
   }

   public void yq() {
      if (C0745.SR.H() == 3) {
         this.Bd();
      }

      ArrayList var1 = new ArrayList();
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YF.clear();
      this.YS.clear();
      this.YD = null;
      this.YJ = null;
      this.YP = null;
      this.YQ = null;
      this.YR = null;
      this.ZB = null;
      Club var2 = null;
      if (C0745.SR.aK() != null) {
         var2 = C0745.SR.aK().BA();
      }

      if (this.YT == null) {
         var1.add(new C0793("fra", 72, 1));
      } else {
         this.YF.add(this.YT);
      }

      if (this.ZC == null) {
         var1.add(new C0793("ale", 3, 1));
      } else if (this.ZC != this.YT) {
         this.YF.add(this.ZC);
      }

      if (this.YT != null && this.YT == this.ZC) {
         var1.add(new C0793("mesmo pais", this.YT.getPais(), 1));
      }

      ArrayList var3 = new ArrayList();
      var3.addAll(this.YF);
      var3.addAll(this.YS);
      if (var1.size() > 0) {
         C0938.a(var1, this.YF, var3, false);
      }

      C0938.a(this.YV, this.YF, var3, false);
      if (C0745.SR.H() > 1 && var2 != null) {
         var3.add(var2);
      }

      C0938.a(this.YW, this.YS, var3, false);
      if (this.YF.size() < 26) {
         C0938.a(this.YF, this.YV, 26, var3);
      }

      if (this.YS.size() < 52) {
         C0938.a(this.YS, this.YW, 52, var3);
      }

      Collections.sort(this.YF, C1007.abm);
      if (this.YF.size() == 26 && this.YS.size() == 52) {
         ArrayList var4 = new ArrayList();

         for (int var5 = 48; var5 <= 51; var5++) {
            var4.add((Club)this.YS.get(var5));
         }

         Collections.shuffle(var4);
         boolean[] var7 = new boolean[7];
         this.YJ = new C0962(null, 4, this.b(), -1, var7, this, 4000);
         C0929 var6 = new C0929();
         var6.a(this.YJ, var4, 0, false, 0, 0, this.b(), false);
      } else {
         System.out.println("erro Liga C() " + this.YF.size() + " " + this.YS.size());
      }
   }

   public void aj(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();

      for (int var3 = 48; var3 <= 51; var3++) {
         if (!arrayList.contains(this.YS.get(var3))) {
            var2.add((Club)this.YS.get(var3));
            ((Club)this.YS.get(var3)).a(this, -1, 4000);
         }
      }

      C0745.SR.mj().zo().addAll(var2);
      C0745.SR.mj().b(var2, 0);
      ArrayList var9 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 19; var6 <= 33; var6++) {
         var9.add((Club)this.YS.get(var6));
      }

      for (int var10 = 34; var10 <= 47; var10++) {
         var4.add((Club)this.YS.get(var10));
      }

      var4.add((Club)arrayList.get(0));
      Collections.shuffle(var9);
      Collections.shuffle(var4);
      Random var11 = new Random();

      for (int var7 = 0; var7 < var9.size(); var7++) {
         if (var11.nextBoolean()) {
            var5.add((Club)var9.get(var7));
            var5.add((Club)var4.get(var7));
         } else {
            var5.add((Club)var4.get(var7));
            var5.add((Club)var9.get(var7));
         }
      }

      boolean[] var12 = new boolean[]{true, true, true, true, true, true, true};
      this.YP = new C0962(null, 30, this.b(), 1, var12, this, 4001);
      C0929 var8 = new C0929();
      var8.a(this.YP, var5, 0, var12[0], 0, 0, this.b(), false);
   }

   public void g(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 4001);
      }

      ArrayList var8 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      C0745.SR.mj().zo().addAll(arrayList2);
      C0745.SR.mj().b(arrayList2, 0);

      for (int var6 = 10; var6 <= 14; var6++) {
         var8.add((Club)this.YS.get(var6));
      }

      var8.addAll(arrayList);

      for (int var9 = 15; var9 <= 18; var9++) {
         var4.add((Club)this.YS.get(var9));
      }

      Collections.shuffle(var8);
      Collections.shuffle(var4);
      var5.addAll(var8);
      var5.addAll(var4);
      boolean[] var10 = new boolean[]{true, true, true, true, true, true, true};
      this.YQ = new C0962(null, 24, this.b(), 1, var10, this, 4002);
      C0929 var7 = new C0929();
      var7.a(this.YQ, var5, 0, var10[0], 0, 0, this.b(), false);
   }

   public void h(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 4002);
      }

      ArrayList var11 = new ArrayList();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 <= 9; var5++) {
         var11.add((Club)arrayList2.get(var5));
      }

      Collections.shuffle(var11);

      for (int var12 = 10; var12 <= 11; var12++) {
         var4.add((Club)arrayList2.get(var12));
      }

      ArrayList var13 = new ArrayList();
      var13.addAll(var11);
      var13.addAll(var4);
      C0745.SR.aK().b(var13, 0);
      C0745.SR.aK().aj(var13);
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();

      for (int var9 = 0; var9 <= 9; var9++) {
         var6.add((Club)arrayList.get(var9));
      }

      for (int var14 = 2; var14 <= 3; var14++) {
         var6.add((Club)this.YS.get(var14));
      }

      Collections.shuffle(var6);

      for (int var15 = 4; var15 <= 9; var15++) {
         var7.add((Club)this.YS.get(var15));
      }

      for (int var16 = 10; var16 <= 11; var16++) {
         var7.add((Club)arrayList.get(var16));
      }

      Collections.shuffle(var7);
      var8.addAll(var6);
      var8.addAll(var7);
      boolean[] var17 = new boolean[]{true, true, true, true, true, true, true};
      this.YR = new C0962(null, 20, this.b(), 1, var17, this, 4003);
      C0929 var10 = new C0929();
      var10.a(this.YR, var8, 0, var17[0], 0, 0, this.b(), false);
   }

   public void j(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 4003);
      }

      C0745.SR.aK().zo().addAll(arrayList2);
      C0745.SR.aK().b(arrayList2, 0);
      ArrayList var8 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 <= 5; var6++) {
         var8.add((Club)arrayList.get(var6));
      }

      for (int var9 = 0; var9 <= 1; var9++) {
         var8.add((Club)this.YS.get(var9));
      }

      Collections.shuffle(var8);

      for (int var10 = 6; var10 <= 9; var10++) {
         var4.add((Club)arrayList.get(var10));
      }

      Collections.shuffle(var4);
      var5.addAll(var8);
      var5.addAll(var4);
      boolean[] var11 = new boolean[]{true, true, true, true, true, true, true};
      this.ZB = new C0962(null, 12, this.b(), 1, var11, this, 4004);
      C0929 var7 = new C0929();
      var7.a(this.ZB, var5, 0, var11[0], 0, 0, this.b(), false);
   }

   public void k(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 4004);
      }

      C0745.SR.aK().zo().addAll(arrayList2);
      C0745.SR.aK().b(arrayList2, 0);
      this.YD = null;
      ArrayList var11 = new ArrayList();
      if (this.YF.size() == 26) {
         ArrayList var4 = new ArrayList();
         ArrayList var5 = new ArrayList();
         ArrayList var6 = new ArrayList();
         ArrayList var7 = new ArrayList();
         C0797[] var8 = new C0797[8];

         for (int var9 = 0; var9 <= 7; var9++) {
            var8[var9] = new C0797();
         }

         for (int var15 = 0; var15 <= 7; var15++) {
            var4.add((Club)this.YF.get(var15));
         }

         for (int var16 = 8; var16 <= 15; var16++) {
            var5.add((Club)this.YF.get(var16));
         }

         for (int var17 = 16; var17 <= 23; var17++) {
            var6.add((Club)this.YF.get(var17));
         }

         for (int var18 = 24; var18 <= 25; var18++) {
            var7.add((Club)this.YF.get(var18));
         }

         var7.addAll(arrayList);
         Collections.shuffle(var4);
         Collections.shuffle(var5);
         Collections.shuffle(var6);
         Collections.shuffle(var7);

         for (int var19 = 0; var19 <= 7; var19++) {
            var8[var19].a(var4, var5, var6, var7);
         }

         var8[0].a(var8);
         ArrayList var20 = new ArrayList();

         for (int var10 = 0; var10 < var8.length; var10++) {
            var20.add(var8[var10]);
         }

         Collections.shuffle(var20);

         for (int var21 = 0; var21 <= 7; var21++) {
            var11.addAll(((C0797)var20.get(var21)).cZ());
         }
      }

      if (var11.size() >= 32) {
         boolean[] var12 = new boolean[]{true, true, true, false, false, false, false};
         LeagueLoadOptions var13 = new LeagueLoadOptions();
         var13.nTimes = 32;
         var13.nGrupos = 8;
         var13.numeroTimesMataMata = 2;
         var13.doisTurnos = true;
         var13.pulaDuasDatas = false;
         var13.duasVoltasMataMata = var12;
         C0955 var14 = new C0955(var13, var11, 0, null, null, null, 4, null, false, null, true, this);
         var14.fb(4005);
         this.YD = var14;
         var14.setNome(this.getNome());
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

      C0745.SR.aK().b(var4, 1);
      Collections.shuffle(var1);
      Collections.shuffle(var2);
      C0797[] var8 = new C0797[8];

      for (int var6 = 0; var6 <= 7; var6++) {
         var8[var6] = new C0797();
      }

      for (int var9 = 0; var9 <= 7; var9++) {
         var8[var9].e(var1, var2);
      }

      var8[0].a(var8);

      for (int var10 = 0; var10 <= 7; var10++) {
         var3.addAll(var8[var10].cZ());
      }

      boolean[] var11 = new boolean[]{true, true, true, false, false, false, false};
      this.YD.c(new C0962(this.YD, var3.size(), this.b(), 0, var11, this, -1));
      C0929 var7 = new C0929();
      var7.a(this.YD.yY(), var3, 0, var11[0], 0, 0, this.b(), false);
   }

   public ArrayList yy() {
      return this.YF;
   }

   public void S(Club club) {
      this.YT = club;
   }

   public ArrayList yE() {
      return this.YS;
   }

   public Club zm() {
      return this.ZC;
   }

   public void T(Club club) {
      this.ZC = club;
   }

   public int zn() {
      return this.ZD;
   }

   public C0955 yd() {
      return this.YD;
   }

   public Club yz() {
      return this.YT;
   }

   public void N(Club club) {
      this.YT = club;
   }

   public C0962 yC() {
      return this.YJ;
   }

   @Override
   public void mr() {
      this.YD.za();
   }

   @Override
   public C0692 mF() {
      int var1 = C0745.SR.H() - 1;
      var1 %= 10;
      int[] var2 = new int[]{192, 162, 3, 104, 154, 97, 72, 152, 65, 52};
      return var1 < var2.length ? C0745.SR.s(var2[var1]) : null;
   }

   public static String yD() {
      int var0 = C0745.SR.H() - 1;
      var0 %= 10;
      String var1 = "";
      String[] var2 = new String[]{"Istambul", "São Petersburgo", "Munique", "Roma", "Lisboa", "Londres", "Paris", "Varsóvia", "Madrid", "Zagreb"};
      return var2[var0];
   }

   @Override
   public C0678[] mB() {
      C0678[] var1 = new C0678[]{this.YD};
      if (this.YD == null) {
         C0678[] var2 = new C0678[]{this.YJ, this.YP, this.YQ, this.YR, this.ZB};
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
      C0678[] var2 = new C0678[]{this.YJ, this.YP, this.YQ, this.YR, this.ZB};
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
      if (c0678 == this.YJ) {
         return C0710.pH;
      } else if (c0678 == this.YP) {
         return C0710.pI;
      } else if (c0678 == this.YQ) {
         return C0710.pJ;
      } else if (c0678 == this.YR) {
         return C0710.pK;
      } else {
         return c0678 == this.ZB ? C0710.pL : C0710.pA;
      }
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_ligacampeoes";
      var1[1] = this.getNome();
      return var1;
   }

   @Override
   public boolean cz(int i) {
      return this.YD != null && this.YD.yY() != null && this.YD.yY().zq() == i;
   }
}
