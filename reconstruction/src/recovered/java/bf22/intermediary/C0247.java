package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0247 implements ActionListener {
   final bf22.intermediary.C0272 Iz;
   C0247(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         C0272.a(this.Iz, 2);
      } else {
         C0272.a(this.Iz, 1);
      }
   }
}
