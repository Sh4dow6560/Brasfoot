package bf22.intermediary;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class C0760 extends JPanel {
   private static BufferedImage DH = null;

   @Override
   protected void paintComponent(Graphics graphics) {
      try {
         DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f02.jpg"));
      } catch (IOException var3) {
      }

      Dimension var2 = this.getSize();
      super.paintComponent(graphics);
      graphics.drawImage(DH, 0, 0, var2.width, var2.height, null);
   }
}
