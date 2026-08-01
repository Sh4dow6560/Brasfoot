package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0103 implements ActionListener {
   final bf22.intermediary.C0102 BP;
   C0103(C0102 c0102) {
      this.BP = c0102;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.BP.os();
   }
}
