package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0905 implements ActionListener {
   final bf22.intermediary.C0901 Vh;
   C0905(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      System.exit(0);
   }
}
