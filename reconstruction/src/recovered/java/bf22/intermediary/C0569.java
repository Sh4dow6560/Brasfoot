package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;
import mod.recovered.model.Player;

public class C0569 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   private static int SE = 1;
   private C0395 SL = null;
   public static Comparator KZ = new C0570();

   public C0569(ArrayList arrayList, C0395 c0395) {
      this.SL = c0395;
      this.vp = arrayList;
      this.mK();
   }

   private void mK() {
      Collections.sort(this.vp, KZ);
      this.Nt = new String[]{"P", "", "Nome", "Time", "L", "F", "Salário", "Valor", "Car.", "GC", "Idade", "V", "E"};
      if (GamePersistence.careerState.isHabilidadeIndividual()) {
         this.Nt = new String[]{
            "P", "", "Nome", "Time", "L", "Gol", "Des", "Arm", "Fin", "Vel", "Tec", "Pas", "Salário", "Valor", "Car.", "GC", "Idade", "V", "E"
         };
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
      return this.vp.size() > 0 ? this.vp.get(i) : null;
   }

   public void et(int i) {
      this.SL.s((Player)this.vp.get(i));
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

   static int vG() {
      return SE;
   }
}
