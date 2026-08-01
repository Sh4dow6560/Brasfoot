package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0233 implements ActionListener {
   final bf22.intermediary.C0231 FS;
   C0233(C0231 c0231) {
      this.FS = c0231;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0231.b(this.FS).dispose();
   }
}
