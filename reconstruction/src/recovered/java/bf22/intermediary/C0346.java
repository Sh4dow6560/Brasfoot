package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0346 implements ListSelectionListener {
   final bf22.intermediary.C0395 Kg;
   C0346(C0395 c0395) {
      this.Kg = c0395;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0395.c(this.Kg).getSelectedRow() >= 0) {
         int var2 = C0395.c(this.Kg).convertRowIndexToModel(C0395.c(this.Kg).getSelectedRow());
         ((C0569)C0395.c(this.Kg).getModel()).et(var2);
      }
   }
}
