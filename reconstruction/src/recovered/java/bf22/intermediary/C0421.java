package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0421 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0421(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      GamePersistence.SR.setJogaEstadual(C0419.e(this.MA).isSelected());
      GamePersistence.vM().setJogaEstadual(C0419.e(this.MA).isSelected());
      GamePersistence.vJ();
   }
}
