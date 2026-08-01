package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.util.TimerTask;

class C0439 extends TimerTask {
   final bf22.intermediary.C0435 Lt;
   C0439(C0435 c0435) {
      this.Lt = c0435;
   }

   @Override
   public void run() {
      C0435.ph().cancel();
      GamePersistence.careerState.ax();
   }
}
