package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0310 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0310(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.vM().setIgnoraLigas(C0294.n(this.JH).isSelected());
      C0745.vJ();
   }
}
