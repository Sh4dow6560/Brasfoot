package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0467 extends MouseAdapter {
   final bf22.intermediary.C0452 MV;
   C0467(C0452 c0452) {
      this.MV = c0452;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0452.f(this.MV);
   }
}
