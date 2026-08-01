package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0979 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   C0979(C0971 c0971) {
      this.Xb = c0971;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0734.dg();
      C0734.dh();
      GamePersistence.careerState.az();
   }
}
