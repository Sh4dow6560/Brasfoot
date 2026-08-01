package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0382 implements ListSelectionListener {
   final bf22.intermediary.C0379 JW;
   C0382(C0379 c0379) {
      this.JW = c0379;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0379.c(this.JW).getSelectedRow() >= 0) {
         int var2 = C0379.c(this.JW).convertRowIndexToModel(C0379.c(this.JW).getSelectedRow());
         ((C0567)C0379.c(this.JW).getModel()).et(var2);
      }
   }
}
