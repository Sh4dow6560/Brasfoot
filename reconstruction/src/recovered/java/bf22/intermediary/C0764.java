package bf22.intermediary;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class C0764 implements ChangeListener {
   final bf22.intermediary.C0762 QR;
   C0764(C0762 c0762) {
      this.QR = c0762;
   }

   @Override
   public void stateChanged(ChangeEvent changeEvent) {
      C0781 var2 = (C0781)changeEvent.getSource();
      this.QR.um();
   }
}
