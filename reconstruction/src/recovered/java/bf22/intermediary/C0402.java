package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0402 implements ActionListener {
   final bf22.intermediary.C0401 LD;
   C0402(C0401 c0401) {
      this.LD = c0401;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0401.a(this.LD).getItemCount() > 0) {
         C0401.b(this.LD);
      }
   }
}
