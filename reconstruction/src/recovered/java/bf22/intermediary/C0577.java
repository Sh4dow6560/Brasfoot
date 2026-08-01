package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import javax.swing.table.AbstractTableModel;

public class C0577 extends AbstractTableModel {
   private String[] Nt = new String[]{"Estado", "Times"};

   @Override
   public int getColumnCount() {
      return this.Nt.length;
   }

   @Override
   public int getRowCount() {
      return GamePersistence.careerState.bE.length;
   }

   @Override
   public Object getValueAt(int i, int j) {
      if (j == 0) {
         return i;
      } else {
         return j == 1 ? GamePersistence.careerState.bE[i] : null;
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
}
