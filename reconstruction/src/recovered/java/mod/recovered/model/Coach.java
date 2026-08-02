package mod.recovered.model;

import mod.recovered.match.Match;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.game.ScheduleDay;
import bf22.intermediary.C0708;
import mod.recovered.core.GameConstants;
import mod.recovered.competition.Competition;
import bf22.intermediary.C0728;
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
   private String dm;
   private Boolean userControlled = false;
   private int nU = -1;
   private transient Club club = null;
   private transient Club nW = null;
   private int clubId = -1;
   private int nX = -1;
   private int nY = 0;
   private int bf = -1;
   private int nZ;
   private Club hy = null;
   private int oa = 1;
   private ArrayList ob = new ArrayList();
   private int oc;
   private int W;
   private int od;
   private int oe;
   private int of = 95;
   private int og = 85;
   private int nc = 0;
   private int nu = 0;
   private ArrayList cA = new ArrayList();
   private ArrayList oh = null;
   private int oi = 0;
   private int bZ = 0;

   public Coach() {
   }

   public Coach(String string) {
      this.dm = string;
      this.nU = GamePersistence.careerState.bU();
   }

   public Boolean isUserControlled() {
      return this.userControlled;
   }

   public void k(Boolean boolean_) {
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

   public void n(Club club) {
      this.club = club;
      if (club != null) {
         this.clubId = club.getClubId();
      } else {
         this.clubId = -1;
      }
   }

   public int lE() {
      return this.nZ;
   }

   public void cg(int i) {
      this.nZ = i;
   }

   public Club lF() {
      Club var1 = this.nW;
      if (var1 == null && this.nX >= 0) {
         var1 = GamePersistence.careerState.x(this.nX);
         this.nW = var1;
         return var1;
      } else {
         return this.nX == -1 ? null : var1;
      }
   }

   public void B(Club club) {
      this.nW = club;
      if (club != null) {
         this.nX = club.getClubId();
      } else {
         this.nX = -1;
      }
   }

   public int lG() {
      return this.nY;
   }

   public void ch(int i) {
      this.nY = i;
   }

   public int lH() {
      return this.oa;
   }

   public void ci(int i) {
      this.oa = i;
   }

   public C0728 C(Club club) {
      for (int var2 = 0; var2 < this.ob.size(); var2++) {
         try {
            if (((C0728)this.ob.get(var2)).ct() == club.getClubId() && ((C0728)this.ob.get(var2)).H() == GamePersistence.careerState.getSeasonNumber()) {
               return (C0728)this.ob.get(var2);
            }
         } catch (Exception var4) {
         }
      }

      C0728 var5 = new C0728(club);
      this.ob.add(var5);
      return var5;
   }

   public void cj(int i) {
      this.of += i;
      if (this.of > 100) {
         this.of = 100;
      } else if (this.of < 0) {
         this.of = 0;
      }
   }

   public void ck(int i) {
      this.og += i;
      if (this.og > 100) {
         this.og = 100;
      } else if (this.og < 0) {
         this.og = 0;
      }
   }

   public void a(Match c0675, boolean bl, int i) {
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
            this.cj(-1);
            this.ck(-1);
         } else if (var12 < 0) {
            this.cj(1);
         }
      } else if (var11 != 1) {
         if (var12 >= 0 && !var8) {
            this.cj(-3);
            this.ck(-3);
         } else if (var12 >= 0 && var8) {
            this.cj(-1);
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
               this.cj(-10);
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
                  this.cj(-5);
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
                  this.cj(-5);
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
               this.cj(-5);
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
            this.cj(var21[var16]);
         } else {
            this.cj(var18[var16]);
         }
      } else if (var11 == 1) {
         if (var8) {
            this.cj(var20[var16]);
         } else {
            this.cj(var17[var16]);
         }
      } else if (var11 == 2) {
         if (var8) {
            this.cj(var22[var16]);
         } else {
            this.cj(var19[var16]);
         }
      }

      if (var11 == 0) {
         if (var8) {
            this.ck(1);
         } else {
            this.ck(-1);
         }
      } else if (var11 == 1) {
         if (var8) {
            this.ck(4);
         } else {
            this.ck(3);
         }

         if (var9) {
            if (this.isUserControlled() && c0675.ic() && !bl) {
               new C0799(this, 27, 81, "", "");
            }

            if (var8) {
               this.ck(5);
            } else {
               this.ck(4);
            }
         }
      } else if (var11 == 2) {
         if (var8) {
            this.ck(-4);
         } else {
            this.ck(-5);
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
               this.ck(-5);
            } else {
               this.ck(-7);
            }
         }
      }

      if (this.og < 20) {
         this.cj(-3);
      }

      if (this.of < 0) {
         this.of = 0;
      } else if (this.of > 100) {
         this.of = 100;
      }

      if (this.og < 0) {
         this.og = 0;
      } else if (this.og > 100) {
         this.og = 100;
      }
   }

   public void D(Club club) {
      C0728 var2 = this.C(club);
      var2.cs();
      this.bZ++;
   }

   public void e(Match c0675) {
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
      } else if (c0675.getHomeClub() == this.hy) {
         var2 = c0675.getHomeGoals();
         var3 = c0675.getAwayGoals();
         var5 = this.hy;
      } else if (c0675.getAwayClub() == this.hy) {
         var2 = c0675.getAwayGoals();
         var3 = c0675.getHomeGoals();
         var5 = this.hy;
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
      C0728 var10 = this.C(var5);
      var10.cl();
      this.W++;
      if (var2 > var3) {
         var10.cn();
         this.od++;
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
            var10.B(var9);
         }
      } else if (var2 < var3) {
         var10.cp();
         this.oe++;
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
            var10.B(var9);
         }
      }

      if (var9 > 0) {
         this.oc += var9;
      }
   }

   public int lI() {
      return this.oc;
   }

   public int A() {
      return this.W;
   }

   public int lJ() {
      return this.od;
   }

   public int lK() {
      return this.oe;
   }

   public int lL() {
      return this.of;
   }

   public void cl(int i) {
      this.of = i;
   }

   public int lM() {
      return this.og;
   }

   public void cm(int i) {
      this.og = i;
   }

   public int getReputacao() {
      return this.nc;
   }

   public void setReputacao(int i) {
      this.nc = i;
   }

   public void g(LeagueStage c0955) {
   }

   public int bz() {
      return this.bf;
   }

   public void v(int i) {
      this.bf = i;
   }

   public void lN() {
      this.B(this.getClub());
      this.bf = this.getClub().getPais();
      this.nY = this.getClub().getDivisao() - 1;
   }

   public void b(Club club, Player player) {
      if (club != null) {
         this.v(club.getPais());
      }

      this.cg(player.getPais());
      if (club != null) {
         this.ch(club.getDivisao() - 1);
      }

      if (club != null) {
         this.setReputacao(club.getReputacao());
      }

      this.ci(GamePersistence.careerState.getSeasonNumber());
   }

   public void i(Coach coach) {
      CoachChangeRecord var2 = new CoachChangeRecord();
      var2.c(this);
      var2.d(coach);
      Calendar var3 = ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(GamePersistence.careerState.getCurrentScheduleIndex())).a();
      var2.a().set(var3.get(1), var3.get(2), var3.get(5));
      if (this.getClub() != null) {
         var2.C(this.getClub().getClubId());
      }

      GamePersistence.careerState.bn().add(var2);
      this.lN();
      if (this.isUserControlled()) {
         if (this.getClub().getPais() == 29) {
            GamePersistence.careerState.u(this.getClub().getEstado());
         }

         GamePersistence.careerState.v(this.getClub().getPais());
         this.getClub().k(false);
         this.getClub().resetFinances();
         this.getClub().M(true);
         GamePersistence.careerState.aN().remove(this.getClub());
         this.T(null);
      }

      if (this.getClub() != null && this.getClub().getFinances() != null) {
         this.getClub().getFinances().setOutstandingLoanPrincipal(0);
      }

      this.getClub().h(null);
      this.n(null);
   }

   public void E(Club club) {
      club.h(this);
      this.n(club);
      this.of = 95;
      this.og = 85;
      this.oi = 0;
      club.resetFinances();
      if (this.isUserControlled()) {
         club.k(true);
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

   public String dS() {
      return this.dm;
   }

   public ArrayList lO() {
      return this.ob;
   }

   public void b(Competition c0713, int i, int j) {
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
         this.oc = this.oc + var6[i];
      }

      if (i == 1) {
         if (GameConstants.fs(var4)) {
            this.D(this.hy);
         } else {
            this.D(this.getClub());
         }

         this.q(c0713);
      }
   }

   public void fh() {
      if (this.club != null) {
         this.clubId = this.club.getClubId();
      }
   }

   private void q(Competition c0713) {
      int var2 = c0713.b();
      int var3 = -1;
      C0708 var4 = new C0708();
      var4.k(GamePersistence.careerState.getSeasonNumber());
      if (var2 == 7) {
         if (this.jo() != null) {
            var4.C(this.jo().getClubId());
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
            this.ck(20);
            this.cj(15);
            if (var2 == 1) {
               this.ck(20);
               this.cj(15);
            }
         } else {
            this.ck(20);
            this.cj(10);
         }
      } else if (c0713.b() == 11) {
         if (this.getClub() != null) {
            var4.R(this.getClub().getPais());
         }

         this.ck(10);
      } else {
         var4.R(c0713.gg());
         if (var2 == 2) {
            this.ck(30);
            this.cj(30);
         } else if (var2 == 4) {
            this.ck(30);
            this.cj(30);
         } else if (var2 == 5) {
            this.ck(30);
            this.cj(30);
         } else if (var2 == 6 || var2 == 12) {
            this.ck(30);
            this.cj(30);
         }
      }

      this.cA.add(var4);
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

   public ArrayList cT() {
      return this.cA;
   }

   public Club jo() {
      return this.hy;
   }

   public void z(Club club) {
      this.hy = club;
   }

   public void lP() {
      GamePersistence.careerState.bu().add(this);
      GamePersistence.careerState.M().remove(this);
      GamePersistence.careerState.L().remove(this);
   }

   public static void c(String string, int i) {
      Coach var2 = new Coach(string);
      var2.cg(i);
      var2.setReputacao(3);
      if (!GamePersistence.careerState.bD()) {
         var2.k(true);
      }

      CountryCompetitions var3 = GamePersistence.careerState.o(i);
      if (var3 == null) {
         var3 = (CountryCompetitions)GamePersistence.careerState.N().get(0);
      }

      var2.v(var3.jc());
      var2.ch(var3.eb().size() - 1);
      GamePersistence.careerState.a(var2);
      if (!GamePersistence.careerState.bD()) {
         GamePersistence.careerState.M().add(var2);
      }
   }

   public void i(String string) {
      this.dm = string;
   }

   public ArrayList lQ() {
      return this.oh;
   }

   public void T(ArrayList arrayList) {
      this.oh = arrayList;
   }

   public int lR() {
      return this.oi;
   }

   public void cn(int i) {
      this.oi = i;
   }

   public void lS() {
      this.oi++;
   }

   public int lT() {
      return this.nU;
   }

   public int cr() {
      return this.bZ;
   }

   public void a(int i, int j, int k, boolean bl, int l) {
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

      this.nu += var7;
   }

   public void kk() {
      byte var1 = 0;
      if (this.nc == 5) {
         this.nu -= 6000;
         if (this.nu < -20000) {
            this.nc = 4;
            this.nu = 0;
         }
      } else if (this.nc == 4) {
         this.nu -= 600;
         if (this.nu < -3000) {
            this.nc = 3;
            this.nu = 0;
         }
      } else if (this.nc == 3 && this.Av()) {
         this.nu -= 50;
         if (this.nu < -500) {
            this.nc = 2;
            this.nu = 0;
         }
      } else if (this.nc == 2 && this.Av()) {
         this.nu -= 5;
         if (this.nu < -50) {
            this.nc = 1;
            this.nu = 0;
         }
      }

      if (this.nu > 22000) {
         var1 = 5;
      } else if (this.nu > 10000) {
         var1 = 4;
      } else if (this.nu > 1000) {
         var1 = 3;
      } else if (this.nu > 100) {
         var1 = 2;
      } else if (this.nu > 10) {
         var1 = 1;
      }

      if (var1 > this.nc) {
         this.nc = var1;
      }
   }

   public boolean Av() {
      return this.getClub() != null ? this.getClub().kn() : false;
   }
}
