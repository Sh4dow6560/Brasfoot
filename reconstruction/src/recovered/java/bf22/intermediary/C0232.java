package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0232 implements ListSelectionListener {
   final bf22.intermediary.C0231 FS;
   C0232(C0231 c0231) {
      this.FS = c0231;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0231.a(this.FS).getSelectedRow() >= 0) {
         int var2 = C0231.a(this.FS).convertRowIndexToModel(C0231.a(this.FS).getSelectedRow());
         ((C0579)C0231.a(this.FS).getModel()).et(var2);
      }
   }
}
