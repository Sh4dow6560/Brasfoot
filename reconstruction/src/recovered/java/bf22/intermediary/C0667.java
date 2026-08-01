package bf22.intermediary;

import java.io.Serializable;
import javax.swing.ImageIcon;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0667 implements Serializable {
   private static final long serialVersionUID = 1L;
   private Club dy = null;
   private int w = -1;
   private int dz = -1;
   private int dA = -1;
   private int dB = -1;
   private Player dC = null;
   private Player dD = null;
   private boolean dE = false;
   private int dF;
   private boolean dG = false;

   public C0667() {
   }

   public C0667(int i) {
      this.dF = i;
   }

   public C0667(int i, boolean bl) {
      this.w = i;
      this.dE = bl;
   }

   public Club cu() {
      return this.dy;
   }

   public void k(Club club) {
      this.dy = club;
   }

   public int b() {
      return this.w;
   }

   public void a(int i) {
      this.w = i;
   }

   public int el() {
      return this.dz;
   }

   public void R(int i) {
      this.dz = i;
   }

   public int em() {
      return this.dA;
   }

   public void S(int i) {
      this.dA = i;
   }

   public int en() {
      return this.dB;
   }

   public void T(int i) {
      this.dB = i;
   }

   public Player eo() {
      return this.dC;
   }

   public void f(Player player) {
      this.dC = player;
   }

   public Player ep() {
      return this.dD;
   }

   public void g(Player player) {
      this.dD = player;
   }

   public boolean isDone() {
      return this.dE;
   }

   public void p(boolean bl) {
      this.dE = bl;
   }

   public String eq() {
      String var1 = "";
      if (this.dB > 0) {
         var1 = " - " + Integer.toString(this.dB) + "º ";
      }

      String var2 = Integer.toString(this.dA) + "'";
      if (this.dA == 0 && this.dB == 2) {
         var2 = "interv.";
         var1 = "";
      }

      return var2 + var1;
   }

   public String er() {
      String var1 = "";
      var1 = "<html>";
      String var2 = "";
      if (this.dB > 0) {
         var2 = " - " + Integer.toString(this.dB) + "º ";
      }

      if (this.w == 1) {
         String var3 = "";
         if (var3 != null) {
            var3 = this.dC.getNome();
         }

         var1 = var1 + this.dC.getNome() + " " + Integer.toString(this.dA) + "'";
         if (this.dz == 2) {
            var1 = var1 + " (contra)";
         } else if (this.dz == 3) {
            var1 = var1 + " (penalty)";
         } else if (this.dz == 4) {
            var1 = var1 + " (falta)";
         } else if (this.dz == 5) {
            var1 = var1 + " (olímpico)";
         }
      } else if (this.w == 6) {
         if (this.dC == null || this.dD == null) {
            return "";
         }

         String var7 = Integer.toString(this.dA) + "'";
         if (this.dA == 0 && this.dB == 2) {
            var7 = "(interv.)";
            var2 = "";
         }

         var1 = var1 + "(" + this.dC.getNome() + ") " + this.dD.getNome() + " " + var7;
      } else if (this.w == 7) {
         var1 = var1 + this.dC.getNome() + " " + Integer.toString(this.dA) + "'" + " perdeu penalty";
      } else if (this.w == 8) {
         String var8 = "";
         if (var8 != null) {
            var8 = "(A: " + this.dC.getNome() + ")";
         }

         var1 = var1 + var8;
         var2 = "";
      } else {
         var1 = var1 + this.dC.getNome() + " " + Integer.toString(this.dA) + "'";
      }

      return var1 + var2 + "</html>";
   }

   public ImageIcon es() {
      if (this.w == 1) {
         return this.dz == 2
            ? new ImageIcon(this.getClass().getResource("/aeicons/egolc.png"))
            : new ImageIcon(this.getClass().getResource("/aeicons/egol.png"));
      } else if (this.w == 2) {
         return new ImageIcon(this.getClass().getResource("/aeicons/eca.png"));
      } else if (this.w == 3) {
         return new ImageIcon(this.getClass().getResource("/aeicons/ecacv.png"));
      } else if (this.w == 4) {
         return new ImageIcon(this.getClass().getResource("/aeicons/ecv.png"));
      } else if (this.w == 5) {
         return new ImageIcon(this.getClass().getResource("/aeicons/ect.png"));
      } else if (this.w == 7) {
         return new ImageIcon(this.getClass().getResource("/aeicons/egolc.png"));
      } else {
         return this.w == 6 ? new ImageIcon(this.getClass().getResource("/aeicons/esubs.png")) : null;
      }
   }

   public int et() {
      return this.dF;
   }

   public boolean eu() {
      return this.dG;
   }

   public void q(boolean bl) {
      this.dG = bl;
   }
}
