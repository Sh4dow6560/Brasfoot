package bf22.intermediary;

import mod.recovered.competition.FriendlyMatches;
import mod.recovered.competition.CountryCompetitions;
import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.match.Match;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
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
import mod.recovered.model.Club;

public class C0186 extends JPanel {
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

   public C0186(JDialog jDialog, Club club) {
      this.ub = jDialog;
      this.ul = club;
      this.mJ();
      this.uu.setText(club.getNome() + "  - marcar amistosos");
      this.uu.setIcon(club.kU());
      this.mM();
      this.mH();
      this.mK();
      String[] var3 = new String[]{"Fora", "Casa"};
      this.uq.addItem(var3[0]);
      this.uq.addItem(var3[1]);
      this.uq.setSelectedIndex(0);
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
      this.uv.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 2));
   }

   private void mK() {
      this.un = FriendlyMatches.M(this.ul);

      for (int var1 = 0; var1 < this.un.size(); var1++) {
         this.up.addItem(((C0693)GamePersistence.careerState.R().get((Integer)this.un.get(var1))).f());
      }
   }

   private void mH() {
      this.ud.addActionListener(new C0239(this));
      this.uo.addActionListener(new C0292(this));
   }

   public static boolean d(Club club, int i) {
      new ArrayList();
      ArrayList var2 = ((C0693)GamePersistence.careerState.R().get(i)).h();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         if (((Match)var2.get(var3)).hc() == club || ((Match)var2.get(var3)).hd() == club) {
            return true;
         }
      }

      return false;
   }

   private void mL() {
      if (this.up.getSelectedIndex() < 0 || this.un.size() == 0) {
         JOptionPane.showMessageDialog(this.ub, "Não há datas disponíveis", "Amistoso", 2);
      } else if (this.uk == null) {
         JOptionPane.showMessageDialog(this.ub, "Selecione um adversário", "Amistoso", 2);
      } else if (d(this.uk, (Integer)this.un.get(this.up.getSelectedIndex()))) {
         JOptionPane.showMessageDialog(this.ub, "A seleção adversária já tem um jogo nesta data", "Amistoso", 2);
      } else if (this.ul != this.uk) {
         JOptionPane.showMessageDialog(this.ub, "Amistoso marcado.", "Amistoso", 2);
         FriendlyMatches.b(this.ul, this.uk, this.uq.getSelectedIndex(), (Integer)this.un.get(this.up.getSelectedIndex()));
         if (!this.uk.jZ()) {
            CountryCompetitions var1 = GamePersistence.careerState.s(this.uk.getPais());
            var1.z(false);
         }

         this.un.clear();
         this.up.removeAllItems();
         this.mK();
      }
   }

   public void F(Club club) {
      this.uk = club;
      this.ur.setText("Selecionado: " + this.uk.getNome());
      this.ur.setIcon(this.uk.kU());
   }

   private void mM() {
      this.uw.getSelectionModel().setSelectionMode(1);
      this.uw.addTreeSelectionListener(new C0345(this));

      for (int var1 = 0; var1 < C0696.jz(); var1++) {
         int var2 = ((CountryInfo)C0732.cY().get(var1)).getPais();
         CountryCompetitions var3 = GamePersistence.careerState.s(var2);
         if (var3.jl() && var3.jo() != this.ul) {
            this.um.add(var3.jo());
         }
      }

      DefaultMutableTreeNode var4 = new DefaultMutableTreeNode("Times");
      this.a(var4);
      this.uw.setModel(new DefaultTreeModel(var4));
      this.uw.setRootVisible(false);
      this.uw.expandRow(0);
   }

   private void a(DefaultMutableTreeNode defaultMutableTreeNode) {
      DefaultMutableTreeNode var2 = null;
      Object var3 = null;
      MutableTreeNode var4 = null;
      if (this.um.size() > 0) {
         var2 = new DefaultMutableTreeNode("Seleções");
         defaultMutableTreeNode.add(var2);

         for (int var5 = 0; var5 < this.um.size(); var5++) {
            var4 = new DefaultMutableTreeNode(this.um.get(var5));
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
