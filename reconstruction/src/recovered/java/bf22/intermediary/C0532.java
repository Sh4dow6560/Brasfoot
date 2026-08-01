package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0532 extends JPanel {
   private Club zu;
   private Player uz = null;
   private JDialog ub;
   private static boolean Ag = false;
   private JButton Np;
   private JButton BZ;
   private JComboBox Nq;
   private JTextField Nr;
   private JLabel ug;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;
   private JLabel vx;
   private JLabel vy;
   private JLabel uF;

   public static boolean nX() {
      return Ag;
   }

   public C0532(JDialog jDialog, Club club, Player player) {
      this.ub = jDialog;
      this.zu = club;
      this.uz = player;
      Ag = false;
      this.mJ();
      this.mH();
      this.uF.setText(this.uz.getNome());

      for (int var4 = 0; var4 < GameConstants.rI.length; var4++) {
         this.Nq.addItem(GameConstants.rI[var4]);
      }

      this.Nq.addItem("Aleatório");
      this.Nq.setSelectedIndex(this.uz.getPosicao());
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   public void mH() {
      this.BZ.addActionListener(new C0533(this));
      this.Np.addActionListener(new C0534(this));
   }

   public void qW() {
      String var1 = null;
      if (!this.Nr.getText().toString().isEmpty() && this.Nr.getText().toString().length() > 1 && this.Nr.getText().toString().length() < 35) {
         var1 = this.Nr.getText().toString();
      }

      int var2 = -1;
      if (this.Nq.getSelectedIndex() < 5) {
         var2 = this.Nq.getSelectedIndex();
      } else {
         var2 = -1;
      }

      this.uz.a(var1, var2, false);
      Ag = true;
      this.ub.dispose();
   }

   private void mJ() {
      this.ug = new JLabel();
      this.BZ = new JButton();
      this.uF = new JLabel();
      this.a_ = new JLabel();
      this.ur = new JLabel();
      this.us = new JLabel();
      this.Nr = new JTextField();
      this.vx = new JLabel();
      this.Nq = new JComboBox();
      this.vy = new JLabel();
      this.Np = new JButton();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Aposentar jogador");
      this.BZ.setFont(new Font("Tahoma", 1, 11));
      this.BZ.setText("X");
      this.uF.setFont(new Font("Arial", 1, 12));
      this.uF.setForeground(new Color(255, 255, 153));
      this.uF.setText("nomeJogador");
      this.a_.setFont(new Font("Arial", 1, 12));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setHorizontalAlignment(2);
      this.a_.setText("<html>Se não houver vaga nos Juniores, ele será promovido ao time principal.</html> ");
      this.a_.setVerticalAlignment(1);
      this.ur.setFont(new Font("Arial", 1, 12));
      this.ur.setForeground(new Color(255, 255, 255));
      this.ur.setHorizontalAlignment(2);
      this.ur
         .setText(
            "<html>Ao aposentar um jogador você ganha a oportunidade de receber um novo jogador na Academia de Juniores do seu time. Você pode escolher a posição e como será chamado o novo jogador.</html> "
         );
      this.ur.setVerticalAlignment(1);
      this.us.setFont(new Font("Arial", 1, 12));
      this.us.setForeground(new Color(255, 255, 153));
      this.us.setText("Escolha um nome:");
      this.vx.setFont(new Font("Arial", 0, 12));
      this.vx.setForeground(new Color(255, 255, 255));
      this.vx.setText("(deixe em branco para um nome automático)");
      this.vy.setFont(new Font("Arial", 1, 12));
      this.vy.setForeground(new Color(255, 255, 153));
      this.vy.setText("Posição:");
      this.Np.setText("Aposentar");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(41, 41, 41)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addComponent(this.uF, -2, 274, -2).addContainerGap(-1, 32767))
                        .addGroup(
                           var1.createSequentialGroup()
                              .addComponent(this.ug, -2, 225, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.BZ, -2, 47, -2)
                              .addGap(32, 32, 32)
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING, false)
                                    .addComponent(this.ur, -2, 337, -2)
                                    .addComponent(this.a_, -2, 337, -2)
                                    .addComponent(this.vx, -2, 275, -2)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING).addComponent(this.Nr, -2, 244, -2).addComponent(this.us, -2, 202, -2)
                                          )
                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING).addComponent(this.vy, -2, 75, -2).addComponent(this.Nq, 0, -1, 32767)
                                          )
                                    )
                              )
                              .addGap(0, 24, 32767)
                        )
                  )
            )
            .addGroup(Alignment.TRAILING, var1.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.Np, -2, 142, -2).addGap(121, 121, 121))
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.BZ).addComponent(this.ug))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uF)
                  .addGap(20, 20, 20)
                  .addComponent(this.ur, -2, 80, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.a_, -2, 47, -2)
                  .addGap(18, 18, 18)
                  .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.us).addComponent(this.vy, Alignment.TRAILING))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Nr, -2, -1, -2).addComponent(this.Nq, -2, -1, -2))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.vx)
                  .addGap(18, 18, 18)
                  .addComponent(this.Np)
                  .addContainerGap(31, 32767)
            )
      );
   }
}
