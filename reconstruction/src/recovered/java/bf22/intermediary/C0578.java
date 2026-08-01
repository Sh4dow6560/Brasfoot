package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0578 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vK;
   private C0208 GS = null;

   public C0578(C0208 c0208) {
      this.Nt = new String[]{"", "", "", "", "", ""};
      this.GS = c0208;
      this.vK = c0208.qi();
   }

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return this.vK.size();
   }

   @Override
   public Object getValueAt(int i, int j) {
      return i < this.vK.size() ? this.vK.get(i) : null;
   }

   @Override
   public Class getColumnClass(int i) {
      return this.getValueAt(0, i) != null ? this.getValueAt(0, i).getClass() : String.class;
   }
}
