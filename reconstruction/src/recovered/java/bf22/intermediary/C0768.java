package bf22.intermediary;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class C0768 implements ChangeListener {
   final bf22.intermediary.C0762 QR;
   C0768(C0762 c0762) {
      this.QR = c0762;
   }

   @Override
   public void stateChanged(ChangeEvent changeEvent) {
      this.QR.um();
   }
}
