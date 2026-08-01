package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0017 implements ListSelectionListener {
   final bf22.intermediary.C0012 vO;
   C0017(C0012 c0012) {
      this.vO = c0012;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0012.c(this.vO).getSelectedRow() >= 0) {
         int var2 = C0012.c(this.vO).convertRowIndexToModel(C0012.c(this.vO).getSelectedRow());
         C0012.a(this.vO, ((C0649)C0012.c(this.vO).getModel()).es(var2));
      }
   }
}
