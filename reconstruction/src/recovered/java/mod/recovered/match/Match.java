package mod.recovered.match;

import mod.recovered.game.ScheduleDay;
import bf22.intermediary.*;
import mod.recovered.competition.Competition;
import mod.recovered.competition.CompetitionStage;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.competition.KnockoutStage;
import mod.recovered.competition.LeagueStage;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.model.Club;
import mod.recovered.model.Player;
import mod.recovered.model.Stadium;

public class Match implements Serializable {
   private static final long serialVersionUID = 1L;
   private boolean v = false;
   private CompetitionStage competitionStage;
   private Competition competition;
   private int scheduleIndex;
   private Club homeClub;
   private Club awayClub;
   private int homeGoals = 0;
   private int awayGoals = 0;
   private Stadium stadium;
   private int[] fD = new int[4];
   private int fE = 0;
   private ArrayList homeStartingLineup = new ArrayList();
   private ArrayList awayStartingLineup = new ArrayList();
   private ArrayList homeBench = new ArrayList();
   private ArrayList awayBench = new ArrayList();
   private ArrayList homePlayersOnField = new ArrayList();
   private ArrayList awayPlayersOnField = new ArrayList();
   private ArrayList homeSubstitutesUsed = new ArrayList();
   private ArrayList awaySubstitutesUsed = new ArrayList();
   private ArrayList events = new ArrayList();
   private int fO = 0;
   private int fP = 0;
   private int[] fQ = new int[]{0, 0, -1};
   private int[] remainingSubstitutions = new int[]{5, 5};
   private int fS = 0;
   private int fT = 0;
   private int fU = 0;
   private ArrayList fV = new ArrayList();
   private int[] possessionPercentages = new int[]{50, 50};
   private int[] fX = new int[2];
   private int[] shots = new int[2];
   private int[] shotsOnTarget = new int[2];
   private int[] shotsOffTarget = new int[2];
   private int[] tackles = new int[2];
   private int[] misplacedPasses = new int[2];
   private int[] fouls = new int[2];
   private boolean ge = false;
   private boolean gf = false;
   private int gg = -1;
   private int gh = -1;
   private int[] gi = new int[]{-1, -1};
   private boolean gj = false;
   private Club gk = null;
   private int[][] gl = new int[2][11];
   private int[][] gm = new int[][]{{-1, -1, -1, -1}, {-1, -1, -1, -1}};
   private int[][] gn = new int[][]{{-1, -1, -1}, {-1, -1, -1}};
   private int dq = 0;
   private transient MatchEngine matchEngine = null;
   private transient String gp = "";
   private transient String gq = null;
   private transient Stadium gr = null;
   private static ArrayList gs = null;
   private static ArrayList gt = null;
   private static ArrayList gu = null;
   private static ArrayList gv = null;
   private static ArrayList gw = null;

   public Match() {
   }

   public void clear() {
      this.events.clear();
      this.homeStartingLineup.clear();
      this.awayStartingLineup.clear();
      this.homeBench.clear();
      this.awayBench.clear();
      this.homePlayersOnField.clear();
      this.awayPlayersOnField.clear();
      this.homeSubstitutesUsed.clear();
      this.awaySubstitutesUsed.clear();
   }

   public String ha() {
      String var1 = "<html>"
         + this.possessionPercentages[0]
         + "% "
         + " <b>posse de bola</b> "
         + this.possessionPercentages[1]
         + " %"
         + "<br>"
         + this.shots[0]
         + " <b>finalizações</b> "
         + this.shots[1]
         + "<br>"
         + "<center>"
         + this.shotsOnTarget[0]
         + " <b>no gol</b> "
         + this.shotsOnTarget[1]
         + "</center>"
         + "<br>"
         + this.shotsOffTarget[0]
         + " <b>para fora</b> "
         + this.shotsOffTarget[1]
         + "<br>"
         + this.tackles[0]
         + " <b>desarnes</b> "
         + this.tackles[1]
         + "<br>"
         + this.misplacedPasses[0]
         + " passes errados "
         + this.misplacedPasses[1]
         + "<br>"
         + this.fouls[0]
         + " faltas "
         + this.fouls[1]
         + "</html>";
      return "<html><body><table width=\"190\" border=\"0\"><tr><td colspan=\"2\">"
         + this.possessionPercentages[0]
         + "% </td>"
         + "<td colspan=\"2\" align=\"center\"><strong>posse de bola</strong></td>"
         + "<td colspan=\"2\">"
         + this.possessionPercentages[1]
         + "% </td>"
         + "</tr>"
         + "<tr>"
         + "<td colspan=\"2\">"
         + this.shots[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>finalizações</strong></td>"
         + "<td colspan=\"2\">"
         + this.shots[1]
         + "</td>"
         + "</tr>"
         + "<tr>"
         + "<td colspan=\"2\">"
         + this.shotsOnTarget[0]
         + "/"
         + this.shotsOffTarget[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>no gol/fora</strong></td>"
         + "<td colspan=\"2\">"
         + this.shotsOnTarget[1]
         + "/"
         + this.shotsOffTarget[1]
         + "</td>"
         + "</tr>"
         + "<td colspan=\"2\">"
         + this.tackles[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>desarmes</strong></td>"
         + "<td colspan=\"2\">"
         + this.tackles[1]
         + "</td>"
         + "</tr>"
         + "</tr>"
         + "<td colspan=\"2\">"
         + this.misplacedPasses[0]
         + "</td>"
         + "<td colspan=\"2\" align=\"center\"><strong>erros passes</strong></td>"
         + "<td  colspan=\"2\">"
         + this.misplacedPasses[1]
         + "</td>"
         + "</tr>"
         + "</table>"
         + "</body>"
         + "</html>";
   }

   public Match(CompetitionStage c0678, int i, Club club, Club club2, int j, Competition c0713, Stadium stadium) {
      this.competitionStage = c0678;
      this.homeClub = club;
      this.awayClub = club2;
      this.scheduleIndex = j;
      this.competition = c0713;
      if (stadium == null) {
         this.stadium = this.homeClub.getStadium();
      } else {
         this.stadium = stadium;
      }

      if (this.stadium != null) {
         this.dq = this.stadium.dX();
      }

      if (c0678 != null) {
         if (c0678.b() == 9) {
            CountryCompetitions var8 = GamePersistence.careerState.s(this.homeClub.getPais());
            if (var8 != null) {
               this.stadium = var8.C(false);
            }
         } else if ((c0678.b() == 4 || c0678.b() == 6 || c0678.b() == 12) && (c0713.gg() == 0 || c0713.gg() == 1) && c0713.cz(i)) {
            this.stadium = null;
            CountryCompetitions var10 = c0713.mF();
            if (var10 != null) {
               boolean var9 = true;
               if (c0678.b() == 6) {
                  var9 = false;
               }

               this.stadium = var10.C(var9);
            }
         }
      }

      ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(j)).a(this);
      ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(j)).a(c0678);
      ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(j)).a(c0713);
      if (this.competition.b() == 5 || this.competition.b() == 15) {
         this.stadium = null;
      }

      this.hb();
   }

