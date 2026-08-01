package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;

public class C0808 extends JPanel {
   private ArrayList vS = new ArrayList();
   private static BufferedImage DH = null;
   private JScrollPane ut;
   private JTable wp;

   public C0808(ArrayList arrayList) {
      this.vS = arrayList;
      this.mJ();
      this.nc();
   }

   private void nc() {
      C0653 var1 = new C0653(this.vS);
      this.wp.setModel(var1);
      this.wp.setTableHeader(null);
      int[] var2 = new int[]{20, 20, 120, 20, 20, 20, 20, 20, 20, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.wp.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.wp.setRowHeight(18);
      this.wp.setShowGrid(false);
      this.wp.setDefaultRenderer(C0810.class, new C0623());
      this.wp.setAutoCreateRowSorter(false);
      this.wp.setIntercellSpacing(new Dimension(1, 1));
      this.wp.setCellSelectionEnabled(false);
      this.wp.setSelectionMode(0);
      this.wp.setRowSelectionAllowed(true);
      this.wp.setSelectionBackground(Color.YELLOW);
      this.wp.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.ut = new JScrollPane();
      this.wp = new JTable();
      this.wp.setBackground(Color.BLACK);
      this.ut.setViewportView(this.wp);
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.ut, -1, 320, 32767));
      var1.setVerticalGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.ut, -1, 300, 32767));
   }

   @Override
   protected void paintComponent(Graphics graphics) {
      try {
         DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f01.jpg"));
      } catch (IOException var3) {
      }

      Dimension var2 = this.getSize();
      super.paintComponent(graphics);
      graphics.drawImage(DH, 0, 0, var2.width, var2.height, null);
   }
}
