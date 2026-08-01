package bf22.intermediary;

import java.util.TimerTask;

class C0116 extends TimerTask {
   final bf22.intermediary.C0113 zT;
   C0116(C0113 c0113) {
      this.zT = c0113;
   }

   @Override
   public void run() {
      C0113.b(this.zT).cancel();
      this.zT.nL();
   }
}
