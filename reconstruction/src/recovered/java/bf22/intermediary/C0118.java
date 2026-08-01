package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0118 extends JPanel {
   private JDialog ub;
   private ArrayList zU = new ArrayList();
   private JButton zK;
   private JLabel ug;
   private JPanel vd;
   private JScrollPane ut;
   private JTable zV;

   public C0118(JDialog jDialog, ArrayList arrayList) {
      this.ub = jDialog;
      this.zU = arrayList;
      this.mJ();
      this.mH();
      this.mS();
      this.mG();
   }

   private void mG() {
      this.setBackground(C0710.E(C0745.vM().getCorTema(), 1));
   }

   public void mH() {
      this.zK.addActionListener(new C0119(this));
   }

   private void mS() {
      C0659 var1 = new C0659(this.zU);
      this.zV.setModel(var1);
      int[] var2 = new int[]{120, 120, 120, 80};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.zV.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.zV.setAutoResizeMode(3);
      this.zV.setRowHeight(20);
      this.zV.setShowGrid(false);
      this.zV.setDefaultRenderer(C0813.class, new C0631());
      this.zV.setAutoCreateRowSorter(false);
      this.zV.getTableHeader().setReorderingAllowed(false);
      this.zV.setIntercellSpacing(new Dimension(0, 0));
      this.zV.setCellSelectionEnabled(false);
      this.zV.setSelectionMode(0);
      this.zV.setRowSelectionAllowed(true);
      this.zV.setSelectionBackground(Color.YELLOW);
      this.zV.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.ut = new JScrollPane();
      this.zV = new JTable();
      this.zK = new JButton();
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.vd.setBackground(new Color(104, 120, 100));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Demissões na Rodada");
      this.ut.setViewportView(this.zV);
      this.zK.setText("continuar >>");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.ug, -2, 253, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.zK, -2, 114, -2)
                        )
                        .addComponent(this.ut, -2, 547, -2)
                  )
                  .addContainerGap(18, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.ug).addComponent(this.zK))
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -1, 295, 32767)
                  .addContainerGap()
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, 32767).addContainerGap())
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, 32767).addContainerGap())
      );
   }
}
