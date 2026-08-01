package bf22.intermediary;

import mod.recovered.game.ScheduleDay;
import mod.recovered.competition.Competition;
import mod.recovered.core.GameConstants;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;

public class C0012 extends JPanel {
   private JDialog ub;
   private ArrayList vK = new ArrayList();
   private ArrayList vL = new ArrayList();
   private Club uk = null;
   private ArrayList u = new ArrayList();
   private static Match vM = null;
   private JButton vm;
   private JComboBox va;
   private JScrollPane ut;
   private JLabel vf;
   private JTable vN;

   public C0012(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.uk = club;
      this.mJ();
      this.mH();
      this.mK();
      this.na();
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.mY();
      this.mG();
      this.Aw();
   }

   private void Aw() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.vL.size(); var2++) {
         if (!((Match)this.vL.get(var2)).e()) {
            var1 = var2;
            break;
         }
      }

      if (var1 < this.vN.getRowCount()) {
         this.vN.setRowSelectionInterval(var1, var1);
         if (var1 > 12) {
            JViewport var5 = (JViewport)this.vN.getParent();
            Rectangle var3 = this.vN.getCellRect(var1 - 5, 0, true);
            Point var4 = var5.getViewPosition();
            var3.setLocation(var3.x - var4.x, var3.y - var4.y);
            this.vN.scrollRectToVisible(var3);
         }
      } else if (this.vN.getRowCount() > 0) {
         this.vN.setRowSelectionInterval(0, 0);
      }
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void mY() {
      this.a(this.vN);
      this.a(this.va);
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(27, 0), "esc");
      jComponent.getActionMap().put("esc", new C0013(this));
   }

   private void mK() {
      this.vf.setText("Calendário - " + this.uk.getNome());
      this.vf.setIcon(this.uk.kU());
      C0624 var1 = new C0624();
      this.va.setPreferredSize(new Dimension(10, 25));
      this.va.setRenderer(var1);
      this.va.setMaximumRowCount(12);
      this.va.addActionListener(new C0014(this));
      this.u.clear();

      for (int var2 = 0; var2 < GamePersistence.careerState.getScheduleDays().size(); var2++) {
         for (int var3 = 0; var3 < ((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var2)).h().size(); var3++) {
            if (((Match)((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var2)).h().get(var3)).getHomeClub() == this.uk
               || ((Match)((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var2)).h().get(var3)).getAwayClub() == this.uk) {
               this.vK.add((Match)((ScheduleDay)GamePersistence.careerState.getScheduleDays().get(var2)).h().get(var3));
            }
         }
      }

      for (int var4 = 0; var4 < this.vK.size(); var4++) {
         if (!this.u.contains(((Match)this.vK.get(var4)).getCompetition())) {
            this.u.add(((Match)this.vK.get(var4)).getCompetition());
         }
      }

      this.va.addItem("Mostrar todos");

      for (int var5 = 0; var5 < this.u.size(); var5++) {
         this.va.addItem(this.u.get(var5));
      }

      this.vL.clear();
      this.vL.addAll(this.vK);
   }

   private void cC(int i) {
      if (i == 0) {
         this.vL.clear();
         this.vL.addAll(this.vK);
      } else if (i > 0) {
         this.vL.clear();
         Competition var2 = (Competition)this.va.getSelectedItem();

         for (int var3 = 0; var3 < this.vK.size(); var3++) {
            if (((Match)this.vK.get(var3)).getCompetition() == var2) {
               this.vL.add((Match)this.vK.get(var3));
            }
         }
      }

      this.vN.addNotify();
      this.Aw();
   }

   public void mH() {
      this.vm.addActionListener(new C0015(this));
      this.vN.addMouseListener(new C0016(this));
   }

   public void mZ() {
      if (vM != null && vM.e()) {
         C0827 var1 = new C0827();
         var1.n(vM);
         JDialog var2 = new JDialog(this.ub);
         C0229 var3 = new C0229(var2, var1);
         var2.add(var3);
         var2.setSize(937, 642);
         var2.setPreferredSize(new Dimension(937, 642));
         var2.setModal(true);
         var2.setResizable(false);
         var2.setLocationRelativeTo(null);
         var2.setUndecorated(true);
         var2.setVisible(true);
      }
   }

   public void na() {
      C0649 var1 = new C0649(this.vL);
      this.vN.setModel(var1);
      int[] var2 = new int[]{90, 135, 60, 135, 170, 80, 80};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vN.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vN.setAutoResizeMode(3);
      this.vN.setRowHeight(20);
      this.vN.setShowGrid(false);
      this.vN.setDefaultRenderer(Match.class, new C0618());
      this.vN.setAutoCreateRowSorter(false);
      this.vN.getTableHeader().setReorderingAllowed(false);
      this.vN.setIntercellSpacing(new Dimension(0, 0));
      this.vN.setCellSelectionEnabled(false);
      this.vN.setSelectionMode(0);
      this.vN.setRowSelectionAllowed(true);
      this.vN.setBackground(Color.BLACK);
      this.vN.setSelectionBackground(new Color(2, 37, 51));
      this.vN.setShowHorizontalLines(true);
      this.vN.setGridColor(Color.BLACK);
      this.vN.setFillsViewportHeight(true);
      this.vN.setRowHeight(30);
      this.vN.getSelectionModel().addListSelectionListener(new C0017(this));
   }

   private void f(Match c0675) {
      vM = c0675;
   }

   private void mJ() {
      this.vf = new JLabel();
      this.ut = new JScrollPane();
      this.vN = new JTable();
      this.vm = new JButton();
      this.va = new JComboBox();
      this.setBackground(new Color(0, 51, 0));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setPreferredSize(new Dimension(820, 602));
      this.setVerifyInputWhenFocusTarget(false);
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Calendário - Cruzeiro");
      this.ut.setViewportView(this.vN);
      this.vm.setText("X");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(36, 36, 36)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.ut, -2, 751, -2)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.vf, -2, 328, -2)
                              .addGap(81, 81, 81)
                              .addComponent(this.va, -2, 216, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 56, -2)
                        )
                  )
                  .addContainerGap(31, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(21, 21, 21)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.va).addComponent(this.vm, -2, 30, -2))
                        .addComponent(this.vf)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.ut, -2, 510, -2)
                  .addGap(28, 28, 28)
            )
      );
   }
}
