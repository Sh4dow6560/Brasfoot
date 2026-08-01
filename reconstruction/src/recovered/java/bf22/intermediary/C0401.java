package bf22.intermediary;

import mod.recovered.manager.CoachChangeRecord;
import mod.recovered.transfer.PlayerTransferRecord;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
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
import mod.recovered.model.Club;

public class C0401 extends JPanel {
   private ArrayList uK = new ArrayList();
   private ArrayList LB = new ArrayList();
   private JDialog ub;
   private Club uk = null;
   private JButton vm;
   private JComboBox GD;
   private JScrollPane ut;
   private JLabel vf;
   private JTable LC;

   public C0401(JDialog jDialog, Club club, int i) {
      this.uk = club;
      this.ub = jDialog;
      this.mJ();
      if (i == 1) {
         this.vf.setText("Últimas trocas de técnicos");
      }

      if (i == 0) {
         this.mQ();
         this.mS();
      } else {
         this.GD.setVisible(false);
         int var4 = 0;

         for (int var5 = 0; var5 < GamePersistence.careerState.bn().size(); var5++) {
            this.LB.add((CoachChangeRecord)GamePersistence.careerState.bn().get(var5));
            if (++var4 == 100) {
               break;
            }
         }

         this.sj();
      }

      this.mH();
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void mQ() {
      this.GD.addItem("Todos os times");
      this.GD.addItem(this.uk.getNome());
      this.GD.addActionListener(new C0402(this));
      this.GD.setSelectedIndex(1);
   }

   private void si() {
      this.uK.clear();
      int var1 = 0;
      if (this.GD.getSelectedIndex() == 0) {
         for (int var2 = GamePersistence.careerState.bo().size() - 1; var2 >= 0; var2--) {
            if (((PlayerTransferRecord)GamePersistence.careerState.bo().get(var2)).x() != null) {
               this.uK.add((PlayerTransferRecord)GamePersistence.careerState.bo().get(var2));
               if (++var1 == 200) {
                  break;
               }
            }
         }
      } else {
         for (int var3 = GamePersistence.careerState.bo().size() - 1; var3 >= 0; var3--) {
            if (((PlayerTransferRecord)GamePersistence.careerState.bo().get(var3)).x() != null
               && (((PlayerTransferRecord)GamePersistence.careerState.bo().get(var3)).lZ() == this.uk.lk() || ((PlayerTransferRecord)GamePersistence.careerState.bo().get(var3)).ma() == this.uk.lk())) {
               this.uK.add((PlayerTransferRecord)GamePersistence.careerState.bo().get(var3));
            }
         }
      }

      this.LC.addNotify();
   }

   private void sj() {
      C0589 var1 = new C0589(this.LB);
      this.LC.setModel(var1);
      int[] var2 = new int[]{30, 120, 120, 120};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.LC.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.LC.setAutoResizeMode(3);
      this.LC.setRowHeight(20);
      this.LC.setShowGrid(false);
      this.LC.setDefaultRenderer(CoachChangeRecord.class, new C0609());
      this.LC.setAutoCreateRowSorter(false);
      this.LC.getTableHeader().setReorderingAllowed(false);
      this.LC.setIntercellSpacing(new Dimension(0, 0));
      this.LC.setCellSelectionEnabled(false);
      this.LC.setSelectionMode(0);
      this.LC.setRowSelectionAllowed(true);
      this.LC.setSelectionBackground(Color.YELLOW);
      this.LC.setFillsViewportHeight(true);
   }

   private void mS() {
      C0588 var1 = new C0588(this.uK);
      this.LC.setModel(var1);
      int[] var2 = new int[]{30, 120, 120, 120, 50};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.LC.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.LC.setAutoResizeMode(3);
      this.LC.setRowHeight(20);
      this.LC.setShowGrid(false);
      this.LC.setDefaultRenderer(PlayerTransferRecord.class, new C0608());
      this.LC.setAutoCreateRowSorter(false);
      this.LC.getTableHeader().setReorderingAllowed(false);
      this.LC.setIntercellSpacing(new Dimension(0, 0));
      this.LC.setCellSelectionEnabled(false);
      this.LC.setSelectionMode(0);
      this.LC.setRowSelectionAllowed(true);
      this.LC.setSelectionBackground(Color.YELLOW);
      this.LC.setFillsViewportHeight(true);
   }

   public void mH() {
      this.vm.addActionListener(new C0403(this));
   }

   private void mJ() {
      this.ut = new JScrollPane();
      this.LC = new JTable();
      this.vf = new JLabel();
      this.GD = new JComboBox();
      this.vm = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.ut.setViewportView(this.LC);
      this.vf.setFont(new Font("Tahoma", 1, 12));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Últimas transferências de jogadores");
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
                              .addComponent(this.vf)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.GD, -2, 152, -2)
                              .addGap(59, 59, 59)
                              .addComponent(this.vm)
                        )
                        .addComponent(this.ut, -2, 657, -2)
                  )
                  .addContainerGap(19, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(10, 10, 10)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vf).addComponent(this.GD, -2, -1, -2).addComponent(this.vm))
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -2, 429, -2)
                  .addContainerGap(20, 32767)
            )
      );
   }
}
