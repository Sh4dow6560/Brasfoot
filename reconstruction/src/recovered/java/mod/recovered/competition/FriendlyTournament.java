package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.LeagueStage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;

public class FriendlyTournament extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private String agn = "";

   public FriendlyTournament() {
      this.F(15, 0);
      this.setNome("Torneio Amistoso");
   }

   public void xZ() {
      this.YD = null;
   }

   public void a(ArrayList arrayList, int i, String string, String string2, boolean bl) {
      this.setNome(string);
      this.agn = string2;
      byte var6 = 1;
      if (i == 0) {
         var6 = 2;
      }

      LeagueLoadOptions var7 = new LeagueLoadOptions();
      var7.nTimes = arrayList.size();
      var7.nGrupos = var6;
      var7.numeroTimesMataMata = 2;
      if (i == 2) {
         var7.numeroTimesMataMata = 0;
      }

      var7.doisTurnos = false;
      boolean[] var8 = new boolean[7];
      var7.duasVoltasMataMata = var8;
      if (bl) {
         Collections.shuffle(arrayList);
      }

      LeagueStage var9 = new LeagueStage(var7, arrayList, 0, null, null, null, 15, null, false, null, true, this);
      this.YD = var9;
      var9.setNome(string);
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
      if (this.YD.yX() > 0) {
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

   public String Bt() {
      return this.agn;
   }

   @Override
   public void mr() {
      this.YD.za();
   }
}
