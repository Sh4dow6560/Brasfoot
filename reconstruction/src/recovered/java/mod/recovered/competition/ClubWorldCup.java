package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import mod.recovered.model.Club;

public class ClubWorldCup extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private KnockoutStage ZM = null;
   private KnockoutStage ZN = null;
   private Club ZO = null;
   private Club ZP = null;
   private Club ZQ = null;
   private Club ZR = null;
   private Club ZS = null;
   private Club ZT = null;

   public ClubWorldCup() {
      this.setNome(C0679.getString("mundialclubes"));
      this.F(5, 7);
      this.O(true);
   }

   public void zC() {
      this.ZM = null;
      this.ZN = null;
      this.ZO = null;
      this.ZP = null;
      this.ZQ = null;
      this.ZR = null;
      this.ZS = null;
      this.ZT = null;
      if (GamePersistence.SR.aI() != null) {
         this.ZO = GamePersistence.SR.aI().cS();
         GamePersistence.SR.aI().N(this.ZO);
      }

      if (GamePersistence.SR.aF() != null) {
         this.ZP = GamePersistence.SR.aF().cS();
         GamePersistence.SR.aF().N(this.ZP);
         if (this.ZP != null && this.ZP.getPais() == 131) {
            this.ZP = GamePersistence.SR.aF().yx();
         }
      }

      if (GamePersistence.SR.aO() != null) {
         this.ZQ = GamePersistence.SR.aO().cS();
         GamePersistence.SR.aO().N(this.ZQ);
      }

      if (GamePersistence.SR.aL() != null) {
         this.ZR = GamePersistence.SR.aL().cS();
         GamePersistence.SR.aL().N(this.ZR);
      }

      if (GamePersistence.SR.aQ() != null) {
         this.ZS = GamePersistence.SR.aQ().cS();
         GamePersistence.SR.aQ().N(this.ZS);
      }

      if (GamePersistence.SR.aP() != null) {
         this.ZT = GamePersistence.SR.aP().cS();
         GamePersistence.SR.aP().N(this.ZT);
      }

      if (this.ZO != null && this.ZP != null && this.ZQ != null && this.ZR != null && this.ZS != null && this.ZT != null) {
         Club[] var1 = new Club[]{this.ZQ, this.ZR, this.ZS, this.ZT};
         int[] var2 = new int[]{2, 0, 3, 1};
         int[] var3 = new int[]{3, 2, 1, 0};
         int[] var4 = new int[]{0, 2, 3, 1};
         int var5 = new Random().nextInt(3);
         int[] var10000 = new int[]{2, 0, 3, 1};
         int[] var6;
         if (var5 == 0) {
            var6 = var2;
         } else if (var5 == 1) {
            var6 = var3;
         } else {
            var6 = var4;
         }

         ArrayList var7 = new ArrayList();

         for (int var8 = 0; var8 < 4; var8++) {
            var7.add(var1[var6[var8]]);
         }

         boolean[] var10 = new boolean[7];
         this.ZM = new KnockoutStage(null, var7.size(), this.b(), 1, var10, this, -1);
         this.ZM.fc(150);
         KnockoutRound var9 = new KnockoutRound();
         var9.a(this.ZM, var7, 0, false, 0, 0, this.b(), false);
      }
   }

   public void al(ArrayList arrayList) {
      if (arrayList.size() == 2) {
         ArrayList var2 = new ArrayList();
         var2.add(this.ZP);
         var2.add((Club)arrayList.get(0));
         var2.add(this.ZO);
         var2.add((Club)arrayList.get(1));
         boolean[] var3 = new boolean[7];
         this.ZN = new KnockoutStage(null, var2.size(), this.b(), 0, var3, this, -1);
         KnockoutRound var4 = new KnockoutRound();
         var4.a(this.ZN, var2, 0, false, 0, 0, this.b(), false);
      }
   }

   public KnockoutStage zD() {
      return this.ZM;
   }

   public KnockoutStage zE() {
      return this.ZN;
   }

   @Override
   public String[] b(CompetitionStage c0678) {
      return c0678 == this.ZM ? GameConstants.pE : GameConstants.pF;
   }

   @Override
   public CompetitionStage[] mB() {
      CompetitionStage[] var1 = new CompetitionStage[]{this.ZM};
      CompetitionStage[] var2 = new CompetitionStage[]{this.ZM, this.ZN};
      return this.ZN == null ? var1 : var2;
   }

   @Override
   public void mr() {
      this.ZN.z(this);
   }

   public static ArrayList eX(int i) {
      ArrayList var1 = new ArrayList();
      String[] var2 = null;
      if (i == 1) {
         String[] var3 = new String[]{"Campeão Libertadores", "vencedor quartas 1", "Campeão L. Campeões", "vencedor quartas 2"};
         var2 = var3;
      } else if (i == 2) {
         String[] var4 = new String[]{"Vencedor Semi-Final 1", "Vencedor Semi-Final 2", "Perdedor Semi-Final 1", "Perdedor Semi-Final 2"};
         var2 = var4;
      }

      for (int var5 = 0; var5 < var2.length; var5++) {
         var1.add(var2[var5]);
      }

      return var1;
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_mundial";
      var1[1] = this.getNome();
      return var1;
   }
}
