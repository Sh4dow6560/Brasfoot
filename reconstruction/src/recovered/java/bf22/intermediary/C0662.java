package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0662 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList SI;

   public C0662(ArrayList arrayList) {
      this.SI = arrayList;
      this.Nt = new String[]{"", "", ""};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.SI.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return this.SI.get(i);
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }
}
