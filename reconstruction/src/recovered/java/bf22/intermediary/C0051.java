package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class C0051 extends JPanel {
   private JDialog ub;
   private JButton zm;
   private JButton zn;
   private JLabel zo;
   private JLabel zp;
   private JLabel zq;
   private JLabel zr;
   private JLabel zs;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JLabel ur;
   private JLabel us;

   public C0051(JDialog jDialog) {
      this.ub = jDialog;
      this.mJ();
      Color[] var2 = GamePersistence.SR.getCoresLista();
      JLabel[] var3 = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};

      for (int var4 = 0; var4 < var3.length; var4++) {
         var3[var4].setBackground(var2[var4]);
      }

      this.mH();
   }

   public void mH() {
      JLabel[] var1 = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};
      this.zn.addActionListener(new C0052(this));
      this.zm.addActionListener(new C0053(this));

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2].setName("corl" + Integer.toString(var2));
         var1[var2].addMouseListener(new C0107(this));
      }
   }

   private void nG() {
      JLabel[] var1 = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};

      for (int var2 = 0; var2 < var1.length; var2++) {
         Color var3 = new Color(GameConstants.oZ[var2][0], GameConstants.oZ[var2][1], GameConstants.oZ[var2][2]);
         var1[var2].setBackground(var3);
      }
   }

   private void nH() {
      JLabel[] var1 = new JLabel[]{this.zo, this.zp, this.zq, this.zr, this.zs};
      Color[] var2 = new Color[5];

      for (int var3 = 0; var3 < var1.length; var3++) {
         var2[var3] = var1[var3].getBackground();
      }

      GamePersistence.SR.setCoresLista(var2);
      GamePersistence.vM().setCoresLista(var2);
      GamePersistence.vJ();
   }

   private void a(Object object) {
      JLabel var2 = (JLabel)object;
      Color var3 = var2.getBackground();
      var2.setBackground(JColorChooser.showDialog(var2, "", var3));
   }

   private void mJ() {
      this.zm = new JButton();
      this.zn = new JButton();
      this.ug = new JLabel();
      this.zo = new JLabel();
      this.zp = new JLabel();
      this.uh = new JLabel();
      this.a_ = new JLabel();
      this.zq = new JLabel();
      this.zr = new JLabel();
      this.ur = new JLabel();
      this.zs = new JLabel();
      this.us = new JLabel();
      this.setBackground(new Color(204, 204, 204));
      this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
      this.zm.setText("setar padrão");
      this.zn.setText("ok");
      this.ug.setText("Goleiros:");
      this.zo.setBackground(new Color(255, 0, 102));
      this.zo.setMinimumSize(new Dimension(20, 20));
      this.zo.setOpaque(true);
      this.zo.setPreferredSize(new Dimension(20, 20));
      this.zp.setBackground(new Color(255, 0, 102));
      this.zp.setMinimumSize(new Dimension(20, 20));
      this.zp.setOpaque(true);
      this.zp.setPreferredSize(new Dimension(20, 20));
      this.uh.setText("Laterais:");
      this.a_.setText("Zagueiros:");
      this.zq.setBackground(new Color(255, 0, 102));
      this.zq.setMinimumSize(new Dimension(20, 20));
      this.zq.setOpaque(true);
      this.zq.setPreferredSize(new Dimension(20, 20));
      this.zr.setBackground(new Color(255, 0, 102));
      this.zr.setMinimumSize(new Dimension(20, 20));
      this.zr.setOpaque(true);
      this.zr.setPreferredSize(new Dimension(20, 20));
      this.ur.setText("Meias:");
      this.zs.setBackground(new Color(255, 0, 102));
      this.zs.setMinimumSize(new Dimension(20, 20));
      this.zs.setOpaque(true);
      this.zs.setPreferredSize(new Dimension(20, 20));
      this.us.setText("Atacantes:");
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(67, 67, 67)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.ug, Alignment.TRAILING)
                                    .addComponent(this.uh, Alignment.TRAILING)
                                    .addComponent(this.a_, Alignment.TRAILING)
                                    .addComponent(this.ur, Alignment.TRAILING)
                                    .addComponent(this.us, Alignment.TRAILING)
                              )
                              .addGap(8, 8, 8)
                              .addGroup(
                                 var1.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.zr, -2, 30, -2)
                                    .addGroup(
                                       var1.createParallelGroup(Alignment.LEADING)
                                          .addComponent(this.zq, Alignment.TRAILING, -2, 30, -2)
                                          .addComponent(this.zp, Alignment.TRAILING, -2, 30, -2)
                                    )
                                    .addComponent(this.zs, Alignment.TRAILING, -2, 30, -2)
                                    .addComponent(this.zo, Alignment.TRAILING, -2, 30, -2)
                              )
                        )
                        .addGroup(
                           var1.createSequentialGroup()
                              .addGap(68, 68, 68)
                              .addGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.zn, -2, 108, -2).addComponent(this.zm, -2, 109, -2))
                        )
                  )
                  .addContainerGap(50, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGap(22, 22, 22)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(8, 8, 8).addComponent(this.ug))
                        .addComponent(this.zo, -2, 30, -2)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(10, 10, 10).addComponent(this.uh))
                        .addComponent(this.zp, -2, 30, -2)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(10, 10, 10).addComponent(this.a_))
                        .addComponent(this.zq, -2, 30, -2)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(10, 10, 10).addComponent(this.ur))
                        .addComponent(this.zr, -2, 30, -2)
                  )
                  .addGap(18, 18, 18)
                  .addGroup(
                     var1.createParallelGroup(Alignment.LEADING)
                        .addGroup(var1.createSequentialGroup().addGap(10, 10, 10).addComponent(this.us))
                        .addComponent(this.zs, -2, 30, -2)
                  )
                  .addGap(40, 40, 40)
                  .addComponent(this.zm)
                  .addGap(18, 18, 18)
                  .addComponent(this.zn)
                  .addContainerGap()
            )
      );
   }
}
