package bf22.intermediary;

import mod.recovered.model.Club;

public class C0784 {
   private Club club = null;
   private int w = 0;
   private int[] Re = new int[3];
   private int Rf;

   public Club getClub() {
      return this.club;
   }

   public void setClub(Club club) {
      this.club = club;
   }

   public int b() {
      return this.w;
   }

   public void a(int i) {
      this.w = i;
   }

   public int uy() {
      return this.Re[0];
   }

   public int uz() {
      return this.Re[1];
   }

   public int uA() {
      return this.Re[2];
   }

   public void dQ(int i) {
      this.Re[0] = i;
   }

   public int[] uB() {
      return this.Re;
   }

   public void m(int[] is) {
      this.Re = is;
   }

   public int uC() {
      return this.Rf;
   }

   public void dR(int i) {
      this.Rf = i;
   }
}
