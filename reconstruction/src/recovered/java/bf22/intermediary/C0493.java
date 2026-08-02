package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Coach;

public class C0493 extends JPanel {
   private JDialog ub = null;
   private Coach Es = null;
   private JButton MC;
   private JButton vm;
   private JButton yZ;
   private JLabel ug;
   private JLabel uh;
   private JScrollPane ut;
   private JTable MD;

   public C0493(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
      this.mS();
      this.uh.setText(Integer.toString(GamePersistence.careerState.M().size()));
      if (this.MD.getRowCount() > 0) {
         this.MD.setRowSelectionInterval(0, 0);
         this.Es = (Coach)GamePersistence.careerState.M().get(0);
      }

      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   public void mH() {
      this.vm.addActionListener(new C0494(this));
      this.yZ.addActionListener(new C0495(this));
      this.MC.addActionListener(new C0496(this));
   }

   private void mI() {
      if (GamePersistence.careerState.M().size() < 20) {
         JDialog var1 = new JDialog(this.ub);
         C0027 var2 = new C0027(var1);
         var1.add(var2);
         var1.setSize(400, 230);
         var1.setPreferredSize(new Dimension(400, 230));
         var1.setModal(true);
         var1.setResizable(false);
         var1.setLocationRelativeTo(null);
         var1.setUndecorated(true);
         var1.setVisible(true);
         this.MD.addNotify();
         this.uh.setText(Integer.toString(GamePersistence.careerState.M().size()));
      } else {
         JOptionPane.showMessageDialog(this.ub, "Limite de técnicos atingido.", "Adicionar", 2);
      }
   }

   private void nB() {
      if (this.MD.getSelectedRowCount() > 0) {
         int var1 = this.MD.getSelectedRow();
         this.Es = (Coach)GamePersistence.careerState.M().get(var1);
         if (this.Es.getClub() != null) {
            JOptionPane.showMessageDialog(this.ub, "Para remover um técnico é necessário antes demiti-lo do time.", "Remover técnico", 2);
         } else {
            int var2 = -1;
            var2 = JOptionPane.showConfirmDialog(this.ub, "Deseja aposentar o técnico?", "Confirmação", 0);
            if (var2 == 0) {
               this.Es.lP();
               this.Es = null;
               this.MD.addNotify();
            }
         }
      }

      this.uh.setText(Integer.toString(GamePersistence.careerState.M().size()));
   }

   private void mS() {
      C0584 var1 = new C0584(GamePersistence.careerState.M());
      this.MD.setModel(var1);
      int[] var2 = new int[]{120, 120};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.MD.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.MD.setAutoResizeMode(3);
      this.MD.setRowHeight(20);
      this.MD.setShowGrid(false);
      this.MD.setDefaultRenderer(Coach.class, new C0604());
      this.MD.setAutoCreateRowSorter(false);
      this.MD.getTableHeader().setReorderingAllowed(false);
      this.MD.setIntercellSpacing(new Dimension(0, 0));
      this.MD.setCellSelectionEnabled(false);
      this.MD.setSelectionMode(0);
      this.MD.setRowSelectionAllowed(true);
      this.MD.setSelectionBackground(Color.YELLOW);
      this.MD.setFillsViewportHeight(true);
      this.MD.getSelectionModel().addListSelectionListener(new C0497(this));
   }

   private void mJ() {
      this.ug = new JLabel();
      this.ut = new JScrollPane();
      this.MD = new JTable();
      this.yZ = new JButton();
      this.MC = new JButton();
      this.uh = new JLabel();
      this.vm = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Técnicos humanos");
      this.ut.setViewportView(this.MD);
      this.yZ.setText("Remover selecionado");
      this.MC.setText("Adicionar novo");
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setIcon(new ImageIcon(this.getClass().getResource("/aicons/iconcoach16.png")));
      this.uh.setText("12");
      this.vm.setText("X");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(0, 0, 32767)
                              .addComponent(this.yZ, -2, 165, -2)
                              .addGap(28, 28, 28)
                              .addComponent(this.MC, -2, 155, -2)
                              .addGap(51, 51, 51)
                              .addComponent(this.uh)
                        )
                        .addGroup(
                           Alignment.LEADING,
                           var1.createSequentialGroup()
                              .addComponent(this.ug, -2, 157, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.vm, -2, 49, -2)
                        )
                        .addComponent(this.ut, Alignment.LEADING, -2, 0, 32767)
                  )
                  .addGap(29, 29, 29)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm))
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -2, 307, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.yZ).addComponent(this.MC).addComponent(this.uh))
                  .addContainerGap(19, 32767)
            )
      );
   }
}
