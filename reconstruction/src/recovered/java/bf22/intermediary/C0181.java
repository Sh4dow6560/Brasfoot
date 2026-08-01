package bf22.intermediary;

import mod.recovered.core.GameConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0181 implements ActionListener {
   final bf22.intermediary.C0180 CO;
   C0181(C0180 c0180) {
      this.CO = c0180;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      int var2 = GameConstants.sL[C0180.a(this.CO).getSelectedIndex()][0];
      C0180.a(this.CO, C0180.a(this.CO).getSelectedIndex());
      C0180.b(this.CO).J(C0180.c(this.CO), var2);
      C0180.b(this.CO).oJ();
   }
}
