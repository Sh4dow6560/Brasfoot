package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0539 extends JPanel {
   private JDialog ub;
   private JButton vm;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JLabel vx;
   private JLabel vy;

   public C0539(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.mH();
      if (C0745.vL()) {
         this.vx.setVisible(false);
      }
   }

   public void mH() {
      this.vm.addActionListener(new C0540(this));
   }

   private void mJ() {
      this.ug = new JLabel();
      this.uh = new JLabel();
      this.vm = new JButton();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.vx = new JLabel();
      this.vy = new JLabel();
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.ug.setFont(new Font("Tahoma", 1, 24));
      this.ug.setForeground(new Color(255, 255, 153));
      this.ug.setText("Brasfoot");
      this.uh.setFont(new Font("Tahoma", 1, 12));
      this.uh.setForeground(new Color(255, 255, 153));
      this.uh.setText("www.brasfoot.com");
      this.vm.setText("X");
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setText("Beta Testers: Jéferson Santos; Jean V. Silva; Dom Rubem; Galba Novaes.");
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setText("");
      this.ur.setToolTipText("");
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setText("Jogo criado por Emmanuel Santos. Todos os direitos reservados.");
      this.us.setToolTipText("");
      this.vx.setFont(new Font("Tahoma", 1, 12));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setText("Cópia não registrada");
      this.vy.setForeground(new Color(255, 255, 153));
      this.vy.setText("");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(26, 26, 26)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.a_, -2, 447, -2).addComponent(this.uh, -2, 171, -2))
                              .addContainerGap(20, 32767)
                        )
                        .addGroup(
                           Alignment.TRAILING,
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.TRAILING)
                                    .addGroup(var1.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.vx, -2, 207, -2))
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.ug, -2, 237, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                          .addComponent(this.vm, -2, 50, -2)
                                    )
                              )
                              .addGap(32, 32, 32)
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.vy)
                                    .addComponent(this.us, -2, 447, -2)
                                    .addComponent(this.ur, -2, 447, -2)
                              )
                              .addGap(0, 0, 32767)
                        )
                  )
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(var1.createParallelGroup(Alignment.LEADING, false).addComponent(this.vm, -1, -1, 32767).addComponent(this.ug, -1, -1, 32767))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uh).addComponent(this.vx))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.vy)
                  .addGap(4, 4, 4)
                  .addComponent(this.a_)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.ur)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.us)
                  .addContainerGap(23, 32767)
            )
      );
   }
}
