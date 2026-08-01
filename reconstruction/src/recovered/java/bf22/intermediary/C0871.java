package bf22.intermediary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0871 extends JPanel {
   private C0915 VH = null;
   private JButton uC;
   private JButton VI;
   private JButton VJ;
   private JButton UK;
   private JTextField VK;
   private JScrollPane ut;
   private JScrollPane wi;
   private JLabel zh;
   private JLabel VL;
   private JLabel QU;
   private JTable VM;

   public C0871() {
      this.mJ();
   }

   private void mJ() {
      this.ut = new JScrollPane();
      this.wi = new JScrollPane();
      this.VM = new JTable();
      this.QU = new JLabel();
      this.VL = new JLabel();
      this.VK = new JTextField();
      this.UK = new JButton();
      this.VJ = new JButton();
      this.zh = new JLabel();
      this.VI = new JButton();
      this.uC = new JButton();
      this.setBackground(new Color(51, 102, 0));
      this.wi.setPreferredSize(new Dimension(316, 202));
      C0887 var1 = new C0887();
      this.VM = new C0872(this, var1);
      this.wi.setViewportView(this.VM);
      this.ut.setViewportView(this.wi);
      this.QU.setFont(new Font("Tahoma", 1, 14));
      this.QU.setForeground(new Color(255, 255, 255));
      this.QU.setHorizontalAlignment(0);
      this.QU.setText("Transferir Jogador");
      this.VL.setForeground(new Color(255, 255, 255));
      this.VL.setHorizontalAlignment(4);
      this.VL.setText("Time:");
      this.UK.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
      this.UK.setToolTipText("");
      this.UK.setCursor(new Cursor(12));
      this.VJ.setIcon(new ImageIcon(this.getClass().getResource("/aicons/icon_search.png")));
      this.VJ.setToolTipText("");
      this.VJ.setCursor(new Cursor(12));
      this.zh.setForeground(new Color(255, 255, 255));
      this.zh.setHorizontalAlignment(0);
      this.zh.setText("transferir para:");
      this.VI.setIcon(new ImageIcon(this.getClass().getResource("/aicons/je.png")));
      this.VI.setText("Confirmar");
      this.VI.setToolTipText("");
      this.VI.setCursor(new Cursor(12));
      this.VI.setEnabled(false);
      this.uC.setIcon(new ImageIcon(this.getClass().getResource("/aicons/exit.png")));
      this.uC.setText("Cancelar");
      this.uC.setToolTipText("");
      this.uC.setCursor(new Cursor(12));
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGroup(
                     var2.createParallelGroup(Alignment.TRAILING)
                        .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.QU, -2, 308, -2))
                        .addGroup(
                           Alignment.LEADING,
                           var2.createSequentialGroup()
                              .addGap(23, 23, 23)
                              .addGroup(
                                 var2.createParallelGroup(Alignment.TRAILING, false)
                                    .addComponent(this.ut)
                                    .addGroup(
                                       var2.createSequentialGroup()
                                          .addComponent(this.VL, -2, 64, -2)
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addComponent(this.VK, -2, 176, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.VJ, -2, 39, -2)
                                    )
                                    .addComponent(this.zh, -1, -1, 32767)
                                    .addGroup(
                                       Alignment.LEADING,
                                       var2.createSequentialGroup()
                                          .addComponent(this.VI, -2, 132, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                          .addComponent(this.uC, -2, 132, -2)
                                    )
                              )
                        )
                  )
                  .addContainerGap(27, 32767)
            )
            .addGroup(
               var2.createParallelGroup(Alignment.LEADING)
                  .addGroup(var2.createSequentialGroup().addGap(0, 159, 32767).addComponent(this.UK).addGap(0, 160, 32767))
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.QU)
                  .addGap(18, 18, 18)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.VK, -2, -1, -2).addComponent(this.VL))
                        .addComponent(this.VJ, -2, 0, 32767)
                  )
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -2, 323, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.zh)
                  .addGap(18, 18, 18)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.VI).addComponent(this.uC))
                  .addContainerGap(26, 32767)
            )
            .addGroup(
               var2.createParallelGroup(Alignment.LEADING)
                  .addGroup(var2.createSequentialGroup().addGap(0, 239, 32767).addComponent(this.UK).addGap(0, 240, 32767))
            )
      );
      this.mK();
      this.nc();
   }

   public void nc() {
      this.VM.getColumnModel().getColumn(0).setPreferredWidth(200);
      this.VM.getColumnModel().getColumn(1).setPreferredWidth(150);
      this.VM.getColumnModel().getColumn(2).setPreferredWidth(52);
      this.VM.setAutoResizeMode(3);
      this.VM.setShowGrid(false);
      this.VM.setDefaultRenderer(C0915.class, new C0603());
      this.VM.setAutoCreateRowSorter(false);
      this.VM.setCellSelectionEnabled(false);
      this.VM.setSelectionMode(0);
      this.VM.setRowSelectionAllowed(true);
      this.VM.setRowHeight(20);
      this.VM.setIntercellSpacing(new Dimension(0, 0));
      this.VM.getTableHeader().setReorderingAllowed(false);
   }

   public void mK() {
      this.uC.addActionListener(new C0873(this));
      this.VJ.addActionListener(new C0874(this));
      this.VM.getSelectionModel().addListSelectionListener(new C0875(this));
      this.VI.addActionListener(new C0876(this));
   }

   public JTable xe() {
      return this.VM;
   }

   public C0915 xf() {
      return this.VH;
   }

   public void e(C0915 c0915) {
      this.VH = c0915;
   }
}
