package bf22.intermediary;

public class C0790 {
   private String[] Rl = new String[9];
   private String[] Rm = new String[9];
   private int[] Rn = new int[9];

   public String[] uL() {
      return this.Rl;
   }

   public String dX(int i) {
      return this.Rl[i];
   }

   public void d(String string, int i) {
      this.Rl[i] = string;
   }

   public String[] uM() {
      return this.Rm;
   }

   public String dY(int i) {
      return this.Rm[i];
   }

   public void e(String string, int i) {
      this.Rm[i] = string;
   }

   public int[] uN() {
      return this.Rn;
   }

   public int dZ(int i) {
      return this.Rn[i];
   }

   public void R(int i, int j) {
      this.Rn[j] = i;
   }
}
