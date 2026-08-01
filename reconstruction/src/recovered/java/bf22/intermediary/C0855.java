package bf22.intermediary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.util.Comparator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class C0855 {
   public JFrame Vi;
   public JPanel xb;
   public JPanel Vj;
   public JPanel Vk;
   public JTable table;
   public JTable UQ;
   public TableModel Vl;
   Comparator UB = new C0856(this);

   public void wT() {
      this.wU();
      this.wV();
   }

   private void wU() {
      this.Vi = new JFrame("Editor Brasfoot");
      this.Vi.setLayout(new BorderLayout());
      this.Vi.setDefaultCloseOperation(3);
   }

   private void wV() {
      this.xb = new JPanel();
      this.Vi.add(this.xb);
      Color var1 = Color.decode("#007700");
      this.xb.setBackground(var1);
      this.wW();
      this.wX();
      this.wY();
      this.xb();
      this.wZ();
   }

   private void wW() {
      this.Vj = new JPanel();
      this.Vj.setLayout(new BoxLayout(this.Vj, 1));
      this.xb.add(this.Vj);
      Color var1 = Color.BLUE;
      this.Vj.setBackground(var1);
   }

   private void wX() {
      this.Vk = new JPanel();
      this.xb.add(this.Vk);
      Color var1 = Color.RED;
      this.Vk.setBackground(var1);
   }

   private void wY() {
      C0887 var1 = new C0887();
      this.table = new C0857(this, var1);
      this.table.setShowGrid(false);
      this.table.setDefaultRenderer(String.class, new C0892());
      this.table.setDefaultRenderer(Integer.class, new C0892());
      TableRowSorter var2 = new TableRowSorter<>(this.table.getModel());
      var2.setComparator(2, this.UB);
      this.table.setRowSorter(var2);
      this.table.getModel().addTableModelListener(new C0861());
      this.table.setSelectionMode(0);
      this.table.setOpaque(true);
      this.table.setRowSelectionAllowed(true);
      this.table.setIntercellSpacing(new Dimension(0, 0));
      JScrollPane var3 = new JScrollPane(this.table);
      this.Vj.add(var3, 0);
   }

   private void wZ() {
      C0887 var1 = new C0887();
      this.UQ = new C0863(this, var1);
      this.UQ.setDefaultRenderer(String.class, new C0892());
      this.UQ.setDefaultRenderer(Integer.class, new C0892());
      TableRowSorter var2 = new TableRowSorter<>(this.UQ.getModel());
      var2.setComparator(2, this.UB);
      this.UQ.setRowSorter(var2);
      this.UQ.getModel().addTableModelListener(new C0861());
      this.UQ.setSelectionMode(0);
      this.UQ.setOpaque(true);
      this.UQ.setRowSelectionAllowed(true);
      this.UQ.setIntercellSpacing(new Dimension(0, 0));
      JScrollPane var3 = new JScrollPane(this.UQ);
      this.Vk.add(var3);
   }

   public void xa() {
      this.Vi.setUndecorated(true);
      this.Vi.pack();
      GraphicsConfiguration var1 = this.Vi.getGraphicsConfiguration();
      Rectangle var2 = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
      this.Vi.setMaximizedBounds(new Rectangle(0, 0, var2.width, var2.height));
      this.Vi.setExtendedState((this.Vi.getExtendedState() & 6) == 6 ? 0 : 6);
      this.Vi.setVisible(true);
   }

   public Component prepareRenderer(TableCellRenderer tableCellRenderer, int i, int j) {
      Component var4 = this.table.prepareRenderer(tableCellRenderer, i, j);
      Object var5 = this.table.getValueAt(i, j);
      if (var5.toString().equals("Red")) {
         var4.setBackground(Color.RED);
      } else if (i % 2 == 0 && !this.table.isCellSelected(i, j)) {
         var4.setBackground(Color.YELLOW);
      } else {
         var4.setBackground(this.table.getBackground());
      }

      return var4;
   }

   private void xb() {
      JButton var1 = new JButton("Add/remove");
      var1.addActionListener(new C0864(this));
      this.Vj.add(var1);
   }
}
