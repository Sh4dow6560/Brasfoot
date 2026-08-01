package bf22.intermediary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
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
import javax.swing.JViewport;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0369 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private Coach Es = null;
   private Coach KA = null;
   private int vk = -1;
   private int vl = -1;
   private int KB = -1;
   private ArrayList KC = new ArrayList();
   private ArrayList Fj = new ArrayList();
   public static Comparator KJ = new C0370();
   private JButton Ie;
   private JButton vm;
   private JComboBox ue;
   private JComboBox KK;
   private JLabel ug;
   private JPanel vd;
   private JScrollPane ut;
   private JScrollPane wi;
   private JLabel xI;
   private JLabel Fs;
   private JTable Fl;
   private JTable KD;

   public C0369(JDialog jDialog, Coach coach) {
      this.ub = jDialog;
      this.KA = coach;
      if (coach != null) {
         if (coach.fg() != null) {
            this.vk = coach.fg().getPais();
         } else {
            this.vk = coach.bz();
         }
      }

      this.mJ();
      this.mH();
      this.mQ();
      this.mS();
      this.pq();
      if (this.vk >= 0 && this.vl >= 0) {
         this.ue.setSelectedIndex(this.vl);
      } else {
         this.ue.setSelectedIndex(0);
      }

      if (this.KA != null && this.KB >= 0 && this.KB < this.KC.size()) {
         this.KD.setRowSelectionInterval(this.KB, this.KB);
         if (this.KB > 20) {
            JViewport var3 = (JViewport)this.KD.getParent();
            Rectangle var4 = this.KD.getCellRect(this.KB - 10, 0, true);
            Point var5 = var3.getViewPosition();
            var4.setLocation(var4.x - var5.x, var4.y - var5.y);
            this.KD.scrollRectToVisible(var4);
         }
      } else {
         this.KD.setRowSelectionInterval(0, 0);
      }

      this.KD.requestFocusInWindow();
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   private void mQ() {
      this.ue.addItem("Internacional");

      for (int var1 = 0; var1 < C0745.SR.N().size(); var1++) {
         this.ue.addItem(((C0692)C0745.SR.N().get(var1)).jp());
         if (((C0692)C0745.SR.N().get(var1)).jc() == this.vk) {
            this.vl = var1 + 1;
         }
      }

      C0037 var2 = new C0037();
      var2.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var2);
      this.ue.setMaximumRowCount(12);
      this.ue.setSelectedIndex(0);
      this.ue.addActionListener(new C0371(this));
      this.KK.addItem("Ranking por pontos");
      this.KK.addItem("Ranking por reputação");
      this.KK.addActionListener(new C0425(this));
   }

   private void AR() {
      int var1 = this.ue.getSelectedIndex() - 1;
      int var2 = -1;
      int var3 = -1;
      this.KC.clear();
      if (var1 >= 0) {
         if (var1 < C0745.SR.N().size() && var1 >= 0) {
            var2 = ((C0692)C0745.SR.N().get(var1)).jc();
         }

         for (int var4 = 0; var4 < C0745.SR.L().size(); var4++) {
            var3 = (byte)-1;
            if (((Coach)C0745.SR.L().get(var4)).fg() != null) {
               var3 = ((Coach)C0745.SR.L().get(var4)).fg().getPais();
            } else {
               var3 = ((Coach)C0745.SR.L().get(var4)).bz();
            }

            if (var3 == var2) {
               this.KC.add((Coach)C0745.SR.L().get(var4));
               if (C0745.SR.L().get(var4) == this.KA) {
                  this.KB = this.KC.size() - 1;
               }
            }
         }
      } else {
         for (int var7 = 0; var7 < C0745.SR.L().size(); var7++) {
            this.KC.add((Coach)C0745.SR.L().get(var7));
            if (C0745.SR.L().get(var7) == this.KA) {
               this.KB = this.KC.size() - 1;
            }
         }
      }

      if (this.KK.getSelectedIndex() == 1) {
         Collections.sort(this.KC, KJ);
      }

      this.mS();
      this.KD.setRowSelectionInterval(0, 0);
      this.KD.scrollRectToVisible(new Rectangle(this.KD.getCellRect(0, 0, true)));
      this.KD.requestFocusInWindow();
      int var8 = this.KD.convertRowIndexToModel(this.KD.getSelectedRow());
      if (var8 >= 0) {
         this.Es = (Coach)this.KC.get(var8);
         this.rV();
      }
   }

   public void mH() {
      this.vm.addActionListener(new C0426(this));
      this.Ie.addActionListener(new C0509(this));
   }

   private void rw() {
      this.Ie.setCursor(new Cursor(3));
      C0685.e(this.Es);
      this.Ie.setCursor(new Cursor(12));
   }

   private void mS() {
      C0572 var1 = new C0572(this.KC, this.KK.getSelectedIndex());
      this.KD.setModel(var1);
      int[] var2 = new int[]{40, 125, 125, 50, 50};
      if (this.KK.getSelectedIndex() == 1) {
         int[] var3 = new int[]{40, 125, 125, 150, 0};
         var2 = var3;
      }

      for (int var4 = 0; var4 < var2.length; var4++) {
         this.KD.getColumnModel().getColumn(var4).setPreferredWidth(var2[var4]);
      }

      this.KD.setAutoResizeMode(3);
      this.KD.setRowHeight(20);
      this.KD.setShowGrid(false);
      this.KD.setDefaultRenderer(Coach.class, new C0593(this.KK.getSelectedIndex()));
      this.KD.setAutoCreateRowSorter(false);
      this.KD.getTableHeader().setReorderingAllowed(false);
      this.KD.setIntercellSpacing(new Dimension(0, 0));
      this.KD.setCellSelectionEnabled(false);
      this.KD.setSelectionMode(0);
      this.KD.setRowSelectionAllowed(true);
      this.KD.setSelectionBackground(Color.YELLOW);
      this.KD.setFillsViewportHeight(true);
      this.KD.getSelectionModel().addListSelectionListener(new C0510(this));
   }

   public void rV() {
      int[] var1 = new int[5];
      if (this.Es != null) {
         String var2 = "";
         if (this.Es.getReputacao() < C0710.pZ.length) {
            var2 = C0710.pZ[this.Es.getReputacao()];
         }

         this.Fs.setText(this.Es.dS() + "       (reputação: " + var2 + ")");
         this.Fj.clear();

         for (int var3 = this.Es.lO().size() - 1; var3 >= 0; var3--) {
            this.Fj.add((C0728)this.Es.lO().get(var3));
         }

         this.Fl.addNotify();

         for (int var4 = this.Es.lO().size() - 1; var4 >= 0; var4--) {
            var1[0] += ((C0728)this.Es.lO().get(var4)).w();
            var1[1] += ((C0728)this.Es.lO().get(var4)).cm();
            var1[2] += ((C0728)this.Es.lO().get(var4)).co();
            var1[3] += ((C0728)this.Es.lO().get(var4)).cq();
            var1[4] += ((C0728)this.Es.lO().get(var4)).cr();
         }

         this.xI
            .setText(
               Integer.toString(var1[0])
                  + " J, "
                  + Integer.toString(var1[1])
                  + " V, "
                  + Integer.toString(var1[2])
                  + " D, "
                  + Integer.toString(var1[3])
                  + " Pontos, "
                  + Integer.toString(var1[4])
                  + " Títulos"
            );
      }
   }

   private void pq() {
      C0535 var1 = new C0535(this.Fj);
      this.Fl.setModel(var1);
      int[] var2 = new int[]{20, 120, 20, 20, 20, 20, 20, 20};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Fl.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Fl.setAutoResizeMode(3);
      this.Fl.setRowHeight(20);
      this.Fl.setShowGrid(false);
      this.Fl.setDefaultRenderer(C0728.class, new C0605());
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
      this.ug = new JLabel();
      this.ue = new JComboBox();
      this.vm = new JButton();
      this.ut = new JScrollPane();
      this.KD = new JTable();
      this.vd = new JPanel();
      this.Fs = new JLabel();
      this.xI = new JLabel();
      this.Ie = new JButton();
      this.wi = new JScrollPane();
      this.Fl = new JTable();
      this.KK = new JComboBox();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Ranking de Técnicos");
      this.vm.setText("X");
      this.KD.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.ut.setViewportView(this.KD);
      this.vd.setBackground(new Color(44, 53, 49));
      this.Fs.setFont(new Font("Tahoma", 1, 12));
      this.Fs.setForeground(new Color(255, 255, 102));
      this.Fs.setText("Técnico");
      this.xI.setFont(new Font("Tahoma", 0, 12));
      this.xI.setForeground(new Color(255, 255, 102));
      this.xI.setText("Técnico");
      this.xI.setVerticalAlignment(1);
      this.Ie.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon10.png")));
      this.Ie.setBorderPainted(false);
      this.Ie.setFocusable(false);
      this.Ie.setHorizontalTextPosition(0);
      this.Ie.setOpaque(false);
      this.Ie.setVerticalTextPosition(3);
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var1.createParallelGroup(Alignment.TRAILING, false).addComponent(this.xI, -1, -1, 32767).addComponent(this.Fs, -1, 328, 32767))
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.Ie, -2, 41, -2)
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addComponent(this.Fs, -1, -1, 32767)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.xI)
                  .addContainerGap()
            )
            .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.Ie, -2, 41, -2).addContainerGap(19, 32767))
      );
      this.wi.setBackground(new Color(255, 255, 255));
      this.Fl.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.wi.setViewportView(this.Fl);
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGap(18, 18, 18)
                              .addComponent(this.ug, -2, 154, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.ue, -2, 217, -2)
                        )
                        .addGroup(var2.createSequentialGroup().addContainerGap(18, 32767).addComponent(this.ut, -2, 404, -2))
                  )
                  .addGap(16, 16, 16)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.KK, -2, 222, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 52, -2)
                        )
                        .addComponent(this.vd, Alignment.TRAILING, -1, -1, 32767)
                        .addComponent(this.wi, -1, 422, 32767)
                  )
                  .addGap(18, 18, 18)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(16, 16, 16)
                  .addGroup(
                     var2.createParallelGroup(Alignment.BASELINE)
                        .addComponent(this.ug)
                        .addComponent(this.ue, -2, 23, -2)
                        .addComponent(this.vm)
                        .addComponent(this.KK, -2, 23, -2)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           var2.createSequentialGroup().addComponent(this.vd, -2, -1, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.wi)
                        )
                        .addComponent(this.ut, -2, 588, -2)
                  )
                  .addContainerGap(23, 32767)
            )
      );
      this.ug.getAccessibleContext().setAccessibleName("Ranking Técnicos");
      this.ug.getAccessibleContext().setAccessibleDescription("");
   }
}
