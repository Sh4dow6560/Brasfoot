package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0613 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList afP;

   public C0613(ArrayList arrayList) {
      this.afP = arrayList;
      this.Nt = new String[]{""};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.afP.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return this.afP.get(i);
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
