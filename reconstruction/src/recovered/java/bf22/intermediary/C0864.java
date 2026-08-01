package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0864 implements ActionListener {
   final bf22.intermediary.C0855 Vm;
   C0864(C0855 c0855) {
      this.Vm = c0855;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      int var2 = this.Vm.table.getSelectedRow();
      ((C0887)this.Vm.table.getModel()).removeRow(var2);
      this.Vm.table.addNotify();
   }
}
