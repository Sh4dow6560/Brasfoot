package bf22.intermediary;

import mod.recovered.match.MatchEvent;
import mod.recovered.match.Match;
public class C0827 {
   private Match zz;
   private String Pp = "";
   private int Pq = 0;
   private int Pr = 0;
   private MatchEvent Ps = null;
   private boolean Pt = false;
   private int Pu = 0;
   private String gq = null;
   private static Double Pv = 36.0;

   public Match tR() {
      return this.zz;
   }

   public void n(Match c0675) {
      this.zz = c0675;
      if (c0675.getHomeClub().isUserControlled() || c0675.getAwayClub().isUserControlled()) {
         this.Pt = true;
      }
   }

   public String tS() {
      return this.Pp;
   }

   public void L(String string) {
      this.Pp = string;
   }

   public int tT() {
      return this.Pq;
   }

   public void dJ(int i) {
      if (i == 1) {
         this.Pq++;
      } else if (i == 2) {
         this.Pr++;
      }
   }

   public int tU() {
      return this.Pr;
   }

   public MatchEvent tV() {
      return this.Ps;
   }

   public void a(MatchEvent c0667) {
      this.Ps = c0667;
   }

   public boolean ei() {
      return this.Pt;
   }

   public int hU() {
      return this.Pu;
   }

   public void tW() {
      if (this.zz != null) {
         this.Pu = this.zz.hU();
      }
   }

   public String ik() {
      return this.gq;
   }

   public void p(String string) {
      if (this.zz != null) {
         this.zz.p(string);
      }

      this.gq = string;
   }

   public static void b(Double double_) {
      Pv = double_;
   }

   public static Double tX() {
      return Pv;
   }
}
