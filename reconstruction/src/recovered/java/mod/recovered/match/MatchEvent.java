package mod.recovered.match;

import bf22.intermediary.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class MatchEvent implements Serializable {
   private static final long serialVersionUID = 1L;
   private Club club = null;
   private int type = -1;
   private int subtype = -1;
   private int minute = -1;
   private int period = -1;
   private Player primaryPlayer = null;
   private Player secondaryPlayer = null;
   private boolean done = false;
   private int teamSide;
   private boolean confirmed = false;

   public MatchEvent() {
   }

   public MatchEvent(int i) {
      this.teamSide = i;
   }

   public MatchEvent(int i, boolean bl) {
      this.type = i;
      this.done = bl;
   }

   public Club getClub() {
      return this.club;
   }

   public void setClub(Club club) {
      this.club = club;
   }

   public int getType() {
      return this.type;
   }

   public void setType(int i) {
      this.type = i;
   }

   public int getSubtype() {
      return this.subtype;
   }

   public void setSubtype(int i) {
      this.subtype = i;
   }

   public int getMinute() {
      return this.minute;
   }

   public void setMinute(int i) {
      this.minute = i;
   }

   public int getPeriod() {
      return this.period;
   }

   public void setPeriod(int i) {
      this.period = i;
   }

   public Player getPrimaryPlayer() {
      return this.primaryPlayer;
   }

   public void setPrimaryPlayer(Player player) {
      this.primaryPlayer = player;
   }

   public Player getSecondaryPlayer() {
      return this.secondaryPlayer;
   }

   public void setSecondaryPlayer(Player player) {
      this.secondaryPlayer = player;
   }

   public boolean isDone() {
      return this.done;
   }

   public void setDone(boolean bl) {
      this.done = bl;
   }

   public String getTimeLabel() {
      String var1 = "";
      if (this.period > 0) {
         var1 = " - " + Integer.toString(this.period) + "º ";
      }

      String var2 = Integer.toString(this.minute) + "'";
      if (this.minute == 0 && this.period == 2) {
         var2 = "interv.";
         var1 = "";
      }

      return var2 + var1;
   }

   public String getDisplayHtml() {
      String var1 = "";
      var1 = "<html>";
      String var2 = "";
      if (this.period > 0) {
         var2 = " - " + Integer.toString(this.period) + "º ";
      }

      if (this.type == 1) {
         String var3 = "";
         if (var3 != null) {
            var3 = this.primaryPlayer.getNome();
         }

         var1 = var1 + this.primaryPlayer.getNome() + " " + Integer.toString(this.minute) + "'";
         if (this.subtype == 2) {
            var1 = var1 + " (contra)";
         } else if (this.subtype == 3) {
            var1 = var1 + " (penalty)";
         } else if (this.subtype == 4) {
            var1 = var1 + " (falta)";
         } else if (this.subtype == 5) {
            var1 = var1 + " (olímpico)";
         }
      } else if (this.type == 6) {
         if (this.primaryPlayer == null || this.secondaryPlayer == null) {
            return "";
         }

         String var7 = Integer.toString(this.minute) + "'";
         if (this.minute == 0 && this.period == 2) {
            var7 = "(interv.)";
            var2 = "";
         }

         var1 = var1 + "(" + this.primaryPlayer.getNome() + ") " + this.secondaryPlayer.getNome() + " " + var7;
      } else if (this.type == 7) {
         var1 = var1 + this.primaryPlayer.getNome() + " " + Integer.toString(this.minute) + "'" + " perdeu penalty";
      } else if (this.type == 8) {
         String var8 = "";
         if (var8 != null) {
            var8 = "(A: " + this.primaryPlayer.getNome() + ")";
         }

         var1 = var1 + var8;
         var2 = "";
      } else {
         var1 = var1 + this.primaryPlayer.getNome() + " " + Integer.toString(this.minute) + "'";
      }

      return var1 + var2 + "</html>";
   }

   public ImageIcon getIcon() {
      if (this.type == 1) {
         return this.subtype == 2
            ? new ImageIcon(this.getClass().getResource("/aeicons/egolc.png"))
            : new ImageIcon(this.getClass().getResource("/aeicons/egol.png"));
      } else if (this.type == 2) {
         return new ImageIcon(this.getClass().getResource("/aeicons/eca.png"));
      } else if (this.type == 3) {
         return new ImageIcon(this.getClass().getResource("/aeicons/ecacv.png"));
      } else if (this.type == 4) {
         return new ImageIcon(this.getClass().getResource("/aeicons/ecv.png"));
      } else if (this.type == 5) {
         return new ImageIcon(this.getClass().getResource("/aeicons/ect.png"));
      } else if (this.type == 7) {
         return new ImageIcon(this.getClass().getResource("/aeicons/egolc.png"));
      } else {
         return this.type == 6 ? new ImageIcon(this.getClass().getResource("/aeicons/esubs.png")) : null;
      }
   }

   public int getTeamSide() {
      return this.teamSide;
   }

   public boolean isConfirmed() {
      return this.confirmed;
   }

   public void setConfirmed(boolean bl) {
      this.confirmed = bl;
   }
}
