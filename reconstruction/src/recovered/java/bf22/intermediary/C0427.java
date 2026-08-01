package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import mod.recovered.ui.MainWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import mod.recovered.model.Club;

public class C0427 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private Club KF = null;
   private ArrayList KG = new ArrayList();
   private ArrayList KH = new ArrayList();
   private ArrayList Fj = new ArrayList();
   private int vk = -1;
   private int vl = -1;
   private int w = 0;
   public static Comparator KI = new C0428();
   public static Comparator KJ = new C0429();
   private JButton vm;
   private JButton Ie;
   private JComboBox ue;
   private JComboBox KK;
   private JPanel vd;
   private JScrollPane ut;
   private JScrollPane wi;
   private JLabel xI;
   private JLabel uu;
   private JLabel vf;
   private JTable Fl;
   private JTable vn;

   public C0427(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.KF = club;
      this.mJ();
      this.mH();
      this.mQ();
      this.pq();
      this.w = 2;
      this.KK.setSelectedIndex(2);
      this.vn.setRowSelectionInterval(0, 0);
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   public void mH() {
      this.vm.addActionListener(new C0430(this));
      this.Ie.addActionListener(new C0431(this));
   }

   private void rw() {
      MainWindow.v(this.uk);
   }

   private void mQ() {
      this.ue.addItem("Internacional");

      for (int var1 = 0; var1 < GamePersistence.careerState.N().size(); var1++) {
         this.ue.addItem(((CountryCompetitions)GamePersistence.careerState.N().get(var1)).jp());
         if (((CountryCompetitions)GamePersistence.careerState.N().get(var1)).jc() == this.vk) {
            this.vl = var1 + 1;
         }
      }

      C0037 var2 = new C0037();
      var2.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var2);
      this.ue.setMaximumRowCount(12);
      this.ue.setSelectedIndex(0);
      this.ue.addActionListener(new C0432(this));
      this.KK.addItem("Ranking por reputação");
      this.KK.addItem("Ranking por pontos corridos");
      this.KK.addItem("Ranking por colocação");
      this.KK.addActionListener(new C0433(this));
   }

   private void mU() {
      this.dw(this.KK.getSelectedIndex());
   }

   private void dw(int i) {
      this.w = i;
      int var2 = this.ue.getSelectedIndex() - 1;
      this.KG.clear();
      if (var2 >= 0) {
         this.vl = ((CountryCompetitions)GamePersistence.careerState.N().get(var2)).jc();

         for (int var3 = 0; var3 < GamePersistence.careerState.P().size(); var3++) {
            if (((Club)GamePersistence.careerState.P().get(var3)).getPais() == this.vl) {
               this.KG.add((Club)GamePersistence.careerState.P().get(var3));
            }
         }
      } else {
         for (int var5 = 0; var5 < GamePersistence.careerState.P().size(); var5++) {
            this.KG.add((Club)GamePersistence.careerState.P().get(var5));
         }
      }

      this.KH.clear();

      for (int var6 = 0; var6 < this.KG.size(); var6++) {
         C0785 var4 = new C0785();
         var4.n((Club)this.KG.get(var6));
         var4.a(this.w);
         if (this.w == 0) {
            var4.dQ(((Club)this.KG.get(var6)).getReputacao());
         } else if (this.w == 1) {
            var4.m(((Club)this.KG.get(var6)).ld());
         } else if (this.w == 2) {
            var4.dQ(((Club)this.KG.get(var6)).lb());
         }

         this.KH.add(var4);
      }

      if (i == 1) {
         Collections.sort(this.KH, KJ);
      } else {
         Collections.sort(this.KH, KI);
      }

      this.dx(this.w);
      this.vn.setRowSelectionInterval(0, 0);
      this.vn.scrollRectToVisible(new Rectangle(this.vn.getCellRect(0, 0, true)));
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
      this.vn.getSelectionModel().addListSelectionListener(new C0434(this));
   }

   private boolean dy(int i) {
      if (i == 3 && !GamePersistence.careerState.isJogaEstadual()) {
         return false;
      }

      if (i == 3 && this.uk.getPais() != 29) {
         return false;
      }

      if (i == 4 || i == 6 || i == 5 || i == 8 || i == 12) {
         if (!GamePersistence.careerState.isJogaIntClubes()) {
            return false;
         }

         if (i == 6 && this.uk.gg() > 1) {
            return false;
         }

         if (i == 8 && this.uk.gg() > 1) {
            return false;
         }

         if (i == 12 && this.uk.gg() > 0) {
            return false;
         }
      }

      return !GameConstants.fs(i);
   }

   private void rW() {
      this.uu.setText(this.uk.getNome());
      this.Fj.clear();
      if (this.w == 0) {
         this.xI.setText(GameConstants.pZ[this.uk.getReputacao()]);
      } else if (this.w == 1) {
         int[][] var1 = this.uk.lc();
         int[] var2 = this.uk.ld();
         this.xI.setText("PG:" + Integer.toString(var2[0]) + " GP:" + Integer.toString(var2[1]) + " GC:" + Integer.toString(var2[2]));

         for (int var3 = 1; var3 <= 14; var3++) {
            if (var1[var3][0] > 0 && this.dy(var3)) {
               C0784 var4 = new C0784();
               var4.n(this.uk);
               var4.a(var3);
               var4.m(var1[var3]);
               var4.dR(1);
               this.Fj.add(var4);
            }
         }
      } else if (this.w == 2) {
         int[] var5 = this.uk.la();
         this.xI.setText(Integer.toString(this.uk.lb()) + " pontos");

         for (int var6 = 1; var6 <= 14; var6++) {
            if (var5[var6] > 0 && this.dy(var6)) {
               C0784 var7 = new C0784();
               var7.n(this.uk);
               var7.a(var6);
               var7.dQ(var5[var6]);
               var7.dR(2);
               this.Fj.add(var7);
            }
         }
      }

      this.Fl.addNotify();
   }

   private void pq() {
      C0574 var1 = new C0574(this.Fj, this.w);
      this.Fl.setModel(var1);
      int[] var2 = new int[]{100, 50};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Fl.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Fl.setAutoResizeMode(3);
      this.Fl.setRowHeight(20);
      this.Fl.setShowGrid(false);
      this.Fl.setDefaultRenderer(C0784.class, new C0595());
      this.Fl.setAutoCreateRowSorter(false);
      this.Fl.getTableHeader().setReorderingAllowed(false);
      this.Fl.setIntercellSpacing(new Dimension(0, 0));
      this.Fl.setCellSelectionEnabled(false);
      this.Fl.setSelectionMode(0);
      this.Fl.setRowSelectionAllowed(true);
      this.Fl.setSelectionBackground(Color.YELLOW);
      this.Fl.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.vf = new JLabel();
      this.ue = new JComboBox();
      this.KK = new JComboBox();
      this.vm = new JButton();
      this.ut = new JScrollPane();
      this.vn = new JTable();
      this.vd = new JPanel();
      this.uu = new JLabel();
      this.xI = new JLabel();
      this.wi = new JScrollPane();
      this.Fl = new JTable();
      this.Ie = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.vf.setFont(new Font("Tahoma", 1, 12));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Ranking Clubes");
      this.vm.setText("X");
      this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.ut.setViewportView(this.vn);
      this.vd.setBackground(new Color(44, 53, 49));
      this.uu.setFont(new Font("Tahoma", 1, 12));
      this.uu.setForeground(new Color(255, 255, 255));
      this.uu.setText("Técnico");
      this.xI.setFont(new Font("Tahoma", 0, 12));
      this.xI.setForeground(new Color(255, 255, 255));
      this.xI.setText("Técnico");
      this.xI.setVerticalAlignment(1);
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addComponent(this.uu, -2, 254, -2).addGap(0, 81, 32767))
                        .addComponent(this.xI, -1, -1, 32767)
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup().addComponent(this.uu, -1, 24, 32767).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.xI, -2, 20, -2)
            )
      );
      this.wi.setBackground(new Color(255, 255, 255));
      this.Fl.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.wi.setViewportView(this.Fl);
      this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/trofeu_s01.png")));
      this.Ie.setText("troféus e títulos");
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(23, 23, 23)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.ut, -2, 408, -2)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.vf, -2, 117, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.ue, -2, 167, -2)
                        )
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           Alignment.TRAILING,
                           var2.createSequentialGroup()
                              .addComponent(this.KK, -2, 222, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 71, -2)
                        )
                        .addComponent(this.wi, -1, 355, 32767)
                        .addComponent(this.vd, -1, -1, 32767)
                        .addComponent(this.Ie, -1, -1, 32767)
                  )
                  .addContainerGap(21, 32767)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(16, 16, 16)
                  .addGroup(
                     var2.createParallelGroup(Alignment.BASELINE)
                        .addComponent(this.vf)
                        .addComponent(this.ue, -2, 23, -2)
                        .addComponent(this.KK, -2, 23, -2)
                        .addComponent(this.vm)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.vd, -2, -1, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.wi, -2, 423, -2)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.Ie, -1, -1, 32767)
                        )
                        .addComponent(this.ut, -2, 530, -2)
                  )
                  .addContainerGap(21, 32767)
            )
      );
   }
}
