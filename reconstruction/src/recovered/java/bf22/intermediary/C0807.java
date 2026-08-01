package bf22.intermediary;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class C0807 implements LayoutManager2, Serializable {
   static final long serialVersionUID = -1919857869177070440L;
   protected Hashtable NA = new Hashtable();

   @Override
   public void addLayoutComponent(String string, Component component) {
      throw new IllegalArgumentException();
   }

   @Override
   public void removeLayoutComponent(Component component) {
      this.NA.remove(component);
   }

   @Override
   public Dimension preferredLayoutSize(Container container) {
      int var2 = 0;
      int var3 = 0;
      Enumeration var4 = this.NA.keys();

      while (var4.hasMoreElements()) {
         Component var5 = (Component)var4.nextElement();
         C0775 var6 = (C0775)this.NA.get(var5);
         Dimension var7 = var5.getPreferredSize();
         int var8 = var6.getWidth();
         if (var8 == -1) {
            var8 = var7.width;
         }

         int var9 = var6.getHeight();
         if (var9 == -1) {
            var9 = var7.height;
         }

         if (var6.x + var8 > var2) {
            var2 = var6.x + var8;
         }

         if (var6.y + var9 > var3) {
            var3 = var6.y + var9;
         }
      }

      return new Dimension(var2, var3);
   }

   @Override
   public Dimension minimumLayoutSize(Container container) {
      int var2 = 0;
      int var3 = 0;
      Enumeration var4 = this.NA.keys();

      while (var4.hasMoreElements()) {
         Component var5 = (Component)var4.nextElement();
         C0775 var6 = (C0775)this.NA.get(var5);
         Dimension var7 = var5.getMinimumSize();
         int var8 = var6.getWidth();
         if (var8 == -1) {
            var8 = var7.width;
         }

         int var9 = var6.getHeight();
         if (var9 == -1) {
            var9 = var7.height;
         }

         if (var6.x + var8 > var2) {
            var2 = var6.x + var8;
         }

         if (var6.y + var9 > var3) {
            var3 = var6.y + var9;
         }
      }

      return new Dimension(var2, var3);
   }

   @Override
   public void layoutContainer(Container container) {
      Enumeration var2 = this.NA.keys();

      while (var2.hasMoreElements()) {
         Component var3 = (Component)var2.nextElement();
         C0775 var4 = (C0775)this.NA.get(var3);
         Dimension var5 = var3.getPreferredSize();
         int var6 = var4.getWidth();
         if (var6 == -1) {
            var6 = var5.width;
         }

         int var7 = var4.getHeight();
         if (var7 == -1) {
            var7 = var5.height;
         }

         var3.setBounds(var4.x, var4.y, var6, var7);
      }
   }

   @Override
   public void addLayoutComponent(Component component, Object object) {
      if (!(object instanceof C0775)) {
         throw new IllegalArgumentException();
      }

      this.NA.put(component, object);
   }

   @Override
   public Dimension maximumLayoutSize(Container container) {
      return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
   }

   @Override
   public float getLayoutAlignmentX(Container container) {
      return 0.0F;
   }

   @Override
   public float getLayoutAlignmentY(Container container) {
      return 0.0F;
   }

   @Override
   public void invalidateLayout(Container container) {
   }
}
