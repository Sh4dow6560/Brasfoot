package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0124 implements ListSelectionListener {
   final bf22.intermediary.C0120 Ae;
   C0124(C0120 c0120) {
      this.Ae = c0120;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0120.b(this.Ae).getSelectedRow() >= 0) {
         int var2 = C0120.b(this.Ae).convertRowIndexToModel(C0120.b(this.Ae).getSelectedRow());
         C0120.a(this.Ae, ((C0661)C0120.b(this.Ae).getModel()).ew(var2));
      }
   }
}
