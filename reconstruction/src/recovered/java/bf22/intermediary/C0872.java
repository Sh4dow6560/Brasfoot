package bf22.intermediary;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

class C0872 extends JTable {
   final bf22.intermediary.C0871 VN;
   C0872(C0871 c0871, TableModel tableModel) {
      super(tableModel);
      this.VN = c0871;
   }

   @Override
   public Component prepareRenderer(TableCellRenderer tableCellRenderer, int i, int j) {
      Component var4 = super.prepareRenderer(tableCellRenderer, i, j);
      if (!this.isCellSelected(i, j)) {
         if (i % 2 == 0 && !this.isCellSelected(i, j)) {
            Color var5 = Color.decode("#f6f7e5");
            var4.setBackground(var5);
         } else {
            var4.setBackground(this.getBackground());
         }
      }

      return var4;
   }
}
