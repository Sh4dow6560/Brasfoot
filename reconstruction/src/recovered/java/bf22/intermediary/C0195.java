package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0195 implements ActionListener {
   final bf22.intermediary.C0193 Gu;
   C0195(C0193 c0193) {
      this.Gu = c0193;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0193.a(this.Gu).dispose();
   }
}
