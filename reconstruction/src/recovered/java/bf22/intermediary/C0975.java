package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0975 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   C0975(C0971 c0971) {
      this.Xb = c0971;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      int var2 = 0;
      int var3 = 1;
      C0971.a(this.Xb);
      GamePersistence.careerState.aO(true);

      for (; GamePersistence.careerState.getSeasonNumber() < 1 || !((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(342)).e() && !GamePersistence.careerState.bN; GamePersistence.careerState.V()) {
         var2 = GamePersistence.careerState.getSeasonNumber();
         if (var3 != var2) {
            var3 = var2;
            System.out.println("ano: " + Integer.toString(var2));
         }
      }

      System.out.println("done");
   }
}
