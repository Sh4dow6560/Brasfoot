package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0001 implements ActionListener {
   final bf22.intermediary.C0564 vo;
   C0001(C0564 c0564) {
      this.vo = c0564;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0564.a(this.vo);
   }
}
