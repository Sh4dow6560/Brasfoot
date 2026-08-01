package bf22.intermediary;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class C0028 implements ItemListener {
   final bf22.intermediary.C0078 yi;
   C0028(C0078 c0078) {
      this.yi = c0078;
   }

   @Override
   public void itemStateChanged(ItemEvent itemEvent) {
      if (itemEvent.getStateChange() == 1 && !this.yi.wZ) {
         C0078.d(this.yi, C0078.c(this.yi).getSelectedIndex());
      }
   }
}
