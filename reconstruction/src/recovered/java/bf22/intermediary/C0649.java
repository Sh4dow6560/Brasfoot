package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0649 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   private static int SE = 1;
   private C0435 SF = null;

   public C0649(ArrayList arrayList) {
      this.SF = this.SF;
      this.vp = arrayList;
      this.Nt = new String[]{"Data", "", "", "", "Competição", "Público", "Renda"};
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

   public C0675 es(int i) {
      return (C0675)this.vp.get(i);
   }

   @Override
   public String getColumnName(int i) {
      return this.Nt[i];
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }

   public void et(int i) {
   }
}
