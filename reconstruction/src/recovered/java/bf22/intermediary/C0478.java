package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0478 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0478(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.SR.setUsarGruposReaisCopa(C0419.h(this.MA).isSelected());
      C0745.vM().setUsarGruposReaisCopa(C0419.h(this.MA).isSelected());
      C0745.vJ();
   }
}
