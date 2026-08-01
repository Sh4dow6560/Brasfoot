package bf22.intermediary;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class C0773 extends JPanel {
   int As;
   int At;
   int Au;
   int Av;
   private JLabel ug;
   private JLabel uh;
   private JLabel a_;
   private JLayeredPane MH;

   public C0773() {
      this.mJ();
   }

   public void X(boolean bl) {
      this.uh.setVisible(bl);
   }

   private void mJ() {
      this.MH = new JLayeredPane();
      this.a_ = new JLabel();
      this.uh = new JLabel();
      this.ug = new JLabel();
      this.setPreferredSize(new Dimension(512, 662));
      this.MH.addMouseListener(new C0774(this));
      this.MH.setLayout(new C0807());
      this.a_.setIcon(new ImageIcon(this.getClass().getResource("/aicons/alpha2.png")));
      this.a_.setToolTipText("");
      this.MH.add(this.a_, new C0775(0, 0, 510, 660));
      this.MH.setLayer(this.a_, JLayeredPane.DRAG_LAYER);
      this.uh.setIcon(new ImageIcon(this.getClass().getResource("/aicons/alpha.png")));
      this.MH.add(this.uh, new C0775(0, 0, 510, 660));
      this.MH.setLayer(this.uh, JLayeredPane.POPUP_LAYER);
      this.ug.setIcon(new ImageIcon(this.getClass().getResource("/aicons/campo.png")));
      this.MH.add(this.ug, new C0775(0, 0, -1, -1));
      GroupLayout var1 = new GroupLayout(this);
      this.setLayout(var1);
      var1.setHorizontalGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.MH));
      var1.setVerticalGroup(var1.createParallelGroup(Alignment.LEADING).addComponent(this.MH));
   }

   private void h(MouseEvent mouseEvent) {
   }
}
