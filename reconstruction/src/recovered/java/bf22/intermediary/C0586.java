package bf22.intermediary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;
import mod.recovered.model.Player;

public class C0586 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   private static int SE = 1;
   private C0452 SO = null;
   private C0395 SL = null;
   public static Comparator KZ = new C0587();

   public C0586(ArrayList arrayList, C0452 c0452) {
      this.SO = c0452;
      this.vp = arrayList;
      this.mK();
   }

   public C0586(ArrayList arrayList) {
      this.vp = arrayList;
      this.mK();
   }

   public C0586(ArrayList arrayList, C0395 c0395) {
      this.SL = c0395;
      this.vp = arrayList;
      this.mK();
   }

   private void mK() {
      Collections.sort(this.vp, KZ);
      this.Nt = new String[]{"P", "", "", "Nome", "L", "F", "Salário", "Valor", "Car.", "GC", "A", "Idade", "V", "E"};
      if (C0745.SR.isHabilidadeIndividual()) {
         this.Nt = new String[]{
            "", "P", "", "Nome", "L", "Gol", "Des", "Arm", "Fin", "Vel", "Tec", "Pas", "Salário", "Valor", "Car.", "GC", "A", "Idade", "V", "E"
         };
      }

      if (this.vp.size() > 0) {
         this.et(0);
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
      return i < this.vp.size() ? this.vp.get(i) : null;
   }

   public void et(int i) {
      if (this.SO != null) {
         this.SO.s((Player)this.vp.get(i));
      }
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
