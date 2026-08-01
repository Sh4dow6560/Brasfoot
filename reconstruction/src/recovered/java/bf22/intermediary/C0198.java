package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0198 implements ActionListener {
   final bf22.intermediary.C0197 GK;
   C0198(C0197 c0197) {
      this.GK = c0197;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.GK.di((Integer)C0197.a(this.GK).getSelectedItem());
      C0197.b(this.GK).J(C0197.c(this.GK), (Integer)C0197.a(this.GK).getSelectedItem());
      C0197.b(this.GK).oJ();
   }
}
