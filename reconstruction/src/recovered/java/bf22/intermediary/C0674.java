package bf22.intermediary;

import mod.recovered.competition.Competition;
import java.io.Serializable;
import mod.recovered.model.Player;

public class C0674 implements Serializable {
   private static final long serialVersionUID = 1L;
   private transient Competition Y = null;
   private int ft = -1;
   private int ca;
   private int cb;
   private int T;
   private int V;
   private int cc;
   private double fu = 0.0;
   private int fv = 0;

   public C0674() {
   }

   public C0674(Player player, Competition c0713) {
      this.Y = c0713;
   }

   public void i(double d) {
      this.fv++;
      this.fu += d;
   }

   public Competition gS() {
      return this.Y;
   }

   public void m(Competition c0713) {
      this.Y = c0713;
   }

   public boolean gT() {
      return this.ca >= 3 || this.cb >= 1;
   }

   public void gU() {
      if (this.ca >= 3) {
         this.ca = 0;
      } else if (this.cb >= 1) {
         this.cb--;
      }
   }

   public void z() {
      this.V++;
   }

   public void gV() {
      this.cc++;
   }

   public void cl() {
      this.T++;
   }

   public void cz() {
      this.ca++;
   }

   public void cA() {
      this.cb++;
   }

   public void cB() {
      this.ca++;
      this.cb++;
   }

   public int[] gW() {
      return new int[]{this.ca, this.cb};
   }

   public int w() {
      return this.T;
   }

   public int y() {
      return this.V;
   }

   public int gX() {
      return this.ft;
   }

   public void gY() {
      if (this.Y != null && this.Y.gD() >= 0) {
         this.ft = this.Y.gD();
      }
   }

   public int cD() {
      return this.cc;
   }

   public void E(int i) {
      this.cc = i;
   }

   public double F() {
      return this.fv > 0 ? this.fu / this.fv : 0.0;
   }

   public int gZ() {
      return this.fv;
   }
}
