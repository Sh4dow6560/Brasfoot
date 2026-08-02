package mod.recovered.match;

import bf22.intermediary.*;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Random;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class MatchEngine {
   private static final double[] SW = new double[]{44.55, 23.86, 7.4};
   private static final double[] SX = new double[]{30.69, 18.35, 12.99};
   private static final double[] SY = new double[]{7.8, 45.78, 53.52};
   private static final double[] SZ = new double[]{10.8, 43.78, 53.52};
   private static final double[] Ta = new double[]{13.2, 36.78, 44.52};
   private static final double[] Tb = new double[]{7.8, 37.78, 45.52};
   private static final double[] Tc = new double[]{5.8, 37.78, 45.52};
   private static final double[] Td = new double[]{2.8, 37.78, 45.52};
   private static final double[] Te = new double[]{1.8, 45.78, 53.52};
   private static final double[] Tf = new double[]{1.0, 55.78, 63.52};
   private static final double[] Tg = new double[]{55.0, 45.0};
   private static final double[] Th = new double[]{50.0, 50.0};
   private static final double Ti = 4.15;
   private static final double Tj = 3.81;
   private static final double Tk = 1.0;
   private static final double Tl = 10.0;
   private static final double Tm = 18.0;
   private Random Tn = new Random();
   private Random To = new Random();
   private C0963 Tp = new C0963();
   private static final double Tq = 3.0;
   private static final double Tr = 5.0;
   private static final double Ts = 5.0;
   private static final double Tt = 3.0;
   private static final double Tu = 24.0;
   private static final double Tv = 20.0;
   private static final double Tw = 12.0;
   public static final double[][] Tx = new double[][]{
      {-1.0, -1.0, -1.0},
      {-1.0, -1.0, -1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {8.0, 8.0, 8.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {8.0, 8.0, 8.0},
      {8.0, 8.0, 8.0},
      {8.0, 8.0, 8.0},
      {8.0, 8.0, 8.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0},
      {22.0, 22.0, 22.0}
   };
   public static final double[][] Ty = new double[][]{
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {10.0, 10.0, 10.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {2.0, 2.0, 2.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {4.0, 4.0, 4.0},
      {20.0, 20.0, 20.0},
      {20.0, 20.0, 20.0},
      {20.0, 20.0, 20.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0},
      {10.0, 10.0, 10.0}
   };
   public static final double[][] Tz = new double[][]{
      {-1.0, -1.0, -1.0},
      {1.0, 1.0, 1.0},
      {5.0, 5.0, 5.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {18.0, 18.0, 18.0},
      {5.0, 5.0, 5.0},
      {1.0, 1.0, 1.0},
      {5.0, 5.0, 5.0},
      {5.0, 5.0, 5.0},
      {5.0, 5.0, 5.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0},
      {1.0, 1.0, 1.0}
   };
   private Match match = null;
   private Club[] clubs = null;
   private int activeTeamIndex = 0;
   private int simulatedPossessions = 0;
   private boolean homeAdvantageDisabled = false;
   Player selectedAttacker = null;
   private double TF = 0.0;
   private int[] goalCounts = new int[2];
   private int[] shotCounts = new int[2];
   private int[] TH = new int[2];
   private int[] TI = new int[2];
   private int[] TJ = new int[2];
   private int[] TK = new int[2];
   private int[] TL = new int[2];
   private int[] attackingAdvances = new int[2];
   private int[] midfieldAdvances = new int[2];
   private int[] midfieldTackles = new int[2];
   private int[] defensiveTackles = new int[2];
   private int[] possessionWins = new int[2];
   private int[] TQ = new int[2];
   private int[] TR = new int[2];
   private int[] TS = new int[3];
   private int[] TT = new int[26];
   private static final double[] TU = new double[]{5.5, 35.55, 15.0};
   private static final double[] TV = new double[]{4.5, 40.55, 15.0};
   private static final double[] TW = new double[]{3.0, 40.55, 15.0};
   private static final double[] TX = new double[]{0.5, 40.55, 15.0};
   int[] TY = new int[]{1, 22, 24, 11, 13, 14, 16, 2, 9, 3, 5};

   public int selectRandomTeamIndex() {
      boolean var1 = this.Tn.nextBoolean();
      return var1 ? 0 : 1;
   }

   public MatchEngine(Match c0675) {
      this.match = c0675;
      Club[] var2 = new Club[]{c0675.getHomeClub(), c0675.getAwayClub()};
      this.clubs = var2;
      this.activeTeamIndex = this.selectRandomTeamIndex();
      this.homeAdvantageDisabled = c0675.hX();
      if (c0675.getHomePlayersOnField().size() == 0) {
         System.out.println("erro escala: " + c0675.getHomeClub().getNome());
         GamePersistence.careerState.bN = true;
         Club.a(c0675.getHomeClub(), c0675, 1, -1, true);
      }

      if (c0675.getAwayPlayersOnField().size() == 0) {
         System.out.println("erro escala: " + c0675.getAwayClub().getNome());
         GamePersistence.careerState.bN = true;
         Club.a(c0675.getAwayClub(), c0675, 1, -1, true);
      }

      for (int var3 = 0; var3 < c0675.getHomeStartingLineup().size(); var3++) {
         ((Player)c0675.getHomeStartingLineup().get(var3)).fe();
      }

      for (int var4 = 0; var4 < c0675.getAwayStartingLineup().size(); var4++) {
         ((Player)c0675.getAwayStartingLineup().get(var4)).fe();
      }

      for (int var5 = 0; var5 < c0675.getHomeBench().size(); var5++) {
         ((Player)c0675.getHomeBench().get(var5)).fe();
      }

      for (int var6 = 0; var6 < c0675.getAwayBench().size(); var6++) {
         ((Player)c0675.getAwayBench().get(var6)).fe();
      }
   }

   public MatchEngine() {
   }

   public MatchEvent simulatePossession() {
      MatchEvent var1 = null;
      this.simulatedPossessions++;
      int var2 = this.resolvePossessionWinner();
      if (var2 == this.activeTeamIndex) {
         if (this.resolveAttackOutcome() == 0) {
            this.match.getShots()[this.activeTeamIndex]++;
            var1 = this.resolveShot();
         } else if (this.To.nextInt(100) < 50) {
            this.match.getTackles()[this.getOpposingTeamIndex()]++;
         } else {
            this.match.getMisplacedPasses()[this.activeTeamIndex]++;
         }
      } else if (this.To.nextInt(100) < 50) {
         this.match.getTackles()[this.getOpposingTeamIndex()]++;
      } else {
         this.match.getMisplacedPasses()[this.activeTeamIndex]++;
      }

      this.switchActiveTeam();
      return var1;
   }

   private void switchActiveTeam() {
      if (this.activeTeamIndex == 1) {
         this.activeTeamIndex = 0;
      } else if (this.activeTeamIndex == 0) {
         this.activeTeamIndex = 1;
      }
   }

   private int getOpposingTeamIndex() {
      return this.activeTeamIndex == 1 ? 0 : 1;
   }

   private double ez(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.match.getHomePlayersOnField();
      } else {
         var2 = this.match.getAwayPlayersOnField();
      }

      int var3 = this.clubs[i].kj()[2];
      double[] var4 = new double[]{0.0, 0.04, 0.08};
      if (var3 >= var4.length) {
         var3 = 2;
      }

      double var5 = 0.0 + var4[var3];
      int var7 = 0;
      double var8 = 0.1;

      for (int var10 = 0; var10 < var2.size(); var10++) {
         if (var7 < 5 && ((Player)var2.get(var10)).fT() >= 10 && ((Player)var2.get(var10)).fT() <= 17) {
            var5 += this.B((Player)var2.get(var10));
            var7++;
         }
      }

      var8 = var5 / 5.0;
      if (var7 < 3) {
         var8 = 0.01;
      }

      return var8;
   }

   private double eA(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.match.getHomePlayersOnField();
      } else {
         var2 = this.match.getAwayPlayersOnField();
      }

      double var3 = 0.0;
      int var5 = 0;
      double var6 = 0.1;

      for (int var8 = 0; var8 < var2.size(); var8++) {
         if (var5 < 3 && ((Player)var2.get(var8)).fT() >= 19 && ((Player)var2.get(var8)).fT() <= 25) {
            var3 += this.B((Player)var2.get(var8));
            var5++;
         }
      }

      var6 = var3 / 3.0;
      if (var5 < 1) {
         var6 = 0.0;
      }

      return var6;
   }

   private double eB(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.match.getHomePlayersOnField();
      } else {
         var2 = this.match.getAwayPlayersOnField();
      }

      Player var3 = null;
      double var4 = 0.1;

      for (int var6 = 0; var6 < var2.size(); var6++) {
         if (((Player)var2.get(var6)).fT() == 1) {
            var3 = (Player)var2.get(var6);
            var4 = this.B((Player)var2.get(var6));
            break;
         }
      }

      if (var3 != null && var3.gF()) {
         var4 = (int)Math.round(var4 * 0.2);
      }

      return var4;
   }

   private double eC(int i) {
      double var2 = 0.1;
      this.selectedAttacker = this.selectAttacker();
      if (this.selectedAttacker != null) {
         var2 = this.B(this.selectedAttacker);
      }

      return var2;
   }

   private int eD(int i) {
      ArrayList var2 = null;
      int var3 = 0;
      if (i == 0) {
         var2 = this.match.getHomePlayersOnField();
      } else {
         var2 = this.match.getAwayPlayersOnField();
      }

      for (int var4 = 0; var4 < var2.size(); var4++) {
         if (((Player)var2.get(var4)).fT() >= 3 && ((Player)var2.get(var4)).fT() <= 8) {
            var3++;
         }
      }

      return var3;
   }

   private double eE(int i) {
      ArrayList var2 = null;
      if (i == 0) {
         var2 = this.match.getHomePlayersOnField();
      } else {
         var2 = this.match.getAwayPlayersOnField();
      }

      double var3 = 0.0;
      int var5 = 0;
      double var6 = 0.1;

      for (int var8 = 0; var8 < var2.size(); var8++) {
         if (var5 < 5 && ((Player)var2.get(var8)).fT() >= 2 && ((Player)var2.get(var8)).fT() <= 9) {
            var3 += this.B((Player)var2.get(var8));
            var5++;
         }
      }

      var6 = var3 / 5.0;
      if (var5 < 3) {
         var6 = 0.01;
      }

      return var6;
   }

   public double B(Player player) {
      int var2 = player.fi();
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         var2 = 0;
         if (player.fT() == 1) {
            var2 += (int)Math.round(player.gK() * 0.6);
            var2 += (int)Math.round(player.gL() * 0.15);
            var2 += (int)Math.round(player.gJ() * 0.15);
            var2 += (int)Math.round(player.gM() * 0.1);
         } else if (player.fT() >= 3 && player.fT() <= 8) {
            var2 += (int)Math.round(player.gN() * 0.5);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gM() * 0.1);
            var2 += (int)Math.round(player.gO() * 0.05);
         } else if (player.fT() == 2 || player.fT() == 9) {
            var2 += (int)Math.round(player.gN() * 0.4);
            var2 += (int)Math.round(player.gJ() * 0.1);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gM() * 0.3);
            var2 += (int)Math.round(player.gO() * 0.05);
            var2 += (int)Math.round(player.gP() * 0.05);
         } else if (player.fT() >= 11 && player.fT() <= 13) {
            var2 += (int)Math.round(player.gN() * 0.4);
            var2 += (int)Math.round(player.gJ() * 0.15);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gM() * 0.2);
            var2 += (int)Math.round(player.gO() * 0.1);
            var2 += (int)Math.round(player.gP() * 0.05);
         } else if (player.fT() >= 14 && player.fT() <= 16) {
            var2 += (int)Math.round(player.gN() * 0.05);
            var2 += (int)Math.round(player.gJ() * 0.1);
            var2 += (int)Math.round(player.gL() * 0.1);
            var2 += (int)Math.round(player.gM() * 0.25);
            var2 += (int)Math.round(player.gO() * 0.4);
            var2 += (int)Math.round(player.gP() * 0.1);
         } else if (player.fT() == 10 || player.fT() == 17) {
            var2 += (int)Math.round(player.gN() * 0.05);
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gL() * 0.15);
            var2 += (int)Math.round(player.gM() * 0.25);
            var2 += (int)Math.round(player.gO() * 0.2);
            var2 += (int)Math.round(player.gP() * 0.1);
         } else if (player.fT() >= 19 && player.fT() <= 24) {
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gL() * 0.25);
            var2 += (int)Math.round(player.gM() * 0.05);
            var2 += (int)Math.round(player.gO() * 0.05);
            var2 += (int)Math.round(player.gP() * 0.4);
         } else if (player.fT() == 18 || player.fT() == 25) {
            var2 += (int)Math.round(player.gJ() * 0.25);
            var2 += (int)Math.round(player.gL() * 0.15);
            var2 += (int)Math.round(player.gM() * 0.15);
            var2 += (int)Math.round(player.gO() * 0.05);
            var2 += (int)Math.round(player.gP() * 0.4);
         }
      }

      if (player.gF()) {
         var2 = (int)Math.round(var2 * 0.5);
      }

      if (var2 <= 0) {
         var2 = 1;
      }

      if (this.match != null && this.match.getCompetition().b() == 7) {
         if (this.match.getHomeClub() != null && player.getPais() == this.match.getHomeClub().getPais()) {
            if (this.match.getHomeClub().getReputacao() < 3) {
               var2 = (int)Math.round(var2 * 0.65);
            } else if (this.match.getHomeClub().getReputacao() == 3) {
               var2 = (int)Math.round(var2 * 0.85);
            } else if (this.match.getHomeClub().getReputacao() == 4) {
               var2 = (int)Math.round(var2 * 0.95);
            }
         } else if (this.match.getAwayClub() != null && player.getPais() == this.match.getAwayClub().getPais()) {
            if (this.match.getAwayClub().getReputacao() < 3) {
               var2 = (int)Math.round(var2 * 0.65);
            } else if (this.match.getAwayClub().getReputacao() == 3) {
               var2 = (int)Math.round(var2 * 0.85);
            } else if (this.match.getAwayClub().getReputacao() == 4) {
               var2 = (int)Math.round(var2 * 0.95);
            }
         }
      }

      if (this.match != null && this.match.getCompetition().b() == 4) {
         if (player.fg() != null && player.fg().getReputacao() < 3) {
            var2 = (int)Math.round(var2 * 0.75);
         } else if (player.fg() != null && player.fg().getReputacao() == 3) {
            var2 = (int)Math.round(var2 * 0.85);
         } else if (player.fg() != null && player.fg().getPais() == 29) {
            var2 = (int)Math.round(var2 * 0.9);
         }
      }

      if (this.match != null && this.match.getCompetition().b() == 5) {
         if (player.fg() != null && player.fg().getReputacao() < 3) {
            var2 = (int)Math.round(var2 * 0.55);
         } else if (player.fg() != null && player.fg().getReputacao() == 3) {
            var2 = (int)Math.round(var2 * 0.75);
         } else if (player.fg() != null && player.fg().gg() != 0) {
            var2 = (int)Math.round(var2 * 0.9);
         }
      }

      if (this.match != null && this.match.getCompetition().b() == 1) {
         if (player.fg() != null && player.fg().getReputacao() < 3) {
            var2 = (int)Math.round(var2 * 0.85);
         } else if (player.fg() != null && player.fg().getReputacao() == 3) {
            var2 = (int)Math.round(var2 * 0.95);
         }
      }

      if (this.match != null
         && (this.match.getCompetition().b() == 3 || this.match.getCompetition().b() == 2)
         && this.match.getHomeClub().getReputacao() < 3
         && this.match.getAwayClub().getReputacao() >= 3
         && player.fg() != null
         && player.fg().equals(this.match.getAwayClub())) {
         var2 = (int)Math.round(var2 * 0.8);
      }

      return var2 / 10.0;
   }

   private void eF(int i) {
      this.match.hY()[i]++;
      int var2 = GameConstants.A(this.match.hY()[0], this.match.hY()[0] + this.match.hY()[1]);
      int var3 = GameConstants.A(this.match.hY()[1], this.match.hY()[0] + this.match.hY()[1]);
      this.match.getPossessionPercentages()[0] = var2;
      this.match.getPossessionPercentages()[1] = var3;
   }

   public int resolvePossessionWinner() {
      double[] var1 = new double[]{0.1, 0.1};
      var1[this.activeTeamIndex] = this.ez(this.activeTeamIndex);
      var1[this.getOpposingTeamIndex()] = this.ez(this.getOpposingTeamIndex());
      double var2 = 1.0 + this.a(var1[this.activeTeamIndex], var1[this.getOpposingTeamIndex()]);
      double var4 = 1.0 + this.a(var1[this.getOpposingTeamIndex()], var1[this.activeTeamIndex]);
      if (!this.homeAdvantageDisabled && this.activeTeamIndex == 0) {
         var2 += 0.3;
      }

      int var10000 = this.clubs[this.activeTeamIndex].kj()[1];
      if (var2 < 0.2) {
         var2 = 0.2;
      }

      if (var4 < 0.2) {
         var4 = 0.2;
      }

      double[] var6 = new double[]{var2, var4};
      int var7 = -1;
      var7 = this.b(Tg, var6);
      int var8 = 0;
      if (var7 == 0) {
         this.TQ[this.getOpposingTeamIndex()]++;
         this.possessionWins[this.activeTeamIndex]++;
         var8 = this.activeTeamIndex;
         this.midfieldAdvances[this.activeTeamIndex]++;
         this.eF(this.activeTeamIndex);
      } else if (var7 == 1) {
         this.TQ[this.activeTeamIndex]++;
         this.possessionWins[this.getOpposingTeamIndex()]++;
         var8 = this.getOpposingTeamIndex();
         this.midfieldTackles[this.getOpposingTeamIndex()]++;
         this.eF(this.getOpposingTeamIndex());
      }

      return var8;
   }

   public int resolveAttackOutcome() {
      double var1 = this.eE(this.getOpposingTeamIndex());
      this.TF = var1;
      double var3 = this.eA(this.activeTeamIndex);
      double var5 = 1.0 + this.a(var3, var1);
      double var7 = 1.0 + this.a(var1, var3);
      if (var1 == 0.0) {
         var7 = 0.1;
      }

      if (!this.homeAdvantageDisabled && this.activeTeamIndex == 0) {
         var5 += 0.3;
      }

      if (var3 == 0.0) {
         var5 = 0.1;
      }

      if (var5 < 0.2) {
         var5 = 0.2;
      }

      if (var7 < 0.2) {
         var7 = 0.2;
      }

      int var9 = 0;
      if (this.clubs[0].jZ() || this.clubs[1].jZ()) {
         var9 = this.eD(this.getOpposingTeamIndex());
         if (var9 == 0) {
            var7 = 0.1;
         } else if (var9 == 1) {
            var7 = 0.05;
         }
      }

      double[] var10 = new double[]{var5, var7};
      int var11 = -1;
      var11 = this.b(Th, var10);
      if (var11 == 0) {
         this.attackingAdvances[this.activeTeamIndex]++;
      } else if (var11 == 1) {
         this.defensiveTackles[this.getOpposingTeamIndex()]++;
      }

      return var11;
   }

   public double a(double d, double e) {
      double var5 = 0.1;
      byte var7 = 8;
      if (GamePersistence.careerState.getSeasonNumber() >= 5) {
         var7 = 11;
      } else if (GamePersistence.careerState.getSeasonNumber() >= 9) {
         var7 = 12;
      }

      var5 = d - e;
      return var5 / var7;
   }

   public double b(double d, double e) {
      double var5 = 0.1;
      byte var7 = 8;
      if (GamePersistence.careerState.getSeasonNumber() >= 5) {
         var7 = 10;
      }

      var5 = d - e;
      return var5 / var7;
   }

   public double c(double d, double e) {
      double var5 = 0.1;
      var5 = d - e;
      return var5 / 12.0;
   }

   public MatchEvent resolveShot() {
      MatchEvent var1 = null;
      double var2 = this.eE(this.getOpposingTeamIndex());
      this.TF = var2;
      double var4 = this.eA(this.activeTeamIndex);
      double var6 = this.eC(this.activeTeamIndex);
      double var8 = this.eB(this.getOpposingTeamIndex());
      double var12 = 1.0 + this.b(var8, var6);
      double var10 = 1.0 + this.b(var2, var4);
      int var14 = 0;
      if (this.clubs[0].jZ() || this.clubs[1].jZ()) {
         var14 = this.eD(this.getOpposingTeamIndex());
         if (var14 == 0) {
            var12 = (int)Math.round(var12 * 0.2);
         } else if (var14 == 1) {
            var12 = (int)Math.round(var12 * 0.4);
         }
      }

      if (!this.homeAdvantageDisabled) {
         if (this.activeTeamIndex == 0) {
            var12 += 0.1;
            var10 = var12 + 0.1;
         }

         if (this.activeTeamIndex == 1) {
            var12 -= 0.1;
            var10 = var12 - 0.1;
         }
      }

      double[] var15 = TU;
      if (this.goalCounts[this.activeTeamIndex] >= 6) {
         var15 = TX;
      } else if (this.goalCounts[this.activeTeamIndex] >= 5) {
         var15 = TW;
      } else if (this.goalCounts[this.activeTeamIndex] >= 3) {
         var15 = TV;
      }

      if (this.goalCounts[this.activeTeamIndex] >= 2 && this.clubs[this.getOpposingTeamIndex()].getReputacao() - this.clubs[this.activeTeamIndex].getReputacao() >= 2) {
         var15 = TW;
      }

      if (var12 < 0.2) {
         var12 = 0.2;
      }

      if (var10 < 0.2) {
         var10 = 0.2;
      }

      double[] var16 = new double[]{1.0, var12, var10};
      int var17 = -1;
      var17 = this.a(var15, var16);
      this.shotCounts[this.activeTeamIndex]++;
      if (var17 == 0) {
         var1 = new MatchEvent(this.activeTeamIndex);
         var1.setClub(this.clubs[this.activeTeamIndex]);
         this.recordGoalEvent(var1, this.selectedAttacker);
         this.match.getShotsOnTarget()[this.activeTeamIndex]++;
      } else if (var17 == 1) {
         this.match.getShotsOnTarget()[this.activeTeamIndex]++;
         if (this.selectedAttacker != null) {
            this.selectedAttacker.gB().tL();
         }
      } else if (var17 == 2) {
         this.match.getShotsOffTarget()[this.activeTeamIndex]++;
      }

      return var1;
   }

   private int a(double[] ds, double[] es) {
      double var3 = 0.0;
      double[] var5 = new double[ds.length];

      for (int var6 = 0; var6 < ds.length; var6++) {
         var5[var6] = ds[var6] * es[var6];
         var3 += var5[var6];
      }

      double var11 = this.Tn.nextDouble() * var3;
      double var8 = 0.0;

      for (int var10 = 0; var10 < var5.length; var10++) {
         var8 += var5[var10];
         if (var11 < var8) {
            return var10;
         }
      }

      return ds.length;
   }

   private int b(double[] ds, double[] es) {
      double var3 = 0.0;
      double[] var5 = new double[ds.length];

      for (int var6 = 0; var6 < ds.length; var6++) {
         var5[var6] = ds[var6] * es[var6];
         var3 += var5[var6];
      }

      double var11 = this.Tn.nextDouble() * var3;
      double var8 = 0.0;

      for (int var10 = 0; var10 < var5.length; var10++) {
         var8 += var5[var10];
         if (var11 < var8) {
            return var10;
         }
      }

      return ds.length;
   }

   public Player selectAttacker() {
      Player var1 = null;
      ArrayList var2 = null;
      if (this.activeTeamIndex == 0) {
         var2 = this.match.getHomePlayersOnField();
      } else {
         var2 = this.match.getAwayPlayersOnField();
      }

      double var3 = 0.0;

      for (int var5 = 0; var5 < var2.size(); var5++) {
         if (((Player)var2.get(var5)).fT() != 1
            && ((Player)var2.get(var5)).getPosicao() != 0
            && ((Player)var2.get(var5)).fT() > 0
            && ((Player)var2.get(var5)).fT() < Tx.length) {
            var3 += Tx[((Player)var2.get(var5)).fT()][0];
            if (((Player)var2.get(var5)).getCr1() == 9 || ((Player)var2.get(var5)).getCr2() == 9) {
               var3 += 4.0;
            } else if (((Player)var2.get(var5)).getCr1() == 5 || ((Player)var2.get(var5)).getCr2() == 5) {
               var3 += 2.0;
               if (((Player)var2.get(var5)).getPosicao() == 2) {
                  var3 += 2.0;
               }
            }
         }
      }

      double var12 = this.Tn.nextDouble() * var3;
      double var7 = 0.0;

      for (int var9 = 0; var9 < var2.size(); var9++) {
         if (((Player)var2.get(var9)).fT() != 1
            && ((Player)var2.get(var9)).getPosicao() != 0
            && ((Player)var2.get(var9)).fT() > 0
            && ((Player)var2.get(var9)).fT() < Tx.length) {
            var7 += Tx[((Player)var2.get(var9)).fT()][0];
            if (((Player)var2.get(var9)).getCr1() == 9 || ((Player)var2.get(var9)).getCr2() == 9) {
               var7 += 4.0;
            } else if (((Player)var2.get(var9)).getCr1() == 5 || ((Player)var2.get(var9)).getCr2() == 5) {
               var7 += 2.0;
               if (((Player)var2.get(var9)).getPosicao() == 2) {
                  var7 += 2.0;
               }
            }
         }

         if (var12 <= var7) {
            var1 = (Player)var2.get(var9);
            return (Player)var2.get(var9);
         }
      }

      if (var1 == null) {
         for (int var13 = var2.size() - 1; var13 > 0; var13--) {
            if (var13 < var2.size() && var2.get(var13) != null) {
               var1 = (Player)var2.get(var13);
               break;
            }
         }
      }

      return var1;
   }

   public Player C(Player player) {
      if (new Random().nextInt(100) > 80) {
         return null;
      }

      Player var2 = null;
      ArrayList var3 = null;
      int var4 = 0;
      if (this.activeTeamIndex == 0) {
         var3 = this.match.getHomePlayersOnField();
         var4 = this.match.getHomeClub().kj()[2];
      } else {
         var3 = this.match.getAwayPlayersOnField();
         var4 = this.match.getAwayClub().kj()[2];
      }

      double var5 = 0.0;

      for (int var7 = 0; var7 < var3.size(); var7++) {
         if (var3.get(var7) != player && ((Player)var3.get(var7)).fT() > 0 && ((Player)var3.get(var7)).fT() < Ty.length) {
            var5 += Ty[((Player)var3.get(var7)).fT()][0];
            if (((Player)var3.get(var7)).getCr1() == 11 || ((Player)var3.get(var7)).getCr2() == 11) {
               var5 += 10.0;
               if (((Player)var3.get(var7)).getCr1() == 4 || ((Player)var3.get(var7)).getCr2() == 4) {
                  var5 += 5.0;
               }
            } else if (((Player)var3.get(var7)).getCr1() == 4 || ((Player)var3.get(var7)).getCr2() == 4) {
               var5 += 2.0;
               if (((Player)var3.get(var7)).getCr1() == 8) {
                  var5 += 2.0;
               }
            } else if (((Player)var3.get(var7)).getCr1() == 8 || ((Player)var3.get(var7)).getCr2() == 8) {
               var5 += 2.0;
               if (((Player)var3.get(var7)).getCr1() == 13) {
                  var5 += 2.0;
               }
            } else if (((Player)var3.get(var7)).getCr1() != 13 && ((Player)var3.get(var7)).getCr2() != 13) {
               if (((Player)var3.get(var7)).getCr1() == 6 || ((Player)var3.get(var7)).getCr2() == 6) {
                  var5 += 5.0;
                  if (((Player)var3.get(var7)).getPosicao() == 1) {
                     var5 += 2.0;
                  }
               }
            } else {
               var5++;
               if (((Player)var3.get(var7)).getPosicao() == 1) {
                  var5 += 2.0;
               }
            }

            if (var4 == 1 && ((Player)var3.get(var7)).getPosicao() == 1) {
               var5 += 20.0;
            }
         }
      }

      double var15 = this.Tn.nextDouble() * var5;
      double var9 = 0.0;

      for (int var11 = 0; var11 < var3.size(); var11++) {
         if (var3.get(var11) != player && ((Player)var3.get(var11)).fT() > 0 && ((Player)var3.get(var11)).fT() < Ty.length) {
            var9 += Ty[((Player)var3.get(var11)).fT()][0];
            if (((Player)var3.get(var11)).getCr1() == 11 || ((Player)var3.get(var11)).getCr2() == 11) {
               var9 += 10.0;
               if (((Player)var3.get(var11)).getCr1() == 4 || ((Player)var3.get(var11)).getCr2() == 4) {
                  var9 += 5.0;
               }
            } else if (((Player)var3.get(var11)).getCr1() == 4 || ((Player)var3.get(var11)).getCr2() == 4) {
               var9 += 2.0;
               if (((Player)var3.get(var11)).getCr1() == 8) {
                  var9 += 2.0;
               }
            } else if (((Player)var3.get(var11)).getCr1() == 8 || ((Player)var3.get(var11)).getCr2() == 8) {
               var9 += 2.0;
               if (((Player)var3.get(var11)).getCr1() == 13) {
                  var9 += 2.0;
               }
            } else if (((Player)var3.get(var11)).getCr1() != 13 && ((Player)var3.get(var11)).getCr2() != 13) {
               if (((Player)var3.get(var11)).getCr1() == 6 || ((Player)var3.get(var11)).getCr2() == 6) {
                  var9 += 5.0;
                  if (((Player)var3.get(var11)).getPosicao() == 1) {
                     var9 += 2.0;
                  }
               }
            } else {
               var9 += 2.0;
               if (((Player)var3.get(var11)).getPosicao() == 1) {
                  var9 += 2.0;
               }
            }

            if (var4 == 1 && ((Player)var3.get(var11)).getPosicao() == 1) {
               var9 += 20.0;
            }
         }

         if (var15 <= var9) {
            var2 = (Player)var3.get(var11);
            return (Player)var3.get(var11);
         }
      }

      return var2;
   }

   public Player selectDefender() {
      Object var1 = null;
      ArrayList var2 = null;
      if (this.activeTeamIndex == 0) {
         var2 = this.match.getAwayPlayersOnField();
      } else {
         var2 = this.match.getHomePlayersOnField();
      }

      double var3 = 0.0;

      for (int var5 = 0; var5 < var2.size(); var5++) {
         if (((Player)var2.get(var5)).fT() >= 0 && ((Player)var2.get(var5)).fT() < Tz.length) {
            var3 += Tz[((Player)var2.get(var5)).fT()][0];
         }
      }

      double var11 = this.Tn.nextDouble() * var3;
      double var7 = 0.0;

      for (int var9 = 0; var9 < var2.size(); var9++) {
         if (((Player)var2.get(var9)).fT() >= 0 && ((Player)var2.get(var9)).fT() < Tz.length) {
            var7 += Tz[((Player)var2.get(var9)).fT()][0];
         }

         if (var11 <= var7) {
            return (Player)var2.get(var9);
         }
      }

      return (Player)var1;
   }

   public int selectFallbackPosition() {
      double var1 = 0.0;

      for (int var3 = 0; var3 < this.TY.length; var3++) {
         if (this.TY[var3] != 1) {
            var1 += Tx[this.TY[var3]][0];
         }
      }

      double var8 = this.Tn.nextDouble() * var1;
      double var5 = 0.0;

      for (int var7 = 0; var7 < this.TY.length; var7++) {
         if (this.TY[var7] != 1) {
            var5 += Tx[this.TY[var7]][0];
         }

         if (var8 <= var5) {
            return this.TY[var7];
         }
      }

      return -1;
   }

   public void recordGoalEvent(MatchEvent c0667, Player player) {
      c0667.setType(1);
      c0667.setPrimaryPlayer(player);
      byte var3 = 1;
      int var4 = new Random().nextInt(1000);
      if (var4 < 900) {
         var3 = 1;
      } else if (var4 < 950) {
         var3 = 3;
      } else if (var4 < 980) {
         var3 = 4;
      } else if (var4 < 990) {
         var3 = 2;
      } else if (var4 < 995) {
         var3 = 5;
      } else {
         var3 = 1;
      }

      if (player == null) {
         ArrayList var5 = null;
         if (this.activeTeamIndex == 0) {
            var5 = this.match.getHomePlayersOnField();
         } else {
            var5 = this.match.getAwayPlayersOnField();
         }

         if (var5.size() == 0) {
            Club.a(this.clubs[this.activeTeamIndex], this.match, this.activeTeamIndex + 1, -1, true);
         }

         player = this.selectAttacker();
      }

      if (player != null && var3 != 3 && var3 != 2) {
         player.gB().z();
      }

      if (var3 != 3 && var3 != 2 && var3 != 5 && var3 != 4) {
         Player var8 = this.C(player);
         if (var8 != null && var8 != player) {
            var8.gB().gV();
            if (var8.fg() != null && !var8.fC()) {
               var8.a(8, c0667.getClub(), this.match.getCompetition());
            }

            c0667.setSecondaryPlayer(var8);
         }
      }

      if (player != null && var3 == 5) {
         ArrayList var9 = null;
         if (this.activeTeamIndex == 0) {
            var9 = this.match.getHomePlayersOnField();
         } else {
            var9 = this.match.getAwayPlayersOnField();
         }

         if (this.clubs[this.activeTeamIndex].lq() != null && var9.contains(this.clubs[this.activeTeamIndex].lq())) {
            c0667.setPrimaryPlayer(this.clubs[this.activeTeamIndex].lq());
         } else if (player.getPosicao() == 0) {
            var3 = 1;
         }
      }

      if (var3 == 2) {
         Player var11 = this.selectDefender();
         if (var11 != null) {
            c0667.setPrimaryPlayer(var11);
            var11.gB().tE();
         } else {
            var3 = 1;
            if (player != null) {
               player.gB().z();
            }
         }
      }

      if (var3 == 3 || var3 == 4) {
         ArrayList var12 = null;
         if (this.activeTeamIndex == 0) {
            var12 = this.match.getHomePlayersOnField();
         } else {
            var12 = this.match.getAwayPlayersOnField();
         }

         if (this.clubs[this.activeTeamIndex].ke() != null && var12.contains(this.clubs[this.activeTeamIndex].ke())) {
            c0667.setPrimaryPlayer(this.clubs[this.activeTeamIndex].ke());
         }
      }

      boolean var14 = false;
      if (var3 == 3) {
         c0667.setConfirmed(true);
         if (this.clubs[0].jZ() || this.clubs[1].jZ()) {
            var14 = true;
            var3 = 3;
            c0667.setConfirmed(false);
         }
      }

      if (!var14) {
         this.goalCounts[this.activeTeamIndex]++;
         if (this.activeTeamIndex == 0) {
            this.match.incrementHomeGoals();
         } else {
            this.match.incrementAwayGoals();
         }

         if (player != null) {
            player.gB().z();
         }
      }

      c0667.setSubtype(var3);
   }

   public void eG(int i) {
      this.goalCounts[i]++;
   }

   public int[] getGoalCounts() {
      return this.goalCounts;
   }

   public int[] getShotCounts() {
      return this.shotCounts;
   }

   public int[] vZ() {
      return this.TH;
   }

   public int[] wa() {
      return this.TI;
   }

   public int[] wb() {
      return this.TJ;
   }

   public int[] wc() {
      return this.TK;
   }

   public int[] wd() {
      return this.TL;
   }

   public int[] getAttackingAdvances() {
      return this.attackingAdvances;
   }

   public int[] getMidfieldAdvances() {
      return this.midfieldAdvances;
   }

   public int[] getMidfieldTackles() {
      return this.midfieldTackles;
   }

   public int[] getDefensiveTackles() {
      return this.defensiveTackles;
   }

   public int[] hY() {
      return this.possessionWins;
   }

   public int[] wi() {
      return this.TR;
   }
}
