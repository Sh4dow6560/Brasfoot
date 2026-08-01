package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0270 implements ActionListener {
   final bf22.intermediary.C0208 Hu;
   C0270(C0208 c0208) {
      this.Hu = c0208;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.Hu.qa();
   }
}
