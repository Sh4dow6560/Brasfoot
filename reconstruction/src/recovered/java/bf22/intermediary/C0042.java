package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0042 implements ActionListener {
   final bf22.intermediary.C0039 yJ;
   C0042(C0039 c0039) {
      this.yJ = c0039;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0039.b(this.yJ).getSelectedIndex() >= 0) {
         C0039.b(this.yJ, false);
      }
   }
}
