package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0277 implements ListSelectionListener {
   final bf22.intermediary.C0272 Iz;
   C0277(C0272 c0272) {
      this.Iz = c0272;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0272.c(this.Iz).getSelectedRow() >= 0) {
         int var2 = C0272.c(this.Iz).convertRowIndexToModel(C0272.c(this.Iz).getSelectedRow());
         ((C0582)C0272.c(this.Iz).getModel()).et(var2);
      }
   }
}
