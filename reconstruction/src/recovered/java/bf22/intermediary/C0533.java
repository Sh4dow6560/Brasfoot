package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0533 implements ActionListener {
   final bf22.intermediary.C0532 Ns;
   C0533(C0532 c0532) {
      this.Ns = c0532;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0532.a(this.Ns).dispose();
   }
}
