package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0222 implements ActionListener {
   final bf22.intermediary.C0221 Fi;
   C0222(C0221 c0221) {
      this.Fi = c0221;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0221.a(this.Fi).dispose();
   }
}
