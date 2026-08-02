package bf22.intermediary;

import mod.recovered.transfer.TransferNegotiation;
import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Club;
import mod.recovered.model.Player;

public class C0185 extends JPanel {
   private JDialog ub;
   private Player CY;
   private Club ul = null;
   private boolean CZ = false;
   private JButton uC;
   private JButton uD;
   private JTextField uE;
   private JLabel ug;
   private JPanel vd;
   private JLabel uF;
   private JLabel uG;
   private JLabel uH;
   private JLabel uI;

   public C0185(JDialog jDialog, Player player, Club club, boolean bl) {
      this.ub = jDialog;
      this.CY = player;
      this.ul = club;
      this.CZ = bl;
      this.mJ();
      this.mK();
      this.mH();
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void mK() {
      this.uF.setText(this.CY.getNome());
      this.uG.setText("Valor do passe: " + ClubFinances.c(this.CY.fk()));
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
      this.uC.addActionListener(new C0134(this));
      this.uD.addActionListener(new C0135(this));
      this.uE.getDocument().addDocumentListener(new C0136(this));
   }

   private void oL() {
      String var1 = this.uE.getText().toString() + "000";
      int var2 = -1;
      if (!var1.equals("") && var1.matches("\\d+") && B(var1) && Integer.parseInt(var1) > 0) {
         int var3 = Integer.parseInt(var1);
         if (this.ul.kb() >= var3) {
            if (this.CY.fg().jZ()) {
               int var4 = Integer.parseInt(var1);
               String var5 = this.ul.getNome();
               String var6 = this.CY.fg().getCoach().dS();
               var2 = JOptionPane.showConfirmDialog(this.ub, var6 + " proposta pelo seu jogador\n" + "Deseja aceitar?", "Proposta de compra", 0);
               if (var2 == 0) {
                  if (!this.CZ) {
                     this.CY.a(this.ul, var4, false, false, false);
                  } else {
                     this.CY.c(this.ul, var4);
                  }

                  TransferNegotiation.l(true);
                  this.ub.dispose();
               }
            } else if (this.CY.ft() && var3 >= this.CY.fl() && !this.CZ) {
               this.oM();
            } else {
               int var14 = 0;
               int var16 = Integer.parseInt(var1);
               var14 = TransferNegotiation.a(this.CY, this.ul, var16);
               String[] var17 = new String[]{
                  "Oferta recusada",
                  "Compra realizada",
                  "Jogador do seu time",
                  "Limite de 30 jogadores alcançado",
                  "Não deseja se transferir para o seu time",
                  "Sem dinheiro para comprar este jogador"
               };
               if (var14 <= 5) {
                  JOptionPane.showMessageDialog(this.ub, var17[var14], "Compra", 2);
               } else if (var14 == 6) {
                  String var7 = ClubFinances.c(TransferNegotiation.cM());
                  var2 = JOptionPane.showConfirmDialog(
                     this.ub, "Para jogar no seu time\no jogador quer um salário de:\n" + var7 + "\n" + "Deseja aceitar?", "Deseja aumento de salário", 0
                  );
                  if (var2 == 0) {
                     this.CY.ae(TransferNegotiation.cM());
                     var14 = 1;
                  }
               } else if (var14 == 7) {
                  var16 = TransferNegotiation.cN();
                  String var18 = this.CY.fg().getNome();
                  String var8 = "";
                  String var9 = "";
                  int var10 = 0;
                  if (TransferNegotiation.cM() > 0) {
                     var10 = TransferNegotiation.cM();
                     var8 = ClubFinances.c(TransferNegotiation.cM());
                     var9 = "E o jogador quer um salário de " + var8 + "\n";
                  }

                  var2 = JOptionPane.showConfirmDialog(
                     this.ub,
                     var18 + " enviou uma contra-proposta\n" + "O clube aceita um valor de " + ClubFinances.c(var16) + "\n" + var9 + "Deseja aceitar?",
                     "Contra-proposta",
                     0
                  );
                  if (var2 == 0) {
                     if (var10 > 0) {
                        this.CY.ae(var10);
                     }

                     var14 = 1;
                  }
               }

               if (var14 == 1) {
                  if (!this.CZ) {
                     Club var19 = this.CY.fg();
                     this.CY.a(this.ul, var16, false, false, false);
                     TransferNegotiation.a(var19, this.CY);
                  } else {
                     this.CY.c(this.ul, var16);
                  }

                  TransferNegotiation.l(true);
                  this.ub.dispose();
               }
            }
         } else {
            this.uH.setText("Valor maior que dinheiro em caixa");
         }
      } else {
         this.uH.setText("valor inválido");
      }
   }

   private void oM() {
      int var1 = 0;
      var1 = TransferNegotiation.b(this.CY, this.ul);
      String[] var2 = new String[]{
         "Não está à venda",
         "Compra realizada",
         "Jogador do seu time",
         "Limite de 32 jogadores alcançado",
         "Não deseja se transferir para o seu time",
         "Sem dinheiro para comprar este jogador"
      };
      JOptionPane.showMessageDialog(this.ub, var2[var1], "Compra", 2);
      if (var1 == 1) {
         this.ub.dispose();
      }
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.uF = new JLabel();
      this.uH = new JLabel();
      this.uE = new JTextField();
      this.uI = new JLabel();
      this.uG = new JLabel();
      this.uC = new JButton();
      this.uD = new JButton();
      this.setBackground(new Color(44, 53, 49));
      this.vd.setBackground(new Color(104, 120, 100));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Proposta pelo jogador");
      this.uF.setFont(new Font("Tahoma", 0, 12));
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setHorizontalAlignment(0);
      this.uF.setText("Nome do Jogador");
      this.uH.setForeground(new Color(255, 255, 255));
      this.uH.setHorizontalAlignment(2);
      this.uH.setText("Preço inicial:");
      this.uI.setForeground(new Color(255, 255, 255));
      this.uI.setHorizontalAlignment(2);
      this.uI.setText("Sua proposta (em milhares de $):");
      this.uG.setForeground(new Color(255, 255, 255));
      this.uG.setText("Valor do passe:");
      this.uC.setText("Cancelar");
      this.uD.setText("Enviar");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, var1.createSequentialGroup().addGap(14, 14, 14).addComponent(this.uF, -1, -1, 32767))
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(67, 67, 67)
                              .addComponent(this.uC, -2, 91, -2)
                              .addGap(26, 26, 26)
                              .addComponent(this.uD, -2, 86, -2)
                              .addGap(0, 0, 32767)
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addContainerGap()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(var1.createSequentialGroup().addComponent(this.ug, -2, 317, -2).addGap(0, 0, 32767))
                                    .addGroup(
                                       Alignment.TRAILING,
                                       var1.createSequentialGroup()
                                          .addGap(0, 0, 32767)
                                          .addGroup(
                                             var1.createParallelGroup(Alignment.LEADING)
                                                .addComponent(this.uE, -2, 200, -2)
                                                .addComponent(this.uI, -2, 264, -2)
                                                .addComponent(this.uH, -2, 237, -2)
                                                .addComponent(this.uG, -2, 256, -2)
                                          )
                                    )
                              )
                        )
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uF)
                  .addGap(18, 18, 18)
                  .addComponent(this.uG)
                  .addGap(18, 18, 18)
                  .addComponent(this.uI)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uE, -2, -1, -2)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uH)
                  .addGap(34, 34, 34)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uC).addComponent(this.uD))
                  .addContainerGap(46, 32767)
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.vd, -2, -1, -2).addContainerGap(18, 32767))
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addGap(19, 19, 19).addComponent(this.vd, -2, -1, -2).addContainerGap(21, 32767))
      );
   }
}
