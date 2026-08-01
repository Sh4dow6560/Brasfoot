package bf22.intermediary;

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

public class C0940 extends Competition implements Serializable {
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

   public C0940() {
      this.F(7, 1);
      this.O(true);
   }

   public void ya() {
      this.YE.clear();
      this.YF.clear();
      this.YD = null;
      int[] var1 = new int[]{10, 0};
      int[] var2 = new int[]{1, 3};
      this.YH++;
      this.YG = this.yb();

      for (int var3 = 0; var3 <= 1; var3++) {
         if (var1[var3] > 0) {
            CountryCompetitions.a(false, var2[var3], var1[var3], this.YE, false, null);
         }
      }

      if (this.YE.size() >= 10) {
         ArrayList var8 = new ArrayList();

         for (int var4 = 0; var4 < this.YE.size(); var4++) {
            var8.add(((CountryCompetitions)this.YE.get(var4)).jo());
            ((CountryCompetitions)this.YE.get(var4)).z(true);
         }

         Collections.sort(this.YF, C1007.cN);
         ArrayList var9 = C1007.Al();

         for (int var5 = 0; var5 < var9.size(); var5++) {
            this.YF.add((Club)var8.get((Integer)var9.get(var5)));
         }

         boolean[] var10 = new boolean[7];
         LeagueLoadOptions var6 = new LeagueLoadOptions();
         var6.nTimes = 10;
         var6.nGrupos = 2;
         var6.numeroTimesMataMata = 4;
         var6.doisTurnos = false;
         var6.duasVoltasMataMata = var10;
         LeagueStage var7 = new LeagueStage(var6, this.YF, 0, null, null, null, 7, null, false, null, true, this);
         this.YD = var7;
         var7.setNome(this.getNome());
         GamePersistence.afQ.L(this.YF);
      }
   }

   @Override
   public int cy(int i) {
      int var2 = this.YH - 1;
      var2 %= 10;
      int var3 = 45000;
      int[] var4 = new int[]{65000, 55000, 52698, 48134, 45600, 34990, 37215, 28065};
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
      String[] var3 = new String[]{"Buenos Aires", "Bogotá", "Córdoba", "Medellín", "Mendoza", "Rosário", "La Plata", "Cali"};
      String[][] var4 = new String[][]{
         {"Buenos Aires", "Córdoba", "La Plata", "Mendoza", "Rosário", "Mar del Plata", "Santa Fé", "Almagro"},
         {"Quito", "Guayaquil", "Cuenca", "Santo Domingo", "Quito", "Guaiaquil", "Cuenca", "Santo Domingo"},
         {"Bogotá", "Medellín", "Cali", "Barranquilla", "Bogotá", "Medellín", "Cali", "Barranquilla"},
         {"Rio de Janeiro", "São Paulo", "Belo Horizonte", "Fortaleza", "Salvador", "Porto Alegre", "Recife", "Curitiba"},
         {"Montevidéu", "Maldonado", "Salto", "Tacuarembó", "Montevidéu", "Maldonado", "Salto", "Tacuarembó"},
         {"Assunção", "Ciudad del Este", "Luque", "Capiatá", "Assunção", "Ciudad del Este", "Luque", "Capiatá"},
         {"La Paz", "Santa Cruz", "Cochabamba", "Sucre", "Oruro", "Potosí", "Cochabamba", "Sucre"},
         {"Caracas", "Maracaibo", "Valencia", "Barquisimeto", "Maracay", "San Cristóbal", "Maturín", "Petare"},
         {"Santiago", "Concepción", "Valparaíso", "La Serena", "Antofagasta", "Temuco", "Talca", "Arica"},
         {"Lima", "Arequipa", "Cusco", "Iquitos", "Chiclayo", "Trujillo", "Tacna", "Chimbote"}
      };
      String var5 = null;
      if (var2 == 0) {
         if (i <= 7) {
            var5 = var3[i];
         } else {
            var5 = var3[i - 8];
         }
      } else if (i <= 7) {
         var5 = var4[var2][i];
      } else {
         var5 = var4[var2][i - 8];
      }

      return var5;
   }

   public CountryCompetitions yb() {
      int var1 = this.YH - 1;
      var1 %= 10;
      int[] var2 = new int[]{11, 60, 46, 29, 195, 150, 26, 198, 42, 151};
      return var1 >= 0 && var1 < var2.length ? GamePersistence.SR.s(var2[var1]) : null;
   }

   public LeagueStage yd() {
      return this.YD;
   }

   public void p(LeagueStage c0955) {
      this.YD = c0955;
   }

   public static ArrayList yc() {
      ArrayList var0 = new ArrayList();
      String[] var1 = new String[]{"1º Grupo A", "2º Grupo B", "1º Grupo D", "2º Grupo C", "1º Grupo B", "2º Grupo A", "1º Grupo C", "2º Grupo D"};

      for (int var2 = 0; var2 < var1.length; var2++) {
         var0.add(var1[var2]);
      }

      return var0;
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
      var1[0] = "tr_copaamerica";
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
