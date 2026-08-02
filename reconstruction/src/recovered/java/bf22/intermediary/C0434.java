package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0434 implements ListSelectionListener {
   final bf22.intermediary.C0427 KL;
   C0434(C0427 c0427) {
      this.KL = c0427;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0427.e(this.KL).getSelectedRow() >= 0) {
         int var2 = C0427.e(this.KL).convertRowIndexToModel(C0427.e(this.KL).getSelectedRow());
         C0427.a(this.KL, ((C0785)C0427.f(this.KL).get(var2)).getClub());
         C0427.g(this.KL);
      }
   }
}
