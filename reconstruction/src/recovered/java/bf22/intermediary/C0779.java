package bf22.intermediary;

import java.io.Serializable;
import mod.recovered.model.Club;

public class C0779 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int id;
   private int d;
   private Club SC = null;
   private int c;

   public C0779() {
   }

   public C0779(int i, int j, Club club, int k) {
      this.id = i;
      this.d = j;
      this.SC = club;
      this.c = k;
   }

   public int getEstado() {
      return this.id;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int i) {
      this.id = i;
   }

   public int co() {
      return this.d;
   }

   public void dT(int i) {
      this.d = i;
   }

   public Club vD() {
      return this.SC;
   }

   public void J(Club club) {
      this.SC = club;
   }

   public int vE() {
      return this.c;
   }

   public void er(int i) {
      this.c = i;
   }
}
