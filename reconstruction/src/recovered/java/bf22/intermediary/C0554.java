package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.BorderFactory;
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
import mod.recovered.model.Player;

public class C0554 extends JPanel {
   private JDialog ub;
   private ArrayList uK = new ArrayList();
   private ArrayList cS = new ArrayList();
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
   public static Comparator uV = new C0555();
   private JButton uW;
   private JButton uX;
   private JButton uY;
   private JButton uZ;
   private JComboBox va;
   private JButton vb;
   private JButton vc;
   private JPanel vd;
   private JScrollPane ut;
   private JToolBar ve;
   private JLabel vf;
   private JLabel vg;
   private JTable vh;
   private JButton vi;

   public C0554(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
      this.mS();
      this.mQ();
      this.mO();
      this.mP();
      this.cB(0);
      this.vg.setVisible(false);
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
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
      this.uY.addActionListener(new C0556(this));
      this.uX.addActionListener(new C0557(this));
      this.uW.addActionListener(new C0558(this));
      this.uZ.addActionListener(new C0559(this));
      this.vi.addActionListener(new C0560(this));
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
      this.cS = C0713.a(i, false, 0);
      this.va.removeAllItems();

      for (int var2 = 0; var2 < this.cS.size(); var2++) {
         this.va.addItem(this.cS.get(var2));
      }
   }

   private void cC(int i) {
      if (this.cS.size() > 0) {
         this.a((C0713)this.va.getSelectedItem(), false);
      }
   }

   private void mQ() {
      C0625 var1 = new C0625();
      this.va.setPreferredSize(new Dimension(10, 25));
      this.va.setRenderer(var1);
      this.va.setMaximumRowCount(24);
      this.va.addActionListener(new C0561(this));
   }

   private void a(C0713 c0713, boolean bl) {
      this.uK.clear();
      c0713.mv();
      if (c0713 != null) {
         for (int var3 = 0; var3 < c0713.ms().size(); var3++) {
            this.uK.add(new C0721((C0720)c0713.ms().get(var3)));
         }
      }

      this.vh.addNotify();
   }

   private void mR() {
      ArrayList var1 = new ArrayList();

      for (int var2 = 0; var2 < C0745.SR.O().size(); var2++) {
         if (((Player)C0745.SR.O().get(var2)).gy() > 0) {
            var1.add(
               new C0721(
                  ((Player)C0745.SR.O().get(var2)).getNome(),
                  ((Player)C0745.SR.O().get(var2)).fg(),
                  ((Player)C0745.SR.O().get(var2)).gy(),
                  ((Player)C0745.SR.O().get(var2)).gz()
               )
            );
         }
      }

      for (int var3 = 0; var3 < C0745.SR.bJ().size(); var3++) {
         var1.add(new C0721(((C0719)C0745.SR.bJ().get(var3)).getN(), null, ((C0719)C0745.SR.bJ().get(var3)).v(), ((C0719)C0745.SR.bJ().get(var3)).w()));
      }

      Collections.sort(var1, uV);
      this.uK.clear();

      for (int var4 = 0; var4 < var1.size(); var4++) {
         this.uK.add((C0721)var1.get(var4));
         if (var4 == 400) {
            break;
         }
      }

      this.vh.addNotify();
   }

   private void mS() {
      C0644 var1 = new C0644(this.uK);
      this.vh.setModel(var1);
      int[] var2 = new int[]{10, 120, 120, 30, 30};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vh.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vh.setAutoResizeMode(3);
      this.vh.setRowHeight(20);
      this.vh.setShowGrid(false);
      this.vh.setDefaultRenderer(C0721.class, new C0591());
      this.vh.setAutoCreateRowSorter(false);
      this.vh.getTableHeader().setReorderingAllowed(false);
      this.vh.setIntercellSpacing(new Dimension(0, 0));
      this.vh.setCellSelectionEnabled(false);
      this.vh.setSelectionMode(0);
      this.vh.setRowSelectionAllowed(true);
      this.vh.setSelectionBackground(Color.YELLOW);
      this.vh.setFillsViewportHeight(true);
   }

   public void mH() {
      this.vb.addActionListener(new C0562(this));
      this.vc.addActionListener(new C0563(this));
   }

   private void mJ() {
      this.ut = new JScrollPane();
      this.vh = new JTable();
      this.vg = new JLabel();
      this.vf = new JLabel();
      this.vd = new JPanel();
      this.va = new JComboBox();
      this.ve = new JToolBar();
      this.vi = new JButton();
      this.uY = new JButton();
      this.uX = new JButton();
      this.uW = new JButton();
      this.uZ = new JButton();
      this.vb = new JButton();
      this.vc = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.ut.setViewportView(this.vh);
      this.vg.setHorizontalAlignment(4);
      this.vg.setText("mostrar todos >>");
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Artilheiros");
      this.vd.setBackground(new Color(35, 28, 14));
      this.vd.setPreferredSize(new Dimension(583, 40));
      this.vd.setLayout(new C0807());
      this.vd.add(this.va, new C0775(447, 7, 200, 25));
      this.ve.setBackground(new Color(35, 28, 14));
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
      this.uY.setPressedIcon(new ImageIcon(this.getClass().getResource("/aiconsb/b0s.png")));
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
      this.vd.add(this.ve, new C0775(0, 0, 440, 40));
      this.vb.setText("X");
      this.vc.setText("Melhores de sempre de todas competições");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.vc, -2, 300, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vg, -2, 156, -2)
                        )
                        .addGroup(
                           Alignment.LEADING,
                           var1.createSequentialGroup()
                              .addComponent(this.vf, -2, 368, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vb, -2, 50, -2)
                        )
                        .addComponent(this.vd, Alignment.LEADING, -1, 565, 32767)
                        .addComponent(this.ut, Alignment.LEADING)
                  )
                  .addGap(22, 22, 22)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(17, 17, 17)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vf).addComponent(this.vb))
                  .addGap(11, 11, 11)
                  .addComponent(this.vd, -2, 40, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ut, -2, 477, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vg).addComponent(this.vc))
                  .addContainerGap(-1, 32767)
            )
      );
   }
}
