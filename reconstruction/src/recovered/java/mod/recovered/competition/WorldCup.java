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
import java.util.Random;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class WorldCup extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private ArrayList YE = new ArrayList();
   private int YH = 0;
   private ArrayList YF = new ArrayList();
   private ArrayList YM = new ArrayList();
   private CountryCompetitions YN = null;
   private CountryCompetitions YO = null;
   private CountryCompetitions YG = null;
   private int[] Zw = new int[]{0, 3, 4, 7, 8, 11, 12, 15, 2, 1, 6, 5, 10, 9, 14, 13};

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.YE.clear();
      this.YF.clear();
   }

   public WorldCup() {
      this.F(7, 7);
      this.O(true);
   }

   public void ya() {
      if (GamePersistence.careerState.H() > 1) {
         this.Bu();
      } else {
         this.YE.clear();
         this.YF.clear();
         this.YD = null;
         boolean var1 = false;
         int[] var2 = new int[]{13, 4, 5, 4, 3, 0};
         int[] var3 = new int[6];
         if (GamePersistence.careerState.H() == 1) {
            var3 = var2;
         }

         this.YH++;
         this.YG = this.eY(0);
         if (GamePersistence.careerState.H() == 1 && GamePersistence.careerState.isUsarGruposReaisCopa()) {
            var1 = true;
            int[] var9 = new int[]{
               39, 60, 169, 85, 97, 98, 68, 145, 11, 9, 131, 152, 72, 14, 54, 190, 65, 51, 3, 107, 21, 38, 129, 52, 29, 171, 180, 36, 154, 75, 195, 49
            };

            for (int var13 = 0; var13 < 32; var13++) {
               this.YE.add(GamePersistence.careerState.s(var9[var13]));
            }
         } else {
            if (this.YG != null && this.YG.jl()) {
               this.YE.add(this.YG);
            } else {
               var3[3]++;
            }

            this.YE.addAll(this.YM);
            int var4 = new Random().nextInt(100) + 1;
            if (var4 <= 70) {
               var3[4]++;
            } else {
               var3[5]++;
            }

            int var5 = 0;

            while (var5 < this.YE.size()) {
               var5++;
            }

            for (int var11 = 0; var11 <= 5; var11++) {
               if (var3[var11] > 0) {
                  CountryCompetitions.a(true, var11, var3[var11], this.YE, false, this.YN);
               }
            }

            if (this.YE.size() < 32) {
               for (int var12 = 0; var12 <= 5; var12++) {
                  int var6 = 32 - this.YE.size();
                  if (var6 > 0) {
                     CountryCompetitions.a(true, var12, var6, this.YE, false, this.YN);
                  }
               }
            }
         }

         if (this.YE.size() >= 32) {
            ArrayList var10 = new ArrayList();

            for (int var14 = 0; var14 < this.YE.size(); var14++) {
               var10.add(((CountryCompetitions)this.YE.get(var14)).jo());
               ((CountryCompetitions)this.YE.get(var14)).z(true);
            }

            Collections.sort(this.YF, C1007.cN);
            ArrayList var15 = C1007.ad(8, 4);
            if (var1) {
               for (int var16 = 0; var16 < this.YE.size(); var16++) {
                  this.YF.add((Club)var10.get(var16));
               }
            } else {
               for (int var17 = 0; var17 < var15.size(); var17++) {
                  this.YF.add((Club)var10.get((Integer)var15.get(var17)));
               }
            }

            boolean[] var18 = new boolean[7];
            LeagueLoadOptions var7 = new LeagueLoadOptions();
            var7.nTimes = 32;
            var7.nGrupos = 8;
            var7.numeroTimesMataMata = 2;
            var7.doisTurnos = false;
            var7.duasVoltasMataMata = var18;
            var7.var0 = 7700;
            LeagueStage var8 = new LeagueStage(var7, this.YF, 0, null, null, null, 7, null, false, null, true, this);
            this.YD = var8;
            var8.setNome(this.getNome());
            GamePersistence.coachJobMarket.L(this.YF);
         }

         this.YM.clear();
         this.YN = null;
         this.YF.clear();
         this.YE.clear();
      }
   }

   public void Bu() {
      this.YH++;
      this.YG = this.eY(0);
      this.YE.clear();
      this.YE.addAll(this.YM);
      this.YM.clear();
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      Collections.sort(this.YE, CountryCompetitions.cN);

      for (int var3 = 0; var3 < this.YE.size(); var3++) {
         var1.add(((CountryCompetitions)this.YE.get(var3)).jo());
         ((CountryCompetitions)this.YE.get(var3)).z(true);
      }

      ArrayList var9 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();

      for (int var6 = 0; var6 <= 15; var6++) {
         var9.add((Club)var1.get(var6));
      }

      for (int var10 = 16; var10 <= 31; var10++) {
         var4.add((Club)var1.get(var10));
      }

      for (int var11 = 32; var11 <= 47; var11++) {
         var5.add((Club)var1.get(var11));
      }

      Collections.shuffle(var9);
      Collections.shuffle(var4);
      Collections.shuffle(var5);

      for (int var12 = 0; var12 <= 15; var12++) {
         var2.add((Club)var9.get(var12));
         var2.add((Club)var4.get(var12));
         var2.add((Club)var5.get(var12));
      }

      boolean[] var13 = new boolean[7];
      LeagueLoadOptions var7 = new LeagueLoadOptions();
      var7.nTimes = 48;
      var7.nGrupos = 16;
      var7.doisTurnos = false;
      var7.numeroTimesMataMata = 2;
      var7.duasVoltasMataMata = var13;
      LeagueStage var8 = new LeagueStage(var7, var2, 0, null, null, null, 7, null, false, null, true, this);
      var8.fb(7700);
      this.YD = var8;
      var8.setNome(this.getNome());
   }

   public void yt() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < this.YD.yQ().size(); var2++) {
         var1.add((Club)((C0673)this.YD.yQ().get(var2)).gR().get(0));
         var1.add((Club)((C0673)this.YD.yQ().get(var2)).gR().get(1));
      }

      ArrayList var5 = new ArrayList();
      if (var1.size() == 16) {
         for (int var3 = 0; var3 < var1.size(); var3++) {
            var5.add((Club)var1.get(this.Zw[var3]));
         }
      }

      if (var1.size() == 32) {
         for (int var6 = 0; var6 < this.Zw.length; var6++) {
            var5.add((Club)var1.get(this.Zw[var6]));
         }

         for (int var7 = 0; var7 < this.Zw.length; var7++) {
            var5.add((Club)var1.get(this.Zw[var7] + 16));
         }
      }

      boolean[] var8 = new boolean[7];
      this.YD.c(new KnockoutStage(null, var5.size(), this.b(), 0, var8, this, -1));
      KnockoutRound var4 = new KnockoutRound();
      var4.a(this.YD.yY(), var5, 0, var8[0], 0, 0, this.b(), false);
   }

   public static String ab(int i, int j) {
      String var2 = "";
      String[][] var3 = new String[][]{
         {
               "Moscou",
               "Ecaterimburgo",
               "São Petesburgo",
               "Sóchi",
               "Cazã",
               "Saransk",
               "Moscou",
               "Kaliningrado",
               "Samara",
               "Rostov",
               "Moscou",
               "Níjni Novgorod",
               "Sóchi",
               "Volgogrado",
               "Saransk",
               "Moscou"
         },
         {
               "São Petesburgo",
               "Rostov",
               "Moscou",
               "Cazã",
               "Samara",
               "Ecaterimburgo",
               "Níjni Novgorod",
               "Volgogrado",
               "São Petesburgo",
               "Kaliningrado",
               "Rostov",
               "Sóchi",
               "Moscou",
               "Níjni Novgorod",
               "Ecaterimburgo",
               "Cazã"
         },
         {
               "Samara",
               "Volgogrado",
               "Saransk",
               "Kaliningrado",
               "Moscou",
               "Sóchi",
               "São Petesburgo",
               "Rostov",
               "Moscou",
               "Níjni Novgorod",
               "Ecaterimburgo",
               "Cazã",
               "Kaliningrado",
               "Saransk",
               "Samara",
               "Volgogrado"
         },
         {"Sóchi", "Cazã", "Samara", "Rostov", "Moscou (Luzhniki)", "Níjni Novgorod", "São Petesburgo", "Moscou (Spartak)", "", "", "", "", "", "", "", ""},
         {"Níjni Novgorod", "Cazã", "Sóchi", "Samara", "", "", "", "", "", "", "", "", "", "", "", ""},
         {"São Petersburgo", "Moscou (Luzhniki)", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
         {"Moscou (Luzhniki)", "São Petersburgo", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
      };
      return var3[i][j];
   }

   public CountryCompetitions eY(int i) {
      int var2 = this.YH + i - 1;
      var2 %= 10;
      int[] var3 = new int[]{39, 131, 65, 11, 104, 97, 43, 3, 29, 162};
      return var2 >= 0 && var2 < var3.length ? GamePersistence.careerState.s(var3[var2]) : null;
   }

   @Override
   public int cy(int i) {
      int var2 = this.YH - 1;
      var2 %= 10;
      int var3 = 45000;
      int[] var4 = new int[]{80000, 65000, 52698, 48134, 45600, 34990, 37215, 28065};
      int[] var5 = new int[]{45000, 42000, 32698, 38134, 35600, 34990, 37215, 28065};
      if (this.YG != null && this.YG.jc() != 11 && this.YG.jc() != 29) {
         var4 = var5;
      }

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
         {"Lusail", "Al Khor", "Doha", "Al Wakrah", "Umm Salal", "Madinat", "Al Rayyan", "Doha"},
         {
               "Nova York",
               "Los Angeles",
               "Atlanta",
               "Cid. México",
               "Boston",
               "Guadalajara",
               "San Francisco",
               "Houston",
               "Monterrey",
               "Dallas",
               "Vancouver",
               "Toronto"
         },
         {"Buenos Aires", "Santiago", "Montevidéu", "Assunción", "Córdoba", "Concepción", "Mendoza", "Rosário", "La Plata", "Santa Fé", "Almagro"},
         {"Madrid", "Lisaboa", "Barcelona", "Porto", "Sevilha", "Valência", "Braga", "Málaga", "Bilbau", "Braga"},
         {"Roma", "Milão", "Turim", "Bologna", "Cagliari", "Gênoa", "Florença", "Udine"},
         {"Londres", "Liverpool", "Manchester", "Notthingam", "Leeds", "Coventry", "Sheffield", "Bristol"},
         {"Pequim", "Guangzhou", "Hangzhou", "Nanquim", "Jinan", "Xangai", "Tianjin", "Chongqing"},
         {"Berlim", "Munique", "Hamburgo", "Dortmund", "Frankfurt", "Hannover", "Leipzig", "Nuremberg"},
         {"Rio de Janeiro", "São Paulo", "Belo Horizonte", "Fortaleza", "Salvador", "Porto Alegre", "Recife", "Curitiba"},
         {"Moscou", "São Petesburgo", "Kazan", "Kaliningrad", "Yaroslavl", "Samara", "Volgograd", "Yekaterinburg"}
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

   public LeagueStage yd() {
      return this.YD;
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
      var1[0] = "tr_copamundo";
      var1[1] = this.getNome();
      return var1;
   }

   public int ye() {
      return this.YH;
   }

   @Override
   public void mr() {
      this.YD.za();
   }
}
