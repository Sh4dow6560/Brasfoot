package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;

public class C0468 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private JButton vm;
   private ButtonGroup Kl;
   private JRadioButton MW;
   private JRadioButton MX;
   private JLabel ug;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JCheckBox MY;

   public C0468(JDialog jDialog, Club club) {
      this.uk = club;
      this.ub = jDialog;
      this.mJ();
      this.mH();
      if (club.ll()) {
         this.MY.setSelected(true);
      }

      if (club.lm() == 0) {
         this.MW.setSelected(true);
      } else {
         this.MX.setSelected(true);
      }
   }

   private void sI() {
      if (this.MW.isSelected()) {
         this.uk.bZ(0);
      } else {
         this.uk.bZ(1);
      }
   }

   private void mH() {
      this.vm.addActionListener(new C0469(this));
      this.MY.addActionListener(new C0470(this));
      this.MW.addActionListener(new C0471(this));
      this.MX.addActionListener(new C0472(this));
   }

   private void mJ() {
      this.Kl = new ButtonGroup();
      this.ug = new JLabel();
      this.vm = new JButton();
      this.a_ = new JLabel();
      this.MW = new JRadioButton();
      this.MX = new JRadioButton();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.MY = new JCheckBox();
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.ug.setFont(new Font("Tahoma", 1, 24));
      this.ug.setForeground(new Color(255, 255, 153));
      this.ug.setText("Treino");
      this.vm.setText("X");
      this.a_.setFont(new Font("Tahoma", 0, 12));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("Foco do treino semanal:");
      this.MW.setBackground(new Color(44, 53, 49));
      this.Kl.add(this.MW);
      this.MW.setForeground(new Color(255, 255, 255));
      this.MW.setText("Habilidades principais\n");
      this.MX.setBackground(new Color(44, 53, 49));
      this.Kl.add(this.MX);
      this.MX.setForeground(new Color(255, 255, 255));
      this.MX.setText("Habilidades secundárias");
      this.ur.setFont(new Font("Tahoma", 0, 12));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur.setText("(gol/des/arm/fin)");
      this.us.setFont(new Font("Tahoma", 0, 12));
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setHorizontalAlignment(2);
      this.us.setText("(vel/tec/pas)");
      this.MY.setBackground(new Color(44, 53, 49));
      this.MY.setForeground(new Color(255, 255, 255));
      this.MY.setText("Deixar auxiliar técnico decidir semanalmente");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addComponent(this.ug, -2, 237, -2).addGap(64, 64, 64).addComponent(this.vm, -2, 50, -2))
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(3, 3, 3)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING, false)
                                    .addComponent(this.MY, -1, -1, 32767)
                                    .addComponent(this.a_, -2, 240, -2)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addComponent(this.MW)
                                                .addGroup(var1.createSequentialGroup().addGap(21, 21, 21).addComponent(this.ur, -2, 122, -2))
                                          )
                                          .addGap(33, 33, 33)
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addGroup(var1.createSequentialGroup().addGap(21, 21, 21).addComponent(this.us, -2, 122, -2))
                                                .addComponent(this.MX)
                                          )
                                    )
                              )
                        )
                  )
                  .addContainerGap(28, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ug).addComponent(this.vm, -1, -1, 32767))
                  .addGap(33, 33, 33)
                  .addComponent(this.a_)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.MW).addComponent(this.MX))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.ur).addComponent(this.us))
                  .addGap(37, 37, 37)
                  .addComponent(this.MY)
                  .addContainerGap(30, 32767)
            )
      );
   }
}
