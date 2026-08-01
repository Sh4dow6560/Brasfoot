package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0500 implements ActionListener {
   final bf22.intermediary.C0498 MI;
   C0500(C0498 c0498) {
      this.MI = c0498;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0498.b(this.MI).getItemCount() > 0) {
         C0498.c(this.MI);
      }
   }
}
