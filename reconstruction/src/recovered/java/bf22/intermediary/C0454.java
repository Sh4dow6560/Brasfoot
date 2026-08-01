package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0454 implements ActionListener {
   final bf22.intermediary.C0452 MV;
   C0454(C0452 c0452) {
      this.MV = c0452;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0452.g(this.MV);
   }
}
