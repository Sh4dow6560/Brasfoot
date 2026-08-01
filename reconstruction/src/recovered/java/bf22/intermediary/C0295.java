package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0295 implements ActionListener {
   final bf22.intermediary.C0294 JH;
   C0295(C0294 c0294) {
      this.JH = c0294;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0294.a(this.JH);
      C0294.b(this.JH).dispose();
   }
}
