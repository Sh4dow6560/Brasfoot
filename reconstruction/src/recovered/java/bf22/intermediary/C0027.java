package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.geo.CountryInfo;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Coach;

public class C0027 extends JPanel {
   private JDialog ub = null;
   private JButton uc;
   private JButton ud;
   private JComboBox ue;
   private JTextField uf;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;

   public C0027(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();

      for (int var2 = 0; var2 < C0696.jz(); var2++) {
         this.ue.addItem(((CountryInfo)C0732.cY().get(var2)).getNome());
      }

      C0037 var3 = new C0037();
      var3.setPreferredSize(new Dimension(10, 25));
      this.ue.setRenderer(var3);
      this.ue.setMaximumRowCount(12);
      this.ue.setSelectedIndex(0);
      this.ue.setSelectedIndex(C0732.G(29));
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   public void mH() {
      this.ud.addActionListener(new C0080(this));
      this.uc.addActionListener(new C0133(this));
   }

   private void mI() {
      if (this.uf.getText().toString() != "" && !this.uf.getText().isEmpty() && this.uf.getText().length() > 1 && this.uf.getText().length() < 50) {
         Coach.c(this.uf.getText().toString(), C0732.H(this.ue.getSelectedIndex()));
         this.ub.dispose();
      } else {
         JOptionPane.showMessageDialog(this.ub, "Nome inválido", "Adicionar técnico", 2);
      }
   }

   private void mJ() {
      this.ug = new JLabel();
      this.uh = new JLabel();
      this.uf = new JTextField();
      this.a_ = new JLabel();
      this.ue = new JComboBox();
      this.ud = new JButton();
      this.uc = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Adicionar técnico humano");
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(4);
      this.uh.setText("Nome:");
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(4);
      this.a_.setText("Nacionalidade:");
      this.ud.setText("Cancelar");
      this.uc.setText("Adicionar");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.ug, -2, 348, -2)
                        .addGroup(
                           var1.createParallelGroup(Alignment.TRAILING)
                              .addGroup(
                                 Alignment.LEADING,
                                 var1.createSequentialGroup()
                                    .addComponent(this.uh, -2, 73, -2)
                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                    .addComponent(this.uf, -2, 224, -2)
                              )
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(
                                       var1.createParallelGroup(Alignment.TRAILING)
                                          .addGroup(
                                             var1.createSequentialGroup()
                                                .addComponent(this.a_, -2, 73, -2)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(this.ue, -2, 214, -2)
                                          )
                                          .addGroup(
                                             var1.createSequentialGroup()
                                                .addComponent(this.ud, -2, 113, -2)
                                                .addGap(36, 36, 36)
                                                .addComponent(this.uc, -2, 117, -2)
                                          )
                                    )
                              )
                        )
                  )
                  .addContainerGap(18, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addComponent(this.ug)
                  .addGap(34, 34, 34)
                  .addGroup(var1.createParallelGroup(Alignment.TRAILING).addComponent(this.uh).addComponent(this.uf, -2, -1, -2))
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.a_).addComponent(this.ue, -2, -1, -2))
                  .addGap(31, 31, 31)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ud).addComponent(this.uc))
                  .addContainerGap(44, 32767)
            )
      );
   }
}
