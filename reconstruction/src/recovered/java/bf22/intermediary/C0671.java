package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Player;

public class C0671 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int dB;
   private int ed;
   private int ee = -1;
   private Player ef = null;
   private int eg = 0;
   private static Double eh = 0.0;

   public int en() {
      return this.dB;
   }

   public void T(int i) {
      this.dB = i;
   }

   public int eZ() {
      return this.ed;
   }

   public void aa(int i) {
      this.ed = i;
   }

   public int fa() {
      return this.ee;
   }

   public void ab(int i) {
      this.ee = i;
   }

   public Player fb() {
      return this.ef;
   }

   public void h(Player player) {
      this.ef = player;
   }

   public int fc() {
      return this.eg;
   }

   public void ac(int i) {
      this.eg = i;
   }

   public static void a(Double double_) {
      eh = double_;
   }
}
