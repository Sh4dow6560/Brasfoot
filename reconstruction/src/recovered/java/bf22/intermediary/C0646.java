package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class C0646 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   public static Comparator KZ = new C0647();

   public C0646(ArrayList arrayList) {
      this.vp = arrayList;
      Collections.sort(arrayList, KZ);
      this.Nt = new String[]{"P", "Nome", "F", "E", "Caract."};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         this.Nt = new String[]{"P", "Nome", "Fin", "E", "Caracter."};
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

   public ArrayList uH() {
      return this.vp;
   }
}
