package bf22.intermediary;

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

public class C0227 extends JPanel {
   private JDialog ub = null;
   private JButton Fu;
   private JCheckBox CS;
   private JCheckBox Fv;
   private JCheckBox Fw;
   private JCheckBox Fx;
   private JCheckBox Fy;
   private JCheckBox Fz;
   private JCheckBox FA;
   private JCheckBox FB;
   private JCheckBox FC;
   private JCheckBox FD;
   private JLabel vf;
   private JLabel FE;

   public C0227(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      this.FD.setSelected(C0745.SR.isJogaIntano1());
      this.CS.setSelected(C0745.SR.isGruposIntPadrao());
      boolean[] var2 = C0745.SR.getVerJint();
      this.Fv.setSelected(var2[0]);
      this.Fw.setSelected(var2[1]);
      this.FB.setSelected(var2[2]);
      this.Fy.setSelected(var2[3]);
      this.Fz.setSelected(var2[4]);
      this.FA.setSelected(var2[5]);
      this.FC.setSelected(var2[6]);
      this.Fx.setSelected(var2[7]);
      this.Fu.addActionListener(new C0228(this));
      this.FD.setVisible(false);
   }

   public void nH() {
      boolean[] var1 = new boolean[]{
         this.Fv.isSelected(),
         this.Fw.isSelected(),
         this.FB.isSelected(),
         this.Fy.isSelected(),
         this.Fz.isSelected(),
         this.FA.isSelected(),
         this.FC.isSelected(),
         this.Fx.isSelected()
      };

      for (int var2 = 0; var2 < var1.length; var2++) {
         C0745.vM().setVerJint(var1[var2], var2);
      }

      C0745.SR.setGruposIntPadrao(this.CS.isSelected());
      C0745.vM().setJogaIntano1(this.FD.isSelected());
      C0745.vM().setGruposIntPadrao(this.CS.isSelected());
      C0745.vJ();
      this.ub.dispose();
   }

   private void mJ() {
      this.CS = new JCheckBox();
      this.Fx = new JCheckBox();
      this.vf = new JLabel();
      this.FE = new JLabel();
      this.FD = new JCheckBox();
      this.Fv = new JCheckBox();
      this.Fw = new JCheckBox();
      this.Fz = new JCheckBox();
      this.Fy = new JCheckBox();
      this.FA = new JCheckBox();
      this.Fu = new JButton();
      this.FB = new JCheckBox();
      this.FC = new JCheckBox();
      this.setBackground(new Color(45, 51, 38));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
      this.CS.setFont(new Font("Tahoma", 0, 14));
      this.CS.setForeground(new Color(255, 255, 255));
      this.CS.setText("Quando possível usar grupos reais");
      this.CS.setOpaque(false);
      this.Fx.setFont(new Font("Tahoma", 0, 14));
      this.Fx.setForeground(new Color(255, 255, 255));
      this.Fx.setText("Sul-Americana");
      this.Fx.setOpaque(false);
      this.vf.setFont(new Font("Tahoma", 1, 14));
      this.vf.setForeground(new Color(255, 255, 255));
      this.vf.setText("Primeira Temporada");
      this.FE.setFont(new Font("Tahoma", 1, 14));
      this.FE.setForeground(new Color(255, 255, 255));
      this.FE.setText("Sem times humanos ver jogos:");
      this.FD.setFont(new Font("Tahoma", 0, 14));
      this.FD.setForeground(new Color(255, 255, 255));
      this.FD.setText("");
      this.FD.setToolTipText("");
      this.FD.setOpaque(false);
      this.Fv.setFont(new Font("Tahoma", 0, 14));
      this.Fv.setForeground(new Color(255, 255, 255));
      this.Fv.setText("Liga dos Campeões");
      this.Fv.setOpaque(false);
      this.Fw.setFont(new Font("Tahoma", 0, 14));
      this.Fw.setForeground(new Color(255, 255, 255));
      this.Fw.setText("Libertadores");
      this.Fw.setOpaque(false);
      this.Fz.setFont(new Font("Tahoma", 0, 14));
      this.Fz.setForeground(new Color(255, 255, 255));
      this.Fz.setText("Liga Concacaf");
      this.Fz.setOpaque(false);
      this.Fy.setFont(new Font("Tahoma", 0, 14));
      this.Fy.setForeground(new Color(255, 255, 255));
      this.Fy.setText("Liga Asiática");
      this.Fy.setOpaque(false);
      this.FA.setFont(new Font("Tahoma", 0, 14));
      this.FA.setForeground(new Color(255, 255, 255));
      this.FA.setText("Liga Oceania");
      this.FA.setOpaque(false);
      this.Fu.setText("OK");
      this.FB.setFont(new Font("Tahoma", 0, 14));
      this.FB.setForeground(new Color(255, 255, 255));
      this.FB.setText("Liga Africana");
      this.FB.setOpaque(false);
      this.FC.setFont(new Font("Tahoma", 0, 14));
      this.FC.setForeground(new Color(255, 255, 255));
      this.FC.setText("Liga Europa");
      this.FC.setOpaque(false);
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addComponent(this.vf, -2, 303, -2)
                        .addComponent(this.CS, -2, 320, -2)
                        .addComponent(this.FE, -2, 334, -2)
                        .addGroup(
                           var1.createParallelGroup(Alignment.TRAILING, false)
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addComponent(this.FC, -2, 165, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    .addComponent(this.Fx, -2, 165, -2)
                              )
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addComponent(this.FB, -2, 165, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    .addComponent(this.FA, -2, 165, -2)
                              )
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addComponent(this.Fw, -2, 165, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    .addComponent(this.Fz, -2, 165, -2)
                              )
                              .addGroup(
                                 var1.createSequentialGroup()
                                    .addComponent(this.Fv, -2, 165, -2)
                                    .addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                                    .addComponent(this.Fy, -2, 165, -2)
                              )
                              .addComponent(this.FD, Alignment.LEADING, -2, 356, -2)
                        )
                  )
                  .addContainerGap(11, 32767)
            )
            .addGroup(Alignment.TRAILING, var1.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.Fu, -2, 91, -2).addGap(154, 154, 154))
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addComponent(this.vf)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(this.FD)
                  .addGap(3, 3, 3)
                  .addComponent(this.CS)
                  .addGap(18, 18, 18)
                  .addComponent(this.FE)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Fv).addComponent(this.Fy))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.Fw).addComponent(this.Fz))
                  .addPreferredGap(ComponentPlacement.RELATED, 4, 32767)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.FB).addComponent(this.FA))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.FC).addComponent(this.Fx))
                  .addGap(28, 28, 28)
                  .addComponent(this.Fu)
                  .addGap(15, 15, 15)
            )
      );
   }
}
