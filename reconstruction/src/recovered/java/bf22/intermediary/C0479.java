package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0479 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0479(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.SR.setHabilidadeIndividual(C0419.i(this.MA).isSelected());
      GamePersistence.vM().setHabilidadeIndividual(C0419.i(this.MA).isSelected());
      GamePersistence.vJ();
   }
}
