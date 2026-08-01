package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0487 implements ActionListener {
   final bf22.intermediary.C0419 MA;
   C0487(C0419 c0419) {
      this.MA = c0419;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.SR.setJogaIntClubes(C0419.c(this.MA).isSelected());
      C0745.vM().setJogaIntClubes(C0419.c(this.MA).isSelected());
      C0745.vJ();
   }
}
