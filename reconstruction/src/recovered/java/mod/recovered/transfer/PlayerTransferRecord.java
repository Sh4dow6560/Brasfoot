package mod.recovered.transfer;

import bf22.intermediary.*;
import mod.recovered.game.CareerState;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Player;

public class PlayerTransferRecord implements Serializable {
   private static final long serialVersionUID = 1L;
   private int d = 0;
   private int on = 0;
   private int y = 0;
   private transient Player U = null;
   private int ei = -1;
   private int ej = -1;
   private int oo = -1;
   private int op = -1;
   private int oq = 0;

   public int getY() {
      return this.y;
   }

   public void cp(int i) {
      this.y = i;
   }

   public void f(int i, int j, int k) {
      this.d = i;
      this.on = j + 1;
      this.y = k;
   }

   public Player x() {
      return this.U;
   }

   public void a(Player player) {
      this.U = player;
   }

   public int lY() {
      return this.oq;
   }

   public void cq(int i) {
      this.oq = i;
   }

   public String f() {
      return Integer.toString(this.d) + "/" + Integer.toString(this.on) + "/" + Integer.toString(this.y);
   }

   public int lZ() {
      return this.op;
   }

   public void cr(int i) {
      this.op = i;
   }

   public int ma() {
      return this.oo;
   }

   public void cs(int i) {
      this.oo = i;
   }

   public int gD() {
      return this.ei;
   }

   public void mb() {
      if (this.U != null) {
         this.ei = this.U.gD();
         this.ej = this.U.gI();
      } else {
         this.ei = -1;
      }
   }

   public String mc() {
      return CareerState.z(this.oo);
   }

   public String md() {
      return CareerState.z(this.op);
   }

   public void me() {
      if (this.ei >= 0) {
         ArrayList var1 = null;
         if (this.ej == 1) {
            var1 = GamePersistence.SR.O();
         } else if (this.ej == 2) {
            var1 = GamePersistence.SR.Q();
         }

         if (var1 != null) {
            for (int var2 = 0; var2 < var1.size(); var2++) {
               if (this.ei == ((Player)var1.get(var2)).gD()) {
                  this.U = (Player)var1.get(var2);
                  break;
               }
            }
         }
      }
   }
}
