package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0163 implements ActionListener {
   final bf22.intermediary.C0102 BP;
   C0163(C0102 c0102) {
      this.BP = c0102;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0102.b(this.BP);
   }
}
