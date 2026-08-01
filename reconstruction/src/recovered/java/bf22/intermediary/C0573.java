package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0573 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;

   public C0573(ArrayList arrayList, int i) {
      this.vp = arrayList;
      if (i == 0) {
         this.Nt = new String[]{"", "Time", "Reputação", ""};
      } else if (i == 1) {
         this.Nt = new String[]{"", "Time", "(PG/GP/GC)", ""};
      } else {
         this.Nt = new String[]{"", "Time", "Pontos", ""};
      }
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
