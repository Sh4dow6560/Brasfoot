package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0900 implements ActionListener {
   final bf22.intermediary.C0893 Ut;
   C0900(C0893 c0893) {
      this.Ut = c0893;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0893.b(this.Ut);
   }
}
