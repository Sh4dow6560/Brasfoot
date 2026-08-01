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

public class C0752 extends JPanel {
   private static BufferedImage DH = null;
   private static int Qf = 0;
   private static String Qg = null;
   private static Color Qh = null;
   private static Color Qi = null;

   public C0752(String string, int i, Color color, Color color2) {
      Qf = i;
      Qg = string;
      Qh = color;
      Qi = color2;
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
      } else if (Qf == 1) {
         super.paintComponent(graphics);
         Graphics2D var11 = (Graphics2D)graphics;
         var11.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         int var3 = this.getWidth();
         int var4 = this.getHeight();
         Color var5 = Color.RED;
         Color var6 = Color.GREEN;
         GradientPaint var7 = new GradientPaint(0.0F, 0.0F, var5, 0.0F, var4, var6);
         var11.setPaint(var7);
         var11.fillRect(0, 0, var3, var4);
      } else if (Qf == 2) {
         try {
            DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f03.png"));
         } catch (IOException var9) {
         }

         Dimension var12 = this.getSize();
         super.paintComponent(graphics);
         graphics.drawImage(DH, 0, 0, var12.width, var12.height, null);
         byte var14 = 2;
         if (Qh.getRGB() == Color.WHITE.getRGB()) {
            Qh = Color.DARK_GRAY;
            var14 = 2;
         }

         graphics.setColor(Qh);
         graphics.drawRect(0, 0, var12.width, var14);
         graphics.fillRect(0, 0, var12.width, var14);
      } else if (Qf == 4) {
         try {
            DH = ImageIO.read(new File(System.getProperty("user.dir") + "/img/f04.png"));
         } catch (IOException var8) {
         }

         Dimension var13 = this.getSize();
         super.paintComponent(graphics);
         graphics.drawImage(DH, 0, 0, var13.width, var13.height, null);
         byte var15 = 2;
         if (Qh.getRGB() == Color.WHITE.getRGB()) {
            Qh = Color.DARK_GRAY;
            var15 = 2;
         }

         graphics.setColor(Qh);
      }
   }
}
