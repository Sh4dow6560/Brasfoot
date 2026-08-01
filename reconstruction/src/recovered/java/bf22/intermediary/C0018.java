package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class C0018 extends JPanel {
   private JDialog ub;
   private ArrayList cS = new ArrayList();
   private ArrayList vP = new ArrayList();
   private ImageIcon uL = new ImageIcon(this.getClass().getResource("/aiconsb/b0.png"));
   private ImageIcon uM = new ImageIcon(this.getClass().getResource("/aiconsb/b1.png"));
   private ImageIcon uN = new ImageIcon(this.getClass().getResource("/aiconsb/b2.png"));
   private ImageIcon uO = new ImageIcon(this.getClass().getResource("/aiconsb/b3.png"));
   private ImageIcon uP = new ImageIcon(this.getClass().getResource("/aiconsb/b4.png"));
   private ImageIcon uQ = new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png"));
   private ImageIcon uR = new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png"));
   private ImageIcon uS = new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png"));
   private ImageIcon uT = new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png"));
   private ImageIcon uU = new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png"));
   private JButton uW;
   private JButton vm;
   private JButton uX;
   private JButton uY;
   private JButton vi;
   private JButton uZ;
   private JComboBox va;
   private JComboBox ue;
   private JPanel vd;
   private JScrollPane ut;
   private JToolBar ve;
   private JLabel vf;
   private JTable vQ;

   public C0018(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
      this.mS();
      this.mQ();
      this.mO();
      this.mP();
      this.cB(0);
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   public void mH() {
      this.vm.addActionListener(new C0019(this));
   }

   private void mO() {
      if (!C0745.SR.isJogaEstadual()) {
         this.uW.setVisible(false);
      }

      if (!C0745.SR.isJogaRegionais()) {
         this.vi.setVisible(false);
      }

      if (!C0745.SR.isJogaSelecoesAll()) {
         this.uZ.setVisible(false);
      }

      if (!C0745.SR.isJogaIntClubes()) {
         this.uX.setVisible(false);
      }
   }

   private void mP() {
      this.uY.addActionListener(new C0020(this));
      this.uX.addActionListener(new C0021(this));
      this.uW.addActionListener(new C0022(this));
      this.uZ.addActionListener(new C0023(this));
      this.vi.addActionListener(new C0024(this));
   }

   private void cA(int i) {
      JButton[] var2 = new JButton[]{this.uY, this.uX, this.uW, this.uZ, this.vi};
      ImageIcon[] var3 = new ImageIcon[]{this.uL, this.uM, this.uN, this.uO, this.uP};
      ImageIcon[] var4 = new ImageIcon[]{this.uQ, this.uR, this.uS, this.uT, this.uU};

      for (int var5 = 0; var5 < var2.length; var5++) {
         var2[var5].setIcon(var3[var5]);
      }

      var2[i].setIcon(var4[i]);
   }

   private void cB(int i) {
      this.cA(i);
      this.cS = C0713.a(i, true, 1);
      if (i == 0 && C0745.SR.bW() != null && C0745.SR.bW().size() > 0) {
         this.cS.add((C0713)C0745.SR.bW().get(0));
      }

      this.va.removeAllItems();

      for (int var2 = 0; var2 < this.cS.size(); var2++) {
         this.va.addItem(this.cS.get(var2));
      }
   }

   private void cC(int i) {
      if (this.cS.size() > 0) {
         this.r((C0713)this.va.getSelectedItem());
      }
   }

   private void nb() {
      this.s((C0713)this.ue.getSelectedItem());
   }

   private void mQ() {
      C0625 var1 = new C0625(1);
      this.va.setPreferredSize(new Dimension(10, 25));
      this.va.setRenderer(var1);
      this.va.setMaximumRowCount(24);
      this.va.addActionListener(new C0025(this));
      C0628 var2 = new C0628();
      this.ue.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var2);
      this.ue.setMaximumRowCount(24);
      if (C0745.SR.bW().size() > 0) {
         for (int var3 = 0; var3 < C0745.SR.bW().size(); var3++) {
            this.ue.addItem(C0745.SR.bW().get(var3));
         }
      }

      this.ue.addActionListener(new C0026(this));
   }

   private void r(C0713 c0713) {
      if (c0713.b() == 11) {
         this.ue.setVisible(true);
         this.ue.setSelectedIndex(0);
      } else {
         this.ue.setVisible(false);
         this.s(c0713);
      }
   }

   private void s(C0713 c0713) {
      this.vP.clear();
      int var2 = -1;

      for (int var3 = c0713.mn().size() - 1; var3 >= 0; var3--) {
         if (c0713.mn().get(var3) != null && ((C0727)c0713.mn().get(var3)).H() != var2) {
            this.vP.add(new C0796((C0727)c0713.mn().get(var3), -1, c0713.b()));
            var2 = ((C0727)c0713.mn().get(var3)).H();
         }
      }

      this.vQ.addNotify();
   }

   private void mS() {
      C0650 var1 = new C0650(this.vP);
      this.vQ.setModel(var1);
      int[] var2 = new int[]{25, 110, 110, 160, 100};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vQ.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vQ.setAutoResizeMode(3);
      this.vQ.setRowHeight(20);
      this.vQ.setShowGrid(false);
      this.vQ.setDefaultRenderer(C0796.class, new C0619());
      this.vQ.setAutoCreateRowSorter(false);
      this.vQ.getTableHeader().setReorderingAllowed(false);
      this.vQ.setIntercellSpacing(new Dimension(0, 0));
      this.vQ.setCellSelectionEnabled(false);
      this.vQ.setSelectionMode(0);
      this.vQ.setRowSelectionAllowed(true);
      this.vQ.setSelectionBackground(Color.YELLOW);
      this.vQ.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.ut = new JScrollPane();
      this.vQ = new JTable();
      this.vf = new JLabel();
      this.vd = new JPanel();
      this.ve = new JToolBar();
      this.uY = new JButton();
      this.uX = new JButton();
      this.uW = new JButton();
      this.uZ = new JButton();
      this.vi = new JButton();
      this.va = new JComboBox();
      this.vm = new JButton();
      this.ue = new JComboBox();
      this.setBackground(new Color(104, 120, 100));
      this.vQ.setModel(new DefaultTableModel(new Object[][]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
      this.ut.setViewportView(this.vQ);
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Campeões");
      this.vd.setBackground(new Color(44, 53, 49));
      this.vd.setPreferredSize(new Dimension(483, 40));
      this.vd.setLayout(new C0807());
      this.ve.setBackground(new Color(44, 53, 49));
      this.ve.setFloatable(false);
      this.ve.setRollover(true);
      this.ve.setBorderPainted(false);
      this.uY.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0.png")));
      this.uY.setBorderPainted(false);
      this.uY.setContentAreaFilled(false);
      this.uY.setFocusable(false);
      this.uY.setHorizontalTextPosition(0);
      this.uY.setMargin(new Insets(0, 0, 0, 0));
      this.uY.setMaximumSize(new Dimension(79, 45));
      this.uY.setMinimumSize(new Dimension(79, 45));
      this.uY.setPreferredSize(new Dimension(79, 45));
      this.uY.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
      this.uY.setVerticalTextPosition(3);
      this.ve.add(this.uY);
      this.uX.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1.png")));
      this.uX.setBorderPainted(false);
      this.uX.setContentAreaFilled(false);
      this.uX.setFocusable(false);
      this.uX.setHorizontalTextPosition(0);
      this.uX.setMargin(new Insets(0, 0, 0, 0));
      this.uX.setMaximumSize(new Dimension(79, 45));
      this.uX.setMinimumSize(new Dimension(79, 45));
      this.uX.setPreferredSize(new Dimension(79, 45));
      this.uX.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b1s.png")));
      this.uX.setVerticalTextPosition(3);
      this.ve.add(this.uX);
      this.uW.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2.png")));
      this.uW.setBorderPainted(false);
      this.uW.setContentAreaFilled(false);
      this.uW.setFocusable(false);
      this.uW.setHorizontalTextPosition(0);
      this.uW.setMargin(new Insets(0, 0, 0, 0));
      this.uW.setMaximumSize(new Dimension(79, 45));
      this.uW.setMinimumSize(new Dimension(79, 45));
      this.uW.setPreferredSize(new Dimension(79, 45));
      this.uW.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b2s.png")));
      this.uW.setVerticalTextPosition(3);
      this.ve.add(this.uW);
      this.uZ.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3.png")));
      this.uZ.setBorderPainted(false);
      this.uZ.setContentAreaFilled(false);
      this.uZ.setFocusable(false);
      this.uZ.setHorizontalTextPosition(0);
      this.uZ.setMargin(new Insets(0, 0, 0, 0));
      this.uZ.setMaximumSize(new Dimension(79, 45));
      this.uZ.setMinimumSize(new Dimension(79, 45));
      this.uZ.setPreferredSize(new Dimension(79, 45));
      this.uZ.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b3s.png")));
      this.uZ.setVerticalTextPosition(3);
      this.ve.add(this.uZ);
      this.vi.setIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4.png")));
      this.vi.setBorderPainted(false);
      this.vi.setContentAreaFilled(false);
      this.vi.setFocusable(false);
      this.vi.setHorizontalTextPosition(0);
      this.vi.setMargin(new Insets(0, 0, 0, 0));
      this.vi.setMaximumSize(new Dimension(79, 45));
      this.vi.setMinimumSize(new Dimension(79, 45));
      this.vi.setPreferredSize(new Dimension(79, 45));
      this.vi.setRolloverIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b4s.png")));
      this.vi.setVerticalTextPosition(3);
      this.ve.add(this.vi);
      this.vd.add(this.ve, new C0775(0, 0, 460, 40));
      this.vd.add(this.va, new C0775(570, 10, 200, 25));
      this.vm.setText("X");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(29, 29, 29)
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addComponent(this.ue, -2, 200, -2)
                        .addGroup(
                           var1.createParallelGroup(Alignment.LEADING, false)
                              .addComponent(this.ut, -2, 781, -2)
                              .addComponent(this.vd, -2, 781, -2)
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addComponent(this.vf, -2, 368, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    .addComponent(this.vm, -2, 59, -2)
                              )
                        )
                  )
                  .addContainerGap(38, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(17, 17, 17)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vf).addComponent(this.vm))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vd, -2, 40, -2)
                  .addGap(11, 11, 11)
                  .addComponent(this.ut, -2, 489, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ue, -2, 25, -2)
                  .addContainerGap(-1, 32767)
            )
      );
   }
}
