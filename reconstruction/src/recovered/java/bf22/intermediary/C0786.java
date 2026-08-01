package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import mod.recovered.model.Club;

public class C0786 {
   private boolean Or = false;
   private int ae = 0;
   private Club cg = null;
   private int T = 0;
   private int bX = 0;
   private int d = 0;
   private int nK = 0;
   private int nL = 0;
   private String Rg = "";
   private String Rh = "";
   private String Px = "";
   private boolean nP = false;
   private boolean nQ = false;
   private int nO = -1;
   private boolean nR = false;

   public boolean tt() {
      return this.Or;
   }

   public void ar(boolean bl) {
      this.Or = bl;
   }

   public int H() {
      return this.ae;
   }

   public String uD() {
      return Integer.toString(this.ae + GamePersistence.careerState.getSeasonYearOffset());
   }

   public void k(int i) {
      this.ae = i;
   }

   public Club fg() {
      return this.cg;
   }

   public void n(Club club) {
      this.cg = club;
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

   public String uE() {
      return this.Rg;
   }

   public void T(String string) {
      this.Rg = string;
   }

   public int uF() {
      return this.T - (this.bX + this.d);
   }

   public String uG() {
      return this.Rh;
   }

   public void U(String string) {
      this.Rh = string;
   }

   public String tZ() {
      return this.Px;
   }

   public void M(String string) {
      this.Px = string;
   }

   public boolean lx() {
      return this.nP;
   }

   public void aB(boolean bl) {
      this.nP = bl;
   }

   public boolean ly() {
      return this.nQ;
   }

   public void aC(boolean bl) {
      this.nQ = bl;
   }

   public int lw() {
      return this.nO;
   }

   public void ce(int i) {
      this.nO = i;
   }

   public boolean lz() {
      return this.nR;
   }

   public void aD(boolean bl) {
      this.nR = bl;
   }
}
