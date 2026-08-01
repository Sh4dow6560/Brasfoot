package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0177 implements ActionListener {
   final bf22.intermediary.C0176 CE;
   C0177(C0176 c0176) {
      this.CE = c0176;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0176.a(this.CE).dispose();
   }
}
