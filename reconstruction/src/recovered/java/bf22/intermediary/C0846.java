package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0846 implements ActionListener {
   final bf22.intermediary.C0901 Vh;
   C0846(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Vh.wB();
   }
}
