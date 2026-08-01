package bf22.intermediary;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class C0782 implements ChangeListener {
   final bf22.intermediary.C0766 Rd;
   public C0782(C0766 c0766) {
      this.Rd = c0766;
   }

   @Override
   public void stateChanged(ChangeEvent changeEvent) {
      if (!C0766.a(this.Rd) && !C0766.b(this.Rd)) {
         this.Rd.calculateThumbLocation();
         C0766.c(this.Rd).repaint();
      }
   }
}
