package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0305 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0305(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.vM().setUsaSons(C0294.i(this.JH).isSelected());
      C0745.vJ();
   }
}
