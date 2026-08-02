package mod.recovered.transfer;

import bf22.intermediary.*;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class TransferNegotiation {
   private Player player = null;
   private int requestedFee = 0;
   private boolean cj = false;
   private Club sourceClub = null;
   private Club destinationClub = null;
   private int agreedFee = 0;
   private ArrayList cn = new ArrayList();
   private ArrayList co = new ArrayList();
   private ArrayList cp = new ArrayList();
   private int sourceRegionCode = -1;
   private boolean cr = false;
   private int transferMode = 0;
   private static Club sellerClub = null;
   private static int requestedSalary = 0;
   private static int counterOfferFee = 0;
   private static boolean transferCompleted = false;
   private int maxDestinationSquadSize = 32;

   public TransferNegotiation(Player player, int i, boolean bl, boolean bl2, int j) {
      this.transferMode = j;
      if (bl) {
         this.maxDestinationSquadSize = 35;
      }

      this.player = player;
      this.requestedFee = i;
      this.cj = bl;
      this.sourceClub = player.getClub();
      int var6 = player.getClub().getPais();
      if (this.sourceClub != null) {
         this.sourceRegionCode = this.sourceClub.gg();
      }

      if (j == 0) {
         if (this.sourceClub != null && this.sourceClub.kn()) {
            this.cn.add(GamePersistence.careerState.o(var6));
         }

         boolean var7 = false;
         if (this.sourceClub.getPais() == 29 && this.player.getOverallStrength() > 50 && new Random().nextInt(100) > 10) {
            var7 = true;
         }

         if (this.player.isStarPlayer() || this.player.isWorldClassPlayer()) {
            var7 = true;
         }

         if (this.sourceRegionCode == 0 || var7) {
            for (int var8 = 0; var8 < GamePersistence.careerState.N().size(); var8++) {
               if (((CountryCompetitions)GamePersistence.careerState.N().get(var8)).gg() == 0 && !this.cn.contains(GamePersistence.careerState.N().get(var8))) {
                  this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var8));
               }
            }
         }

         for (int var11 = 0; var11 < GamePersistence.careerState.N().size(); var11++) {
            if (((CountryCompetitions)GamePersistence.careerState.N().get(var11)).gg() == 0 && !this.cn.contains(GamePersistence.careerState.N().get(var11))) {
               this.co.add((CountryCompetitions)GamePersistence.careerState.N().get(var11));
            }
         }

         for (int var12 = 0; var12 < GamePersistence.careerState.N().size(); var12++) {
            if (((CountryCompetitions)GamePersistence.careerState.N().get(var12)).gg() == 0) {
               this.cp.add((CountryCompetitions)GamePersistence.careerState.N().get(var12));
            }
         }
      } else if (j == 1) {
         if (this.sourceClub != null && this.sourceClub.kn()) {
            this.cn.add(GamePersistence.careerState.o(var6));
         }

         boolean var9 = false;
         if (this.sourceClub.getPais() == 29 && this.player.getOverallStrength() > 50 && new Random().nextInt(100) > 10) {
            var9 = true;
         }

         if (this.player.isStarPlayer() || this.player.isWorldClassPlayer()) {
            var9 = true;
         }

         if (this.sourceRegionCode == 0 || var9) {
            for (int var13 = 0; var13 < GamePersistence.careerState.N().size(); var13++) {
               if (((CountryCompetitions)GamePersistence.careerState.N().get(var13)).gg() == 0 && !this.cn.contains(GamePersistence.careerState.N().get(var13))) {
                  this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var13));
               }
            }
         }

         if (this.sourceRegionCode == 1) {
            for (int var14 = 0; var14 < GamePersistence.careerState.N().size(); var14++) {
               if (((CountryCompetitions)GamePersistence.careerState.N().get(var14)).gg() != 5 && !this.cn.contains(GamePersistence.careerState.N().get(var14))) {
                  this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var14));
               }
            }
         }

         if (this.sourceRegionCode == 2) {
            for (int var15 = 0; var15 < GamePersistence.careerState.N().size(); var15++) {
               if ((((CountryCompetitions)GamePersistence.careerState.N().get(var15)).gg() == 0 || ((CountryCompetitions)GamePersistence.careerState.N().get(var15)).gg() == 3) && !this.cn.contains(GamePersistence.careerState.N().get(var15))) {
                  this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var15));
               }
            }
         }

         if (this.sourceRegionCode == 3) {
            for (int var16 = 0; var16 < GamePersistence.careerState.N().size(); var16++) {
               if ((((CountryCompetitions)GamePersistence.careerState.N().get(var16)).gg() == 3 || ((CountryCompetitions)GamePersistence.careerState.N().get(var16)).gg() == 0) && !this.cn.contains(GamePersistence.careerState.N().get(var16))) {
                  this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var16));
               }
            }
         }

         if (this.sourceClub.getPais() != 131 && this.sourceClub.getPais() != 68) {
            if (this.sourceRegionCode == 4) {
               for (int var18 = 0; var18 < GamePersistence.careerState.N().size(); var18++) {
                  if (((CountryCompetitions)GamePersistence.careerState.N().get(var18)).gg() == 4 && !this.cn.contains(GamePersistence.careerState.N().get(var18))) {
                     this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var18));
                  }
               }
            }
         } else {
            for (int var17 = 0; var17 < GamePersistence.careerState.N().size(); var17++) {
               if (((CountryCompetitions)GamePersistence.careerState.N().get(var17)).gg() == 0 && !this.cn.contains(GamePersistence.careerState.N().get(var17))) {
                  this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var17));
               }
            }
         }

         if (this.sourceRegionCode == 5) {
            for (int var19 = 0; var19 < GamePersistence.careerState.N().size(); var19++) {
               if ((((CountryCompetitions)GamePersistence.careerState.N().get(var19)).gg() == 5 || ((CountryCompetitions)GamePersistence.careerState.N().get(var19)).gg() == 3) && !this.cn.contains(GamePersistence.careerState.N().get(var19))) {
                  this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var19));
               }
            }
         }

         for (int var20 = 0; var20 < GamePersistence.careerState.N().size(); var20++) {
            if (((CountryCompetitions)GamePersistence.careerState.N().get(var20)).gg() == 0 && !this.cn.contains(GamePersistence.careerState.N().get(var20))) {
               this.co.add((CountryCompetitions)GamePersistence.careerState.N().get(var20));
            }
         }

         for (int var21 = 0; var21 < GamePersistence.careerState.N().size(); var21++) {
            if (((CountryCompetitions)GamePersistence.careerState.N().get(var21)).gg() == 0) {
               this.cp.add((CountryCompetitions)GamePersistence.careerState.N().get(var21));
            }
         }
      } else if (j == 2) {
         for (int var10 = 0; var10 < GamePersistence.careerState.N().size(); var10++) {
            if (((CountryCompetitions)GamePersistence.careerState.N().get(var10)).gg() == 0 && !this.cn.contains(GamePersistence.careerState.N().get(var10))) {
               this.cn.add((CountryCompetitions)GamePersistence.careerState.N().get(var10));
            }
         }
      }
   }

   public Club findDestination(boolean bl, boolean bl2) {
      Club var3 = null;
      boolean var4 = true;
      if (this.player.getOverallStrength() > 30 && this.sourceClub.isUserControlled() && new Random().nextInt(100) > 60) {
         var4 = false;
      }

      if (this.player.isStarPlayer() && this.sourceClub.isUserControlled()) {
         var4 = false;
      }

      if (this.player.isWorldClassPlayer()) {
         var4 = false;
      }

      if (var4) {
         if (this.cn != null) {
            var3 = this.findDestinationInCompetitions(this.cn, bl);
         }

         if (this.destinationClub == null && this.sourceClub.getReputacao() > 2) {
            var3 = this.findDestinationInCompetitions(this.co, bl);
         }
      } else {
         if (this.destinationClub == null && this.player.isWorldClassPlayer()) {
            var3 = this.findEliteDestination();
         }

         if (this.destinationClub == null && this.player.isWorldClassPlayer()) {
            var3 = this.findDestinationInCompetitions(this.cp, bl);
         }

         if (this.destinationClub == null && this.player.isStarPlayer()) {
            var3 = this.findDestinationInCompetitions(this.cp, bl);
         }

         if (this.destinationClub == null && this.sourceClub.getReputacao() > 2) {
            var3 = this.findDestinationInCompetitions(this.co, bl);
         }

         if (this.destinationClub == null && this.cn != null) {
            var3 = this.findDestinationInCompetitions(this.cn, bl);
         }
      }

      if (this.destinationClub == null) {
         var3 = this.findAnyDestinationCandidate();
      }

      if (this.destinationClub == null && GamePersistence.careerState.getSeasonNumber() > 2 && this.cj && this.requestedFee < this.player.getMarketValue()) {
         var3 = this.findExpandedDestination();
      }

      return var3;
   }

   public Club findAnyDestination(boolean bl) {
      Object var2 = null;
      return this.findAnyDestinationCandidate();
   }

   private Club findAnyDestinationCandidate() {
      Club var1 = null;
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < GamePersistence.careerState.P().size(); var3++) {
         if (!((Club)GamePersistence.careerState.P().get(var3)).kn()
            && GamePersistence.careerState.P().get(var3) != this.player.getClub()
            && !((Club)GamePersistence.careerState.P().get(var3)).isUserControlled()
            && ((Club)GamePersistence.careerState.P().get(var3)).getSeniorPlayers().size() < this.maxDestinationSquadSize
            && ((Club)GamePersistence.careerState.P().get(var3)).getClubId() != this.player.fA()) {
            var2.add((Club)GamePersistence.careerState.P().get(var3));
         }
      }

      Collections.shuffle(var2);
      boolean var7 = true;
      if (this.sourceClub.isUserControlled()) {
         var7 = false;
      }

      boolean var4 = true;
      boolean var5 = false;
      if ((this.player.gg() == 1 || this.player.gg() == 4) && new Random().nextInt(100) > 15) {
         var5 = true;
      }

      if (this.transferMode == 2) {
         for (int var6 = 0; var6 < var2.size(); var6++) {
            if (!((Club)var2.get(var6)).lh() && ((Club)var2.get(var6)).gg() == 0 && ((Club)var2.get(var6)).getReputacao() >= 4) {
               var1 = (Club)var2.get(var6);
               this.selectDestination((Club)var2.get(var6), this.requestedFee);
               break;
            }
         }
      }

      if (var1 == null && this.transferMode != 2 && var5) {
         for (int var8 = 0; var8 < var2.size(); var8++) {
            if (((Club)var2.get(var8)).getPais() == this.player.getPais() && ((Club)var2.get(var8)).a(this.player, var7)) {
               var1 = (Club)var2.get(var8);
               this.selectDestination((Club)var2.get(var8), this.requestedFee);
               break;
            }
         }
      }

      if (var1 == null && this.transferMode != 2 && var4) {
         for (int var10 = 0; var10 < var2.size(); var10++) {
            if (((Club)var2.get(var10)).gg() == this.sourceClub.gg() && ((Club)var2.get(var10)).a(this.player, var7)) {
               var1 = (Club)var2.get(var10);
               this.selectDestination((Club)var2.get(var10), this.requestedFee);
               break;
            }
         }
      } else if (var1 == null && this.transferMode != 2) {
         for (int var9 = 0; var9 < var2.size(); var9++) {
            if (((Club)var2.get(var9)).a(this.player, var7)) {
               var1 = (Club)var2.get(var9);
               this.selectDestination((Club)var2.get(var9), this.requestedFee);
               break;
            }
         }
      }

      return var1;
   }

   private Club findEliteDestination() {
      Club var1 = null;
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < GamePersistence.careerState.P().size(); var3++) {
         if (((Club)GamePersistence.careerState.P().get(var3)).getReputacao() >= 4
            && GamePersistence.careerState.P().get(var3) != this.player.getClub()
            && !((Club)GamePersistence.careerState.P().get(var3)).isUserControlled()
            && ((Club)GamePersistence.careerState.P().get(var3)).getSeniorPlayers().size() < this.maxDestinationSquadSize
            && ((Club)GamePersistence.careerState.P().get(var3)).getClubId() != this.player.fA()) {
            var2.add((Club)GamePersistence.careerState.P().get(var3));
         }
      }

      Collections.shuffle(var2);
      boolean var5 = true;
      if (this.sourceClub.isUserControlled()) {
         var5 = false;
      }

      if (var1 == null) {
         for (int var4 = 0; var4 < var2.size(); var4++) {
            if (((Club)var2.get(var4)).gg() == 0 && ((Club)var2.get(var4)).a(this.player, var5)) {
               var1 = (Club)var2.get(var4);
               this.selectDestination((Club)var2.get(var4), this.requestedFee);
               break;
            }
         }
      }

      return var1;
   }

   private Club findExpandedDestination() {
      Club var1 = null;
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < GamePersistence.careerState.P().size(); var3++) {
         if (GamePersistence.careerState.P().get(var3) != this.player.getClub()
            && !((Club)GamePersistence.careerState.P().get(var3)).isUserControlled()
            && ((Club)GamePersistence.careerState.P().get(var3)).getSeniorPlayers().size() < 35
            && ((Club)GamePersistence.careerState.P().get(var3)).getClubId() != this.player.fA()) {
            var2.add((Club)GamePersistence.careerState.P().get(var3));
         }
      }

      Collections.shuffle(var2);
      boolean var7 = true;
      if (this.sourceClub.isUserControlled()) {
         var7 = false;
      }

      boolean var4 = true;
      boolean var5 = false;
      if ((this.player.gg() == 1 || this.player.gg() == 4) && new Random().nextInt(100) > 15) {
         var5 = true;
      }

      if (var1 == null && this.transferMode != 2 && var5) {
         for (int var6 = 0; var6 < var2.size(); var6++) {
            if (((Club)var2.get(var6)).getPais() == this.player.getPais() && ((Club)var2.get(var6)).a(this.player, false)) {
               var1 = (Club)var2.get(var6);
               this.selectDestination((Club)var2.get(var6), this.requestedFee);
               break;
            }
         }
      }

      if (var1 == null && this.transferMode != 2 && var4) {
         for (int var10 = 0; var10 < var2.size(); var10++) {
            if (((Club)var2.get(var10)).gg() == this.sourceClub.gg() && ((Club)var2.get(var10)).a(this.player, false)) {
               var1 = (Club)var2.get(var10);
               this.selectDestination((Club)var2.get(var10), this.requestedFee);
               break;
            }
         }
      } else if (var1 == null && this.transferMode != 2) {
         for (int var9 = 0; var9 < var2.size(); var9++) {
            if (((Club)var2.get(var9)).a(this.player, false)) {
               var1 = (Club)var2.get(var9);
               this.selectDestination((Club)var2.get(var9), this.requestedFee);
               break;
            }
         }
      }

      if (var1 == null) {
         for (int var11 = 0; var11 < var2.size(); var11++) {
            if (((Club)var2.get(var11)).a(this.player, false)) {
               var1 = (Club)var2.get(var11);
               this.selectDestination((Club)var2.get(var11), this.requestedFee);
               break;
            }
         }

         if (var1 == null && var2.size() > 0) {
            var1 = (Club)var2.get(0);
            this.selectDestination((Club)var2.get(0), this.requestedFee);
         }
      }

      return var1;
   }

   private Club findDestinationInCompetitions(ArrayList arrayList, boolean bl) {
      ArrayList var3 = new ArrayList();
      int var4 = this.sourceClub.getDivisao() - 1;
      int var5 = this.sourceClub.getDivisao() + 1;
      int[] var10000 = new int[]{4, 5, 5, 10, 6, 5};
      if (this.sourceClub.getDivisao() == 1) {
         var4 = 1;
      }

      if (this.transferMode == 1) {
         var4 = 1;
         var5 = 2;
         if (this.sourceClub.gg() == 0 && this.sourceClub.getReputacao() >= 4 && this.player.getOverallStrength() >= 40) {
            var5 = 1;
         }
      }

      for (int var7 = 0; var7 < arrayList.size(); var7++) {
         if (this.player.getOverallStrength() <= 5) {
            var4 = 0;
            var5 = ((CountryCompetitions)arrayList.get(var7)).js();
         } else if (this.player.getOverallStrength() <= 20) {
            var5 = ((CountryCompetitions)arrayList.get(var7)).js();
         }

         if (this.player.getOverallStrength() <= 20) {
            var4 = 0;
         }

         if (this.transferMode == 0) {
            for (int var8 = 0; var8 < ((CountryCompetitions)arrayList.get(var7)).jg().size(); var8++) {
               if (((CountryCompetitions)arrayList.get(var7)).jg().get(var8) != this.player.getClub()
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var8)).getDivisao() <= var5
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var8)).getClubId() != this.player.fA()
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var8)).getDivisao() >= var4
                  && ((CountryCompetitions)arrayList.get(var7)).jg().get(var8) != this.sourceClub
                  && !((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var8)).isUserControlled()
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var8)).getSeniorPlayers().size() < this.maxDestinationSquadSize) {
                  int[] var9 = ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var8)).J(true);
                  var3.add((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var8));
               }
            }
         } else {
            for (int var11 = 0; var11 < ((CountryCompetitions)arrayList.get(var7)).jg().size(); var11++) {
               if (((CountryCompetitions)arrayList.get(var7)).jg().get(var11) != this.player.getClub()
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var11)).getDivisao() <= var5
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var11)).getClubId() != this.player.fA()
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var11)).getDivisao() >= var4
                  && ((CountryCompetitions)arrayList.get(var7)).jg().get(var11) != this.sourceClub
                  && !((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var11)).isUserControlled()
                  && ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var11)).getSeniorPlayers().size() < this.maxDestinationSquadSize) {
                  int[] var13 = ((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var11)).J(true);
                  var3.add((Club)((CountryCompetitions)arrayList.get(var7)).jg().get(var11));
               }
            }
         }
      }

      Collections.shuffle(var3);
      Club var10 = null;
      boolean var12 = true;
      if (this.sourceClub.isUserControlled()) {
         var12 = false;
      }

      if (this.transferMode == 1) {
         for (int var14 = 0; var14 < var3.size(); var14++) {
            if (((Club)var3.get(var14)).b(this.player, var12)) {
               var10 = (Club)var3.get(var14);
               break;
            }
         }
      } else if (this.transferMode == 2) {
         for (int var15 = 0; var15 < var3.size(); var15++) {
            if (!((Club)var3.get(var15)).lh() && ((Club)var3.get(var15)).getReputacao() >= 4) {
               var10 = (Club)var3.get(var15);
               break;
            }
         }
      } else {
         for (int var16 = 0; var16 < var3.size(); var16++) {
            if (((Club)var3.get(var16)).a(this.player, var12)) {
               var10 = (Club)var3.get(var16);
               break;
            }
         }
      }

      this.selectDestination(var10, this.requestedFee);
      return var10;
   }

   private void selectDestination(Club club, int i) {
      this.destinationClub = club;
      this.agreedFee = i;
   }

   public static int tryLoanPlayer(Player player, Club club) {
      if (player != null && club != null) {
         if (!player.isAvailableForLoan()) {
            return 5;
         }

         if (club == player.getClub()) {
            return 2;
         }

         if (club.getSeniorPlayers().size() >= 35) {
            return 6;
         }

         byte var2 = 4;
         int var3 = 0;

         for (int var4 = 0; var4 < GamePersistence.careerState.bt().size(); var4++) {
            if (((PlayerLoan)GamePersistence.careerState.bt().get(var4)).getPlayer().getClub() != null && ((PlayerLoan)GamePersistence.careerState.bt().get(var4)).getPlayer().getClub() == club) {
               var3++;
            }
         }

         if (var3 >= var2) {
            return 3;
         }

         if (!canPlayerJoinClub(player, club)) {
            return 4;
         }

         player.loanToClub(club);
         return 1;
      } else {
         return 0;
      }
   }

   public static int tryListedTransfer(Player player, Club club) {
      transferCompleted = false;
      if (player == null || club == null || !player.isTransferListed()) {
         return 0;
      }

      if (club == player.getClub()) {
         return 2;
      }

      if (club.kb() < player.getAskingPrice()) {
         return 5;
      }

      if (club.getSeniorPlayers().size() >= 35) {
         return 3;
      }

      if (!canPlayerJoinClub(player, club)) {
         return 4;
      }

      player.moveToClub(club, player.getAskingPrice(), false, false, false);
      transferCompleted = true;
      return 1;
   }

   public static int evaluateTransferOffer(Player player, Club club, int i) {
      transferCompleted = false;
      sellerClub = player.getClub();
      requestedSalary = 0;
      int[] var3 = sellerClub.J(false);
      int[] var4 = new int[]{3, 4, 4, 5, 4};
      double[] var5 = new double[]{1.5, 1.5, 1.5, 1.5, 2.0, 1.0};
      double[] var6 = new double[]{1.0, 1.0, 1.0, 1.0, 1.5, 2.0};
      double[] var7 = new double[]{0.5, 0.2, 0.2, 0.2, 0.5, 1.0};
      int[] var8 = new int[]{15, 20, 20, 10, 10, 2};
      int var9 = 0;
      if (var3[player.getPosicao()] >= var4[player.getPosicao()]) {
         if (player.getOverallStrength() >= 30 && player.getIdade() <= 35) {
            int var10 = (int)Math.round(player.getMarketValue() * var7[player.getPosicao()]);
            var9 = player.getMarketValue() + var10;
         } else {
            var9 = player.getMarketValue() - Math.round(player.getMarketValue() * var8[player.getPosicao()] / 100);
         }
      } else if (var3[player.getPosicao()] == 1) {
         int var12 = (int)Math.round(player.getMarketValue() * var5[player.getPosicao()]);
         var9 = player.getMarketValue() + var12;
      } else {
         int var13 = (int)Math.round(player.getMarketValue() * var6[player.getPosicao()]);
         var9 = player.getMarketValue() + var13;
      }

      if (i >= var9) {
         int var15 = evaluatePlayerInterest(player, club);
         if (var15 == 1) {
            return 4;
         } else {
            return var15 == 2 ? 6 : 1;
         }
      } else {
         if (club.kb() >= var9) {
            int var14 = evaluatePlayerInterest(player, club);
            if (var14 == 0 || var14 == 2) {
               counterOfferFee = var9;
               return 7;
            }
         }

         return 0;
      }
   }

   public static int evaluatePlayerInterest(Player player, Club club) {
      if (club.gg() == 0) {
         return 0;
      }

      if (player.gh() == 0 && player.getClub().getReputacao() >= 4) {
         if (club.getReputacao() >= 4 || club.getDivisao() == 1) {
            return 0;
         }

         if (club.getReputacao() >= 3 || club.getDivisao() == 1) {
            requestedSalary = player.getSalary() * 2;
            return 2;
         }
      } else {
         if (player.getClub().getReputacao() >= 3 && club.getReputacao() >= 3) {
            return 0;
         }

         if (player.getClub().getReputacao() == 3 && club.getReputacao() == 2) {
            return 0;
         }

         if (player.getClub().getReputacao() == 3 && club.getReputacao() == 1) {
            return 0;
         }

         if (player.getClub().getReputacao() <= 2) {
            return 0;
         }
      }

      return 1;
   }

   public static boolean canPlayerJoinClub(Player player, Club club) {
      if (club.gg() == 0) {
         return true;
      }

      if (player.gh() == 0 && player.getClub().getReputacao() >= 4) {
         if (club.getReputacao() >= 4 || club.getDivisao() == 1) {
            return true;
         }
      } else {
         if (player.getClub().getReputacao() >= 3 && club.getReputacao() >= 3) {
            return true;
         }

         if (player.getClub().getReputacao() == 3 && club.getReputacao() == 2) {
            return true;
         }

         if (player.getClub().getReputacao() == 3 && club.getReputacao() == 1) {
            return true;
         }

         if (player.getClub().getReputacao() <= 2) {
            return true;
         }
      }

      return false;
   }

   public static void replenishSquadAfterTransfer(Club club, Player player) {
      int[] var2 = club.J(false);
      int[] var3 = new int[]{2, 3, 3, 5, 3, 2};

      for (int var4 = 0; var4 <= 4; var4++) {
         if (var2[var4] < var3[var4]) {
            int[] var5 = new int[]{player.getPosicao(), player.getOverallStrength()};
            recruitPlayerForNeed(club, var5);
         }
      }
   }

   public static void recruitPlayerForNeed(Club club, int[] is) {
      int var2 = club.getReputacao();
      int var3 = var2 - 2;
      int var4 = var2 + 1;
      if (var3 < 0) {
         var3 = 0;
      }

      CountryCompetitions var5 = null;
      Player var6 = null;
      ArrayList var7 = new ArrayList();
      if (club.kn()) {
         var5 = GamePersistence.careerState.o(club.getPais());
         if (var5 != null) {
            for (int var8 = 0; var8 < var5.jg().size(); var8++) {
               if (!((Club)var5.jg().get(var8)).isUserControlled()
                  && var5.jg().get(var8) != club
                  && var3 <= ((Club)var5.jg().get(var8)).getReputacao()
                  && var4 >= ((Club)var5.jg().get(var8)).getReputacao()) {
                  var7.add((Club)var5.jg().get(var8));
               }
            }

            Collections.shuffle(var7);
            var6 = findRecruitmentCandidate(var7, is);
         }
      } else {
         var3 = var2 - 1;
         var4 = var2 + 1;
         if (var3 < 0) {
            var3 = 0;
         }

         for (int var13 = 0; var13 < GamePersistence.careerState.P().size(); var13++) {
            if (!((Club)GamePersistence.careerState.P().get(var13)).isUserControlled()
               && GamePersistence.careerState.P().get(var13) != club
               && ((Club)GamePersistence.careerState.P().get(var13)).gg() == club.gg()
               && var3 <= ((Club)GamePersistence.careerState.P().get(var13)).getReputacao()
               && var4 >= ((Club)GamePersistence.careerState.P().get(var13)).getReputacao()) {
               var7.add((Club)GamePersistence.careerState.P().get(var13));
            }
         }

         Collections.shuffle(var7);
         var6 = findRecruitmentCandidate(var7, is);
      }

      if (var6 != null) {
         var6.moveToClub(club, var6.getMarketValue(), false, false, false);
      } else {
         var6 = Player.a(club, is[0], null, 0, null, false);
         if (var6 != null) {
            C0677.a(false, var6, club);
         }
      }
   }

   public static Player findRecruitmentCandidate(ArrayList arrayList, int[] is) {
      int var2 = is[1] - 5;
      int var3 = is[1] + 5;
      int var4 = is[0];
      Player var5 = null;
      int[] var6 = new int[]{3, 4, 4, 6, 4, 3};
      if (var2 < 5) {
         var2 = 5;
      }

      if (var3 > 100) {
         var3 = 100;
      }

      int var7 = 0;
      ArrayList var8 = new ArrayList();

      for (int var9 = 0; var9 < arrayList.size(); var9++) {
         var8.clear();
         var8.addAll(((Club)arrayList.get(var9)).getSeniorPlayers());
         Collections.shuffle(var8);
         var7 = 0;

         for (int var10 = 0; var10 < var8.size(); var10++) {
            if (((Player)var8.get(var10)).getPosicao() == var4) {
               var7++;
            }

            if (var5 == null
               && ((Player)var8.get(var10)).getPosicao() == var4
               && ((Player)var8.get(var10)).getOverallStrength() >= var2
               && ((Player)var8.get(var10)).getOverallStrength() <= var3
               && !((Player)var8.get(var10)).isStarPlayer()
               && !((Player)var8.get(var10)).isWorldClassPlayer()) {
               var5 = (Player)var8.get(var10);
            }
         }

         if (var5 != null && var7 >= var6[var4]) {
            break;
         }

         var5 = null;
      }

      return var5;
   }

   public Club getDestinationClub() {
      return this.destinationClub;
   }

   public void setDestinationClub(Club club) {
      this.destinationClub = club;
   }

   public int getAgreedFee() {
      return this.agreedFee;
   }

   public void setAgreedFee(int i) {
      this.agreedFee = i;
   }

   public static int getRequestedSalary() {
      return requestedSalary;
   }

   public static int getCounterOfferFee() {
      return counterOfferFee;
   }

   public static boolean isTransferCompleted() {
      return transferCompleted;
   }

   public static void setTransferCompleted(boolean bl) {
      transferCompleted = bl;
   }

   public boolean cP() {
      return this.cr;
   }

   public void m(boolean bl) {
      this.cr = bl;
   }
}
