package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mod.recovered.model.Coach;

class C0497 implements ListSelectionListener {
   final bf22.intermediary.C0493 ME;
   C0497(C0493 c0493) {
      this.ME = c0493;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0493.d(this.ME).getSelectedRow() >= 0) {
         int var2 = C0493.d(this.ME).convertRowIndexToModel(C0493.d(this.ME).getSelectedRow());
         C0493.a(this.ME, (Coach)GamePersistence.careerState.M().get(var2));
      }
   }
}
