package bf22.intermediary;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class C0644 extends AbstractTableModel {
   private String[] Nt;
   private ArrayList vp;
   private static String SD = "";

   public C0644(ArrayList arrayList) {
      this.vp = arrayList;
      this.Nt = new String[]{"", "Jogador", "Time", "Gols", "Jogos"};
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

   public static void ac(String string) {
      SD = string;
      C0127.nZ();
   }

   public static String vF() {
      return SD;
   }
}
