package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0206 implements ListSelectionListener {
   final bf22.intermediary.C0200 GR;
   C0206(C0200 c0200) {
      this.GR = c0200;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0200.e(this.GR).getSelectedRow() >= 0) {
         int var2 = C0200.e(this.GR).convertRowIndexToModel(C0200.e(this.GR).getSelectedRow());
         C0200.a(this.GR, (String)C0200.f(this.GR).get(var2));
         C0200.g(this.GR);
      }
   }
}
