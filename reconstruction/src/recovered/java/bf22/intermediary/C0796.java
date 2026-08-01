package bf22.intermediary;

import mod.recovered.competition.CompetitionSeasonResult;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0796 {
   private int ae;
   private int RN = -1;
   private int V;
   private Club RO = null;
   private Club RP = null;
   private Club RQ = null;
   private String RR = "";
   private Coach RS = null;
   private boolean Or;
   private CountryCompetitions RT = null;
   private boolean afN = false;

   public C0796(CompetitionSeasonResult c0727, int i, int j) {
      this.RN = i;
      if (c0727 != null) {
         this.ae = c0727.H();
         this.RO = c0727.ce();
         this.RP = c0727.cf();
         this.RQ = c0727.ch();
         this.RR = c0727.cg();
         this.RS = c0727.ci();
         this.V = c0727.y();
      } else {
         this.RT = GamePersistence.careerState.o(i);
         this.Or = true;
      }
   }

   public Coach ci() {
      return this.RS;
   }

   public Club ce() {
      return this.RO;
   }

   public Club cf() {
      return this.RP;
   }

   public String cg() {
      return this.RR;
   }

   public Club ch() {
      return this.RQ;
   }

   public int H() {
      return this.ae;
   }

   public void k(int i) {
      this.ae = i;
   }

   public int y() {
      return this.V;
   }

   public void ek(int i) {
      this.V = i;
   }

   public boolean tt() {
      return this.Or;
   }

   public void ar(boolean bl) {
      this.Or = bl;
   }

   public int vk() {
      return this.RN;
   }

   public void el(int i) {
      this.RN = i;
   }

   public CountryCompetitions vl() {
      return this.RT;
   }

   public void f(CountryCompetitions c0692) {
      this.RT = c0692;
   }
}
