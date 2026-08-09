package bf22.intermediary;

import bf22.intermediary.CareerInitializer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class C0127 extends JPanel {
   int As;
   int At;
   int Au;
   int Av;
   private JButton vb;
   private JButton vc;
   private JPanel Aw;

   public C0127() {
      this.mJ();
      this.vb.addActionListener(new C0128(this));
      this.vc.addActionListener(new C0129(this));
   }

   public void nY() {
      this.Aw.addMouseListener(new C0130(this));
      this.Aw.addMouseMotionListener(new C0131(this));
   }

   private void a(MouseEvent mouseEvent) {
      this.As = mouseEvent.getX();
      this.At = mouseEvent.getY();
      this.Au = this.As;
      this.Av = this.At;
   }

   public static void nZ() {
      if (C0644.vF().equals(C0698.jG())) {
         C0670.m(C0698.getNome());
         C0670.eS();
         C0670.eT();
         new C0054();
         CareerInitializer.dv();
         if (CareerInitializer.du() < 8) {
            CareerInitializer.n(true);
         }
      }
   }

   private void b(MouseEvent mouseEvent) {
      this.Au = mouseEvent.getX();
      this.Av = mouseEvent.getY();
   }

   private void c(MouseEvent mouseEvent) {
      this.As = mouseEvent.getX();
      this.At = mouseEvent.getY();
   }

   private void mJ() {
      this.Aw = new C0773();
      this.vb = new JButton();
      this.vc = new JButton();
      this.setBackground(new Color(51, 102, 0));
      this.vb.setText("jButton1");
      this.vc.setText("jButton2");
      this.Aw.setPreferredSize(new Dimension(512, 662));
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addComponent(this.Aw, -2, -1, -2)
                  .addGap(74, 74, 74)
                  .addComponent(this.vb)
                  .addGap(83, 83, 83)
                  .addComponent(this.vc)
                  .addGap(0, 85, 32767)
            )
      );
      var1.setVerticalGroup(
         var1.createParallelGroup(Alignment.LEADING)
            .addGroup(
               var1.createSequentialGroup()
                  .addGroup(
                     var1.createParallelGroup(Alignment.TRAILING)
                        .addGroup(var1.createParallelGroup(Alignment.BASELINE).addComponent(this.vb).addComponent(this.vc))
                        .addComponent(this.Aw, -2, -1, -2)
                  )
                  .addGap(0, 38, 32767)
            )
      );
   }
}
