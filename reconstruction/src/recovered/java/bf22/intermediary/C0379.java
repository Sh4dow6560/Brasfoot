package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Player;

public class C0379 extends JPanel {
   private C0667 JO = null;
   private ArrayList vp = null;
   private Player CY = null;
   private JDialog ub = null;
   private static Timer Dk;
   private JButton vq;
   private JScrollPane ut;
   private JLabel vf;
   private JTable zS;

   public C0379(JDialog jDialog, C0667 c0667, ArrayList arrayList) {
      this.ub = jDialog;
      this.JO = c0667;
      this.vp = arrayList;
      this.mJ();
      this.vq.setEnabled(false);
      this.vf.setIcon(c0667.cu().kU());
      this.mV();
      this.vq.addActionListener(new C0380(this));
      if (GamePersistence.careerState.bD()) {
         this.oR();
      }
   }

   private void oQ() {
      this.ub.dispose();
   }

   public void oR() {
      Dk = new Timer();
      Dk.schedule(new C0381(this), 0L);
   }

   public void A(Player player) {
      this.CY = player;
      if (player != null) {
         this.JO.f(player);
         this.vq.setEnabled(true);
      }
   }

   public void mV() {
      C0567 var1 = new C0567(this.vp, this);
      this.zS.setModel(var1);
      int[] var2 = new int[]{25, 75, 25, 55, 100};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.zS.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.zS.setAutoResizeMode(3);
      this.zS.setRowHeight(20);
      this.zS.setShowGrid(false);
      this.zS.setDefaultRenderer(Player.class, new C0639());
      this.zS.setAutoCreateRowSorter(false);
      this.zS.getTableHeader().setReorderingAllowed(false);
      this.zS.setCellSelectionEnabled(false);
      this.zS.setSelectionMode(0);
      this.zS.setRowSelectionAllowed(true);
      this.zS.setSelectionBackground(Color.YELLOW);
      this.zS.setFillsViewportHeight(true);
      this.zS.getSelectionModel().addListSelectionListener(new C0382(this));
   }

   private void mJ() {
      this.vf = new JLabel();
      this.ut = new JScrollPane();
      this.zS = new JTable();
      this.vq = new JButton();
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.setBackground(new Color(44, 53, 49));
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 153));
      this.vf.setHorizontalAlignment(0);
      this.vf.setText("Penalty - escolha do batedor");
      this.ut.setViewportView(this.zS);
      this.vq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
      this.vq.setText("Bater");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addComponent(this.vf, Alignment.TRAILING, -1, -1, 32767)
            .addGroup(var1.createSequentialGroup().addGap(20, 20, 20).addComponent(this.ut, -2, 360, -2).addContainerGap(20, 32767))
            .addGroup(Alignment.TRAILING, var1.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.vq, -2, 139, -2).addGap(123, 123, 123))
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.vf)
                  .addGap(18, 18, 18)
                  .addComponent(this.ut, -1, 297, 32767)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.vq, -2, 32, -2)
                  .addContainerGap()
            )
      );
   }
}
