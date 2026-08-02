package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
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

public class C0223 extends JPanel {
   private JDialog ub;
   private ArrayList Fj = new ArrayList();
   private ArrayList Fk = new ArrayList();
   private Player CY;
   private JButton vb;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JPanel vd;
   private JScrollPane wi;
   private JScrollPane zf;
   private JTable Fl;
   private JTable vN;

   public C0223(JDialog jDialog, Player player) {
      this.ub = jDialog;
      this.CY = player;
      this.mJ();
      this.pq();
      this.pH();
      this.pI();
      this.mH();
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   public void mH() {
      this.vb.addActionListener(new C0224(this));
   }

   private void pq() {
      C0651 var1 = new C0651(this.Fj);
      this.Fl.setModel(var1);
      int[] var2 = new int[]{30, 120, 25, 25, 20, 20, 20, 20, 30};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.Fl.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.Fl.setAutoResizeMode(3);
      this.Fl.setRowHeight(20);
      this.Fl.setShowGrid(false);
      this.Fl.setDefaultRenderer(C0729.class, new C0620());
      this.Fl.setAutoCreateRowSorter(false);
      this.Fl.getTableHeader().setReorderingAllowed(false);
      this.Fl.setIntercellSpacing(new Dimension(0, 0));
      this.Fl.setCellSelectionEnabled(false);
      this.Fl.setSelectionMode(0);
      this.Fl.setRowSelectionAllowed(true);
      this.Fl.setSelectionBackground(Color.YELLOW);
      this.Fl.setFillsViewportHeight(true);
   }

   private void pH() {
      C0585 var1 = new C0585(this.Fk);
      this.vN.setModel(var1);
      int[] var2 = new int[]{60, 100, 25, 100, 30};

      for (int var3 = 0; var3 < var2.length; var3++) {
         this.vN.getColumnModel().getColumn(var3).setPreferredWidth(var2[var3]);
      }

      this.vN.setAutoResizeMode(3);
      this.vN.setRowHeight(20);
      this.vN.setShowGrid(false);
      this.vN.setDefaultRenderer(C0829.class, new C0606());
      this.vN.setAutoCreateRowSorter(false);
      this.vN.getTableHeader().setReorderingAllowed(false);
      this.vN.setIntercellSpacing(new Dimension(0, 0));
      this.vN.setCellSelectionEnabled(false);
      this.vN.setSelectionMode(0);
      this.vN.setRowSelectionAllowed(true);
      this.vN.setSelectionBackground(Color.YELLOW);
      this.vN.setFillsViewportHeight(true);
   }

   public void pI() {
      int[] var1 = new int[6];
      if (this.CY != null) {
         this.ug.setText(this.CY.getNome() + " (" + GameConstants.rI[this.CY.getPosicao()] + ")");
         ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aflags/" + this.CY.getPais() + ".png"));
         this.ug.setIcon(var2);
         this.Fj.clear();

         for (int var3 = this.CY.gr().size() - 1; var3 >= 0; var3--) {
            this.Fj.add((C0729)this.CY.gr().get(var3));
         }

         for (int var5 = this.CY.gr().size() - 1; var5 >= 0; var5--) {
            var1[0] += ((C0729)this.CY.gr().get(var5)).w();
            var1[1] += ((C0729)this.CY.gr().get(var5)).y();
            var1[2] += ((C0729)this.CY.gr().get(var5)).cv();
            var1[3] += ((C0729)this.CY.gr().get(var5)).cw();
            var1[4] += ((C0729)this.CY.gr().get(var5)).cx();
            var1[5] += ((C0729)this.CY.gr().get(var5)).cD();
         }

         C0729 var6 = new C0729(true, var1);
         this.Fj.add(var6);
         var6.e(this.CY.gx());
         if (this.CY.fL() > 0 && this.CY.getClub() != null) {
            C0729 var4 = new C0729();
            var4.D(this.CY.fL());
            this.Fj.add(var4);
         }

         this.Fk.clear();
         if (this.CY.gv() != null) {
            for (int var7 = this.CY.gv().size() - 1; var7 >= 0; var7--) {
               this.Fk.add(new C0829((C0676)this.CY.gv().get(var7)));
            }
         }

         this.vN.addNotify();
      }
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.vb = new JButton();
      this.wi = new JScrollPane();
      this.Fl = new JTable();
      this.zf = new JScrollPane();
      this.vN = new JTable();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.vd.setBackground(new Color(44, 53, 49));
      this.ug.setBackground(new Color(44, 53, 49));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Jogador Nome");
      this.ug.setOpaque(true);
      this.vb.setText("X");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap(73, 32767)
                  .addComponent(this.ug, -2, 612, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.vb, -2, 53, -2)
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addContainerGap(-1, 32767)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ug, -2, 23, -2).addComponent(this.vb))
                  .addGap(17, 17, 17)
            )
      );
      this.wi.setBackground(new Color(255, 255, 255));
      this.wi.setViewportView(this.Fl);
      this.zf.setBackground(new Color(255, 255, 255));
      this.zf.setViewportView(this.vN);
      this.uh.setBackground(new Color(44, 53, 49));
      this.uh.setFont(new Font("Tahoma", 1, 14));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(0);
      this.uh.setText("Jogos na Temporada");
      this.uh.setOpaque(true);
      this.a_.setBackground(new Color(44, 53, 49));
      this.a_.setFont(new Font("Tahoma", 1, 14));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(0);
      this.a_.setText("Histórico Carreira");
      this.a_.setOpaque(true);
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var2.createParallelGroup(Alignment.TRAILING)
                        .addComponent(this.vd, -1, -1, 32767)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addGroup(var2.createParallelGroup(Alignment.LEADING).addComponent(this.wi, -2, 0, 32767).addComponent(this.a_, -1, -1, 32767))
                              .addGap(18, 18, 18)
                              .addGroup(
                                 var2.createParallelGroup(Alignment.LEADING, false).addComponent(this.zf, -1, 368, 32767).addComponent(this.uh, -1, -1, 32767)
                              )
                        )
                  )
                  .addContainerGap()
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.vd, -2, 41, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.uh, -2, 23, -2).addComponent(this.a_, -2, 23, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var2.createParallelGroup(Alignment.LEADING).addComponent(this.zf).addComponent(this.wi, -1, 497, 32767))
                  .addContainerGap()
            )
      );
   }
}
