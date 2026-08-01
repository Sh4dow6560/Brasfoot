package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0002 implements ActionListener {
   final bf22.intermediary.C0564 vo;
   C0002(C0564 c0564) {
      this.vo = c0564;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0564.b(this.vo).dispose();
   }
}
