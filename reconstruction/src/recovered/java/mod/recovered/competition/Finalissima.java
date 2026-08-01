package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.KnockoutRound;
import mod.recovered.competition.KnockoutStage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import mod.recovered.model.Club;

public class Finalissima extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private Club agg = null;
   private Club agh = null;
   private String agi = null;
   private KnockoutStage aac = null;
   private int YH = 0;
   String[] agj = new String[]{"Buenos Aires", "Rio de Janeiro", "São Paulo", "Santiago", "Lima", "Belo Horizonte", "Motevidéu", "Quito", "Bogotá"};
   int[] agk = new int[]{11, 29, 29, 42, 151, 29, 195, 60, 46};
   String[] agl = new String[]{
      "Roma", "Madrid", "Kiev", "Varsóvia", "Paris", "Lisboa", "Berlim", "Milão", "Munique", "Londres", "Liverpool", "Viena", "Budapeste", "Istambul"
   };
   int[] agm = new int[]{104, 65, 193, 152, 72, 154, 3, 104, 3, 97, 97, 15, 88, 192};

   public Finalissima() {
      this.F(13, 7);
   }

   public void Bs() {
      this.agi = null;
      if (this.agg != null && this.agh != null) {
         ArrayList var1 = new ArrayList();
         boolean[] var2 = new boolean[7];
         var1.add(this.agg);
         var1.add(this.agh);
         this.aac = new KnockoutStage(null, var1.size(), 13, 0, var2, this, -1);
         KnockoutRound var3 = new KnockoutRound();
         var3.a(this.aac, var1, 0, var2[0], 0, 0, 13, false);
         this.YH++;

         while (this.agi == null) {
            this.ag(this.agg.getPais(), this.agh.getPais());
         }
      }
   }

   private void ag(int i, int j) {
      boolean var3 = false;
      String[] var10000 = new String[]{""};
      int[] var5 = new int[0];
      if (this.YH % 2 == 0) {
         var3 = true;
      }

      String[] var4;
      if (!var3) {
         var4 = this.agl;
         var5 = this.agm;
      } else {
         var4 = this.agj;
         var5 = this.agk;
      }

      int var6 = new Random().nextInt(var4.length);
      if (i != var5[var6] && j != var5[var6]) {
         this.agi = var4[var6];
      }
   }

   @Override
   public int cy(int i) {
      int[] var2 = new int[]{65000, 55000, 52698};
      int var3 = new Random().nextInt(var2.length);
      return var2[var3] + new Random().nextInt(5000);
   }

   @Override
   public String cx(int i) {
      return this.agi;
   }

   public void Z(Club club) {
      this.agg = club;
   }

   public void aa(Club club) {
      this.agh = club;
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
      var1[0] = "tr_finalissima";
      var1[1] = this.getNome();
      return var1;
   }

   @Override
   public void mr() {
      this.aac.z(this);
   }

   public Club BT() {
      return this.agg;
   }
}
