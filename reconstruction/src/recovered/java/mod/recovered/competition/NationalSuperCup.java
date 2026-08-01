package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class NationalSuperCup extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private KnockoutStage aac = null;
   private ArrayList cE = new ArrayList();
   private int pais;

   public NationalSuperCup() {
   }

   public NationalSuperCup(int i) {
      this.pais = i;
      CountryCompetitions var2 = GamePersistence.careerState.o(this.pais);
      this.setNome("Supercopa - " + var2.jf());
      this.F(11, i);
   }

   public void Ab() {
      Club var1 = null;
      Club var2 = null;
      CountryCompetitions var3 = GamePersistence.careerState.o(this.pais);
      if (var3 != null && var3.eb() != null && var3.eb().size() > 0) {
         var1 = ((NationalLeague)var3.eb().get(0)).cv(GamePersistence.careerState.getSeasonNumber() - 1);
         Club[] var4 = var3.bk(GamePersistence.careerState.getSeasonNumber() - 1);
         if (var4 != null) {
            if (var1 != var4[0]) {
               var2 = var4[0];
            } else {
               var2 = var4[1];
            }
         }

         this.b(var1, var2);
      }
   }

   public void b(Club club, Club club2) {
      this.cE.clear();
      this.aac = null;
      boolean[] var3 = new boolean[7];
      if (club != null && club2 != null) {
         this.cE.add(club);
         this.cE.add(club2);
         this.aac = new KnockoutStage(null, this.cE.size(), 11, 0, var3, this, -1);
         KnockoutRound var4 = new KnockoutRound();
         var4.a(this.aac, this.cE, 0, var3[0], 0, 0, 11, false);
      }
   }

   @Override
   public void mr() {
      this.aac.z(this);
   }

   public KnockoutStage zS() {
      return this.aac;
   }

   public int getPais() {
      return this.pais;
   }

   @Override
   public CompetitionStage[] mB() {
      return new CompetitionStage[]{this.aac};
   }

   @Override
   public ArrayList mC() {
      return null;
   }

   @Override
   public String[] b(CompetitionStage c0678) {
      return this.aac.zB();
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      String var2 = "tr_supercopa_" + C0696.valueOf("P" + Integer.toString(this.pais)).jA();
      String var3 = "tr_supercopa_generico";
      if (GameConstants.w(var2)) {
         var1[0] = var2;
      } else {
         var1[0] = var3;
      }

      var1[1] = this.getNome();
      return var1;
   }
}
