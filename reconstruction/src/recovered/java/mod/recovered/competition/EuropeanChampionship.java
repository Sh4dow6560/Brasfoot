package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.LeagueStage;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class EuropeanChampionship extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private ArrayList YE = new ArrayList();
   private ArrayList YF = new ArrayList();
   private CountryCompetitions YG = null;
   private int YH = 0;
   private ArrayList YM = new ArrayList();

   public EuropeanChampionship() {
      this.F(7, 0);
      this.O(true);
   }

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.YE.clear();
      this.YF.clear();
   }

   public void ya() {
      this.YE.clear();
      this.YF.clear();
      this.YD = null;
      byte var1 = 23;
      this.YH++;
      this.YG = this.yb();
      this.YE.addAll(this.YM);
      this.YM.clear();
      if (this.YE.size() == 24) {
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < this.YE.size(); var3++) {
            var2.add(((CountryCompetitions)this.YE.get(var3)).jo());
            ((CountryCompetitions)this.YE.get(var3)).z(true);
         }

         Collections.sort(this.YF, C1007.cN);
         ArrayList var7 = C1007.ad(6, 4);

         for (int var4 = 0; var4 < var7.size(); var4++) {
            this.YF.add((Club)var2.get((Integer)var7.get(var4)));
         }

         boolean[] var8 = new boolean[7];
         LeagueLoadOptions var5 = new LeagueLoadOptions();
         var5.nTimes = 24;
         var5.nGrupos = 6;
         var5.numeroTimesMataMata = 2;
         var5.doisTurnos = false;
         var5.duasVoltasMataMata = var8;
         var5.melhoresTerceiros = true;
         LeagueStage var6 = new LeagueStage(var5, this.YF, 0, null, null, null, 7, null, false, null, true, this);
         this.YD = var6;
         var6.setNome(this.getNome());
         GamePersistence.afQ.L(this.YF);
      }
   }

   @Override
   public int cy(int i) {
      int var2 = this.YH - 1;
      var2 %= 10;
      int var3 = 45000;
      int[] var4 = new int[]{80000, 75000, 72698, 68134, 55600, 44990, 47215, 38065};
      if (i <= 7) {
         var3 = var4[i];
      } else if (i - 8 < var4.length) {
         var3 = var4[i - 8];
      }

      return var3;
   }

   @Override
   public String cx(int i) {
      int var2 = this.YH - 1;
      var2 %= 10;
      String[][] var3 = new String[][]{
         {"Berlim", "Munique", "Hamburgo", "Dortmund", "Frankfurt", "Hannover", "Leipzig", "Nuremberg"},
         {"Roma", "Milão", "Turim", "Bologna", "Cagliari", "Gênoa", "Florença", "Udine"},
         {"Londres", "Liverpool", "Manchester", "Notthingam", "Leeds", "Coventry", "Sheffield", "Bristol"},
         {"Madrid", "Sevilha", "Valencia", "Vigo", "Málaga", "Valladolid", "Barcelona", "Gijón"},
         {"Lisboa", "Porto", "Coimbra", "Setúbal", "Aveiro", "Faro", "Braga", "Viseu"},
         {"Moscou", "São Petesburgo", "Kazan", "Kaliningrad", "Yaroslavl", "Samara", "Volgograd", "Yekaterinburg"},
         {"Kiev", "Carcóvia", "Odessa", "Dnipro", "Donetsk", "Zaporizhzhya", "Lviv", "Mariupol"},
         {"Atenas", "Tessalônica", "Patras", "Larissa", "Heraclião", "Vólos", "Trícala", "Cálcis"},
         {"Paris", "Marselha", "Lyon", "Toulouse", "Nice", "Nantes", "Estrasburgo", "Montpellier"},
         {"Varsóvia", "Cracóvia", "Lodz", "Breslávia", "Poznan", "Gdansk", "Lublin", "Katowice"}
      };
      String var4 = null;
      if (i < var3[var2].length) {
         var4 = var3[var2][i];
      } else if (i - var3[var2].length < var3[var2].length) {
         var4 = var3[var2][i - var3[var2].length];
      } else {
         var4 = var3[var2][0];
      }

      return var4;
   }

   public CountryCompetitions yb() {
      int var1 = this.YH - 1;
      var1 %= 10;
      int[] var2 = new int[]{72, 3, 104, 97, 65, 154, 162, 193, 78, 152};
      if (var1 == 0) {
         return null;
      } else {
         return var1 >= 0 && var1 < var2.length ? GamePersistence.SR.s(var2[var1]) : null;
      }
   }

   public LeagueStage yd() {
      return this.YD;
   }

   public void p(LeagueStage c0955) {
      this.YD = c0955;
   }

   public void a(Competition c0713, CountryCompetitions c0692) {
      this.YM.add(c0692);
      c0692.jo().e(c0713, 1);
   }

   @Override
   public CompetitionStage[] mB() {
      CompetitionStage[] var1 = new CompetitionStage[]{this.YD};
      if (this.YD.yZ()) {
         CompetitionStage[] var2 = new CompetitionStage[]{this.YD.yY()};
         var1 = var2;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      CompetitionStage[] var2 = new CompetitionStage[]{this.YD};
      var1.add(new C0830(var2, "Fase de Grupos"));
      CompetitionStage[] var3 = new CompetitionStage[]{this.YD.yY()};
      var1.add(new C0830(var3, "Fase Final"));
      return var1;
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_eurocopa";
      var1[1] = this.getNome();
      return var1;
   }

   @Override
   public void mr() {
      this.YD.za();
   }
}
