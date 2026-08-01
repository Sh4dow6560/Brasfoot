package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0819 implements ActionListener {
   final bf22.intermediary.C0818 Pc;
   C0819(C0818 c0818) {
      this.Pc = c0818;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Pc.Oy.qR();
   }
}
