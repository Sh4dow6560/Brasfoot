package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0307 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0307(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.vM().setNegritoCasa(C0294.j(this.JH).isSelected());
      C0745.vJ();
   }
}
