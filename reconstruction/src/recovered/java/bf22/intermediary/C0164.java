package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0164 extends JPanel {
   private JDialog ub;
   private Club ul = null;
   private ArrayList BQ = new ArrayList();
   private Player yK = null;
   private JButton yW;
   private JButton ud;
   private JButton BR;
   private JButton BS;
   private JButton BT;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JPanel vd;
   private JScrollPane ut;
   private JLabel zh;
   private JSpinner BU;
   private JTree BV;

   public C0164(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.ul = club;
      this.mJ();
      this.mM();
      this.mH();
      this.BU.setModel(new SpinnerNumberModel(this.oz(), 1, 99, 1));
      this.zh.setText("");
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 1));
      this.vd.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
   }

   private void mH() {
      this.ud.addActionListener(new C0165(this));
      this.BT.addActionListener(new C0166(this));
      this.yW.addActionListener(new C0167(this));
      this.BR.addActionListener(new C0168(this));
      this.BS.addActionListener(new C0169(this));
   }

   private void ov() {
      for (int var1 = 0; var1 < this.ul.kc().size(); var1++) {
         ((Player)this.ul.kc().get(var1)).ah(0);
      }

      this.ox();
   }

   private void ow() {
      if (this.yK != null) {
         this.yK.ah(0);
      }

      this.ox();
   }

   private void nz() {
      for (int var1 = 0; var1 < this.ul.kc().size(); var1++) {
         ((Player)this.ul.kc().get(var1)).ah(0);
      }

      int[][] var5 = new int[][]{{1, 12, 22}, {2, 6, 13, 16}, {3, 4, 14, 15}, {7, 10, 19, 20}, {9, 11, 21, 23}, {5, 8, 17, 18}};
      int[] var2 = new int[6];

      for (int var3 = 0; var3 < this.ul.kc().size(); var3++) {
         int var4 = ((Player)this.ul.kc().get(var3)).getPosicao();
         if (var4 == 3 && ((Player)this.ul.kc().get(var3)).fF() == 0) {
            var4 = 5;
         }

         if (var2[var4] < var5[var4].length) {
            ((Player)this.ul.kc().get(var3)).ah(var5[var4][var2[var4]]);
            var2[var4]++;
         }
      }

      for (int var6 = 0; var6 < this.ul.kc().size(); var6++) {
         if (((Player)this.ul.kc().get(var6)).fn() <= 0) {
            ((Player)this.ul.kc().get(var6)).ah(this.oz());
         }
      }

      this.ox();
   }

   private void ox() {
      this.BV.removeAll();
      this.BQ.clear();
      this.mM();
   }

   private void oy() {
      this.zh.setText("");
      if (this.yK != null) {
         int var1 = (Integer)this.BU.getValue();
         if (var1 > 0 && var1 <= 99 && !this.cY(var1)) {
            this.yK.ah(var1);
            this.ox();
         } else {
            this.zh.setText("Número já escolhido");
         }
      } else {
         this.zh.setText("Selecione um jogador");
      }
   }

   private int oz() {
      ArrayList var1 = new ArrayList();
      int var2 = 1;

      for (int var3 = 0; var3 < this.ul.kc().size(); var3++) {
         if (((Player)this.ul.kc().get(var3)).fn() > 0) {
            var1.add(((Player)this.ul.kc().get(var3)).fn());
         }
      }

      for (int var6 = 1; var6 < 100; var6++) {
         boolean var4 = false;

         for (int var5 = 0; var5 < var1.size(); var5++) {
            if (((Integer)var1.get(var5)).equals(var6)) {
               var4 = true;
               break;
            }
         }

         if (!var4) {
            var2 = var6;
            break;
         }
      }

      return var2;
   }

   private boolean cY(int i) {
      for (int var2 = 0; var2 < this.ul.kc().size(); var2++) {
         if (((Player)this.ul.kc().get(var2)).fn() == i) {
            return true;
         }
      }

      return false;
   }

   public void y(Player player) {
   }

   private void mM() {
      this.BV.getSelectionModel().setSelectionMode(1);
      this.BV.addTreeSelectionListener(new C0170(this));

      for (int var1 = 0; var1 < this.ul.kc().size(); var1++) {
         this.BQ.add((Player)this.ul.kc().get(var1));
      }

      Collections.sort(this.BQ, C1007.aaR);
      DefaultMutableTreeNode var2 = new DefaultMutableTreeNode("Elenco");
      this.a(var2);
      this.BV.setModel(new DefaultTreeModel(var2));
      this.BV.setRootVisible(false);
      this.BV.expandRow(0);
   }

   private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
      DefaultMutableTreeNode var2 = null;
      Object var3 = null;
      MutableTreeNode var4 = null;
      if (this.BQ.size() > 0) {
         var2 = new DefaultMutableTreeNode("Jogadores");
         defaultMutableTreeNode.add(var2);

         for (int var5 = 0; var5 < this.BQ.size(); var5++) {
            var4 = new DefaultMutableTreeNode(this.BQ.get(var5));
            var2.add(var4);
         }
      }
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ut = new JScrollPane();
      this.BV = new JTree();
      this.uh = new JLabel();
      this.BT = new JButton();
      this.a_ = new JLabel();
      this.yW = new JButton();
      this.zh = new JLabel();
      this.BU = new JSpinner();
      this.BR = new JButton();
      this.BS = new JButton();
      this.ug = new JLabel();
      this.ud = new JButton();
      this.setBackground(new Color(42, 64, 29));
      this.vd.setBackground(new Color(84, 127, 59));
      this.ut.setViewportView(this.BV);
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setText("Selecione um jogador:");
      this.BT.setText("escolher");
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setText("Escolha um número entre 1 e 99:");
      this.yW.setText("escolha automática");
      this.zh.setForeground(new Color(255, 204, 153));
      this.zh.setHorizontalAlignment(0);
      this.zh.setText("jLabel4");
      this.BR.setText("limpar todos");
      this.BS.setText("limpa selecionado");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(this.ut)
                        .addComponent(this.uh)
                        .addGroup(var1.createSequentialGroup().addComponent(this.yW).addGap(18, 18, 18).addComponent(this.BR, -2, 117, -2))
                  )
                  .addPreferredGap(ComponentPlacement.RELATED, 41, 32767)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.a_, Alignment.TRAILING)
                        .addComponent(this.BU, Alignment.TRAILING, -2, 91, -2)
                        .addComponent(this.BT, Alignment.TRAILING, -2, 91, -2)
                        .addComponent(this.zh, Alignment.TRAILING, -2, 164, -2)
                        .addComponent(this.BS, Alignment.TRAILING)
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(this.uh)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.ut, -2, 0, 32767)
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(41, 41, 41)
                              .addComponent(this.a_)
                              .addGap(18, 18, 18)
                              .addComponent(this.BU, -2, -1, -2)
                              .addGap(18, 18, 18)
                              .addComponent(this.BT)
                              .addGap(18, 18, 18)
                              .addComponent(this.zh)
                              .addPreferredGap(ComponentPlacement.RELATED, 125, 32767)
                              .addComponent(this.BS)
                        )
                  )
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.yW).addComponent(this.BR))
                  .addGap(15, 15, 15)
            )
      );
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setText("Numeração do elenco");
      this.ud.setText("X");
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING, false)
                        .addGroup(
                           var2.createSequentialGroup()
                              .addComponent(this.ug, -2, 146, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.ud, -2, 49, -2)
                        )
                        .addComponent(this.vd, -2, -1, -2)
                  )
                  .addContainerGap(20, 32767)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(17, 17, 17)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.ud))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vd, -2, -1, -2)
                  .addContainerGap(24, 32767)
            )
      );
   }
}
