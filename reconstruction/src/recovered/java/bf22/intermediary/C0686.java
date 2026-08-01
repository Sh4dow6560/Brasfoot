package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.game.CareerState;
import mod.recovered.save.GamePersistence;
import java.io.Serializable;
import mod.recovered.model.Club;

public class C0686 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int gV;
   private int gW;
   private int gX = 0;
   private int gY = 0;
   private int gZ = 0;
   private int ha = 0;
   private int T = 0;
   private int hb = -1;
   private int hc;
   private int hd;
   private int he;
   private int hf = -1;
   private int hg;
   private int hh;
   private int hi;

   public C0686() {
   }

   public C0686(int i, int j, int k, int l, int m) {
      this.gV = i;
      this.gW = j;
      this.gX = k;
      this.gY = l;
      this.T++;
      if (k != l) {
         if (k > l) {
            this.gZ++;
            this.hb = m;
            this.hc = GamePersistence.careerState.H();
            this.hd = k;
            this.he = l;
         } else {
            this.ha++;
            this.hf = m;
            this.hg = GamePersistence.careerState.H();
            this.hh = k;
            this.hi = l;
         }
      }

      GamePersistence.careerState.bd().add(this);
   }

   public void a(int i, int j, int k, int l) {
      int var5 = 0;
      int var6 = 0;
      boolean var7 = false;
      if (i == 1) {
         var5 = this.hd - this.he;
         var6 = j - k;
         if (var6 > var5) {
            var7 = true;
         } else if (var6 == var5 && j >= this.hd) {
            var7 = true;
         }

         if (var7) {
            this.hc = GamePersistence.careerState.H();
            this.hb = l;
            this.hd = j;
            this.he = k;
         }
      } else if (i == 2) {
         var5 = this.hh - this.he;
         var6 = j - k;
         if (var6 > var5) {
            var7 = true;
         } else if (var6 == var5 && j >= this.hh) {
            var7 = true;
         }

         if (var7) {
            this.hg = GamePersistence.careerState.H();
            this.hf = l;
            this.hh = j;
            this.hi = k;
         }
      }
   }

   public void a(Club club, Club club2, int i, int j, int k) {
      boolean var6 = true;
      if (club.lk() == this.iL()) {
         var6 = true;
      } else {
         var6 = false;
      }

      this.T++;
      if (var6) {
         this.gX += i;
         this.gY += j;
         if (i > j) {
            this.gZ++;
            this.a(1, i, j, k);
         } else if (j > i) {
            this.ha++;
            this.a(2, j, i, k);
         }
      } else {
         this.gX += j;
         this.gY += i;
         if (i > j) {
            this.ha++;
            this.a(2, i, j, k);
         } else if (j > i) {
            this.gZ++;
            this.a(1, j, i, k);
         }
      }
   }

   public String iJ() {
      return CareerState.z(this.gV);
   }

   public String iK() {
      return CareerState.z(this.gW);
   }

   public int iL() {
      return this.gV;
   }

   public void ba(int i) {
   }

   public int iM() {
      return this.gW;
   }

   public void bb(int i) {
   }

   public void k(int i) {
   }

   public int getP1() {
      return this.gX;
   }

   public void bc(int i) {
   }

   public int getP2() {
      return this.gY;
   }

   public void bd(int i) {
   }

   public boolean a(Club club, Club club2) {
      return this.gV == club.lk() && this.gW == club2.lk() ? true : this.gW == club.lk() && this.gV == club2.lk();
   }

   public Club y(Club club) {
      if (this.gV == club.lk()) {
         return GamePersistence.careerState.x(this.gW);
      } else {
         return this.gW == club.lk() ? GamePersistence.careerState.x(this.gV) : null;
      }
   }

   public String iN() {
      String var1 = "jogos";
      if (this.T == 1) {
         var1 = "jogo";
      }

      return String.valueOf(this.T + " " + var1);
   }

   public String iO() {
      int var1 = this.T - (this.gZ + this.ha);
      String var2 = "empates";
      if (var1 == 1) {
         var2 = "empate";
      }

      return String.valueOf(var1) + " " + var2;
   }

   public String be(int i) {
      int var2 = this.gZ;
      if (i == this.gW) {
         var2 = this.ha;
      }

      String var3 = "vitórias";
      if (var2 == 1) {
         var3 = "vitória";
      }

      return String.valueOf(var2) + " " + var3;
   }

   public String bf(int i) {
      int var2 = this.gX;
      if (i == this.gW) {
         var2 = this.gY;
      }

      String var3 = "gols";
      if (var2 == 1) {
         var3 = "gol";
      }

      return String.valueOf(var2) + " " + var3;
   }

   public String[] bg(int i) {
      return i == this.gW ? this.iQ() : this.iP();
   }

   public String[] iP() {
      String[] var1 = new String[]{"", ""};
      if (this.hb >= 0) {
         var1[0] = String.valueOf(GamePersistence.careerState.iU() + this.hc) + " - " + this.bh(1) + ": " + this.hd + "x" + this.he;
         var1[1] = "(" + GameConstants.tz[this.hb] + ")";
      }

      return var1;
   }

   public String[] iQ() {
      String[] var1 = new String[]{"", ""};
      if (this.hf >= 0) {
         var1[0] = String.valueOf(GamePersistence.careerState.iU() + this.hg) + " - " + this.bh(2) + ": " + this.hh + "x" + this.hi;
         var1[1] = "(" + GameConstants.tz[this.hf] + ")";
      }

      return var1;
   }

   public String bh(int i) {
      String var2 = "";
      if (this.hb >= 0) {
         var2 = GameConstants.tz[this.hb];
      }

      Club var3 = GamePersistence.careerState.x(this.gV);
      int var4 = this.hb;
      if (i == 2) {
         var3 = GamePersistence.careerState.x(this.gW);
         if (this.hf >= 0) {
            var2 = GameConstants.tz[this.hf];
         }

         var4 = this.hf;
      }

      if (var4 == 1) {
         var2 = "Camp. Nacional";
      } else if (var4 == 3) {
         var2 = "Camp. " + GameConstants.rZ[var3.getEstado()];
      } else if (var4 == 4 || var4 == 6 || var4 == 7 || var4 == 8) {
         var2 = GameConstants.z(var4, var3.gg());
      }

      return var2;
   }
}
