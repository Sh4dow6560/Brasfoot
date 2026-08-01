package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0224 implements ActionListener {
   final bf22.intermediary.C0223 Fm;
   C0224(C0223 c0223) {
      this.Fm = c0223;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0223.a(this.Fm).dispose();
   }
}
