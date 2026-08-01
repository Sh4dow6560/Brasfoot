package bf22.intermediary;

import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class C0318 extends JPanel {
   private JDialog ub = null;
   private JButton Fu;
   private JCheckBox JI;
   private JCheckBox JJ;
   private JCheckBox JK;
   private JCheckBox JL;
   private JCheckBox JM;
   private JLabel vf;

   public C0318(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      boolean[] var2 = GamePersistence.careerState.getJogaRegionaisTodos();
      var2 = GamePersistence.careerState.getJogaRegionaisTodos();
      this.JJ.setSelected(var2[0]);
      this.JK.setSelected(var2[1]);
      this.JL.setSelected(var2[2]);
      this.JM.setSelected(var2[3]);
      this.JI.setSelected(GamePersistence.getOptions().isConviteRegionais());
      this.Fu.addActionListener(new C0372(this));
   }

   public void nH() {
      boolean[] var1 = new boolean[]{this.JJ.isSelected(), this.JK.isSelected(), this.JL.isSelected(), this.JM.isSelected()};
      GamePersistence.careerState.setJogaRegionaisTodos(var1);
      GamePersistence.getOptions().setJogaRegionaisTodos(var1);
      GamePersistence.getOptions().setConviteRegionais(this.JI.isSelected());
      GamePersistence.saveOptions();
      this.ub.dispose();
   }

   private void mJ() {
      this.vf = new JLabel();
      this.JJ = new JCheckBox();
      this.JK = new JCheckBox();
      this.Fu = new JButton();
      this.JL = new JCheckBox();
      this.JM = new JCheckBox();
      this.JI = new JCheckBox();
      this.setBackground(new Color(44, 53, 49));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 153));
      this.vf.setText("Jogar:");
      this.JJ.setFont(new Font("Tahoma", 0, 14));
      this.JJ.setForeground(new Color(255, 255, 255));
      this.JJ.setText("Rio-São Paulo");
      this.JJ.setOpaque(false);
      this.JK.setFont(new Font("Tahoma", 0, 14));
      this.JK.setForeground(new Color(255, 255, 255));
      this.JK.setText("Sul-Minas");
      this.JK.setOpaque(false);
      this.Fu.setText("OK");
      this.JL.setFont(new Font("Tahoma", 0, 14));
      this.JL.setForeground(new Color(255, 255, 255));
      this.JL.setText("Copa do Nordeste");
      this.JL.setOpaque(false);
      this.JM.setFont(new Font("Tahoma", 0, 14));
      this.JM.setForeground(new Color(255, 255, 255));
      this.JM.setText("Copa Verde");
      this.JM.setOpaque(false);
      this.JI.setBackground(new Color(44, 53, 49));
      this.JI.setFont(new Font("Tahoma", 0, 14));
      this.JI.setForeground(new Color(255, 255, 255));
      this.JI.setText("Sempre ser convidado para jogar os regionais");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.JI, -1, 332, 32767)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.JM, -2, 165, -2)
                                    .addComponent(this.JL, -2, 165, -2)
                                    .addComponent(this.JK, -2, 165, -2)
                                    .addComponent(this.JJ, -2, 165, -2)
                                    .addComponent(this.vf, -2, 305, -2)
                              )
                              .addGap(0, 0, 32767)
                        )
                  )
                  .addContainerGap()
            )
            .addGroup(var1.createSequentialGroup().addGap(134, 134, 134).addComponent(this.Fu, -2, 103, -2).addContainerGap(-1, 32767))
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addComponent(this.vf)
                  .addGap(18, 18, 18)
                  .addComponent(this.JJ)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.JK)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.JL)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(this.JM)
                  .addGap(18, 18, 18)
                  .addComponent(this.JI)
                  .addGap(18, 18, 18)
                  .addComponent(this.Fu)
                  .addContainerGap(27, 32767)
            )
      );
   }
}
