package bf22.intermediary;

import java.io.Serializable;

public class C0788 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int clubId = -1;
   private int nT = 0;
   private int T = 0;
   private int bX = 0;
   private int d = 0;
   private int nK = 0;
   private int nL = 0;

   public C0788() {
   }

   public C0788(C0704 c0704, int i) {
      this.clubId = i;
      if (c0704 != null) {
         this.nT = c0704.lD();
         this.T = c0704.w();
         this.bX = c0704.cm();
         this.d = c0704.co();
         this.nK = c0704.ls();
         this.nL = c0704.lt();
      }
   }

   public void lA() {
      this.nT = 0;
      this.T = 0;
      this.bX = 0;
      this.d = 0;
      this.nK = 0;
      this.nL = 0;
   }

   public int getClubId() {
      return this.clubId;
   }

   public void bX(int i) {
      this.clubId = i;
   }

   public int lD() {
      return this.nT;
   }

   public void dW(int i) {
      this.nT = i;
   }

   public int w() {
      return this.T;
   }

   public void h(int i) {
      this.T = i;
   }

   public int cm() {
      return this.bX;
   }

   public void dS(int i) {
      this.bX = i;
   }

   public int co() {
      return this.d;
   }

   public void dT(int i) {
      this.d = i;
   }

   public int ls() {
      return this.nK;
   }

   public void dU(int i) {
      this.nK = i;
   }

   public int lt() {
      return this.nL;
   }

   public void dV(int i) {
      this.nL = i;
   }
}
