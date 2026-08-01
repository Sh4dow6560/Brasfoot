package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
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
import javax.swing.table.DefaultTableModel;
import mod.recovered.model.Club;

public class C0545 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private Club KF = null;
   private ArrayList KG = new ArrayList();
   private ArrayList KH = new ArrayList();
   private ArrayList Fj = new ArrayList();
   private int vk = -1;
   private int vl = -1;
   private int w = 0;
   public static Comparator KI = new C0546();
   public static Comparator KJ = new C0547();
   private JButton HR;
   private JButton vm;
   private JButton HY;
   private JButton Ie;
   private JComboBox ue;
   private JLabel ug;
   private JScrollPane ut;
   private JToolBar ve;
   private JTable vn;

   public C0545(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.KF = club;
      this.mJ();
      this.mH();
      this.mQ();
      this.w = 2;
      this.ue.setSelectedIndex(0);
      this.vn.setRowSelectionInterval(0, 0);
      this.mG();
   }

   private void mQ() {
      this.ue.addItem("Europa");
      this.ue.addItem("América do Sul");
      this.ue.addItem("África");
      this.ue.addItem("Ásia");
      this.ue.addItem("Concacaf");
      this.ue.addItem("Oceania");
      this.ue.addActionListener(new C0548(this));
   }

   private void AQ() {
      this.dw(this.ue.getSelectedIndex());
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 1));
      this.ve.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
   }

   private void dw(int i) {
      this.KG.clear();

      for (int var2 = 0; var2 < GamePersistence.SR.aG().size(); var2++) {
         if (((CountryCompetitions)GamePersistence.SR.aG().get(var2)).jo() != null && ((CountryCompetitions)GamePersistence.SR.aG().get(var2)).gg() == i && ((CountryCompetitions)GamePersistence.SR.aG().get(var2)).jc() != 135) {
            this.KG.add(((CountryCompetitions)GamePersistence.SR.aG().get(var2)).jo());
         }
      }

      this.w = 1;
      this.KH.clear();

      for (int var4 = 0; var4 < this.KG.size(); var4++) {
         C0785 var3 = new C0785();
         var3.n((Club)this.KG.get(var4));
         var3.a(this.w);
         if (this.w == 0) {
            var3.dQ(((Club)this.KG.get(var4)).getReputacao());
         } else if (this.w == 1) {
            var3.m(((Club)this.KG.get(var4)).ld());
         } else if (this.w == 2) {
            var3.dQ(((Club)this.KG.get(var4)).lb());
         }

         this.KH.add(var3);
      }

      if (this.w == 1) {
         Collections.sort(this.KH, KJ);
      } else {
         Collections.sort(this.KH, KI);
      }

      this.dx(this.w);
      this.vn.setRowSelectionInterval(0, 0);
      this.vn.scrollRectToVisible(new Rectangle(this.vn.getCellRect(0, 0, true)));
   }

   public void mH() {
      this.vm.addActionListener(new C0549(this));
      this.HR.addActionListener(new C0505(this));
      this.Ie.addActionListener(new C0506(this));
      this.HY.addActionListener(new C0507(this));
   }

   private void qP() {
      this.HY.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0447 var2 = new C0447(var1, this.uk);
      var1.add(var2);
      var1.setSize(740, 684);
      var1.setPreferredSize(new Dimension(740, 684));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.HY.setCursor(new Cursor(12));
   }

   private void rw() {
      this.Ie.setCursor(new Cursor(3));
      MainWindow.v(this.uk);
      this.Ie.setCursor(new Cursor(12));
   }

   private void sD() {
      this.HR.setCursor(new Cursor(3));
      JDialog var1 = new JDialog(this.ub);
      C0012 var2 = new C0012(var1, this.uk);
      var1.add(var2);
      var1.setSize(820, 600);
      var1.setPreferredSize(new Dimension(820, 600));
      var1.setModal(true);
      var1.setResizable(false);
      var1.setLocationRelativeTo(null);
      var1.setUndecorated(true);
      var1.setVisible(true);
      this.HR.setCursor(new Cursor(12));
   }

   private void dx(int i) {
      C0573 var2 = new C0573(this.KH, i);
      this.vn.setModel(var2);
      int[] var3 = new int[]{40, 200, 150, 40};

      for (int var4 = 0; var4 < var3.length; var4++) {
         this.vn.getColumnModel().getColumn(var4).setPreferredWidth(var3[var4]);
      }

      this.vn.getColumnModel().getColumn(0).setMaxWidth(40);
      this.vn.getColumnModel().getColumn(1).setMaxWidth(200);
      this.vn.getColumnModel().getColumn(2).setMaxWidth(200);
      this.vn.setAutoResizeMode(3);
      this.vn.setRowHeight(20);
      this.vn.setShowGrid(false);
      this.vn.setDefaultRenderer(C0785.class, new C0594());
      this.vn.setAutoCreateRowSorter(false);
      this.vn.getTableHeader().setReorderingAllowed(false);
      this.vn.setIntercellSpacing(new Dimension(0, 0));
      this.vn.setCellSelectionEnabled(false);
      this.vn.setSelectionMode(0);
      this.vn.setRowSelectionAllowed(true);
      this.vn.setSelectionBackground(Color.YELLOW);
      this.vn.setFillsViewportHeight(true);
      this.vn.getSelectionModel().addListSelectionListener(new C0508(this));
   }

   private void mJ() {
      this.ug = new JLabel();
      this.ue = new JComboBox();
      this.vm = new JButton();
      this.ut = new JScrollPane();
      this.vn = new JTable();
      this.ve = new JToolBar();
      this.HR = new JButton();
      this.Ie = new JButton();
      this.HY = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Ranking de Seleções");
      this.vm.setText("X");
      this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.ut.setViewportView(this.vn);
      this.ve.setBackground(new Color(0, 51, 51));
      this.ve.setRollover(true);
      this.ve.setBorderPainted(false);
      this.HR.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon02.png")));
      this.HR.setBorderPainted(false);
      this.HR.setFocusable(false);
      this.HR.setHorizontalTextPosition(0);
      this.HR.setOpaque(false);
      this.HR.setVerticalTextPosition(3);
      this.ve.add(this.HR);
      this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon10.png")));
      this.Ie.setBorderPainted(false);
      this.Ie.setFocusable(false);
      this.Ie.setHorizontalTextPosition(0);
      this.Ie.setOpaque(false);
      this.Ie.setVerticalTextPosition(3);
      this.ve.add(this.Ie);
      this.HY.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon11.png")));
      this.HY.setBorderPainted(false);
      this.HY.setFocusable(false);
      this.HY.setHorizontalTextPosition(0);
      this.HY.setMaximumSize(new Dimension(31, 31));
      this.HY.setOpaque(false);
      this.HY.setVerticalTextPosition(3);
      this.ve.add(this.HY);
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(this.ve, -1, -1, 32767)
                        .addGroup(
                           Alignment.LEADING,
                           var1.createSequentialGroup()
                              .addComponent(this.ug, -2, 154, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.ue, 0, 156, 32767)
                              .addGap(18, 18, 18)
                              .addComponent(this.vm, -2, 52, -2)
                        )
                        .addComponent(this.ut, -2, 0, 32767)
                  )
                  .addContainerGap(22, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(16, 16, 16)
                              .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.ue, -2, 23, -2))
                        )
                        .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.vm))
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.ut, -2, 554, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.ve, -2, -1, -2)
                  .addContainerGap()
            )
      );
      this.ug.getAccessibleContext().setAccessibleName("Ranking de Seleções");
   }
}
