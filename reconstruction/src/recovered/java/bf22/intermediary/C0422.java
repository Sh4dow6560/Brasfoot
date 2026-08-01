package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0422 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0422(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.careerState.setJogaRegionais(C0419.f(this.MA).isSelected());
      GamePersistence.getOptions().setJogaRegionais(C0419.f(this.MA).isSelected());
      GamePersistence.saveOptions();
   }
}
