package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0666 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList SJ;

   public C0666(ArrayList arrayList) {
      this.SJ = arrayList;
      this.Nt = new String[]{"camp", "time", "Ano"};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.SJ.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return this.SJ.get(i);
   }

   @Override
   public String getColumnName(int i) {
      return this.Nt[i];
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }
}
