package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0032 implements ActionListener {
   final bf22.intermediary.C0078 yi;
   C0032(C0078 c0078) {
      this.yi = c0078;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0078.b(this.yi, 1);
   }
}
