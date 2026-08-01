package bf22.intermediary;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class C0896 implements ItemListener {
   final bf22.intermediary.C0893 Ut;
   C0896(C0893 c0893) {
      this.Ut = c0893;
   }

   @Override
   public void itemStateChanged(ItemEvent itemEvent) {
      C0732.da().aM(C0893.c(this.Ut).isSelected());
   }
}
