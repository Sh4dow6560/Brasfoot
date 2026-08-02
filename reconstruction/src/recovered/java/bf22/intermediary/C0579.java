package bf22.intermediary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0579 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   private static int SE = 1;
   private C0231 SM = null;
   public static Comparator KZ = new C0580();

   public C0579(Club club, C0231 c0231) {
      this.SM = c0231;
      this.vp = club.getYouthPlayers();
      Collections.sort(this.vp, KZ);
      this.Nt = new String[]{"", "P", "Pais", "Nome", "Idade", "L", "Desenvolvimento", "CPE", "Car", "Valor estimado", "Salário"};

      for (int var3 = 0; var3 < this.vp.size(); var3++) {
         ((Player)this.vp.get(var3)).a((ImageIcon)null);
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
      return this.vp.size() > 0 ? this.vp.get(i) : null;
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
      this.SM.z((Player)this.vp.get(i));
   }

   public ArrayList uH() {
      return this.vp;
   }

   static int vG() {
      return SE;
   }
}
