package bf22.intermediary;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

public class C0775 implements Serializable {
   static final long serialVersionUID = 5261460716622152494L;
   public int x;
   public int y;
   public int width = -1;
   public int height = -1;

   public C0775(Point point) {
      this(point.x, point.y);
   }

   public C0775(int i, int j) {
      this.x = i;
      this.y = j;
   }

   public C0775(Point point, Dimension dimension) {
      this.x = point.x;
      this.y = point.y;
      if (dimension != null) {
         this.width = dimension.width;
         this.height = dimension.height;
      }
   }

   public C0775(int i, int j, int k, int l) {
      this.x = i;
      this.y = j;
      this.width = k;
      this.height = l;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }

   @Override
   public String toString() {
      return super.toString() + " [x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]";
   }
}
