package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0466 implements ActionListener {
   final bf22.intermediary.C0452 MV;
   C0466(C0452 c0452) {
      this.MV = c0452;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0452.e(this.MV);
   }
}
