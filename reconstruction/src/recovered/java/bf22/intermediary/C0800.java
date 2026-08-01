package bf22.intermediary;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class C0800 extends JScrollPane {
   private ArrayList vp = new ArrayList();
   private JTable Sf;

   public C0800(ArrayList arrayList) {
      this.mJ();
      this.vp.addAll(arrayList);
      this.nc();
   }

   private void nc() {
      C0648 var1 = new C0648(this.vp);
      this.Sf.setModel(var1);
      this.Sf.setTableHeader(null);
      int[] var2 = new int[]{10, 80, 80, 40, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Sf.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Sf.setRowHeight(20);
      this.Sf.setShowGrid(false);
      this.Sf.setDefaultRenderer(C0722.class, new C0617());
      this.Sf.setAutoCreateRowSorter(false);
      this.Sf.setIntercellSpacing(new Dimension(0, 0));
      this.Sf.setCellSelectionEnabled(false);
      this.Sf.setRowSelectionAllowed(false);
      this.Sf.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.Sf = new JTable();
      this.setViewportView(this.Sf);
   }

   public void ac(ArrayList arrayList) {
      this.vp.clear();
      this.vp.addAll(arrayList);
      this.Sf.addNotify();
   }
}
