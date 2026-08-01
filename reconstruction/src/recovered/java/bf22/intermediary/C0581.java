package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0581 extends AbstractTableModel {
   private String[] Nt;
   private static ArrayList ds;

   public C0581() {
      ds = GamePersistence.SR.bF;
      this.Nt = new String[]{"Jogar", "País", "Times"};
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
      if (ds.size() == 0) {
         return null;
      } else {
         C0681 var3 = (C0681)ds.get(i);
         if (j == 0) {
            return var3.iC() ? 1 : 0;
         } else if (j == 1) {
            return Integer.toString(var3.getPais());
         } else {
            return j == 2 ? var3.iB() : null;
         }
      }
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
         if (((C0681)ds.get(i)).iC()) {
            ((C0681)ds.get(i)).v(false);
         } else if (!((C0681)ds.get(i)).iC()) {
            ((C0681)ds.get(i)).v(true);
         }
      }
   }
}
