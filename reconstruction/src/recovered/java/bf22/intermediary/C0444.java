package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0444 implements ActionListener {
   final bf22.intermediary.C0435 Lt;
   C0444(C0435 c0435) {
      this.Lt = c0435;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0435.a(this.Lt);
   }
}
