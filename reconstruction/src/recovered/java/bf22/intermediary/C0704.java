package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Club;

public class C0704 implements Serializable {
   private static final long serialVersionUID = 1L;
   private C0955 nS = null;
   private int nT = 0;
   private int T = 0;
   private int bX = 0;
   private int d = 0;
   private int nK = 0;
   private int nL = 0;

   public C0704() {
   }

   public void lA() {
      this.nT = 0;
      this.T = 0;
      this.bX = 0;
      this.d = 0;
      this.nK = 0;
      this.nL = 0;
   }

   public C0704(Club club, C0955 c0955) {
      this.nS = c0955;
   }

   public void a(C0788 c0788) {
      this.nT = this.nT + c0788.lD();
      this.T = this.T + c0788.w();
      this.bX = this.bX + c0788.cm();
      this.d = this.d + c0788.co();
      this.nK = this.nK + c0788.ls();
      this.nL = this.nL + c0788.lt();
   }

   public int[] lB() {
      return new int[]{this.nT, this.T, this.bX, this.T - (this.bX + this.d), this.d, this.nK, this.nL, this.nK - this.nL};
   }

   public C0955 lC() {
      return this.nS;
   }

   public void f(C0955 c0955) {
      this.nS = c0955;
   }

   public int lD() {
      return this.nT;
   }

   public void cf(int i) {
      this.nT += i;
   }

   public int w() {
      return this.T;
   }

   public void cl() {
      this.T++;
   }

   public int co() {
      return this.d;
   }

   public void cp() {
      this.d++;
   }

   public int cm() {
      return this.bX;
   }

   public void cn() {
      this.bX++;
   }

   public int lt() {
      return this.nL;
   }

   public void cb(int i) {
      this.nL += i;
   }

   public int ls() {
      return this.nK;
   }

   public void ca(int i) {
      this.nK += i;
   }
}
