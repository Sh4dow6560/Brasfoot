package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;
import mod.recovered.model.Player;

public class C0657 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp = null;
   private static int SE = 1;
   private C0043 SH = null;
   public static Comparator KZ = new C0658();

   public C0657(ArrayList arrayList, C0043 c0043, int i) {
      this.SH = c0043;
      this.vp = arrayList;
      this.eu(i);
   }

   private void eu(int i) {
      Collections.sort(this.vp, KZ);
      this.Nt = new String[]{"", "Nome", "Time", "L", "F", "Car.", "Idade"};
      if (GamePersistence.SR.isHabilidadeIndividual()) {
         if (i == 1) {
            this.Nt = new String[]{"", "Nome", "Time", "L", "Gol", "Des", "Arm", "Fin", "Vel", "Tec", "Pas", "Car.", "I"};
         } else {
            this.Nt = new String[]{"", "Nome", "Time", "L"};
         }
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
      if (this.SH != null) {
         this.SH.s((Player)this.vp.get(i));
      }
   }

   public Player ev(int i) {
      return (Player)this.vp.get(i);
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
