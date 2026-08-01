package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0524 implements ActionListener {
   final bf22.intermediary.C0475 Nj;
   C0524(C0475 c0475) {
      this.Nj = c0475;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0475.c(this.Nj);
   }
}
