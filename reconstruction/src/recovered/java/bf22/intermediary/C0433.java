package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0433 implements ActionListener {
   final bf22.intermediary.C0427 KL;
   C0433(C0427 c0427) {
      this.KL = c0427;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0427.a(this.KL, C0427.d(this.KL).getSelectedIndex());
   }
}
