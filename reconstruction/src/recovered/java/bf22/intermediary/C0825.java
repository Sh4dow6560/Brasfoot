package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0825 implements Serializable {
   private static final long serialVersionUID = 1L;
   private Player U = null;
   private long Pm = 0L;
   private Club Pn = null;
   private boolean Po = false;

   public C0825() {
   }

   public C0825(Player player, Club club) {
      this.U = player;
      this.Pn = club;
      C0745.SR.bt().add(this);
      long var3 = 366L;
      var3 *= 86400000L;
      this.Pm = C0745.SR.bc() + var3;
   }

   public boolean tM() {
      return this.Pm < C0745.SR.bc();
   }

   public boolean tN() {
      boolean var1 = false;
      if (this.Pn != null) {
         if (this.Pn.jZ()) {
            if (this.Pn.kw() < 35) {
               this.U.r(this.Pn);
               var1 = true;
            }
         } else {
            this.U.r(this.Pn);
            var1 = true;
         }
      }

      return var1;
   }

   public Player x() {
      return this.U;
   }

   public long tO() {
      return this.Pm;
   }

   public Club tP() {
      return this.Pn;
   }

   public boolean tQ() {
      return this.Po;
   }

   public void au(boolean bl) {
      this.Po = bl;
   }
}
