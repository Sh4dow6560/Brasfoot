package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0040 implements ActionListener {
   final bf22.intermediary.C0039 yJ;
   C0040(C0039 c0039) {
      this.yJ = c0039;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0039.a(this.yJ).dispose();
   }
}
