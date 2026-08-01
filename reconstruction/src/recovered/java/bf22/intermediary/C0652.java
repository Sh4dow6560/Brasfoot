package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0652 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vU = new ArrayList();

   public C0652(ArrayList arrayList) {
      this.vU = arrayList;
      this.Nt = new String[]{"", "", ""};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.vU.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return this.vU.get(i);
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }
}
