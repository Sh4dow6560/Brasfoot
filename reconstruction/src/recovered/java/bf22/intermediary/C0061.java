package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0061 implements ActionListener {
   final bf22.intermediary.C0054 wq;
   C0061(C0054 c0054) {
      this.wq = c0054;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0054.d(this.wq).getSelectedIndex() >= 0) {
         C0054.c(this.wq, C0054.d(this.wq).getSelectedIndex());
      }
   }
}
