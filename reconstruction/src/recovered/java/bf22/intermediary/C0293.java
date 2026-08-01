package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0293 implements ActionListener {
   final bf22.intermediary.C0343 IF;
   C0293(C0343 c0343) {
      this.IF = c0343;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0343.b(this.IF);
   }
}
