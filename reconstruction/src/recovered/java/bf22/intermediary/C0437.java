package bf22.intermediary;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0437 implements ActionListener {
   final bf22.intermediary.C0435 Lt;
   C0437(C0435 c0435) {
      this.Lt = c0435;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0435.e(this.Lt).setCursor(new Cursor(3));
      C0685.a(null, C0435.f(this.Lt), 0);
      C0435.e(this.Lt).setCursor(new Cursor(12));
   }
}
