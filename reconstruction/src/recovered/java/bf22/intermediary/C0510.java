package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mod.recovered.model.Coach;

class C0510 implements ListSelectionListener {
   final bf22.intermediary.C0369 KE;
   C0510(C0369 c0369) {
      this.KE = c0369;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0369.d(this.KE).getSelectedRow() >= 0) {
         int var2 = C0369.d(this.KE).convertRowIndexToModel(C0369.d(this.KE).getSelectedRow());
         C0369.a(this.KE, (Coach)C0369.e(this.KE).get(var2));
         this.KE.rV();
      }
   }
}
