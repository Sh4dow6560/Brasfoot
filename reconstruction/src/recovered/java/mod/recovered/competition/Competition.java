package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public abstract class Competition implements Serializable {
   private static final long serialVersionUID = 1L;
   private String dm = null;
   private int tR = 0;
   private int dz = -1;
   private boolean tS = true;
   private ArrayList tT = new ArrayList();
   private ArrayList tU = new ArrayList();
   private boolean decisaoTerceiroLugar = false;
   private int ei = -1;
   private transient ArrayList tV = new ArrayList();
   private transient C0731 tW = null;
   public static Comparator tX = new CompetitionPlayerStatsComparator();
   public static Comparator tY = new CompetitionRatingComparator();
   public static Comparator tZ = new CompetitionPerformanceComparator();
   public static Comparator ua = new CompetitionCoachComparator();

   public void clear() {
   }

   public ImageIcon es() {
      return null;
   }

   public String getNome() {
      return this.dm;
   }

   public void setNome(String string) {
      this.dm = string;
   }

   public boolean mm() {
      return this.tS;
   }

   public void N(boolean bl) {
      this.tS = bl;
   }

   public int b() {
      return this.tR;
   }

   public void F(int i, int j) {
      this.tR = i;
      this.dz = j;
   }

   public ArrayList mn() {
      return this.tT;
   }

   public Club cS() {
      Object var1 = null;

      for (int var2 = 0; var2 < this.mn().size(); var2++) {
         if (((CompetitionSeasonResult)this.mn().get(var2)).H() == GamePersistence.careerState.H()) {
            return ((CompetitionSeasonResult)this.mn().get(var2)).ce();
         }
      }

      return null;
   }

   public Club cv(int i) {
      Object var2 = null;

      for (int var3 = 0; var3 < this.mn().size(); var3++) {
         if (((CompetitionSeasonResult)this.mn().get(var3)).H() == i) {
            return ((CompetitionSeasonResult)this.mn().get(var3)).ce();
         }
      }

      return null;
   }

   public CompetitionSeasonResult mo() {
      for (int var1 = 0; var1 < this.mn().size(); var1++) {
         if (((CompetitionSeasonResult)this.mn().get(var1)).H() == GamePersistence.careerState.H()) {
            return (CompetitionSeasonResult)this.mn().get(var1);
         }
      }

      return null;
   }

   public CompetitionSeasonResult mp() {
      for (int var1 = 0; var1 < this.mn().size(); var1++) {
         if (((CompetitionSeasonResult)this.mn().get(var1)).H() == GamePersistence.careerState.H() - 1) {
            return (CompetitionSeasonResult)this.mn().get(var1);
         }
      }

      return null;
   }

   public CompetitionPlayerStats p(Player player) {
      for (int var2 = 0; var2 < this.tU.size(); var2++) {
         if (((CompetitionPlayerStats)this.tU.get(var2)).x() == player) {
            return (CompetitionPlayerStats)this.tU.get(var2);
         }
      }

      CompetitionPlayerStats var3 = new CompetitionPlayerStats(this, player);
      this.tU.add(var3);
      return var3;
   }

   public void q(Player player) {
      int var2 = -1;

      for (int var3 = 0; var3 < this.tU.size(); var3++) {
         if (((CompetitionPlayerStats)this.tU.get(var3)).x() == player) {
            var2 = var3;
            break;
         }
      }

      if (var2 >= 0) {
         this.tU.remove(var2);
      }
   }

   public CompetitionPlayerStats r(Player player) {
      Object var2 = null;

      for (int var3 = 0; var3 < this.tU.size(); var3++) {
         if (((CompetitionPlayerStats)this.tU.get(var3)).x() == player) {
            return (CompetitionPlayerStats)this.tU.get(var3);
         }
      }

      return (CompetitionPlayerStats)var2;
   }

   public static long getSerialversionuid() {
      return 1L;
   }

   public boolean mq() {
      return this.decisaoTerceiroLugar;
   }

   public void O(boolean bl) {
      this.decisaoTerceiroLugar = bl;
   }

   public C0741 ir() {
      return null;
   }

   public CountryCompetitions iq() {
      return null;
   }

   public int ip() {
      return -1;
   }

   public void mr() {
      System.out.println("at:" + this.getNome());
   }

   public String P(boolean bl) {
      return "";
   }

   public String is() {
      return this.dm;
   }

   public static ArrayList a(int i, boolean bl, int j) {
      ArrayList var3 = new ArrayList();
      boolean var4 = false;

      for (int var5 = 0; var5 < GamePersistence.careerState.R().size(); var5++) {
         for (int var6 = 0; var6 < ((C0693)GamePersistence.careerState.R().get(var5)).t().size(); var6++) {
            if (i == 3 && j == 1 && ((Competition)((C0693)GamePersistence.careerState.R().get(var5)).t().get(var6)).b() == 9) {
               var4 = true;
            } else {
               var4 = false;
            }

            if (!var4 && !var3.contains(((C0693)GamePersistence.careerState.R().get(var5)).t().get(var6)) && ((Competition)((C0693)GamePersistence.careerState.R().get(var5)).t().get(var6)).cw(i)) {
               var3.add((Competition)((C0693)GamePersistence.careerState.R().get(var5)).t().get(var6));
            }
         }
      }

      if (i == 4) {
         RegionalCup[] var10 = GamePersistence.careerState.bV();

         for (int var12 = 0; var12 < var10.length; var12++) {
            if (var10[var12] != null) {
               var3.add(var10[var12]);
            }
         }
      }

      if (GamePersistence.careerState.bk() && i == 0) {
         CountryCompetitions var11 = GamePersistence.careerState.o(29);
         Object var13 = null;
         int var7 = 0;

         for (int var8 = 0; var8 < var3.size(); var8++) {
            if (var3.get(var8) instanceof NationalLeague
               && ((NationalLeague)var3.get(var8)).yg() != null
               && ((NationalLeague)var3.get(var8)).yg().jc() == 29
               && ((NationalLeague)var3.get(var8)).ip() == 3) {
               var7 = var8 + 1;
               break;
            }
         }

         if (var11.eb().size() == 4) {
            var13 = (Competition)var11.eb().get(var11.eb().size() - 1);
            if (var13 != null) {
               if (!var3.contains(var13)) {
                  var3.add(var7, var13);
               } else {
                  var3.remove(var13);
                  var3.add(var7, var13);
               }
            }
         }

         if (var11 != null) {
            if (var11.jq() == null) {
               var11.a((NationalCup)null);
            }

            if (!var3.contains(var11.jq())) {
               var3.add(var11.jq());
            }
         }
      }

      if (i == 3 && bl) {
         if (GamePersistence.careerState.aY() != null && !var3.contains(GamePersistence.careerState.aY())) {
            var3.add(GamePersistence.careerState.aY());
         }

         if (GamePersistence.careerState.ba() != null && !var3.contains(GamePersistence.careerState.ba())) {
            var3.add(GamePersistence.careerState.ba());
         }

         if (GamePersistence.careerState.aZ() != null && !var3.contains(GamePersistence.careerState.aZ())) {
            var3.add(GamePersistence.careerState.aZ());
         }

         if (GamePersistence.careerState.be() != null && !var3.contains(GamePersistence.careerState.be())) {
            var3.add(GamePersistence.careerState.be());
         }

         if (GamePersistence.careerState.bf() != null && !var3.contains(GamePersistence.careerState.bf())) {
            var3.add(GamePersistence.careerState.bf());
         }

         if (GamePersistence.careerState.bg() != null && !var3.contains(GamePersistence.careerState.bg())) {
            var3.add(GamePersistence.careerState.bg());
         }

         if (GamePersistence.careerState.bX() != null && !var3.contains(GamePersistence.careerState.bX())) {
            var3.add(GamePersistence.careerState.bX());
         }

         if (GamePersistence.careerState.yl() != null && !var3.contains(GamePersistence.careerState.yl())) {
            var3.add(GamePersistence.careerState.yl());
         }

         if (GamePersistence.careerState.sq() != null && !var3.contains(GamePersistence.careerState.sq())) {
            var3.add(GamePersistence.careerState.sq());
         }

         if (GamePersistence.careerState.ym() != null && !var3.contains(GamePersistence.careerState.ym())) {
            var3.add(GamePersistence.careerState.ym());
         }
      }

      if (i == 1 && bl) {
         if (GamePersistence.careerState.aR() != null && !var3.contains(GamePersistence.careerState.aR())) {
            var3.add(GamePersistence.careerState.aR());
         }

         if (GamePersistence.careerState.aW() != null && !var3.contains(GamePersistence.careerState.aW())) {
            var3.add(GamePersistence.careerState.aW());
         }

         if (GamePersistence.careerState.aV() != null && !var3.contains(GamePersistence.careerState.aV())) {
            var3.add(GamePersistence.careerState.aV());
         }
      }

      if (i == 1 && GamePersistence.careerState.aK() != null && !var3.contains(GamePersistence.careerState.aK())) {
         var3.add(GamePersistence.careerState.aK());
      }

      return var3;
   }

   public boolean cw(int i) {
      if (i == 0) {
         if (this.tR == 1) {
            return true;
         }

         if (this.tR == 2) {
            return true;
         }

         if (!GamePersistence.careerState.isJogaIntClubes() && this.tR == 15) {
            return true;
         }
      } else if (i == 1) {
         if (this.tR == 4) {
            return true;
         }

         if (this.tR == 5) {
            return true;
         }

         if (this.tR == 6) {
            return true;
         }

         if (this.tR == 8) {
            return true;
         }

         if (this.tR == 12) {
            return true;
         }

         if (this.tR == 15) {
            return true;
         }
      } else if (i == 2) {
         if (this.tR == 3) {
            return true;
         }
      } else if (i == 3 && (this.tR == 7 || this.tR == 9 || this.tR == 13 || this.tR == 14)) {
         return true;
      }

      return false;
   }

   public ArrayList ms() {
      return this.tU;
   }

   public void U(ArrayList arrayList) {
      this.tU = arrayList;
   }

   public int mt() {
      return this.tU.size();
   }

   public CompetitionPlayerStats mu() {
      this.mv();
      return this.tU != null && this.tU.size() > 0 ? (CompetitionPlayerStats)this.tU.get(0) : null;
   }

   public void mv() {
      if (this.tU != null && this.tU.size() > 0) {
         for (int var1 = 0; var1 < this.tU.size(); var1++) {
            if (((CompetitionPlayerStats)this.tU.get(var1)).x() != null) {
               C0674 var2 = ((CompetitionPlayerStats)this.tU.get(var1)).x().g(this);
               if (var2 != null) {
                  ((CompetitionPlayerStats)this.tU.get(var1)).i(var2.w());
               }
            }
         }

         Collections.sort(this.tU, tX);
      }
   }

   public void mw() {
      this.tU.clear();
   }

   public void mx() {
      this.tV.clear();
      this.tW = null;
   }

   public void my() {
      double var1 = 0.0;
      int var3 = 0;
      int var4 = 0;
      Match var5 = null;
      int var6 = 3;
      Club var7 = null;
      ArrayList var8 = new ArrayList();

      for (int var9 = 0; var9 < GamePersistence.careerState.R().size(); var9++) {
         if (((C0693)GamePersistence.careerState.R().get(var9)).e() && ((C0693)GamePersistence.careerState.R().get(var9)).h().size() > 0) {
            for (int var10 = 0; var10 < ((C0693)GamePersistence.careerState.R().get(var9)).h().size(); var10++) {
               if (((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hy() == this) {
                  var3++;
                  var4 += ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hu();
                  var4 += ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hw();
                  if (((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hu() - ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hw() >= var6) {
                     var5 = (Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10);
                     var6 = ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hu() - ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hw();
                  }

                  if (((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hw() - ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hu() >= var6) {
                     var5 = (Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10);
                     var6 = ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hw() - ((Match)((C0693)GamePersistence.careerState.R().get(var9)).h().get(var10)).hu();
                  }
               }
            }
         }
      }

      if (var3 > 0) {
         var1 = (double)var4 / var3;
      }

      if (this.cS() != null) {
         var7 = this.cS();
      } else {
         for (int var13 = 0; var13 < this.mn().size(); var13++) {
            if (((CompetitionSeasonResult)this.mn().get(var13)).H() == GamePersistence.careerState.H() - 1) {
               var7 = ((CompetitionSeasonResult)this.mn().get(var13)).ce();
               break;
            }
         }
      }

      ArrayList var14 = new ArrayList();

      for (int var15 = 0; var15 < this.mn().size(); var15++) {
         if (!var8.contains(((CompetitionSeasonResult)this.mn().get(var15)).ce())) {
            var8.add(((CompetitionSeasonResult)this.mn().get(var15)).ce());
         }

         var14.add(((CompetitionSeasonResult)this.mn().get(var15)).ce());
      }

      ArrayList var16 = null;
      if (var8.size() > 0) {
         var16 = new ArrayList();

         for (int var11 = 0; var11 < var8.size(); var11++) {
            var16.add(new C0707((Club)var8.get(var11), Collections.frequency(var14, var8.get(var11))));
         }

         Collections.sort(var16, ua);
      }

      this.tW = new C0731(var1, var4, var3, var5, var7, var16);
   }

   public void mz() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < GamePersistence.careerState.O().size(); var2++) {
         C0674 var3 = ((Player)GamePersistence.careerState.O().get(var2)).g(this);
         if (var3 != null && var3.F() > 5.0) {
            var1.add(new C0690((Player)GamePersistence.careerState.O().get(var2), var3.F(), var3.gZ()));
         }
      }

      Collections.sort(var1, tY);
      if (this.tV == null) {
         this.tV = new ArrayList();
      }

      this.tV.clear();
      if (var1.size() >= 4) {
         for (int var4 = 0; var4 < 5; var4++) {
            this.tV.add((C0690)var1.get(var4));
         }
      }

      var1.clear();
   }

   public String[] mA() {
      return new String[]{"", ""};
   }

   public int gg() {
      return this.dz;
   }

   public int el() {
      return this.dz;
   }

   public int gD() {
      return this.ei;
   }

   public void az(int i) {
      this.ei = i;
   }

   public CompetitionStage[] mB() {
      return null;
   }

   public ArrayList mC() {
      return null;
   }

   public String[] b(CompetitionStage c0678) {
      return null;
   }

   public ArrayList mD() {
      return this.tV;
   }

   public C0731 mE() {
      return this.tW;
   }

   public void a(C0731 c0731) {
      this.tW = c0731;
   }

   public String cx(int i) {
      return null;
   }

   public int cy(int i) {
      return 40000;
   }

   public boolean cz(int i) {
      return false;
   }

   public CountryCompetitions mF() {
      return null;
   }
}
