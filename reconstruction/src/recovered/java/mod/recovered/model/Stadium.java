package mod.recovered.model;

import mod.recovered.match.Match;
import mod.recovered.core.GameConstants;
import mod.recovered.competition.KnockoutStage;
import java.io.Serializable;
import java.util.Random;

public class Stadium implements Serializable {
   private static final long serialVersionUID = 1L;
   private String name;
   private int[] sectorCapacities = new int[4];
   private int[] ticketPrices = new int[]{20, 35, 55, 80};
   private boolean useSuggestedTicketPrices = true;
   private int pitchCondition = 0;
   private int countryId = -1;

   public Stadium() {
   }

   public Stadium(String string, int i, Club club) {
      this.name = string;
      this.N(i);
      this.ticketPrices = a(1, club);
      this.h(club);
      this.countryId = club.getPais();
   }

   public Stadium(boolean bl, String string, int i) {
      this.name = string;
      this.N(i);
      this.ticketPrices = GameConstants.qK[1][1];
   }

   private void h(Club club) {
      if (club != null) {
         Random var2 = new Random();
         if (club.getReputation() >= 4) {
            if (var2.nextInt(100) >= 95) {
               this.pitchCondition = 1;
            }
         } else if (club.getReputation() == 3) {
            int var3 = var2.nextInt(100);
            if (var3 >= 50) {
               this.pitchCondition = 1;
            } else if (var3 <= 5) {
               this.pitchCondition = 2;
            }
         } else if (club.getReputation() == 2) {
            int var4 = var2.nextInt(100);
            if (var4 >= 50) {
               this.pitchCondition = 1;
            } else if (var4 <= 15) {
               this.pitchCondition = 2;
            } else if (var4 == 0) {
               this.pitchCondition = 3;
            }
         } else {
            int var5 = var2.nextInt(100);
            if (var5 >= 90) {
               this.pitchCondition = 0;
            } else if (var5 >= 50) {
               this.pitchCondition = 1;
            } else if (var5 >= 25) {
               this.pitchCondition = 2;
            } else {
               this.pitchCondition = 3;
            }
         }
      }
   }

   public void i(Club club) {
      Random var2 = new Random();
      if (club.getReputation() >= 4) {
         if (var2.nextInt(100) >= 70) {
            this.pitchCondition = 1;
         } else {
            this.pitchCondition = 0;
         }
      } else if (var2.nextInt(100) >= 70) {
         this.pitchCondition = 1;
      } else {
         this.pitchCondition = 0;
      }
   }

   private void N(int i) {
      if (i < 1000 || i > 120000) {
         i = 10000;
      }

      double[] var2 = new double[]{0.15, 0.75, 0.09, 0.009};
      this.sectorCapacities[0] = (int)Math.round(i * var2[0]);
      this.sectorCapacities[2] = (int)Math.round(i * var2[2]);
      this.sectorCapacities[3] = (int)Math.round(i * var2[3]);
      this.sectorCapacities[1] = i - (this.sectorCapacities[0] + this.sectorCapacities[2] + this.sectorCapacities[3]);
   }

