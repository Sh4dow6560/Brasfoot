package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0544 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0544(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.vM().setIgnoraEstadual(C0294.o(this.JH).isSelected());
      C0745.vJ();
   }
}
