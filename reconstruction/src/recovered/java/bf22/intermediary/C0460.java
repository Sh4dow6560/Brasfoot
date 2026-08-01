package bf22.intermediary;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class C0460 extends AbstractAction {
   final bf22.intermediary.C0452 MV;
   C0460(C0452 c0452) {
      this.MV = c0452;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0452.a(this.MV).dispose();
   }
}
