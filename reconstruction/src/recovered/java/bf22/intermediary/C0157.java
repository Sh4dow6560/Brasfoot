package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0157 implements ActionListener {
   final bf22.intermediary.C0156 Ee;
   C0157(C0156 c0156) {
      this.Ee = c0156;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0156.a(this.Ee).dispose();
   }
}
