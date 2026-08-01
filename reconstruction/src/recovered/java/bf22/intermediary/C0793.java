package bf22.intermediary;

import java.io.Serializable;

public class C0793 implements Serializable {
   private static final long serialVersionUID = 1L;
   private int Rw;
   private int Rx;
   private boolean Ry = false;

   public C0793(String string, int i, int j) {
      this.Rw = i;
      this.Rx = j;
   }

   public C0793(String string, int i, int j, boolean bl) {
      this.Rw = i;
      this.Rx = j;
      this.Ry = bl;
   }

   public C0793() {
   }

   public int uW() {
      return this.Rw;
   }

   public int uX() {
      return this.Rx;
   }

   public boolean uY() {
      return this.Ry;
   }

   public void fE(int i) {
      this.Rw = i;
   }
}
