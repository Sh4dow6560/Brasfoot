package mod.recovered.competition;

import bf22.intermediary.*;
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

public class AfricaWorldCupQualifiers extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private KnockoutStage YJ = null;
   private KnockoutStage afV = null;
   private ArrayList YF = new ArrayList();
   private Club afW = null;

   public AfricaWorldCupQualifiers() {
      this.F(9, 2);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.YJ = null;
      this.afV = null;
      this.YF.clear();
      this.afW = null;
   }

   public void Bj() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < GamePersistence.careerState.aG().size(); var4++) {
         if (((CountryCompetitions)GamePersistence.careerState.aG().get(var4)).jo() != null && ((CountryCompetitions)GamePersistence.careerState.aG().get(var4)).gg() == 2) {
            var1.add((CountryCompetitions)GamePersistence.careerState.aG().get(var4));
         }
      }

      Collections.sort(var1, CountryCompetitions.cN);

      for (int var8 = 0; var8 < var1.size(); var8++) {
         var2.add(((CountryCompetitions)var1.get(var8)).jo());
      }

      for (int var9 = 0; var9 <= 25; var9++) {
         this.YF.add((Club)var2.get(var9));
      }

      ArrayList var10 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 26; var6 <= 39; var6++) {
         var10.add((Club)var2.get(var6));
      }

      for (int var11 = 40; var11 <= 53; var11++) {
         var5.add((Club)var2.get(var11));
      }

      for (int var12 = 0; var12 < var10.size(); var12++) {
         var3.add((Club)var10.get(var12));
         var3.add((Club)var5.get(var12));
      }

      for (int var13 = 0; var13 < this.YF.size(); var13++) {
         GamePersistence.careerState.s(((Club)this.YF.get(var13)).getPais()).z(true);
      }

      for (int var14 = 0; var14 < var3.size(); var14++) {
         GamePersistence.careerState.s(((Club)var3.get(var14)).getPais()).z(true);
      }

      boolean[] var15 = new boolean[]{true, true, true, true, true, true, true};
      this.YJ = new KnockoutStage(null, var3.size(), this.b(), 1, var15, this, 9200);
      KnockoutRound var7 = new KnockoutRound();
      var7.a(this.YJ, var3, 0, var15[0], 0, 0, this.b(), false);
      GamePersistence.coachJobMarket.L(var3);
      GamePersistence.coachJobMarket.L(this.YF);
   }

   public void Bk() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < this.YD.yQ().size(); var3++) {
         var2.add((Club)((C0673)this.YD.yQ().get(var3)).gR().get(1));
      }

      LeagueStage.r(this.YD);
      Collections.sort(var2, C1007.abn);

      for (int var5 = 0; var5 <= 3; var5++) {
         var1.add((Club)var2.get(var5));
      }

      Collections.shuffle(var1);
      boolean[] var6 = new boolean[]{true, true, true, true, true, true, true};
      this.afV = new KnockoutStage(null, var1.size(), this.b(), 0, var6, this, 9202);
      KnockoutRound var4 = new KnockoutRound();
      var4.a(this.afV, var1, 0, var6[0], 0, 0, this.b(), false);
   }

   public void p(ArrayList arrayList, ArrayList arrayList2) {
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < this.YD.yQ().size(); var4++) {
         var3.add((Club)((C0673)this.YD.yQ().get(var4)).gR().get(0));
      }

      var3.add((Club)arrayList.get(0));
      this.afW = (Club)arrayList2.get(0);

      for (int var5 = 0; var5 < var3.size(); var5++) {
         GamePersistence.careerState.aY().a(this, GamePersistence.careerState.s(((Club)var3.get(var5)).getPais()));
      }
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

      for (int var7 = 0; var7 <= 9; var7++) {
         var3.add((Club)var2.get(var7));
      }

      for (int var11 = 10; var11 <= 19; var11++) {
         var4.add((Club)var2.get(var11));
      }

      for (int var12 = 20; var12 <= 29; var12++) {
         var5.add((Club)var2.get(var12));
      }

      for (int var13 = 30; var13 <= 39; var13++) {
         var6.add((Club)var2.get(var13));
      }

      Collections.shuffle(var3);
      Collections.shuffle(var4);
      Collections.shuffle(var5);
      Collections.shuffle(var6);
      ArrayList var14 = new ArrayList();

      for (int var8 = 0; var8 <= 9; var8++) {
         var14.add((Club)var3.get(var8));
         var14.add((Club)var4.get(var8));
         var14.add((Club)var5.get(var8));
         var14.add((Club)var6.get(var8));
      }

      if (var14.size() == 40) {
         boolean[] var15 = new boolean[]{true, true, true, true, false, false, false};
         LeagueLoadOptions var9 = new LeagueLoadOptions();
         var9.nTimes = 40;
         var9.nGrupos = 8;
         var9.numeroTimesMataMata = 1;
         var9.doisTurnos = true;
         var9.pulaDuasDatas = false;
         var9.duasVoltasMataMata = var15;
         LeagueStage var10 = new LeagueStage(var9, var14, 0, null, null, null, this.b(), null, false, null, true, this);
         var10.fb(9201);
         this.YD = var10;
         var10.setNome(this.getNome());
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
      CompetitionStage[] var1 = new CompetitionStage[]{this.YD};
      if (this.YD == null) {
         CompetitionStage[] var2 = new CompetitionStage[]{this.YJ};
         var1 = var2;
      } else if (this.afV != null) {
         CompetitionStage[] var3 = new CompetitionStage[]{this.afV};
         var1 = var3;
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
      if (this.afV != null) {
         CompetitionStage[] var4 = new CompetitionStage[]{this.afV};
         var1.add(new C0830(var4, "Play-offs"));
      }

      return var1;
   }

   public Club Bl() {
      return this.afW;
   }
}
