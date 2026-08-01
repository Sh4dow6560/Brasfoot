package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Player;

public class C0551 extends JPanel {
   private Player uz = null;
   private C0231 uA;
   private JDialog uB;
   private JButton uC;
   private JButton uD;
   private JTextField uE;
   private JLabel ug;
   private JLabel uF;
   private JLabel uG;
   private JLabel uH;
   private JLabel uI;

   public C0551(JDialog jDialog, C0231 c0231, Player player) {
      this.uB = jDialog;
      this.uA = c0231;
      this.uz = player;
      this.mJ();
      this.mH();
      this.uH.setVisible(false);
      this.uF.setText(player.getNome());
   }

   private void mN() {
      String var1 = null;
      if (this.uE.getText().toString().isEmpty() || this.uE.getText().toString().length() < 2) {
         this.uH.setText("Apelido muito curto");
         this.uH.setVisible(true);
      } else if (this.uE.getText().toString().length() > 32) {
         this.uH.setText("Apelido muito longo");
         this.uH.setVisible(true);
      } else {
         var1 = this.uE.getText().toString();
         this.uz.setNome(var1);
         this.uB.dispose();
         this.uA.pO();
      }
   }

   public void mH() {
      this.uC.addActionListener(new C0552(this));
      this.uD.addActionListener(new C0553(this));
   }

   private void mJ() {
      this.ug = new JLabel();
      this.uF = new JLabel();
      this.uH = new JLabel();
      this.uE = new JTextField();
      this.uI = new JLabel();
      this.uG = new JLabel();
      this.uC = new JButton();
      this.uD = new JButton();
      this.setBackground(new Color(44, 53, 49));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Definir apelido");
      this.uF.setFont(new Font("Tahoma", 0, 12));
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setHorizontalAlignment(0);
      this.uF.setText("Nome do Jogador");
      this.uH.setForeground(new Color(255, 255, 204));
      this.uH.setHorizontalAlignment(2);
      this.uH.setText("Preço inicial:");
      this.uI.setForeground(new Color(255, 255, 255));
      this.uI.setHorizontalAlignment(2);
      this.uI.setText("que será mostrado no lugar do nome:");
      this.uG.setForeground(new Color(255, 255, 255));
      this.uG.setText("Você pode escolher um apelido para o júnior");
      this.uC.setText("Cancelar");
      this.uD.setText("Definir");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           Alignment.TRAILING,
                           var1.createSequentialGroup()
                              .addGap(0, 0, 32767)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.uI, -2, 264, -2)
                                    .addComponent(this.uH, -2, 237, -2)
                                    .addComponent(this.uG, -2, 256, -2)
                                    .addComponent(this.uE, -2, 249, -2)
                              )
                        )
                        .addComponent(this.uF, Alignment.TRAILING, -1, -1, 32767)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGap(66, 66, 66)
                                          .addComponent(this.uC, -2, 91, -2)
                                          .addGap(31, 31, 31)
                                          .addComponent(this.uD, -2, 94, -2)
                                    )
                                    .addComponent(this.ug, -2, 317, -2)
                              )
                              .addGap(0, 0, 32767)
                        )
                  )
                  .addGap(28, 28, 28)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.uF)
                  .addGap(40, 40, 40)
                  .addComponent(this.uG)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uI)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.uE, -2, -1, -2)
                  .addGap(18, 18, 18)
                  .addComponent(this.uH)
                  .addGap(22, 22, 22)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uC).addComponent(this.uD))
                  .addContainerGap(49, 32767)
            )
      );
   }
}
