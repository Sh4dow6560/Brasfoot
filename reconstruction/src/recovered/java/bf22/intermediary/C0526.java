package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Player;

public class C0526 extends JPanel {
   private JDialog ub;
   private Player CY;
   private int w = 1;
   private int Nk = 0;
   private int Nl = 0;
   private int oq = 0;
   private static boolean Nm = false;
   private JButton uC;
   private ButtonGroup Kl;
   private JRadioButton Km;
   private JRadioButton Kn;
   private JTextField uE;
   private JButton vb;
   private JLabel ug;
   private JLabel uh;
   private JLabel us;
   private JPanel vd;
   private JLabel Nn;
   private JLabel uH;
   private JLabel uI;

   public C0526(JDialog jDialog, Player player) {
      this.ub = jDialog;
      this.CY = player;
      Nm = false;
      this.mJ();
      this.mH();
      this.mK();
   }

   private void a(int i) {
      this.w = i;
      if (this.w == 1) {
         this.uI.setText("Preço inicial: (em milhares de $)");
         this.vb.setText("Iniciar leilão");
      } else {
         this.uI.setText("Preço fixado: (em milhares de $)");
         this.vb.setText("Fixar preço");
      }
   }

   private void mK() {
      this.uI.setText("Preço inicial: (em milhares de $)");
      this.Kl.add(this.Km);
      this.Kl.add(this.Kn);
      this.uh.setText(this.CY.getNome());
      this.oq = this.CY.fk();
      this.uE.setText(String.valueOf(Math.round(this.CY.fk() / 1000)));
      this.uH.setText(ClubFinances.c(this.CY.fk()));
      this.Km.addActionListener(new C0527(this));
      this.Kn.addActionListener(new C0528(this));
      this.Km.setSelected(true);
      this.uE.getDocument().addDocumentListener(new C0529(this));
      int var1 = this.CY.getContractDaysRemaining();
      if (var1 <= 0) {
         this.Nl = 0;
      } else if (var1 > 0 && var1 <= 30) {
         this.Nl = 12;
      } else if (var1 <= 60) {
         this.Nl = 20;
      } else if (var1 <= 90) {
         this.Nl = 22;
      } else if (var1 <= 180) {
         this.Nl = 25;
      } else if (var1 <= 722) {
         this.Nl = 30;
      } else {
         this.Nl = 35;
      }

      this.Nk = Math.round(this.CY.fk() * this.Nl / 100);
      this.Nn.setText("Multa estimada deste jogador: " + Integer.toString(this.Nl) + "% da venda");
   }

   public static boolean B(String string) {
      try {
         Integer.parseInt(string);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      } catch (NullPointerException var3) {
         return false;
      }
   }

   private void oK() {
      String var1 = this.uE.getText().toString() + "000";
      if (!var1.equals("") && var1.matches("\\d+") && B(var1) && Integer.parseInt(var1) >= 0) {
         this.uH.setText(ClubFinances.c(Integer.parseInt(var1)));
      } else {
         this.uH.setText("valor inválido");
      }
   }

   public void mH() {
      this.uC.addActionListener(new C0530(this));
      this.vb.addActionListener(new C0531(this));
   }

   private void dD(int i) {
      this.CY.c(true);
      this.CY.ag(i);
      this.ub.dispose();
   }

   private void dE(int i) {
      this.CY.ag(i);
      int var2 = i;
      if (i < this.CY.fk()) {
         double var3 = 0.1;
         if (new Random().nextInt(100) > 50) {
            var3 = 0.15;
         }

         var2 = (int)Math.round(this.CY.fk() * var3);
         var2 = this.CY.fk() - var2;
         if (var2 < i) {
            var2 = i;
         }
      }

      this.ub.dispose();
      new C0794(this.CY, var2, true, false);
      Nm = true;
   }

   private void qX() {
      String var1 = this.uE.getText().toString() + "000";
      if (var1.equals("") || !var1.matches("\\d+") || !B(var1) || Integer.parseInt(var1) < 0) {
         JOptionPane.showMessageDialog(this.ub, "O preço do jogador não é válido.", "Erro", 0);
      } else if (this.w == 1) {
         this.dE(Integer.parseInt(var1));
      } else {
         this.dD(Integer.parseInt(var1));
      }
   }

