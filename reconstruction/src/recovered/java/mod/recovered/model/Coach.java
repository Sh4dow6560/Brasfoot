package mod.recovered.model;

import mod.recovered.match.Match;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.game.ScheduleDay;
import bf22.intermediary.C0708;
import mod.recovered.core.GameConstants;
import mod.recovered.competition.Competition;
import mod.recovered.manager.CoachSeasonRecord;
import mod.recovered.manager.CoachChangeRecord;
import mod.recovered.save.GamePersistence;
import bf22.intermediary.C0799;
import mod.recovered.competition.LeagueStage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Coach implements Serializable {
   private static final long serialVersionUID = 1L;
   private String name;
   private Boolean userControlled = false;
   private int coachId = -1;
   private transient Club club = null;
   private transient Club previousClub = null;
   private int clubId = -1;
   private int previousClubId = -1;
   private int lastManagedDivisionIndex = 0;
   private int lastManagedCountryId = -1;
   private int nationalityId;
   private Club nationalTeam = null;
   private int careerStartSeason = 1;
   private ArrayList seasonRecords = new ArrayList();
   private int careerScore;
   private int matchCount;
   private int winCount;
   private int lossCount;
   private int boardApproval = 95;
   private int fanApproval = 85;
   private int reputation = 0;
   private int reputationProgress = 0;
   private ArrayList competitionAchievements = new ArrayList();
   private ArrayList inbox = null;
   private int clubTenure = 0;
   private int titleCount = 0;

   public Coach() {
   }

   public Coach(String string) {
      this.name = string;
      this.coachId = GamePersistence.careerState.bU();
   }

   public Boolean isUserControlled() {
      return this.userControlled;
   }

   public void setUserControlled(Boolean boolean_) {
      this.userControlled = boolean_;
   }

   public Club getClub() {
      Club var1 = this.club;
      if (var1 == null && this.clubId >= 0) {
         var1 = GamePersistence.careerState.x(this.clubId);
         this.club = var1;
         return var1;
      } else {
         return this.clubId == -1 ? null : var1;
      }
   }

   public void setClub(Club club) {
      this.club = club;
      if (club != null) {
         this.clubId = club.getClubId();
      } else {
         this.clubId = -1;
      }
   }

   public int getNationalityId() {
      return this.nationalityId;
   }

   public void setNationalityId(int i) {
      this.nationalityId = i;
   }

   public Club getPreviousClub() {
      Club var1 = this.previousClub;
      if (var1 == null && this.previousClubId >= 0) {
         var1 = GamePersistence.careerState.x(this.previousClubId);
         this.previousClub = var1;
         return var1;
      } else {
         return this.previousClubId == -1 ? null : var1;
      }
   }

   public void setPreviousClub(Club club) {
      this.previousClub = club;
      if (club != null) {
         this.previousClubId = club.getClubId();
      } else {
         this.previousClubId = -1;
      }
   }

   public int getLastManagedDivisionIndex() {
      return this.lastManagedDivisionIndex;
   }

   public void setLastManagedDivisionIndex(int i) {
      this.lastManagedDivisionIndex = i;
   }

   public int getCareerStartSeason() {
      return this.careerStartSeason;
   }

   public void setCareerStartSeason(int i) {
      this.careerStartSeason = i;
   }

   public CoachSeasonRecord getOrCreateSeasonRecord(Club club) {
      for (int var2 = 0; var2 < this.seasonRecords.size(); var2++) {
         try {
            if (((CoachSeasonRecord)this.seasonRecords.get(var2)).getClubId() == club.getClubId()
               && ((CoachSeasonRecord)this.seasonRecords.get(var2)).getSeasonNumber() == GamePersistence.careerState.getSeasonNumber()) {
               return (CoachSeasonRecord)this.seasonRecords.get(var2);
            }
         } catch (Exception var4) {
         }
      }

      CoachSeasonRecord var5 = new CoachSeasonRecord(club);
      this.seasonRecords.add(var5);
      return var5;
   }

   public void adjustBoardApproval(int i) {
      this.boardApproval += i;
      if (this.boardApproval > 100) {
         this.boardApproval = 100;
      } else if (this.boardApproval < 0) {
         this.boardApproval = 0;
      }
   }

   public void adjustFanApproval(int i) {
      this.fanApproval += i;
      if (this.fanApproval > 100) {
         this.fanApproval = 100;
      } else if (this.fanApproval < 0) {
         this.fanApproval = 0;
      }
   }

   public void updateApprovalFromMatch(Match c0675, boolean bl, int i) {
      int var4 = 0;
      int var5 = 0;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      int var11 = 0;
      int var12 = 0;
      int[] var13 = new int[3];
      int var14 = 0;
      if (c0675.getCompetition() != null) {
         var14 = c0675.getCompetition().b();
      }

      if (c0675.getHomeClub() == this.getClub()) {
         var4 = c0675.getHomeGoals();
         var5 = c0675.getAwayGoals();
         if (c0675.getHomeClub().A(c0675.getAwayClub())) {
            var10 = true;
         }

         var12 = c0675.getHomeClub().getNivel() - c0675.getAwayClub().getNivel();
         if (!bl) {
            var13 = c0675.getHomeClub().p(c0675.getCompetition());
         }
      } else if (c0675.getAwayClub() == this.getClub()) {
         var4 = c0675.getAwayGoals();
         var5 = c0675.getHomeGoals();
         var8 = true;
         if (c0675.getAwayClub().A(c0675.getHomeClub())) {
            var10 = true;
         }

         var12 = c0675.getAwayClub().getNivel() - c0675.getHomeClub().getNivel();
         if (!bl) {
            var13 = c0675.getAwayClub().p(c0675.getCompetition());
         }
      }

      if (bl) {
         var13[2] = -1;
      }

      if (var4 != var5) {
         if (var4 > var5) {
            var11 = 1;
            if (var4 - var5 >= 3) {
               var9 = true;
            }
         } else if (var4 < var5) {
            var11 = 2;
            if (var5 - var4 >= 3) {
               var9 = true;
            }
         }
      } else {
         var11 = 0;
      }

      if (var11 == 0) {
         if (var12 >= 0 && !var8) {
            this.adjustBoardApproval(-1);
            this.adjustFanApproval(-1);
         } else if (var12 < 0) {
            this.adjustBoardApproval(1);
         }
      } else if (var11 != 1) {
         if (var12 >= 0 && !var8) {
            this.adjustBoardApproval(-3);
            this.adjustFanApproval(-3);
         } else if (var12 >= 0 && var8) {
            this.adjustBoardApproval(-1);
         }
      }

      boolean var15 = false;
      int var16 = 2;
      if (var14 == 1 || var14 == 3) {
         var16 = var13[1];
      }

      if (var13[2] == -1 || bl) {
         var15 = true;
      }

      int[] var17 = new int[6];
      int[] var18 = new int[6];
      int[] var19 = new int[6];
      int[] var20 = new int[6];
      int[] var21 = new int[6];
      int[] var22 = new int[6];
      if (var15 & !c0675.hS()) {
         var15 = false;
         var16 = 1;
      } else if (i >= 1) {
         var11 = i;
         var15 = false;
         var16 = 1;
      }

      if (!var15) {
         if (var14 == 1) {
            if (this.isUserControlled() && this.getClub() != null && this.getClub().getCashBalance() < 0L) {
               this.adjustBoardApproval(-10);
            }

            int[] var23 = new int[]{0, 5, 4, 1, 1, 0};
            int[] var24 = new int[]{0, 6, 5, 2, 2, 1};
            int[] var25 = new int[]{0, 2, 1, -1, -1, -3};
            int[] var26 = new int[]{0, 2, 1, 0, -1, -2};
            int[] var27 = new int[]{0, -2, -2, -3, -5, -7};
            int[] var28 = new int[]{0, -1, -1, -2, -4, -5};
            var17 = var23;
            var18 = var25;
            var19 = var27;
            var20 = var24;
            var21 = var26;
            var22 = var28;
         } else if (var14 != 3 && var14 != 10) {
            if (var14 != 4 && var14 != 6) {
               if (this.isUserControlled() && this.getClub() != null && this.getClub().getCashBalance() < 0L) {
                  this.adjustBoardApproval(-5);
               }

               int[] var33 = new int[]{0, 5, 4, 1, 1, 0};
               int[] var36 = new int[]{0, 6, 5, 2, 2, 1};
               int[] var39 = new int[]{0, 2, 1, -1, -1, -3};
               int[] var42 = new int[]{0, 2, 1, 0, -1, -2};
               int[] var45 = new int[]{0, -2, -2, -3, -5, -7};
               int[] var48 = new int[]{0, -1, -1, -2, -4, -5};
               var17 = var33;
               var18 = var39;
               var19 = var45;
               var20 = var36;
               var21 = var42;
               var22 = var48;
            } else {
               if (this.isUserControlled() && this.getClub() != null && this.getClub().getCashBalance() < 0L) {
                  this.adjustBoardApproval(-5);
               }

               int[] var32 = new int[]{0, 5, 4, 3, 3, 3};
               int[] var35 = new int[]{0, 7, 6, 4, 4, 5};
               int[] var38 = new int[]{0, 2, 1, 0, -1, -3};
               int[] var41 = new int[]{0, 2, 1, 0, 0, -2};
               int[] var44 = new int[]{0, -2, -2, -3, -3, -5};
               int[] var47 = new int[]{0, -1, -1, -2, -2, -3};
               var17 = var32;
               var18 = var38;
               var19 = var44;
               var20 = var35;
               var21 = var41;
               var22 = var47;
            }
         } else {
            if (this.isUserControlled() && this.getClub() != null && this.getClub().getCashBalance() < 0L) {
               this.adjustBoardApproval(-5);
            }

            int[] var31 = new int[]{0, 2, 2, 1, 1, 1};
            int[] var34 = new int[]{0, 3, 2, 2, 2, 1};
            int[] var37 = new int[]{0, 1, 1, 0, 0, -1};
            int[] var40 = new int[]{0, 1, 1, 1, 0, -1};
            int[] var43 = new int[]{0, -2, -2, -3, -3, -5};
            int[] var46 = new int[]{0, -1, -1, -2, -2, -3};
            var17 = var31;
            var18 = var37;
            var19 = var43;
            var20 = var34;
            var21 = var40;
            var22 = var46;
         }
      }

      if (var11 == 0) {
         if (var8) {
            this.adjustBoardApproval(var21[var16]);
         } else {
            this.adjustBoardApproval(var18[var16]);
         }
      } else if (var11 == 1) {
         if (var8) {
            this.adjustBoardApproval(var20[var16]);
         } else {
            this.adjustBoardApproval(var17[var16]);
         }
      } else if (var11 == 2) {
         if (var8) {
            this.adjustBoardApproval(var22[var16]);
         } else {
            this.adjustBoardApproval(var19[var16]);
         }
      }

      if (var11 == 0) {
         if (var8) {
            this.adjustFanApproval(1);
         } else {
            this.adjustFanApproval(-1);
         }
      } else if (var11 == 1) {
         if (var8) {
            this.adjustFanApproval(4);
         } else {
            this.adjustFanApproval(3);
         }

         if (var9) {
            if (this.isUserControlled() && c0675.ic() && !bl) {
               new C0799(this, 27, 81, "", "");
            }

            if (var8) {
               this.adjustFanApproval(5);
            } else {
               this.adjustFanApproval(4);
            }
         }
      } else if (var11 == 2) {
         if (var8) {
            this.adjustFanApproval(-4);
         } else {
            this.adjustFanApproval(-5);
         }

         if (var9) {
            if (c0675.ic()) {
               if (this.isUserControlled() && !bl) {
                  new C0799(this, 6, 46, "", "");
               }
            } else if (!var8 && this.isUserControlled() && !bl) {
               new C0799(this, 5, 47 + new Random().nextInt(2), "", "");
            }

            if (var8) {
               this.adjustFanApproval(-5);
            } else {
               this.adjustFanApproval(-7);
            }
         }
      }

      if (this.fanApproval < 20) {
         this.adjustBoardApproval(-3);
      }

      if (this.boardApproval < 0) {
         this.boardApproval = 0;
      } else if (this.boardApproval > 100) {
         this.boardApproval = 100;
      }

      if (this.fanApproval < 0) {
         this.fanApproval = 0;
      } else if (this.fanApproval > 100) {
         this.fanApproval = 100;
      }
   }

   public void recordTitleWon(Club club) {
      CoachSeasonRecord var2 = this.getOrCreateSeasonRecord(club);
      var2.incrementTitleCount();
      this.titleCount++;
   }

   public void recordMatchResult(Match c0675) {
      int var2 = 0;
      int var3 = 0;
      boolean var4 = false;
      Club var5 = null;
      if (c0675.getHomeClub() == this.getClub()) {
         var2 = c0675.getHomeGoals();
         var3 = c0675.getAwayGoals();
         var5 = this.getClub();
      } else if (c0675.getAwayClub() == this.getClub()) {
         var2 = c0675.getAwayGoals();
         var3 = c0675.getHomeGoals();
         var4 = true;
         var5 = this.getClub();
      } else if (c0675.getHomeClub() == this.nationalTeam) {
         var2 = c0675.getHomeGoals();
         var3 = c0675.getAwayGoals();
         var5 = this.nationalTeam;
      } else if (c0675.getAwayClub() == this.nationalTeam) {
         var2 = c0675.getAwayGoals();
         var3 = c0675.getHomeGoals();
         var5 = this.nationalTeam;
         var4 = true;
      }

      int var6 = 0;
      int var7 = 0;
      boolean var8 = false;
      if (c0675.getCompetition() != null) {
         var6 = c0675.getCompetition().b();
         if (var6 == 1 || var6 == 3) {
            var7 = c0675.getCompetition().ip();
         }
      }

      int var9 = 0;
      CoachSeasonRecord var10 = this.getOrCreateSeasonRecord(var5);
      var10.incrementMatchCount();
      this.matchCount++;
      if (var2 > var3) {
         var10.incrementWinCount();
         this.winCount++;
         if (var6 == 1) {
            if (var7 == 1) {
               var9 = 4;
            } else if (var7 == 2) {
               var9 = 3;
            } else if (var7 == 3) {
               var9 = 2;
            } else {
               var9 = 1;
            }
         } else if (var6 == 2) {
            var9 = 4;
         } else if (var6 == 3) {
            if (var8) {
               var9 = 2;
            } else {
               var9 = 1;
            }
         } else if (var6 == 4) {
            var9 = 5;
         } else if (var6 == 5) {
            var9 = 7;
         } else if (var6 == 6) {
            var9 = 4;
         } else if (var6 == 7) {
            var9 = 8;
         } else if (var6 == 8) {
            var9 = 4;
         } else if (var6 == 10) {
            var9 = 2;
         } else if (var6 == 11) {
            var9 = 2;
         } else if (var6 == 12) {
            var9 = 3;
         } else if (var6 == 9) {
            var9 = 2;
         } else if (var6 == 13) {
            var9 = 5;
         } else if (var6 == 14) {
            var9 = 6;
         }

         if (var4 && var6 != 7 && var6 != 5) {
            var9++;
         }

         if (var9 > 0) {
            var10.addCareerScore(var9);
         }
      } else if (var2 < var3) {
         var10.incrementLossCount();
         this.lossCount++;
      } else if (var2 == var3) {
         if (var4 && var6 != 7 && var6 != 5) {
            var9++;
         }

         if (var6 == 1) {
            if (var7 == 1) {
               var9 = 2;
            } else if (var7 == 2) {
               var9 = 1;
            }
         } else if (var6 == 2) {
            var9 = 1;
         } else if (var6 == 4) {
            var9 = 2;
         } else if (var6 == 5) {
            var9 = 2;
         } else if (var6 == 6) {
            var9 = 2;
         } else if (var6 == 7) {
            var9 = 2;
         } else if (var6 == 8) {
            var9 = 2;
         } else if (var6 == 11) {
            var9 = 2;
         } else if (var6 == 8) {
            var9 = 4;
         } else if (var6 == 10) {
            var9 = 1;
         } else if (var6 == 11) {
            var9 = 1;
         } else if (var6 == 12) {
            var9 = 1;
         } else if (var6 == 9) {
            var9 = 1;
         } else if (var6 == 13) {
            var9 = 2;
         } else if (var6 == 14) {
            var9 = 2;
         }

         if (var9 > 0) {
            var10.addCareerScore(var9);
         }
      }

      if (var9 > 0) {
         this.careerScore += var9;
      }
   }

   public int getCareerScore() {
      return this.careerScore;
   }

   public int getMatchCount() {
      return this.matchCount;
   }

   public int getWinCount() {
      return this.winCount;
   }

   public int getLossCount() {
      return this.lossCount;
   }

   public int getBoardApproval() {
      return this.boardApproval;
   }

   public void setBoardApproval(int i) {
      this.boardApproval = i;
   }

   public int getFanApproval() {
      return this.fanApproval;
   }

   public void setFanApproval(int i) {
      this.fanApproval = i;
   }

   public int getReputation() {
      return this.reputation;
   }

   public void setReputation(int i) {
      this.reputation = i;
   }

   public void g(LeagueStage c0955) {
   }

   public int getLastManagedCountryId() {
      return this.lastManagedCountryId;
   }

   public void setLastManagedCountryId(int i) {
      this.lastManagedCountryId = i;
   }

   public void rememberPreviousClubContext() {
      this.setPreviousClub(this.getClub());
      this.lastManagedCountryId = this.getClub().getPais();
      this.lastManagedDivisionIndex = this.getClub().getDivisao() - 1;
   }

   public void initializeCareerFromPlayer(Club club, Player player) {
      if (club != null) {
         this.setLastManagedCountryId(club.getPais());
      }

      this.setNationalityId(player.getPais());
      if (club != null) {
         this.setLastManagedDivisionIndex(club.getDivisao() - 1);
      }

      if (club != null) {
         this.setReputation(club.getReputation());
      }

      this.setCareerStartSeason(GamePersistence.careerState.getSeasonNumber());
   }

   public void leaveClubForReplacement(Coach coach) {
      CoachChangeRecord var2 = new CoachChangeRecord();
      var2.setOutgoingCoach(this);
      var2.setIncomingCoach(coach);
      Calendar var3 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a();
      var2.getDate().set(var3.get(1), var3.get(2), var3.get(5));
      if (this.getClub() != null) {
         var2.setClubId(this.getClub().getClubId());
      }

      GamePersistence.careerState.bn().add(var2);
      this.rememberPreviousClubContext();
      if (this.isUserControlled()) {
         if (this.getClub().getPais() == 29) {
            GamePersistence.careerState.u(this.getClub().getEstado());
         }

         GamePersistence.careerState.v(this.getClub().getPais());
         this.getClub().setUserControlled(false);
         this.getClub().resetFinances();
         this.getClub().M(true);
         GamePersistence.careerState.aN().remove(this.getClub());
         this.setInbox(null);
      }

      if (this.getClub() != null && this.getClub().getFinances() != null) {
         this.getClub().getFinances().setOutstandingLoanPrincipal(0);
      }

      this.getClub().h(null);
      this.setClub(null);
   }

   public void joinClub(Club club) {
      club.h(this);
      this.setClub(club);
      this.boardApproval = 95;
      this.fanApproval = 85;
      this.clubTenure = 0;
      club.resetFinances();
      if (this.isUserControlled()) {
         club.setUserControlled(true);
         GamePersistence.careerState.aN().add(club);
         club.ks();
         new C0799(this, 0, 74, club.getNome(), "");
         if (club.getStadium() != null) {
            club.getStadium().i(club);
         }

         for (int var2 = 0; var2 < club.getSeniorPlayers().size(); var2++) {
            ((Player)club.getSeniorPlayers().get(var2)).renewContract(180L, true);
         }
      }
   }

   public String getName() {
      return this.name;
   }

   public ArrayList getSeasonRecords() {
      return this.seasonRecords;
   }

   public void recordCompetitionResult(Competition c0713, int i, int j) {
      int var4 = c0713.b();
      int[][] var5 = new int[][]{
         new int[11],
         {0, 25, 10, 8, 7, 6, 5, 4, 3, 2, 1},
         {0, 20, 7, 3, 3, 0, 0, 0, 0, 0, 0},
         {0, 15, 3, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 30, 15, 7, 7, 0, 0, 0, 0, 0, 0},
         {0, 25, 5, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 20, 10, 5, 5, 0, 0, 0, 0, 0, 0},
         {0, 35, 20, 10, 5, 0, 0, 0, 0, 0, 0},
         {0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         new int[11],
         {0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 18, 8, 4, 4, 0, 0, 0, 0, 0, 0},
         {0, 20, 10, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 25, 15, 7, 3, 0, 0, 0, 0, 0, 0},
         new int[11]
      };
      int[] var6 = var5[var4];
      if (var4 == 1 && c0713.ip() > 1) {
         if (c0713.ip() == 2) {
            int[] var7 = new int[]{0, 5, 3, 2, 1, 0, 0, 0, 0, 0, 0};
            var6 = var7;
         } else {
            int[] var8 = new int[]{0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
            var6 = var8;
         }
      }

      if (var4 == 3 && c0713.ip() > 1) {
         int[] var9 = new int[11];
         var6 = var9;
      }

      if (var4 == 7 && c0713.gg() != 7) {
         int[] var10 = new int[]{0, 25, 15, 5, 3, 0, 0, 0, 0, 0, 0};
         var6 = var10;
      }

      if (var4 <= 14 && i >= 0 && i < var6.length) {
         this.careerScore = this.careerScore + var6[i];
      }

      if (i == 1) {
         if (GameConstants.fs(var4)) {
            this.recordTitleWon(this.nationalTeam);
         } else {
            this.recordTitleWon(this.getClub());
         }

         this.recordCompetitionTitle(c0713);
      }
   }

   public void syncClubId() {
      if (this.club != null) {
         this.clubId = this.club.getClubId();
      }
   }

   private void recordCompetitionTitle(Competition c0713) {
      int var2 = c0713.b();
      int var3 = -1;
      C0708 var4 = new C0708();
      var4.k(GamePersistence.careerState.getSeasonNumber());
      if (var2 == 7) {
         if (this.getNationalTeam() != null) {
            var4.C(this.getNationalTeam().getClubId());
         }
      } else if (this.getClub() != null) {
         var4.C(this.getClub().getClubId());
      }

      var4.a(c0713.b());
      var4.m(c0713);
      if (c0713.b() == 1 || c0713.b() == 3) {
         var3 = c0713.ip();
         var4.R(var3);
         if (var3 == 1) {
            this.adjustFanApproval(20);
            this.adjustBoardApproval(15);
            if (var2 == 1) {
               this.adjustFanApproval(20);
               this.adjustBoardApproval(15);
            }
         } else {
            this.adjustFanApproval(20);
            this.adjustBoardApproval(10);
         }
      } else if (c0713.b() == 11) {
         if (this.getClub() != null) {
            var4.R(this.getClub().getPais());
         }

         this.adjustFanApproval(10);
      } else {
         var4.R(c0713.gg());
         if (var2 == 2) {
            this.adjustFanApproval(30);
            this.adjustBoardApproval(30);
         } else if (var2 == 4) {
            this.adjustFanApproval(30);
            this.adjustBoardApproval(30);
         } else if (var2 == 5) {
            this.adjustFanApproval(30);
            this.adjustBoardApproval(30);
         } else if (var2 == 6 || var2 == 12) {
            this.adjustFanApproval(30);
            this.adjustBoardApproval(30);
         }
      }

      this.competitionAchievements.add(var4);
      if (this.isUserControlled() && this.getClub() != null) {
         String var5 = "";
         if (var2 == 4) {
            if (this.getClub().gg() == 0) {
               var5 = " da Liga dos Campeões";
            } else if (this.getClub().gg() == 1) {
               var5 = " da Libertadores";
            } else if (this.getClub().gg() == 2) {
               var5 = " da Liga dos Campeões da África";
            } else if (this.getClub().gg() == 3) {
               var5 = " da Liga dos Campeões da Ásia";
            } else if (this.getClub().gg() == 4) {
               var5 = " da Liga dos Campeões da Concacaf";
            } else if (this.getClub().gg() == 5) {
               var5 = " da Liga dos Campeões da Oceania";
            }

            new C0799(this, 25, 76, "", var5);
         } else if (var2 == 1 || var2 == 2 || var2 == 6) {
            new C0799(this, 24, 77, "", "");
         } else if (var2 == 5) {
            new C0799(this, 25, 78, "", "");
         }
      }
   }

   public ArrayList getCompetitionAchievements() {
      return this.competitionAchievements;
   }

   public Club getNationalTeam() {
      return this.nationalTeam;
   }

   public void setNationalTeam(Club club) {
      this.nationalTeam = club;
   }

   public void retire() {
      GamePersistence.careerState.bu().add(this);
      GamePersistence.careerState.M().remove(this);
      GamePersistence.careerState.L().remove(this);
   }

   public static void createUserCoach(String string, int i) {
      Coach var2 = new Coach(string);
      var2.setNationalityId(i);
      var2.setReputation(3);
      if (!GamePersistence.careerState.bD()) {
         var2.setUserControlled(true);
      }

      CountryCompetitions var3 = GamePersistence.careerState.o(i);
      if (var3 == null) {
         var3 = (CountryCompetitions)GamePersistence.careerState.N().get(0);
      }

      var2.setLastManagedCountryId(var3.jc());
      var2.setLastManagedDivisionIndex(var3.eb().size() - 1);
      GamePersistence.careerState.a(var2);
      if (!GamePersistence.careerState.bD()) {
         GamePersistence.careerState.M().add(var2);
      }
   }

   public void setName(String string) {
      this.name = string;
   }

   public ArrayList getInbox() {
      return this.inbox;
   }

   public void setInbox(ArrayList arrayList) {
      this.inbox = arrayList;
   }

   public int getClubTenure() {
      return this.clubTenure;
   }

   public void setClubTenure(int i) {
      this.clubTenure = i;
   }

   public void incrementClubTenure() {
      this.clubTenure++;
   }

   public int getCoachId() {
      return this.coachId;
   }

   public int getTitleCount() {
      return this.titleCount;
   }

   public void addReputationProgress(int i, int j, int k, boolean bl, int l) {
      int[][] var6 = new int[][]{
         {0, 600, 500, 30, 6000, 10000, 2000, 0, 500, 0, 50, 100, 3000, 3000, 20000}, {0, 150, 150, 5, 1000, 1000, 500, 2000, 0, 0, 0, 0, 300, 500, 0}
      };
      int var7 = 0;
      if (i < var6.length && j < var6[0].length) {
         var7 = var6[i][j];
      }

      if (var7 > 1000 & !bl && l > 1) {
         var7 = (int)Math.round(var7 * 0.6);
      }

      if (j == 1 && k > 1) {
         var7 = 50;
      }

      if (j == 7) {
         if (k == 7 && i == 0) {
            var7 = 23000;
         } else {
            var7 = 6000;
         }
      }

      this.reputationProgress += var7;
   }

   public void updateReputation() {
      byte var1 = 0;
      if (this.reputation == 5) {
         this.reputationProgress -= 6000;
         if (this.reputationProgress < -20000) {
            this.reputation = 4;
            this.reputationProgress = 0;
         }
      } else if (this.reputation == 4) {
         this.reputationProgress -= 600;
         if (this.reputationProgress < -3000) {
            this.reputation = 3;
            this.reputationProgress = 0;
         }
      } else if (this.reputation == 3 && this.managesLoadedClub()) {
         this.reputationProgress -= 50;
         if (this.reputationProgress < -500) {
            this.reputation = 2;
            this.reputationProgress = 0;
         }
      } else if (this.reputation == 2 && this.managesLoadedClub()) {
         this.reputationProgress -= 5;
         if (this.reputationProgress < -50) {
            this.reputation = 1;
            this.reputationProgress = 0;
         }
      }

      if (this.reputationProgress > 22000) {
         var1 = 5;
      } else if (this.reputationProgress > 10000) {
         var1 = 4;
      } else if (this.reputationProgress > 1000) {
         var1 = 3;
      } else if (this.reputationProgress > 100) {
         var1 = 2;
      } else if (this.reputationProgress > 10) {
         var1 = 1;
      }

      if (var1 > this.reputation) {
         this.reputation = var1;
      }
   }

   public boolean managesLoadedClub() {
      return this.getClub() != null ? this.getClub().kn() : false;
   }
}
