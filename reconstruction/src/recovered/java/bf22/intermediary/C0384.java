package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0384 implements ActionListener {
   final bf22.intermediary.C0383 JZ;
   C0384(C0383 c0383) {
      this.JZ = c0383;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0383.a(this.JZ).setVisible(false);
   }
}
