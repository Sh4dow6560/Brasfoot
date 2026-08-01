package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0458 implements ListSelectionListener {
   final bf22.intermediary.C0452 MV;
   C0458(C0452 c0452) {
      this.MV = c0452;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0452.k(this.MV).getSelectedRow() >= 0) {
         int var2 = C0452.k(this.MV).convertRowIndexToModel(C0452.k(this.MV).getSelectedRow());
         ((C0586)C0452.k(this.MV).getModel()).et(var2);
      }
   }
}
