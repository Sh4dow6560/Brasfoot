package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0135 implements ActionListener {
   final bf22.intermediary.C0185 Da;
   C0135(C0185 c0185) {
      this.Da = c0185;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0185.b(this.Da);
   }
}
