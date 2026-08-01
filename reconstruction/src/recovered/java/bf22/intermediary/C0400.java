package bf22.intermediary;

public class C0400 extends Thread {
   final bf22.intermediary.C0450 LA;
   public C0400(C0450 c0450) {
      this.LA = c0450;
   }

   @Override
   public void run() {
      this.LA.sh();
   }
}
