package bf22.intermediary;

import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0813 {
   private Club club = null;
   private Coach Oi = null;
   private Coach Oj = null;
   private int Fp = 1;

   public C0813(Club club, Coach coach, Coach coach2, int i) {
      this.club = club;
      this.Oi = coach;
      this.Oj = coach2;
      this.Fp = i;
   }

   public Club getClub() {
      return this.club;
   }

   public void setClub(Club club) {
      this.club = club;
   }

   public Coach tj() {
      return this.Oi;
   }

   public void j(Coach coach) {
      this.Oi = coach;
   }

   public Coach tk() {
      return this.Oj;
   }

   public void k(Coach coach) {
      this.Oj = coach;
   }

   public int tl() {
      return this.Fp;
   }

   public void dH(int i) {
      this.Fp = i;
   }
}
