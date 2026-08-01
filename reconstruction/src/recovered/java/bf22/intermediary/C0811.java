package bf22.intermediary;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

public class C0811 implements Icon {
   public static final float NU = 0.0F;
   public static final float NV = 0.0F;
   public static final float NW = 0.5F;
   public static final float NX = 1.0F;
   public static final float NY = 1.0F;
   private Icon[] NZ;
   private C0812 Oa;
   private int Ob;
   private float Oc = 0.5F;
   private float Od = 0.5F;

   public C0811(Icon... icons) {
      this(C0812.Oe, icons);
   }

   public C0811(C0812 c0812, Icon... icons) {
      this(c0812, 0, icons);
   }

   public C0811(C0812 c0812, int i, Icon... icons) {
      this(c0812, i, 0.5F, 0.5F, icons);
   }

   public C0811(C0812 c0812, int i, float f, float g, Icon... icons) {
      this.Oa = c0812;
      this.Ob = i;
      this.Oc = f > 1.0F ? 1.0F : (f < 0.0F ? 0.0F : f);
      this.Od = g > 1.0F ? 1.0F : (g < 0.0F ? 0.0F : g);

      for (int var6 = 0; var6 < icons.length; var6++) {
         if (icons[var6] == null) {
            String var7 = "Icon (" + var6 + ") cannot be null";
            throw new IllegalArgumentException(var7);
         }
      }

      this.NZ = icons;
   }

   public C0812 th() {
      return this.Oa;
   }

   public int getGap() {
      return this.Ob;
   }

   public float getAlignmentX() {
      return this.Oc;
   }

   public float getAlignmentY() {
      return this.Od;
   }

   public int ti() {
      return this.NZ.length;
   }

   public Icon dG(int i) {
      return this.NZ[i];
   }

   @Override
   public int getIconWidth() {
      int var1 = 0;
      if (this.Oa == C0812.Oe) {
         var1 += (this.NZ.length - 1) * this.Ob;
         Icon[] var5 = this.NZ;
         int var4 = this.NZ.length;

         for (int var3 = 0; var3 < var4; var3++) {
            Icon var2 = var5[var3];
            var1 += var2.getIconWidth();
         }
      } else {
         Icon[] var9 = this.NZ;
         int var8 = this.NZ.length;

         for (int var7 = 0; var7 < var8; var7++) {
            Icon var6 = var9[var7];
            var1 = Math.max(var1, var6.getIconWidth());
         }
      }

      return var1;
   }

   @Override
   public int getIconHeight() {
      int var1 = 0;
      if (this.Oa == C0812.Of) {
         var1 += (this.NZ.length - 1) * this.Ob;
         Icon[] var5 = this.NZ;
         int var4 = this.NZ.length;

         for (int var3 = 0; var3 < var4; var3++) {
            Icon var2 = var5[var3];
            var1 += var2.getIconHeight();
         }
      } else {
         Icon[] var9 = this.NZ;
         int var8 = this.NZ.length;

         for (int var7 = 0; var7 < var8; var7++) {
            Icon var6 = var9[var7];
            var1 = Math.max(var1, var6.getIconHeight());
         }
      }

      return var1;
   }

   @Override
   public void paintIcon(Component component, Graphics graphics, int i, int j) {
      if (this.Oa == C0812.Oe) {
         int var5 = this.getIconHeight();
         Icon[] var9 = this.NZ;
         int var8 = this.NZ.length;

         for (int var7 = 0; var7 < var8; var7++) {
            Icon var6 = var9[var7];
            int var10 = this.a(var5, var6.getIconHeight(), this.Od);
            var6.paintIcon(component, graphics, i, j + var10);
            i += var6.getIconWidth() + this.Ob;
         }
      } else if (this.Oa == C0812.Of) {
         int var13 = this.getIconWidth();
         Icon[] var21 = this.NZ;
         int var19 = this.NZ.length;

         for (int var17 = 0; var17 < var19; var17++) {
            Icon var15 = var21[var17];
            int var23 = this.a(var13, var15.getIconWidth(), this.Oc);
            var15.paintIcon(component, graphics, i + var23, j);
            j += var15.getIconHeight() + this.Ob;
         }
      } else {
         int var14 = this.getIconWidth();
         int var16 = this.getIconHeight();
         Icon[] var24 = this.NZ;
         int var22 = this.NZ.length;

         for (int var20 = 0; var20 < var22; var20++) {
            Icon var18 = var24[var20];
            int var11 = this.a(var14, var18.getIconWidth(), this.Oc);
            int var12 = this.a(var16, var18.getIconHeight(), this.Od);
            var18.paintIcon(component, graphics, i + var11, j + var12);
         }
      }
   }

   private int a(int i, int j, float f) {
      float var4 = (i - j) * f;
      return Math.round(var4);
   }
}
