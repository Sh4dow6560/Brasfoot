package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0009 implements ActionListener {
   final bf22.intermediary.C0008 vJ;
   C0009(C0008 c0008) {
      this.vJ = c0008;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0008.a(this.vJ).getItemCount() > 0) {
         C0008.b(this.vJ);
      }
   }
}