   private void mJ() {
      this.Kl = new ButtonGroup();
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.uh = new JLabel();
      this.Km = new JRadioButton();
      this.Kn = new JRadioButton();
      this.uI = new JLabel();
      this.uE = new JTextField();
      this.uH = new JLabel();
      this.vb = new JButton();
      this.uC = new JButton();
      this.us = new JLabel();
      this.Nn = new JLabel();
      this.setBackground(new Color(42, 64, 29));
      this.vd.setBackground(new Color(84, 127, 59));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Vender Jogador");
      this.uh.setFont(new Font("Tahoma", 0, 12));
      this.uh.setForeground(new Color(255, 255, 255));
      this.uh.setHorizontalAlignment(0);
      this.uh.setText("Nome do Jogador");
      this.Km.setBackground(new Color(255, 254, 176));
      this.Km.setFont(new Font("Tahoma", 0, 12));
      this.Km.setForeground(new Color(255, 255, 255));
      this.Km.setText("Vender jogador em leilão");
      this.Km.setOpaque(false);
      this.Kn.setBackground(new Color(255, 254, 176));
      this.Kn.setFont(new Font("Tahoma", 0, 12));
      this.Kn.setForeground(new Color(255, 255, 255));
      this.Kn.setText("Colocar à venda esperando comprador ");
      this.Kn.setOpaque(false);
      this.uI.setForeground(new Color(255, 255, 255));
      this.uI.setHorizontalAlignment(2);
      this.uI.setText("Preço inicial:");
      this.uH.setForeground(new Color(255, 255, 255));
      this.uH.setHorizontalAlignment(2);
      this.uH.setText("Preço inicial:");
      this.vb.setText("Iniciar leilao");
      this.uC.setText("Cancelar");
      this.us.setForeground(new Color(255, 255, 255));
      this.us.setHorizontalAlignment(2);
      this.us.setText("Jogadores com contrato pagam multa de rescisão. ");
      this.Nn.setForeground(new Color(255, 255, 255));
      this.Nn.setHorizontalAlignment(2);
      this.Nn.setText("Multa estimada:");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(var1.createSequentialGroup().addContainerGap().addComponent(this.uh, -1, -1, 32767).addContainerGap())
            .addGroup(
               Alignment.TRAILING,
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(
                           Alignment.LEADING,
                           var1.createSequentialGroup()
                              .addGap(29, 29, 29)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.uE)
                                    .addComponent(this.Kn, -1, -1, 32767)
                                    .addComponent(this.Km, -1, -1, 32767)
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addComponent(this.us, -2, 302, -2)
                                                .addComponent(this.uI, -2, 264, -2)
                                                .addComponent(this.uH, -2, 237, -2)
                                                .addComponent(this.Nn, -2, 254, -2)
                                          )
                                          .addGap(0, 0, 32767)
                                    )
                              )
                        )
                        .addGroup(
                           Alignment.LEADING,
                           var1.createSequentialGroup()
                              .addGap(41, 41, 41)
                              .addComponent(this.vb, -2, 123, -2)
                              .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                              .addComponent(this.uC, -2, 115, -2)
                              .addGap(9, 9, 9)
                        )
                  )
                  .addGap(24, 24, 24)
            )
            .addGroup(var1.createSequentialGroup().addGap(4, 4, 4).addComponent(this.ug, -2, 341, -2).addContainerGap(-1, 32767))
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uh)
                  .addGap(18, 18, 18)
                  .addComponent(this.Km)
                  .addGap(34, 34, 34)
                  .addComponent(this.Kn)
                  .addGap(28, 28, 28)
                  .addComponent(this.uI)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uE, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uH)
                  .addGap(43, 43, 43)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vb).addComponent(this.uC))
                  .addGap(18, 18, 18)
                  .addComponent(this.us)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.Nn)
                  .addContainerGap(24, 32767)
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addGap(20, 20, 20).addComponent(this.vd, -2, -1, -2).addContainerGap(20, 32767))
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addGap(20, 20, 20).addComponent(this.vd, -2, -1, -2).addContainerGap(25, 32767))
      );
   }

   public static boolean sN() {
      return Nm;
   }
}
