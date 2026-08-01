package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0566 extends AbstractTableModel {
   private String[] Nt;
   private static ArrayList ds;

   public C0566() {
      ds = C0745.SR.N();
      this.Nt = new String[]{"Ver", "País", ""};
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return ds.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return ds.size() == 0 ? null : ds.get(i);
   }

   @Override
   public String getColumnName(int i) {
      return this.Nt[i];
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i).getClass();
   }

   public void ex(int i) {
      if (i >= 0) {
         if (((C0692)ds.get(i)).jr()) {
            ((C0692)ds.get(i)).B(false);
         } else if (!((C0692)ds.get(i)).jr()) {
            ((C0692)ds.get(i)).B(true);
         }
      }
   }
}
