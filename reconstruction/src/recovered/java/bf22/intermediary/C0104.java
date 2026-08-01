package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0104 implements ActionListener {
   final bf22.intermediary.C0102 BP;
   C0104(C0102 c0102) {
      this.BP = c0102;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0102.a(this.BP);
   }
}
