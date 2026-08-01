package bf22.intermediary;

import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;

public class C0398 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private Club ul = null;
   private ArrayList um = new ArrayList();
   ArrayList un = new ArrayList();
   private JButton ud;
   private JButton uo;
   private JComboBox up;
   private JComboBox uq;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JScrollPane ut;
   private JLabel uu;
   private JPanel uv;
   private JTree uw;

   public C0398(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.ul = club;
      this.mJ();
      this.mM();
      this.mH();
      this.uu.setText(club.getNome() + " - marcar amistoso");
      this.uu.setIcon(club.kU());
      this.mK();
      String[] var3 = new String[]{"Fora", "Casa"};
      this.uq.addItem(var3[0]);
      this.uq.addItem(var3[1]);
      this.uq.setSelectedIndex(0);
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 1));
      this.uv.setBackground(GameConstants.E(GamePersistence.vM().getCorTema(), 2));
   }

   private void mK() {
      this.un = C0937.L(this.ul);

      for (int var1 = 0; var1 < this.un.size(); var1++) {
         this.up.addItem(((C0693)GamePersistence.SR.R().get((Integer)this.un.get(var1))).f());
      }
   }

   private void mH() {
      this.ud.addActionListener(new C0451(this));
      this.uo.addActionListener(new C0504(this));
   }

   private void mL() {
      if (this.up.getSelectedIndex() < 0 || this.un.size() == 0) {
         JOptionPane.showMessageDialog(this.ub, "Não há datas disponíveis", "Amistoso", 2);
      } else if (this.uk == null) {
         JOptionPane.showMessageDialog(this.ub, "Selecione um adversário", "Amistoso", 2);
      } else if (this.ul != this.uk) {
         int var1 = -1;
         var1 = C0937.a(this.ul, this.uk, this.uq.getSelectedIndex(), (Integer)this.un.get(this.up.getSelectedIndex()));
         String[] var2 = new String[]{
            "Amistoso recusado",
            "Amistoso marcado",
            this.uk.getNome() + " já tem um amistoso nesta data",
            "Quer um valor de " + ClubFinances.c(C0937.xY()) + "\n Deseja aceitar?"
         };
         if (var1 >= 0 && var1 < 3) {
            JOptionPane.showMessageDialog(this.ub, var2[var1], "Amistoso", 2);
         } else if (var1 == 3) {
            int var3 = -1;
            var3 = JOptionPane.showConfirmDialog(this.ub, var2[3], "Amistoso", 0);
            if (var3 == 0) {
               var1 = 1;
               this.ul.w(C0937.xY(), -1);
            }
         }

         if (var1 == 1) {
            C0937.b(this.ul, this.uk, this.uq.getSelectedIndex(), (Integer)this.un.get(this.up.getSelectedIndex()));
            this.un.clear();
            this.up.removeAllItems();
            this.mK();
         }
      }
   }

   public void F(Club club) {
      this.uk = club;
      this.ur.setText("Selecionado: " + this.uk.getNome());
      this.ur.setIcon(this.uk.kU());
   }

   private void mM() {
      this.uw.getSelectionModel().setSelectionMode(1);
      this.uw.addTreeSelectionListener(new C0550(this));

      for (int var1 = 0; var1 < GamePersistence.SR.P().size(); var1++) {
         if (!((Club)GamePersistence.SR.P().get(var1)).kn()) {
            this.um.add((Club)GamePersistence.SR.P().get(var1));
            Collections.sort(this.um, C1007.VS);
         }
      }

      DefaultMutableTreeNode var2 = new DefaultMutableTreeNode("Times");
      this.a(var2);
      this.uw.setModel(new DefaultTreeModel(var2));
   }

   private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
      DefaultMutableTreeNode var2 = null;
      DefaultMutableTreeNode var3 = null;
      MutableTreeNode var4 = null;

      for (int var5 = 0; var5 < GamePersistence.SR.N().size(); var5++) {
         var2 = new DefaultMutableTreeNode(((CountryCompetitions)GamePersistence.SR.N().get(var5)).jp());
         defaultMutableTreeNode.add(var2);

         for (int var6 = 0; var6 < ((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().size(); var6++) {
            if (((C0924)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).yi().yK().size() > 0) {
               var3 = new DefaultMutableTreeNode(((C0924)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).getNome());
               var2.add(var3);

               for (int var7 = 0; var7 < ((C0924)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).yi().yK().size(); var7++) {
                  var4 = new DefaultMutableTreeNode(((C0924)((CountryCompetitions)GamePersistence.SR.N().get(var5)).eb().get(var6)).yi().yK().get(var7));
                  var3.add(var4);
               }
            }
         }

         if (((CountryCompetitions)GamePersistence.SR.N().get(var5)).ek().size() > 0) {
            var3 = new DefaultMutableTreeNode("Regionais");
            var2.add(var3);

            for (int var16 = 0; var16 < ((CountryCompetitions)GamePersistence.SR.N().get(var5)).ek().size(); var16++) {
               var4 = new DefaultMutableTreeNode(((CountryCompetitions)GamePersistence.SR.N().get(var5)).ek().get(var16));
               var3.add(var4);
            }
         }
      }

      if (this.um.size() > 0) {
         var2 = new DefaultMutableTreeNode("Internacionais");
         defaultMutableTreeNode.add(var2);

         for (int var15 = 0; var15 < this.um.size(); var15++) {
            var4 = new DefaultMutableTreeNode(this.um.get(var15));
            var2.add(var4);
         }
      }
   }

   private void mJ() {
      this.uu = new JLabel();
      this.uv = new JPanel();
      this.uh = new JLabel();
      this.up = new JComboBox();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.uq = new JComboBox();
      this.uo = new JButton();
      this.ut = new JScrollPane();
      this.uw = new JTree();
      this.ud = new JButton();
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.uu.setFont(new Font("Tahoma", 1, 12));
      this.uu.setForeground(new Color(255, 255, 102));
      this.uu.setText("Marcar amistoso");
      this.uv.setBackground(new Color(104, 120, 100));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(4);
      this.uh.setText("Escolha uma data disponível:");
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(4);
      this.a_.setText("Escolha um adversário:");
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("Time selecionado:");
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setHorizontalAlignment(4);
      this.us.setText("Local do jogo:");
      this.uo.setText("Propor amistoso");
      this.ut.setViewportView(this.uw);
      GroupLayout var1 = new GroupLayout(this.uv);
      this.uv.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(25, 25, 25)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addComponent(this.uh, -2, 164, -2).addGap(18, 18, 18).addComponent(this.up, -2, 141, -2))
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.a_, -2, 164, -2)
                              .addGap(18, 18, 18)
                              .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.ur, -2, 234, -2).addComponent(this.ut, -2, 243, -2))
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.us, -2, 164, -2)
                              .addGap(18, 18, 18)
                              .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.uo, -2, 180, -2).addComponent(this.uq, -2, 141, -2))
                        )
                  )
                  .addContainerGap(56, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(25, 25, 25)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.up, -2, -1, -2).addComponent(this.uh))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.a_).addComponent(this.ut, -2, 248, -2))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.ur)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.us).addComponent(this.uq, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.RELATED, 48, 32767)
                  .addComponent(this.uo)
                  .addGap(42, 42, 42)
            )
      );
      this.ud.setText("X");
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addGroup(
                     var2.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.uv, -2, -1, -2)
                        .addGroup(var2.createSequentialGroup().addComponent(this.uu, -2, 434, -2).addGap(18, 18, 18).addComponent(this.ud, -2, 52, -2))
                  )
                  .addContainerGap(23, 32767)
            )
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var2.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addGroup(var2.createParallelGroup(Alignment.BASELINE).addComponent(this.uu).addComponent(this.ud))
                  .addGap(18, 18, 18)
                  .addComponent(this.uv, -2, -1, -2)
                  .addContainerGap(27, 32767)
            )
      );
   }
}
