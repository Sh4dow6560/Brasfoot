package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.io.Serializable;

public class C0719 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int g = 0;
   private int T = 0;
   private String n = null;

   public C0719() {
   }

   public C0719(String string, int i, int j) {
      this.n = string;
      this.g = i;
      this.T = j;
      GamePersistence.SR.bJ().add(this);
   }

   public int v() {
      return this.g;
   }

   public void g(int i) {
      this.g = i;
   }

   public int w() {
      return this.T;
   }

   public void h(int i) {
      this.T = i;
   }

   public String getN() {
      return this.n;
   }

   public void setN(String string) {
      this.n = string;
   }
}
