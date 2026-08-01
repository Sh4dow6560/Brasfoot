package mod.recovered.competition;

import bf22.intermediary.*;
import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import java.io.Serializable;
import java.util.ArrayList;
import mod.recovered.model.Club;

public class KnockoutStage extends CompetitionStage implements Serializable {
   private static final long serialVersionUID = 1L;
   private LeagueStage nS = null;
   private Competition YY = null;
   private int tR;
   private ArrayList ZF = new ArrayList();
   private int ZG = 0;
   private int Zf = 0;
   private int ZH;
   private transient int ZI = 0;
   private transient int ZJ = 0;
   private boolean[] ZK = new boolean[]{true, true, true, true, true, true, true};
   private int Zg = -1;
   boolean ZL = true;

   public KnockoutStage() {
   }

   public KnockoutStage(LeagueStage c0955, int i, int j, int k, boolean[] bls, Competition c0713, int l) {
      this.YY = c0713;
      this.nS = c0955;
      this.tR = j;
      this.Zg = l;
      this.ZK = bls;
      this.setNome(c0713.getNome());
      if (k > 0) {
         this.ZG = k - 1;
         this.ZL = false;
      } else {
         byte var8 = 1;
         if (this.Zg == 2029) {
            var8 = 7;
         } else if (i == 128) {
            var8 = 7;
         } else if (i == 64) {
            var8 = 6;
         } else if (i == 32) {
            var8 = 5;
         } else if (i == 16) {
            var8 = 4;
         } else if (i == 8) {
            var8 = 3;
         } else if (i == 4) {
            var8 = 2;
         } else if (i == 2) {
            var8 = 1;
         }

         this.ZG = var8 - 1;
      }

      this.Zf = 0;
      this.ZH = 1;
   }

   @Override
   public int b() {
      return this.tR;
   }

   public int zb() {
      return this.Zf;
   }

   public void fe(int i) {
      this.Zf = i;
   }

   public ArrayList zp() {
      return this.ZF;
   }

   public void ak(ArrayList arrayList) {
      this.ZF = arrayList;
   }

   public int zq() {
      return this.ZG;
   }

   public void ff(int i) {
      this.ZG = i - 1;
   }

   public int zr() {
      return this.ZH;
   }

   public void fg(int i) {
      this.ZH = i;
   }

   public void pO() {
      this.ZI = this.Zf;
      this.ZJ = this.ZH;
      boolean var1 = ((KnockoutRound)this.zp().get(this.Zf)).hO();
      if (this.ZH == 1 && !var1) {
         this.zs();
      } else if (this.ZH == 2) {
         this.zs();
      } else {
         this.ZH = 2;
      }
   }

   public void zs() {
      this.ZI = this.Zf;
      this.ZJ = this.ZH;
      if (this.Zg == 2029) {
         this.zx();
      } else if (this.Zf == this.ZG) {
         this.zx();
      } else {
         ((KnockoutRound)this.zp().get(this.Zf)).b(false, false);
         KnockoutRound var1 = new KnockoutRound();
         var1.a(this, ((KnockoutRound)this.zp().get(this.Zf)).zY(), this.Zf + 1, this.ZK[this.Zf + 1], 0, 0, this.tR, ((KnockoutRound)this.zp().get(this.Zf)).zZ());
         this.Zf++;
         this.ZH = 1;
      }
   }

   public void BH() {
      this.Zf++;
      this.ZH = 1;
   }

   public int[] o(Match c0675) {
      int[] var10000 = new int[]{-1, -1};
      return ((KnockoutRound)this.zp().get(this.Zf)).o(c0675);
   }

   public ArrayList zt() {
      ArrayList var1 = new ArrayList();

      for (int var2 = this.ZF.size() - 1; var2 >= 0; var2--) {
         if (((KnockoutRound)this.ZF.get(var2)).zW().size() == 2) {
            for (int var3 = 0; var3 <= 1; var3++) {
               if (!((KnockoutRound)this.ZF.get(var2)).zY().contains(((Match)((KnockoutRound)this.ZF.get(var2)).zW().get(var3)).getHomeClub())) {
                  var1.add(((Match)((KnockoutRound)this.ZF.get(var2)).zW().get(var3)).getHomeClub());
               }

               if (!((KnockoutRound)this.ZF.get(var2)).zY().contains(((Match)((KnockoutRound)this.ZF.get(var2)).zW().get(var3)).getAwayClub())) {
                  var1.add(((Match)((KnockoutRound)this.ZF.get(var2)).zW().get(var3)).getAwayClub());
               }
            }
         }
      }

      return var1;
   }

   public boolean zu() {
      return ((KnockoutRound)this.zp().get(this.Zf)).hO();
   }

   public int BI() {
      return ((KnockoutRound)this.zp().get(this.Zf)).ze();
   }

   public boolean fh(int i) {
      return i >= 0 && i < this.zp().size() ? ((KnockoutRound)this.zp().get(i)).hO() : false;
   }

