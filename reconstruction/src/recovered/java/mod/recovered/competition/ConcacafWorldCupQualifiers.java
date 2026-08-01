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

public class ConcacafWorldCupQualifiers extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage agb = null;
   private LeagueStage afX = null;
   private ArrayList agc = new ArrayList();
   private KnockoutStage agd = null;
   private Club afW = null;

   public ConcacafWorldCupQualifiers() {
      this.F(9, 4);
   }

   public void xZ() {
      if (this.afX != null) {
         this.afX.aN(true);
      }

      this.agb = null;
      this.afX = null;
      this.agc.clear();
      this.afW = null;
   }

   public void Bj() {
      this.agc.clear();
      new ArrayList();
      ArrayList var2 = new ArrayList();
      int[] var3 = new int[]{
         131, 68, 51, 106, 86, 58, 38, 8, 147, 84, 189, 7, 79, 166, 181, 139, 158, 77, 20, 80, 168, 24, 22, 165, 153, 53, 212, 56, 90, 17, 13, 213, 211, 94, 6
      };
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < var3.length; var5++) {
         CountryCompetitions var6 = GamePersistence.careerState.s(var3[var5]);
         var4.add(var6.jo());
         var6.z(true);
      }

      Collections.sort(var4, C1007.cN);

      for (int var12 = 0; var12 <= 4; var12++) {
         this.agc.add((Club)var4.get(var12));
      }

      ArrayList var13 = new ArrayList();
      ArrayList var14 = new ArrayList();
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();
      ArrayList var9 = new ArrayList();

      for (int var10 = 5; var10 <= 10; var10++) {
         var13.add((Club)var4.get(var10));
      }

      for (int var15 = 11; var15 <= 16; var15++) {
         var14.add((Club)var4.get(var15));
      }

      for (int var16 = 17; var16 <= 22; var16++) {
         var7.add((Club)var4.get(var16));
      }

      for (int var17 = 23; var17 <= 28; var17++) {
         var8.add((Club)var4.get(var17));
      }

      for (int var18 = 29; var18 <= 34; var18++) {
         var9.add((Club)var4.get(var18));
      }

      for (int var19 = 0; var19 <= 5; var19++) {
         var2.add((Club)var13.get(var19));
         var2.add((Club)var14.get(var19));
         var2.add((Club)var7.get(var19));
         var2.add((Club)var8.get(var19));
         var2.add((Club)var9.get(var19));
      }

      Collections.shuffle(var13);
      Collections.shuffle(var14);
      Collections.shuffle(var7);
      Collections.shuffle(var8);
      Collections.shuffle(var9);
      LeagueLoadOptions var20 = new LeagueLoadOptions();
      var20.nTimes = 30;
      var20.nGrupos = 6;
      var20.doisTurnos = false;
      LeagueStage var11 = new LeagueStage(var20, var2, 0, null, null, null, 9, null, false, null, true, this);
      this.agb = var11;
      var11.setNome(this.getNome());
      var11.fb(9400);
      GamePersistence.coachJobMarket.L(var2);
      GamePersistence.coachJobMarket.L(this.agc);
   }

   public void Bp() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < this.agb.yQ().size(); var2++) {
         var1.add((Club)((C0673)this.agb.yQ().get(var2)).gR().get(0));
      }

      boolean[] var4 = new boolean[]{true, true, true, false, false, false, false};
      this.agd = new KnockoutStage(null, var1.size(), this.b(), 1, var4, this, 9401);
      KnockoutRound var3 = new KnockoutRound();
      var3.a(this.agd, var1, 0, var4[0], 0, 0, this.b(), false);
   }

   public void ay(ArrayList arrayList) {
      this.agc.addAll(arrayList);
      LeagueLoadOptions var2 = new LeagueLoadOptions();
      var2.nTimes = 8;
      var2.doisTurnos = true;
      LeagueStage var3 = new LeagueStage(var2, this.agc, 0, null, null, null, this.b(), null, false, null, true, this);
      var3.fb(9402);
      this.afX = var3;
      var3.setNome(this.getNome());
   }

   public void Bm() {
      for (int var1 = 0; var1 < 6; var1++) {
         GamePersistence.careerState.aY().a(this, GamePersistence.careerState.s(((Club)this.afX.yK().get(var1)).getPais()));
      }

      this.afW = (Club)this.afX.yK().get(6);
      GamePersistence.careerState.bQ().X((Club)this.afX.yK().get(7));
   }

   public void Y(Club club) {
      GamePersistence.careerState.aY().a(this, GamePersistence.careerState.s(club.getPais()));
   }

   @Override
   public CompetitionStage[] mB() {
      CompetitionStage[] var1 = new CompetitionStage[]{this.agd};
      if (this.agd == null) {
         CompetitionStage[] var2 = new CompetitionStage[]{this.agb};
         var1 = var2;
      } else if (this.afX != null) {
         CompetitionStage[] var3 = new CompetitionStage[]{this.afX};
         var1 = var3;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      CompetitionStage[] var2 = new CompetitionStage[]{this.agb};
      var1.add(new C0830(var2, "Fase Preliminar"));
      CompetitionStage[] var3 = new CompetitionStage[]{this.agd};
      var1.add(new C0830(var3, "Fase Intermediária"));
      CompetitionStage[] var4 = new CompetitionStage[]{this.afX};
      var1.add(new C0830(var4, "Fase Final"));
      CompetitionStage[] var5 = new CompetitionStage[]{GamePersistence.careerState.bQ().Bo()};
      var1.add(new C0830(var5, "Torneio Repescagem"));
      return var1;
   }

   public Club Bl() {
      return this.afW;
   }
}
