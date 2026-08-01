package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class C0817 extends JPanel {
   private ArrayList vP = new ArrayList();
   private JScrollPane ut;
   private JSeparator BE;
   private JLabel Ov;
   private JTable Ox;

   public C0817() {
      this.mJ();
      this.nc();
   }

   public void a(String string, ArrayList arrayList) {
      this.vP.addAll(arrayList);
      this.Ov.setText(string);
      this.Ox.addNotify();
   }

   private void nc() {
      C0666 var1 = new C0666(this.vP);
      this.Ox.setModel(var1);
      int[] var2 = new int[]{155, 120, 35};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Ox.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Ox.setAutoResizeMode(3);
      this.Ox.setRowHeight(20);
      this.Ox.setShowGrid(false);
      this.Ox.setDefaultRenderer(C0778.class, new C0637());
      this.Ox.setAutoCreateRowSorter(false);
      this.Ox.getTableHeader().setReorderingAllowed(false);
      this.Ox.setIntercellSpacing(new Dimension(0, 0));
      this.Ox.setCellSelectionEnabled(false);
      this.Ox.setTableHeader(null);
      this.Ox.setSelectionMode(0);
      this.Ox.setRowSelectionAllowed(true);
      this.Ox.setSelectionBackground(Color.YELLOW);
      this.Ox.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.Ov = new JLabel();
      this.BE = new JSeparator();
      this.ut = new JScrollPane();
      this.Ox = new JTable();
      this.setBackground(new Color(255, 255, 255));
      this.setMinimumSize(new Dimension(310, 515));
      this.setPreferredSize(new Dimension(595, 110));
      this.setLayout(new C0807());
      this.Ov.setBackground(new Color(255, 255, 255));
      this.Ov.setFont(new Font("Tahoma", 1, 12));
      this.Ov.setForeground(new Color(36, 104, 43));
      this.Ov.setText("Brasileiro - 1ª divisão");
      this.add(this.Ov, new C0775(10, 10, 190, -1));
      this.add(this.BE, new C0775(0, 30, 310, -1));
      this.ut.setBorder(BorderFactory.createEmptyBorder());
      this.ut.setViewportView(this.Ox);
      this.add(this.ut, new C0775(0, 35, 310, 480));
   }
}
