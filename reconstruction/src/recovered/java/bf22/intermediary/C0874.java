package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0874 implements ActionListener {
   final bf22.intermediary.C0871 VN;
   C0874(C0871 c0871) {
      this.VN = c0871;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (!C0871.a(this.VN).getText().isEmpty()) {
         ((C0887)C0871.b(this.VN).getModel()).aj(C0670.f(C0871.a(this.VN).getText()));
      }
   }
}
