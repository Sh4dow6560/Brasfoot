package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0749 implements ActionListener {
   final bf22.intermediary.C0748 PA;
   C0749(C0748 c0748) {
      this.PA = c0748;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0748.a(this.PA).dispose();
   }
}
