package bf22.intermediary;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class C0750 extends JPanel {
   @Override
   protected void paintComponent(Graphics graphics) {
      ImageIcon var2 = new ImageIcon(this.getClass().getResource("/aicons/alpha.png"));
      Image var3 = var2.getImage();
      super.paintComponent(graphics);
      graphics.drawImage(var3, 0, 0, null);
   }
}
