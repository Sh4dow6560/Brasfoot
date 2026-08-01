package bf22.intermediary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class C0866 implements ActionListener {
   final bf22.intermediary.C0865 VG;
   C0866(C0865 c0865) {
      this.VG = c0865;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      C0865.a(this.VG).clear();
      if (!C0865.b(this.VG)) {
         this.VG.xc();
      } else {
         this.VG.xd();
      }

      if (C0865.a(this.VG).size() == 0) {
         C0732.da().wo();
         C0732.da().Uw.dispose();
      } else {
         JOptionPane.showMessageDialog(null, C0865.a(this.VG).get(0), "", 0);
      }
   }
}
