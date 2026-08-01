package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0566 extends AbstractTableModel {
   private String[] Nt;
   private static ArrayList ds;

   public C0566() {
      ds = GamePersistence.SR.N();
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
         if (((CountryCompetitions)ds.get(i)).jr()) {
            ((CountryCompetitions)ds.get(i)).B(false);
         } else if (!((CountryCompetitions)ds.get(i)).jr()) {
            ((CountryCompetitions)ds.get(i)).B(true);
         }
      }
   }
}
