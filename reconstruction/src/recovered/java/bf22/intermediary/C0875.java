package bf22.intermediary;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class C0875 implements ListSelectionListener {
   final bf22.intermediary.C0871 VN;
   C0875(C0871 c0871) {
      this.VN = c0871;
   }

   @Override
   public void valueChanged(ListSelectionEvent listSelectionEvent) {
      if (!listSelectionEvent.getValueIsAdjusting() && C0871.b(this.VN).getSelectedRow() >= 0) {
         int var2 = C0871.b(this.VN).convertRowIndexToModel(C0871.b(this.VN).getSelectedRow());
         ((C0887)C0871.b(this.VN).getModel()).eJ(var2);
         C0871.c(this.VN).setText("Transferir para " + C0871.d(this.VN).getNome());
         C0871.e(this.VN).setEnabled(true);
      }
   }
}
