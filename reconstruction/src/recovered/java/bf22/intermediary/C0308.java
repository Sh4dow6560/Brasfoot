package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0308 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0308(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0745.vM().setUsaCoresLista(C0294.k(this.JH).isSelected());
      C0745.vJ();
      if (C0294.l(this.JH) != null) {
         C0294.l(this.JH).addNotify();
      }
   }
}
