package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mod.recovered.model.Club;

class C0351 implements ListSelectionListener {
   final bf22.intermediary.C0350 aeO;
   C0351(C0350 c0350) {
      this.aeO = c0350;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0350.a(this.aeO).getSelectedRow() >= 0) {
         int var2 = C0350.a(this.aeO).convertRowIndexToModel(C0350.a(this.aeO).getSelectedRow());
         C0350.a(this.aeO, (Club)C0350.b(this.aeO).get(var2));
         C0350.c(this.aeO);
      }
   }
}