   private void hb() {
      if (gs == null) {
         gs = new ArrayList();

         for (int var1 = 19; var1 <= 38; var1++) {
            gs.add(var1);
         }
      }

      Collections.shuffle(gs);
      if (gt == null) {
         gt = new ArrayList();

         for (int var3 = 5; var3 <= 15; var3++) {
            gt.add(var3);
         }
      }

      if (gu == null) {
         gu = new ArrayList();

         for (int var4 = 16; var4 <= 35; var4++) {
            gu.add(var4);
         }
      }

      if (gv == null) {
         gv = new ArrayList();

         for (int var5 = 36; var5 <= 42; var5++) {
            gv.add(var5);
         }
      }

      if (gw == null) {
         gw = new ArrayList();

         for (int var6 = 43; var6 <= 47; var6++) {
            gw.add(var6);
         }
      }

      Random var7 = new Random();
      int var2 = var7.nextInt(100);
      this.gn[0][0] = (Integer)gs.get(0);
      this.gn[0][1] = (Integer)gs.get(1);
      this.gn[1][0] = (Integer)gs.get(2);
      this.gn[1][1] = (Integer)gs.get(3);
      if (var7.nextInt(100) > 30) {
         this.gn[0][2] = (Integer)gs.get(4);
      }

      if (var7.nextInt(100) > 30) {
         this.gn[1][2] = (Integer)gs.get(5);
      }

      if (var2 > 90) {
         this.F(gt);
      } else if (var2 > 50) {
         this.F(gu);
      } else {
         this.F(gv);
      }

      Collections.shuffle(gw);
      if (var7.nextInt(100) > 20) {
         this.gm[0][2] = (Integer)gw.get(0);
      }

      if (var7.nextInt(100) > 50) {
         this.gm[0][3] = (Integer)gw.get(1);
      }

      if (var7.nextInt(100) > 20) {
         this.gm[1][2] = (Integer)gw.get(2);
      }

      if (var7.nextInt(100) > 50) {
         this.gm[1][3] = (Integer)gw.get(3);
      }
   }

   private void F(ArrayList arrayList) {
      Collections.shuffle(arrayList);
      this.gm[0][0] = (Integer)arrayList.get(0);
      this.gm[0][1] = (Integer)arrayList.get(1);
      this.gm[1][0] = (Integer)arrayList.get(2);
      this.gm[1][1] = (Integer)arrayList.get(3);
   }

   public Match(Club club, Club club2, boolean bl) {
      this.homeClub = club;
      this.awayClub = club2;
   }

   public Club getHomeClub() {
      return this.homeClub;
   }

   public void setHomeClub(Club club) {
      this.homeClub = club;
   }

   public Club getAwayClub() {
      return this.awayClub;
   }

   public void setAwayClub(Club club) {
      this.awayClub = club;
   }

   public static void he() {
      new ArrayList();
      ArrayList var0 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).h();
      Competition var1 = null;
      int var2 = 0;

