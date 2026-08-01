package bf22.intermediary;

import java.util.TimerTask;

class C0381 extends TimerTask {
   final bf22.intermediary.C0379 JW;
   C0381(C0379 c0379) {
      this.JW = c0379;
   }

   @Override
   public void run() {
      C0379.rL().cancel();
      C0379.b(this.JW);
   }
}
