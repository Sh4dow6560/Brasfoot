package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0480 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0480(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.careerState.setHabilidadeIndividual(C0419.i(this.MA).isSelected());
      GamePersistence.getOptions().setHabilidadeIndividual(C0419.i(this.MA).isSelected());
      GamePersistence.saveOptions();
   }
}
