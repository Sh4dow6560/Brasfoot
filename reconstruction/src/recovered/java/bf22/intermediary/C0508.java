package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0508 implements ListSelectionListener {
   final bf22.intermediary.C0545 afy;
   C0508(C0545 c0545) {
      this.afy = c0545;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0545.f(this.afy).getSelectedRow() >= 0) {
         int var2 = C0545.f(this.afy).convertRowIndexToModel(C0545.f(this.afy).getSelectedRow());
         C0545.a(this.afy, ((C0785)C0545.g(this.afy).get(var2)).fg());
      }
   }
}
