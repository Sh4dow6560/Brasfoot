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

public class AsianCup extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private ArrayList YE = new ArrayList();
   private ArrayList YF = new ArrayList();
   private CountryCompetitions YG = null;
   private int YH = 0;

   public void xZ() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YD = null;
      this.YE.clear();
      this.YF.clear();
   }

   public AsianCup() {
      this.F(7, 3);
      this.O(true);
   }

   public void ya() {
      this.YE.clear();
      this.YF.clear();
      this.YD = null;
      int var1 = 23;
      this.YH++;
      this.YG = this.yb();
      if (this.YG != null && this.YG.jl()) {
         this.YE.add(this.YG);
      } else {
         var1++;
      }

      CountryCompetitions.a(false, 3, var1, this.YE, false, null);
      if (this.YE.size() >= 24) {
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
      int[] var4 = new int[]{65000, 55000, 52698, 48134, 45600, 34990, 37215, 28065};
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
         {"Pequim", "Xangai", "Cantão", "Shenzhen", "Tianjin", "Wuhan", "Hangzhou", "Shenyang"},
         {"Tóquio", "Yokohama", "Osaka", "Nagoya", "Sapporo", "Kobe", "Kyoto", "Hiroshima"},
         {"Dubai", "Abu Dabi", "Xarja", "Alaine", "Ajmã", "Fujeira", "Al Quwain", "Ras al-Khaimah"},
         {"Sydney", "Melbourne", "Brisbane", "Perth", "Adelaide", "Camberra", "Wollongong", "Hobart"},
         {"Teerã", "Mexede", "Ispaã", "Karaj", "Tabriz", "Xiraz", "Avaz", "Qom"},
         {"Alepo", "Damasco", "Homs", "Latakia", "Hama", "Ar-Raqqah", "Deir ez-Zor", "Al-Hasakah"},
         {"Lusail", "Al Khor", "Doha", "Al Wakrah", "Umm Salal", "Madinat", "Al Rayyan", "Doha"},
         {"Seul", "Busan", "Incheon", "Daegu", "Daejeon", "Ulsan", "Changwon", "Gwangju"},
         {"Bagdá", "Baçorá", "Mossul", "Arbil", "Quircuque", "Faluja", "Suleimânia", "Carbala"},
         {"Ha Noi", "Ho Chi Minh", "Haiphong", "Can Tho", "Da Nang", "Bien Hoa", "Nha Trang", "Thai Nguyen"}
      };
      String var4 = null;
      int var5 = i;
      if (i > 7) {
         var5 = i - 8;
      }

      if (var5 < var3[var2].length) {
         var4 = var3[var2][var5];
      }

      return var4;
   }

   public CountryCompetitions yb() {
      int var1 = this.YH - 1;
      var1 %= 10;
      int[] var2 = new int[]{43, 107, 59, 14, 98, 174, 39, 49, 99, 199};
      return var1 >= 0 && var1 < var2.length ? GamePersistence.SR.s(var2[var1]) : null;
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"1º Grupo A", "2º Grupo B", "1º Grupo D", "2º Grupo C", "1º Grupo B", "2º Grupo A", "1º Grupo C", "2º Grupo D"};

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
      var1[0] = "tr_copaasia";
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
