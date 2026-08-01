package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mod.recovered.model.Club;

class C0366 implements ListSelectionListener {
   final bf22.intermediary.C0360 Kz;
   C0366(C0360 c0360) {
      this.Kz = c0360;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0360.f(this.Kz).getSelectedRow() >= 0) {
         int var2 = C0360.f(this.Kz).convertRowIndexToModel(C0360.f(this.Kz).getSelectedRow());
         C0360.a(this.Kz, (Club)C0360.g(this.Kz).get(var2));
         C0360.h(this.Kz);
      }
   }
}
