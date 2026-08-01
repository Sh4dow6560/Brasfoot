package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0003 extends JPanel {
   private JDialog ub;
   private Club uk;
   private int dF = 0;
   private ArrayList vp = new ArrayList();
   private JButton vq;
   private JButton vb;
   private JButton vc;
   private JLabel ug;
   private JScrollPane ut;
   private JLabel vf;
   private JTable vr;

   public C0003(JDialog jDialog, Club club, C0675 c0675) {
      this.ub = jDialog;
      this.uk = club;
      if (this.uk == c0675.hc()) {
         this.vp.addAll(c0675.hp());
         this.dF = 1;
      } else {
         this.vp.addAll(c0675.hq());
         this.dF = 2;
      }

      this.mJ();
      this.ug.setIcon(this.uk.kU());
      this.ug.setText(this.uk.getNome());
      this.mV();
      this.vr.setRowSelectionInterval(0, 0);
      this.a((JComponent)this);
      this.mH();
   }

   private void a(JComponent jComponent) {
      InputMap var2 = jComponent.getInputMap(1);
      jComponent.getInputMap().put(KeyStroke.getKeyStroke(115, 512), "st");
      ActionMap var3 = this.getActionMap();
      jComponent.getActionMap().put("st", new C0004(this));
   }

   public void mH() {
      this.vq.addActionListener(new C0005(this));
      this.vb.addActionListener(new C0006(this));
      this.vc.addActionListener(new C0007(this));
   }

   private void cE(int i) {
      int var2 = this.vr.getSelectedRow();
      if (var2 >= 0) {
         if (i == 1) {
            if (var2 - 1 >= 0) {
               Collections.swap(this.vp, var2, var2 - 1);
               this.vr.setRowSelectionInterval(var2 - 1, var2 - 1);
            }
         } else if (i == -1 && var2 + 1 < this.vp.size()) {
            Collections.swap(this.vp, var2, var2 + 1);
            this.vr.setRowSelectionInterval(var2 + 1, var2 + 1);
         }
      }

      this.vr.addNotify();
   }

   public void mV() {
      C0646 var1 = new C0646(this.vp);
      this.vr.setModel(var1);
      int[] var2 = new int[]{25, 75, 30, 55, 95};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vr.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vr.setAutoResizeMode(3);
      this.vr.setRowHeight(20);
      this.vr.setShowGrid(false);
      this.vr.setDefaultRenderer(Player.class, new C0616());
      this.vr.setAutoCreateRowSorter(false);
      this.vr.getTableHeader().setReorderingAllowed(false);
      this.vr.setCellSelectionEnabled(false);
      this.vr.setSelectionMode(0);
      this.vr.setRowSelectionAllowed(true);
      this.vr.setSelectionBackground(Color.YELLOW);
      this.vr.setFillsViewportHeight(true);
   }

   private void mJ() {
      this.vf = new JLabel();
      this.ut = new JScrollPane();
      this.vr = new JTable();
      this.vq = new JButton();
      this.ug = new JLabel();
      this.vb = new JButton();
      this.vc = new JButton();
      this.setBackground(new Color(204, 204, 204));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setHorizontalAlignment(0);
      this.vf.setText("Disputa penalties - ordem dos batedores");
      this.ut.setViewportView(this.vr);
      this.vq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/ball.png")));
      this.vq.setText("Jogar");
      this.ug.setForeground(new Color(102, 102, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("time");
      this.vb.setIcon(new ImageIcon(this.getClass().getResource("/aicons/uparray.png")));
      this.vb.setText("subir");
      this.vc.setIcon(new ImageIcon(this.getClass().getResource("/aicons/downarray.png")));
      this.vc.setText("descer");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.vf, -1, -1, 32767)
                        .addComponent(this.ut, -1, 360, 32767)
                        .addComponent(this.ug, -1, -1, 32767)
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createParallelGroup(Alignment.LEADING, false).addComponent(this.vc, -1, -1, 32767).addComponent(this.vb, -1, -1, 32767))
                        .addComponent(this.vq)
                  )
                  .addContainerGap(11, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addComponent(this.vf)
                  .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.vb)
                              .addPreferredGap(ComponentPlacement.UNRELATED)
                              .addComponent(this.vc)
                              .addGap(313, 313, 313)
                              .addComponent(this.vq, -2, 32, -2)
                        )
                        .addComponent(this.ut, -2, 431, -2)
                  )
                  .addGap(25, 25, 25)
            )
      );
   }
}
