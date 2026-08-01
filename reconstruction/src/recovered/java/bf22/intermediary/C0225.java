package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import mod.recovered.model.Club;
import mod.recovered.model.Coach;

public class C0225 extends JPanel {
   private JDialog ub;
   private Club uk = null;
   private Coach Fn = null;
   private Coach Fo = null;
   private int Fp = 0;
   private JButton zK;
   private JLabel ug;
   private JLabel a_;
   private JPanel vd;
   private JLabel Fq;
   private JLabel yA;
   private JLabel yB;
   private JLabel Fr;
   private JLabel Fs;

   public C0225(JDialog jDialog, Coach coach, Coach coach2, Club club, int i) {
      this.ub = jDialog;
      this.Fn = coach;
      this.Fo = coach2;
      this.uk = club;
      this.Fp = i;
      this.mJ();
      this.mH();
      this.mK();
      this.mG();
   }

   private void mG() {
      this.setBackground(GameConstants.E(GamePersistence.getOptions().getCorTema(), 1));
   }

   private void mK() {
      this.Fs.setText(this.Fn.dS());
      this.yA.setText("A razão foi: " + GameConstants.sg[this.Fp]);
      this.Fq.setIcon(this.uk.kP());
      String var1 = "um interino.";
      if (this.Fo != null) {
         var1 = this.Fo.dS();
      }

      this.yB.setText("Para o seu lugar foi contratado: " + var1);
   }

   public void mH() {
      this.zK.addActionListener(new C0226(this));
   }

   private void mJ() {
      this.vd = new JPanel();
      this.ug = new JLabel();
      this.Fs = new JLabel();
      this.a_ = new JLabel();
      this.yA = new JLabel();
      this.yB = new JLabel();
      this.Fr = new JLabel();
      this.zK = new JButton();
      this.Fq = new JLabel();
      this.setBackground(new Color(104, 120, 100));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.vd.setBackground(new Color(44, 53, 49));
      this.ug.setFont(new Font("Tahoma", 1, 14));
      this.ug.setForeground(new Color(255, 255, 255));
      this.ug.setText("Demitido!");
      this.Fs.setFont(new Font("Tahoma", 0, 12));
      this.Fs.setForeground(new Color(255, 255, 255));
      this.Fs.setText("jLabel2");
      this.a_.setFont(new Font("Tahoma", 0, 12));
      this.a_.setForeground(new Color(255, 255, 255));
      this.a_.setText("Você foi demitido. ");
      this.yA.setFont(new Font("Tahoma", 0, 12));
      this.yA.setForeground(new Color(255, 255, 255));
      this.yA.setText("A razão foi:");
      this.yB.setFont(new Font("Tahoma", 0, 12));
      this.yB.setForeground(new Color(255, 255, 255));
      this.yB.setText("Para o seu lugar foi contratado:");
      this.Fr.setFont(new Font("Tahoma", 0, 12));
      this.Fr.setForeground(new Color(255, 255, 255));
      this.Fr.setText("Agora, espere por propostas de outros times.");
      this.zK.setText("Continuar>>");
      this.Fq.setIcon(new ImageIcon(this.getClass().getResource("/aicons/escudo.png")));
      GroupLayout var1 = new GroupLayout(this.vd);
      this.vd.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(19, 19, 19)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createParallelGroup(Alignment.TRAILING)
                              .addComponent(this.zK)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.Fr, -2, 407, -2)
                                    .addComponent(this.yB, -2, 407, -2)
                                    .addComponent(this.yA, -2, 407, -2)
                              )
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.Fs, -2, 234, -2)
                                    .addComponent(this.a_, -2, 173, -2)
                                    .addComponent(this.ug, -2, 159, -2)
                              )
                              .addPreferredGap(ComponentPlacement.RELATED, 115, 32767)
                              .addComponent(this.Fq, -2, 75, -2)
                        )
                  )
                  .addContainerGap()
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(this.ug)
                              .addPreferredGap(ComponentPlacement.RELATED)
                              .addComponent(this.Fs)
                              .addGap(18, 18, 18)
                              .addComponent(this.a_)
                        )
                        .addComponent(this.Fq, -2, 68, -2)
                  )
                  .addGap(18, 18, 18)
                  .addComponent(this.yA)
                  .addGap(18, 18, 18)
                  .addComponent(this.yB)
                  .addGap(18, 18, 18)
                  .addComponent(this.Fr)
                  .addGap(27, 27, 27)
                  .addComponent(this.zK)
                  .addContainerGap(27, 32767)
            )
      );
      GroupLayout var2 = new GroupLayout(this);
      this.setLayout(var2);
      var2.setHorizontalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -1, -1, 32767).addContainerGap())
      );
      var2.setVerticalGroup(
         var2.createParallelGroup(Alignment.LEADING)
            .addGroup(var2.createSequentialGroup().addContainerGap().addComponent(this.vd, -2, -1, -2).addContainerGap(-1, 32767))
      );
   }
}
