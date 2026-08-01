package bf22.intermediary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class C0214 extends MouseAdapter {
   final bf22.intermediary.C0213 El;
   C0214(C0213 c0213) {
      this.El = c0213;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      C0213.a(this.El);
   }
}
