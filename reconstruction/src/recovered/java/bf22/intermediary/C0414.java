package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0414 implements ActionListener {
   final bf22.intermediary.C0404 Ma;
   C0414(C0404 c0404) {
      this.Ma = c0404;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0404.a(this.Ma).dispose();
   }
}
