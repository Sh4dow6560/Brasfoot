package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class RegionalCup extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private ArrayList YF = new ArrayList();
   private Club ZA = null;
   private Integer aad = -1;

   public LeagueStage yd() {
      return this.YD;
   }

   public RegionalCup() {
   }

   public RegionalCup(Integer integer, ArrayList arrayList) {
      this.aad = integer;
      this.setNome(GameConstants.pY[integer]);
      this.F(10, integer);
      this.an(arrayList);
   }

   public void am(ArrayList arrayList) {
      this.YD = null;
      this.an(arrayList);
      this.mw();
   }

   public void an(ArrayList arrayList) {
      this.YF.clear();
      this.YD = null;
      Integer[][] var2 = new Integer[][]{{18, 25}, {10, 17, 22, 23}, {1, 4, 5, 9, 14, 15, 16, 19, 24}, {0, 2, 3, 6, 7, 8, 11, 12, 13, 20, 21, 26}};
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < arrayList.size(); var5++) {
         int var6 = ((Club)arrayList.get(var5)).getEstado();
         if (Arrays.asList(var2[this.aad]).contains(var6)) {
            var3.add((Club)arrayList.get(var5));
         }
      }

      if (var3.size() >= 16) {
         for (int var9 = 0; var9 < 16; var9++) {
            var4.add((Club)var3.get(var9));
         }

         Collections.sort(var4, C1007.abm);
         ArrayList var10 = C1007.ad(4, 4);

         for (int var11 = 0; var11 < var10.size(); var11++) {
            this.YF.add((Club)var4.get((Integer)var10.get(var11)));
         }

         boolean[] var12 = new boolean[]{true, true, true, false, false, false, false};
         LeagueLoadOptions var7 = new LeagueLoadOptions();
         var7.nTimes = 16;
         var7.nGrupos = 4;
         var7.numeroTimesMataMata = 2;
         var7.doisTurnos = true;
         var7.duasVoltasMataMata = var12;
         LeagueStage var8 = new LeagueStage(var7, this.YF, 0, null, null, null, 10, null, false, null, true, this);
         this.YD = var8;
         var8.setNome(this.getNome());
      }
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
   public void mr() {
      this.YD.za();
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
      if (this.YD.yX() > 0) {
         ArrayList var1 = new ArrayList();
         String var2 = "Primeira Fase";
         if (this.YD.yQ().size() > 0) {
            var2 = "Fase de Grupos";
         }

         CompetitionStage[] var3 = new CompetitionStage[]{this.YD};
         var1.add(new C0830(var3, var2));
         CompetitionStage[] var4 = new CompetitionStage[]{this.YD.yY()};
         var1.add(new C0830(var4, "Fase Final"));
         return var1;
      } else {
         return null;
      }
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      String[] var2 = new String[]{"tr_riosaopaulo", "tr_sulminas", "tr_copanordeste", "tr_copaverde", ""};
      if (GameConstants.w(var2[this.aad])) {
         var1[0] = var2[this.aad];
      } else {
         var1[0] = "tr_nacionalgenerico";
      }

      var1[1] = this.getNome();
      return var1;
   }
}
