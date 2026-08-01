package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0975 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   C0975(C0971 c0971) {
      this.Xb = c0971;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      int var2 = 0;
      int var3 = 1;
      C0971.a(this.Xb);
      C0745.SR.aO(true);

      for (; C0745.SR.H() < 1 || !((C0693)C0745.SR.R().get(342)).e() && !C0745.SR.bN; C0745.SR.V()) {
         var2 = C0745.SR.H();
         if (var3 != var2) {
            var3 = var2;
            System.out.println("ano: " + Integer.toString(var2));
         }
      }

      System.out.println("done");
   }
}
