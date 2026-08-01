package bf22.intermediary;

import java.util.TimerTask;

class C0138 extends TimerTask {
   final bf22.intermediary.C0137 DI;
   C0138(C0137 c0137) {
      this.DI = c0137;
   }

   @Override
   public void run() {
      C0137.ph().cancel();
      C0137.a(this.DI);
   }
}
