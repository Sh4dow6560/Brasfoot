package bf22.intermediary;

import mod.recovered.core.GameConstants;
import mod.recovered.save.GamePersistence;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

class C0766 extends BasicSliderUI {
   private Color QY = GameConstants.E(GamePersistence.vM().getCorTema(), 3);
   private Rectangle QZ;
   private boolean Ra;
   private transient boolean Rb;
   private transient boolean Rc;

   public C0766(C0781 c0781) {
      super(c0781);
   }

   @Override
   public void installUI(JComponent jComponent) {
      this.QZ = new Rectangle();
      super.installUI(jComponent);
   }

   @Override
   protected TrackListener createTrackListener(JSlider jSlider) {
      return new C0783(this);
   }

   @Override
   protected ChangeListener createChangeListener(JSlider jSlider) {
      return new C0782(this);
   }

   @Override
   protected void calculateThumbSize() {
      super.calculateThumbSize();
      this.QZ.setSize(this.thumbRect.width, this.thumbRect.height);
   }

   @Override
   protected void calculateThumbLocation() {
      super.calculateThumbLocation();
      if (this.slider.getSnapToTicks()) {
         int var1 = this.slider.getValue() + this.slider.getExtent();
         int var2 = var1;
         int var3 = this.slider.getMajorTickSpacing();
         int var4 = this.slider.getMinorTickSpacing();
         int var5 = 0;
         if (var4 > 0) {
            var5 = var4;
         } else if (var3 > 0) {
            var5 = var3;
         }

         if (var5 != 0) {
            if ((var1 - this.slider.getMinimum()) % var5 != 0) {
               float var6 = (float)(var1 - this.slider.getMinimum()) / var5;
               int var7 = Math.round(var6);
               var2 = this.slider.getMinimum() + var7 * var5;
            }

            if (var2 != var1) {
               this.slider.setExtent(var2 - this.slider.getValue());
            }
         }
      }

      if (this.slider.getOrientation() == 0) {
         int var8 = this.xPositionForValue(this.slider.getValue() + this.slider.getExtent());
         this.QZ.x = var8 - this.QZ.width / 2;
         this.QZ.y = this.trackRect.y;
      } else {
         int var9 = this.yPositionForValue(this.slider.getValue() + this.slider.getExtent());
         this.QZ.x = this.trackRect.x;
         this.QZ.y = var9 - this.QZ.height / 2;
      }
   }

   @Override
   protected Dimension getThumbSize() {
      return new Dimension(18, 18);
   }

   @Override
   public void paint(Graphics graphics, JComponent jComponent) {
      super.paint(graphics, jComponent);
      Rectangle var3 = graphics.getClipBounds();
      if (this.Ra) {
         if (var3.intersects(this.thumbRect)) {
            this.a(graphics);
         }

         if (var3.intersects(this.QZ)) {
            this.b(graphics);
         }
      } else {
         if (var3.intersects(this.QZ)) {
            this.b(graphics);
         }

         if (var3.intersects(this.thumbRect)) {
            this.a(graphics);
         }
      }
   }

   @Override
   public void paintTrack(Graphics graphics) {
      super.paintTrack(graphics);
      Rectangle var2 = this.trackRect;
      if (this.slider.getOrientation() == 0) {
         int var3 = this.thumbRect.x + this.thumbRect.width / 2;
         int var4 = this.QZ.x + this.QZ.width / 2;
         int var5 = var2.height / 2 - 2;
         Color var6 = graphics.getColor();
         graphics.translate(var2.x, var2.y + var5);
         graphics.setColor(this.QY);

         for (int var7 = 0; var7 <= 3; var7++) {
            graphics.drawLine(var3 - var2.x, var7, var4 - var2.x, var7);
         }

         graphics.translate(-var2.x, -(var2.y + var5));
         graphics.setColor(var6);
      } else {
         int var8 = this.thumbRect.x + this.thumbRect.width / 2;
         int var9 = this.QZ.x + this.QZ.width / 2;
         int var10 = var2.width / 2 - 2;
         Color var11 = graphics.getColor();
         graphics.translate(var2.x + var10, var2.y);
         graphics.setColor(this.QY);

         for (int var12 = 0; var12 <= 3; var12++) {
            graphics.drawLine(var12, var8 - var2.y, var12, var9 - var2.y);
         }

         graphics.translate(-(var2.x + var10), -var2.y);
         graphics.setColor(var11);
      }
   }

   @Override
   public void paintThumb(Graphics graphics) {
   }

   private void a(Graphics graphics) {
      Rectangle var2 = this.thumbRect;
      int var3 = var2.width;
      int var4 = var2.height;
      Graphics2D var5 = (Graphics2D)graphics.create();
      Shape var6 = this.P(var3 - 1, var4 - 1);
      var5.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var5.translate(var2.x, var2.y);
      var5.setColor(GameConstants.E(GamePersistence.vM().getCorTema(), 3));
      var5.fill(var6);
      var5.setColor(GameConstants.E(GamePersistence.vM().getCorTema(), 3));
      var5.draw(var6);
      var5.dispose();
   }

   private void b(Graphics graphics) {
      Rectangle var2 = this.QZ;
      int var3 = var2.width;
      int var4 = var2.height;
      Graphics2D var5 = (Graphics2D)graphics.create();
      Shape var6 = this.P(var3 - 1, var4 - 1);
      var5.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var5.translate(var2.x, var2.y);
      var5.setColor(GameConstants.E(GamePersistence.vM().getCorTema(), 3));
      var5.fill(var6);
      var5.setColor(GameConstants.E(GamePersistence.vM().getCorTema(), 3));
      var5.draw(var6);
      var5.dispose();
   }

   private Shape P(int i, int j) {
      return new Double(0.0, 0.0, i, j);
   }

   private void Q(int i, int j) {
      Rectangle var3 = new Rectangle();
      var3.setBounds(this.QZ);
      this.QZ.setLocation(i, j);
      SwingUtilities.computeUnion(this.QZ.x, this.QZ.y, this.QZ.width, this.QZ.height, var3);
      this.slider.repaint(var3.x, var3.y, var3.width, var3.height);
   }

   @Override
   public void scrollByBlock(int i) {
      synchronized (this.slider) {
         int var3 = (this.slider.getMaximum() - this.slider.getMinimum()) / 10;
         if (var3 <= 0 && this.slider.getMaximum() > this.slider.getMinimum()) {
            var3 = 1;
         }

         int var4 = var3 * (i > 0 ? 1 : -1);
         if (this.Ra) {
            int var5 = ((C0781)this.slider).uv();
            ((C0781)this.slider).dP(var5 + var4);
         } else {
            int var7 = this.slider.getValue();
            this.slider.setValue(var7 + var4);
         }
      }
   }

   @Override
   public void scrollByUnit(int i) {
      synchronized (this.slider) {
         int var3 = 1 * (i > 0 ? 1 : -1);
         if (this.Ra) {
            int var4 = ((C0781)this.slider).uv();
            ((C0781)this.slider).dP(var4 + var3);
         } else {
            int var6 = this.slider.getValue();
            this.slider.setValue(var6 + var3);
         }
      }
   }
}
