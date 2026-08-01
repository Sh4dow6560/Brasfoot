package mod.recovered.finance;

import java.io.Serializable;
import mod.recovered.model.Club;

public class ClubFinances implements Serializable {
   private static final long serialVersionUID = 1L;
   private long dK;
   private int dL;
   private int dM;
   private long dN;
   private int dO;
   private int dP;
   private int dQ;
   private long dR;
   private long dS;
   private int dT;
   private int dU;
   private int dV;
   private int dW;
   private int dX;
   private static String[] dY = new String[]{" mil", "M", "B", "T"};

   public static void ey() {
   }

   public long ez() {
      return this.dL + this.dM + this.dN + this.dO + this.dP;
   }

   public void eA() {
      this.dL = 0;
      this.dN = 0L;
      this.dM = 0;
      this.dO = 0;
      this.dQ = 0;
      this.dS = 0L;
      this.dT = 0;
      this.dU = 0;
      this.dV = 0;
      this.dR = 0L;
   }

   public long eB() {
      return this.dQ + this.dR + this.dS + this.dT + this.dU + this.dV;
   }

   public long eC() {
      long var1 = this.ez();
      long var3 = this.eB();
      return var1 - var3;
   }

   public void h(int i, int j) {
      if (j == 1) {
         this.dN += i;
      } else if (j == 3) {
         this.dM += i;
      } else if (j == 5) {
         this.dL += i;
      } else if (j == 6) {
         this.dO += i;
      } else if (j == 9) {
         this.dP += i;
      }
   }

   public void b(long l) {
      this.dS += l;
   }

   public void i(int i, int j) {
      if (j == 1) {
         this.dR += i;
      } else if (j == 4) {
         this.dT += i;
      } else if (j == 7) {
         this.dQ += i;
      } else if (j == 8) {
         this.dV += i;
      } else {
         this.dU += i;
      }
   }

   public static String c(long l) {
      String var2 = String.valueOf(l);
      String[] var3 = new String[]{"mil", "milhão", "milhões", "bilhão", "bilhões"};
      String var4 = "";
      String var5 = "";
      if (l < 0L) {
         return "-" + c(Math.abs(l));
      }

      if (l == 0L) {
         return "0 " + var3[0];
      }

      if (l <= 999L) {
         return var2;
      }

      if (l <= 9999L) {
         return var2.substring(0, 1) + " " + var3[0];
      }

      if (l <= 99999L) {
         return var2.substring(0, 2) + " " + var3[0];
      }

      if (l <= 999999L) {
         return var2.substring(0, 3) + " " + var3[0];
      }

      if (l <= 1999999L) {
         var4 = var2.substring(0, 1) + " " + var3[1];
         var5 = var2.substring(1, 4) + " " + var3[0];
      } else if (l <= 9999999L) {
         var4 = var2.substring(0, 1) + " " + var3[2];
         var5 = var2.substring(1, 4) + " " + var3[0];
      } else if (l <= 99999999L) {
         var4 = var2.substring(0, 2) + " " + var3[2];
         var5 = var2.substring(2, 5) + " " + var3[0];
      } else if (l <= 999999999L) {
         var4 = var2.substring(0, 3) + " " + var3[2];
         var5 = var2.substring(3, 6) + " " + var3[0];
      } else if (l <= 1999999999L) {
         var4 = var2.substring(0, 1) + " " + var3[3];
         var5 = var2.substring(1, 4) + " " + var3[2];
      } else if (l <= 9999999999L) {
         var4 = var2.substring(0, 1) + " " + var3[4];
         var5 = var2.substring(1, 4) + " " + var3[2];
      } else {
         if (l > 99999999999L) {
            return a(l, 0);
         }

         var4 = var2.substring(0, 2) + " " + var3[4];
         var5 = var2.substring(2, 5) + " " + var3[2];
      }

      if (var5.length() >= 3 && var5.substring(0, 3).equals("000")) {
         var5 = "";
      }

      if (var5.length() >= 3 && var5.substring(0, 2).equals("00")) {
         var5 = var5.substring(2, 3) + " " + var3[0];
      }

      if (var5.length() >= 3 && var5.substring(0, 1).equals("0")) {
         var5 = var5.substring(1, 3) + " " + var3[0];
      }

      return var4 + " " + var5;
   }

   public static String U(int i) {
      return null;
   }

   public static String a(double d, int i) {
      double var3 = (long)d / 100L / 10.0;
      boolean var5 = var3 * 10.0 % 10.0 == 0.0;
      return var3 < 1000.0 ? (!(var3 > 99.9) && !var5 && (var5 || !(var3 > 9.99)) ? String.valueOf(var3) : (int)var3 * 10 / 10) + dY[i] : a(var3, i + 1);
   }

   public long eD() {
      return this.dK;
   }

   public int eE() {
      return this.dL;
   }

   public int eF() {
      return this.dM;
   }

   public long eG() {
      return this.dN;
   }

   public int eH() {
      return this.dO;
   }

   public int eI() {
      return this.dQ;
   }

   public long eJ() {
      return this.dR;
   }

   public int eK() {
      return this.dT;
   }

   public int eL() {
      return this.dU;
   }

   public int eM() {
      return this.dV;
   }

   public int eN() {
      return this.dW;
   }

   public long eO() {
      return this.dS;
   }

   public void V(int i) {
      this.dW = i;
   }

   public boolean l(Club club) {
      if (this.dW > 0 && club.kb() >= 500000L) {
         this.dW -= 500000;
         club.w(500000, -1);
         this.eP();
         return true;
      } else {
         return false;
      }
   }

   public boolean m(Club club) {
      int[] var2 = new int[]{1000000, 5000000, 3000000, 2000000, 1500000};
      int var3;
      if (club.getDivisao() >= 1 && club.getDivisao() <= 4) {
         var3 = var2[club.getDivisao()];
      } else {
         var3 = var2[0];
      }

      if (this.dW < var3) {
         this.dW += 500000;
         club.v(500000, -1);
         this.eP();
         return true;
      } else {
         return false;
      }
   }

   private void eP() {
      if (this.dW > 0) {
         this.dX = Math.round(this.dW * 3 / 100);
      } else {
         this.dX = 0;
      }
   }

   public int eQ() {
      return this.dX;
   }

   public void W(int i) {
      this.dX = i;
   }

   public int eR() {
      return this.dP;
   }

   public void X(int i) {
      this.dP = i;
   }
}
