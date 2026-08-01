package bf22.intermediary;

import java.awt.event.MouseEvent;
import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

public class C0783 extends TrackListener {
   final bf22.intermediary.C0766 Rd;
   public C0783(C0766 c0766) {
      c0766.super();
      this.Rd = c0766;
   }

   @Override
   public void mousePressed(MouseEvent mouseEvent) {
      if (C0766.c(this.Rd).isEnabled()) {
         this.currentMouseX = mouseEvent.getX();
         this.currentMouseY = mouseEvent.getY();
         if (C0766.c(this.Rd).isRequestFocusEnabled()) {
            C0766.c(this.Rd).requestFocus();
         }

         boolean var2 = false;
         boolean var3 = false;
         if (!C0766.d(this.Rd) && C0766.c(this.Rd).getMinimum() != C0766.c(this.Rd).getValue()) {
            if (C0766.f(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
               var2 = true;
            } else if (C0766.e(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
               var3 = true;
            }
         } else if (C0766.e(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
            var3 = true;
         } else if (C0766.f(this.Rd).contains(this.currentMouseX, this.currentMouseY)) {
            var2 = true;
         }

         if (var2) {
            switch (C0766.c(this.Rd).getOrientation()) {
               case 0:
                  this.offset = this.currentMouseX - C0766.f(this.Rd).x;
                  break;
               case 1:
                  this.offset = this.currentMouseY - C0766.f(this.Rd).y;
            }

            C0766.a(this.Rd, false);
            C0766.b(this.Rd, true);
         } else {
            C0766.b(this.Rd, false);
            if (var3) {
               switch (C0766.c(this.Rd).getOrientation()) {
                  case 0:
                     this.offset = this.currentMouseX - C0766.e(this.Rd).x;
                     break;
                  case 1:
                     this.offset = this.currentMouseY - C0766.e(this.Rd).y;
               }

               C0766.a(this.Rd, true);
               C0766.c(this.Rd, true);
            } else {
               C0766.c(this.Rd, false);
            }
         }
      }
   }

   @Override
   public void mouseReleased(MouseEvent mouseEvent) {
      C0766.b(this.Rd, false);
      C0766.c(this.Rd, false);
      C0766.c(this.Rd).setValueIsAdjusting(false);
      super.mouseReleased(mouseEvent);
   }

   @Override
   public void mouseDragged(MouseEvent mouseEvent) {
      if (C0766.c(this.Rd).isEnabled()) {
         this.currentMouseX = mouseEvent.getX();
         this.currentMouseY = mouseEvent.getY();
         if (C0766.a(this.Rd)) {
            C0766.c(this.Rd).setValueIsAdjusting(true);
            this.uw();
         } else if (C0766.b(this.Rd)) {
            C0766.c(this.Rd).setValueIsAdjusting(true);
            this.ux();
         }
      }
   }

   @Override
   public boolean shouldScroll(int i) {
      return false;
   }

   private void uw() {
      int var1 = 0;
      switch (C0766.c(this.Rd).getOrientation()) {
         case 0:
            int var7 = C0766.f(this.Rd).width / 2;
            int var8 = this.currentMouseX - this.offset;
            int var9 = C0766.g(this.Rd).x;
            int var10 = C0766.g(this.Rd).x + (C0766.g(this.Rd).width - 1);
            int var11 = C0766.b(this.Rd, C0766.c(this.Rd).getValue() + C0766.c(this.Rd).getExtent());
            if (C0766.h(this.Rd)) {
               var9 = var11;
            } else {
               var10 = var11;
            }

            var8 = Math.max(var8, var9 - var7);
            var8 = Math.min(var8, var10 - var7);
            this.Rd.setThumbLocation(var8, C0766.f(this.Rd).y);
            var1 = var8 + var7;
            C0766.c(this.Rd).setValue(this.Rd.valueForXPosition(var1));
            break;
         case 1:
            int var2 = C0766.f(this.Rd).height / 2;
            int var3 = this.currentMouseY - this.offset;
            int var4 = C0766.g(this.Rd).y;
            int var5 = C0766.g(this.Rd).y + (C0766.g(this.Rd).height - 1);
            int var6 = C0766.a(this.Rd, C0766.c(this.Rd).getValue() + C0766.c(this.Rd).getExtent());
            if (C0766.h(this.Rd)) {
               var5 = var6;
            } else {
               var4 = var6;
            }

            var3 = Math.max(var3, var4 - var2);
            var3 = Math.min(var3, var5 - var2);
            this.Rd.setThumbLocation(C0766.f(this.Rd).x, var3);
            var1 = var3 + var2;
            C0766.c(this.Rd).setValue(this.Rd.valueForYPosition(var1));
            break;
         default:
            return;
      }
   }

   private void ux() {
      int var1 = 0;
      switch (C0766.c(this.Rd).getOrientation()) {
         case 0:
            int var7 = C0766.f(this.Rd).width / 2;
            int var8 = this.currentMouseX - this.offset;
            int var9 = C0766.g(this.Rd).x;
            int var10 = C0766.g(this.Rd).x + (C0766.g(this.Rd).width - 1);
            int var11 = C0766.b(this.Rd, C0766.c(this.Rd).getValue());
            if (C0766.h(this.Rd)) {
               var10 = var11;
            } else {
               var9 = var11;
            }

            var8 = Math.max(var8, var9 - var7);
            var8 = Math.min(var8, var10 - var7);
            C0766.a(this.Rd, var8, C0766.f(this.Rd).y);
            var1 = var8 + var7;
            C0766.c(this.Rd).setExtent(this.Rd.valueForXPosition(var1) - C0766.c(this.Rd).getValue());
            break;
         case 1:
            int var2 = C0766.f(this.Rd).height / 2;
            int var3 = this.currentMouseY - this.offset;
            int var4 = C0766.g(this.Rd).y;
            int var5 = C0766.g(this.Rd).y + (C0766.g(this.Rd).height - 1);
            int var6 = C0766.a(this.Rd, C0766.c(this.Rd).getValue());
            if (C0766.h(this.Rd)) {
               var4 = var6;
            } else {
               var5 = var6;
            }

            var3 = Math.max(var3, var4 - var2);
            var3 = Math.min(var3, var5 - var2);
            C0766.a(this.Rd, C0766.f(this.Rd).x, var3);
            var1 = var3 + var2;
            C0766.c(this.Rd).setExtent(this.Rd.valueForYPosition(var1) - C0766.c(this.Rd).getValue());
            break;
         default:
            return;
      }
   }
}
