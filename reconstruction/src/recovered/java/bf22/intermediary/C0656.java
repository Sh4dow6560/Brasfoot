package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0656 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;

   public C0656(ArrayList arrayList) {
      this.vp = arrayList;
      this.Nt = new String[]{"Data", "", "", "", "Competição"};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.vp.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return this.vp.get(i);
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
