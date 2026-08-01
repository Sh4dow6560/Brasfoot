package bf22.intermediary;

import mod.recovered.transfer.TransferNegotiation;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableRowSorter;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0231 extends JPanel {
   private Club zu = null;
   private Club Af = null;
   private Player FL = null;
   private JDialog ub;
   private boolean FM = false;
   private static boolean Ag = false;
   private JButton FN;
   private JButton FO;
   private JButton FP;
   private JButton FQ;
   private JButton vb;
   private JLabel ug;
   private JLabel uh;
   private JPanel vd;
   private JScrollPane ut;
   private JTable FR;

   public C0231(JDialog jDialog, Club club, Club club2) {
      this.ub = jDialog;
      this.Af = club;
      this.zu = club2;
      Ag = false;
      if (this.Af == this.zu) {
         this.FM = true;
      } else {
         this.FM = false;
      }

      UIManager.put("ProgressBar.selectionForeground", Color.WHITE);
      UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
      this.mJ();
      this.mH();
      this.pK();
      this.pJ();
      this.ug.setIcon(this.zu.x(30, 30));
      if (!this.FM) {
         this.FQ.setVisible(false);
         this.FP.setVisible(false);
         this.FO.setVisible(false);
         if (this.Af.ky().size() >= 20) {
            this.FN.setEnabled(false);
         } else {
            this.FN.setEnabled(true);
         }
      } else {
         this.FN.setVisible(false);
         this.FO.setVisible(true);
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 1));
   }

   public void z(Player player) {
      this.FL = player;
   }

   public void pJ() {
      C0579 var1 = new C0579(this.zu, this);
      this.FR.setModel(var1);
      int[] var2 = new int[]{20, 25, 55, 110, 25, 25, 120, 100, 60, 90, 80};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.FR.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.FR.setAutoResizeMode(3);
      this.FR.setRowHeight(20);
      this.FR.setShowGrid(false);
      this.FR.setDefaultRenderer(Player.class, new C0601());
      this.FR.setAutoCreateRowSorter(false);
      this.FR.getTableHeader().setReorderingAllowed(false);
      this.FR.setCellSelectionEnabled(false);
      this.FR.setSelectionMode(0);
      this.FR.setRowSelectionAllowed(true);
      this.FR.setSelectionBackground(Color.YELLOW);
      this.FR.setFillsViewportHeight(true);
      if (this.FR.getRowCount() > 0) {
         this.FR.setRowSelectionInterval(0, 0);
      }

      this.FR.getSelectionModel().addListSelectionListener(new C0232(this));
      TableRowSorter var4 = new TableRowSorter<>(this.FR.getModel());
      this.FR.setRowSorter(var4);
      var4.setComparator(1, C1007.abe);
      var4.setComparator(3, C1007.abk);
      var4.setComparator(4, C1007.VU);
      var4.setComparator(5, C1007.aba);
      var4.setComparator(6, C1007.aaI);
      var4.setComparator(7, C1007.aaH);
      var4.setComparator(9, C1007.aaW);
      if (((C0579)this.FR.getModel()).getRowCount() > 0) {
         this.FR.setRowSelectionInterval(0, 0);
      }
   }

   public static boolean nX() {
      return Ag;
   }

   public void pK() {
      if (this.FM) {
         this.uh.setText("Vagas: " + Integer.toString(this.zu.ky().size()) + "/" + Integer.toString(20));
      } else {
         this.uh.setText(Integer.toString(this.zu.ky().size()) + " jogadores");
      }
   }

   public void mH() {
      this.vb.addActionListener(new C0233(this));
      this.FQ.addActionListener(new C0234(this));
      this.FP.addActionListener(new C0235(this));
      this.FN.addActionListener(new C0236(this));
      this.FO.addActionListener(new C0237(this));
   }

   private boolean pL() {
      if (this.FM) {
         return false;
      }

      if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
         TransferNegotiation.l(false);
         if (this.Af.ky().size() < 20) {
            JDialog var1 = new JDialog(this.ub);
            C0185 var2 = new C0185(var1, this.FL, this.Af, true);
            var1.add(var2);
            var1.setSize(373, 300);
            var1.setPreferredSize(new Dimension(373, 300));
            var1.setModal(true);
            var1.setResizable(false);
            var1.setLocationRelativeTo(null);
            var1.setUndecorated(true);
            var1.setVisible(true);
            if (TransferNegotiation.cO()) {
               this.pJ();
            }
         } else {
            JOptionPane.showMessageDialog(this.ub, "Limite de juniores alcançado", "", 2);
         }
      }

      return true;
   }

   public void pM() {
      if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
         int var1 = -1;
         var1 = JOptionPane.showConfirmDialog(this.ub, "Deseja dispensar o junior " + this.FL.getNome() + "?", "Confirmar", 0);
         if (var1 == 0) {
            this.FL.n(null);
            this.zu.ky().remove(this.FL);
            GamePersistence.SR.Q().remove(this.FL);
            ((C0579)this.FR.getModel()).fireTableDataChanged();
            this.FR.addNotify();
            if (this.FR.getRowCount() > 0) {
               this.FR.addRowSelectionInterval(0, 0);
            } else {
               this.FL = null;
            }

            this.pK();
         }
      }
   }

   public void pN() {
      if (this.zu.kc().size() >= 35) {
         JOptionPane.showMessageDialog(this.ub, "Não há vagas no time profissional", "", 2);
      } else if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
         int var1 = -1;
         var1 = JOptionPane.showConfirmDialog(this.ub, "Deseja promover o junior " + this.FL.getNome() + "?", "Confirmar", 0);
         if (var1 == 0) {
            C0677.a(false, this.FL, this.zu);
            this.FL.aB(300);
            ((C0579)this.FR.getModel()).fireTableDataChanged();
            this.FR.addNotify();
            if (this.FR.getRowCount() > 0) {
               this.FR.addRowSelectionInterval(0, 0);
            } else {
               this.FL = null;
            }

            Ag = true;
            this.pK();
         }
      }
   }

   public void pO() {
      ((C0579)this.FR.getModel()).fireTableDataChanged();
      this.FR.addNotify();
   }

   private void pP() {
      if (this.FR.getSelectedRow() >= 0 && this.FL != null) {
         JDialog var1 = new JDialog(this.ub);
         C0551 var2 = new C0551(var1, this, this.FL);
         var1.add(var2);
         var1.setSize(373, 300);
         var1.setPreferredSize(new Dimension(373, 300));
         var1.setModal(true);
         var1.setResizable(false);
         var1.setLocationRelativeTo(null);
         var1.setUndecorated(true);
         var1.setVisible(true);
      }
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.vb = new JButton();
      this.uh = new JLabel();
      this.ut = new JScrollPane();
      this.FR = new JTable();
      this.FQ = new JButton();
      this.FP = new JButton();
      this.FN = new JButton();
      this.FO = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.vd.setBackground(new Color(44, 53, 49));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon09.png")));
      this.ug.setText("Academia de Juniores");
      this.vb.setText("X");
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(4);
      this.uh.setText("");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug, -2, 282, -2)
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.uh, -2, 91, -2)
                  .addGap(26, 26, 26)
                  .addComponent(this.vb, -2, 49, -2)
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.uh))
                        .addComponent(this.vb, -2, 24, -2)
                  )
                  .addContainerGap(-1, 32767)
            )
      );
      this.ut.setViewportView(this.FR);
      this.FQ.setText("Promover");
      this.FP.setText("Dispensar");
      this.FN.setText("Propor compra");
      this.FO.setText("Definir apelido");
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, 32767).addContainerGap())
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.ut, -2, 722, -2)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.FQ, -2, 109, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.FP, -2, 109, -2)
                              .addGap(100, 100, 100)
                              .addComponent(this.FN, -2, 133, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.FO, -2, 133, -2)
                        )
                  )
                  .addContainerGap(17, 32767)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.vd, -2, 46, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.ut, -2, 435, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var2.createParallelGroup(Alignment.BASELINE).addComponent(this.FQ).addComponent(this.FP).addComponent(this.FN).addComponent(this.FO)
                  )
                  .addContainerGap(26, 32767)
            )
      );
   }
}
