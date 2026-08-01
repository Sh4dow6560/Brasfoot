package bf22.intermediary;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class C0861 implements TableModelListener {
   @Override
   public void tableChanged(TableModelEvent tableModelEvent) {
      int var2 = tableModelEvent.getFirstRow();
      int var3 = tableModelEvent.getColumn();
      TableModel var4 = (TableModel)tableModelEvent.getSource();
      String var5 = var4.getColumnName(var3);
      Object var6 = var4.getValueAt(var2, var3);
   }
}
