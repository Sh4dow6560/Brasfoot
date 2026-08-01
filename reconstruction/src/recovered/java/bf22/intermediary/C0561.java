package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0561 implements ActionListener {
   final bf22.intermediary.C0554 vj;
   C0561(C0554 c0554) {
      this.vj = c0554;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0554.a(this.vj).getSelectedIndex() >= 0) {
         C0554.b(this.vj, C0554.a(this.vj).getSelectedIndex());
      }
   }
}
