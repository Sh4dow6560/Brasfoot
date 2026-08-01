package bf22.intermediary;

import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import mod.recovered.config.LeagueLoadOptions;
import mod.recovered.model.Club;

public class C0956 extends Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage YD = null;
   private ArrayList YF = new ArrayList();
   private Club ZA = null;
   private ArrayList YV = new ArrayList();
   private KnockoutStage YP = null;
   private KnockoutStage YQ = null;

   public C0956() {
      this.setNome(C0679.getString("ligaCaf"));
      this.F(4, 2);
      this.yo();
   }

   private void yo() {
      this.YV.clear();
      this.YV.add(new C0793("tun", 190, 2));
      this.YV.add(new C0793("argl", 10, 3));
      this.YV.add(new C0793("egi", 57, 3));
      this.YV.add(new C0793("mar", 129, 3));
      this.YV.add(new C0793("afr sul", 1, 2));
      this.YV.add(new C0793("congo", 47, 1));
      this.YV.add(new C0793("cosMarf", 50, 1));
      this.YV.add(new C0793("gana", 75, 1));
      this.YV.add(new C0793("nigeria", 141, 1));
      this.YV.add(new C0793("mali", 127, 1));
      this.YV.add(new C0793("eti", 67, 1));
      this.YV.add(new C0793("camar", 36, 1));
      this.YV.add(new C0793("ang", 5, 1));
      this.YV.add(new C0793("rep.dem.cong.", 157, 1));
      this.YV.add(new C0793("sudao", 178, 1));
      this.YV.add(new C0793("zim", 201, 1));
      this.YV.add(new C0793("zam", 200, 1));
      this.YV.add(new C0793("guin", 81, 1));
      this.YV.add(new C0793("lib", 116, 1));
      this.YV.add(new C0793("sen", 169, 1));
      this.YV.add(new C0793("moç", 133, 1));
      this.YV.add(new C0793("uga", 194, 1));
      this.YV.add(new C0793("tan", 186, 1));
   }

   public void a(int i, C0792 c0792) {
      C0938.a(2, 1, this.YV, null, i, c0792);
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
      if (this.YF.size() < 32) {
         C0938.a(this.YF, this.YV, 32, var2);
      }

      Collections.sort(this.YF, C1007.abm);
      ArrayList var3 = new ArrayList();
      if (this.YF.size() >= 32) {
         int[] var4 = new int[]{0, 15, 23, 31, 3, 14, 22, 29, 5, 13, 21, 27, 7, 12, 20, 25, 1, 11, 19, 30, 2, 10, 18, 28, 4, 9, 17, 26, 6, 8, 16, 24};

         for (int var5 = 0; var5 < var4.length; var5++) {
            var3.add((Club)this.YF.get(var4[var5]));
         }

         LeagueLoadOptions var7 = new LeagueLoadOptions();
         var7.nTimes = 32;
         var7.nGrupos = 8;
         var7.numeroTimesMataMata = 2;
         var7.doisTurnos = true;
         var7.pulaDuasDatas = true;
         LeagueStage var6 = new LeagueStage(var7, var3, 0, null, null, null, 4, null, false, null, true, this);
         this.YD = var6;
         var6.setNome(this.getNome());
      } else {
         System.out.println("erro Liga Africa() " + this.YF.size());
      }
   }

   public void q(ArrayList arrayList, ArrayList arrayList2) {
   }

   public void g(ArrayList arrayList, ArrayList arrayList2) {
   }

   public void l(ArrayList arrayList, ArrayList arrayList2) {
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
      var1[0] = "tr_ligacaf";
      var1[1] = this.getNome();
      return var1;
   }

   public KnockoutStage By() {
      return this.YP;
   }

   public KnockoutStage Bz() {
      return this.YQ;
   }
}
