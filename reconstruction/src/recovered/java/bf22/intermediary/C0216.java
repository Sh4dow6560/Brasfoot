package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0216 implements ActionListener {
   final bf22.intermediary.C0213 El;
   C0216(C0213 c0213) {
      this.El = c0213;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0213.c(this.El);
   }
}
