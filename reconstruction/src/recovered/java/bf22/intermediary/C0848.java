package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0848 implements ListSelectionListener {
   final bf22.intermediary.C0901 Vh;
   C0848(C0901 c0901) {
      this.Vh = c0901;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && this.Vh.Vg.getSelectedRow() >= 0) {
         C0901.a(this.Vh, true);
         int var2 = this.Vh.Vg.convertRowIndexToModel(this.Vh.Vg.getSelectedRow());
         ((C0887)this.Vh.Vg.getModel()).et(var2);
         C0901.g(this.Vh).addNotify();
      }
   }
}