   public boolean zv() {
      return ((KnockoutRound)this.zp().get(this.Zf)).zZ();
   }

   public void zx() {
      ((KnockoutRound)this.zp().get(this.Zf)).b(this.ZL, true);
   }

   public CompetitionStage zy() {
      return this.nS;
   }

   public void f(LeagueStage c0955) {
      this.nS = c0955;
   }

   public int zf() {
      return this.Zg;
   }

   public void fc(int i) {
      this.Zg = i;
   }

   public Competition yT() {
      return this.YY;
   }

   @Override
   public CountryCompetitions iq() {
      return this.nS != null ? this.nS.iq() : null;
   }

   @Override
   public C0741 ir() {
      return this.nS != null ? this.nS.ir() : null;
   }

   @Override
   public int ip() {
      return this.nS != null ? this.nS.ip() : -1;
   }

   @Override
   public String io() {
      String var1 = "";
      String[] var2 = this.YY.b(this);
      if (var2 == null) {
         var2 = this.zB();
      }

      if (this.ZG == 7) {
         this.ZG = 6;
      }

      int var3 = var2.length - 1 - this.ZG;
      int var4 = this.ZH;
      var1 = var2[var3 + this.Zf];
      if (this.ZG == 0 && this.Zf == 0 && (this.tR == 4 || this.tR == 5)) {
         var1 = var2[0];
      }

      if (this.ZG == 1 && this.Zf == 0 && this.tR == 4) {
         var1 = "Preliminar R1";
      }

      if (this.ZG == 1 && this.Zf == 1 && this.tR == 4) {
         var1 = "Preliminar R2";
      }

      return this.fh(this.Zf) ? var1 + " - " + Integer.toString(var4) + "º jogo" : var1;
   }

   @Override
   public String getNome() {
      if (this.nS != null) {
         return this.nS.getNome();
      } else {
         return this.YY != null ? this.YY.getNome() : null;
      }
   }

   @Override
   public String is() {
      return this.nS != null ? this.nS.is() : null;
   }

   public boolean[] zz() {
      return this.ZK;
   }

   public boolean zA() {
      return this.nS != null && this.tR == 3 && this.nS instanceof LeagueStage && this.nS.zd() == 1;
   }

   public boolean U(Club club) {
      for (int var2 = this.zp().size() - 1; var2 >= 0; var2--) {
         for (int var3 = 0; var3 < ((KnockoutRound)this.zp().get(var2)).zW().size(); var3++) {
            if (((Match)((KnockoutRound)this.zp().get(var2)).zW().get(var3)).getHomeClub() == club || ((Match)((KnockoutRound)this.zp().get(var2)).zW().get(var3)).getAwayClub() == club) {
               return true;
            }
         }
      }

      return false;
   }

   public void z(Competition c0713) {
      ArrayList var2 = new ArrayList();
      int var3 = 0;
      int var4 = 1;

      for (int var5 = this.zp().size() - 1; var5 >= 0; var5--) {
         for (int var6 = 0; var6 < ((KnockoutRound)this.zp().get(var5)).zW().size(); var6++) {
            Club var7 = null;
            Club var8 = null;
            if (((KnockoutRound)this.zp().get(var5)).zY().contains(((Match)((KnockoutRound)this.zp().get(var5)).zW().get(var6)).getHomeClub())) {
               var7 = ((Match)((KnockoutRound)this.zp().get(var5)).zW().get(var6)).getHomeClub();
               var8 = ((Match)((KnockoutRound)this.zp().get(var5)).zW().get(var6)).getAwayClub();
            } else if (((KnockoutRound)this.zp().get(var5)).zY().contains(((Match)((KnockoutRound)this.zp().get(var5)).zW().get(var6)).getAwayClub())) {
               var7 = ((Match)((KnockoutRound)this.zp().get(var5)).zW().get(var6)).getAwayClub();
               var8 = ((Match)((KnockoutRound)this.zp().get(var5)).zW().get(var6)).getHomeClub();
            }

            if (!var2.contains(var7)) {
               var2.add(var7);
               var7.a(c0713, var4, var3);
               var4++;
            }

            if (!var2.contains(var8)) {
               var2.add(var8);
               var8.a(c0713, var4, var3);
               var4++;
            }
         }

         var3++;
      }
   }

   public String[] zB() {
      if (this.zf() == 1068) {
         return GameConstants.pX;
      } else if (this.zf() == 6006) {
         return GameConstants.abY;
      } else if (this.ZG == 6) {
         return GameConstants.px;
      } else if (this.ZG == 5) {
         return GameConstants.py;
      } else if (this.ZG == 4) {
         return GameConstants.pz;
      } else if (this.ZG == 3) {
         return GameConstants.pA;
      } else if (this.ZG == 2) {
         return GameConstants.pB;
      } else if (this.ZG == 1) {
         return GameConstants.pC;
      } else {
         return this.ZG == 0 ? GameConstants.pD : GameConstants.ps;
      }
   }
}
