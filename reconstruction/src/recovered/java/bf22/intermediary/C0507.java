package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0507 implements ActionListener {
   final bf22.intermediary.C0545 afy;
   C0507(C0545 c0545) {
      this.afy = c0545;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0545.e(this.afy);
   }
}
