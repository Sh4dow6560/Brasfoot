package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0653 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList SG = new ArrayList();

   public C0653(ArrayList arrayList) {
      this.SG = arrayList;
      this.Nt = new String[]{"", "", "", "", "", "", "", "", "", "", ""};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.SG.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return this.SG.get(i);
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }
}
