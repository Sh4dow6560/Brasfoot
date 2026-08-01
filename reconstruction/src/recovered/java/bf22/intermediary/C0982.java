package bf22.intermediary;

import mod.recovered.ui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class C0982 implements ActionListener {
   final bf22.intermediary.C0971 Xb;
   C0982(C0971 c0971) {
      this.Xb = c0971;
   }

   @Override
   public void actionPerformed(ActionEvent actionEvent) {
      new MainWindow(false);
      MainWindow.aY(7);
   }
}
