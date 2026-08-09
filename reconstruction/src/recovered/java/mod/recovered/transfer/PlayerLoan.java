package mod.recovered.transfer;

import bf22.intermediary.*;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class PlayerLoan implements Serializable {
   private static final long serialVersionUID = 1L;
   private Player player = null;
   private long endTimeMillis = 0L;
   private Club originalClub = null;
   private boolean returnFailureNotified = false;

   public PlayerLoan() {
   }

   public PlayerLoan(Player player, Club club) {
      this.player = player;
      this.originalClub = club;
      GamePersistence.careerState.getPlayerLoans().add(this);
      long var3 = 366L;
      var3 *= 86400000L;
      this.endTimeMillis = GamePersistence.careerState.getCurrentTimeMillis() + var3;
   }

   public boolean isExpired() {
      return this.endTimeMillis < GamePersistence.careerState.getCurrentTimeMillis();
   }

   public boolean returnToOriginalClub() {
      boolean var1 = false;
      if (this.originalClub != null) {
         if (this.originalClub.isUserControlled()) {
            if (this.originalClub.kw() < 35) {
               this.player.returnFromLoan(this.originalClub);
               var1 = true;
            }
         } else {
            this.player.returnFromLoan(this.originalClub);
            var1 = true;
         }
      }

      return var1;
   }

   public Player getPlayer() {
      return this.player;
   }

   public long getEndTimeMillis() {
      return this.endTimeMillis;
   }

   public Club getOriginalClub() {
      return this.originalClub;
   }

   public boolean isReturnFailureNotified() {
      return this.returnFailureNotified;
   }

   public void setReturnFailureNotified(boolean bl) {
      this.returnFailureNotified = bl;
   }
}
