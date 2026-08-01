package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0482 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0482(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.careerState.bi();
      C0419.a(this.MA).addNotify();
   }
}