      for (int var3 = 0; var3 < var0.size(); var3++) {
         ((Match)var0.get(var3)).o(((Match)var0.get(var3)).hG());
         if (((Match)var0.get(var3)).getCompetition() != null) {
            if (((Match)var0.get(var3)).getCompetition().b() == 15) {
               ((Match)var0.get(var3)).a(((Match)var0.get(var3)).getCompetition(), var2, true, GamePersistence.careerState.yn().Bt());
            }

            boolean var4 = false;
            if (((Match)var0.get(var3)).getCompetition().b() == 14 && ((Match)var0.get(var3)).getCompetitionStage() == GamePersistence.careerState.sq().BF()) {
               var4 = true;
            }

            if (((Match)var0.get(var3)).getCompetition().b() == 7 || ((Match)var0.get(var3)).getCompetition().b() == 13 || var4) {
               if (var1 != ((Match)var0.get(var3)).getCompetition()) {
                  var2 = 0;
               }

               var1 = ((Match)var0.get(var3)).getCompetition();
               ((Match)var0.get(var3)).a(((Match)var0.get(var3)).getCompetition(), var2, false, "");
               var2++;
            }

            if (((Match)var0.get(var3)).getCompetition().b() == 9
               && ((Match)var0.get(var3)).getCompetitionStage() != null
               && ((Match)var0.get(var3)).getCompetitionStage() instanceof LeagueStage
               && ((LeagueStage)((Match)var0.get(var3)).getCompetitionStage()).ze() == 7701) {
               CountryCompetitions var5 = GamePersistence.careerState.aY().eY(2);
               String var6 = "";
               if (var5 != null) {
                  var6 = var5.jf();
               }

               ((Match)var0.get(var3)).a(((Match)var0.get(var3)).getCompetition(), var2, true, var6);
            }
         }

         ((Match)var0.get(var3)).V();
      }
   }

   public void hf() {
      int var1 = this.competition.b();
      if (var1 != 7 && var1 != 5 && this.getHomeClub().isUserControlled()) {
         this.getHomeClub().credit(this.fE, 5);
      }
   }

   public void hg() {
      int var1 = -1;
      if (this.competition != null) {
         var1 = this.competition.b();
      }

      C0686 var2 = null;

      for (int var3 = 0; var3 < GamePersistence.careerState.bd().size(); var3++) {
         if (((C0686)GamePersistence.careerState.bd().get(var3)).a(this.homeClub, this.awayClub)) {
            var2 = (C0686)GamePersistence.careerState.bd().get(var3);
         }
      }

      if (var2 != null) {
         var2.a(this.homeClub, this.awayClub, this.homeGoals, this.awayGoals, var1);
      } else {
         new C0686(this.homeClub.getClubId(), this.awayClub.getClubId(), this.homeGoals, this.awayGoals, var1);
      }

      this.homeClub.e(this);
      this.awayClub.e(this);
      if (this.homeClub.getCoach() != null) {
         this.homeClub.getCoach().recordMatchResult(this);
         if (this.competition != null
            && (
               this.competition.b() == 1
                  || this.competition.b() == 3
                  || this.competition.b() == 2
                  || this.competition.b() == 4
                  || this.competition.b() == 5
                  || this.competition.b() == 6
                  || this.competition.b() == 8
                  || this.competition.b() == 10
            )) {
            this.homeClub.getCoach().updateApprovalFromMatch(this, false, -1);
         }
      }

      if (this.awayClub.getCoach() != null) {
         this.awayClub.getCoach().recordMatchResult(this);
         if (this.competition != null
            && (
               this.competition.b() == 1
                  || this.competition.b() == 3
                  || this.competition.b() == 2
                  || this.competition.b() == 4
                  || this.competition.b() == 5
                  || this.competition.b() == 6
                  || this.competition.b() == 8
                  || this.competition.b() == 10
            )) {
            this.awayClub.getCoach().updateApprovalFromMatch(this, false, -1);
         }
      }
   }

   public void hh() {
      for (int var1 = 0; var1 < this.homeStartingLineup.size(); var1++) {
         ((Player)this.homeStartingLineup.get(var1)).b(this.competition, this.getHomeClub());
         ((Player)this.homeStartingLineup.get(var1)).a(this.competition, this, 0, 1, this.getHomeClub());
         if (var1 < this.gl[0].length) {
            this.gl[0][var1] = ((Player)this.homeStartingLineup.get(var1)).getTacticalPosition();
         }
      }

      for (int var2 = 0; var2 < this.awayStartingLineup.size(); var2++) {
         ((Player)this.awayStartingLineup.get(var2)).b(this.competition, this.getAwayClub());
         ((Player)this.awayStartingLineup.get(var2)).a(this.competition, this, 1, 0, this.getAwayClub());
         if (var2 < this.gl[1].length) {
            this.gl[1][var2] = ((Player)this.awayStartingLineup.get(var2)).getTacticalPosition();
         }
      }

      for (int var3 = 0; var3 < this.homeSubstitutesUsed.size(); var3++) {
         ((Player)this.homeSubstitutesUsed.get(var3)).b(this.competition, this.getHomeClub());
         ((Player)this.homeSubstitutesUsed.get(var3)).a(this.competition, this, 0, 1, this.getHomeClub());
      }

      for (int var4 = 0; var4 < this.awaySubstitutesUsed.size(); var4++) {
         ((Player)this.awaySubstitutesUsed.get(var4)).b(this.competition, this.getAwayClub());
         ((Player)this.awaySubstitutesUsed.get(var4)).a(this.competition, this, 1, 0, this.getAwayClub());
      }

      for (int var5 = 0; var5 < this.events.size(); var5++) {
         if (((MatchEvent)this.events.get(var5)).getPrimaryPlayer() != null) {
            if (((MatchEvent)this.events.get(var5)).getType() == 1 && ((MatchEvent)this.events.get(var5)).getSubtype() != 2) {
               ((MatchEvent)this.events.get(var5)).getPrimaryPlayer().a(this.competition, ((MatchEvent)this.events.get(var5)).getClub());
            } else if (((MatchEvent)this.events.get(var5)).getType() == 2 || ((MatchEvent)this.events.get(var5)).getType() == 3 || ((MatchEvent)this.events.get(var5)).getType() == 4) {
               ((MatchEvent)this.events.get(var5)).getPrimaryPlayer().a(((MatchEvent)this.events.get(var5)).getType(), this.competition, ((MatchEvent)this.events.get(var5)).getClub());
            }
         }
      }
   }

   public void hi() {
      Competition var1 = this.competition;

      for (int var2 = 0; var2 < this.homeClub.getSeniorPlayers().size(); var2++) {
         ((Player)this.homeClub.getSeniorPlayers().get(var2)).aw(0);
         if (((Player)this.homeClub.getSeniorPlayers().get(var2)).c(var1)) {
            ((Player)this.homeClub.getSeniorPlayers().get(var2)).f(var1);
         }
      }

      for (int var3 = 0; var3 < this.awayClub.getSeniorPlayers().size(); var3++) {
         ((Player)this.awayClub.getSeniorPlayers().get(var3)).aw(0);
         if (((Player)this.awayClub.getSeniorPlayers().get(var3)).c(var1)) {
            ((Player)this.awayClub.getSeniorPlayers().get(var3)).f(var1);
         }
      }
   }

   public static void a(int i, Match c0675, Player player, int j, int k) {
      Club var5 = c0675.getHomeClub();
      if (i == 1) {
         var5 = c0675.getAwayClub();
      }

      a(4, -1, c0675, var5, player, null, j, k);
   }

   public static void b(int i, Match c0675, Player player, int j, int k) {
      player.gj();
      Club var5 = c0675.getHomeClub();
      if (i == 1) {
         var5 = c0675.getAwayClub();
      }

      if (player.gi() == 2) {
         a(3, -1, c0675, var5, player, null, j, k);
      } else {
         a(2, -1, c0675, var5, player, null, j, k);
      }
   }

   public void k(int i, int j) {
      for (int var3 = 1; var3 <= j; var3++) {
         a(this, i, var3);
      }
   }

   public static void a(Match c0675, int i, int j) {
      int var3 = 30;
      int var4 = 700;
      int var5 = 1000;
      Player var6 = null;
      int[] var7 = new int[]{70, 40, 30};
      int[] var8 = new int[]{45, 40, 30};
      int[] var9 = new int[]{1200, 900, 800};
      int[] var10 = new int[]{800, 700, 550};
      int[] var11 = new int[]{1500, 1000, 800};
      int[] var12 = new int[]{800, 600, 600};
      byte var13 = 0;
      int var15 = new Random().nextInt(100);
      int var16 = 0;
      byte var17 = 0;
      ArrayList var14;
      if (var15 > 55) {
         var14 = c0675.homePlayersOnField;
         var16 = c0675.getHomeClub().getTacticalSettings()[2];
      } else {
         var14 = c0675.awayPlayersOnField;
         var16 = c0675.getAwayClub().getTacticalSettings()[2];
         var17 = 1;
      }

      int[] var18 = new int[]{30, 10, 0};
      if (var16 >= var18.length) {
         var16 = 0;
      }

      if (j < 15) {
         var13 = 0;
      } else if (j < 30) {
         var13 = 1;
      } else {
         var13 = 2;
      }

      if (j % 7 == 0) {
         c0675.applyEnergyDrain(i, j);
      }

      if (i == 1) {
         var3 = var7[var13] + var18[var16];
         var4 = var9[var13];
         var5 = var11[var13];
      } else {
         var3 = var8[var13] + var18[var16];
         var4 = var10[var13];
         var5 = var12[var13];
      }

      if (c0675.fS > 5) {
         var3 *= 2;
      } else if (c0675.fS > 10) {
         var3 = 1000;
      }

      if (c0675.fT >= 2) {
         var3 = var4 * 2;
      }

      if (c0675.fU >= 1) {
         var3 = var5 * 5;
      }

      if (new Random().nextInt(var3) == 1) {
         var6 = H(var14);
         c0675.fS++;
         if (var6 != null) {
            b(var17, c0675, var6, i, j);
         }
      } else if (new Random().nextInt(var4) == 1) {
         var6 = J(var14);
         if (var6 != null) {
            a(var17, c0675, var6, i, j);
         }

         c0675.fT++;
      } else if (new Random().nextInt(var5) == 1) {
         c0675.fU++;
         Club var19 = c0675.getHomeClub();
         if (var17 == 1) {
            var19 = c0675.getAwayClub();
         }

         var6 = I(var14);
         if (var6 != null) {
            a(5, -1, c0675, var19, var6, null, i, j);
         }
      } else if (i == 2 && j >= 5) {
         c0675.evaluateScoreBasedSubstitutions(i, j);
      }
   }

   public int a(Player player, int i, int j) {
      byte var4 = 1;
      int var5 = new Random().nextInt(1000);
      if (i == 1) {
         if (var5 < 900) {
            var4 = 1;
         } else if (var5 < 950) {
            var4 = 3;
         } else if (var5 < 980) {
            var4 = 4;
         } else if (var5 < 990) {
            var4 = 2;
         } else if (var5 < 995) {
            var4 = 5;
         } else {
            var4 = 1;
         }
      } else if (i == 2) {
         if (var5 < 800) {
            var4 = 1;
         } else if (var5 < 850) {
            var4 = 3;
         } else if (var5 < 980) {
            var4 = 4;
         } else if (var5 < 990) {
            var4 = 2;
         } else if (var5 < 995) {
            var4 = 5;
         } else {
            var4 = 1;
         }
      }

      if (var4 == 5 && (player.getPosicao() == 0 || player.getPosicao() == 2)) {
         var4 = 1;
      }

      if (var4 == 3) {
         ArrayList var6 = null;
         byte var7 = 0;
         if (player.getClub() == this.homeClub) {
            var6 = this.awayPlayersOnField;
            var7 = 1;
         } else if (player.getClub() == this.awayClub) {
            var6 = this.homePlayersOnField;
            var7 = 0;
         }

         if (var6 != null) {
            var5 = new Random().nextInt(100);
            if (var5 < 50) {
               Player var8 = H(var6);
               if (var8 != null) {
                  b(var7, this, var8, i, j);
               }
            } else if (var5 < 60) {
               Player var10 = J(var6);
               if (var10 != null) {
                  a(var7, this, var10, i, j);
               }
            }
         }
      }

      return var4;
   }

   public static C0671 a(Match c0675, int i, int j, int k) {
      for (int var4 = 0; var4 < c0675.fV.size(); var4++) {
         if (((C0671)c0675.fV.get(var4)).fc() == i && ((C0671)c0675.fV.get(var4)).eZ() == k && ((C0671)c0675.fV.get(var4)).en() == j) {
            return (C0671)c0675.fV.get(var4);
         }
      }

      return null;
   }

   public static MatchEvent a(int i, int j, Match c0675, Club club, Player player, Player player2, int k, int l) {
      ArrayList var8 = null;
      ArrayList var9 = null;
      byte var10 = 0;
      if (club == c0675.homeClub) {
         var8 = c0675.getHomePlayersOnField();
         var9 = c0675.getAwayPlayersOnField();
         var10 = 0;
      } else if (club == c0675.awayClub) {
         var8 = c0675.getAwayPlayersOnField();
         var9 = c0675.getHomePlayersOnField();
         var10 = 1;
      }

      MatchEvent var11 = new MatchEvent(var10);
      var11.setType(i);
      var11.setPrimaryPlayer(player);
      if (j == 2) {
         Player var12 = G(var9);
         if (var12 != null) {
            var11.setPrimaryPlayer(var12);
            var11.setSubtype(2);
         } else {
            var11.setSubtype(1);
         }
      } else {
         var11.setSubtype(j);
      }

      if (player2 != null) {
         var11.setSecondaryPlayer(player2);
      }

      var11.setMinute(l);
      var11.setPeriod(k);
      var11.setClub(club);
      c0675.events.add(var11);
      if (i == 2) {
         player.gB().tG();
      } else if (i == 4) {
         player.gB().tH();
      } else if (i == 3) {
         player.gB().tG();
         player.gB().tH();
      }

      if (i != 3 && i != 4) {
         if (i == 5) {
            if (player != null) {
               player.p(club);
            }

            if (var8 != null && !club.isUserControlled()) {
               var8.remove(player);
            }

            if (c0675 != null && club != null && c0675.remainingSubstitutions[var10] > 0 && !club.isUserControlled()) {
               a(var10, false, c0675, player, k, l, true);
            }
         }
      } else if (var8 != null) {
         var8.remove(player);
         if (player.getTacticalPosition() <= 13 && !club.isUserControlled() && c0675.remainingSubstitutions[var10] > 0) {
            a(var10, true, c0675, player, k, l, false);
         }
      }

      return var11;
   }

   public static void a(int i, boolean bl, Match c0675, Player player, int j, int k, boolean bl2) {
      ArrayList var7 = null;
      ArrayList var8 = null;
      Player var9 = null;
      if (i == 0) {
         var7 = c0675.getHomeBench();
         var8 = c0675.homePlayersOnField;
      } else if (i == 1) {
         var7 = c0675.getAwayBench();
         var8 = c0675.awayPlayersOnField;
      }

      if (bl) {
         var9 = a(var8, 18, 25);
         if (var9 == null) {
            var9 = a(var8, 14, 17);
         }

         if (var9 == null && player.getTacticalPosition() == 1) {
            var9 = a(var8, 2, 25);
         }
      } else {
         var9 = player;
      }

      if (var7 != null && var9 != null) {
         Player var10 = null;
         if (player.getTacticalPosition() >= 0) {
            boolean var11 = true;
            if (player.getPosicao() == 0) {
               var11 = false;
            }

            var10 = Club.selectPlayerForTacticalPosition(var7, player.getTacticalPosition(), false, var11);
         }

         if (var10 != null) {
            if (bl2) {
               if (var9.getPosicao() == 0 || var10.getPosicao() != 0) {
                  c0675.performSubstitution(i, var9, var10, j, k, player.getTacticalPosition());
               }
            } else {
               c0675.performSubstitution(i, var9, var10, j, k, player.getTacticalPosition());
            }
         }
      }
   }

   public MatchEvent performSubstitution(int i, Player player, Player player2, int j, int k, int l) {
      MatchEvent var7 = null;
      ArrayList var8 = null;
      ArrayList var9 = null;
      ArrayList var10 = null;
      if (player != null && player2 != null) {
         Club var11 = this.getHomeClub();
         if (i == 0) {
            var8 = this.getHomePlayersOnField();
            var9 = this.getHomeBench();
            var10 = this.homeSubstitutesUsed;
            this.consumeSubstitution(0);
         } else if (i == 1) {
            var8 = this.getAwayPlayersOnField();
            var9 = this.getAwayBench();
            this.consumeSubstitution(1);
            var10 = this.awaySubstitutesUsed;
            var11 = this.getAwayClub();
         }

         if (var8 != null && var9 != null) {
            player2.setTacticalPosition(player.getTacticalPosition());
            if (l > 0) {
               player2.setTacticalPosition(l);
            }

            var8.remove(player);
            var8.add(player2);
            var10.add(player2);
            player2.b(true);
            var9.remove(player2);
         }

         var7 = a(6, -1, this, var11, player, player2, j, k);
      }

      return var7;
   }

   public void applyEnergyDrain(int i, int j) {
      for (int var3 = 0; var3 < this.homePlayersOnField.size(); var3++) {
         if (((Player)this.homePlayersOnField.get(var3)).getTacticalPosition() != 1) {
            ((Player)this.homePlayersOnField.get(var3)).reduceEnergyAfterMatch();
         } else if (i == 2) {
            ((Player)this.homePlayersOnField.get(var3)).reduceEnergyAfterMatch();
         }
      }

      for (int var4 = 0; var4 < this.awayPlayersOnField.size(); var4++) {
         if (((Player)this.awayPlayersOnField.get(var4)).getTacticalPosition() != 1) {
            ((Player)this.awayPlayersOnField.get(var4)).reduceEnergyAfterMatch();
         } else if (i == 2) {
            ((Player)this.awayPlayersOnField.get(var4)).reduceEnergyAfterMatch();
         }
      }
   }

   public void evaluateScoreBasedSubstitutions(int i, int j) {
      boolean var3 = false;
      if (i == 2) {
         if (!this.homeClub.isUserControlled() && this.remainingSubstitutions[0] > 0) {
            if (j == 0 && this.isTeamTrailingBy(1, 1)) {
               if (new Random().nextInt(100) > 50) {
                  var3 = this.attemptAutomaticSubstitution(2, 0, i, j, this.getHomePlayersOnField());
               }
            } else if (j != this.gn[0][0] && j != this.gn[0][1] && j != this.gn[0][2]) {
               if (j == this.gm[0][0] || j == this.gm[0][1] || j == this.gm[0][2] || j == this.gm[0][3]) {
                  var3 = this.attemptAutomaticSubstitution(1, 0, i, j, this.getHomePlayersOnField());
               }
            } else if (this.isTeamTrailingBy(1, 1) || this.isScoreTied()) {
               var3 = this.attemptAutomaticSubstitution(2, 0, i, j, this.getHomePlayersOnField());
            }
         }

         if (!var3 && !this.awayClub.isUserControlled() && this.remainingSubstitutions[1] > 0) {
            if (j == 0 && this.isTeamTrailingBy(2, 2)) {
               if (new Random().nextInt(100) > 50) {
                  this.attemptAutomaticSubstitution(2, 1, i, j, this.getAwayPlayersOnField());
               }
            } else if (j != this.gn[1][0] && j != this.gn[1][1] && j != this.gn[1][2]) {
               if (j == this.gm[1][0] || j == this.gm[1][1] || j == this.gm[1][2] || j == this.gm[1][3]) {
                  this.attemptAutomaticSubstitution(1, 1, i, j, this.getAwayPlayersOnField());
               }
            } else if (this.isTeamTrailingBy(2, 1)) {
               this.attemptAutomaticSubstitution(2, 1, i, j, this.getAwayPlayersOnField());
            }
         }
      }
   }

   public boolean attemptAutomaticSubstitution(int i, int j, int k, int l, ArrayList arrayList) {
      if (i == 1) {
         byte var6 = 60;
         int var7 = 0;
         if (l > 40) {
            var6 = 90;
            if (arrayList.size() > 0) {
               var7 = new Random().nextInt(arrayList.size());
            }
         }

         for (int var8 = var7; var8 < arrayList.size(); var8++) {
            if (((Player)arrayList.get(var8)).getTacticalPosition() != 1 && ((Player)arrayList.get(var8)).getEnergy() < var6) {
               a(j, false, this, (Player)arrayList.get(var8), k, l, false);
               return true;
            }
         }
      } else if (i == 2) {
         Random var9 = new Random();
         int var10 = 0;
         if (arrayList.size() > 0) {
            var10 = var9.nextInt(arrayList.size());
            ArrayList var12 = this.homeSubstitutesUsed;
            if (j == 2) {
               var12 = this.awaySubstitutesUsed;
            }

            if (var12.contains(arrayList.get(var10))) {
               var10 = var9.nextInt(arrayList.size());
            }

            if (((Player)arrayList.get(var10)).getTacticalPosition() != 1 && !var12.contains(arrayList.get(var10))) {
               a(j, false, this, (Player)arrayList.get(var10), k, l, false);
               return true;
            }
         }
      }

      return false;
   }

   private boolean isScoreTied() {
      return this.homeGoals == this.awayGoals;
   }

   private boolean isTeamTrailingBy(int i, int j) {
      if (i == 1) {
         if (this.awayGoals - this.homeGoals >= j) {
            return true;
         }
      } else if (this.homeGoals - this.awayGoals >= j) {
         return true;
      }

      return false;
   }

   public void evaluateFatigueSubstitutions(int i, int j) {
      int var3 = new Random().nextInt(100) + 1;
      byte var4 = 50;
      if (j < 10) {
         var4 = 95;
      } else if (j < 30) {
         var4 = 80;
      } else if (j < 40) {
         var4 = 60;
      } else {
         var4 = 40;
      }

      boolean var5 = false;
      if (var3 > var4) {
         if (!this.homeClub.isUserControlled() && this.remainingSubstitutions[0] > 0) {
            for (int var6 = 0; var6 < this.homePlayersOnField.size(); var6++) {
               if (((Player)this.homePlayersOnField.get(var6)).getTacticalPosition() != 1) {
                  if (((Player)this.homePlayersOnField.get(var6)).getEnergy() < 75) {
                     a(0, false, this, (Player)this.homePlayersOnField.get(var6), i, j, false);
                     var5 = true;
                     break;
                  }
               } else if (i == 2 && ((Player)this.homePlayersOnField.get(var6)).getEnergy() < 40) {
                  a(0, false, this, (Player)this.homePlayersOnField.get(var6), i, j, false);
                  var5 = true;
                  break;
               }
            }
         }

         if (!var5 && !this.awayClub.isUserControlled() && this.remainingSubstitutions[1] > 0) {
            for (int var8 = 0; var8 < this.awayPlayersOnField.size(); var8++) {
               if (((Player)this.awayPlayersOnField.get(var8)).getTacticalPosition() != 1) {
                  if (((Player)this.awayPlayersOnField.get(var8)).getEnergy() < 75) {
                     a(1, false, this, (Player)this.awayPlayersOnField.get(var8), i, j, false);
                     break;
                  }
               } else if (i == 2 && ((Player)this.awayPlayersOnField.get(var8)).getEnergy() < 40) {
                  a(1, false, this, (Player)this.awayPlayersOnField.get(var8), i, j, false);
                  break;
               }
            }
         }
      }
   }

   public static Player G(ArrayList arrayList) {
      int var1 = new Random().nextInt(1000);
      Object var2 = null;
      byte var3 = 0;
      if (var1 == 0) {
         var3 = 6;
      } else if (var1 < 150) {
         var3 = 0;
      } else if (var1 < 350) {
         var3 = 1;
      } else if (var1 < 400) {
         var3 = 2;
      } else if (var1 < 450) {
         var3 = 3;
      } else if (var1 < 500) {
         var3 = 4;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static Player H(ArrayList arrayList) {
      int var1 = new Random().nextInt(100);
      Object var2 = null;
      byte var3 = 0;
      if (var1 < 25) {
         var3 = 0;
      } else if (var1 < 40) {
         var3 = 1;
      } else if (var1 < 65) {
         var3 = 2;
      } else if (var1 < 73) {
         var3 = 3;
      } else if (var1 < 82) {
         var3 = 4;
      } else if (var1 < 85) {
         var3 = 6;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static Player I(ArrayList arrayList) {
      int var1 = new Random().nextInt(500);
      Object var2 = null;
      byte var3 = 0;
      if (var1 == 0) {
         var3 = 6;
      } else if (var1 < 150) {
         var3 = 0;
      } else if (var1 < 250) {
         var3 = 1;
      } else if (var1 < 320) {
         var3 = 2;
      } else if (var1 < 360) {
         var3 = 3;
      } else if (var1 < 420) {
         var3 = 4;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static Player a(ArrayList arrayList, int i, int j) {
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < arrayList.size(); var4++) {
         if (((Player)arrayList.get(var4)).getTacticalPosition() >= i && ((Player)arrayList.get(var4)).getTacticalPosition() <= j) {
            var3.add((Player)arrayList.get(var4));
         }
      }

      Collections.shuffle(var3);
      return var3.size() > 0 ? (Player)var3.get(0) : null;
   }

   public static Player J(ArrayList arrayList) {
      int var1 = new Random().nextInt(200);
      Object var2 = null;
      byte var3 = 0;
      if (var1 == 0) {
         var3 = 6;
      } else if (var1 < 80) {
         var3 = 0;
      } else if (var1 < 110) {
         var3 = 1;
      } else if (var1 < 160) {
         var3 = 2;
      } else if (var1 < 170) {
         var3 = 3;
      } else if (var1 < 190) {
         var3 = 4;
      } else {
         var3 = 5;
      }

      return a(arrayList, GameConstants.sS[var3][0], GameConstants.sS[var3][1]);
   }

   public static ArrayList p(int i, int j) {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();

      for (int var4 = 1; var4 <= i; var4++) {
         var3.add(var4);
      }

      Collections.shuffle(var3);

      for (int var5 = 0; var5 <= j - 1; var5++) {
         var2.add((Integer)var3.get(var5));
      }

      return var2;
   }

   public void q(int i, int j) {
      MatchEngine var3 = null;
      if (this.matchEngine == null) {
         var3 = new MatchEngine(this);
         this.setMatchEngine(var3);
      } else {
         var3 = this.matchEngine;
      }

      a(this, j, i);
      MatchEvent var4 = null;
      var4 = var3.simulatePossession();
      if (var4 != null) {
         var4.setMinute(i);
         var4.setPeriod(j);
         this.getEvents().add(var4);
         if (var4.getType() == 1 && var4.getSecondaryPlayer() != null) {
            MatchEvent var5 = new MatchEvent(var4.getTeamSide());
            var5.setMinute(i);
            var5.setPrimaryPlayer(var4.getSecondaryPlayer());
            var5.setType(8);
            var5.setPeriod(j);
            this.getEvents().add(var5);
         }
      }
   }

   public void a(Competition c0713, int i, boolean bl, String string) {
      if (!bl) {
         this.p(c0713.cx(i));
         int var5 = c0713.cy(i);
         this.b(new Stadium(true, this.ik(), var5));
      } else {
         this.stadium = null;
         this.gr = null;
         this.p(string);
      }
   }

   public void V() {
      MatchEngine var1 = new MatchEngine(this);
      this.setMatchEngine(var1);
      int[] var10000 = new int[]{-1, -1};
      if (this.getCompetitionStage() instanceof KnockoutStage) {
         if (((KnockoutStage)this.getCompetitionStage()).zu()) {
            if (((KnockoutStage)this.getCompetitionStage()).zr() == 2) {
               int[] var2 = ((KnockoutStage)this.getCompetitionStage()).o(this);
               this.aU(var2[1]);
               this.aV(var2[0]);
               this.gj = true;
               this.ge = true;
            }
         } else {
            this.ge = true;
         }

         if (this.ge) {
            if (((KnockoutStage)this.getCompetitionStage()).zA()) {
               this.gf = false;
            } else {
               this.gf = true;
            }
         }
      }

      if (this.getStadium() != null) {
         this.getStadium().b(this);
      } else if (this.il() != null) {
         this.il().b(this);
      }

      if (!this.getHomeClub().isUserControlled() && !this.getAwayClub().isUserControlled()) {
         this.fQ[0] = new Random().nextInt(3);
         this.fQ[1] = new Random().nextInt(5) + 1;

         for (int var3 = 0; var3 < 45 + this.fQ[0]; var3++) {
            a(this, 1, var3);
            MatchEvent var4 = null;
            var4 = var1.simulatePossession();
            if (var4 != null) {
               var4.setMinute(var3);
               var4.setPeriod(1);
               this.getEvents().add(var4);
               if (var4.getType() == 1 && var4.getSecondaryPlayer() != null) {
                  MatchEvent var5 = new MatchEvent(var4.getTeamSide());
                  var5.setMinute(var3);
                  var5.setPrimaryPlayer(var4.getSecondaryPlayer());
                  var5.setType(8);
                  var5.setPeriod(1);
                  this.getEvents().add(var5);
               }
            }
         }

         this.evaluateScoreBasedSubstitutions(2, 0);

         for (int var6 = 0; var6 < 45 + this.fQ[1]; var6++) {
            a(this, 2, var6);
            MatchEvent var9 = null;
            var9 = var1.simulatePossession();
            if (var9 != null) {
               var9.setMinute(var6);
               var9.setPeriod(2);
               this.getEvents().add(var9);
               if (var9.getType() == 1 && var9.getSecondaryPlayer() != null) {
                  MatchEvent var12 = new MatchEvent(var9.getTeamSide());
                  var12.setMinute(var6);
                  var12.setPrimaryPlayer(var9.getSecondaryPlayer());
                  var12.setPeriod(2);
                  var12.setType(8);
                  this.getEvents().add(var12);
               }
            }
         }

         if (this.ge && this.gf && this.hk()) {
            int var7 = new Random().nextInt(7) + 2;
            int var11 = new Random().nextInt(7) + 2;
            if (var7 >= var11) {
               this.gk = this.getHomeClub();
               this.gi[0] = var7;
               this.gi[1] = var7 - 1;
            } else {
               this.gk = this.getAwayClub();
               this.gi[0] = var7;
               this.gi[1] = var7 + 1;
            }
         }
      }

      this.getHomeClub().setLineupReady(false);
      this.getAwayClub().setLineupReady(false);
   }

   public boolean hk() {
      boolean var1 = ((KnockoutStage)this.getCompetitionStage()).zv();
      int var2 = ((KnockoutStage)this.getCompetitionStage()).BI();
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      byte var9 = 0;
      int var10 = 0;
      int var11 = 0;
      var3 = this.getHomeGoals();
      var4 = this.getAwayGoals();
      var10 = var3;
      var11 = var4;
      if (var3 > var4) {
         var7++;
      } else if (var4 > var3) {
         var8++;
      }

      if (this.gj) {
         var6 = this.hK();
         var5 = this.hL();
         if (var5 > var6) {
            var7++;
         } else if (var6 > var5) {
            var8++;
         }

         var10 += var5;
         var11 += var6;
      }

      if (var7 > var8) {
         var9 = 1;
      } else if (var8 > var7) {
         var9 = 2;
      }

      if (var9 == 0) {
         if (var10 > var11) {
            var9 = 1;
         } else if (var11 > var10) {
            var9 = 2;
         }
      }

      if (var9 == 0 && this.gj && var1) {
         if (var5 > var4) {
            var9 = 1;
         } else if (var4 > var5) {
            var9 = 2;
         }
      }

      return var9 == 0 && var2 == 2129 ? false : var9 == 0;
   }

   public ArrayList getHomeStartingLineup() {
      return this.homeStartingLineup;
   }

   public ArrayList getAwayStartingLineup() {
      return this.awayStartingLineup;
   }

   public ArrayList getHomeBench() {
      return this.homeBench;
   }

   public ArrayList getAwayBench() {
      return this.awayBench;
   }

   public ArrayList getHomePlayersOnField() {
      return this.homePlayersOnField;
   }

   public ArrayList getAwayPlayersOnField() {
      return this.awayPlayersOnField;
   }

   public int hr() {
      return this.fO;
   }

   public void aP(int i) {
      this.fO = i;
   }

   public int hs() {
      return this.fP;
   }

   public void aQ(int i) {
      this.fP = i;
   }

   public CompetitionStage getCompetitionStage() {
      return this.competitionStage;
   }

   public int getHomeGoals() {
      return this.homeGoals;
   }

   public void incrementHomeGoals() {
      this.homeGoals++;
   }

   public int getAwayGoals() {
      return this.awayGoals;
   }

   public void incrementAwayGoals() {
      this.awayGoals++;
   }

   public int getRemainingSubstitutions(int i) {
      return this.remainingSubstitutions[i];
   }

   public void consumeSubstitution(int i) {
      this.remainingSubstitutions[i]--;
   }

   public Competition getCompetition() {
      return this.competition;
   }

   public int[] getPossessionPercentages() {
      return this.possessionPercentages;
   }

   public void setPossessionPercentages(int[] is) {
      this.possessionPercentages = is;
   }

   public int[] getShots() {
      return this.shots;
   }

   public void setShots(int[] is) {
      this.shots = is;
   }

   public int[] getTackles() {
      return this.tackles;
   }

   public void setTackles(int[] is) {
      this.tackles = is;
   }

   public int[] getMisplacedPasses() {
      return this.misplacedPasses;
   }

   public void setMisplacedPasses(int[] is) {
      this.misplacedPasses = is;
   }

   public int[] getFouls() {
      return this.fouls;
   }

   public void setFouls(int[] is) {
      this.fouls = is;
   }

   public ArrayList getEvents() {
      return this.events;
   }

   public Stadium getStadium() {
      return this.stadium;
   }

   public Player aT(int i) {
      if (i == 1) {
         for (int var2 = 0; var2 < this.homePlayersOnField.size(); var2++) {
            if (((Player)this.homePlayersOnField.get(var2)).getTacticalPosition() == 1) {
               return (Player)this.homePlayersOnField.get(var2);
            }
         }
      } else if (i == 2) {
         for (int var3 = 0; var3 < this.awayPlayersOnField.size(); var3++) {
            if (((Player)this.awayPlayersOnField.get(var3)).getTacticalPosition() == 1) {
               return (Player)this.awayPlayersOnField.get(var3);
            }
         }
      }

      return null;
   }

   public void recalculateScoreFromEvents() {
      this.homeGoals = 0;
      this.awayGoals = 0;

      for (int var1 = 0; var1 < this.events.size(); var1++) {
         if (((MatchEvent)this.events.get(var1)).getType() == 1) {
            if (((MatchEvent)this.events.get(var1)).getClub() == this.homeClub) {
               this.homeGoals++;
            } else if (((MatchEvent)this.events.get(var1)).getClub() == this.awayClub) {
               this.awayGoals++;
            }
         }
      }
   }

   public String hG() {
      String var1 = "";
      if (this.competition != null) {
         var1 = this.competition.is();
      }

      if (this.competitionStage != null) {
         var1 = var1 + " - " + this.competitionStage.io();
      }

      if (this.competition != null && this.competition.b() == 9 && this.competitionStage != null && this.competitionStage instanceof LeagueStage && ((LeagueStage)this.competitionStage).ze() == 7701) {
         var1 = "Torneio Repescagem";
      }

      if (this.competition != null && this.competition.b() == 1 && this.competitionStage != null && this.competitionStage instanceof KnockoutStage) {
         if (((KnockoutStage)this.competitionStage).zf() == 1099) {
            var1 = "Mata-Mata Ascenso - " + var1;
         } else if (((KnockoutStage)this.competitionStage).zf() == 1098) {
            var1 = "Playoff Rebaixamento - " + var1;
         }
      }

      return var1;
   }

   public String hH() {
      String var1 = "";
      if (this.competition != null) {
         var1 = this.competition.getNome();
      }

      String var2 = "";
      if (this.competitionStage != null) {
         var2 = " - " + this.competitionStage.io();
      }

      return var1 + var2;
   }

   public String hI() {
      String var1 = "";
      String var2 = "";
      if (this.competition != null) {
         var1 = this.competition.getNome();
      }

      if (this.competitionStage != null) {
         var2 = " - " + this.competitionStage.io();
      }

      return var1 + var2;
   }

   public String[] hJ() {
      String[] var1 = new String[]{"", ""};
      if (this.competitionStage != null) {
         var1[1] = this.competitionStage.io();
      }

      if (this.competition != null) {
         var1[0] = this.competition.is();
      }

      return var1;
   }

   public int hK() {
      return this.gg;
   }

   public void aU(int i) {
      this.gg = i;
   }

   public int hL() {
      return this.gh;
   }

   public void aV(int i) {
      this.gh = i;
   }

   public int getScheduleIndex() {
      return this.scheduleIndex;
   }

   public int hN() {
      return this.fE;
   }

   public boolean hO() {
      return this.gj;
   }

   public void s(boolean bl) {
      this.gj = bl;
   }

   public boolean hP() {
      return this.gf;
   }

   public int[] hQ() {
      return this.gi;
   }

   public Club hR() {
      return this.gk;
   }

   public boolean hS() {
      return this.ge;
   }

   public void u(Club club) {
      this.gk = club;
   }

   public void i(int[] is) {
      this.gi = is;
   }

   public void aW(int i) {
      this.fE = i;
   }

   public void j(int[] is) {
      this.fD = is;
   }

   public int[] hT() {
      return this.fD;
   }

   public int hU() {
      return this.fD[0] + this.fD[1] + this.fD[2] + this.fD[3];
   }

   public String hV() {
      return Integer.toString(this.hU())
         + " (G:"
         + Integer.toString(this.fD[0])
         + ","
         + "A:"
         + Integer.toString(this.fD[1])
         + ","
         + "Cd:"
         + Integer.toString(this.fD[2])
         + ","
         + "Cm:"
         + Integer.toString(this.fD[3])
         + ")";
   }

   public MatchEngine getMatchEngine() {
      return this.matchEngine;
   }

   public void setMatchEngine(MatchEngine c0746) {
      this.matchEngine = c0746;
   }

   public boolean hX() {
      return this.competition != null && this.competition.b() == 5 || this.competition.b() == 7;
   }

   public int[] hY() {
      return this.fX;
   }

   public int[] getShotsOnTarget() {
      return this.shotsOnTarget;
   }

   public int[] getShotsOffTarget() {
      return this.shotsOffTarget;
   }

   public boolean e() {
      return this.v;
   }

   public void a(boolean bl) {
      this.v = bl;
   }

   public int[] ib() {
      return this.fQ;
   }

   public boolean ic() {
      boolean var1 = false;
      if (this.homeClub.jY() != null && this.awayClub.jY() != null) {
         for (int var2 = 0; var2 < GameConstants.pe.length; var2++) {
            if (this.homeClub.jY().equals(GameConstants.pe[var2][0]) && this.awayClub.jY().equals(GameConstants.pe[var2][1])) {
               return true;
            }

            if (this.awayClub.jY().equals(GameConstants.pe[var2][0]) && this.homeClub.jY().equals(GameConstants.pe[var2][1])) {
               return true;
            }
         }
      }

      return var1;
   }

   public int[][] id() {
      return this.gl;
   }

   public ArrayList getHomeSubstitutesUsed() {
      return this.homeSubstitutesUsed;
   }

   public ArrayList getAwaySubstitutesUsed() {
      return this.awaySubstitutesUsed;
   }

   public String ig() {
      return this.homeGoals + " x " + this.awayGoals;
   }

   public String ih() {
      return " " + this.homeGoals + "x" + this.awayGoals + " ";
   }

   public String ii() {
      return " " + this.homeGoals + "x" + this.awayGoals + " " + "(" + this.gi[0] + "x" + this.gi[1] + ")";
   }

   public String t(boolean bl) {
      return !bl ? " " + this.homeGoals + "x" + this.awayGoals + " " : " " + this.awayGoals + "x" + this.homeGoals + " ";
   }

   public String u(boolean bl) {
      return !bl ? this.gi[0] + "x" + this.gi[1] : this.gi[1] + "x" + this.gi[0];
   }

   public String ij() {
      return this.gp;
   }

   public void o(String string) {
      this.gp = string;
   }

   public int dX() {
      return this.dq;
   }

   public void O(int i) {
      this.dq = i;
   }

   public String ik() {
      return this.gq;
   }

   public void p(String string) {
      this.gq = string;
   }

   public Stadium il() {
      return this.gr;
   }

   public void b(Stadium stadium) {
      this.gr = stadium;
   }
}