   public void b(Match c0675) {
      boolean var2 = false;
      int[] var3 = new int[4];
      int var4 = 0;
      int var5 = c0675.getCompetition().b();
      int var6 = c0675.getCompetition().el();
      int[] var7 = a(c0675.getCompetition().b(), c0675.getHomeClub());
      int[] var8 = new int[4];
      int[] var9 = new int[4];

      for (int var10 = 0; var10 < var9.length; var10++) {
         var9[var10] = this.sectorCapacities[var10];
      }

      int[][] var27 = new int[][]{
         {200, 500, 50, 0}, {1000, 5000, 1200, 20}, {2000, 10000, 1500, 50}, {4000, 20000, 2500, 300}, {4500, 30000, 3500, 400}, {5000, 40000, 5500, 500}
      };
      int var11 = c0675.getHomeClub().getDivisao();
      int var12 = c0675.getHomeClub().getReputation();

      for (int var13 = 0; var13 < var8.length; var13++) {
         var8[var13] = var27[var12][var13];
      }

      if (var5 == 3 || var5 == 10) {
         for (int var28 = 0; var28 < var8.length; var28++) {
            var8[var28] = (int)Math.round(var8[var28] * 0.7);
         }
      }

      if (var5 == 0) {
         for (int var29 = 0; var29 < var8.length; var29++) {
            var8[var29] = (int)Math.round(var8[var29] * 0.4);
         }
      }

      double var30 = 0.3;
      if (c0675.getCompetitionStage() instanceof KnockoutStage) {
         var30 += 0.15;
      }

      if (var5 == 4) {
         var30 += 0.3;
      } else if (var5 == 7 || var5 == 9) {
         var30 += 0.3;
      } else if (var5 == 6 || var5 == 8 || var5 == 11) {
         var30 += 0.15;
      }

      for (int var15 = 0; var15 < var8.length; var15++) {
         var8[var15] += (int)Math.round(this.sectorCapacities[var15] * var30);
      }

      double var31 = 0.0;
      int var17 = c0675.getAwayClub().getReputation() - c0675.getHomeClub().getReputation();
      double[] var18 = new double[]{0.0, 0.05, 0.1, 0.15, 0.2, 0.25};
      var31 += var18[Math.abs(var17)];
      if (var17 > 0) {
         for (int var19 = 0; var19 < var8.length; var19++) {
            var8[var19] += (int)Math.round(var8[var19] * var31);
         }
      } else if (var17 < 0) {
         for (int var33 = 0; var33 < var8.length; var33++) {
            var8[var33] -= (int)Math.round(var8[var33] * var31);
         }
      }

      int var34 = 80;
      if (c0675.getHomeClub().getCoach() != null) {
         var34 = c0675.getHomeClub().getCoach().getFanApproval();
      }

      double var20 = var34 / 100.0;

      for (int var22 = 0; var22 < var8.length; var22++) {
         var8[var22] = (int)Math.round(var8[var22] * var20);
      }

      int[][] var35 = new int[][]{{10, 20, 5, 0}, {100, 500, 200, 10}, {300, 1000, 400, 20}, {400, 1200, 500, 30}, {500, 1500, 1000, 50}};

      for (int var23 = 0; var23 < var8.length; var23++) {
         int var24 = var35[var11][var23];
         if (var24 > 0) {
            var8[var23] += new Random().nextInt(var24);
         }
      }

      int[] var36 = new int[4];
      if (this.usesSuggestedTicketPrices()) {
         var3 = a(c0675.getCompetition().b(), c0675.getHomeClub());
      } else {
         var3 = this.getTicketPrices();

         for (int var37 = 0; var37 < var3.length; var37++) {
            var36[var37] = var7[var37] - var3[var37];
            if (var36[var37] != 0) {
               int var25 = (int)(Math.round(0.03 * var8[var37]) * var36[var37]);
               var8[var37] += var25;
            }
         }
      }

      for (int var38 = 0; var38 < var8.length; var38++) {
         if (var8[var38] < 0) {
            var8[var38] = 0;
         }

         if (var8[var38] > this.sectorCapacities[var38]) {
            var8[var38] = this.sectorCapacities[var38];
         }

         var4 += var8[var38] * var3[var38];
      }

      if (var5 == 7) {
         if (var6 != 7) {
            var4 *= 3;
         } else {
            var4 *= 5;
         }
      } else if (var5 == 9) {
         var4 *= 2;
      }

      c0675.j(var8);
      c0675.aW(var4);
   }

   public static void c(Match c0675) {
      c0675.getStadium().b(c0675);
   }

   public static int[] a(int i, Club club) {
      int[] var2 = new int[]{10, 25, 35, 50};
      if (i == 10) {
         i = 2;
      }

      int var3 = club.gg();
      int var4 = club.getDivisao();
      int var5 = club.getReputation();
      if (var3 > 1) {
         var3 = 1;
      }

      if (i == 1) {
         var2 = GameConstants.qK[i][var4];
      } else if (i == 2 || i == 3) {
         var2 = GameConstants.qK[i][var5];
      } else if (i == 4 || i == 6 || i == 8) {
         var2 = GameConstants.qK[i][var3];
      } else if (i == 5 || i == 7) {
         var2 = GameConstants.qK[1][var4];
      }

      return var2;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String string) {
      this.name = string;
   }

   public int[] getSectorCapacities() {
      return this.sectorCapacities;
   }

   public void setSectorCapacities(int[] is) {
      this.sectorCapacities = is;
   }

   public int[] getTicketPrices() {
      return this.ticketPrices;
   }

   public void setTicketPrices(int[] is) {
      this.ticketPrices = is;
   }

   public boolean usesSuggestedTicketPrices() {
      return this.useSuggestedTicketPrices;
   }

   public void setUseSuggestedTicketPrices(boolean bl) {
      this.useSuggestedTicketPrices = bl;
   }

   public int getCapacity() {
      return this.sectorCapacities[0] + this.sectorCapacities[1] + this.sectorCapacities[2] + this.sectorCapacities[3];
   }

   public void addSectorCapacity(int i, int j) {
      this.sectorCapacities[i] = this.sectorCapacities[i] + j;
   }

   public int getPitchCondition() {
      return this.pitchCondition;
   }

   public void setPitchCondition(int i) {
      this.pitchCondition = i;
   }

   public int getPais() {
      return this.countryId;
   }
}
