package bf22.intermediary;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0201 implements ActionListener {
   final bf22.intermediary.C0200 GR;
   C0201(C0200 c0200) {
      this.GR = c0200;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0200.a(this.GR).setCursor(new Cursor(3));
      C0200.b(this.GR);
   }
}
