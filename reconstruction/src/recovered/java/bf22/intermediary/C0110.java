package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0110 implements ActionListener {
   final bf22.intermediary.C0108 zy;
   C0110(C0108 c0108) {
      this.zy = c0108;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0108.b(this.zy).dispose();
   }
}
