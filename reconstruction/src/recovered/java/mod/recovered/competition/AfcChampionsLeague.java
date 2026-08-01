package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.LeagueStage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class AfcChampionsLeague extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private ArrayList YF = new ArrayList();
   private Club ZA = null;
   private ArrayList YV = new ArrayList();

   public AfcChampionsLeague() {
      this.setNome(C0679.getString("ligaAfc"));
      this.F(4, 3);
      this.yo();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("chn.", 43, 2));
      this.YV.add(new C0793("arab s.", 9, 3));
      this.YV.add(new C0793("jap", 107, 3));
      this.YV.add(new C0793("cor s.", 49, 3));
      this.YV.add(new C0793("cat", 39, 3));
      this.YV.add(new C0793("irn", 98, 3));
      this.YV.add(new C0793("emi", 59, 3));
      this.YV.add(new C0793("uzb", 196, 2));
      this.YV.add(new C0793("aus", 14, 2));
      this.YV.add(new C0793("tai", 183, 1));
      this.YV.add(new C0793("vie", 199, 1));
      this.YV.add(new C0793("ind", 95, 1));
      this.YV.add(new C0793("hk", 87, 1));
      this.YV.add(new C0793("sir", 174, 1));
      this.YV.add(new C0793("idn", 96, 1));
      this.YV.add(new C0793("irq", 99, 1));
      this.YV.add(new C0793("malásia", 124, 1));
      this.YV.add(new C0793("libano", 115, 1));
      this.YV.add(new C0793("tajiq", 182, 1));
      this.YV.add(new C0793("jord", 108, 1));
      this.YV.add(new C0793("sing", 173, 1));
      this.YV.add(new C0793("Filp", 71, 1));
      this.YV.add(new C0793("KorN", 48, 1));
      this.YV.add(new C0793("mianmar", 132, 1));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(3, 1, this.YV, null, i, c0792);
   }

   public void yq() {
      if (this.YD != null) {
         this.YD.aN(true);
      }

      this.YF.clear();
      this.YD = null;
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      if (this.ZA != null) {
         this.YF.add(this.ZA);
      }

      var2.addAll(this.YF);
      C0938.a(this.YV, this.YF, var2, false);
      C0938.a(var1, this.YF, var2, false);
      if (this.YF.size() < 40) {
         C0938.a(this.YF, this.YV, 40, var2);
      }

      Collections.sort(this.YF, C1007.abm);
      ArrayList var3 = new ArrayList();
      if (this.YF.size() >= 40) {
         int[] var4 = new int[]{
            0,
            10,
            20,
            30,
            1,
            11,
            21,
            31,
            2,
            12,
            22,
            32,
            3,
            13,
            23,
            33,
            4,
            14,
            24,
            34,
            5,
            15,
            25,
            35,
            6,
            16,
            26,
            36,
            7,
            17,
            27,
            37,
            8,
            18,
            28,
            38,
            9,
            19,
            29,
            39
         };

         for (int var5 = 0; var5 < var4.length; var5++) {
            var3.add((Club)this.YF.get(var4[var5]));
         }

         LeagueLoadOptions var7 = new LeagueLoadOptions();
         var7.nTimes = 40;
         var7.nGrupos = 10;
         var7.numeroTimesMataMata = 1;
         var7.melhoresTerceiros = true;
         var7.doisTurnos = true;
         var7.pulaDuasDatas = true;
         var7.var0 = 1403;
         LeagueStage var6 = new LeagueStage(var7, var3, 0, null, null, null, 4, null, false, null, true, this);
         this.YD = var6;
         var6.setNome(this.getNome());
      } else {
         System.out.println("erro Liga Asiatica() " + this.YF.size());
      }
   }

   public ArrayList yy() {
      return this.YF;
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
      var1[0] = "tr_ligaafc";
      var1[1] = this.getNome();
      return var1;
   }
}
