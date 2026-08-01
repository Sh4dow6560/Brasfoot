package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0506 implements ActionListener {
   final bf22.intermediary.C0545 afy;
   C0506(C0545 c0545) {
      this.afy = c0545;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0545.d(this.afy);
   }
}
