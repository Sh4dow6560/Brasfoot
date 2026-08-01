package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class SouthAmericanRecopa extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private KnockoutStage aac = null;
   private ArrayList cE = new ArrayList();

   public SouthAmericanRecopa() {
      this.setNome(C0679.getString("recopaS"));
      this.F(8, 1);
   }

   public void zR() {
      this.cE.clear();
      this.aac = null;
      Club var1 = null;
      Club var2 = null;
      if (GamePersistence.SR.aF() != null) {
         var1 = GamePersistence.SR.aF().yz();
      }

      if (GamePersistence.SR.aH() != null) {
         var2 = GamePersistence.SR.aH().yz();
      }

      boolean[] var3 = new boolean[]{true, true, true, true, true, true, true};
      if (var1 != null && var2 != null && var1 != var2) {
         this.cE.add(var2);
         this.cE.add(var1);
         this.aac = new KnockoutStage(null, this.cE.size(), 8, 0, var3, this, -1);
         KnockoutRound var4 = new KnockoutRound();
         var4.a(this.aac, this.cE, 0, true, 0, 0, 8, false);
      }
   }

   @Override
   public void mr() {
      this.aac.z(this);
   }

   public KnockoutStage zS() {
      return this.aac;
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
      var1[0] = "tr_recopasulamaericana";
      var1[1] = this.getNome();
      return var1;
   }
}
