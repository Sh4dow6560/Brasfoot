package bf22.intermediary;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class C0383 extends JPanel {
   private int JX = 1;
   int As;
   int At;
   int Au;
   int Av;
   private JButton vb;
   private JButton vc;
   private JPanel xb;
   private JPanel JY;

   public C0383() {
      this.mJ();
      this.vb.addActionListener(new C0384(this));
      this.vc.addActionListener(new C0385(this));
      this.JY.setVisible(false);
      this.mH();
   }

   @Override
   protected void paintComponent(Graphics graphics) {
      ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aicons/campo.png"));
      Image var3 = var2.getImage();
      super.paintComponent(graphics);
      graphics.drawImage(var3, 0, 0, null);
   }

   public void af(boolean bl) {
      this.JY.setVisible(bl);
   }

   public void mH() {
      this.xb.addMouseListener(new C0386(this));
      this.xb.addMouseMotionListener(new C0387(this));
   }

   private void e(MouseEvent mouseEvent) {
      this.As = mouseEvent.getX();
      this.At = mouseEvent.getY();
      this.Au = this.As;
      this.Av = this.At;
      this.JY.setVisible(true);
   }

   private void f(MouseEvent mouseEvent) {
      this.Au = mouseEvent.getX();
      this.Av = mouseEvent.getY();
   }

   private void g(MouseEvent mouseEvent) {
      this.As = mouseEvent.getX();
      this.At = mouseEvent.getY();
      this.JY.setVisible(false);
      this.rM();
   }

   public void rM() {
      this.xb.setVisible(false);
      this.xb = new C0753(3);
      this.xb.setVisible(true);
   }

   private void mJ() {
      this.xb = new C0753(2);
      this.JY = new C0750();
      this.vc = new JButton();
      this.vb = new JButton();
      this.JY.setOpaque(false);
      this.xb.setOpaque(false);
      GroupLayout var1 = new GroupLayout(this.JY);
      this.JY.setLayout(var1);
      var1.setHorizontalGroup(var1.createParallelGroup(Alignment.LEADING).addGap(0, 512, 32767));
      var1.setVerticalGroup(var1.createParallelGroup(Alignment.LEADING).addGap(0, 662, 32767));
      this.xb.setBackground(new Color(0, 153, 153));
      GroupLayout var2 = new GroupLayout(this.xb);
      this.xb.setLayout(var2);
      var2.setHorizontalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 512, 32767));
      var2.setVerticalGroup(var2.createParallelGroup(Alignment.LEADING).addGap(0, 662, 32767));
      this.vc.setText("jButton2");
      this.vb.setText("jButton1");
      GroupLayout var3 = new GroupLayout(this);
      this.setLayout(var3);
      var3.setHorizontalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addComponent(this.xb, -1, -1, 32767)
            .addGroup(
               var3.createParallelGroup(Alignment.LEADING)
                  .addGroup(
                     var3.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(this.vb)
                        .addGap(72, 72, 72)
                        .addComponent(this.vc)
                        .addContainerGap(147, 32767)
                  )
            )
            .addGroup(var3.createParallelGroup(Alignment.LEADING).addComponent(this.JY, -1, -1, 32767))
      );
      var3.setVerticalGroup(
         var3.createParallelGroup(Alignment.LEADING)
            .addComponent(this.xb, -1, -1, 32767)
            .addGroup(
               var3.createParallelGroup(Alignment.LEADING)
                  .addGroup(
                     var3.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addGroup(var3.createParallelGroup(Alignment.BASELINE).addComponent(this.vc).addComponent(this.vb))
                        .addContainerGap(320, 32767)
                  )
            )
            .addGroup(var3.createParallelGroup(Alignment.LEADING).addComponent(this.JY, Alignment.TRAILING, -1, -1, 32767))
      );
   }
}
