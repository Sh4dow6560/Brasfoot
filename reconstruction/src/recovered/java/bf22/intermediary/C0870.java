package bf22.intermediary;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JColorChooser;

class C0870 extends MouseAdapter {
   final bf22.intermediary.C0865 VG;
   C0870(C0865 c0865) {
      this.VG = c0865;
   }

   @Override
   public void mouseClicked(MouseEvent mouseEvent) {
      Color var2 = C0865.g(this.VG).getBackground();
      var2 = JColorChooser.showDialog(C0865.g(this.VG), "", C0865.g(this.VG).getBackground());
      if (var2 != null) {
         C0865.g(this.VG).setBackground(var2);
      }
   }
}
