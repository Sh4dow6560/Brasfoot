package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0868 implements ActionListener {
   final bf22.intermediary.C0865 VG;
   C0868(C0865 c0865) {
      this.VG = c0865;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      if (C0732.H(C0865.c(this.VG).getSelectedIndex()) == 29) {
         C0865.d(this.VG).setVisible(true);
         C0865.e(this.VG).setVisible(true);
      } else {
         C0865.d(this.VG).setVisible(false);
         C0865.e(this.VG).setVisible(false);
      }
   }
}
