package mod.recovered.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.game.CareerState;
import mod.recovered.model.Player;
import mod.recovered.save.GamePersistence;

public class PlayerTransferRecord implements Serializable {
   private static final long serialVersionUID = 1L;
   private int day = 0;
   private int month = 0;
   private int year = 0;
   private transient Player player = null;
   private int playerId = -1;
   private int playerPoolType = -1;
   private int sourceClubId = -1;
   private int destinationClubId = -1;
   private int fee = 0;

   public int getYear() {
      return this.year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public void setDate(int day, int zeroBasedMonth, int year) {
      this.day = day;
      this.month = zeroBasedMonth + 1;
      this.year = year;
   }

   public Player getPlayer() {
      return this.player;
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public int getFee() {
      return this.fee;
   }

   public void setFee(int fee) {
      this.fee = fee;
   }

   public String getDateText() {
      return Integer.toString(this.day)
         + "/"
         + Integer.toString(this.month)
         + "/"
         + Integer.toString(this.year);
   }

   public int getDestinationClubId() {
      return this.destinationClubId;
   }

   public void setDestinationClubId(int clubId) {
      this.destinationClubId = clubId;
   }

   public int getSourceClubId() {
      return this.sourceClubId;
   }

   public void setSourceClubId(int clubId) {
      this.sourceClubId = clubId;
   }

   public int getPlayerId() {
      return this.playerId;
   }

   public void capturePlayerIdentity() {
      if (this.player != null) {
         this.playerId = this.player.getPlayerId();
         this.playerPoolType = this.player.gI();
      } else {
         this.playerId = -1;
      }
   }

   public String getSourceClubName() {
      return CareerState.z(this.sourceClubId);
   }

   public String getDestinationClubName() {
      return CareerState.z(this.destinationClubId);
   }

   public void restorePlayerReference() {
      if (this.playerId < 0) {
         return;
      }

      ArrayList players = null;
      if (this.playerPoolType == 1) {
         players = GamePersistence.careerState.O();
      } else if (this.playerPoolType == 2) {
         players = GamePersistence.careerState.Q();
      }

      if (players == null) {
         return;
      }

      for (int index = 0; index < players.size(); index++) {
         Player candidate = (Player)players.get(index);
         if (this.playerId == candidate.getPlayerId()) {
            this.player = candidate;
            break;
         }
      }
   }
}
