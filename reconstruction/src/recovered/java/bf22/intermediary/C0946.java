package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0946 extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private LeagueStage afX = null;
   private KnockoutStage YJ = null;
   private KnockoutStage afY = null;
   private ArrayList YF = new ArrayList();
   private LeagueStage afZ = null;
   private Club aga = null;

   public C0946() {
      this.F(9, 3);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.afZ = null;
      this.YD = null;
      this.YJ = null;
      this.afX = null;
      this.afY = null;
      this.aga = null;
      this.YF.clear();
   }

   public void Bj() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < GamePersistence.SR.aG().size(); var4++) {
         if (((CountryCompetitions)GamePersistence.SR.aG().get(var4)).jo() != null && ((CountryCompetitions)GamePersistence.SR.aG().get(var4)).gg() == 3) {
            var1.add((CountryCompetitions)GamePersistence.SR.aG().get(var4));
         }
      }

      Collections.sort(var1, CountryCompetitions.cN);

      for (int var8 = 0; var8 < var1.size(); var8++) {
         var2.add(((CountryCompetitions)var1.get(var8)).jo());
      }

      for (int var9 = 0; var9 <= 33; var9++) {
         this.YF.add((Club)var2.get(var9));
      }

      ArrayList var10 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 34; var6 <= 39; var6++) {
         var10.add((Club)var2.get(var6));
      }

      for (int var11 = 40; var11 <= 45; var11++) {
         var5.add((Club)var2.get(var11));
      }

      for (int var12 = 0; var12 < var10.size(); var12++) {
         var3.add((Club)var10.get(var12));
         var3.add((Club)var5.get(var12));
      }

      for (int var13 = 0; var13 < this.YF.size(); var13++) {
         GamePersistence.SR.s(((Club)this.YF.get(var13)).getPais()).z(true);
      }

      for (int var14 = 0; var14 < var3.size(); var14++) {
         GamePersistence.SR.s(((Club)var3.get(var14)).getPais()).z(true);
      }

      boolean[] var15 = new boolean[]{true, true, true, true, true, true, true};
      this.YJ = new KnockoutStage(null, var3.size(), this.b(), 1, var15, this, 9300);
      KnockoutRound var7 = new KnockoutRound();
      var7.a(this.YJ, var3, 0, var15[0], 0, 0, this.b(), false);
      GamePersistence.afQ.L(var3);
      GamePersistence.afQ.L(this.YF);
   }

   public void aw(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      var2.addAll(arrayList);
      var2.addAll(this.YF);
      Collections.sort(var2, C1007.abm);
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();

      for (int var8 = 0; var8 <= 7; var8++) {
         var3.add((Club)var2.get(var8));
      }

      for (int var12 = 8; var12 <= 15; var12++) {
         var4.add((Club)var2.get(var12));
      }

      for (int var13 = 16; var13 <= 23; var13++) {
         var5.add((Club)var2.get(var13));
      }

      for (int var14 = 24; var14 <= 31; var14++) {
         var6.add((Club)var2.get(var14));
      }

      for (int var15 = 32; var15 <= 39; var15++) {
         var7.add((Club)var2.get(var15));
      }

      Collections.shuffle(var3);
      Collections.shuffle(var4);
      Collections.shuffle(var5);
      Collections.shuffle(var6);
      Collections.shuffle(var7);
      ArrayList var16 = new ArrayList();

      for (int var9 = 0; var9 <= 7; var9++) {
         var16.add((Club)var3.get(var9));
         var16.add((Club)var4.get(var9));
         var16.add((Club)var5.get(var9));
         var16.add((Club)var6.get(var9));
         var16.add((Club)var7.get(var9));
      }

      if (var16.size() == 40) {
         boolean[] var17 = new boolean[]{true, true, true, true, false, false, false};
         LeagueLoadOptions var10 = new LeagueLoadOptions();
         var10.nTimes = 40;
         var10.nGrupos = 8;
         var10.doisTurnos = true;
         var10.pulaDuasDatas = false;
         var10.duasVoltasMataMata = var17;
         LeagueStage var11 = new LeagueStage(var10, var16, 0, null, null, null, this.b(), null, false, null, true, this);
         var11.fb(9301);
         this.YD = var11;
         var11.setNome(this.getNome());
      }
   }

   public void yt() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < this.YD.yQ().size(); var4++) {
         var1.add((Club)((C0673)this.YD.yQ().get(var4)).gR().get(0));
      }

      for (int var9 = 0; var9 < this.YD.yQ().size(); var9++) {
         var3.add((Club)((C0673)this.YD.yQ().get(var9)).gR().get(1));
      }

      LeagueStage.r(this.YD);
      Collections.sort(var3, C1007.abn);

      for (int var10 = 0; var10 <= 3; var10++) {
         var1.add((Club)var3.get(var10));
      }

      Collections.sort(var1, C1007.cN);
      ArrayList var11 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 <= 5; var6++) {
         var11.add((Club)var1.get(var6));
      }

      for (int var12 = 6; var12 <= 11; var12++) {
         var5.add((Club)var1.get(var12));
      }

      for (int var13 = 0; var13 < var11.size(); var13++) {
         var2.add((Club)var11.get(var13));
         var2.add((Club)var5.get(var13));
      }

      if (var2.size() == 12) {
         boolean[] var14 = new boolean[]{true, true, true, true, false, false, false};
         LeagueLoadOptions var7 = new LeagueLoadOptions();
         var7.nTimes = 12;
         var7.nGrupos = 2;
         var7.doisTurnos = true;
         var7.pulaDuasDatas = false;
         var7.duasVoltasMataMata = var14;
         LeagueStage var8 = new LeagueStage(var7, var2, 0, null, null, null, this.b(), null, false, null, true, this);
         var8.fb(9302);
         this.afX = var8;
         var8.setNome(this.getNome());
      }
   }

   public void Bm() {
      for (int var1 = 0; var1 < this.afX.yQ().size(); var1++) {
         GamePersistence.SR.aY().a(this, GamePersistence.SR.s(((Club)((C0673)this.afX.yQ().get(var1)).gR().get(0)).getPais()));
         GamePersistence.SR.aY().a(this, GamePersistence.SR.s(((Club)((C0673)this.afX.yQ().get(var1)).gR().get(1)).getPais()));
         GamePersistence.SR.aY().a(this, GamePersistence.SR.s(((Club)((C0673)this.afX.yQ().get(var1)).gR().get(2)).getPais()));
         GamePersistence.SR.aY().a(this, GamePersistence.SR.s(((Club)((C0673)this.afX.yQ().get(var1)).gR().get(3)).getPais()));
      }

      ArrayList var4 = new ArrayList();
      var4.add((Club)((C0673)this.afX.yQ().get(0)).gR().get(4));
      var4.add((Club)((C0673)this.afX.yQ().get(1)).gR().get(4));
      boolean[] var2 = new boolean[]{false, false, false, false, true, true, true};
      this.afY = new KnockoutStage(null, var4.size(), this.b(), 1, var2, this, 9303);
      KnockoutRound var3 = new KnockoutRound();
      var3.a(this.afY, var4, 0, var2[0], 0, 0, this.b(), false);
   }

   public void ax(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      var2.add(GamePersistence.SR.bK().Br());
      var2.add((Club)arrayList.get(0));
      var2.add(GamePersistence.SR.bR().Bl());
      var2.add(this.aga);
      var2.add(GamePersistence.SR.bM().Bl());
      var2.add(GamePersistence.SR.bS().Br());
      LeagueLoadOptions var3 = new LeagueLoadOptions();
      var3.nTimes = 6;
      var3.doisTurnos = false;
      LeagueStage var4 = new LeagueStage(var3, var2, 0, null, null, null, this.b(), null, false, null, true, this);
      var4.fb(7701);
      this.afZ = var4;
      var4.setNome("Eliminatórias - Repescagem");
   }

   public void Bn() {
      for (int var1 = 0; var1 <= 1; var1++) {
         GamePersistence.SR.aY().a(this, GamePersistence.SR.s(((Club)this.Bo().yK().get(var1)).getPais()));
      }
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"Sorteio 1", "Sorteio 2", "Sorteio 3", "Sorteio 4", "Sorteio 5", "Sorteio 6", "Sorteio 7", "Sorteio 8"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   public LeagueStage yd() {
      return this.YD;
   }

   public void p(LeagueStage c0955) {
      this.YD = c0955;
   }

   @Override
   public CompetitionStage[] mB() {
      CompetitionStage[] var1 = new CompetitionStage[]{this.YJ};
      if (this.afZ != null) {
         CompetitionStage[] var2 = new CompetitionStage[]{this.afZ};
         var1 = var2;
      } else if (this.afX != null) {
         CompetitionStage[] var3 = new CompetitionStage[]{this.afX};
         var1 = var3;
      } else if (this.YD != null) {
         CompetitionStage[] var4 = new CompetitionStage[]{this.YD};
         var1 = var4;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      CompetitionStage[] var2 = new CompetitionStage[]{this.YJ};
      var1.add(new C0830(var2, "Fase Preliminar"));
      CompetitionStage[] var3 = new CompetitionStage[]{this.YD};
      var1.add(new C0830(var3, "Fase de Grupos"));
      if (this.YD != null && this.afX != null) {
         CompetitionStage[] var4 = new CompetitionStage[]{this.afX};
         var1.add(new C0830(var4, "Fase Final"));
      } else {
         var1.add(new C0830(null, "Fase Final"));
      }

      if (this.afY != null) {
         CompetitionStage[] var5 = new CompetitionStage[]{this.afY};
         var1.add(new C0830(var5, "Pré-repescagem"));
      } else {
         var1.add(new C0830(null, "Pré-repescagem"));
      }

      CompetitionStage[] var6 = new CompetitionStage[]{GamePersistence.SR.bQ().Bo()};
      var1.add(new C0830(var6, "Repescagem"));
      return var1;
   }

   public LeagueStage Bo() {
      return this.afZ;
   }

   public void X(Club club) {
      this.aga = club;
   }
}
