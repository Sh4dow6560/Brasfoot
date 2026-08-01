package bf22.intermediary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;
import mod.recovered.model.Player;

public class C0567 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   private static int SE = 1;
   private C0379 SK = null;
   public static Comparator KZ = new C0568();

   public C0567(ArrayList arrayList, C0379 c0379) {
      this.SK = c0379;
      this.vp = arrayList;
      Collections.sort(arrayList, KZ);
      this.Nt = new String[]{"P", "Nome", "F", "E", "Caract."};
      if (C0745.SR.isHabilidadeIndividual()) {
         this.Nt = new String[]{"P", "Nome", "Fin", "E", "Caract."};
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

   public void et(int i) {
      this.SK.A((Player)this.vp.get(i));
   }

   public ArrayList uH() {
      return this.vp;
   }

   static int vG() {
      return SE;
   }
}
