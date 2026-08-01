package bf22.intermediary;

import java.util.TimerTask;

class C0117 extends TimerTask {
   final bf22.intermediary.C0113 zT;
   C0117(C0113 c0113) {
      this.zT = c0113;
   }

   @Override
   public void run() {
      C0113.b(this.zT).cancel();
      C0113.c(this.zT);
   }
}
