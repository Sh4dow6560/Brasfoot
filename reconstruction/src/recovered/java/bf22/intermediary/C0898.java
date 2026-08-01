package bf22.intermediary;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class C0898 implements ChangeListener {
   final bf22.intermediary.C0893 Ut;
   C0898(C0893 c0893) {
      this.Ut = c0893;
   }

   @Override
   public void stateChanged(ChangeEvent changeEvent) {
      C0893.g(this.Ut).setText(Integer.toString(C0893.h(this.Ut).getValue()));
   }
}
