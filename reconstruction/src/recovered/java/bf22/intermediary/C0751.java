package bf22.intermediary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class C0751 extends JPanel {
   private static BufferedImage DH = null;
   private static int Qf = 0;
   private static String Qg = null;

   public C0751(String string, int i) {
      Qf = i;
      Qg = string;
   }

   @Override
   protected void paintComponent(Graphics graphics) {
      if (Qf == 0) {
         try {
            DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f01.jpg"));
         } catch (IOException var10) {
         }

         Dimension var2 = this.getSize();
         super.paintComponent(graphics);
         graphics.drawImage(DH, 0, 0, var2.width, var2.height, null);
      } else if (Qf == 8) {
         try {
            DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f02.jpg"));
         } catch (IOException var9) {
         }

         Dimension var11 = this.getSize();
         super.paintComponent(graphics);
         graphics.drawImage(DH, 0, 0, var11.width, var11.height, null);
      } else if (Qf == 1) {
         super.paintComponent(graphics);
         Graphics2D var12 = (Graphics2D)graphics;
         var12.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         int var3 = this.getWidth();
         int var4 = this.getHeight();
         Color var5 = Color.RED;
         Color var6 = Color.GREEN;
         GradientPaint var7 = new GradientPaint(0.0F, 0.0F, var5, 0.0F, var4, var6);
         var12.setPaint(var7);
         var12.fillRect(0, 0, var3, var4);
      } else if (Qf == 3) {
         try {
            DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f03.png"));
         } catch (IOException var8) {
         }

         Dimension var13 = this.getSize();
         super.paintComponent(graphics);
         graphics.drawImage(DH, 0, 0, var13.width, var13.height, null);
      }
   }
}
