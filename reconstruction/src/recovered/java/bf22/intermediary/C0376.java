package bf22.intermediary;

import java.util.TimerTask;

class C0376 extends TimerTask {
   final bf22.intermediary.C0373 JV;
   C0376(C0373 c0373) {
      this.JV = c0373;
   }

   @Override
   public void run() {
      C0373.a(this.JV).cancel();
      C0373.b(this.JV);
   }
}
