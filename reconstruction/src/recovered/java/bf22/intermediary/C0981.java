package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0981 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   C0981(C0971 c0971) {
      this.Xb = c0971;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0732.cV();
      C0732.cW();
      C0971.b(this.Xb).setVisible(false);
   }
}
