package bf22.intermediary;

import bf22.intermediary.CareerInitializer;
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
      CareerInitializer.initializeNewCareer();
      CareerInitializer.initializeRegionalCups();
      GamePersistence.careerState.az();
   }
}
