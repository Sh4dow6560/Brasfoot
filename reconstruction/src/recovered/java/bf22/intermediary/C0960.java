package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0960 extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private KnockoutStage YP = null;
   private KnockoutStage YQ = null;
   private LeagueStage YD = null;
   private KnockoutStage afT = null;
   private ArrayList YF = new ArrayList();
   private ArrayList YS = new ArrayList();
   private ArrayList ZE = new ArrayList();
   private Club ZA = null;
   private ArrayList YV = new ArrayList();
   private ArrayList YW = new ArrayList();
   private Club ago = null;

   public C0960() {
      this.setNome(C0679.getString("ligaE"));
      this.F(6, 0);
      this.yo();
      this.yp();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("ing", 97, 1, true));
      this.YV.add(new C0793("esp", 65, 1, true));
      this.YV.add(new C0793("ita", 104, 1, true));
      this.YV.add(new C0793("ale", 3, 1, true));
      this.YV.add(new C0793("fra", 72, 1, true));
      this.YV.add(new C0793("por", 154, 1, true));
      this.YV.add(new C0793("hol", 85, 1, true));
      this.YV.add(new C0793("fra", 72, 1, false));
      this.YV.add(new C0793("ing", 97, 1, false));
      this.YV.add(new C0793("esp", 65, 1, false));
      this.YV.add(new C0793("ita", 104, 1, false));
   }

   private void yp() {
      this.YW.clear();
      this.YW.add(new C0793("bel", 21, 1, true));
      this.YW.add(new C0793("aut", 15, 1, true));
      this.YW.add(new C0793("esc", 62, 1, true));
      this.YW.add(new C0793("ucr", 193, 1, true));
      this.YW.add(new C0793("tur", 192, 1, true));
      this.YW.add(new C0793("din", 54, 1, true));
      this.YW.add(new C0793("chipre", 44, 1, true));
      this.YW.add(new C0793("cze", 159, 1, true));
      this.YW.add(new C0793("serv", 171, 1, true));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(0, 2, this.YV, this.YW, i, c0792);
   }

   private void Bd() {
      ((C0793)this.YW.get(6)).fE(162);
   }

   public void yq() {
      if (GamePersistence.SR.H() == 3) {
         this.Bd();
      }

      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YF.clear();
      this.YS.clear();
      this.ZE.clear();
      this.YD = null;
      this.YP = null;
      this.YQ = null;
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      var2.addAll(GamePersistence.SR.aI().yy());
      var2.addAll(GamePersistence.SR.aI().yE());
      if (GamePersistence.SR.H() > 1 && this.ago != null && !GamePersistence.SR.aI().yy().contains(this.ago) && !GamePersistence.SR.aI().yE().contains(this.ago)) {
         this.YF.add(this.ago);
         var2.add(this.ago);
      } else {
         var1.add(new C0793("ale", 3, 1));
      }

      if (var1.size() > 0) {
         C0938.a(var1, this.YF, var2, false);
      }

      C0938.a(this.YV, this.YF, var2, false);
      C0938.a(this.YW, this.YS, var2, false);
      if (this.YF.size() < 12) {
         C0938.a(this.YF, this.YV, 12, var2);
      }

      if (this.YS.size() < 9) {
         C0938.a(this.YS, this.YW, 9, var2);
      }

      Collections.sort(this.YF, C1007.abm);
   }

   public void aj(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 <= 9; var5++) {
         var2.add((Club)arrayList.get(var5));
      }

      for (int var7 = 10; var7 <= 11; var7++) {
         var3.add((Club)arrayList.get(var7));
      }

      for (int var8 = 7; var8 <= 8; var8++) {
         var3.add((Club)this.YS.get(var8));
      }

      Collections.shuffle(var2);
      Collections.shuffle(var3);
      var4.addAll(var2);
      var4.addAll(var3);
      boolean[] var9 = new boolean[]{true, true, true, true, true, true, true};
      this.YP = new KnockoutStage(null, var4.size(), this.b(), 1, var9, this, 6001);
      KnockoutRound var6 = new KnockoutRound();
      var6.a(this.YP, var4, 0, var9[0], 0, 0, this.b(), false);
   }

   public void g(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 6001);
      }

      ArrayList var11 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      GamePersistence.SR.mj().zo().addAll(arrayList2);
      GamePersistence.SR.mj().b(arrayList2, 0);

      for (int var7 = 0; var7 <= 6; var7++) {
         var11.add((Club)this.YS.get(var7));
      }

      for (int var12 = 0; var12 <= 5; var12++) {
         var11.add((Club)this.ZE.get(var12));
      }

      var11.addAll(arrayList);
      Collections.shuffle(var11);

      for (int var13 = 0; var13 <= 9; var13++) {
         var4.add((Club)var11.get(var13));
      }

      for (int var14 = 10; var14 <= 19; var14++) {
         var5.add((Club)var11.get(var14));
      }

      Random var15 = new Random();
      C0797[] var8 = new C0797[10];

      for (int var9 = 0; var9 <= 9; var9++) {
         var8[var9] = new C0797();
      }

      for (int var16 = 0; var16 <= 9; var16++) {
         if (var15.nextBoolean()) {
            var8[var16].e(var4, var5);
         } else {
            var8[var16].e(var5, var4);
         }
      }

      for (int var17 = 0; var17 <= 9; var17++) {
         var6.addAll(var8[var17].cZ());
      }

      boolean[] var18 = new boolean[]{true, true, true, true, true, true, true};
      this.YQ = new KnockoutStage(null, var6.size(), this.b(), 1, var18, this, 6002);
      KnockoutRound var10 = new KnockoutRound();
      var10.a(this.YQ, var6, 0, var18[0], 0, 0, this.b(), false);
   }

   public void m(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 6004);
      }

      GamePersistence.SR.mj().zo().addAll(arrayList2);
      GamePersistence.SR.mj().b(arrayList2, 0);
      ArrayList var13 = new ArrayList();

      for (int var4 = 6; var4 <= 15; var4++) {
         var13.add((Club)this.ZE.get(var4));
      }

      var13.addAll(arrayList);
      var13.addAll(this.YF);
      Collections.sort(var13, C1007.abm);
      ArrayList var14 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();

      for (int var8 = 0; var8 <= 7; var8++) {
         var14.add((Club)var13.get(var8));
      }

      for (int var15 = 8; var15 <= 15; var15++) {
         var5.add((Club)var13.get(var15));
      }

      for (int var16 = 16; var16 <= 23; var16++) {
         var6.add((Club)var13.get(var16));
      }

      for (int var17 = 24; var17 <= 31; var17++) {
         var7.add((Club)var13.get(var17));
      }

      Collections.shuffle(var14);
      Collections.shuffle(var5);
      Collections.shuffle(var6);
      Collections.shuffle(var7);
      C0797[] var18 = new C0797[8];

      for (int var9 = 0; var9 <= 7; var9++) {
         var18[var9] = new C0797();
      }

      for (int var19 = 0; var19 <= 7; var19++) {
         var18[var19].a(var14, var5, var6, var7);
      }

      var18[0].a(var18);
      ArrayList var20 = new ArrayList();

      for (int var10 = 0; var10 <= 7; var10++) {
         var20.addAll(var18[var10].cZ());
      }

      if (var20.size() == 32) {
         boolean[] var21 = new boolean[]{true, true, true, true, false, false, false};
         LeagueLoadOptions var11 = new LeagueLoadOptions();
         var11.nTimes = 32;
         var11.nGrupos = 8;
         var11.numeroTimesMataMata = 2;
         var11.doisTurnos = true;
         var11.pulaDuasDatas = false;
         var11.duasVoltasMataMata = var21;
         LeagueStage var12 = new LeagueStage(var11, var20, 0, null, null, null, 6, null, false, null, true, this);
         var12.fb(6005);
         this.YD = var12;
         var12.setNome(this.getNome());
      }
   }

   public void b(ArrayList arrayList, int i) {
      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         if (((Club)arrayList.get(var3)).jZ()) {
            if (i == 0) {
               new C0799(((Club)arrayList.get(var3)).ka(), 30, 85, "", "");
            } else {
               new C0799(((Club)arrayList.get(var3)).ka(), 31, 86, "", "");
            }
         }
      }
   }

   public void Be() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < this.YD.yQ().size(); var4++) {
         var1.add((Club)((C0673)this.YD.yQ().get(var4)).gR().get(1));
      }

      for (int var7 = 0; var7 < GamePersistence.SR.aI().yd().yQ().size(); var7++) {
         var2.add((Club)((C0673)GamePersistence.SR.aI().yd().yQ().get(var7)).gR().get(2));
      }

      Collections.shuffle(var1);
      Collections.shuffle(var2);
      C0797[] var8 = new C0797[8];

      for (int var5 = 0; var5 <= 7; var5++) {
         var8[var5] = new C0797();
      }

      for (int var9 = 0; var9 <= 7; var9++) {
         var8[var9].e(var1, var2);
      }

      var8[0].a(var8);

      for (int var10 = 0; var10 <= 7; var10++) {
         var3.addAll(var8[var10].cZ());
      }

      boolean[] var11 = new boolean[]{true, true, true, false, false, false, false};
      this.YD.c(new KnockoutStage(this.YD, var3.size(), this.b(), 1, var11, this, 6006));
      KnockoutRound var6 = new KnockoutRound();
      var6.a(this.YD.yY(), var3, 0, var11[0], 0, 0, this.b(), false);
   }

   public void l(ArrayList arrayList, ArrayList arrayList2) {
      for (int var3 = 0; var3 < arrayList2.size(); var3++) {
         ((Club)arrayList2.get(var3)).a(this, -1, 6006);
      }

      ArrayList var9 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 < this.YD.yQ().size(); var6++) {
         var9.add((Club)((C0673)this.YD.yQ().get(var6)).gR().get(0));
      }

      for (int var10 = 0; var10 < arrayList.size(); var10++) {
         var4.add((Club)arrayList.get(var10));
      }

      Collections.shuffle(var9);
      Collections.shuffle(var4);
      C0797[] var11 = new C0797[8];

      for (int var7 = 0; var7 <= 7; var7++) {
         var11[var7] = new C0797();
      }

      for (int var12 = 0; var12 <= 7; var12++) {
         var11[var12].e(var9, var4);
      }

      var11[0].a(var11);

      for (int var13 = 0; var13 <= 7; var13++) {
         var5.addAll(var11[var13].cZ());
      }

      boolean[] var14 = new boolean[]{true, true, true, false, false, false, false};
      this.afT = new KnockoutStage(null, var5.size(), this.b(), 0, var14, this, -1);
      KnockoutRound var8 = new KnockoutRound();
      var8.a(this.afT, var5, 0, var14[0], 0, 0, this.b(), false);
   }

   public ArrayList yy() {
      return this.YF;
   }

   public ArrayList yE() {
      return this.YS;
   }

   public Club yz() {
      return this.ZA;
   }

   public void N(Club club) {
      this.ZA = club;
   }

   public LeagueStage yd() {
      return this.YD;
   }

   @Override
   public void mr() {
      this.YD.f(this.afT);
   }

   @Override
   public CountryCompetitions mF() {
      int var1 = GamePersistence.SR.H() - 1;
      var1 %= 10;
      int[] var2 = new int[]{152, 65, 52, 31, 21, 154, 3, 72, 162, 97};
      return var1 < var2.length ? GamePersistence.SR.s(var2[var1]) : null;
   }

   public static String yD() {
      int var0 = GamePersistence.SR.H() - 1;
      var0 %= 10;
      String var1 = "";
      String[] var2 = new String[]{"Gdansk", "Sevilla", "Zagreb", "Sofia", "Bruxelas", "Porto", "Frankfurt", "Lyon", "Moscou", "Liverpool"};
      return var2[var0];
   }

   @Override
   public CompetitionStage[] mB() {
      CompetitionStage[] var1 = new CompetitionStage[]{this.YD};
      if (this.YD == null) {
         CompetitionStage[] var2 = new CompetitionStage[]{this.YP, this.YQ};
         var1 = var2;
      } else if (this.YD.yY() != null) {
         CompetitionStage[] var3 = new CompetitionStage[]{this.YD.yY(), this.afT};
         var1 = var3;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      CompetitionStage[] var2 = new CompetitionStage[]{this.YP, this.YQ};
      var1.add(new C0830(var2, "Fase Preliminar"));
      CompetitionStage[] var3 = new CompetitionStage[]{this.YD};
      var1.add(new C0830(var3, "Fase de Grupos"));
      if (this.YD != null && this.YD.yY() != null) {
         CompetitionStage[] var4 = new CompetitionStage[]{this.YD.yY(), this.afT};
         var1.add(new C0830(var4, "Fase Final"));
      } else {
         var1.add(new C0830(null, "Fase Final"));
      }

      return var1;
   }

   @Override
   public String[] b(CompetitionStage c0678) {
      if (c0678 == this.YP) {
         return GameConstants.pN;
      } else if (c0678 == this.YQ) {
         return GameConstants.pO;
      } else {
         return this.YD != null && c0678 == this.YD.yY() ? GameConstants.abY : GameConstants.pA;
      }
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_ligaeuropa";
      var1[1] = this.getNome();
      return var1;
   }

   public ArrayList zo() {
      return this.ZE;
   }

   @Override
   public boolean cz(int i) {
      return this.afT != null && this.afT.zq() == i;
   }

   public void ab(Club club) {
      this.ago = club;
   }

   public Club BA() {
      return this.ago;
   }
}
