package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0448 implements ActionListener {
   final bf22.intermediary.C0447 Ly;
   C0448(C0447 c0447) {
      this.Ly = c0447;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0447.a(this.Ly).dispose();
   }
}
