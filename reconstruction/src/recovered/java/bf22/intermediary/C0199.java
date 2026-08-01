package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0199 implements ActionListener {
   final bf22.intermediary.C0197 GK;
   C0199(C0197 c0197) {
      this.GK = c0197;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0197.a(this.GK, (Integer)C0197.a(this.GK).getSelectedItem(), false);
   }
}
