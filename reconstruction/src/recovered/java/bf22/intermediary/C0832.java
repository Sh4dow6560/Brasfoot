package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0832 implements ListSelectionListener {
   final bf22.intermediary.C0901 Vh;
   C0832(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0901.g(this.Vh).getSelectedRow() >= 0) {
         int var2 = C0901.g(this.Vh).convertRowIndexToModel(C0901.g(this.Vh).getSelectedRow());
         ((C0878)C0901.g(this.Vh).getModel()).et(var2);
      }
   }
}
