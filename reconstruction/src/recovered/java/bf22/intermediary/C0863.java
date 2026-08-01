package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

class C0863 extends JTable {
   final bf22.intermediary.C0855 Vm;
   C0863(C0855 c0855, TableModel tableModel) {
      super(tableModel);
      this.Vm = c0855;
   }

   @Override
   public Component prepareRenderer(TableCellRenderer tableCellRenderer, int i, int j) {
      Component var4 = super.prepareRenderer(tableCellRenderer, i, j);
      if (!this.isCellSelected(i, j)) {
         if (i % 2 == 0 && !this.isCellSelected(i, j)) {
            var4.setBackground(Color.LIGHT_GRAY);
         } else {
            var4.setBackground(this.getBackground());
         }
      }

      return var4;
   }
}
