package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0557 implements ActionListener {
   final bf22.intermediary.C0554 vj;
   C0557(C0554 c0554) {
      this.vj = c0554;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0554.a(this.vj, 1);
   }
}
