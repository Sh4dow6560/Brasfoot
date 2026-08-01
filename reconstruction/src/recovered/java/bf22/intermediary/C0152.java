package bf22.intermediary;

import java.util.TimerTask;

class C0152 extends TimerTask {
   final bf22.intermediary.C0151 DV;
   C0152(C0151 c0151) {
      this.DV = c0151;
   }

   @Override
   public void run() {
      C0151.ph().cancel();
      C0745.SR.V();
   }
}
