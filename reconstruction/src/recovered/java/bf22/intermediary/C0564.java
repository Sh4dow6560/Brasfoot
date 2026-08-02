package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.GroupLayout;
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
import mod.recovered.model.Player;

public class C0564 extends JPanel {
   private JDialog ub;
   private ArrayList uK = new ArrayList();
   private int vk = -1;
   private int vl = -1;
   public static Comparator uV = new C0565();
   private JButton vm;
   private JComboBox ue;
   private JScrollPane ut;
   private JLabel vf;
   private JTable vn;

   public C0564(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
      this.mS();
      this.mQ();
      if (club != null) {
         this.cD(club.getPais());
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   public void cD(int i) {
      int var2 = 0;

      for (int var3 = 0; var3 < GamePersistence.careerState.N().size(); var3++) {
         if (((CountryCompetitions)GamePersistence.careerState.N().get(var3)).jc() == i) {
            var2 = var3 + 1;
            break;
         }
      }

      this.ue.setSelectedIndex(var2);
   }

   public void mT() {
      int var1 = this.ue.getSelectedIndex() - 1;
      if (var1 >= 0) {
         this.vl = ((CountryCompetitions)GamePersistence.careerState.N().get(var1)).jc();
      } else {
         this.vl = -1;
      }

      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 < GamePersistence.careerState.O().size(); var3++) {
         boolean var4 = false;
         if (this.vl == -1) {
            var4 = true;
         } else if (((Player)GamePersistence.careerState.O().get(var3)).getClub() != null && ((Player)GamePersistence.careerState.O().get(var3)).getClub().getPais() == this.vl) {
            var4 = true;
         }

         if (var4) {
            int var5 = ((Player)GamePersistence.careerState.O().get(var3)).gs();
            if (var5 > 0) {
               int var6 = ((Player)GamePersistence.careerState.O().get(var3)).gu();
               var2.add(new C0721(((Player)GamePersistence.careerState.O().get(var3)).getNome(), ((Player)GamePersistence.careerState.O().get(var3)).getClub(), var5, var6));
            }
         }
      }

      Collections.sort(var2, uV);
      this.uK.clear();

      for (int var7 = 0; var7 < var2.size(); var7++) {
         this.uK.add((C0721)var2.get(var7));
         if (var7 == 400) {
            break;
         }
      }

      this.vn.addNotify();
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
      this.ue.addActionListener(new C0001(this));
   }

   private void mU() {
      this.mT();
   }

   private void mS() {
      C0645 var1 = new C0645(this.uK);
      this.vn.setModel(var1);
      int[] var2 = new int[]{10, 120, 120, 30, 30};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vn.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vn.setAutoResizeMode(3);
      this.vn.setRowHeight(20);
      this.vn.setShowGrid(false);
      this.vn.setFont(new Font("Helvetica", 0, 12));
      this.vn.setDefaultRenderer(C0721.class, new C0591());
      this.vn.setAutoCreateRowSorter(false);
      this.vn.getTableHeader().setReorderingAllowed(false);
      this.vn.setIntercellSpacing(new Dimension(0, 0));
      this.vn.setCellSelectionEnabled(false);
      this.vn.setSelectionMode(0);
      this.vn.setRowSelectionAllowed(true);
      this.vn.setSelectionBackground(Color.YELLOW);
      this.vn.setFillsViewportHeight(true);
   }

   public void mH() {
      this.vm.addActionListener(new C0002(this));
   }

   private void mJ() {
      this.vf = new JLabel();
      this.ut = new JScrollPane();
      this.vn = new JTable();
      this.ue = new JComboBox();
      this.vm = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.vf.setFont(new Font("Tahoma", 1, 12));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Líderes de assistências");
      this.vn.setModel(new DefaultTableModel(new Object[0][], new String[0]));
      this.ut.setViewportView(this.vn);
      this.vm.setText("X");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.vf, -2, 211, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, 117, 32767)
                              .addComponent(this.ue, -2, 167, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.vm, -2, 49, -2)
                        )
                        .addComponent(this.ut, -2, 557, -2)
                  )
                  .addContainerGap(15, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ue, -2, 23, -2).addComponent(this.vf).addComponent(this.vm))
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -2, 530, -2)
                  .addContainerGap(18, 32767)
            )
      );
   }
}
