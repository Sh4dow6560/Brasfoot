package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0134 implements ActionListener {
   final bf22.intermediary.C0185 Da;
   C0134(C0185 c0185) {
      this.Da = c0185;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0185.a(this.Da).dispose();
   }
}
