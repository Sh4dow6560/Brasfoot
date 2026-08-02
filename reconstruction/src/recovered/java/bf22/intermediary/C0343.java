package bf22.intermediary;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.finance.ClubFinances;
import mod.recovered.model.Player;

public class C0343 extends JPanel {
   private JDialog ub = null;
   private Player CY = null;
   private int IC = 0;
   private JButton uC;
   private JButton ID;
   private JComboBox Bf;
   private JLabel ug;
   private JPanel vd;
   private JLabel uF;
   private JLabel uG;
   private JLabel uH;
   private JLabel Ec;
   private JLabel uI;
   private JSpinner IE;

   public C0343(JDialog jDialog, Player player) {
      this.ub = jDialog;
      this.CY = player;
      this.mJ();
      this.mH();
      String[] var3 = new String[]{"6 meses", "1 ano", "2 anos", "3 anos"};

      for (int var4 = 0; var4 < var3.length; var4++) {
         this.Bf.addItem(var3[var4]);
      }

      this.uF.setText(this.CY.getNome());
      this.uG.setText("Contrato até: " + this.CY.getContractEndDateLabel());
      this.Ec.setText("Salário atual: " + ClubFinances.c(this.CY.getSalary()));
      this.Bf.setSelectedIndex(0);
      this.IE.setModel(new SpinnerNumberModel(this.CY.getSalary(), 1, 100000000, 1000));
   }

   public void mH() {
      this.uC.addActionListener(new C0344(this));
      this.ID.addActionListener(new C0293(this));
   }

   private void rE() {
      int var1 = -1;
      int var2 = (Integer)this.IE.getValue();
      if (var2 > 0 && var2 < this.rF()) {
         if (this.dr(var2)) {
            this.dq(var2);
         } else {
            if (this.IC > this.rF()) {
               this.IC = this.rF();
            }

            String var5 = Integer.toString(this.IC);
            var1 = JOptionPane.showConfirmDialog(this.ub, "O salário não foi aceito.\nO jogador quer um salário de:\n" + var5, "Salário recusado", 0);
            if (var1 == 0) {
               this.dq(this.IC);
            }
         }
      } else if (var2 >= this.rF()) {
         String var3 = ClubFinances.c(this.rF());
         JOptionPane.showMessageDialog(this.ub, "Salário maior que o limite para esse jogador. Limite é " + var3, "Salário", 2);
      }
   }

   private void dq(int i) {
      this.CY.setTransferListed(false);
      this.CY.resetAskingPriceToMarketValue();
      int var2 = this.Bf.getSelectedIndex();
      int[] var3 = new int[]{180, 365, 730, 1095};
      this.CY.renewContract(var3[var2], false);
      this.CY.setSalary(i);
      this.ub.dispose();
   }

   private boolean dr(int i) {
      int var2 = this.Bf.getSelectedIndex();
      int[] var3 = new int[]{1, 3, 5, 12};
      int[] var4 = new int[]{10, 12, 15, 5};
      int var5 = this.CY.getSalary() - Math.round(this.CY.getSalary() * var3[var2] / 100);
      int var6 = this.CY.getSalary() + Math.round(this.CY.getSalary() * var4[var2] / 100);
      if (this.CY.getContractDaysRemaining() < 60) {
         this.IC = var5;
         if (i < var5) {
            return false;
         }
      } else {
         this.IC = var6;
         if (i < var6) {
            return false;
         }
      }

      return true;
   }

   private int rF() {
      return (int)Math.round(this.CY.getMarketValue() * 0.25);
   }

   private boolean ds(int i) {
      int var2 = (int)Math.round(this.CY.getMarketValue() * 0.25);
      return i <= var2;
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.uF = new JLabel();
      this.uH = new JLabel();
      this.uI = new JLabel();
      this.uG = new JLabel();
      this.Ec = new JLabel();
      this.IE = new JSpinner();
      this.Bf = new JComboBox();
      this.uC = new JButton();
      this.ID = new JButton();
      this.setBackground(new Color(42, 64, 29));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
      this.vd.setBackground(new Color(84, 127, 59));
      this.ug.setFont(new Font("Tahoma", 1, 12));
      this.ug.setForeground(new Color(255, 255, 102));
      this.ug.setHorizontalAlignment(0);
      this.ug.setText("Novo contrato");
      this.uF.setFont(new Font("Tahoma", 0, 12));
      this.uF.setForeground(new Color(255, 255, 255));
      this.uF.setHorizontalAlignment(0);
      this.uF.setText("Nome do Jogador");
      this.uH.setForeground(new Color(255, 255, 255));
      this.uH.setHorizontalAlignment(2);
      this.uH.setText("Duração:");
      this.uI.setForeground(new Color(255, 255, 255));
      this.uI.setHorizontalAlignment(2);
      this.uI.setText("Novo salário:");
      this.uG.setForeground(new Color(255, 255, 255));
      this.uG.setText("");
      this.Ec.setForeground(new Color(255, 255, 255));
      this.Ec.setText("");
      this.uC.setText("Cancelar");
      this.ID.setText("Oferecer");
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
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
                                             var1.createParallelGroup(Alignment.LEADING).addComponent(this.Ec, -2, 256, -2).addComponent(this.uG, -2, 256, -2)
                                          )
                                          .addGap(8, 8, 8)
                                    )
                              )
                        )
                        .addGroup(var1.createSequentialGroup().addGap(14, 14, 14).addComponent(this.uF, -1, -1, 32767))
                        .addGroup(
                           Alignment.TRAILING,
                           var1.createSequentialGroup()
                              .addGap(0, 0, 32767)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(
                                       Alignment.TRAILING,
                                       var1.createParallelGroup(Alignment.LEADING)
                                          .addComponent(this.IE, -2, 192, -2)
                                          .addComponent(this.uI, -2, 264, -2)
                                          .addComponent(this.uH, -2, 63, -2)
                                    )
                                    .addGroup(
                                       var1.createSequentialGroup()
                                          .addComponent(this.uC, -2, 97, -2)
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addComponent(this.ID, -2, 90, -2)
                                    )
                              )
                        )
                  )
                  .addContainerGap()
            )
            .addGroup(var1.createSequentialGroup().addGap(124, 124, 124).addComponent(this.Bf, -2, 131, -2).addContainerGap(-1, 32767))
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(this.ug)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.uF)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.uG)
                  .addGap(9, 9, 9)
                  .addComponent(this.Ec)
                  .addGap(18, 18, 18)
                  .addComponent(this.uI)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.IE, -2, 27, -2)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Bf, -2, -1, -2).addComponent(this.uH))
                  .addPreferredGap(ComponentPlacement.RELATED, 29, 32767)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.uC).addComponent(this.ID))
                  .addGap(23, 23, 23)
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addGap(18, 18, 18).addComponent(this.vd, -2, 314, -2).addContainerGap(21, 32767))
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addGap(19, 19, 19).addComponent(this.vd, -2, -1, -2).addContainerGap(21, 32767))
      );
   }
}
