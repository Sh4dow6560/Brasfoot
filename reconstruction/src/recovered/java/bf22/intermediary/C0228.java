package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0228 implements ActionListener {
   final bf22.intermediary.C0227 FF;
   C0228(C0227 c0227) {
      this.FF = c0227;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      this.FF.nH();
   }
}
