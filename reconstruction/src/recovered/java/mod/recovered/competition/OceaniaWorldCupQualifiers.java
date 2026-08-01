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

public class OceaniaWorldCupQualifiers extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage agb = null;
   private LeagueStage YD = null;
   private ArrayList YF = new ArrayList();
   private KnockoutStage afT = null;
   private Club agf = null;

   public OceaniaWorldCupQualifiers() {
      this.F(9, 5);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.agb = null;
      this.agf = null;
      this.afT = null;
      this.YF.clear();
   }

   public void Bj() {
      this.YF.clear();
      ArrayList var1 = new ArrayList();
      int[] var2 = new int[]{214, 91, 163, 188, 69, 215, 143, 148, 93, 184, 197};
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2.length; var4++) {
         CountryCompetitions var5 = GamePersistence.careerState.s(var2[var4]);
         var3.add(var5.jo());
         var5.z(true);
      }

      Collections.sort(var3, C1007.cN);

      for (int var6 = 0; var6 <= 6; var6++) {
         this.YF.add((Club)var3.get(var6));
      }

      for (int var7 = 7; var7 < var3.size(); var7++) {
         var1.add((Club)var3.get(var7));
      }

      LeagueLoadOptions var8 = new LeagueLoadOptions();
      var8.nTimes = 4;
      var8.nGrupos = 0;
      var8.doisTurnos = true;
      LeagueStage var9 = new LeagueStage(var8, var1, 0, null, null, null, 9, null, false, null, true, this);
      this.agb = var9;
      var9.setNome(this.getNome());
      var9.fb(9500);
      GamePersistence.coachJobMarket.L(var1);
      GamePersistence.coachJobMarket.L(this.YF);
   }

   public void yt() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < this.YD.yQ().size(); var2++) {
         var1.add((Club)((C0673)this.YD.yQ().get(var2)).gR().get(0));
         var1.add((Club)((C0673)this.YD.yQ().get(var2)).gR().get(1));
      }

      boolean[] var4 = new boolean[]{true, true, true, false, false, false, false};
      this.afT = new KnockoutStage(null, var1.size(), this.b(), 0, var4, this, 9502);
      KnockoutRound var3 = new KnockoutRound();
      var3.a(this.afT, var1, 0, var4[0], 0, 0, this.b(), false);
   }

   public void Bq() {
      this.YF.add((Club)this.agb.yK().get(0));
      LeagueLoadOptions var1 = new LeagueLoadOptions();
      var1.nTimes = 8;
      var1.nGrupos = 2;
      var1.doisTurnos = true;
      LeagueStage var2 = new LeagueStage(var1, this.YF, 0, null, null, null, 9, null, false, null, true, this);
      this.YD = var2;
      var2.setNome(this.getNome());
      var2.fb(9501);
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"5º A. Sul", "1º Oceania"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
   }

   public void p(ArrayList arrayList, ArrayList arrayList2) {
      GamePersistence.careerState.aY().a(this, GamePersistence.careerState.s(((Club)arrayList.get(0)).getPais()));
      this.agf = (Club)arrayList2.get(0);
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
         CompetitionStage[] var2 = new CompetitionStage[]{this.agb};
         var1 = var2;
      } else if (this.afT != null) {
         CompetitionStage[] var3 = new CompetitionStage[]{this.afT};
         var1 = var3;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      CompetitionStage[] var2 = new CompetitionStage[]{this.agb};
      var1.add(new C0830(var2, "Fase Preliminar"));
      CompetitionStage[] var3 = new CompetitionStage[]{this.YD};
      var1.add(new C0830(var3, "Fase de Grupos"));
      CompetitionStage[] var4 = new CompetitionStage[]{this.afT};
      var1.add(new C0830(var4, "Fase Final"));
      CompetitionStage[] var5 = new CompetitionStage[]{GamePersistence.careerState.bQ().Bo()};
      var1.add(new C0830(var5, "Torneio Repescagem"));
      return var1;
   }

   public Club Br() {
      return this.agf;
   }
}
