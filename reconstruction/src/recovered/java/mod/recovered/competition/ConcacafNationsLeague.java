package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class ConcacafNationsLeague extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage agp = null;
   private LeagueStage agq = null;
   private LeagueStage agr = null;
   private ArrayList agt = new ArrayList();
   private ArrayList agu = new ArrayList();
   private ArrayList agv = new ArrayList();
   private KnockoutStage afT = null;
   private ArrayList xc = new ArrayList();
   private int YH = 0;
   private int agy = -1;

   public ConcacafNationsLeague() {
      this.F(14, 4);
      this.O(true);
   }

   public void Ar() {
      if (this.YH == 0) {
         int[] var1 = new int[]{131, 68, 38, 51, 147, 106, 58, 86, 219, 8, 181, 77};
         int[] var2 = new int[]{84, 79, 189, 53, 220, 217, 139, 24, 7, 80, 158, 168, 22, 212, 20, 17};
         int[] var3 = new int[]{166, 153, 221, 165, 56, 13, 90, 213, 222, 223, 211, 6, 94};

         for (int var4 = 0; var4 < var1.length; var4++) {
            this.agt.add(GamePersistence.careerState.s(var1[var4]).jo());
         }

         for (int var5 = 0; var5 < var2.length; var5++) {
            this.agu.add(GamePersistence.careerState.s(var2[var5]).jo());
         }

         for (int var6 = 0; var6 < var3.length; var6++) {
            this.agv.add(GamePersistence.careerState.s(var3[var6]).jo());
         }
      }

      this.aB(this.agt);
      this.aB(this.agu);
      this.aB(this.agv);
      this.agp = this.e(this.agt, 14401);
      this.agq = this.e(this.agu, 14402);
      this.agr = this.e(this.agv, 14403);
      this.agy = -1;
      this.YH++;
      GamePersistence.coachJobMarket.L(this.agt);
      GamePersistence.coachJobMarket.L(this.agu);
      GamePersistence.coachJobMarket.L(this.agv);
   }

   private LeagueStage e(ArrayList arrayList, int i) {
      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         GamePersistence.careerState.s(((Club)arrayList.get(var3)).getPais()).z(false);
      }

      boolean[] var6 = new boolean[7];
      LeagueLoadOptions var4 = new LeagueLoadOptions();
      var4.nTimes = arrayList.size();
      var4.nGrupos = 4;
      var4.numeroTimesMataMata = 0;
      var4.doisTurnos = true;
      var4.duasVoltasMataMata = var6;
      if (arrayList.size() == 13) {
         var4.nGrupos = 4;
         var4.gruposNumeroDiferenteTimes = true;
         var4.gruposNumeroDiferenteTimes = true;
         var4.numeroDefinidoTimesPorGrupo[0] = 4;
         var4.numeroDefinidoTimesPorGrupo[1] = 3;
         var4.numeroDefinidoTimesPorGrupo[2] = 3;
         var4.numeroDefinidoTimesPorGrupo[3] = 3;
      }

      LeagueStage var5 = new LeagueStage(var4, arrayList, 0, null, null, null, 14, null, false, null, true, this);
      var5.fb(i);
      var5.setNome(this.getNome());
      return var5;
   }

   public void yt() {
      ArrayList var1 = new ArrayList();
      var1.add((Club)((C0673)this.agp.yQ().get(0)).gR().get(0));
      var1.add((Club)((C0673)this.agp.yQ().get(1)).gR().get(0));
      var1.add((Club)((C0673)this.agp.yQ().get(2)).gR().get(0));
      var1.add((Club)((C0673)this.agp.yQ().get(3)).gR().get(0));
      Collections.shuffle(var1);
      this.agy = ((Club)var1.get(0)).getPais();
      boolean[] var2 = new boolean[7];
      this.afT = new KnockoutStage(null, var1.size(), this.b(), 0, var2, this, -1);
      KnockoutRound var3 = new KnockoutRound();
      var3.a(this.afT, var1, 0, var2[0], 0, 0, this.b(), false);
   }

   public void aA(ArrayList arrayList) {
      this.xc.clear();
      this.xc.addAll(arrayList);
   }

   private void aB(ArrayList arrayList) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      ArrayList var5 = new ArrayList();
      if (arrayList.size() == 16) {
         for (int var6 = 0; var6 <= 3; var6++) {
            var2.add((Club)arrayList.get(var6));
         }

         for (int var7 = 4; var7 <= 7; var7++) {
            var3.add((Club)arrayList.get(var7));
         }

         for (int var8 = 8; var8 <= 11; var8++) {
            var4.add((Club)arrayList.get(var8));
         }

         for (int var9 = 12; var9 <= 15; var9++) {
            var5.add((Club)arrayList.get(var9));
         }

         Collections.shuffle(var2);
         Collections.shuffle(var3);
         Collections.shuffle(var4);
         Collections.shuffle(var5);
         arrayList.clear();

         for (int var10 = 0; var10 <= 3; var10++) {
            arrayList.add((Club)var2.get(var10));
            arrayList.add((Club)var3.get(var10));
            arrayList.add((Club)var4.get(var10));
            arrayList.add((Club)var5.get(var10));
         }
      }

      if (arrayList.size() == 15) {
         for (int var11 = 0; var11 <= 3; var11++) {
            var2.add((Club)arrayList.get(var11));
         }

         for (int var12 = 4; var12 <= 7; var12++) {
            var3.add((Club)arrayList.get(var12));
         }

         for (int var13 = 8; var13 <= 12; var13++) {
            var4.add((Club)arrayList.get(var13));
         }

         Collections.shuffle(var2);
         Collections.shuffle(var3);
         Collections.shuffle(var4);
         arrayList.clear();

         for (int var14 = 0; var14 <= 3; var14++) {
            arrayList.add((Club)var2.get(var14));
            arrayList.add((Club)var3.get(var14));
            arrayList.add((Club)var4.get(var14));
         }

         arrayList.add((Club)var4.get(4));
      }

      if (arrayList.size() == 12) {
         for (int var15 = 0; var15 <= 3; var15++) {
            var2.add((Club)arrayList.get(var15));
         }

         for (int var16 = 4; var16 <= 7; var16++) {
            var3.add((Club)arrayList.get(var16));
         }

         for (int var17 = 8; var17 <= 11; var17++) {
            var4.add((Club)arrayList.get(var17));
         }

         Collections.shuffle(var2);
         Collections.shuffle(var3);
         Collections.shuffle(var4);
         arrayList.clear();

         for (int var18 = 0; var18 <= 3; var18++) {
            arrayList.add((Club)var2.get(var18));
            arrayList.add((Club)var3.get(var18));
            arrayList.add((Club)var4.get(var18));
         }
      }
   }

   public void BC() {
   }

   private void BD() {
      for (int var1 = 0; var1 < this.agp.yQ().size(); var1++) {
         this.a(
            this.agt,
            this.agu,
            this.a(this.agt, (Club)((C0673)this.agp.yQ().get(var1)).gR().get(2)),
            this.a(this.agu, (Club)((C0673)this.agq.yQ().get(var1)).gR().get(0))
         );
      }

      for (int var2 = 0; var2 < this.agq.yQ().size(); var2++) {
         this.a(
            this.agu,
            this.agv,
            this.a(this.agu, (Club)((C0673)this.agq.yQ().get(var2)).gR().get(3)),
            this.a(this.agv, (Club)((C0673)this.agr.yQ().get(var2)).gR().get(0))
         );
      }
   }

   private int a(ArrayList arrayList, Club club) {
      for (int var3 = 0; var3 < arrayList.size(); var3++) {
         if (arrayList.get(var3) == club) {
            return var3;
         }
      }

      return -1;
   }

   private void a(ArrayList arrayList, ArrayList arrayList2, int i, int j) {
      Club var5 = null;
      Club var6 = null;
      var5 = (Club)arrayList.get(i);
      var6 = (Club)arrayList2.get(j);
      var5.b(this, 0);
      var6.b(this, 1);
      arrayList.set(i, var6);
      arrayList2.set(j, var5);
   }

   public void xZ() {
      if (this.agp != null) {
         this.BD();
      }

      if (this.agp != null) {
         this.agp.aN(true);
      }

      if (this.agq != null) {
         this.agq.aN(true);
      }

      if (this.agr != null) {
         this.agr.aN(true);
      }

      this.agp = null;
      this.agq = null;
      this.agr = null;
      this.afT = null;
   }

   @Override
   public CompetitionStage[] mB() {
      CompetitionStage[] var1 = new CompetitionStage[]{this.agp};
      if (this.afT != null) {
         CompetitionStage[] var2 = new CompetitionStage[]{this.afT};
         var1 = var2;
      }

      return var1;
   }

   @Override
   public ArrayList mC() {
      ArrayList var1 = new ArrayList();
      CompetitionStage[] var2 = new CompetitionStage[]{this.agp};
      var1.add(new C0830(var2, "Liga A"));
      CompetitionStage[] var3 = new CompetitionStage[]{this.agq};
      var1.add(new C0830(var3, "Liga B"));
      CompetitionStage[] var4 = new CompetitionStage[]{this.agr};
      var1.add(new C0830(var4, "Liga C"));
      CompetitionStage[] var5 = new CompetitionStage[]{this.afT};
      var1.add(new C0830(var5, "Fase Final"));
      return var1;
   }

   @Override
   public String[] b(CompetitionStage c0678) {
      return GameConstants.pF;
   }

   @Override
   public int cy(int i) {
      int[] var2 = new int[]{65000, 55000, 52698};
      int var3 = new Random().nextInt(var2.length);
      return var2[var3] + new Random().nextInt(5000);
   }

   @Override
   public String cx(int i) {
      return C0696.bl(this.agy);
   }

   @Override
   public String[] mA() {
      String[] var1 = new String[]{"", ""};
      var1[0] = "tr_liganacoesC";
      var1[1] = this.getNome();
      return var1;
   }

   @Override
   public void mr() {
      this.afT.z(this);
      this.BG();
   }

   private void BG() {
      for (int var1 = 0; var1 < this.agp.yK().size(); var1++) {
         ((Club)this.agp.yK().get(var1)).e(this, 1);
      }

      for (int var2 = 0; var2 < this.agq.yK().size(); var2++) {
         ((Club)this.agq.yK().get(var2)).e(this, 2);
      }

      for (int var3 = 0; var3 < this.agr.yK().size(); var3++) {
         ((Club)this.agr.yK().get(var3)).e(this, 3);
      }
   }
}
